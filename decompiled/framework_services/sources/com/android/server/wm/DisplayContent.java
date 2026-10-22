package com.android.server.wm;

import android.R;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.ColorSpace;
import android.graphics.Insets;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.HardwareBuffer;
import android.hardware.display.DisplayManagerInternal;
import android.metrics.LogMaker;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.WorkSource;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.provider.Settings;
import android.util.ArraySet;
import android.util.DisplayMetrics;
import android.util.DisplayUtils;
import android.util.EventLog;
import android.util.IntArray;
import android.util.LostModeUtil;
import android.util.Pair;
import android.util.RotationUtils;
import android.util.Size;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.util.proto.ProtoOutputStream;
import android.view.ContentRecordingSession;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.DisplayInfo;
import android.view.DisplayShape;
import android.view.IDecorViewGestureListener;
import android.view.IDisplayWindowInsetsController;
import android.view.ISystemGestureExclusionListener;
import android.view.IWindow;
import android.view.InputChannel;
import android.view.InputDevice;
import android.view.InsetsSource;
import android.view.InsetsState;
import android.view.MagnificationSpec;
import android.view.PrivacyIndicatorBounds;
import android.view.RoundedCorners;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowManagerPolicyConstants;
import android.view.inputmethod.ImeTracker;
import android.window.DesktopExperienceFlags;
import android.window.IDisplayAreaOrganizer;
import android.window.ScreenCapture;
import android.window.SystemPerformanceHinter;
import android.window.TransitionRequestInfo;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.policy.TransitionAnimation;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ToBooleanFunction;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.ISmartScenes;
import com.android.server.SysOptBridge;
import com.android.server.UiModeManagerService;
import com.android.server.am.ProcessList;
import com.android.server.common.Constants;
import com.android.server.dispatcher.SystemWindowManagerEventDispatcher;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.usb.descriptors.UsbACInterface;
import com.android.server.wm.utils.DisplayInfoOverrides;
import com.android.server.wm.utils.RegionUtils;
import com.android.server.wm.utils.RotationCache;
import com.android.server.wm.utils.WmDisplayCutout;
import com.obric.server.display.ObricAutoActionDisplayStateReporter;
import com.obric.utils.ObricImplFactory;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
class DisplayContent extends RootDisplayArea implements WindowManagerPolicy.DisplayContentInfo {
    private static final InsetsState.OnTraverseCallbacks COPY_SOURCE_VISIBILITY = null;
    private static final long FIXED_ROTATION_HIDE_ANIMATION_DEBOUNCE_DELAY_MS = 250;
    static final int FORCE_SCALING_MODE_AUTO = 0;
    static final int FORCE_SCALING_MODE_DISABLED = 1;
    static final int IME_TARGET_CONTROL = 2;
    static final int IME_TARGET_LAYERING = 0;
    static final float INVALID_DPI = 0.0f;
    private static final String TAG = "WindowManager";
    boolean isDefaultDisplay;
    private SurfaceControl mA11yOverlayLayer;
    private Set<ActivityRecord> mActiveSizeCompatActivities;
    final ArrayList<RootWindowContainer.SleepToken> mAllSleepTokens;
    AppCompatCameraPolicy mAppCompatCameraPolicy;
    private final Consumer<WindowState> mApplyPostLayoutPolicy;
    private final Consumer<WindowState> mApplySurfaceChangesTransaction;
    private AsyncRotationController mAsyncRotationController;
    final ActivityTaskManagerService mAtmService;
    DisplayCutout mBaseDisplayCutout;
    int mBaseDisplayDensity;
    int mBaseDisplayHeight;
    float mBaseDisplayPhysicalXDpi;
    float mBaseDisplayPhysicalYDpi;
    int mBaseDisplayWidth;
    RoundedCorners mBaseRoundedCorners;
    final float mCloseToSquareMaxAspectRatio;
    private final DisplayMetrics mCompatDisplayMetrics;
    float mCompatibleScreenScale;
    private final Predicate<WindowState> mComputeImeTargetPredicate;
    private ContentRecorder mContentRecorder;
    WindowState mCurrentFocus;
    private int mCurrentOverrideConfigurationChanges;
    PrivacyIndicatorBounds mCurrentPrivacyIndicatorBounds;
    String mCurrentUniqueDisplayId;
    private final RemoteCallbackList<IDecorViewGestureListener> mDecorViewGestureListener;
    private int mDeferUpdateImeTargetCount;
    private boolean mDeferredRemoval;
    final Consumer<DeviceStateController.DeviceState> mDeviceStateConsumer;
    final DeviceStateController mDeviceStateController;
    final Display mDisplay;
    private IntArray mDisplayAccessUIDs;
    final DisplayAreaPolicy mDisplayAreaPolicy;
    private final RotationCache<DisplayCutout, WmDisplayCutout> mDisplayCutoutCache;
    DisplayFrames mDisplayFrames;
    final int mDisplayId;
    private final DisplayInfo mDisplayInfo;
    private final DisplayMetrics mDisplayMetrics;
    private final DisplayPolicy mDisplayPolicy;
    private boolean mDisplayReady;
    private final DisplayRotation mDisplayRotation;
    boolean mDisplayScalingDisabled;
    private final RotationCache<DisplayShape, DisplayShape> mDisplayShapeCache;
    final DeferredDisplayUpdater mDisplayUpdater;
    boolean mDontMoveToTop;
    DisplayWindowPolicyControllerHelper mDwpcHelper;
    private IExtDisplayContent mExt;
    private final ToBooleanFunction<WindowState> mFindFocusedWindow;
    private ActivityRecord mFixedRotationLaunchingApp;
    final FixedRotationTransitionListener mFixedRotationTransitionListener;
    ActivityRecord mFocusedApp;
    float mForcedDisplayDensityRatio;
    boolean mHasSetIgnoreOrientationRequest;
    private SystemPerformanceHinter.HighPerfSession mHighFrameRateSession;
    private PowerManager.WakeLock mHoldScreenWakeLock;
    private WindowState mHoldScreenWindow;
    private final boolean mIgnoreActivitySizeRestrictions;
    boolean mIgnoreDisplayCutout;
    private InsetsControlTarget mImeControlTarget;
    private InputTarget mImeInputTarget;
    private WindowState mImeLayeringTarget;
    ImeScreenshot mImeScreenshot;
    private Pair<IBinder, WindowContainerListener> mImeTargetTokenListenerPair;
    private final ImeContainer mImeWindowsContainer;
    private boolean mInEnsureActivitiesVisible;
    private boolean mInTouchMode;
    DisplayCutout mInitialDisplayCutout;
    int mInitialDisplayDensity;
    int mInitialDisplayHeight;
    DisplayShape mInitialDisplayShape;
    int mInitialDisplayWidth;
    float mInitialPhysicalXDpi;
    float mInitialPhysicalYDpi;
    RoundedCorners mInitialRoundedCorners;
    SurfaceControl mInputMethodSurfaceParent;
    private WindowContainer mInputMethodSurfaceParentWindow;
    WindowState mInputMethodWindow;
    private InputMonitor mInputMonitor;
    private SurfaceControl mInputOverlayLayer;
    private final InsetsPolicy mInsetsPolicy;
    private final InsetsStateController mInsetsStateController;
    boolean mIsDensityForced;
    boolean mIsSizeForced;
    boolean mLastContainsRunningSurfaceAnimator;
    private DisplayInfo mLastDisplayInfoOverride;
    private boolean mLastHasContent;
    private InputTarget mLastImeInputTarget;
    private WindowState mLastWakeLockHoldingWindow;
    private WindowState mLastWakeLockObscuringWindow;
    private boolean mLastWallpaperVisible;
    private boolean mLayoutNeeded;
    int mLayoutSeq;
    private MagnificationSpec mMagnificationSpec;
    int mMaxUiWidth;
    private MetricsLogger mMetricsLogger;
    int mMinSizeOfResizeableTaskDp;
    private IObricDisplayContent mObricExt;
    private WindowState mObscuringWindow;
    private TaskDisplayArea mOrientationRequestingTaskDisplayArea;
    private SurfaceControl mOverlayLayer;
    private final Consumer<WindowState> mPerformLayout;
    private final Consumer<WindowState> mPerformLayoutAttached;
    private Point mPhysicalDisplaySize;
    final PinnedTaskController mPinnedTaskController;
    private final PointerEventDispatcher mPointerEventDispatcher;
    private final RotationCache<PrivacyIndicatorBounds, PrivacyIndicatorBounds> mPrivacyIndicatorBoundsCache;
    final DisplayMetrics mRealDisplayMetrics;
    final RemoteDisplayChangeController mRemoteDisplayChangeController;
    RemoteInsetsControlTarget mRemoteInsetsControlTarget;
    private final IBinder.DeathRecipient mRemoteInsetsDeath;
    private boolean mRemoved;
    private boolean mRemoving;
    private Set<Rect> mRestrictedKeepClearAreas;
    private RootWindowContainer mRootWindowContainer;
    private final DisplayRotationReversionController mRotationReversionController;
    private final RotationCache<RoundedCorners, RoundedCorners> mRoundedCornerCache;
    private boolean mSandboxDisplayApis;
    private final Consumer<WindowState> mScheduleToastTimeout;
    final SparseArray<ShellRoot> mShellRoots;
    private boolean mSleeping;
    private final ComponentCallbacks mSysUiContextConfigCallback;
    private final Region mSystemGestureExclusion;
    private int mSystemGestureExclusionLimit;
    private final RemoteCallbackList<ISystemGestureExclusionListener> mSystemGestureExclusionListeners;
    private final Region mSystemGestureExclusionUnrestricted;
    private boolean mSystemGestureExclusionWasRestricted;
    private final Rect mSystemGestureFrameLeft;
    private final Rect mSystemGestureFrameRight;
    private final Configuration mTempConfig;
    private final ApplySurfaceChangesTransactionState mTmpApplySurfaceChangesTransactionState;
    private final Configuration mTmpConfiguration;
    private final DisplayMetrics mTmpDisplayMetrics;
    private WindowState mTmpHoldScreenWindow;
    private boolean mTmpInitial;
    private final Rect mTmpRect;
    private final Region mTmpRegion;
    private final TaskForResizePointSearchResult mTmpTaskForResizePointSearchResult;
    private final LinkedList<ActivityRecord> mTmpUpdateAllDrawn;
    private WindowState mTmpWindow;
    private final HashMap<IBinder, WindowToken> mTokenMap;
    final TransitionAnimation mTransitionAnimation;
    private SystemPerformanceHinter.HighPerfSession mTransitionPrefSession;
    final UnknownAppVisibilityController mUnknownAppVisibilityController;
    private Set<Rect> mUnrestrictedKeepClearAreas;
    private boolean mUpdateImeRequestedWhileDeferred;
    private boolean mUpdateImeTarget;
    private final Consumer<WindowState> mUpdateWindowsForAnimator;
    private final boolean mVisibleBackgroundUserEnabled;
    boolean mWaitingForConfig;
    WallpaperController mWallpaperController;
    boolean mWallpaperMayChange;
    final ArrayList<WindowState> mWinAddedSinceNullFocus;
    final ArrayList<WindowState> mWinRemovedSinceNullFocus;
    private final float mWindowCornerRadius;
    int pendingLayoutChanges;

    private static final class ApplySurfaceChangesTransactionState {
        public boolean disableHdrConversion;
        public boolean displayHasContent;
        public boolean obscured;
        public boolean preferMinimalPostProcessing;
        public float preferredMaxRefreshRate;
        public float preferredMinRefreshRate;
        public int preferredModeId;
        public float preferredRefreshRate;
        public boolean syswin;

        /* synthetic */ ApplySurfaceChangesTransactionState(DisplayContentIA r1) {
            this();
        }

        private ApplySurfaceChangesTransactionState() {
        }

        void reset() {
            this.displayHasContent = false;
            this.obscured = false;
            this.syswin = false;
            this.preferMinimalPostProcessing = false;
            this.preferredRefreshRate = DisplayContent.INVALID_DPI;
            this.preferredModeId = 0;
            this.preferredMinRefreshRate = DisplayContent.INVALID_DPI;
            this.preferredMaxRefreshRate = DisplayContent.INVALID_DPI;
            this.disableHdrConversion = false;
        }
    }

    class FixedRotationTransitionListener extends WindowManagerInternal.AppTransitionListener {
        final /* synthetic */ DisplayContent this$0;

        FixedRotationTransitionListener(DisplayContent this$0, int displayId) {
            this.this$0 = this$0;
            super(displayId);
        }

        boolean shouldDeferRotation() {
            ActivityRecord source = null;
            if (this.this$0.mTransitionController.isShellTransitionsEnabled() == false) goto L8;
            if (this.this$0.hasFixedRotationTransientLaunch() == false) goto L8;
            source = DisplayContent.m9909$$Nest$fgetmFixedRotationLaunchingApp(this.this$0);
        L8:
            if (source != null) goto L10;
        L14:
            return false;
        L10:
            if (source.getRequestedConfigurationOrientation(true) == 0) goto L14;
            return this.this$0.mWmService.mPolicy.okToAnimate(false);
        }

        @Override // com.android.server.wm.WindowManagerInternal.AppTransitionListener
        public void onAppTransitionFinishedLocked(IBinder token) {
            ActivityRecord r = ActivityRecord.forTokenLocked(token);
            if (r != null) goto L6;
            return;
        L6:
            if (DisplayContent.m9909$$Nest$fgetmFixedRotationLaunchingApp(this.this$0) != null) goto L15;
            if (this.this$0.mWmService.mFlags.mRespectNonTopVisibleFixedOrientation == true) goto L11;
            r.finishFixedRotationTransform();
            return;
        L11:
            if (r.isVisible() == true) goto L40;
            r.finishFixedRotationTransform();
            return;
        L40:
            return;
        L15:
            if (r.isVisible() == true) goto L18;
            return;
        L18:
            if (DisplayContent.m9909$$Nest$fgetmFixedRotationLaunchingApp(this.this$0).hasFixedRotationTransform(r) == false) goto L23;
            if (DisplayContent.m9909$$Nest$fgetmFixedRotationLaunchingApp(this.this$0).hasAnimatingFixedRotationTransition() == false) goto L35;
            return;
        L35:
            if (DisplayContent.m9908$$Nest$fgetmExt(this.this$0).shouldSkipFixedRotationReleaseForSplitReplace(r) == false) goto L37;
            return;
        L37:
            this.this$0.continueUpdateOrientationForDiffOrienLaunchingApp();
            return;
        L23:
            if (DisplayContent.m9909$$Nest$fgetmFixedRotationLaunchingApp(this.this$0).fillsParent() == true) goto L29;
            if (DisplayContent.m9909$$Nest$fgetmFixedRotationLaunchingApp(this.this$0).isState(ActivityRecord.State.STOPPING) == false) goto L41;
            Slog.w(DisplayContent.TAG, "translucent fixedRotationApp is stopping state");
            this.this$0.continueUpdateOrientationForDiffOrienLaunchingApp();
            return;
        L41:
            return;
        L29:
            if (r.inTransition() == false) goto L32;
            return;
        L32:
            if (DisplayContent.m9908$$Nest$fgetmExt(this.this$0).shouldSkipUpdateOrientationForDiffOrienLaunchingApp() == false) goto L35;
        }

        @Override // com.android.server.wm.WindowManagerInternal.AppTransitionListener
        public void onAppTransitionTimeoutLocked() {
            this.this$0.continueUpdateOrientationForDiffOrienLaunchingApp();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface ForceScalingMode {
    }

    private static class ImeContainer extends DisplayArea.Tokens {
        boolean mNeedsLayer;

        ImeContainer(WindowManagerService wms) {
            super(wms, DisplayArea.Type.ABOVE_TASKS, "ImeContainer", 8);
            this.mNeedsLayer = false;
        }

        public void setNeedsLayer() {
            this.mNeedsLayer = true;
        }

        @Override // com.android.server.wm.DisplayArea.Tokens, com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
        int getOrientation(int candidate) {
            if (shouldIgnoreOrientationRequest(candidate) == false) goto L6;
            return -2;
        L6:
            return candidate;
        }

        @Override // com.android.server.wm.WindowContainer
        void updateAboveInsetsState(InsetsState aboveInsetsState, SparseArray<InsetsSource> localInsetsSourcesFromParent, ArraySet<WindowState> insetsChangedWindows) {
            if (skipImeWindowsDuringTraversal(this.mDisplayContent) == false) goto L5;
            return;
        L5:
            super.updateAboveInsetsState(aboveInsetsState, localInsetsSourcesFromParent, insetsChangedWindows);
        }

        @Override // com.android.server.wm.WindowContainer
        boolean forAllWindows(ToBooleanFunction<WindowState> callback, boolean traverseTopToBottom) {
            DisplayContent dc = this.mDisplayContent;
            if (skipImeWindowsDuringTraversal(dc) == false) goto L7;
            return false;
        L7:
            return super.forAllWindows(callback, traverseTopToBottom);
        }

        private static boolean skipImeWindowsDuringTraversal(DisplayContent dc) {
            if (DisplayContent.m9910$$Nest$fgetmImeLayeringTarget(dc) == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean forAllWindowForce(ToBooleanFunction<WindowState> callback, boolean traverseTopToBottom) {
            return super.forAllWindows(callback, traverseTopToBottom);
        }

        @Override // com.android.server.wm.WindowContainer
        void assignLayer(SurfaceControl.Transaction t, int layer) {
            if (this.mNeedsLayer == true) goto L5;
            return;
        L5:
            super.assignLayer(t, layer);
            this.mNeedsLayer = false;
        }

        @Override // com.android.server.wm.WindowContainer
        void assignRelativeLayer(SurfaceControl.Transaction t, SurfaceControl relativeTo, int layer, boolean forceUpdate) {
            if (this.mNeedsLayer == true) goto L5;
            return;
        L5:
            super.assignRelativeLayer(t, relativeTo, layer, forceUpdate);
            this.mNeedsLayer = false;
        }

        @Override // com.android.server.wm.DisplayArea
        void setOrganizer(IDisplayAreaOrganizer organizer, boolean skipDisplayAreaAppeared) {
            super.setOrganizer(organizer, skipDisplayAreaAppeared);
            this.mDisplayContent.updateImeParent();
            if (organizer == null) goto L15;
            SurfaceControl imeParentSurfaceControl = getParentSurfaceControl();
            if (this.mSurfaceControl == null) goto L12;
            if (imeParentSurfaceControl == null) goto L12;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[2] == false) goto L10;
            String protoLogParam0 = String.valueOf(imeParentSurfaceControl);
            ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_IME, -1556099709547629010L, 0, new Object[]{protoLogParam0});
        L10:
            getPendingTransaction().reparent(this.mSurfaceControl, imeParentSurfaceControl);
            return;
        L12:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[4] == false) goto L17;
            String protoLogParam1 = String.valueOf(this.mSurfaceControl);
            String protoLogParam2 = String.valueOf(imeParentSurfaceControl);
            ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_IME, 1119786654111970652L, 0, new Object[]{protoLogParam1, protoLogParam2});
            return;
        L17:
            return;
        }
    }

    static final class ImeScreenshot {
        private SurfaceControl mImeSurface;
        private Point mImeSurfacePosition;
        private WindowState mImeTarget;
        private SurfaceControl.Builder mSurfaceBuilder;

        ImeScreenshot(SurfaceControl.Builder surfaceBuilder, WindowState imeTarget) {
            this.mSurfaceBuilder = surfaceBuilder;
            this.mImeTarget = imeTarget;
        }

        WindowState getImeTarget() {
            return this.mImeTarget;
        }

        SurfaceControl getImeScreenshotSurface() {
            return this.mImeSurface;
        }

        private SurfaceControl createImeSurface(ScreenCapture.ScreenshotHardwareBuffer b, SurfaceControl.Transaction t) {
            HardwareBuffer buffer = b.getHardwareBuffer();
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[2] == false) goto L5;
            String protoLogParam0 = String.valueOf(this.mImeTarget);
            String protoLogParam1 = String.valueOf(buffer.getWidth());
            String protoLogParam2 = String.valueOf(buffer.getHeight());
            ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_IME, 4835192778854186097L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2});
        L5:
            WindowState imeWindow = this.mImeTarget.getDisplayContent().mInputMethodWindow;
            ActivityRecord activity = this.mImeTarget.mActivityRecord;
            if (this.mImeTarget.mAttrs.type != 1) goto L8;
            SurfaceControl imeParent = activity.getSurfaceControl();
        L9:
            SurfaceControl imeSurface = this.mSurfaceBuilder.setName("IME-snapshot-surface").setBLASTLayer().setFormat(buffer.getFormat()).setParent(imeParent).setCallsite("DisplayContent.attachAndShowImeScreenshotOnTarget").build();
            InputMonitor.setTrustedOverlayInputInfo(imeSurface, t, imeWindow.getDisplayId(), "IME-snapshot-surface");
            t.setBuffer(imeSurface, buffer);
            t.setColorSpace(activity.mSurfaceControl, ColorSpace.get(ColorSpace.Named.SRGB));
            t.setLayer(imeSurface, 1);
            Point surfacePosition = new Point(imeWindow.getFrame().left, imeWindow.getFrame().top);
            if (imeParent != activity.getSurfaceControl()) goto L12;
            t.setPosition(imeSurface, surfacePosition.x, surfacePosition.y);
        L13:
            this.mImeSurfacePosition = surfacePosition;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[2] == false) goto L16;
            long protoLogParam3 = surfacePosition.x;
            long protoLogParam4 = surfacePosition.y;
            ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_IME, 2408509162360028352L, 5, new Object[]{Long.valueOf(protoLogParam3), Long.valueOf(protoLogParam4)});
        L16:
            return imeSurface;
        L12:
            surfacePosition.offset(-this.mImeTarget.getFrame().left, -this.mImeTarget.getFrame().top);
            surfacePosition.offset(this.mImeTarget.mAttrs.surfaceInsets.left, this.mImeTarget.mAttrs.surfaceInsets.top);
            t.setPosition(imeSurface, surfacePosition.x, surfacePosition.y);
            goto L13
        L8:
            imeParent = this.mImeTarget.getSurfaceControl();
            goto L9
        }

        private void removeImeSurface(SurfaceControl.Transaction t) {
            if (this.mImeSurface == null) goto L9;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[2] == false) goto L7;
            String protoLogParam0 = String.valueOf(Debug.getCallers(6));
            ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_IME, 2005731931732324688L, 0, new Object[]{protoLogParam0});
        L7:
            t.remove(this.mImeSurface);
            this.mImeSurface = null;
        L9:
            if (ImeTracker.DEBUG_IME_VISIBILITY == false) goto L12;
            EventLog.writeEvent(EventLogTags.IMF_REMOVE_IME_SCREENSHOT, this.mImeTarget.toString());
            return;
        }

        void attachAndShow(SurfaceControl.Transaction t, boolean anyTargetTask) {
            DisplayContent dc = this.mImeTarget.getDisplayContent();
            Task task = this.mImeTarget.getTask();
            boolean isValidSnapshot = true;
            if (this.mImeSurface != null) goto L5;
        L10:
            boolean renewImeSurface = true;
        L12:
            if (task == null) goto L23;
            if (anyTargetTask == false) goto L15;
        L16:
            if (renewImeSurface == false) goto L18;
            ScreenCapture.ScreenshotHardwareBuffer imeBuffer = dc.mWmService.mTaskSnapshotController.snapshotImeFromAttachedTask(task);
        L20:
            if (imeBuffer == null) goto L23;
            removeImeSurface(t);
            this.mImeSurface = createImeSurface(imeBuffer, t);
            goto L23
        L18:
            imeBuffer = null;
            goto L20
        L15:
            if (task.isActivityTypeHomeOrRecents() == false) goto L16;
        L23:
            if (this.mImeSurface != null) goto L25;
        L27:
            isValidSnapshot = false;
        L28:
            if (isValidSnapshot == true) goto L30;
        L37:
            if (isValidSnapshot == true) goto L42;
            removeImeSurface(t);
            return;
        L42:
            return;
        L30:
            if (dc.getInsetsStateController().getImeSourceProvider().isImeShowing() == false) goto L37;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[2] == false) goto L34;
            String protoLogParam0 = String.valueOf(this.mImeTarget);
            String protoLogParam1 = String.valueOf(Debug.getCallers(6));
            ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_IME, -6495118720675662641L, 0, new Object[]{protoLogParam0, protoLogParam1});
        L34:
            t.show(this.mImeSurface);
            if (ImeTracker.DEBUG_IME_VISIBILITY == false) goto L40;
            EventLog.writeEvent(EventLogTags.IMF_SHOW_IME_SCREENSHOT, new Object[]{this.mImeTarget.toString(), Integer.valueOf(dc.mInputMethodWindow.mTransitFlags), this.mImeSurfacePosition.toString()});
            return;
        L40:
            return;
        L25:
            if (this.mImeSurface.isValid() == false) goto L27;
        L5:
            if (this.mImeSurface.getWidth() != dc.mInputMethodWindow.getFrame().width()) goto L10;
            if (this.mImeSurface.getHeight() != dc.mInputMethodWindow.getFrame().height()) goto L10;
            renewImeSurface = false;
            goto L12
        }

        void detach(SurfaceControl.Transaction t) {
            removeImeSurface(t);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("ImeScreenshot{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" imeTarget=" + this.mImeTarget);
            sb.append(" surface=" + this.mImeSurface);
            sb.append('}');
            return sb.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface InputMethodTarget {
    }

    class RemoteInsetsControlTarget implements InsetsControlTarget {
        private int mAnimatingTypes;
        private final boolean mCanShowTransient;
        private boolean mImeInputTargetRequestedVisible;
        private final IDisplayWindowInsetsController mRemoteInsetsController;
        private int mRequestedVisibleTypes;
        private ComponentName mTopFocusedComponentName;
        private int mTopFocusedRequestedVisibleTypes;
        final /* synthetic */ DisplayContent this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmRemoteInsetsController, reason: not valid java name */
        static /* bridge */ /* synthetic */ IDisplayWindowInsetsController m9912$$Nest$fgetmRemoteInsetsController(RemoteInsetsControlTarget r0) {
            return r0.mRemoteInsetsController;
        }

        RemoteInsetsControlTarget(DisplayContent this$0, IDisplayWindowInsetsController controller) {
            this.this$0 = this$0;
            this.mRequestedVisibleTypes = WindowInsets.Type.defaultVisible();
            this.mAnimatingTypes = 0;
            this.mTopFocusedComponentName = null;
            this.mTopFocusedRequestedVisibleTypes = WindowInsets.Type.defaultVisible();
            this.mImeInputTargetRequestedVisible = false;
            this.mRemoteInsetsController = controller;
            this.mCanShowTransient = this$0.mWmService.mContext.getResources().getBoolean(R.bool.config_safe_sound_dosage_enabled);
        }

        void topFocusedWindowChanged(ComponentName component, int requestedVisibleTypes) {
            if (this.mTopFocusedComponentName != null) goto L5;
        L9:
            this.mTopFocusedComponentName = component;
            this.mTopFocusedRequestedVisibleTypes = requestedVisibleTypes;
            this.mRemoteInsetsController.topFocusedWindowChanged(component, requestedVisibleTypes);     // Catch: RemoteException -> L12
            return;
        L12:
            e = move-exception;
            Slog.w(DisplayContent.TAG, "Failed to deliver package in top focused window change", e);
            return;
        L5:
            if (this.mTopFocusedComponentName.equals(component) == false) goto L9;
            if (this.mTopFocusedRequestedVisibleTypes != requestedVisibleTypes) goto L9;
        }

        void notifyInsetsChanged() {
            this.mRemoteInsetsController.insetsChanged(this.this$0.getInsetsStateController().getRawInsetsState());     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(DisplayContent.TAG, "Failed to deliver inset state change", e);
        }

        @Override // com.android.server.wm.InsetsControlTarget
        public void notifyInsetsControlChanged(int displayId) {
            InsetsStateController stateController = this.this$0.getInsetsStateController();
            this.mRemoteInsetsController.insetsControlChanged(stateController.getRawInsetsState(), stateController.getControlsForDispatch(this));     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.w(DisplayContent.TAG, "Failed to deliver inset control state change", e);
        }

        @Override // com.android.server.wm.InsetsControlTarget
        public void showInsets(int types, boolean fromIme, ImeTracker.Token statsToken) {
            ImeTracker.forLogging().onProgress(statsToken, 23);     // Catch: RemoteException -> L5
            this.mRemoteInsetsController.showInsets(types, fromIme, statsToken);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.w(DisplayContent.TAG, "Failed to deliver showInsets", e);
            ImeTracker.forLogging().onFailed(statsToken, 23);
        }

        @Override // com.android.server.wm.InsetsControlTarget
        public void hideInsets(int types, boolean fromIme, ImeTracker.Token statsToken) {
            ImeTracker.forLogging().onProgress(statsToken, 24);     // Catch: RemoteException -> L5
            this.mRemoteInsetsController.hideInsets(types, fromIme, statsToken);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.w(DisplayContent.TAG, "Failed to deliver hideInsets", e);
            ImeTracker.forLogging().onFailed(statsToken, 24);
        }

        @Override // com.android.server.wm.InsetsControlTarget
        public boolean canShowTransient() {
            return this.mCanShowTransient;
        }

        @Override // com.android.server.wm.InsetsControlTarget, com.android.server.wm.InsetsTarget
        public boolean isRequestedVisible(int types) {
            if ((WindowInsets.Type.ime() & types) == 0) goto L9;
            if (this.mImeInputTargetRequestedVisible == true) goto L9;
            Slog.d(DisplayContent.TAG, "isRequestedVisible: IME input target requested hidden, return false");
            return false;
        L9:
            if ((this.mRequestedVisibleTypes & types) == 0) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // com.android.server.wm.InsetsControlTarget, com.android.server.wm.InsetsTarget
        public int getRequestedVisibleTypes() {
            return this.mRequestedVisibleTypes;
        }

        @Override // com.android.server.wm.InsetsControlTarget
        public void setImeInputTargetRequestedVisibility(boolean visible, ImeTracker.Token statsToken) {
            this.mImeInputTargetRequestedVisible = visible;
            this.mRemoteInsetsController.setImeInputTargetRequestedVisibility(visible, statsToken);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.w(DisplayContent.TAG, "Failed to deliver setImeInputTargetRequestedVisibility", e);
        }

        int updateRequestedVisibleTypes(int visibleTypes, int mask) {
            int newRequestedVisibleTypes = (this.mRequestedVisibleTypes & (~mask)) | (visibleTypes & mask);
            if (this.mRequestedVisibleTypes == newRequestedVisibleTypes) goto L6;
            Slog.d(DisplayContent.TAG, "updateRequestedVisibleTypes: %d" + this.mRequestedVisibleTypes + " -> %d" + newRequestedVisibleTypes + Debug.getCallers(8));
            int changedTypes = this.mRequestedVisibleTypes ^ newRequestedVisibleTypes;
            this.mRequestedVisibleTypes = newRequestedVisibleTypes;
            return changedTypes;
        L6:
            return 0;
        }

        @Override // com.android.server.wm.InsetsControlTarget
        public int getAnimatingTypes() {
            return this.mAnimatingTypes;
        }

        @Override // com.android.server.wm.InsetsControlTarget
        public void setAnimatingTypes(int animatingTypes, ImeTracker.Token statsToken) {
            if (this.mAnimatingTypes == animatingTypes) goto L6;
            this.mAnimatingTypes = animatingTypes;
            return;
        }
    }

    static final class TaskForResizePointSearchResult implements Predicate<Task> {
        private int delta;
        private Rect mTmpRect;
        private Task taskForResize;
        private int x;
        private int y;

        TaskForResizePointSearchResult() {
            this.mTmpRect = new Rect();
        }

        @Override // java.util.function.Predicate
        public /* bridge */ /* synthetic */ boolean test(Task r1) {
            return test2(r1);
        }

        Task process(WindowContainer root, int x, int y, int delta) {
            this.taskForResize = null;
            this.x = x;
            this.y = y;
            this.delta = delta;
            this.mTmpRect.setEmpty();
            root.forAllTasks(this);
            return this.taskForResize;
        }

        /* JADX INFO: renamed from: test, reason: avoid collision after fix types in other method */
        public boolean test2(Task task) {
            if (task.getRootTask().getWindowConfiguration().canResizeTask() == true) goto L6;
            return true;
        L6:
            if (task.getWindowingMode() != 1) goto L9;
            return true;
        L9:
            if (task.isOrganized() == false) goto L11;
            return true;
        L11:
            task.getDimBounds(this.mTmpRect);
            this.mTmpRect.inset(-this.delta, -this.delta);
            if (this.mTmpRect.contains(this.x, this.y) == false) goto L18;
            this.mTmpRect.inset(this.delta, this.delta);
            if (this.mTmpRect.contains(this.x, this.y) == true) goto L17;
            this.taskForResize = task;
            return true;
        L17:
            return true;
        L18:
            return false;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-Ae98LSExF9Yad4-_Mm-zfs_rQw, reason: not valid java name */
    public static /* synthetic */ void m9886$r8$lambda$Ae98LSExF9Yad4_Mmzfs_rQw(ActivityRecord r0) {
        lambda$setIgnoreOrientationRequest$46(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$-dBz3LtsWovWVT0SE5m__EwNfT4, reason: not valid java name */
    public static /* synthetic */ void m9887$r8$lambda$dBz3LtsWovWVT0SE5m__EwNfT4(DisplayContent r0, WindowState r1) {
        r0.lambda$new$8(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$09LjI9IPIDqkx6xQRSSpO0paSaI(DisplayContent r0, WindowState r1) {
        return r0.lambda$new$6(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$0qT6GYhjGguOWMyvPDOpZD9lW8A(DisplayContent r0, WindowState r1) {
        return r0.lambda$new$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$0tWwKMMqS8qtraYTMmN5kYdU2b0(int[] r0, int[] r1, Region r2, Rect r3) {
        lambda$addToGlobalAndConsumeLimit$31(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$1BcDbdgRKwB39qMGzO3iB-yGEfw, reason: not valid java name */
    public static /* synthetic */ void m9888$r8$lambda$1BcDbdgRKwB39qMGzO3iByGEfw(ToBooleanFunction r0, ArrayList r1, WindowState r2) {
        lambda$getLayerCaptureArgs$29(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$1_iZMLXs4nYM1ovPUWdiCnCPVR0(PrintWriter r0, String r1, int[] r2, WindowState r3) {
        lambda$dumpWindowAnimators$26(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$1lUYzPCZZNOBLP0-kUj3J63ADaE, reason: not valid java name */
    public static /* synthetic */ boolean m9889$r8$lambda$1lUYzPCZZNOBLP0kUj3J63ADaE(DisplayContent r0, SparseBooleanArray r1, WindowState r2) {
        return r0.lambda$shouldWaitForSystemDecorWindowsOnBoot$27(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$29SvIfa0q_EjfJz5LIYrvX0eW-E, reason: not valid java name */
    public static /* synthetic */ boolean m9890$r8$lambda$29SvIfa0q_EjfJz5LIYrvX0eWE(int r0, WindowState r1) {
        return lambda$canAddToastWindowForUid$21(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$36VABT65rrgD1t41DPqwt8IaZx8(IBinder r0) {
        lambda$updateImeControlTarget$24(r0);
    }

    public static /* synthetic */ DisplayShape $r8$lambda$5VVSLdls3hPPHQhvQRptGbZEU1E(DisplayContent r0, DisplayShape r1, int r2) {
        return r0.calculateDisplayShapeForRotationUncached(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$5bhSsr-yGga7yNAEK2ugIQHZvK4, reason: not valid java name */
    public static /* synthetic */ boolean m9891$r8$lambda$5bhSsryGga7yNAEK2ugIQHZvK4(Task r0) {
        return lambda$releaseSelfIfNeeded$41(r0);
    }

    public static /* synthetic */ void $r8$lambda$9up4jPrAiE1PWTnFThp8_HStPpg(DisplayContent r0, DeviceStateController.DeviceState r1) {
        r0.lambda$new$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$AEOYpAxELdjJR80taSEH9CmSkgE(DisplayContent r0, RootWindowContainer.SleepToken r1) {
        r0.lambda$remove$40(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$AXMCdmPt7rxgAllYR-oCCahjN_c, reason: not valid java name */
    public static /* synthetic */ void m9892$r8$lambda$AXMCdmPt7rxgAllYRoCCahjN_c(Task r0) {
        lambda$removeAllTasks$45(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$DKIVdWt43k7OVoUwb0Draiw1VO8(Set r0, Set r1, Matrix r2, float[] r3, WindowState r4) {
        return lambda$getKeepClearAreas$33(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$DNOm8Dos4h-TAyyQM_PBy-h28mY, reason: not valid java name */
    public static /* synthetic */ Task m9893$r8$lambda$DNOm8Dos4hTAyyQM_PByh28mY(DisplayContent r0, int r1, int r2, int r3, TaskDisplayArea r4) {
        return r0.lambda$findTaskForResizePoint$16(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$DUxAkCYamglfWldOyLUFQLJ_2hY(DisplayContent r0) {
        r0.lambda$remove$39();
    }

    public static /* synthetic */ void $r8$lambda$DgjwN9PtwCkfxpv3tlhvDuQdISk(DisplayContent r0, Region r1, Region r2, Region r3, int[] r4, Region r5, Region r6, WindowState r7) {
        r0.lambda$calculateSystemGestureExclusion$30(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: $r8$lambda$FGmCOc7G6J_5WkJ6-UnWFyLN-Cs, reason: not valid java name */
    public static /* synthetic */ boolean m9894$r8$lambda$FGmCOc7G6J_5WkJ6UnWFyLNCs(WindowState r0, Object r1) {
        return lambda$removeImeSurfaceByTarget$23(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$FRQuL_4aVvApdsUcGAI2BrKuoIc(int r0, WindowState r1) {
        return lambda$canAddToastWindowForUid$20(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Ivfp5oKoGh0tJPXbUnBZVv6Lw4U(DisplayContent r0, SurfaceControl.Transaction r1, WindowState r2) {
        r0.lambda$destroyLeakedSurfaces$22(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$J9dU0gU1oxd1-cPbUcp7MJw5738, reason: not valid java name */
    public static /* synthetic */ void m9895$r8$lambda$J9dU0gU1oxd1cPbUcp7MJw5738(DisplayContent r0, ActivityRecord r1) {
        r0.lambda$getPresentUIDs$43(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$K_UatSEBEnjL0_6C0gAzkKVNFRY(DisplayContent r0, int r1, ActivityRecord r2) {
        return r0.lambda$applyFixedRotationForNonTopVisibleActivityIfNeeded$10(r1, r2);
    }

    public static /* synthetic */ ActivityRecord $r8$lambda$NWSpFyyJ2jHJPOgCS6lPAIRV21w(boolean r0, TaskDisplayArea r1) {
        return lambda$topRunningActivity$36(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$OXVENR37SwETNUCVwJfw_R_ZmjI(Task r0) {
        lambda$releaseSelfIfNeeded$42(r0);
    }

    public static /* synthetic */ WmDisplayCutout $r8$lambda$OlRwH3_Eqb403xPL7MPG5vhH0aE(DisplayContent r0, DisplayCutout r1, int r2) {
        return r0.calculateDisplayCutoutForRotationUncached(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$U-EeNvNwsmSKaNDaDAATRribTDI, reason: not valid java name */
    public static /* synthetic */ void m9896$r8$lambda$UEeNvNwsmSKaNDaDAATRribTDI(int[] r0, ArrayList r1, Task r2) {
        lambda$removeRootTasksInWindowingModes$34(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$XUTCyB_ZYJVkBqlu2Wl2mZroZ8I(int[] r0, Task r1) {
        lambda$getRootTaskCount$14(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$bC7m5niZgqHDhSvbbkAt-rVKzoA, reason: not valid java name */
    public static /* synthetic */ void m9897$r8$lambda$bC7m5niZgqHDhSvbbkAtrVKzoA(DisplayContent r0, int r1, int r2) {
        r0.lambda$applyRotationAndFinishFixedRotation$37(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$eqRZJdJkfUYsak86XG7kAgFd1Kc(DisplayContent r0, long r1) {
        r0.lambda$requestChangeTransition$17(r1);
    }

    public static /* synthetic */ RoundedCorners $r8$lambda$f7tHAwMP7F9Y6GRaAF8mvZCW4p4(DisplayContent r0, RoundedCorners r1, int r2) {
        return r0.calculateRoundedCornersForRotationUncached(r1, r2);
    }

    public static /* synthetic */ PrivacyIndicatorBounds $r8$lambda$g3NtyUymxIbR0_Zt8BGLWPTUWWk(DisplayContent r0, PrivacyIndicatorBounds r1, int r2) {
        return r0.calculatePrivacyIndicatorBoundsForRotationUncached(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$gBc8HHrgm8lWA0NOAKJqxLyz6Eo(WindowState r0) {
        return lambda$hasSecureWindowOnScreen$28(r0);
    }

    public static /* synthetic */ Task $r8$lambda$gqwDScxwzVQcDgWRYExOmr1VSYI(boolean r0, TaskDisplayArea r1, Task r2) {
        return lambda$clearAllTasksOnDisplay$38(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$hkBcv35oI_sDzJ-r3_1RUH-fcfo, reason: not valid java name */
    public static /* synthetic */ void m9898$r8$lambda$hkBcv35oI_sDzJr3_1RUHfcfo(DisplayContent r0, WindowState r1) {
        r0.lambda$new$5(r1);
    }

    public static /* synthetic */ Task $r8$lambda$hyu7zHFgtjAI7KSmHZsuQ6Quv9Q(int r0, int r1, TaskDisplayArea r2) {
        return lambda$getRootTask$12(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$jBYehbd4VoumxuHejP-OiyhtLds, reason: not valid java name */
    public static /* synthetic */ void m9899$r8$lambda$jBYehbd4VoumxuHejPOiyhtLds(DisplayContent r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$jb34Dh5W4dvkHzL-AlQ2T5FmX-I, reason: not valid java name */
    public static /* synthetic */ boolean m9900$r8$lambda$jb34Dh5W4dvkHzLAlQ2T5FmXI(int r0, Task r1) {
        return lambda$getRootTask$13(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$m3_QfYVQ2X5TCCaPfidklMmlJ3A(DisplayContent r0, WindowState r1) {
        r0.lambda$new$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$n3xTmYSwOLiRmmdl4Nc5LH-hb-w, reason: not valid java name */
    public static /* synthetic */ void m9901$r8$lambda$n3xTmYSwOLiRmmdl4Nc5LHhbw(DisplayContent r0) {
        r0.lambda$updateImeParent$25();
    }

    /* JADX INFO: renamed from: $r8$lambda$nDBBxPKrToEhm-AbGM-OXvv_Byc, reason: not valid java name */
    public static /* synthetic */ void m9902$r8$lambda$nDBBxPKrToEhmAbGMOXvv_Byc(PrintWriter r0, String r1, boolean r2, TaskDisplayArea r3) {
        lambda$dump$18(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$nODbW0BIYZxTBiTwYRNgIzEqyjs(ActivityRecord r0, boolean r1, Task r2) {
        lambda$ensureActivitiesVisible$44(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$nSzlgovjqO6D-KA1rputZkWgFOY, reason: not valid java name */
    public static /* synthetic */ void m9903$r8$lambda$nSzlgovjqO6DKA1rputZkWgFOY(DisplayContent r0, WindowState r1) {
        r0.lambda$new$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ok6wr7W0cFAk5q-tHqW-sztrMxA, reason: not valid java name */
    public static /* synthetic */ void m9904$r8$lambda$ok6wr7W0cFAk5qtHqWsztrMxA(Set r0, Rect r1) {
        lambda$getKeepClearAreas$32(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$rBB2XIZZraU5FHtqYxHh4itVwSg(int[] r0, ArrayList r1, Task r2) {
        lambda$removeRootTasksWithActivityTypes$35(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$ro8qyeDvIUnuK9S-Ac1Fs1DW7Pc, reason: not valid java name */
    public static /* synthetic */ void m9905$r8$lambda$ro8qyeDvIUnuK9SAc1Fs1DW7Pc(DisplayContent r0, WindowState r1) {
        r0.lambda$new$7(r1);
    }

    public static /* synthetic */ void $r8$lambda$t6d5V3y0Nwh6xc7M2jAqZdlSn5w(DisplayContent r0, DisplayArea r1) {
        r0.lambda$updateDisplayAreaOrganizers$15(r1);
    }

    public static /* synthetic */ void $r8$lambda$tJXVQaj2eE3V3eVOQCwZkLsb81Q(DisplayContent r0) {
        r0.lambda$startAsyncRotation$11();
    }

    public static /* synthetic */ void $r8$lambda$viMLDYZeNr6UfQB2dUSXkWvClEk(DisplayContent r0, WindowState r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$xRJpquIU1EHNGL_YqIKUA9DatXc(DisplayContent r0, int r1, int r2, WindowState r3) {
        return r0.lambda$getTouchableWinAtPointLocked$19(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayPolicy m9906$$Nest$fgetmDisplayPolicy(DisplayContent r0) {
        return r0.mDisplayPolicy;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9907$$Nest$fgetmDisplayReady(DisplayContent r0) {
        return r0.mDisplayReady;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtDisplayContent m9908$$Nest$fgetmExt(DisplayContent r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFixedRotationLaunchingApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityRecord m9909$$Nest$fgetmFixedRotationLaunchingApp(DisplayContent r0) {
        return r0.mFixedRotationLaunchingApp;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmImeLayeringTarget, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowState m9910$$Nest$fgetmImeLayeringTarget(DisplayContent r0) {
        return r0.mImeLayeringTarget;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMinimalTaskSizeDp, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9911$$Nest$mgetMinimalTaskSizeDp(DisplayContent r0) {
        return r0.getMinimalTaskSizeDp();
    }

    static {
        COPY_SOURCE_VISIBILITY = new AnonymousClass1();
    }

    private /* synthetic */ void lambda$new$0() {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mRemoteInsetsControlTarget = null;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$new$1(WindowState w) {
        WindowStateAnimator winAnimator = w.mWinAnimator;
        ActivityRecord activity = w.mActivityRecord;
        if (winAnimator.mDrawState != 3) goto L13;
        if (activity == null) goto L8;
        if (activity.canShowWindows() == true) goto L8;
        return;
    L8:
        if (w.performShowLocked() == false) goto L15;
        this.pendingLayoutChanges |= 8;
        if (WindowManagerDebugConfig.DEBUG_LAYOUT_REPEATS == false) goto L16;
        this.mWmService.mWindowPlacerLocked.debugLayoutRepeats("updateWindowsAndWallpaperLocked 5", this.pendingLayoutChanges);
        return;
    L16:
        return;
    L15:
        return;
    }

    private /* synthetic */ void lambda$new$2(WindowState w) {
        int lostFocusUid = this.mTmpWindow.mOwnerUid;
        Handler handler = this.mWmService.mH;
        if (w.mAttrs.type == 2005) goto L5;
        return;
    L5:
        if (w.mOwnerUid == lostFocusUid) goto L7;
        return;
    L7:
        if (handler.hasMessages(52, w) == true) goto L12;
        handler.sendMessageDelayed(handler.obtainMessage(52, w), w.mAttrs.hideTimeoutMilliseconds);
        return;
    }

    private /* synthetic */ boolean lambda$new$3(WindowState w) {
        ActivityRecord focusedApp = this.mFocusedApp;
        boolean canReceiveKeys = w.canReceiveKeys();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(w);
        long protoLogParam1 = w.mAttrs.flags;
        String protoLogParam3 = String.valueOf(w.canReceiveKeysReason(false));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS, 1432179297701477868L, 52, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Boolean.valueOf(canReceiveKeys), protoLogParam3});
    L5:
        if (canReceiveKeys == true) goto L8;
        return false;
    L8:
        if (w.mIsImWindow == true) goto L10;
    L29:
        ActivityRecord activity = w.mActivityRecord;
        if (getExt().shouldRejectSplitReplaceSelectingFocusWindow(w) == false) goto L32;
        return false;
    L32:
        if (focusedApp != null) goto L39;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[1] == false) goto L36;
        String protoLogParam2 = String.valueOf(w);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -1998969924927409574L, 0, new Object[]{protoLogParam2});
    L36:
        this.mTmpWindow = w;
        return true;
    L39:
        if (focusedApp.windowsAreFocusable() == false) goto L41;
        if (activity == null) goto L72;
        if (w.mAttrs.type == 3) goto L72;
        if (focusedApp.compareTo(activity) > 0) goto L51;
        TaskFragment parent = activity.getTaskFragment();
        if (parent == null) goto L65;
        if (parent.isEmbedded() == false) goto L65;
        if (activity.getTask() != focusedApp.getTask()) goto L65;
        if (activity.getTaskFragment() == focusedApp.getTaskFragment()) goto L65;
        return false;
    L65:
        if (Features.FEAT_QUICK_WIN == false) goto L72;
        if (activity.inFreeformWindowingMode() == false) goto L72;
        if (w.getTask() == focusedApp.getTask()) goto L72;
        return false;
    L51:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[1] == false) goto L53;
        String protoLogParam4 = String.valueOf(focusedApp);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, 271075236829935631L, 0, new Object[]{protoLogParam4});
    L53:
        this.mTmpWindow = null;
        return true;
    L72:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[1] == false) goto L74;
        String protoLogParam5 = String.valueOf(w);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, 3066566560703920191L, 0, new Object[]{protoLogParam5});
    L74:
        this.mTmpWindow = w;
        return true;
    L41:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[1] == false) goto L43;
        String protoLogParam6 = String.valueOf(w);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -1513212297283619351L, 0, new Object[]{protoLogParam6});
    L43:
        this.mTmpWindow = w;
        return true;
    L10:
        if (this.mInputMethodSurfaceParentWindow != null) goto L12;
    L14:
        boolean imeParentVisible = false;
    L16:
        if (imeParentVisible == true) goto L22;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[1] == false) goto L20;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS, 8023526987596643062L, 0, null);
    L20:
        return false;
    L22:
        if (w.isChildWindow() == false) goto L29;
        if (getInsetsStateController().getImeSourceProvider().isImeShowing() == true) goto L29;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[1] == false) goto L28;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS, -8514879032382311302L, 0, null);
    L28:
        return false;
    L12:
        if (this.mInputMethodSurfaceParentWindow.isVisibleRequested() == false) goto L14;
        imeParentVisible = true;
        goto L16
    }

    private /* synthetic */ void lambda$new$4(WindowState w) {
        if (w.mLayoutAttached == false) goto L5;
        return;
    L5:
        boolean gone = w.isGoneForLayout();
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L23;
        Slog.v(TAG, "1ST PASS " + w + ": gone=" + gone + " mHaveFrame=" + w.mHaveFrame + " config reported=" + w.isLastConfigReportedToClient());
        ActivityRecord activity = w.mActivityRecord;
        if (gone == false) goto L16;
        StringBuilder r9 = new StringBuilder();
        r9.append("  GONE: mViewVisibility=");
        r9.append(w.mViewVisibility);
        r9.append(" mRelayoutCalled=");
        r9.append(w.mRelayoutCalled);
        r9.append(" visible=");
        r9.append(w.mToken.isVisible());
        r9.append(" visibleRequested=");
        if (activity != null) goto L12;
    L14:
        boolean r6 = false;
    L15:
        r9.append(r6);
        r9.append(" parentHidden=");
        r9.append(w.isParentWindowHidden());
        Slog.v(TAG, r9.toString());
        goto L23
    L12:
        if (activity.isVisibleRequested() == false) goto L14;
        r6 = true;
        goto L15
    L16:
        StringBuilder r10 = new StringBuilder();
        r10.append("  VIS: mViewVisibility=");
        r10.append(w.mViewVisibility);
        r10.append(" mRelayoutCalled=");
        r10.append(w.mRelayoutCalled);
        r10.append(" visible=");
        r10.append(w.mToken.isVisible());
        r10.append(" visibleRequested=");
        if (activity != null) goto L19;
    L21:
        boolean r7 = false;
    L22:
        r10.append(r7);
        r10.append(" parentHidden=");
        r10.append(w.isParentWindowHidden());
        Slog.v(TAG, r10.toString());
        goto L23
    L19:
        if (activity.isVisibleRequested() == false) goto L21;
        r7 = true;
    L23:
        if (gone == false) goto L29;
        if (w.mHaveFrame == false) goto L29;
        if (w.mLayoutNeeded == true) goto L29;
        return;
    L29:
        if (this.mTmpInitial == false) goto L31;
        w.resetContentChanged();
    L31:
        w.mSurfacePlacementNeeded = true;
        w.mLayoutNeeded = false;
        boolean firstLayout = !w.isLaidOut();
        getDisplayPolicy().layoutWindowLw(w, null, this.mDisplayFrames);
        w.mLayoutSeq = this.mLayoutSeq;
        if (firstLayout == false) goto L38;
        if (w.getFrame().isEmpty() == true) goto L36;
        w.updateLastFrames();
        this.mWmService.mFrameChangingWindows.remove(w);
    L36:
        w.updateSurfacePositionNonOrganized();
        w.onResizeHandled();
    L38:
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L42;
        Slog.v(TAG, "  LAYOUT: mFrame=" + w.getFrame() + " mParentFrame=" + w.getParentFrame() + " mDisplayFrame=" + w.getDisplayFrame());
        return;
    }

    private /* synthetic */ void lambda$new$5(WindowState w) {
        if (w.mLayoutAttached == true) goto L6;
        return;
    L6:
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L9;
        Slog.v(TAG, "2ND PASS " + w + " mHaveFrame=" + w.mHaveFrame + " mViewVisibility=" + w.mViewVisibility + " mRelayoutCalled=" + w.mRelayoutCalled);
    L9:
        if (w.mViewVisibility == 8) goto L13;
        if (w.mRelayoutCalled == false) goto L13;
    L17:
        if (this.mTmpInitial == false) goto L19;
        w.resetContentChanged();
    L19:
        w.mSurfacePlacementNeeded = true;
        w.mLayoutNeeded = false;
        getDisplayPolicy().layoutWindowLw(w, w.getParentWindow(), this.mDisplayFrames);
        w.mLayoutSeq = this.mLayoutSeq;
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L24;
        Slog.v(TAG, " LAYOUT: mFrame=" + w.getFrame() + " mParentFrame=" + w.getParentFrame() + " mDisplayFrame=" + w.getDisplayFrame());
        return;
    L24:
        return;
    L13:
        if (w.mHaveFrame == false) goto L17;
        if (w.mLayoutNeeded == true) goto L17;
    }

    private /* synthetic */ boolean lambda$new$6(WindowState w) {
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L8;
        if (this.mUpdateImeTarget == false) goto L8;
        Slog.i(TAG, "Checking window @" + w + " fl=0x" + Integer.toHexString(w.mAttrs.flags));
    L8:
        if (w.inFreeformWindowingMode() == false) goto L17;
        if (w.canBeImeTarget() == false) goto L17;
        if (this.mCurrentFocus != w) goto L14;
        return true;
    L14:
        return false;
    L17:
        return w.canBeImeTarget();
    }

    private /* synthetic */ void lambda$new$7(WindowState w) {
        getDisplayPolicy().applyPostLayoutPolicyLw(w, w.mAttrs, w.getParentWindow(), this.mImeLayeringTarget);
    }

    private /* synthetic */ void lambda$new$8(WindowState w) {
        WindowSurfacePlacer surfacePlacer = this.mWmService.mWindowPlacerLocked;
        RootWindowContainer root = this.mWmService.mRoot;
        if (w.mHasSurface == false) goto L15;
        boolean committed = w.mWinAnimator.commitFinishDrawingLocked();
        if (this.isDefaultDisplay == false) goto L15;
        if (committed == false) goto L15;
        if (w.hasWallpaper() == false) goto L15;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L12;
        String protoLogParam0 = String.valueOf(w);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -8667452489821572603L, 0, new Object[]{protoLogParam0});
    L12:
        this.mWallpaperMayChange = true;
        this.pendingLayoutChanges |= 4;
        if (WindowManagerDebugConfig.DEBUG_LAYOUT_REPEATS == false) goto L15;
        surfacePlacer.debugLayoutRepeats("wallpaper and commitFinishDrawingLocked true", this.pendingLayoutChanges);
    L15:
        w.mObscured = this.mTmpApplySurfaceChangesTransactionState.obscured;
        if (this.mTmpApplySurfaceChangesTransactionState.obscured == true) goto L68;
        boolean isDisplayed = w.isDisplayed();
        if (isDisplayed == true) goto L20;
    L22:
        boolean displayHasContent = root.handleNotObscuredLocked(w, this.mTmpApplySurfaceChangesTransactionState.obscured, this.mTmpApplySurfaceChangesTransactionState.syswin);
        if (this.mTmpApplySurfaceChangesTransactionState.displayHasContent == true) goto L28;
        if (getDisplayPolicy().isWindowExcludedFromContent(w) == true) goto L28;
        this.mTmpApplySurfaceChangesTransactionState.displayHasContent |= displayHasContent;
    L28:
        if (w.mHasSurface == false) goto L68;
        if (isDisplayed == false) goto L68;
        if ((w.mAttrs.flags & 128) == 0) goto L34;
        this.mTmpHoldScreenWindow = w;
    L38:
        int type = w.mAttrs.type;
        if (type != 2008) goto L41;
    L46:
        this.mTmpApplySurfaceChangesTransactionState.syswin = true;
    L48:
        if (this.mTmpApplySurfaceChangesTransactionState.preferredRefreshRate == INVALID_DPI) goto L50;
    L52:
        this.mTmpApplySurfaceChangesTransactionState.preferMinimalPostProcessing |= w.mAttrs.preferMinimalPostProcessing;
        ApplySurfaceChangesTransactionState r6 = this.mTmpApplySurfaceChangesTransactionState;
        r6.disableHdrConversion = (true ^ w.mAttrs.isHdrConversionEnabled()) | r6.disableHdrConversion;
        int preferredModeId = getDisplayPolicy().getRefreshRatePolicy().getPreferredModeId(w);
        if (w.getWindowingMode() != 2) goto L55;
    L58:
        float preferredMinRefreshRate = getDisplayPolicy().getRefreshRatePolicy().getPreferredMinRefreshRate(w);
        if (this.mTmpApplySurfaceChangesTransactionState.preferredMinRefreshRate == INVALID_DPI) goto L61;
    L63:
        float preferredMaxRefreshRate = getDisplayPolicy().getRefreshRatePolicy().getPreferredMaxRefreshRate(w);
        if (this.mTmpApplySurfaceChangesTransactionState.preferredMaxRefreshRate != INVALID_DPI) goto L68;
        if (preferredMaxRefreshRate == INVALID_DPI) goto L68;
        this.mTmpApplySurfaceChangesTransactionState.preferredMaxRefreshRate = preferredMaxRefreshRate;
        goto L68
    L61:
        if (preferredMinRefreshRate == INVALID_DPI) goto L63;
        this.mTmpApplySurfaceChangesTransactionState.preferredMinRefreshRate = preferredMinRefreshRate;
        goto L63
    L55:
        if (this.mTmpApplySurfaceChangesTransactionState.preferredModeId != 0) goto L58;
        if (preferredModeId == 0) goto L58;
        this.mTmpApplySurfaceChangesTransactionState.preferredModeId = preferredModeId;
        goto L58
    L50:
        if (w.mAttrs.preferredRefreshRate == INVALID_DPI) goto L52;
        this.mTmpApplySurfaceChangesTransactionState.preferredRefreshRate = w.mAttrs.preferredRefreshRate;
        goto L52
    L41:
        if (type == 2010) goto L46;
        if (type != 2040) goto L48;
        if (this.mWmService.mPolicy.isKeyguardShowing() == false) goto L48;
    L34:
        if (w != this.mLastWakeLockHoldingWindow) goto L38;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_KEEP_SCREEN_ON_enabled[0] == false) goto L38;
        String protoLogParam1 = String.valueOf(w);
        String protoLogParam2 = String.valueOf(Debug.getCallers(10));
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, 6283995720623600346L, 0, new Object[]{protoLogParam1, protoLogParam2});
        goto L38
    L20:
        if (w.isObscuringDisplay() == false) goto L22;
        this.mObscuringWindow = w;
        this.mTmpApplySurfaceChangesTransactionState.obscured = true;
    L68:
        w.handleWindowMovedIfNeeded();
        w.resetContentChanged();
        ActivityRecord activity = w.mActivityRecord;
        if (activity != null) goto L71;
    L77:
        w.updateResizingWindowIfNeeded();
        return;
    L71:
        if (activity.isVisibleRequested() == false) goto L77;
        activity.updateLetterboxSurfaceIfNeeded(w);
        boolean updateAllDrawn = activity.updateDrawnWindowStates(w);
        if (updateAllDrawn == false) goto L77;
        if (this.mTmpUpdateAllDrawn.contains(activity) == true) goto L77;
        this.mTmpUpdateAllDrawn.add(activity);
        goto L77
    }

    DisplayContent(Display display, RootWindowContainer root, DeviceStateController deviceStateController) {
        super(root.mWindowManager, "DisplayContent", 0);
        this.mVisibleBackgroundUserEnabled = UserManager.isVisibleBackgroundUsersEnabled();
        this.mMinSizeOfResizeableTaskDp = -1;
        this.mImeWindowsContainer = new ImeContainer(this.mWmService);
        this.mMaxUiWidth = 0;
        this.mTokenMap = new HashMap();
        this.mInitialDisplayWidth = 0;
        this.mInitialDisplayHeight = 0;
        this.mInitialPhysicalXDpi = INVALID_DPI;
        this.mInitialPhysicalYDpi = INVALID_DPI;
        this.mInitialDisplayDensity = 0;
        this.mDisplayCutoutCache = new RotationCache(new DisplayContent$$ExternalSyntheticLambda36(this));
        this.mRoundedCornerCache = new RotationCache(new DisplayContent$$ExternalSyntheticLambda41(this));
        this.mCurrentPrivacyIndicatorBounds = new PrivacyIndicatorBounds();
        this.mPrivacyIndicatorBoundsCache = new RotationCache(new DisplayContent$$ExternalSyntheticLambda42(this));
        this.mDisplayShapeCache = new RotationCache(new DisplayContent$$ExternalSyntheticLambda43(this));
        this.mBaseDisplayWidth = 0;
        this.mBaseDisplayHeight = 0;
        this.mIsSizeForced = false;
        this.mSandboxDisplayApis = true;
        this.mBaseDisplayDensity = 0;
        this.mForcedDisplayDensityRatio = INVALID_DPI;
        this.mIsDensityForced = false;
        this.mBaseDisplayPhysicalXDpi = INVALID_DPI;
        this.mBaseDisplayPhysicalYDpi = INVALID_DPI;
        this.mDisplayInfo = new DisplayInfo();
        this.mDisplayMetrics = new DisplayMetrics();
        this.mSystemGestureExclusionListeners = new RemoteCallbackList();
        this.mDecorViewGestureListener = new RemoteCallbackList();
        this.mSystemGestureExclusion = new Region();
        this.mSystemGestureExclusionWasRestricted = false;
        this.mSystemGestureExclusionUnrestricted = new Region();
        this.mSystemGestureFrameLeft = new Rect();
        this.mSystemGestureFrameRight = new Rect();
        this.mRestrictedKeepClearAreas = new ArraySet();
        this.mUnrestrictedKeepClearAreas = new ArraySet();
        this.mRealDisplayMetrics = new DisplayMetrics();
        this.mTmpDisplayMetrics = new DisplayMetrics();
        this.mCompatDisplayMetrics = new DisplayMetrics();
        this.mLastWallpaperVisible = false;
        this.mTmpRect = new Rect();
        this.mTmpRegion = new Region();
        this.mTmpConfiguration = new Configuration();
        this.mTmpUpdateAllDrawn = new LinkedList();
        this.mTmpTaskForResizePointSearchResult = new TaskForResizePointSearchResult();
        this.mTmpApplySurfaceChangesTransactionState = new ApplySurfaceChangesTransactionState(null);
        this.mDisplayReady = false;
        this.mWallpaperMayChange = false;
        this.mCurrentFocus = null;
        this.mFocusedApp = null;
        this.mOrientationRequestingTaskDisplayArea = null;
        this.mWinAddedSinceNullFocus = new ArrayList();
        this.mWinRemovedSinceNullFocus = new ArrayList();
        this.mLayoutSeq = 0;
        this.mShellRoots = new SparseArray();
        this.mRemoteInsetsControlTarget = null;
        this.mRemoteInsetsDeath = new DisplayContent$$ExternalSyntheticLambda44(this);
        this.mDisplayAccessUIDs = new IntArray();
        this.mAllSleepTokens = new ArrayList();
        this.mActiveSizeCompatActivities = new ArraySet();
        this.mTempConfig = new Configuration();
        this.mInEnsureActivitiesVisible = false;
        this.mObricExt = (IObricDisplayContent) ObricImplFactory.getImpl(IObricDisplayContent.class, new Object[]{this});
        this.mUpdateWindowsForAnimator = new DisplayContent$$ExternalSyntheticLambda45(this);
        this.mScheduleToastTimeout = new DisplayContent$$ExternalSyntheticLambda46(this);
        this.mFindFocusedWindow = new DisplayContent$$ExternalSyntheticLambda47(this);
        this.mPerformLayout = new DisplayContent$$ExternalSyntheticLambda48(this);
        this.mPerformLayoutAttached = new DisplayContent$$ExternalSyntheticLambda49(this);
        this.mComputeImeTargetPredicate = new DisplayContent$$ExternalSyntheticLambda37(this);
        this.mApplyPostLayoutPolicy = new DisplayContent$$ExternalSyntheticLambda38(this);
        this.mApplySurfaceChangesTransaction = new DisplayContent$$ExternalSyntheticLambda39(this);
        this.mSysUiContextConfigCallback = new AnonymousClass2(this);
        this.mExt = (IExtDisplayContent) ExtImplFactory.getImpl(IExtDisplayContent.class, new Object[]{this});
        if (this.mWmService.mRoot.getDisplayContent(display.getDisplayId()) != null) goto L26;
        this.mRootWindowContainer = root;
        this.mAtmService = this.mWmService.mAtmService;
        this.mDisplay = display;
        this.mDisplayId = display.getDisplayId();
        this.mCurrentUniqueDisplayId = display.getUniqueId();
        this.mWallpaperController = new WallpaperController(this.mWmService, this);
        this.mWallpaperController.resetLargestDisplay(display);
        display.getDisplayInfo(this.mDisplayInfo);
        display.getMetrics(this.mDisplayMetrics);
        this.mDisplayUpdater = new DeferredDisplayUpdater(this);
        this.mSystemGestureExclusionLimit = (this.mWmService.mConstants.mSystemGestureExclusionLimitDp * this.mDisplayMetrics.densityDpi) / 160;
        if (this.mDisplayId != 0) goto L7;
        boolean r0 = true;
    L8:
        this.isDefaultDisplay = r0;
        this.mInsetsStateController = new InsetsStateController(this);
        initializeDisplayBaseInfo();
        this.mDisplayFrames = new DisplayFrames(this.mInsetsStateController.getRawInsetsState(), this.mDisplayInfo, calculateDisplayCutoutForRotation(this.mDisplayInfo.rotation), calculateRoundedCornersForRotation(this.mDisplayInfo.rotation), calculatePrivacyIndicatorBoundsForRotation(this.mDisplayInfo.rotation), calculateDisplayShapeForRotation(this.mDisplayInfo.rotation));
        this.mHoldScreenWakeLock = this.mWmService.mPowerManager.newWakeLock(536870922, "WindowManager/displayId:" + this.mDisplayId, this.mDisplayId);
        this.mHoldScreenWakeLock.setReferenceCounted(false);
        this.mFixedRotationTransitionListener = new FixedRotationTransitionListener(this, this.mDisplayId);
        this.mTransitionAnimation = new TransitionAnimation(this.mWmService.mContext, false, TAG);
        this.mTransitionController.registerLegacyListener(this.mFixedRotationTransitionListener);
        this.mUnknownAppVisibilityController = new UnknownAppVisibilityController(this.mWmService, this);
        this.mRemoteDisplayChangeController = new RemoteDisplayChangeController(this);
        InputChannel inputChannel = this.mWmService.mInputManager.monitorInput("PointerEventDispatcher" + this.mDisplayId, this.mDisplayId);
        this.mPointerEventDispatcher = new PointerEventDispatcher(inputChannel);
        if (this.mWmService.mAtmService.getRecentTasks() == null) goto L11;
        registerPointerEventListener(this.mWmService.mAtmService.getRecentTasks().getInputListener());
    L11:
        this.mDeviceStateController = deviceStateController;
        this.mAppCompatCameraPolicy = new AppCompatCameraPolicy(this.mWmService, this);
        this.mDisplayPolicy = new DisplayPolicy(this.mWmService, this);
        this.mDisplayRotation = new DisplayRotation(this.mWmService, this, this.mDisplayInfo.address, this.mDeviceStateController, root.getDisplayRotationCoordinator());
        this.mDeviceStateConsumer = new DisplayContent$$ExternalSyntheticLambda40(this);
        this.mDeviceStateController.registerDeviceStateCallback(this.mDeviceStateConsumer, new HandlerExecutor(this.mWmService.mH));
        this.mCloseToSquareMaxAspectRatio = this.mWmService.mContext.getResources().getFloat(R.dimen.datepicker_year_label_height);
        if (this.isDefaultDisplay == false) goto L15;
        this.mWmService.mPolicy.setDefaultDisplay(this);
    L15:
        if (this.mWmService.mDisplayReady == false) goto L18;
        this.mDisplayPolicy.onConfigurationChanged();
    L18:
        if (this.mWmService.mSystemReady == false) goto L20;
        this.mDisplayPolicy.systemReady();
    L20:
        this.mWindowCornerRadius = this.mDisplayPolicy.getWindowCornerRadius();
        this.mPinnedTaskController = new PinnedTaskController(this.mWmService, this);
        this.mDisplayAreaPolicy = this.mWmService.getDisplayAreaPolicyProvider().instantiate(this.mWmService, this, this, this.mImeWindowsContainer);
        SurfaceControl.Transaction pendingTransaction = getPendingTransaction();
        configureSurfaces(pendingTransaction);
        pendingTransaction.apply();
        onDisplayChanged(this);
        updateDisplayAreaOrganizers();
        this.mRotationReversionController = new DisplayRotationReversionController(this);
        this.mInputMonitor = new InputMonitor(this.mWmService, this);
        this.mInsetsPolicy = new InsetsPolicy(this.mInsetsStateController, this);
        this.mMinSizeOfResizeableTaskDp = getMinimalTaskSizeDp();
        if (WindowManagerDebugConfig.DEBUG_DISPLAY == false) goto L23;
        Slog.v(TAG, "Creating display=" + display);
    L23:
        setWindowingMode(1);
        this.mWmService.mDisplayWindowSettings.applySettingsToDisplayLocked(this);
        this.mIgnoreActivitySizeRestrictions = this.mWmService.mDisplayWindowSettings.isIgnoreActivitySizeRestrictionsLocked(this);
        this.mInTouchMode = this.mWmService.mContext.getResources().getBoolean(R.bool.config_defaultWindowFeatureContextMenu);
        this.mWmService.mInputManager.setInTouchMode(this.mInTouchMode, WindowManagerService.MY_PID, WindowManagerService.MY_UID, true, this.mDisplayId);
        this.mAppCompatCameraPolicy.start();
        return;
    L7:
        r0 = false;
        goto L8
    L26:
        throw new IllegalArgumentException("Display with ID=" + display.getDisplayId() + " already exists=" + this.mWmService.mRoot.getDisplayContent(display.getDisplayId()) + " new=" + display);
    }

    private /* synthetic */ void lambda$new$9(DeviceStateController.DeviceState newFoldState) {
        this.mDisplayRotation.foldStateChanged(newFoldState);
    }

    private void beginHoldScreenUpdate() {
        this.mTmpHoldScreenWindow = null;
        this.mObscuringWindow = null;
    }

    private void finishHoldScreenUpdate() {
        if (this.mTmpHoldScreenWindow == null) goto L5;
        boolean hold = true;
    L6:
        if (hold == true) goto L8;
    L10:
        this.mHoldScreenWindow = this.mTmpHoldScreenWindow;
        this.mTmpHoldScreenWindow = null;
        boolean state = this.mHoldScreenWakeLock.isHeld();
        if (hold == state) goto L22;
        if (hold == false) goto L18;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_KEEP_SCREEN_ON_enabled[0] == false) goto L16;
        String protoLogParam0 = String.valueOf(this.mHoldScreenWindow);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, 1959209522588955826L, 0, new Object[]{protoLogParam0});
    L16:
        this.mLastWakeLockHoldingWindow = this.mHoldScreenWindow;
        this.mLastWakeLockObscuringWindow = null;
        this.mHoldScreenWakeLock.acquire();
        return;
    L18:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_KEEP_SCREEN_ON_enabled[0] == false) goto L20;
        String protoLogParam1 = String.valueOf(this.mObscuringWindow);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, 352937214222086717L, 0, new Object[]{protoLogParam1});
    L20:
        this.mLastWakeLockHoldingWindow = null;
        this.mLastWakeLockObscuringWindow = this.mObscuringWindow;
        this.mHoldScreenWakeLock.release();
        return;
    L22:
        return;
    L8:
        if (this.mTmpHoldScreenWindow == this.mHoldScreenWindow) goto L10;
        this.mHoldScreenWakeLock.setWorkSource(new WorkSource(this.mTmpHoldScreenWindow.mSession.mUid, this.mTmpHoldScreenWindow.mSession.mPackageName));
        goto L10
    L5:
        hold = false;
        goto L6
    }

    @Override // com.android.server.wm.WindowContainer
    void migrateToNewSurfaceControl(SurfaceControl.Transaction t) {
        t.remove(this.mSurfaceControl);
        int i = this.mRootWindowContainer.getChildCount() - 1;
    L3:
        if (i < 0) goto L8;
        ContentRecorder recorder = this.mRootWindowContainer.getChildAt(i).mContentRecorder;
        if (recorder == null) goto L7;
        recorder.resetRecordingDisplay(this.mDisplayId);
    L7:
        i = i - 1;
        goto L3
    L8:
        this.mLastSurfacePosition.set(0, 0);
        this.mLastDeltaRotation = 0;
        configureSurfaces(t);
        scheduleAnimation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void configureSurfaces(SurfaceControl.Transaction transaction) {
        SurfaceControl.Builder b = this.mWmService.makeSurfaceBuilder().setOpaque(true).setContainerLayer().setCallsite("DisplayContent");
        this.mSurfaceControl = b.setName(getName()).setContainerLayer().build();
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L9;
        SurfaceControl sc = ((DisplayArea) getChildAt(i)).mSurfaceControl;
        if (sc == null) goto L7;
        transaction.reparent(sc, this.mSurfaceControl);
    L7:
        i = i - 1;
        goto L3
    L9:
        if (this.mOverlayLayer != null) goto L11;
        this.mOverlayLayer = b.setName("Display Overlays").setParent(this.mSurfaceControl).build();
    L13:
        if (this.mInputOverlayLayer != null) goto L15;
        this.mInputOverlayLayer = b.setName("Input Overlays").setParent(this.mSurfaceControl).build();
    L17:
        if (this.mA11yOverlayLayer != null) goto L19;
        this.mA11yOverlayLayer = b.setName("Accessibility Overlays").setParent(this.mSurfaceControl).build();
    L20:
        transaction.setLayerStack(this.mSurfaceControl, this.mDisplayId).show(this.mSurfaceControl).setLayer(this.mOverlayLayer, Integer.MAX_VALUE).show(this.mOverlayLayer).setLayer(this.mInputOverlayLayer, 2147483646).show(this.mInputOverlayLayer).setLayer(this.mA11yOverlayLayer, 2147483645).show(this.mA11yOverlayLayer);
        return;
    L19:
        transaction.reparent(this.mA11yOverlayLayer, this.mSurfaceControl);
        goto L20
    L15:
        transaction.reparent(this.mInputOverlayLayer, this.mSurfaceControl);
        goto L17
    L11:
        transaction.reparent(this.mOverlayLayer, this.mSurfaceControl);
        goto L13
    }

    DisplayRotationReversionController getRotationReversionController() {
        return this.mRotationReversionController;
    }

    boolean isReady() {
        if (this.mWmService.mDisplayReady == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mDisplayReady == false) goto L7;
        return true;
    }

    boolean setInTouchMode(boolean inTouchMode) {
        if (this.mInTouchMode != inTouchMode) goto L6;
        return false;
    L6:
        this.mInTouchMode = inTouchMode;
        return true;
    }

    boolean isInTouchMode() {
        return this.mInTouchMode;
    }

    int getDisplayId() {
        return this.mDisplayId;
    }

    float getWindowCornerRadius() {
        return this.mWindowCornerRadius;
    }

    WindowToken getWindowToken(IBinder binder) {
        return this.mTokenMap.get(binder);
    }

    void addWindowToken(IBinder binder, WindowToken token) {
        DisplayContent dc = this.mWmService.mRoot.getWindowTokenDisplay(token);
        if (dc != null) goto L15;
        if (binder == null) goto L13;
        if (token == null) goto L11;
        this.mTokenMap.put(binder, token);
        if (token.asActivityRecord() != null) goto L16;
        DisplayArea.Tokens da = findAreaForToken(token).asTokens();
        da.addChild(token);
        return;
    L16:
        return;
    L11:
        throw new IllegalArgumentException("Can't map null token to display=" + getName() + " binder=" + binder);
    L13:
        throw new IllegalArgumentException("Can't map token=" + token + " to display=" + getName() + " binder is null");
    L15:
        throw new IllegalArgumentException("Can't map token=" + token + " to display=" + getName() + " already mapped to display=" + dc + " tokens=" + dc.mTokenMap);
    }

    WindowToken removeWindowToken(IBinder binder, boolean animateExit) {
        WindowToken token = this.mTokenMap.remove(binder);
        if (token != null) goto L5;
    L7:
        return token;
    L5:
        if (token.asActivityRecord() != null) goto L7;
        token.setExiting(animateExit);
        goto L7
    }

    SurfaceControl addShellRoot(IWindow client, int shellRootLayer) {
        ShellRoot root = this.mShellRoots.get(shellRootLayer);
        if (root != null) goto L5;
    L9:
        ShellRoot root2 = new ShellRoot(client, this, shellRootLayer);
        SurfaceControl rootLeash = root2.getSurfaceControl();
        if (rootLeash != null) goto L13;
        root2.clear();
        return null;
    L13:
        this.mShellRoots.put(shellRootLayer, root2);
        SurfaceControl out = new SurfaceControl(rootLeash, "DisplayContent.addShellRoot");
        return out;
    L5:
        if (root.getClient() == client) goto L7;
        root.clear();
        this.mShellRoots.remove(shellRootLayer);
        goto L9
    L7:
        return root.getSurfaceControl();
    }

    void removeShellRoot(int windowType) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ShellRoot root = this.mShellRoots.get(windowType);     // Catch: Throwable -> L9
        if (root != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        root.clear();     // Catch: Throwable -> L9
        this.mShellRoots.remove(windowType);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void setRemoteInsetsController(IDisplayWindowInsetsController controller) {
        if (this.mRemoteInsetsControlTarget == null) goto L5;
        RemoteInsetsControlTarget.m9912$$Nest$fgetmRemoteInsetsController(this.mRemoteInsetsControlTarget).asBinder().unlinkToDeath(this.mRemoteInsetsDeath, 0);
        this.mRemoteInsetsControlTarget = null;
    L5:
        if (controller != null) goto L11;
        return;
    L11:
        controller.asBinder().linkToDeath(this.mRemoteInsetsDeath, 0);     // Catch: RemoteException -> L8
        this.mRemoteInsetsControlTarget = new RemoteInsetsControlTarget(this, controller);     // Catch: RemoteException -> L8
        return;
    }

    void reParentWindowToken(WindowToken token) {
        DisplayContent prevDc = token.getDisplayContent();
        if (prevDc != this) goto L5;
        return;
    L5:
        if (prevDc != null) goto L7;
    L11:
        addWindowToken(token.token, token);
        if (this.mWmService.mAccessibilityController.hasCallbacks() == false) goto L18;
        if (prevDc == null) goto L15;
        int prevDisplayId = prevDc.getDisplayId();
    L16:
        this.mWmService.mAccessibilityController.onSomeWindowResizedOrMoved(new int[]{prevDisplayId, getDisplayId()});
        return;
    L15:
        prevDisplayId = -1;
        goto L16
    L18:
        return;
    L7:
        if (prevDc.mTokenMap.remove(token.token) == null) goto L11;
        if (token.asActivityRecord() != null) goto L11;
        token.getParent().removeChild(token);
        goto L11
    }

    void removeAppToken(IBinder binder) {
        WindowToken token = removeWindowToken(binder, true);
        if (token != null) goto L6;
        Slog.w(TAG, "removeAppToken: Attempted to remove non-existing token: " + binder);
        return;
    L6:
        ActivityRecord activity = token.asActivityRecord();
        if (activity != null) goto L10;
        Slog.w(TAG, "Attempted to remove non-App token: " + binder + " token=" + token);
        return;
    L10:
        activity.onRemovedFromDisplay();
        if (activity != this.mFixedRotationLaunchingApp) goto L14;
        activity.finishFixedRotationTransform();
        setFixedRotationLaunchingAppUnchecked(null);
        return;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.DisplayContentInfo
    public Display getDisplay() {
        return this.mDisplay;
    }

    DisplayInfo getDisplayInfo() {
        return this.mDisplayInfo;
    }

    DisplayMetrics getDisplayMetrics() {
        return this.mDisplayMetrics;
    }

    DisplayPolicy getDisplayPolicy() {
        return this.mDisplayPolicy;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.DisplayContentInfo
    public DisplayRotation getDisplayRotation() {
        return this.mDisplayRotation;
    }

    InsetsStateController getInsetsStateController() {
        return this.mInsetsStateController;
    }

    InsetsPolicy getInsetsPolicy() {
        return this.mInsetsPolicy;
    }

    int getRotation() {
        return this.mDisplayRotation.getRotation();
    }

    int getLastOrientation() {
        return this.mDisplayRotation.getLastOrientation();
    }

    WindowContainer getImeParentWindow() {
        return this.mInputMethodSurfaceParentWindow;
    }

    void reconfigureDisplayLocked() {
        if (isReady() == true) goto L5;
        return;
    L5:
        configureDisplayPolicy();
        setLayoutNeeded();
        boolean configChanged = updateOrientation();
        Configuration currentDisplayConfig = getConfiguration();
        this.mTmpConfiguration.setTo(currentDisplayConfig);
        computeScreenConfiguration(this.mTmpConfiguration);
        int changes = currentDisplayConfig.diff(this.mTmpConfiguration);
        if (changes == 0) goto L8;
        boolean r4 = true;
    L10:
        if ((configChanged | r4) == false) goto L20;
        this.mWaitingForConfig = true;
        if (this.mLastHasContent == true) goto L14;
    L19:
        sendNewConfiguration();
        goto L20
    L14:
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L19;
        Rect startBounds = currentDisplayConfig.windowConfiguration.getBounds();
        Rect endBounds = this.mTmpConfiguration.windowConfiguration.getBounds();
        if (this.mTransitionController.isCollecting() == true) goto L18;
        TransitionRequestInfo.DisplayChange change = new TransitionRequestInfo.DisplayChange(this.mDisplayId);
        change.setStartAbsBounds(startBounds);
        change.setEndAbsBounds(endBounds);
        requestChangeTransition(changes, change);
        goto L19
    L18:
        Transition transition = this.mTransitionController.getCollectingTransition();
        transition.setKnownConfigChanges(this, changes);
        this.mTransitionController.setDisplaySyncMethod(startBounds, endBounds, this);
        collectDisplayChange(transition);
    L20:
        this.mWmService.mWindowPlacerLocked.performSurfacePlacement();
        return;
    L8:
        r4 = false;
        goto L10
    }

    boolean sendNewConfiguration() {
        if (isReady() == true) goto L6;
        return false;
    L6:
        if (this.mRemoteDisplayChangeController.isWaitingForRemoteDisplayChange() == false) goto L9;
        return false;
    L9:
        if (this.mTransitionController.isCollecting() == false) goto L11;
        Transition.ReadyCondition displayConfig = new Transition.ReadyCondition("displayConfig", this);
    L12:
        if (displayConfig == null) goto L15;
        this.mTransitionController.waitFor(displayConfig);
    L19:
        boolean configUpdated = updateDisplayOverrideConfigurationLocked();
        if (displayConfig == null) goto L22;
        displayConfig.meet();
    L22:
        if (configUpdated == false) goto L25;
        return true;
    L25:
        clearFixedRotationLaunchingApp();
        if (this.mWaitingForConfig == false) goto L28;
        this.mWaitingForConfig = false;
        setLayoutNeeded();
        this.mWmService.mWindowPlacerLocked.performSurfacePlacement();
    L28:
        return false;
    L15:
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L19;
        if (this.mLastHasContent == false) goto L19;
        Slog.e(TAG, "Display reconfigured outside of a transition: " + this);
        goto L19
    L11:
        displayConfig = null;
        goto L12
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    boolean onDescendantOrientationChanged(WindowContainer requestingContainer) {
        Configuration config = updateOrientationAndComputeConfig(false);
        if (requestingContainer == null) goto L5;
        int orientation = requestingContainer.getOverrideOrientation();
    L6:
        boolean handled = handlesOrientationChangeFromDescendant(orientation);
        if (config != null) goto L9;
        return handled;
    L9:
        if (handled == true) goto L11;
    L16:
        updateDisplayOverrideConfigurationLocked(config, null, false);
    L17:
        return handled;
    L11:
        if ((requestingContainer instanceof ActivityRecord) == false) goto L16;
        ActivityRecord activityRecord = (ActivityRecord) requestingContainer;
        boolean kept = updateDisplayOverrideConfigurationLocked(config, activityRecord, false);
        if (kept == true) goto L17;
        this.mRootWindowContainer.resumeFocusedTasksTopActivities();
        goto L17
    L5:
        orientation = -2;
        goto L6
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    boolean handlesOrientationChangeFromDescendant(int orientation) {
        if (shouldIgnoreOrientationRequest(orientation) == false) goto L5;
    L7:
        return false;
    L5:
        if (getDisplayRotation().isFixedToUserRotation() == true) goto L7;
        return true;
    }

    boolean updateOrientation() {
        return updateOrientation(false);
    }

    Configuration updateOrientationAndComputeConfig(boolean forceUpdate) {
        if (this.mDisplayReady == true) goto L7;
        return null;
    L7:
        if (updateOrientation(forceUpdate) == false) goto L10;
        Configuration config = new Configuration();
        computeScreenConfiguration(config);
        return config;
    L10:
        return null;
    }

    private int getMinimalTaskSizeDp() {
        Resources res = getDisplayUiContext().getResources();
        TypedValue value = new TypedValue();
        res.getValue(R.dimen.indeterminate_progress_alpha_43, value, true);
        int valueUnit = (value.data >> 0) & 15;
        if (value.type != 5) goto L8;
        if (valueUnit != 1) goto L8;
        return (int) TypedValue.complexToFloat(value.data);
    L8:
        throw new IllegalArgumentException("Resource ID #0x" + Integer.toHexString(R.dimen.indeterminate_progress_alpha_43) + " is not in valid type or unit");
    }

    private boolean updateOrientation(boolean forceUpdate) {
        WindowContainer<?> r0 = this.mLastOrientationSource;
        int orientation = getOrientation();
        WindowContainer<?> r2 = getLastOrientationSource();
        if (r2 != r0) goto L5;
    L7:
        if (r2 == null) goto L9;
        ActivityRecord r = r2.asActivityRecord();
    L11:
        if (r == null) goto L26;
        Task task = r.getTask();
        if (task == null) goto L18;
        if (orientation == task.mLastReportedRequestedOrientation) goto L18;
        task.mLastReportedRequestedOrientation = orientation;
        this.mAtmService.getTaskChangeNotificationController().notifyTaskRequestedOrientationChanged(task.mTaskId, orientation);
    L18:
        if (r.isVisibleRequested() == true) goto L20;
        ActivityRecord topCandidate = topRunningActivity();
    L21:
        if (topCandidate == null) goto L26;
        if (handleTopActivityLaunchingInDifferentOrientation(topCandidate, r, true) == false) goto L26;
        return false;
    L20:
        topCandidate = r;
    L26:
        if (getExt().shouldDeferUpdateOrientationForSplit(orientation, getLastOrientation(), forceUpdate, this.mDisplayId) == false) goto L29;
        return false;
    L29:
        return this.mDisplayRotation.updateOrientation(orientation, forceUpdate);
    L9:
        r = null;
        goto L11
    L5:
        if (this.mRotationReversionController.isRotationReversionEnabled() == false) goto L7;
        this.mRotationReversionController.updateForNoSensorOverride();
        goto L7
    }

    private ActivityRecord getLastOrientationSourceApp() {
        WindowContainer<?> orientationSrc = getLastOrientationSource();
        if (orientationSrc != null) goto L7;
        return null;
    L7:
        return orientationSrc.asActivityRecord();
    }

    void applyFixedRotationForNonTopVisibleActivityIfNeeded() {
        if (this.mWmService.mFlags.mRespectNonTopVisibleFixedOrientation == true) goto L5;
        return;
    L5:
        ActivityRecord orientationSrcApp = getLastOrientationSourceApp();
        if (orientationSrcApp != null) goto L8;
        return;
    L8:
        if (orientationSrcApp.fillsParent() == true) goto L16;
        final int topOrientation = orientationSrcApp.getRequestedOrientation();
        if (topOrientation != (-1)) goto L13;
        return;
    L13:
        forAllActivities(new DisplayContent$$ExternalSyntheticLambda26(this, topOrientation), true);
        return;
    }

    private /* synthetic */ boolean lambda$applyFixedRotationForNonTopVisibleActivityIfNeeded$10(int topOrientation, ActivityRecord ar) {
        if (ar.isVisibleRequested() == true) goto L6;
        return true;
    L6:
        applyFixedRotationForNonTopVisibleActivityIfNeeded(ar, topOrientation);
        return false;
    }

    void applyFixedRotationForNonTopVisibleActivityIfNeeded(ActivityRecord ar) {
        if (this.mWmService.mFlags.mRespectNonTopVisibleFixedOrientation == true) goto L5;
        return;
    L5:
        ActivityRecord orientationSrcApp = getLastOrientationSourceApp();
        if (orientationSrcApp == null) goto L9;
        applyFixedRotationForNonTopVisibleActivityIfNeeded(ar, orientationSrcApp.getRequestedOrientation());
        return;
    }

    private void applyFixedRotationForNonTopVisibleActivityIfNeeded(ActivityRecord ar, int topOrientation) {
        if (this.mExt.shouldDeferFixedRotationForNonTopVisibleActivity(ar) == false) goto L5;
        return;
    L5:
        int orientation = ar.getRequestedOrientation();
        if (orientation != 3) goto L10;
        ActivityRecord nextCandidate = getActivityBelowForDefiningOrientation(ar);
        if (nextCandidate == null) goto L10;
        orientation = nextCandidate.getRequestedOrientation();
    L10:
        if (orientation != topOrientation) goto L12;
        return;
    L12:
        if (ar.inMultiWindowMode() == false) goto L14;
        return;
    L14:
        if (ar.getRequestedConfigurationOrientation() == 0) goto L32;
        int displayRotation = getRotation();
        int rotation = this.mDisplayRotation.rotationForOrientation(orientation, displayRotation);
        if (rotation != displayRotation) goto L19;
        return;
    L19:
        startFixedRotationTransform(ar, rotation);
        WindowState wallpaperTarget = this.mWallpaperController.getWallpaperTarget();
        if (wallpaperTarget != null) goto L22;
        return;
    L22:
        if (wallpaperTarget.mActivityRecord != ar) goto L29;
        WindowState wp = this.mWallpaperController.getTopVisibleWallpaper();
        if (wp == null) goto L30;
        wp.mToken.linkFixedRotationTransform(ar);
        return;
    L30:
        return;
    L29:
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isSyncFinished(BLASTSyncEngine.SyncGroup group) {
        return !this.mRemoteDisplayChangeController.isWaitingForRemoteDisplayChange();
    }

    int rotationForActivityInDifferentOrientation(ActivityRecord r) {
        if (this.mTransitionController.useShellTransitionsRotation() == false) goto L5;
        return -1;
    L5:
        int activityOrientation = r.getOverrideOrientation();
        if (WindowManagerService.ENABLE_FIXED_ROTATION_TRANSFORM == true) goto L8;
    L25:
        return -1;
    L8:
        if (shouldIgnoreOrientationRequest(activityOrientation) == true) goto L25;
        if (activityOrientation != 3) goto L16;
        ActivityRecord nextCandidate = getActivityBelowForDefiningOrientation(r);
        if (nextCandidate == null) goto L16;
        r = nextCandidate;
        activityOrientation = r.getOverrideOrientation();
    L16:
        if (r.inMultiWindowMode() == false) goto L18;
    L24:
        return -1;
    L18:
        if (r.getRequestedConfigurationOrientation(true, activityOrientation) == getConfiguration().orientation) goto L24;
        int currentRotation = getRotation();
        int rotation = this.mDisplayRotation.rotationForOrientation(activityOrientation, currentRotation);
        if (rotation != currentRotation) goto L23;
        return -1;
    L23:
        return rotation;
    }

    boolean handleTopActivityLaunchingInDifferentOrientation(ActivityRecord r, boolean checkOpening) {
        return handleTopActivityLaunchingInDifferentOrientation(r, r, checkOpening);
    }

    private boolean handleTopActivityLaunchingInDifferentOrientation(ActivityRecord r, ActivityRecord orientationSrc, boolean checkOpening) {
        if (WindowManagerService.ENABLE_FIXED_ROTATION_TRANSFORM == true) goto L6;
        return false;
    L6:
        if (r.isFinishingFixedRotationTransform() == false) goto L9;
        return false;
    L9:
        if (r.hasFixedRotationTransform() == false) goto L26;
        if (this.mWmService.mFlags.mRespectNonTopVisibleFixedOrientation == true) goto L13;
    L24:
        return true;
    L13:
        if (this.mFixedRotationLaunchingApp != null) goto L15;
    L23:
        setFixedRotationLaunchingAppUnchecked(r, r.getWindowConfiguration().getDisplayRotation());
        goto L24
    L15:
        if (r == this.mFixedRotationLaunchingApp) goto L24;
        if (r.occludesParent() == false) goto L24;
        if (r.getTask() == null) goto L24;
        if (r != r.getTask().topRunningActivity()) goto L24;
    L26:
        if (this.mWmService.mFlags.mRespectNonTopVisibleFixedOrientation == false) goto L31;
        if (r.isReportedDrawn() == false) goto L35;
        return false;
    L35:
        if (checkOpening == false) goto L47;
        if (this.mTransitionController.isCollecting(r) == true) goto L40;
        return false;
    L40:
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L50;
        if (r.getTask().mInResumeTopActivity == true) goto L50;
        if (getExt().hasRemoteTransition() == true) goto L50;
        return false;
    L50:
        if (this.mLastWallpaperVisible == true) goto L52;
    L56:
        int rotation = rotationForActivityInDifferentOrientation(orientationSrc);
        if (rotation != (-1)) goto L60;
        return false;
    L60:
        if (r.getDisplayArea().matchParentBounds() == true) goto L62;
        return false;
    L62:
        setFixedRotationLaunchingApp(r, rotation);
        return true;
    L52:
        if (r.windowsCanBeWallpaperTarget() == false) goto L56;
        if (this.mTransitionController.isTransientLaunch(r) == true) goto L56;
        return false;
    L47:
        if (r == topRunningActivity()) goto L50;
        return false;
    L31:
        if (r.occludesParent() == true) goto L33;
    L64:
        return false;
    L33:
        if (r.isReportedDrawn() == false) goto L35;
        goto L35
    }

    boolean hasTopFixedRotationLaunchingApp() {
        if (this.mFixedRotationLaunchingApp == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasFixedRotationTransientLaunch() {
        if (this.mFixedRotationLaunchingApp != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mTransitionController.isTransientLaunch(this.mFixedRotationLaunchingApp) == false) goto L7;
        return true;
    }

    boolean isFixedRotationLaunchingApp(ActivityRecord r) {
        if (this.mFixedRotationLaunchingApp != r) goto L5;
        return true;
    L5:
        return false;
    }

    AsyncRotationController getAsyncRotationController() {
        return this.mAsyncRotationController;
    }

    void setFixedRotationLaunchingAppUnchecked(ActivityRecord r) {
        setFixedRotationLaunchingAppUnchecked(r, -1);
    }

    void setFixedRotationLaunchingAppUnchecked(ActivityRecord r, int rotation) {
        if (this.mFixedRotationLaunchingApp != null) goto L8;
        if (r == null) goto L8;
        this.mWmService.mDisplayNotificationController.dispatchFixedRotationStarted(this, rotation);
        boolean shouldDebounce = this.mTransitionController.isTransientLaunch(r);
        startAsyncRotation(shouldDebounce);
    L13:
        Slog.d(TAG, "setFixedRotationLaunchingAppUnchecked, " + r + ", caller:" + Debug.getCallers(3));
        this.mFixedRotationLaunchingApp = r;
        return;
    L8:
        if (this.mFixedRotationLaunchingApp == null) goto L13;
        if (r != null) goto L13;
        this.mWmService.mDisplayNotificationController.dispatchFixedRotationFinished(this);
        if (this.mTransitionController.hasCollectingRotationChange(this, getRotation()) == true) goto L13;
        finishAsyncRotationIfPossible();
        goto L13
    }

    void setFixedRotationLaunchingApp(ActivityRecord r, int rotation) {
        ActivityRecord prevRotatedLaunchingApp = this.mFixedRotationLaunchingApp;
        if (prevRotatedLaunchingApp == r) goto L5;
    L7:
        if (prevRotatedLaunchingApp == null) goto L15;
        if (prevRotatedLaunchingApp.getWindowConfiguration().getRotation() != rotation) goto L15;
        if (prevRotatedLaunchingApp.isInTransition() == false) goto L15;
        r.linkFixedRotationTransform(prevRotatedLaunchingApp);
        setFixedRotationLaunchingAppUnchecked(r, rotation);
        return;
    L15:
        if (r.hasFixedRotationTransform() == true) goto L17;
        startFixedRotationTransform(r, rotation);
    L17:
        setFixedRotationLaunchingAppUnchecked(r, rotation);
        if (prevRotatedLaunchingApp == null) goto L21;
        prevRotatedLaunchingApp.finishFixedRotationTransform();
        return;
    L21:
        return;
    L5:
        if (r.getWindowConfiguration().getRotation() != rotation) goto L7;
    }

    void continueUpdateOrientationForDiffOrienLaunchingApp() {
        if (this.mFixedRotationLaunchingApp != null) goto L6;
        return;
    L6:
        if (this.mPinnedTaskController.shouldDeferOrientationChange() == false) goto L9;
        return;
    L9:
        if (this.mDisplayRotation.updateOrientation(getOrientation(), false) == false) goto L15;
        if (this.mTransitionController.isCollecting(this) == true) goto L19;
        sendNewConfiguration();
        return;
    L19:
        return;
    L15:
        if (this.mRemoteDisplayChangeController.isWaitingForRemoteDisplayChange() == false) goto L17;
        return;
    L17:
        clearFixedRotationLaunchingApp();
    }

    private void clearFixedRotationLaunchingApp() {
        if (this.mFixedRotationLaunchingApp != null) goto L5;
        return;
    L5:
        this.mFixedRotationLaunchingApp.finishFixedRotationTransform();
        setFixedRotationLaunchingAppUnchecked(null);
    }

    private void startFixedRotationTransform(WindowToken token, int rotation) {
        this.mTmpConfiguration.unset();
        DisplayInfo info = computeScreenConfiguration(this.mTmpConfiguration, rotation);
        DisplayCutout cutout = calculateDisplayCutoutForRotation(rotation);
        RoundedCorners roundedCorners = calculateRoundedCornersForRotation(rotation);
        PrivacyIndicatorBounds indicatorBounds = calculatePrivacyIndicatorBoundsForRotation(rotation);
        DisplayShape displayShape = calculateDisplayShapeForRotation(rotation);
        DisplayFrames displayFrames = new DisplayFrames(new InsetsState(), info, cutout, roundedCorners, indicatorBounds, displayShape);
        token.applyFixedRotationTransform(info, displayFrames, this.mTmpConfiguration);
    }

    void rotateInDifferentOrientationIfNeeded(ActivityRecord activityRecord) {
        int rotation = rotationForActivityInDifferentOrientation(activityRecord);
        if (rotation == (-1)) goto L6;
        startFixedRotationTransform(activityRecord, rotation);
        return;
    }

    boolean isRotationChanging() {
        if (this.mDisplayRotation.getRotation() == getWindowConfiguration().getRotation()) goto L5;
        return true;
    L5:
        return false;
    }

    private void startAsyncRotationIfNeeded() {
        if (isRotationChanging() == false) goto L6;
        startAsyncRotation(false);
        return;
    }

    private boolean startAsyncRotation(boolean shouldDebounce) {
        if (shouldDebounce == false) goto L7;
        this.mWmService.mH.postDelayed(new DisplayContent$$ExternalSyntheticLambda24(this), FIXED_ROTATION_HIDE_ANIMATION_DEBOUNCE_DELAY_MS);
        return false;
    L7:
        if (this.mAsyncRotationController != null) goto L10;
        this.mAsyncRotationController = new AsyncRotationController(this);
        this.mAsyncRotationController.start();
        return true;
    L10:
        return false;
    }

    private /* synthetic */ void lambda$startAsyncRotation$11() {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mFixedRotationLaunchingApp != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        if (startAsyncRotation(false) == false) goto L11;
        getPendingTransaction().apply();     // Catch: Throwable -> L9
        goto L11
    }

    void finishAsyncRotationIfPossible() {
        AsyncRotationController controller = this.mAsyncRotationController;
        if (controller == null) goto L6;
        controller.completeAll();
        this.mAsyncRotationController = null;
        return;
    }

    void finishAsyncRotation(WindowToken windowToken) {
        AsyncRotationController controller = this.mAsyncRotationController;
        if (controller != null) goto L5;
        return;
    L5:
        if (controller.completeRotation(windowToken) == false) goto L9;
        this.mAsyncRotationController = null;
        return;
    }

    void notifyInsetsChanged(Consumer<WindowState> dispatchInsetsChanged) {
        if (this.mFixedRotationLaunchingApp == null) goto L7;
        InsetsState rotatedState = this.mFixedRotationLaunchingApp.getFixedRotationTransformInsetsState();
        if (rotatedState == null) goto L7;
        InsetsState state = this.mInsetsStateController.getRawInsetsState();
        InsetsState.traverse(rotatedState, state, COPY_SOURCE_VISIBILITY);
    L7:
        boolean isImeShow = true;
        forAllWindows(dispatchInsetsChanged, true);
        if (this.mRemoteInsetsControlTarget == null) goto L11;
        this.mRemoteInsetsControlTarget.notifyInsetsChanged();
    L11:
        if (this.mWmService.mAccessibilityController.hasCallbacks() == true) goto L13;
        return;
    L13:
        if (this.mImeControlTarget != null) goto L15;
    L17:
        isImeShow = false;
    L18:
        this.mWmService.mAccessibilityController.updateImeVisibilityIfNeeded(this.mDisplayId, isImeShow);
        return;
    L15:
        if (this.mImeControlTarget.isRequestedVisible(WindowInsets.Type.ime()) == false) goto L17;
        goto L17
    }

    boolean updateRotationUnchecked() {
        return this.mDisplayRotation.updateRotationUnchecked(false);
    }

    boolean canShowTasksInHostDeviceRecents() {
        if (this.mDwpcHelper != null) goto L7;
        return true;
    L7:
        return this.mDwpcHelper.canShowTasksInHostDeviceRecents();
    }

    ComponentName getCustomHomeComponent() {
        if (isHomeSupported() == true) goto L5;
        return null;
    L5:
        if (this.mDwpcHelper != null) goto L8;
        return null;
    L8:
        return this.mDwpcHelper.getCustomHomeComponent();
    }

    private void applyRotation(int oldRotation, int rotation) {
        this.mDisplayRotation.applyCurrentRotation(rotation);
        updateDisplayAndOrientation(null);
        setFixedTransformHint(getPendingTransaction(), this.mSurfaceControl, rotation);
        getSyncTransaction().unsetFixedTransformHint(this.mSurfaceControl);
        scheduleAnimation();
        this.mWmService.mRotationWatcherController.dispatchDisplayRotationChange(this.mDisplayId, rotation);
    }

    void setFixedTransformHint(SurfaceControl.Transaction t, SurfaceControl sc, int rotation) {
        t.setFixedTransformHint(sc, (this.mDisplayInfo.installOrientation + rotation) % 4);
    }

    void configureDisplayPolicy() {
        this.mRootWindowContainer.updateDisplayImePolicyCache();
        this.mDisplayPolicy.updateConfigurationAndScreenSizeDependentBehaviors();
        this.mDisplayRotation.configure(this.mBaseDisplayWidth, this.mBaseDisplayHeight);
    }

    private DisplayInfo updateDisplayAndOrientation(Configuration outConfig) {
        int rotation = getRotation();
        boolean r1 = true;
        if (rotation != 1) goto L5;
    L8:
        boolean rotated = r1;
        if (rotated == false) goto L12;
        int r2 = this.mBaseDisplayHeight;
    L11:
        int dw = r2;
        if (rotated == false) goto L16;
        int r3 = this.mBaseDisplayWidth;
    L15:
        int dh = r3;
        DisplayCutout displayCutout = calculateDisplayCutoutForRotation(rotation);
        RoundedCorners roundedCorners = calculateRoundedCornersForRotation(rotation);
        DisplayShape displayShape = calculateDisplayShapeForRotation(rotation);
        Rect appFrame = this.mDisplayPolicy.getDecorInsetsInfo(rotation, dw, dh).mNonDecorFrame;
        this.mDisplayInfo.rotation = rotation;
        this.mDisplayInfo.logicalWidth = dw;
        this.mDisplayInfo.logicalHeight = dh;
        this.mDisplayInfo.logicalDensityDpi = this.mBaseDisplayDensity;
        this.mDisplayInfo.physicalXDpi = this.mBaseDisplayPhysicalXDpi;
        this.mDisplayInfo.physicalYDpi = this.mBaseDisplayPhysicalYDpi;
        this.mDisplayInfo.appWidth = appFrame.width();
        this.mDisplayInfo.appHeight = appFrame.height();
        DisplayCutout r4 = null;
        if (this.isDefaultDisplay == false) goto L20;
        this.mDisplayInfo.getLogicalMetrics(this.mRealDisplayMetrics, CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, null);
    L20:
        DisplayInfo r5 = this.mDisplayInfo;
        if (displayCutout.isEmpty() == true) goto L24;
        r4 = displayCutout;
    L24:
        r5.displayCutout = r4;
        this.mDisplayInfo.roundedCorners = roundedCorners;
        this.mDisplayInfo.displayShape = displayShape;
        this.mDisplayInfo.getAppMetrics(this.mDisplayMetrics);
        if (this.mDisplayScalingDisabled == false) goto L27;
        this.mDisplayInfo.flags |= 1073741824;
    L28:
        computeSizeRanges(this.mDisplayInfo, rotated, dw, dh, this.mDisplayMetrics.density, outConfig, false);
        setDisplayInfoOverride();
        if (this.isDefaultDisplay == false) goto L31;
        this.mCompatibleScreenScale = CompatibilityInfo.computeCompatibleScaling(this.mDisplayMetrics, this.mCompatDisplayMetrics);
    L31:
        onDisplayInfoChanged();
        return this.mDisplayInfo;
    L27:
        this.mDisplayInfo.flags &= -1073741825;
        goto L28
    L16:
        r3 = this.mBaseDisplayHeight;
        goto L15
    L12:
        r2 = this.mBaseDisplayWidth;
        goto L11
    L5:
        if (rotation == 3) goto L8;
        r1 = false;
        goto L8
    }

    private void setDisplayInfoOverride() {
        this.mWmService.mDisplayManagerInternal.setDisplayInfoOverrideFromWindowManager(this.mDisplayId, this.mDisplayInfo);
        if (this.mLastDisplayInfoOverride != null) goto L5;
        this.mLastDisplayInfoOverride = new DisplayInfo();
    L5:
        this.mLastDisplayInfoOverride.copyFrom(this.mDisplayInfo);
    }

    DisplayCutout calculateDisplayCutoutForRotation(int rotation) {
        DisplayCutout cutout = this.mObricExt.calculateDisplayCutoutForRotation(rotation);
        if (cutout == null) goto L5;
        return cutout;
    L5:
        RotationCache<DisplayCutout, WmDisplayCutout> r0 = this.mDisplayCutoutCache;
        if (this.mIsSizeForced == false) goto L8;
        DisplayCutout r1 = this.mBaseDisplayCutout;
    L10:
        return r0.getOrCompute(r1, rotation).getDisplayCutout();
    L8:
        r1 = this.mInitialDisplayCutout;
        goto L10
    }

    static WmDisplayCutout calculateDisplayCutoutForRotationAndDisplaySizeUncached(DisplayCutout cutout, int rotation, int displayWidth, int displayHeight) {
        if (cutout == null) goto L27;
        if (cutout == DisplayCutout.NO_CUTOUT) goto L27;
        if (displayWidth != displayHeight) goto L9;
        Slog.w(TAG, "Ignore cutout because display size is square: " + displayWidth);
        return WmDisplayCutout.NO_CUTOUT;
    L9:
        if (rotation == 0) goto L11;
        boolean rotated = false;
        DisplayCutout rotatedCutout = cutout.getRotated(displayWidth, displayHeight, 0, rotation);
        if (rotation != 1) goto L15;
    L16:
        rotated = true;
    L18:
        if (rotated == false) goto L20;
        int r4 = displayHeight;
    L21:
        if (rotated == false) goto L23;
        int r5 = displayWidth;
    L25:
        return new WmDisplayCutout(rotatedCutout, new Size(r4, r5));
    L23:
        r5 = displayHeight;
        goto L25
    L20:
        r4 = displayWidth;
        goto L21
    L15:
        if (rotation != 3) goto L18;
    L11:
        return WmDisplayCutout.computeSafeInsets(cutout, displayWidth, displayHeight);
    L27:
        return WmDisplayCutout.NO_CUTOUT;
    }

    private WmDisplayCutout calculateDisplayCutoutForRotationUncached(DisplayCutout cutout, int rotation) {
        if (this.mIsSizeForced == false) goto L5;
        int r0 = this.mBaseDisplayWidth;
    L7:
        if (this.mIsSizeForced == false) goto L9;
        int r1 = this.mBaseDisplayHeight;
    L11:
        return calculateDisplayCutoutForRotationAndDisplaySizeUncached(cutout, rotation, r0, r1);
    L9:
        r1 = this.mInitialDisplayHeight;
        goto L11
    L5:
        r0 = this.mInitialDisplayWidth;
        goto L7
    }

    RoundedCorners calculateRoundedCornersForRotation(int rotation) {
        RotationCache<RoundedCorners, RoundedCorners> r0 = this.mRoundedCornerCache;
        if (this.mIsSizeForced == false) goto L5;
        RoundedCorners r1 = this.mBaseRoundedCorners;
    L7:
        return r0.getOrCompute(r1, rotation);
    L5:
        r1 = this.mInitialRoundedCorners;
        goto L7
    }

    private RoundedCorners calculateRoundedCornersForRotationUncached(RoundedCorners roundedCorners, int rotation) {
        if (roundedCorners == null) goto L19;
        if (roundedCorners == RoundedCorners.NO_ROUNDED_CORNERS) goto L19;
        if (rotation != 0) goto L9;
        return roundedCorners;
    L9:
        if (this.mIsSizeForced == false) goto L11;
        int r0 = this.mBaseDisplayWidth;
    L13:
        if (this.mIsSizeForced == false) goto L15;
        int r1 = this.mBaseDisplayHeight;
    L17:
        return roundedCorners.rotate(rotation, r0, r1);
    L15:
        r1 = this.mInitialDisplayHeight;
        goto L17
    L11:
        r0 = this.mInitialDisplayWidth;
    L19:
        return RoundedCorners.NO_ROUNDED_CORNERS;
    }

    PrivacyIndicatorBounds calculatePrivacyIndicatorBoundsForRotation(int rotation) {
        return this.mPrivacyIndicatorBoundsCache.getOrCompute(this.mCurrentPrivacyIndicatorBounds, rotation);
    }

    private PrivacyIndicatorBounds calculatePrivacyIndicatorBoundsForRotationUncached(PrivacyIndicatorBounds bounds, int rotation) {
        if (bounds != null) goto L6;
        return new PrivacyIndicatorBounds(new Rect[4], rotation);
    L6:
        return bounds.rotate(rotation);
    }

    DisplayShape calculateDisplayShapeForRotation(int rotation) {
        return this.mDisplayShapeCache.getOrCompute(this.mInitialDisplayShape, rotation);
    }

    private DisplayShape calculateDisplayShapeForRotationUncached(DisplayShape displayShape, int rotation) {
        if (displayShape == null) goto L4;
        if (rotation != 0) goto L8;
        return displayShape;
    L8:
        return displayShape.setRotation(rotation);
    L4:
        return DisplayShape.NONE;
    }

    DisplayInfo computeScreenConfiguration(Configuration outConfig, int rotation) {
        boolean r1 = true;
        if (rotation != 1) goto L5;
    L8:
        boolean rotated = r1;
        if (rotated == false) goto L12;
        int r2 = this.mBaseDisplayHeight;
    L11:
        int dw = r2;
        if (rotated == false) goto L16;
        int r3 = this.mBaseDisplayWidth;
    L15:
        int dh = r3;
        outConfig.windowConfiguration.setMaxBounds(0, 0, dw, dh);
        outConfig.windowConfiguration.setBounds(outConfig.windowConfiguration.getMaxBounds());
        computeScreenAppConfiguration(outConfig, dw, dh, rotation);
        DisplayInfo displayInfo = new DisplayInfo(this.mDisplayInfo);
        displayInfo.rotation = rotation;
        displayInfo.logicalWidth = dw;
        displayInfo.logicalHeight = dh;
        Rect appBounds = outConfig.windowConfiguration.getAppBounds();
        displayInfo.appWidth = appBounds.width();
        displayInfo.appHeight = appBounds.height();
        DisplayCutout displayCutout = calculateDisplayCutoutForRotation(rotation);
        if (displayCutout.isEmpty() == false) goto L20;
        DisplayCutout r4 = null;
    L21:
        displayInfo.displayCutout = r4;
        computeSizeRanges(displayInfo, rotated, dw, dh, this.mDisplayMetrics.density, outConfig, false);
        return displayInfo;
    L20:
        r4 = displayCutout;
        goto L21
    L16:
        r3 = this.mBaseDisplayHeight;
        goto L15
    L12:
        r2 = this.mBaseDisplayWidth;
        goto L11
    L5:
        if (rotation == 3) goto L8;
        r1 = false;
        goto L8
    }

    private void computeScreenAppConfiguration(Configuration outConfig, int dw, int dh, int rotation) {
        DisplayPolicy.DecorInsets.Info info = this.mDisplayPolicy.getDecorInsetsInfo(rotation, dw, dh);
        outConfig.windowConfiguration.setAppBounds(info.mNonDecorFrame);
        outConfig.windowConfiguration.setRotation(rotation);
        float density = this.mDisplayMetrics.density;
        outConfig.screenWidthDp = (int) ((info.mConfigFrame.width() / density) + 0.5f);
        outConfig.screenHeightDp = (int) ((info.mConfigFrame.height() / density) + 0.5f);
        outConfig.compatScreenWidthDp = (int) (outConfig.screenWidthDp / this.mCompatibleScreenScale);
        outConfig.compatScreenHeightDp = (int) (outConfig.screenHeightDp / this.mCompatibleScreenScale);
        boolean rotated = true;
        if (outConfig.screenWidthDp > outConfig.screenHeightDp) goto L5;
        int r2 = 1;
    L6:
        outConfig.orientation = r2;
        outConfig.screenLayout = WindowContainer.computeScreenLayout(Configuration.resetScreenLayout(outConfig.screenLayout), outConfig.screenWidthDp, outConfig.screenHeightDp);
        if (rotation != 1) goto L9;
    L12:
        outConfig.compatSmallestScreenWidthDp = computeCompatSmallestWidth(rotated, dw, dh);
        outConfig.windowConfiguration.setDisplayRotation(rotation);
        return;
    L9:
        if (rotation == 3) goto L12;
        rotated = false;
        goto L12
    L5:
        r2 = 2;
        goto L6
    }

    void computeScreenConfiguration(Configuration config) {
        DisplayInfo displayInfo = updateDisplayAndOrientation(config);
        int dw = displayInfo.logicalWidth;
        int dh = displayInfo.logicalHeight;
        this.mTmpRect.set(0, 0, dw, dh);
        config.windowConfiguration.setBounds(this.mTmpRect);
        config.windowConfiguration.setMaxBounds(this.mTmpRect);
        config.windowConfiguration.setWindowingMode(getWindowingMode());
        computeScreenAppConfiguration(config, dw, dh, displayInfo.rotation);
        int r5 = config.screenLayout & (-769);
        if ((displayInfo.flags & 16) == 0) goto L5;
        int r7 = 512;
    L6:
        config.screenLayout = r5 | r7;
        config.densityDpi = displayInfo.logicalDensityDpi;
        if (displayInfo.isHdr() == true) goto L9;
    L11:
        int r6 = 4;
    L12:
        int r9 = 1;
        if (displayInfo.isWideColorGamut() == true) goto L15;
    L17:
        int r8 = 1;
    L18:
        config.colorMode = r6 | r8;
        config.touchscreen = 1;
        config.keyboard = 1;
        config.navigation = 1;
        this.mObricExt.calculateScreenConfiguration(config);
        int keyboardPresence = 0;
        int navigationPresence = 0;
        InputDevice[] devices = this.mWmService.mInputManager.getInputDevices();
        if (devices == null) goto L21;
        int len = devices.length;
    L22:
        int i = 0;
    L23:
        if (i >= len) goto L57;
        InputDevice device = devices[i];
        if (device.isVirtual() == true) goto L55;
        if (this.mWmService.mInputManager.canDispatchToDisplay(device.getId(), this.mDisplayId) == false) goto L55;
        int sources = device.getSources();
        if (device.isExternal() == false) goto L33;
        int presenceFlag = 2;
    L35:
        if (this.mWmService.mIsTouchDevice == true) goto L37;
        config.touchscreen = 1;
    L41:
        if (getExt().isObricVirtualDisplay() == false) goto L44;
        config.touchscreen = 3;
    L44:
        if ((sources & 65540) != 65540) goto L47;
        config.navigation = 3;
        navigationPresence = navigationPresence | presenceFlag;
        int r10 = 2;
    L53:
        if (device.getKeyboardType() != r10) goto L55;
        config.keyboard = r10;
        keyboardPresence = keyboardPresence | presenceFlag;
        goto L55
    L47:
        if ((sources & 513) == 513) goto L49;
    L51:
        r10 = 2;
        goto L53
    L49:
        if (config.navigation != 1) goto L51;
        r10 = 2;
        config.navigation = 2;
        navigationPresence = navigationPresence | presenceFlag;
        goto L53
    L37:
        if ((sources & UsbACInterface.FORMAT_II_AC3) != 4098) goto L41;
        config.touchscreen = 3;
        goto L41
    L33:
        presenceFlag = r9;
    L55:
        i = i + 1;
        r9 = 1;
        goto L23
    L57:
        if (config.navigation != 1) goto L62;
        if (this.mWmService.mHasPermanentDpad == false) goto L62;
        config.navigation = 2;
        navigationPresence = navigationPresence | 1;
    L62:
        if (config.keyboard == 1) goto L64;
        boolean hardKeyboardAvailable = true;
    L66:
        if (hardKeyboardAvailable == this.mWmService.mHardKeyboardAvailable) goto L68;
        this.mWmService.mHardKeyboardAvailable = hardKeyboardAvailable;
        this.mWmService.mH.removeMessages(22);
        this.mWmService.mH.sendEmptyMessage(22);
    L68:
        this.mDisplayPolicy.updateConfigurationAndScreenSizeDependentBehaviors();
        config.keyboardHidden = 1;
        config.hardKeyboardHidden = 1;
        config.navigationHidden = 1;
        this.mWmService.mPolicy.adjustConfigurationLw(config, keyboardPresence, navigationPresence);
        return;
    L64:
        hardKeyboardAvailable = false;
        goto L66
    L21:
        len = 0;
        goto L22
    L15:
        if (this.mWmService.hasWideColorGamutSupport() == false) goto L17;
        r8 = 2;
        goto L18
    L9:
        if (this.mWmService.hasHdrSupport() == false) goto L11;
        r6 = 8;
        goto L12
    L5:
        r7 = 256;
        goto L6
    }

    private int computeCompatSmallestWidth(boolean rotated, int dw, int dh) {
        this.mTmpDisplayMetrics.setTo(this.mDisplayMetrics);
        DisplayMetrics tmpDm = this.mTmpDisplayMetrics;
        if (rotated == false) goto L5;
        int unrotDw = dh;
        int unrotDh = dw;
    L6:
        int sw = reduceCompatConfigWidthSize(0, 0, tmpDm, unrotDw, unrotDh);
        int unrotDh2 = unrotDh;
        int unrotDh3 = unrotDw;
        return reduceCompatConfigWidthSize(reduceCompatConfigWidthSize(reduceCompatConfigWidthSize(sw, 1, tmpDm, unrotDh2, unrotDh3), 2, tmpDm, unrotDh3, unrotDh2), 3, tmpDm, unrotDh2, unrotDh3);
    L5:
        unrotDw = dw;
        unrotDh = dh;
        goto L6
    }

    private int reduceCompatConfigWidthSize(int curSize, int rotation, DisplayMetrics dm, int dw, int dh) {
        Rect nonDecorSize = this.mDisplayPolicy.getDecorInsetsInfo(rotation, dw, dh).mNonDecorFrame;
        dm.noncompatWidthPixels = nonDecorSize.width();
        dm.noncompatHeightPixels = nonDecorSize.height();
        float scale = CompatibilityInfo.computeCompatibleScaling(dm, null);
        int size = (int) (((dm.noncompatWidthPixels / scale) / dm.density) + 0.5f);
        if (curSize == 0) goto L6;
        if (size < curSize) goto L6;
        return curSize;
    L6:
        return size;
    }

    void computeSizeRanges(DisplayInfo displayInfo, boolean rotated, int dw, int dh, float density, Configuration outConfig, boolean overrideConfig) {
        if (ActivityStarterHook.CAR_DISPLAY_NAME.equals(this.mDisplayInfo.name) == false) goto L5;
        boolean overrideConfig2 = false;
    L6:
        if (rotated == false) goto L8;
        int unrotDw = dh;
        int unrotDh = dw;
    L9:
        displayInfo.smallestNominalAppWidth = 1073741824;
        displayInfo.smallestNominalAppHeight = 1073741824;
        displayInfo.largestNominalAppWidth = 0;
        displayInfo.largestNominalAppHeight = 0;
        adjustDisplaySizeRanges(displayInfo, 0, unrotDw, unrotDh, overrideConfig2);
        int unrotDh2 = unrotDh;
        int unrotDh3 = unrotDw;
        adjustDisplaySizeRanges(displayInfo, 1, unrotDh2, unrotDh3, overrideConfig2);
        adjustDisplaySizeRanges(displayInfo, 2, unrotDh3, unrotDh2, overrideConfig2);
        adjustDisplaySizeRanges(displayInfo, 3, unrotDh2, unrotDh3, overrideConfig2);
        if (outConfig != null) goto L12;
        return;
    L12:
        outConfig.smallestScreenWidthDp = (int) ((displayInfo.smallestNominalAppWidth / density) + 0.5f);
        return;
    L8:
        unrotDw = dw;
        unrotDh = dh;
        goto L9
    L5:
        overrideConfig2 = overrideConfig;
        goto L6
    }

    private void adjustDisplaySizeRanges(DisplayInfo displayInfo, int rotation, int dw, int dh, boolean overrideConfig) {
        DisplayPolicy.DecorInsets.Info info = this.mDisplayPolicy.getDecorInsetsInfo(rotation, dw, dh);
        if (overrideConfig == true) goto L5;
        int w = info.mConfigFrame.width();
        int h = info.mConfigFrame.height();
    L7:
        if (w >= displayInfo.smallestNominalAppWidth) goto L10;
        displayInfo.smallestNominalAppWidth = w;
    L10:
        if (w <= displayInfo.largestNominalAppWidth) goto L13;
        displayInfo.largestNominalAppWidth = w;
    L13:
        if (h >= displayInfo.smallestNominalAppHeight) goto L16;
        displayInfo.smallestNominalAppHeight = h;
    L16:
        if (h <= displayInfo.largestNominalAppHeight) goto L19;
        displayInfo.largestNominalAppHeight = h;
        return;
    L19:
        return;
    L5:
        w = info.mOverrideConfigFrame.width();
        h = info.mOverrideConfigFrame.height();
        goto L7
    }

    int getPreferredOptionsPanelGravity() {
        int rotation = getRotation();
        if (this.mInitialDisplayWidth >= this.mInitialDisplayHeight) goto L9;
        switch(rotation) {
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L5;
        };
    L5:
        return 81;
    L6:
        return 8388691;
    L7:
        return 81;
    L8:
        return 85;
    L9:
        switch(rotation) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            default: goto L10;
        };
    L10:
        return 85;
    L11:
        return 81;
    L12:
        return 8388691;
    L13:
        return 81;
    }

    PinnedTaskController getPinnedTaskController() {
        return this.mPinnedTaskController;
    }

    boolean hasAccess(int uid) {
        if (this.mDisplay.hasAccess(uid) == true) goto L6;
        return false;
    L6:
        if (this.mVisibleBackgroundUserEnabled == true) goto L9;
        return true;
    L9:
        if (isPrivate() == false) goto L11;
        return true;
    L11:
        int userId = UserHandle.getUserId(uid);
        if (userId == 0) goto L16;
        if (this.mWmService.mUmInternal.isUserVisible(userId, this.mDisplayId) == true) goto L16;
        return false;
    L16:
        return true;
    }

    boolean isPrivate() {
        if ((this.mDisplay.getFlags() & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isTrusted() {
        return this.mDisplay.isTrusted();
    }

    Task getRootTask(final int windowingMode, final int activityType) {
        return (Task) getItemFromTaskDisplayAreas(new DisplayContent$$ExternalSyntheticLambda32(windowingMode, activityType));
    }

    private static /* synthetic */ Task lambda$getRootTask$12(int windowingMode, int activityType, TaskDisplayArea taskDisplayArea) {
        return taskDisplayArea.getRootTask(windowingMode, activityType);
    }

    private static /* synthetic */ boolean lambda$getRootTask$13(int rootTaskId, Task rootTask) {
        if (rootTask.getRootTaskId() != rootTaskId) goto L5;
        return true;
    L5:
        return false;
    }

    Task getRootTask(final int rootTaskId) {
        return getRootTask(new DisplayContent$$ExternalSyntheticLambda14(rootTaskId));
    }

    int getRootTaskCount() {
        final int[] count = new int[1];
        forAllRootTasks(new DisplayContent$$ExternalSyntheticLambda19(count));
        return count[0];
    }

    private static /* synthetic */ void lambda$getRootTaskCount$14(int[] count, Task task) {
        count[0] = count[0] + 1;
    }

    Task getTopRootTask() {
        return getRootTask(WindowContainer.alwaysTruePredicate());
    }

    int getCurrentOverrideConfigurationChanges() {
        return this.mCurrentOverrideConfigurationChanges;
    }

    int getInitialDisplayDensity() {
        int density = this.mInitialDisplayDensity;
        if (this.mMaxUiWidth > 0) goto L5;
        return density;
    L5:
        if (this.mInitialDisplayWidth > this.mMaxUiWidth) goto L7;
        return density;
    L7:
        return (int) ((this.mMaxUiWidth * density) / this.mInitialDisplayWidth);
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void onConfigurationChanged(Configuration newParentConfig) {
        int lastOrientation = getConfiguration().orientation;
        int lastWindowingMode = getWindowingMode();
        super.onConfigurationChanged(newParentConfig);
        this.mPinnedTaskController.onPostDisplayConfigurationChanged();
        updateImeParent();
        if (this.mContentRecorder == null) goto L6;
        this.mContentRecorder.onConfigurationChanged(lastOrientation, lastWindowingMode);
    L6:
        if (lastOrientation == getConfiguration().orientation) goto L10;
        getMetricsLogger().write(new LogMaker(1659).setSubtype(getConfiguration().orientation).addTaggedData(1660, Integer.valueOf(getDisplayId())));
        if (Features.FEAT_QUICK_WIN == false) goto L10;
        getExt().onDisplayOrientationChanged(getConfiguration().orientation);
    L10:
        this.mExt.updateFixedRotatedWindow();
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    boolean fillsParent() {
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isVisible() {
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isVisibleRequested() {
        if (isVisible() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mRemoved == true) goto L9;
        if (this.mRemoving == true) goto L9;
        return true;
    }

    void onTransitionFinished() {
        if (this.mFixedRotationLaunchingApp == null) goto L10;
        if (this.mFixedRotationLaunchingApp.isVisibleRequested() == true) goto L10;
        if (this.mFixedRotationLaunchingApp.isVisible() == true) goto L10;
        clearFixedRotationLaunchingApp();
    L10:
        if (this.mFixedRotationLaunchingApp != null) goto L12;
        return;
    L12:
        if (this.mFixedRotationLaunchingApp.isVisible() == true) goto L14;
        return;
    L14:
        if (this.mTransitionController.isCollecting() == false) goto L16;
        return;
    L16:
        if (this.mTransitionController.inPlayingTransition(this.mFixedRotationLaunchingApp) == false) goto L18;
        return;
    L18:
        if (this.mAtmService.mBackNavigationController.isMonitoringFinishTransition() == true) goto L29;
        Transition finishTransition = this.mTransitionController.mFinishingTransition;
        if (finishTransition != null) goto L22;
    L23:
        continueUpdateOrientationForDiffOrienLaunchingApp();
        return;
    L22:
        if (finishTransition.mParticipants.contains(this.mFixedRotationLaunchingApp) == false) goto L23;
        return;
    }

    boolean forAllImeWindows(ToBooleanFunction<WindowState> callback, boolean traverseTopToBottom) {
        return this.mImeWindowsContainer.forAllWindowForce(callback, traverseTopToBottom);
    }

    @Override // com.android.server.wm.WindowContainer
    int getOrientation() {
        int compatOrientation = this.mAppCompatCameraPolicy.getOrientation();
        if (compatOrientation == (-1)) goto L6;
        this.mLastOrientationSource = null;
        return compatOrientation;
    L6:
        int orientation = super.getOrientation();
        if (handlesOrientationChangeFromDescendant(orientation) == true) goto L22;
        ActivityRecord topActivity = topRunningActivity(true);
        if (topActivity != null) goto L11;
    L17:
        this.mLastOrientationSource = null;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L20;
        long protoLogParam0 = this.mDisplayId;
        long protoLogParam1 = orientation;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -3395592185328682328L, 21, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1), -1L});
    L20:
        return -1;
    L11:
        if (topActivity.mAppCompatController.getOrientationOverrides().shouldUseDisplayLandscapeNaturalOrientation() == false) goto L17;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L28;
        long protoLogParam2 = this.mDisplayId;
        long protoLogParam3 = orientation;
        String protoLogParam4 = String.valueOf(topActivity);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -74384795669614579L, 21, new Object[]{Long.valueOf(protoLogParam2), Long.valueOf(protoLogParam3), 0L, protoLogParam4});
        return 0;
    L28:
        return 0;
    L22:
        if (orientation == (-2)) goto L24;
        return orientation;
    L24:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L26;
        long protoLogParam5 = this.mDisplayId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 3438870491084701232L, 5, new Object[]{-1L, Long.valueOf(protoLogParam5)});
    L26:
        return -1;
    }

    void updateDisplayInfo(DisplayInfo newDisplayInfo) {
        updateBaseDisplayMetricsIfNeeded(newDisplayInfo);
        DisplayInfoOverrides.copyDisplayInfoFields(this.mDisplayInfo, newDisplayInfo, this.mLastDisplayInfoOverride, DisplayInfoOverrides.WM_OVERRIDE_FIELDS);
        this.mDisplayInfo.getAppMetrics(this.mDisplayMetrics, this.mDisplay.getDisplayAdjustments());
        onDisplayInfoChanged();
        onDisplayChanged(this);
    }

    void updatePrivacyIndicatorBounds(Rect[] staticBounds) {
        PrivacyIndicatorBounds oldBounds = this.mCurrentPrivacyIndicatorBounds;
        this.mCurrentPrivacyIndicatorBounds = this.mCurrentPrivacyIndicatorBounds.updateStaticBounds(staticBounds);
        if (Objects.equals(oldBounds, this.mCurrentPrivacyIndicatorBounds) == true) goto L6;
        updateDisplayFrames(true);
        return;
    }

    void onDisplayInfoChanged() {
        updateDisplayFrames(false);
        this.mInputMonitor.layoutInputConsumers(this.mDisplayInfo.logicalWidth, this.mDisplayInfo.logicalHeight);
        this.mDisplayPolicy.onDisplayInfoChanged(this.mDisplayInfo);
    }

    private void updateDisplayFrames(boolean notifyInsetsChange) {
        if (updateDisplayFrames(this.mDisplayFrames, this.mDisplayInfo.rotation, this.mDisplayInfo.logicalWidth, this.mDisplayInfo.logicalHeight) == false) goto L6;
        this.mInsetsStateController.onDisplayFramesUpdated(notifyInsetsChange);
        return;
    }

    boolean updateDisplayFrames(DisplayFrames displayFrames, int rotation, int w, int h) {
        return displayFrames.update(rotation, w, h, calculateDisplayCutoutForRotation(rotation), calculateRoundedCornersForRotation(rotation), calculatePrivacyIndicatorBoundsForRotation(rotation), calculateDisplayShapeForRotation(rotation));
    }

    @Override // com.android.server.wm.WindowContainer
    void onDisplayChanged(DisplayContent dc) {
        super.onDisplayChanged(dc);
        updateSystemGestureExclusionLimit();
    }

    void updateSystemGestureExclusionLimit() {
        this.mSystemGestureExclusionLimit = (this.mWmService.mConstants.mSystemGestureExclusionLimitDp * this.mDisplayMetrics.densityDpi) / 160;
        updateSystemGestureExclusion();
    }

    void initializeDisplayBaseInfo() {
        DisplayManagerInternal displayManagerInternal = this.mWmService.mDisplayManagerInternal;
        if (displayManagerInternal == null) goto L8;
        DisplayInfo newDisplayInfo = displayManagerInternal.getDisplayInfo(this.mDisplayId);
        if (newDisplayInfo == null) goto L7;
        this.mDisplayInfo.copyFrom(newDisplayInfo);
    L7:
        this.mDwpcHelper = new DisplayWindowPolicyControllerHelper(this);
    L8:
        updateBaseDisplayMetrics(this.mDisplayInfo.logicalWidth, this.mDisplayInfo.logicalHeight, this.mDisplayInfo.logicalDensityDpi, this.mDisplayInfo.physicalXDpi, this.mDisplayInfo.physicalYDpi);
        this.mInitialDisplayWidth = this.mDisplayInfo.logicalWidth;
        this.mInitialDisplayHeight = this.mDisplayInfo.logicalHeight;
        this.mInitialDisplayDensity = this.mDisplayInfo.logicalDensityDpi;
        this.mInitialPhysicalXDpi = this.mDisplayInfo.physicalXDpi;
        this.mInitialPhysicalYDpi = this.mDisplayInfo.physicalYDpi;
        this.mInitialDisplayCutout = this.mDisplayInfo.displayCutout;
        this.mInitialRoundedCorners = this.mDisplayInfo.roundedCorners;
        this.mCurrentPrivacyIndicatorBounds = new PrivacyIndicatorBounds(new Rect[4], this.mDisplayInfo.rotation);
        this.mInitialDisplayShape = this.mDisplayInfo.displayShape;
        Display.Mode maxDisplayMode = DisplayUtils.getMaximumResolutionDisplayMode(this.mDisplayInfo.supportedModes);
        if (maxDisplayMode != null) goto L11;
        int r4 = this.mInitialDisplayWidth;
    L12:
        if (maxDisplayMode != null) goto L14;
        int r5 = this.mInitialDisplayHeight;
    L15:
        this.mPhysicalDisplaySize = new Point(r4, r5);
        return;
    L14:
        r5 = maxDisplayMode.getPhysicalHeight();
        goto L15
    L11:
        r4 = maxDisplayMode.getPhysicalWidth();
        goto L12
    }

    private void updateBaseDisplayMetricsIfNeeded(DisplayInfo newDisplayInfo) {
        this.mDisplayInfo.copyFrom(newDisplayInfo);
        getRotation();
        int orientation = this.mDisplayInfo.rotation;
        if (orientation != 1) goto L5;
    L8:
        boolean r3 = true;
    L9:
        boolean rotated = r3;
        DisplayInfo r4 = this.mDisplayInfo;
        if (rotated == false) goto L12;
        int r5 = r4.logicalHeight;
    L13:
        int newWidth = r5;
        DisplayInfo r6 = this.mDisplayInfo;
        if (rotated == false) goto L16;
        int r7 = r6.logicalWidth;
    L17:
        int newHeight = r7;
        int newDensity = this.mDisplayInfo.logicalDensityDpi;
        float newXDpi = this.mDisplayInfo.physicalXDpi;
        float newYDpi = this.mDisplayInfo.physicalYDpi;
        if (this.mIgnoreDisplayCutout == false) goto L20;
        DisplayCutout r8 = DisplayCutout.NO_CUTOUT;
    L21:
        DisplayCutout newCutout = r8;
        String newUniqueId = this.mDisplayInfo.uniqueId;
        RoundedCorners newRoundedCorners = this.mDisplayInfo.roundedCorners;
        DisplayShape newDisplayShape = this.mDisplayInfo.displayShape;
        if (this.mInitialDisplayWidth == newWidth) goto L24;
    L39:
        boolean r2 = true;
    L40:
        boolean displayMetricsChanged = r2;
        boolean physicalDisplayChanged = !newUniqueId.equals(this.mCurrentUniqueDisplayId);
        if (displayMetricsChanged == true) goto L45;
        if (physicalDisplayChanged == true) goto L45;
        return;
    L45:
        if (physicalDisplayChanged == false) goto L47;
        this.mWmService.mDisplayWindowSettings.applySettingsToDisplayLocked(this, false);
        this.mDisplayRotation.physicalDisplayChanged();
        this.mDisplayPolicy.physicalDisplayChanged();
    L47:
        this.mInitialDisplayWidth = newWidth;
        this.mInitialDisplayHeight = newHeight;
        this.mInitialDisplayDensity = newDensity;
        this.mInitialPhysicalXDpi = newXDpi;
        this.mInitialPhysicalYDpi = newYDpi;
        this.mInitialDisplayCutout = newCutout;
        this.mInitialRoundedCorners = newRoundedCorners;
        this.mInitialDisplayShape = newDisplayShape;
        this.mCurrentUniqueDisplayId = newUniqueId;
        if (this.mIsSizeForced == false) goto L50;
        int r1 = this.mBaseDisplayWidth;
    L52:
        if (this.mIsSizeForced == false) goto L54;
        int r9 = this.mBaseDisplayHeight;
    L55:
        int r18 = r1;
        if (this.mIsDensityForced == false) goto L58;
        int r10 = this.mBaseDisplayDensity;
    L59:
        int r19 = r10;
        if (this.mIsSizeForced == false) goto L62;
        float r11 = this.mBaseDisplayPhysicalXDpi;
    L63:
        float r20 = r11;
        if (this.mIsSizeForced == false) goto L66;
        float r12 = this.mBaseDisplayPhysicalYDpi;
    L67:
        updateBaseDisplayMetrics(r18, r9, r19, r20, r12);
        configureDisplayPolicy();
        if (physicalDisplayChanged == false) goto L70;
        this.mWmService.mDisplayWindowSettings.applyRotationSettingsToDisplayLocked(this);
    L70:
        reconfigureDisplayLocked();
        if (physicalDisplayChanged == false) goto L75;
        this.mDisplayPolicy.physicalDisplayUpdated();
        this.mDisplayUpdater.onDisplayContentDisplayPropertiesPostChanged();
        return;
    L75:
        return;
    L66:
        r12 = newYDpi;
        goto L67
    L62:
        r11 = newXDpi;
        goto L63
    L58:
        r10 = newDensity;
        goto L59
    L54:
        r9 = newHeight;
        goto L55
    L50:
        r1 = newWidth;
        goto L52
    L24:
        if (this.mInitialDisplayHeight != newHeight) goto L39;
        if (this.mInitialDisplayDensity != newDensity) goto L39;
        if (this.mInitialPhysicalXDpi != newXDpi) goto L39;
        if (this.mInitialPhysicalYDpi != newYDpi) goto L39;
        if (Objects.equals(this.mInitialDisplayCutout, newCutout) == false) goto L39;
        if (Objects.equals(this.mInitialRoundedCorners, newRoundedCorners) == false) goto L39;
        if (Objects.equals(this.mInitialDisplayShape, newDisplayShape) == false) goto L39;
        r2 = false;
        goto L40
    L20:
        r8 = this.mDisplayInfo.displayCutout;
        goto L21
    L16:
        r7 = r6.logicalHeight;
        goto L17
    L12:
        r5 = r4.logicalWidth;
        goto L13
    L5:
        if (orientation == 3) goto L8;
        r3 = false;
        goto L9
    }

    void setMaxUiWidth(int width) {
        if (WindowManagerDebugConfig.DEBUG_DISPLAY == false) goto L5;
        Slog.v(TAG, "Setting max ui width:" + width + " on display:" + getDisplayId());
    L5:
        this.mMaxUiWidth = width;
        updateBaseDisplayMetrics(this.mBaseDisplayWidth, this.mBaseDisplayHeight, this.mBaseDisplayDensity, this.mBaseDisplayPhysicalXDpi, this.mBaseDisplayPhysicalYDpi);
    }

    void updateBaseDisplayMetrics(int baseWidth, int baseHeight, int baseDensity, float baseXDpi, float baseYDpi) {
        this.mBaseDisplayWidth = baseWidth;
        this.mBaseDisplayHeight = baseHeight;
        this.mBaseDisplayDensity = baseDensity;
        this.mBaseDisplayPhysicalXDpi = baseXDpi;
        this.mBaseDisplayPhysicalYDpi = baseYDpi;
        if (this.mIsSizeForced == false) goto L6;
        this.mBaseDisplayCutout = loadDisplayCutout(baseWidth, baseHeight);
        this.mBaseRoundedCorners = loadRoundedCorners(baseWidth, baseHeight);
    L6:
        if (DesktopExperienceFlags.ENABLE_PERSISTING_DISPLAY_SIZE_FOR_CONNECTED_DISPLAYS.isTrue() == false) goto L11;
        if (this.mForcedDisplayDensityRatio == INVALID_DPI) goto L11;
        this.mBaseDisplayDensity = getBaseDensityFromRatio();
    L11:
        if (this.mMaxUiWidth <= 0) goto L21;
        if (this.mBaseDisplayWidth <= this.mMaxUiWidth) goto L21;
        float ratio = this.mMaxUiWidth / this.mBaseDisplayWidth;
        this.mBaseDisplayHeight = (int) (this.mBaseDisplayHeight * ratio);
        this.mBaseDisplayWidth = this.mMaxUiWidth;
        this.mBaseDisplayPhysicalXDpi *= ratio;
        this.mBaseDisplayPhysicalYDpi *= ratio;
        if (this.mIsDensityForced == true) goto L18;
        this.mBaseDisplayDensity = (int) (this.mBaseDisplayDensity * ratio);
    L18:
        if (WindowManagerDebugConfig.DEBUG_DISPLAY == false) goto L21;
        Slog.v(TAG, "Applying config restraints:" + this.mBaseDisplayWidth + "x" + this.mBaseDisplayHeight + " on display:" + getDisplayId());
    L21:
        if (this.mDisplayReady == true) goto L23;
        return;
    L23:
        if (this.mDisplayPolicy.shouldKeepCurrentDecorInsets() == true) goto L27;
        this.mDisplayPolicy.mDecorInsets.invalidate();
        return;
    }

    private int getBaseDensityFromRatio() {
        if (this.mForcedDisplayDensityRatio == INVALID_DPI) goto L6;
        return ((int) (this.mInitialDisplayDensity * this.mForcedDisplayDensityRatio)) & (-2);
    L6:
        return this.mInitialDisplayDensity;
    }

    void setForcedDensity(int density, int userId) {
        boolean updateCurrent = false;
        if (density == getInitialDisplayDensity()) goto L5;
        boolean r0 = true;
    L6:
        this.mIsDensityForced = r0;
        if (userId != (-2)) goto L10;
        updateCurrent = true;
    L10:
        if (this.mWmService.mCurrentUserId == userId) goto L12;
        if (updateCurrent == true) goto L12;
    L13:
        if (updateCurrent == false) goto L16;
        return;
    L16:
        if (density != getInitialDisplayDensity()) goto L18;
        density = 0;
    L18:
        this.mWmService.mDisplayWindowSettings.setForcedDensity(getDisplayInfo(), density, userId);
        return;
    L12:
        this.mBaseDisplayDensity = density;
        reconfigureDisplayLocked();
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    void setForcedDensityRatio(float ratio, int userId) {
        if (DesktopExperienceFlags.ENABLE_PERSISTING_DISPLAY_SIZE_FOR_CONNECTED_DISPLAYS.isTrue() == false) goto L6;
        this.mForcedDisplayDensityRatio = ratio;
        this.mWmService.mDisplayWindowSettings.setForcedDensityRatio(getDisplayInfo(), this.mForcedDisplayDensityRatio);
        setForcedDensity(getBaseDensityFromRatio(), userId);
        return;
    }

    void setForcedScalingMode(int mode) {
        boolean r0 = true;
        if (mode == 1) goto L5;
        mode = 0;
    L5:
        if (mode != 0) goto L8;
        r0 = false;
    L8:
        this.mDisplayScalingDisabled = r0;
        StringBuilder r1 = new StringBuilder();
        r1.append("Using display scaling mode: ");
        if (this.mDisplayScalingDisabled == false) goto L11;
        String r2 = "off";
    L12:
        r1.append(r2);
        Slog.i(TAG, r1.toString());
        reconfigureDisplayLocked();
        this.mWmService.mDisplayWindowSettings.setForcedScalingMode(this, mode);
        return;
    L11:
        r2 = UiModeManagerService.Shell.NIGHT_MODE_STR_AUTO;
        goto L12
    }

    void setForcedSize(int width, int height) {
        setForcedSize(width, height, INVALID_DPI, INVALID_DPI);
    }

    void setForcedSize(int width, int height, float xDPI, float yDPI) {
        if (this.mInitialDisplayWidth == width) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.mIsSizeForced = r0;
        if (this.mIsSizeForced == true) goto L12;
        int width2 = width;
        int height2 = height;
    L18:
        Slog.i(TAG, "Using new display size: " + width2 + "x" + height2);
        if (this.mIsDensityForced == false) goto L22;
        int r9 = this.mBaseDisplayDensity;
    L21:
        int r5 = r9;
        if (xDPI == INVALID_DPI) goto L26;
        float r6 = xDPI;
    L28:
        if (yDPI == INVALID_DPI) goto L30;
        float r7 = yDPI;
    L31:
        updateBaseDisplayMetrics(width2, height2, r5, r6, r7);
        reconfigureDisplayLocked();
        if (this.mIsSizeForced == true) goto L34;
        height2 = 0;
        width2 = 0;
    L34:
        this.mWmService.mDisplayWindowSettings.setForcedSize(this, width2, height2);
        return;
    L30:
        r7 = this.mBaseDisplayPhysicalYDpi;
        goto L31
    L26:
        r6 = this.mBaseDisplayPhysicalXDpi;
        goto L28
    L22:
        r9 = this.mInitialDisplayDensity;
        goto L21
    L12:
        if (this.mMaxUiWidth > 0) goto L14;
    L16:
        Point size = getValidForcedSize(width, height);
        width2 = size.x;
        height2 = size.y;
        goto L18
    L14:
        if (width <= this.mMaxUiWidth) goto L16;
        float ratio = this.mMaxUiWidth / width;
        height = (int) (height * ratio);
        width = this.mMaxUiWidth;
        goto L16
    L5:
        if (this.mInitialDisplayHeight != height) goto L8;
        r0 = false;
        goto L9
    }

    Point getValidForcedSize(int w, int h) {
        int maxSize = Math.max(this.mInitialDisplayWidth, this.mInitialDisplayHeight) * 3;
        int w2 = Math.min(Math.max(w, 200), maxSize);
        int h2 = Math.min(Math.max(h, 200), maxSize);
        return new Point(w2, h2);
    }

    void onDisplayInfoChangeApplied() {
        if (DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT.isTrue() == true) goto L6;
        Slog.e(TAG, "ShouldShowSystemDecors shouldn't be updated when the flag is off.");
    L6:
        if (allowContentModeSwitch() == true) goto L8;
        return;
    L8:
        boolean shouldShowContent = this.mDisplay.canHostTasks();
        if (shouldShowContent != this.mWmService.mDisplayWindowSettings.shouldShowSystemDecorsLocked(this)) goto L11;
        return;
    L11:
        this.mWmService.mDisplayWindowSettings.setShouldShowSystemDecorsLocked(this, shouldShowContent);
        if (shouldShowContent == true) goto L14;
        clearAllTasksOnDisplay(null, false);
    L14:
        this.mWmService.mDisplayManagerInternal.onDisplayBelongToTopologyChanged(this.mDisplayId, shouldShowContent);
    }

    boolean allowContentModeSwitch() {
        if ((this.mDisplay.getFlags() & 32768) != 0) goto L6;
        return false;
    L6:
        if (this.isDefaultDisplay == false) goto L9;
        return false;
    L9:
        if (isPrivate() == false) goto L11;
    L21:
        return false;
    L11:
        if (isTrusted() == false) goto L21;
        if (shouldNeverShowSystemDecorations() == false) goto L17;
        return false;
    L17:
        if ((this.mDisplay.getFlags() & 64) == 0) goto L19;
        return false;
    L19:
        return true;
    }

    DisplayCutout loadDisplayCutout(int displayWidth, int displayHeight) {
        if (this.mDisplayPolicy == null) goto L10;
        if (this.mInitialDisplayCutout != null) goto L8;
        return null;
    L8:
        return DisplayCutout.fromResourcesRectApproximation(this.mDisplayPolicy.getSystemUiContext().getResources(), this.mDisplayInfo.uniqueId, this.mPhysicalDisplaySize.x, this.mPhysicalDisplaySize.y, displayWidth, displayHeight);
    L10:
        return null;
    }

    RoundedCorners loadRoundedCorners(int displayWidth, int displayHeight) {
        if (this.mDisplayPolicy == null) goto L10;
        if (this.mInitialRoundedCorners != null) goto L8;
        return null;
    L8:
        return RoundedCorners.fromResources(this.mDisplayPolicy.getSystemUiContext().getResources(), this.mDisplayInfo.uniqueId, this.mPhysicalDisplaySize.x, this.mPhysicalDisplaySize.y, displayWidth, displayHeight);
    L10:
        return null;
    }

    @Override // com.android.server.wm.DisplayArea
    void getStableRect(Rect out) {
        InsetsState state = this.mDisplayContent.getInsetsStateController().getRawInsetsState();
        out.set(state.getDisplayFrame());
        out.inset(state.calculateInsets(out, WindowInsets.Type.systemBars(), true));
    }

    TaskDisplayArea getDefaultTaskDisplayArea() {
        return this.mDisplayAreaPolicy.getDefaultTaskDisplayArea();
    }

    void updateDisplayAreaOrganizers() {
        if (isTrusted() == true) goto L5;
        return;
    L5:
        forAllDisplayAreas(new DisplayContent$$ExternalSyntheticLambda53(this));
    }

    private /* synthetic */ void lambda$updateDisplayAreaOrganizers$15(DisplayArea displayArea) {
        if (displayArea.isOrganized() == false) goto L5;
        return;
    L5:
        IDisplayAreaOrganizer organizer = this.mAtmService.mWindowOrganizerController.mDisplayAreaOrganizerController.getOrganizerByFeature(displayArea.mFeatureId);
        if (organizer == null) goto L9;
        displayArea.setOrganizer(organizer);
        return;
    }

    Task findTaskForResizePoint(final int x, final int y) {
        final int delta = WindowManagerService.dipToPixel(30, this.mDisplayMetrics);
        return (Task) getItemFromTaskDisplayAreas(new DisplayContent$$ExternalSyntheticLambda51(this, x, y, delta));
    }

    private /* synthetic */ Task lambda$findTaskForResizePoint$16(int x, int y, int delta, TaskDisplayArea taskDisplayArea) {
        return this.mTmpTaskForResizePointSearchResult.process(taskDisplayArea, x, y, delta);
    }

    @Override // com.android.server.wm.WindowContainer
    void switchUser(int userId) {
        super.switchUser(userId);
        this.mWmService.mWindowsChanged = true;
        this.mDisplayPolicy.switchUser();
    }

    private boolean shouldDeferRemoval() {
        if (isAnimating(3) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mTransitionController.isTransitionOnDisplay(this) == true) goto L8;
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    void removeIfPossible() {
        if (shouldDeferRemoval() == false) goto L6;
        this.mDeferredRemoval = true;
        return;
    L6:
        removeImmediately();
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    void removeImmediately() {
        this.mDeferredRemoval = false;
    L8:
        th = move-exception;
        this.mDisplayReady = false;
        throw th;
    L4:
        if (DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT.isTrue() == true) goto L6;
    L10:
        this.mUnknownAppVisibilityController.clear();     // Catch: Throwable -> L8
        this.mTransitionController.unregisterLegacyListener(this.mFixedRotationTransitionListener);     // Catch: Throwable -> L8
        this.mDeviceStateController.unregisterDeviceStateCallback(this.mDeviceStateConsumer);     // Catch: Throwable -> L8
        super.removeImmediately();     // Catch: Throwable -> L8
        if (WindowManagerDebugConfig.DEBUG_DISPLAY == false) goto L13;
        Slog.v(TAG, "Removing display=" + this);     // Catch: Throwable -> L8
    L13:
        this.mPointerEventDispatcher.dispose();     // Catch: Throwable -> L8
        setRemoteInsetsController(null);     // Catch: Throwable -> L8
        this.mOverlayLayer.release();     // Catch: Throwable -> L8
        this.mInputOverlayLayer.release();     // Catch: Throwable -> L8
        this.mA11yOverlayLayer.release();     // Catch: Throwable -> L8
        this.mInputMonitor.onDisplayRemoved();     // Catch: Throwable -> L8
        this.mWmService.mDisplayNotificationController.dispatchDisplayRemoved(this);     // Catch: Throwable -> L8
        this.mDisplayRotation.onDisplayRemoved();     // Catch: Throwable -> L8
        this.mWmService.mAccessibilityController.onDisplayRemoved(this.mDisplayId);     // Catch: Throwable -> L8
        this.mRootWindowContainer.mTaskSupervisor.getKeyguardController().onDisplayRemoved(this.mDisplayId);     // Catch: Throwable -> L8
        this.mWallpaperController.resetLargestDisplay(this.mDisplay);     // Catch: Throwable -> L8
        this.mWmService.mDisplayWindowSettings.onDisplayRemoved(this);     // Catch: Throwable -> L8
        getDisplayUiContext().unregisterComponentCallbacks(this.mSysUiContextConfigCallback);     // Catch: Throwable -> L8
        this.mDisplayReady = false;
        getPendingTransaction().apply();
        this.mWmService.mWindowPlacerLocked.requestTraversal();
        this.mAppCompatCameraPolicy.dispose();
        return;
    L6:
        if (this.mWmService.mDisplayWindowSettings.shouldShowSystemDecorsLocked(this) == false) goto L10;
        this.mDisplayPolicy.notifyDisplayRemoveSystemDecorations();     // Catch: Throwable -> L8
        goto L10
    }

    @Override // com.android.server.wm.WindowContainer
    boolean handleCompleteDeferredRemoval() {
        if (super.handleCompleteDeferredRemoval() == false) goto L5;
    L8:
        boolean stillDeferringRemoval = true;
    L9:
        if (stillDeferringRemoval == false) goto L11;
    L14:
        return stillDeferringRemoval;
    L11:
        if (this.mDeferredRemoval == false) goto L14;
        removeImmediately();
        return false;
    L5:
        if (shouldDeferRemoval() == true) goto L8;
        stillDeferringRemoval = false;
        goto L9
    }

    void adjustForImeIfNeeded() {
        WindowState imeWin = this.mInputMethodWindow;
        if (imeWin != null) goto L5;
    L9:
        boolean imeVisible = false;
    L10:
        int imeHeight = getInputMethodWindowVisibleHeight();
        this.mPinnedTaskController.setAdjustedForIme(imeVisible, imeHeight);
        return;
    L5:
        if (imeWin.isVisible() == false) goto L9;
        if (imeWin.isDisplayed() == false) goto L9;
        imeVisible = true;
        goto L10
    }

    int getInputMethodWindowVisibleHeight() {
        InsetsState state = getInsetsStateController().getRawInsetsState();
        InsetsSource imeSource = state.peekSource(InsetsSource.ID_IME);
        if (imeSource != null) goto L5;
    L13:
        return 0;
    L5:
        if (imeSource.isVisible() == false) goto L13;
        if (imeSource.getVisibleFrame() == null) goto L10;
        Rect imeFrame = imeSource.getVisibleFrame();
    L11:
        Rect dockFrame = this.mTmpRect;
        dockFrame.set(state.getDisplayFrame());
        dockFrame.inset(state.calculateInsets(dockFrame, WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout(), false));
        return dockFrame.bottom - imeFrame.top;
    L10:
        imeFrame = imeSource.getFrame();
        goto L11
    }

    void enableHighPerfTransition(boolean enable) {
        if (this.mWmService.mSupportsHighPerfTransitions == true) goto L5;
        return;
    L5:
        if (enable == false) goto L11;
        if (this.mTransitionPrefSession != null) goto L9;
        this.mTransitionPrefSession = this.mWmService.mSystemPerformanceHinter.createSession(3, this.mDisplayId, "Transition");
    L9:
        this.mTransitionPrefSession.start();
        return;
    L11:
        if (this.mTransitionPrefSession == null) goto L15;
        this.mTransitionPrefSession.close();
        return;
    }

    void enableHighFrameRate(boolean enable) {
        if (enable == false) goto L8;
        if (this.mHighFrameRateSession != null) goto L6;
        this.mHighFrameRateSession = this.mWmService.mSystemPerformanceHinter.createSession(2, this.mDisplayId, "WindowAnimation");
    L6:
        this.mHighFrameRateSession.start();
        return;
    L8:
        if (this.mHighFrameRateSession == null) goto L12;
        this.mHighFrameRateSession.close();
        return;
    }

    void rotateBounds(int oldRotation, int newRotation, Rect inOutBounds) {
        getBounds(this.mTmpRect, oldRotation);
        RotationUtils.rotateBounds(inOutBounds, this.mTmpRect, oldRotation, newRotation);
    }

    void collectDisplayChange(Transition transition) {
        if (this.mLastHasContent == true) goto L6;
        return;
    L6:
        if (transition.isCollecting() == true) goto L9;
        return;
    L9:
        if (transition.mParticipants.contains(this) == true) goto L14;
        transition.collect(this);
        startAsyncRotationIfNeeded();
        if (this.mFixedRotationLaunchingApp == null) goto L19;
        setSeamlessTransitionForFixedRotation(transition);
        return;
    L19:
        return;
    L14:
        if (this.mAsyncRotationController != null) goto L16;
        return;
    L16:
        if (isRotationChanging() == true) goto L22;
        Slog.i(TAG, "Finish AsyncRotation for previous intermediate change");
        finishAsyncRotationIfPossible();
        return;
    }

    void requestChangeTransition(int changes, TransitionRequestInfo.DisplayChange displayChange) {
        if (this.mWmService.getExt().isFreezingDisplayForSwitchResolution() == false) goto L6;
        Slog.d(TAG, "Freezing display for switch resolution, skip requestChangeTransition");
        return;
    L6:
        TransitionController controller = this.mTransitionController;
        Transition t = controller.requestStartDisplayTransition(6, 0, this, null, displayChange);
        t.collect(this);
        this.mAtmService.startPowerMode(2);
        if (this.mAsyncRotationController == null) goto L10;
        this.mAsyncRotationController.updateRotation();
    L10:
        if (this.mFixedRotationLaunchingApp == null) goto L13;
        setSeamlessTransitionForFixedRotation(t);
    L20:
        t.setKnownConfigChanges(this, changes);
        return;
    L13:
        if (isRotationChanging() == false) goto L20;
        if (displayChange == null) goto L19;
        boolean seamless = this.mDisplayRotation.shouldRotateSeamlessly(displayChange.getStartRotation(), displayChange.getEndRotation(), false);
        if (seamless == false) goto L19;
        t.onSeamlessRotating(this);
    L19:
        this.mWmService.mLatencyTracker.onActionStart(6);
        controller.mTransitionMetricsReporter.associate(t.getToken(), new DisplayContent$$ExternalSyntheticLambda22(this));
        startAsyncRotation(false);
        goto L20
    }

    private /* synthetic */ void lambda$requestChangeTransition$17(long startTime) {
        this.mWmService.mLatencyTracker.onActionEnd(6);
    }

    private void setSeamlessTransitionForFixedRotation(Transition t) {
        t.setSeamlessRotation(this);
        if (this.mAsyncRotationController == null) goto L6;
        this.mAsyncRotationController.keepAppearanceInPreviousRotation();
        return;
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        if (logLevel == 2) goto L5;
    L7:
        long token = proto.start(fieldId);
        super.dumpDebug(proto, 1146756268053L, logLevel);
        proto.write(1120986464258L, this.mDisplayId);
        proto.write(1120986464265L, this.mBaseDisplayDensity);
        this.mDisplayInfo.dumpDebug(proto, 1146756268042L);
        this.mDisplayRotation.dumpDebug(proto, 1146756268065L);
        this.mDisplayFrames.dumpDebug(proto, 1146756268045L);
        proto.write(1120986464295L, this.mMinSizeOfResizeableTaskDp);
        this.mTransitionController.dumpDebugLegacy(proto, 1146756268048L);
        if (this.mFocusedApp == null) goto L10;
        this.mFocusedApp.writeNameToProto(proto, 1138166333455L);
    L10:
        Task focusedRootTask = getFocusedRootTask();
        if (focusedRootTask == null) goto L16;
        proto.write(1120986464279L, focusedRootTask.getRootTaskId());
        ActivityRecord focusedActivity = focusedRootTask.getDisplayArea().getFocusedActivity();
        if (focusedActivity == null) goto L17;
        focusedActivity.writeIdentifierToProto(proto, 1146756268056L);
    L17:
        proto.write(1133871366170L, isReady());
        proto.write(1133871366180L, isSleeping());
        int i = 0;
    L19:
        if (i >= this.mAllSleepTokens.size()) goto L22;
        this.mAllSleepTokens.get(i).writeTagToProto(proto, 2237677961253L);
        i = i + 1;
        goto L19
    L22:
        if (this.mImeLayeringTarget == null) goto L25;
        this.mImeLayeringTarget.writeIdentifierToProto(proto, 1146756268072L);
    L25:
        if (this.mImeInputTarget == null) goto L30;
        if (this.mImeInputTarget.getWindowState() == null) goto L30;
        this.mImeInputTarget.getWindowState().writeIdentifierToProto(proto, 1146756268073L);
    L30:
        if (this.mImeControlTarget == null) goto L35;
        if (this.mImeControlTarget.getWindow() == null) goto L35;
        this.mImeControlTarget.getWindow().writeIdentifierToProto(proto, 1146756268074L);
    L35:
        if (this.mCurrentFocus == null) goto L38;
        this.mCurrentFocus.writeIdentifierToProto(proto, 1146756268075L);
    L38:
        if (this.mInsetsStateController == null) goto L40;
        this.mInsetsStateController.dumpDebug(proto, logLevel);
    L40:
        proto.write(1120986464290L, getImePolicy());
        Iterator<Rect> r3 = getKeepClearAreas().iterator();
    L42:
        if (r3.hasNext() == false) goto L44;
        Rect r = r3.next();
        r.dumpDebug(proto, 2246267895846L);
        goto L42
    L44:
        proto.end(token);
        return;
    L16:
        proto.write(1120986464279L, -1);
        goto L17
    L5:
        if (isVisible() == true) goto L7;
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    long getProtoFieldId() {
        return 1146756268035L;
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
    public void dump(final PrintWriter pw, final String prefix, final boolean dumpAll) {
        pw.print(prefix);
        StringBuilder r0 = new StringBuilder();
        r0.append("Display: mDisplayId=");
        r0.append(this.mDisplayId);
        Object r2 = "";
        if (isOrganized() == false) goto L5;
        String r1 = " (organized)";
    L6:
        r0.append(r1);
        pw.println(r0.toString());
        String subPrefix = "  " + prefix;
        pw.print(subPrefix);
        pw.print("init=");
        pw.print(this.mInitialDisplayWidth);
        pw.print("x");
        pw.print(this.mInitialDisplayHeight);
        pw.print(" ");
        pw.print(this.mInitialDisplayDensity);
        pw.print("dpi");
        pw.print(" mMinSizeOfResizeableTaskDp=");
        pw.print(this.mMinSizeOfResizeableTaskDp);
        if (this.mInitialDisplayWidth == this.mBaseDisplayWidth) goto L9;
    L12:
        pw.print(" base=");
        pw.print(this.mBaseDisplayWidth);
        pw.print("x");
        pw.print(this.mBaseDisplayHeight);
        pw.print(" ");
        pw.print(this.mBaseDisplayDensity);
        pw.print("dpi");
    L14:
        if (this.mDisplayScalingDisabled == false) goto L16;
        pw.println(" noscale");
    L16:
        pw.print(" cur=");
        pw.print(this.mDisplayInfo.logicalWidth);
        pw.print("x");
        pw.print(this.mDisplayInfo.logicalHeight);
        pw.print(" app=");
        pw.print(this.mDisplayInfo.appWidth);
        pw.print("x");
        pw.print(this.mDisplayInfo.appHeight);
        pw.print(" rng=");
        pw.print(this.mDisplayInfo.smallestNominalAppWidth);
        pw.print("x");
        pw.print(this.mDisplayInfo.smallestNominalAppHeight);
        pw.print("-");
        pw.print(this.mDisplayInfo.largestNominalAppWidth);
        pw.print("x");
        pw.println(this.mDisplayInfo.largestNominalAppHeight);
        pw.print(subPrefix + "deferred=" + this.mDeferredRemoval + " mLayoutNeeded=" + this.mLayoutNeeded);
        pw.println();
        super.dump(pw, prefix, dumpAll);
        pw.print(prefix);
        if (this.mHasSetIgnoreOrientationRequest == false) goto L19;
        pw.print("mHasSetIgnoreOrientationRequest=true ");
    L19:
        pw.print("ignoreOrientationRequest=");
        pw.println(getIgnoreOrientationRequest());
        pw.print(prefix);
        pw.print("mLayoutSeq=");
        pw.println(this.mLayoutSeq);
        pw.print("  mCurrentFocus=");
        pw.println(this.mCurrentFocus);
        pw.print("  mFocusedApp=");
        pw.println(this.mFocusedApp);
        if (this.mFixedRotationLaunchingApp == null) goto L23;
        pw.println("  mFixedRotationLaunchingApp=" + this.mFixedRotationLaunchingApp);
    L23:
        if (this.mAsyncRotationController == null) goto L25;
        this.mAsyncRotationController.dump(pw, prefix);
    L25:
        ArrayList<Transition> playingTransitions = this.mTransitionController.mPlayingTransitions;
        pw.print("  mPlayingTransitions.size=");
        pw.println(playingTransitions.size());
        pw.print("  mPlayingTransitions.top=");
        if (playingTransitions.isEmpty() == false) goto L28;
    L30:
        pw.println(r2);
        pw.println();
        pw.print(prefix + "mHoldScreenWindow=");
        pw.print(this.mHoldScreenWindow);
        pw.println();
        pw.print(prefix + "mObscuringWindow=");
        pw.print(this.mObscuringWindow);
        pw.println();
        pw.print(prefix + "mLastWakeLockHoldingWindow=");
        pw.print(this.mLastWakeLockHoldingWindow);
        pw.println();
        pw.print(prefix + "mLastWakeLockObscuringWindow=");
        pw.println(this.mLastWakeLockObscuringWindow);
        pw.println();
        pw.println(prefix + " mPointerEventDispatcher: " + this.mPointerEventDispatcher);
        this.mPointerEventDispatcher.dump(prefix, pw);
        this.mWallpaperController.dump(pw, "  ");
        if (this.mSystemGestureExclusionListeners.getRegisteredCallbackCount() <= 0) goto L33;
        pw.println();
        pw.print("  mSystemGestureExclusion=");
        pw.println(this.mSystemGestureExclusion);
    L33:
        Set<Rect> keepClearAreas = getKeepClearAreas();
        if (keepClearAreas.isEmpty() == true) goto L36;
        pw.println();
        pw.print("  keepClearAreas=");
        pw.println(keepClearAreas);
    L36:
        pw.println();
        pw.println(prefix + "Display areas in top down Z order:");
        dumpChildDisplayArea(pw, subPrefix, dumpAll);
        pw.println();
        pw.println(prefix + "Task display areas in top down Z order:");
        forAllTaskDisplayAreas(new DisplayContent$$ExternalSyntheticLambda0(pw, prefix, dumpAll));
        pw.println();
        Task rootHomeTask = getDefaultTaskDisplayArea().getRootHomeTask();
        if (rootHomeTask == null) goto L39;
        pw.println(prefix + "rootHomeTask=" + rootHomeTask.getName());
    L39:
        Task rootPinnedTask = getDefaultTaskDisplayArea().getRootPinnedTask();
        if (rootPinnedTask == null) goto L42;
        pw.println(prefix + "rootPinnedTask=" + rootPinnedTask.getName());
    L42:
        Task rootRecentsTask = getDefaultTaskDisplayArea().getRootTask(0, 3);
        if (rootRecentsTask == null) goto L45;
        pw.println(prefix + "rootRecentsTask=" + rootRecentsTask.getName());
    L45:
        Task rootDreamTask = getRootTask(0, 5);
        if (rootDreamTask == null) goto L48;
        pw.println(prefix + "rootDreamTask=" + rootDreamTask.getName());
    L48:
        pw.println();
        this.mPinnedTaskController.dump(prefix, pw);
        pw.println();
        this.mDisplayFrames.dump(prefix, pw);
        pw.println();
        this.mDisplayPolicy.dump(prefix, pw);
        pw.println();
        this.mDisplayRotation.dump(prefix, pw);
        pw.println();
        this.mInputMonitor.dump(pw, "  ");
        pw.println();
        this.mInsetsStateController.dump(prefix, pw);
        this.mInsetsPolicy.dump(prefix, pw);
        this.mDwpcHelper.dump(prefix, pw);
        pw.println();
        return;
    L28:
        if (playingTransitions.get(0) == null) goto L30;
        r2 = Integer.valueOf(playingTransitions.get(0).getSyncId());
        goto L30
    L9:
        if (this.mInitialDisplayHeight != this.mBaseDisplayHeight) goto L12;
        if (this.mInitialDisplayDensity == this.mBaseDisplayDensity) goto L14;
    L5:
        r1 = "";
        goto L6
    }

    private static /* synthetic */ void lambda$dump$18(PrintWriter pw, String prefix, boolean dumpAll, TaskDisplayArea taskDisplayArea) {
        taskDisplayArea.dump(pw, prefix + "  ", dumpAll);
    }

    @Override // com.android.server.wm.DisplayArea
    public String toString() {
        return "Display{#" + this.mDisplayId + " state=" + Display.stateToString(this.mDisplayInfo.state) + " size=" + this.mDisplayInfo.logicalWidth + "x" + this.mDisplayInfo.logicalHeight + " " + Surface.rotationToString(this.mDisplayInfo.rotation) + "}";
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.ConfigurationContainer
    String getName() {
        return "Display " + this.mDisplayId + " name=\"" + this.mDisplayInfo.name + "\"";
    }

    WindowState getTouchableWinAtPointLocked(float xf, float yf) {
        final int x = (int) xf;
        final int y = (int) yf;
        WindowState touchedWin = getWindow(new DisplayContent$$ExternalSyntheticLambda35(this, x, y));
        return touchedWin;
    }

    private /* synthetic */ boolean lambda$getTouchableWinAtPointLocked$19(int x, int y, WindowState w) {
        int flags = w.mAttrs.flags;
        if (w.isVisible() == true) goto L6;
        return false;
    L6:
        if ((flags & 16) == 0) goto L8;
        return false;
    L8:
        w.getVisibleBounds(this.mTmpRect);
        if (this.mTmpRect.contains(x, y) == true) goto L11;
        return false;
    L11:
        w.getTouchableRegion(this.mTmpRegion);
        int touchFlags = flags & 40;
        if (this.mTmpRegion.contains(x, y) == true) goto L14;
        if (touchFlags == 0) goto L14;
        return false;
    L14:
        return true;
    }

    boolean canAddToastWindowForUid(final int uid) {
        WindowState focusedWindowForUid = getWindow(new DisplayContent$$ExternalSyntheticLambda30(uid));
        if (focusedWindowForUid == null) goto L5;
        return true;
    L5:
        WindowState win = getWindow(new DisplayContent$$ExternalSyntheticLambda31(uid));
        if (win == null) goto L10;
        return false;
    L10:
        return true;
    }

    private static /* synthetic */ boolean lambda$canAddToastWindowForUid$20(int uid, WindowState w) {
        if (w.mOwnerUid == uid) goto L5;
    L7:
        return false;
    L5:
        if (w.isFocused() == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$canAddToastWindowForUid$21(int uid, WindowState w) {
        if (w.mAttrs.type == 2005) goto L5;
    L11:
        return false;
    L5:
        if (w.mOwnerUid != uid) goto L11;
        if (w.mPermanentlyHidden == true) goto L11;
        if (w.mWindowRemovalAllowed == true) goto L11;
        return true;
    }

    void scheduleToastWindowsTimeoutIfNeededLocked(WindowState oldFocus, WindowState newFocus) {
        if (oldFocus == null) goto L9;
        if (newFocus != null) goto L5;
    L7:
        this.mTmpWindow = oldFocus;
        forAllWindows(this.mScheduleToastTimeout, false);
        return;
    L5:
        if (newFocus.mOwnerUid != oldFocus.mOwnerUid) goto L7;
        return;
    }

    boolean canStealTopFocus() {
        if ((this.mDisplayInfo.flags & 4096) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    WindowState findFocusedWindowIfNeeded(int topFocusedDisplayId) {
        if (hasOwnFocus() == true) goto L8;
        if (topFocusedDisplayId == (-1)) goto L8;
        return null;
    L8:
        return findFocusedWindow();
    }

    WindowState findFocusedWindow() {
        this.mTmpWindow = null;
        forAllWindows(this.mFindFocusedWindow, true);
        if (this.mTmpWindow != null) goto L8;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[1] == false) goto L8;
        long protoLogParam0 = getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -1123818872155982592L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L8:
        return this.mTmpWindow;
    }

    WindowState findFocusedWindow(ActivityRecord activityRecord) {
        ActivityRecord tmpApp = this.mFocusedApp;
        this.mTmpWindow = null;
        this.mFocusedApp = activityRecord;     // Catch: Throwable -> L6
        activityRecord.forAllWindows(this.mFindFocusedWindow, true);     // Catch: Throwable -> L6
        this.mFocusedApp = tmpApp;
        return this.mTmpWindow;
    L6:
        th = move-exception;
        this.mFocusedApp = tmpApp;
        throw th;
    }

    boolean updateFocusedWindowLocked(int mode, boolean updateInputWindows, int topFocusedDisplayId) {
        if (this.mCurrentFocus != null) goto L5;
    L18:
        WindowState newFocus = findFocusedWindowIfNeeded(topFocusedDisplayId);
        if (this.mCurrentFocus != newFocus) goto L21;
        return false;
    L21:
        boolean imWindowChanged = false;
        WindowState imWindow = this.mInputMethodWindow;
        if (imWindow == null) goto L34;
        WindowState prevTarget = this.mImeLayeringTarget;
        WindowState newTarget = computeImeTarget(true);
        if (prevTarget == newTarget) goto L26;
        boolean r13 = true;
    L27:
        imWindowChanged = r13;
        if (mode == 1) goto L31;
        if (mode == 3) goto L31;
        assignWindowLayers(false);
    L31:
        if (imWindowChanged == false) goto L34;
        this.mWmService.mWindowsChanged = true;
        setLayoutNeeded();
        newFocus = findFocusedWindowIfNeeded(topFocusedDisplayId);
        goto L34
    L26:
        r13 = false;
    L34:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[0] == false) goto L36;
        String protoLogParam0 = String.valueOf(this.mCurrentFocus);
        String protoLogParam1 = String.valueOf(newFocus);
        long protoLogParam2 = getDisplayId();
        String protoLogParam3 = String.valueOf(Debug.getCallers(4));
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, 3101160328044493048L, 16, new Object[]{protoLogParam0, protoLogParam1, Long.valueOf(protoLogParam2), protoLogParam3});
    L36:
        WindowState oldFocus = this.mCurrentFocus;
        this.mCurrentFocus = newFocus;
        if (newFocus == null) goto L43;
        ISmartScenes r5 = SysOptBridge.getFactory().getSmartScenes();
        if (newFocus.mActivityRecord != null) goto L41;
        ApplicationInfo r6 = null;
    L42:
        r5.updateFocusWindow(r6);
        goto L43
    L41:
        r6 = newFocus.mActivityRecord.info.applicationInfo;
    L43:
        if (newFocus == null) goto L66;
        this.mWinAddedSinceNullFocus.clear();
        this.mWinRemovedSinceNullFocus.clear();
        if (Constants.ENABLE_GAME_ASSIST == true) goto L47;
        boolean r10 = false;
    L52:
        if (newFocus.canReceiveKeys() == false) goto L54;
        newFocus.mToken.paused = r10;
    L54:
        if (oldFocus == null) goto L56;
        SysOptBridge.getFactory().getDynamicRefreshRateService().onFocusedWindowChangeLocked(oldFocus.getOwningPackage(), newFocus.getOwningPackage());
    L56:
        SysOptBridge.getFactory().getAppRecordManagerService().onFocusChanged(newFocus.getUid(), newFocus.getPid(), newFocus.getDisplayId(), true);
        if (newFocus.getActivityRecord() == null) goto L64;
        if (newFocus.getDisplayId() != 0) goto L61;
        boolean isOnMainDisplay = true;
    L62:
        SysOptBridge.getFactory().getOAutoHelper().setFocusedActivity(newFocus.getActivityRecord().mActivityComponent, isOnMainDisplay);
        goto L64
    L61:
        isOnMainDisplay = false;
    L64:
        if (getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L66;
        this.mWmService.getObricExt().setAutoFocusedPkg(newFocus.getOwningPackage());
        goto L66
    L47:
        if (newFocus.mAttrs == null) goto L49;
        SystemWindowManagerEventDispatcher.getInstance().notifyFocuesWindowChanged(newFocus.mAttrs.packageName, newFocus.mAttrs.type, newFocus.getBounds());
        r10 = false;
        goto L52
    L49:
        r10 = false;
        SystemWindowManagerEventDispatcher.getInstance().notifyFocuesWindowChanged("", 0, null);
    L66:
        getDisplayPolicy().focusChangedLw(oldFocus, newFocus);
        this.mAtmService.mBackNavigationController.onFocusChanged(newFocus);
        getObricExt().onFocusChanged(oldFocus, newFocus);
        if (imWindowChanged == false) goto L76;
        if (oldFocus == this.mInputMethodWindow) goto L76;
        if (mode != 2) goto L73;
        performLayout(true, updateInputWindows);
        goto L76
    L73:
        if (mode != 3) goto L76;
        assignWindowLayers(false);
    L76:
        if (mode == 1) goto L78;
        getInputMonitor().setInputFocusLw(newFocus, updateInputWindows);
    L78:
        adjustForImeIfNeeded();
        scheduleToastWindowsTimeoutIfNeededLocked(oldFocus, newFocus);
        if (mode != 2) goto L82;
        this.pendingLayoutChanges |= 8;
    L82:
        if (this.mWmService.mAccessibilityController.hasCallbacks() == false) goto L86;
        this.mWmService.mH.sendMessage(PooledLambda.obtainMessage(new DisplayContent$$ExternalSyntheticLambda2(this), this.mWmService.mAccessibilityController));
        return true;
    L86:
        return true;
    L5:
        if (this.mTransitionController.shouldKeepFocus(this.mCurrentFocus) == false) goto L18;
        if (this.mFocusedApp == null) goto L18;
        if (this.mCurrentFocus.isDescendantOf(this.mFocusedApp) == false) goto L18;
        if (this.mCurrentFocus.isVisible() == false) goto L18;
        if (this.mCurrentFocus.isFocusable() == false) goto L18;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[1] == false) goto L17;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS, -2192125645150932161L, 0, null);
    L17:
        return false;
    }

    void updateAccessibilityOnWindowFocusChanged(AccessibilityController accessibilityController) {
        accessibilityController.onWindowFocusChangedNot(getDisplayId());
    }

    boolean setFocusedApp(ActivityRecord newFocus) {
        if (newFocus == null) goto L13;
        DisplayContent appDisplay = newFocus.getDisplayContent();
        if (appDisplay == this) goto L11;
        StringBuilder r2 = new StringBuilder();
        r2.append(newFocus);
        r2.append(" is not on ");
        r2.append(getName());
        r2.append(" but ");
        if (appDisplay == null) goto L8;
        String r3 = appDisplay.getName();
    L9:
        r2.append(r3);
        throw new IllegalStateException(r2.toString());
    L8:
        r3 = "none";
        goto L9
    L11:
        onLastFocusedTaskDisplayAreaChanged(newFocus.getDisplayArea());
    L13:
        if (this.mFocusedApp != newFocus) goto L16;
        return false;
    L16:
        if (getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L20;
        Slog.w(TAG, " no need to set focusedApp for auto virtual display" + newFocus);
        return false;
    L20:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[2] == false) goto L22;
        String protoLogParam0 = String.valueOf(newFocus);
        long protoLogParam1 = getDisplayId();
        String protoLogParam2 = String.valueOf(Debug.getCallers(4));
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, 7634130879993688940L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), protoLogParam2});
    L22:
        Task newTask = null;
        if (this.mFocusedApp == null) goto L25;
        Task oldTask = this.mFocusedApp.getTask();
    L26:
        if (newFocus == null) goto L28;
        newTask = newFocus.getTask();
    L28:
        this.mFocusedApp = newFocus;
        if (oldTask == newTask) goto L35;
        if (oldTask == null) goto L32;
        oldTask.onAppFocusChanged(false);
    L32:
        if (newTask == null) goto L35;
        newTask.onAppFocusChanged(true);
    L35:
        if ("PREFETCH_APP".equals(this.mDisplay.getName()) == false) goto L38;
        Slog.i(TAG, "skip update input focus for prefetch. mDisplay.getName=" + this.mDisplay.getName());
        return true;
    L38:
        getInputMonitor().setFocusedAppLw(newFocus);
        return true;
    L25:
        oldTask = null;
        goto L26
    }

    void onRunningActivityChanged() {
        this.mDwpcHelper.onRunningActivityChanged();
    }

    void onLastFocusedTaskDisplayAreaChanged(TaskDisplayArea taskDisplayArea) {
        this.mOrientationRequestingTaskDisplayArea = taskDisplayArea;
    }

    TaskDisplayArea getOrientationRequestingTaskDisplayArea() {
        if (getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L7;
        return getDefaultTaskDisplayArea();
    L7:
        return this.mOrientationRequestingTaskDisplayArea;
    }

    void assignWindowLayers(boolean setLayoutNeeded) {
        Trace.traceBegin(32, "assignWindowLayers");
        assignChildLayers(getSyncTransaction());
        if (setLayoutNeeded == false) goto L5;
        setLayoutNeeded();
    L5:
        scheduleAnimation();
        Trace.traceEnd(32);
    }

    boolean destroyLeakedSurfaces() {
        this.mTmpWindow = null;
        final SurfaceControl.Transaction t = this.mWmService.mTransactionFactory.get();
        forAllWindows(new DisplayContent$$ExternalSyntheticLambda33(this, t), false);
        t.apply();
        if (this.mTmpWindow == null) goto L6;
        return true;
    L6:
        return false;
    }

    private /* synthetic */ void lambda$destroyLeakedSurfaces$22(SurfaceControl.Transaction t, WindowState w) {
        WindowStateAnimator wsa = w.mWinAnimator;
        if (wsa.mSurfaceControl != null) goto L6;
        return;
    L6:
        if (this.mWmService.mSessions.contains(wsa.mSession) == true) goto L9;
        Slog.w(TAG, "LEAKED SURFACE (session doesn't exist): " + w + " surface=" + wsa.mSurfaceControl + " token=" + w.mToken + " pid=" + w.mSession.mPid + " uid=" + w.mSession.mUid);
        wsa.destroySurface(t);
        this.mWmService.mForceRemoves.add(w);
        this.mTmpWindow = w;
        return;
    L9:
        if (w.mActivityRecord != null) goto L11;
        return;
    L11:
        if (w.mActivityRecord.isClientVisible() == true) goto L19;
        Slog.w(TAG, "LEAKED SURFACE (app token hidden): " + w + " surface=" + wsa.mSurfaceControl + " token=" + w.mActivityRecord);
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L15;
        String protoLogParam0 = String.valueOf(w);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, -4130402450005935184L, 0, new Object[]{protoLogParam0});
    L15:
        wsa.destroySurface(t);
        this.mTmpWindow = w;
        return;
    }

    boolean hasAlertWindowSurfaces() {
        int i = this.mWmService.mSessions.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (this.mWmService.mSessions.valueAt(i).hasAlertWindowSurfaces(this) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    void setInputMethodWindowLocked(WindowState win) {
        this.mInputMethodWindow = win;
        this.mInsetsStateController.getImeSourceProvider().setWindowContainer(win, this.mDisplayPolicy.getImeSourceFrameProvider(), null);
        computeImeTarget(true);
        updateImeControlTarget();
    }

    WindowState computeImeTarget(boolean updateImeTarget) {
        if (this.mInputMethodWindow != null) goto L10;
        if (updateImeTarget == true) goto L6;
    L9:
        return null;
    L6:
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L8;
        Slog.w(TAG, "Moving IM target from " + this.mImeLayeringTarget + " to null since mInputMethodWindow is null");
    L8:
        setImeLayeringTargetInner(null);
        goto L9
    L10:
        WindowState curTarget = this.mImeLayeringTarget;
        if (canUpdateImeTarget() == false) goto L13;
        this.mUpdateImeTarget = updateImeTarget;
        WindowState target = getWindow(this.mComputeImeTargetPredicate);
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L22;
        if (updateImeTarget == false) goto L22;
        Slog.v(TAG, "Proposed new IME target: " + target + " for display: " + getDisplayId());
    L22:
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L24;
        Slog.v(TAG, "Desired input method target=" + target + " updateImeTarget=" + updateImeTarget);
    L24:
        String r5 = "";
        if (target != null) goto L36;
        if (updateImeTarget == true) goto L28;
    L35:
        return null;
    L28:
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L34;
        StringBuilder r8 = new StringBuilder();
        r8.append("Moving IM target from ");
        r8.append(curTarget);
        r8.append(" to null.");
        if (WindowManagerDebugConfig.SHOW_STACK_CRAWLS == false) goto L33;
        r5 = " Callers=" + Debug.getCallers(4);
    L33:
        r8.append(r5);
        Slog.w(TAG, r8.toString());
    L34:
        setImeLayeringTargetInner(null);
        goto L35
    L36:
        if (updateImeTarget == true) goto L38;
    L44:
        return target;
    L38:
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L43;
        StringBuilder r2 = new StringBuilder();
        r2.append("Moving IM target from ");
        r2.append(curTarget);
        r2.append(" to ");
        r2.append(target);
        if (WindowManagerDebugConfig.SHOW_STACK_CRAWLS == false) goto L42;
        r5 = " Callers=" + Debug.getCallers(4);
    L42:
        r2.append(r5);
        Slog.w(TAG, r2.toString());
    L43:
        setImeLayeringTargetInner(target);
        goto L44
    L13:
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L15;
        Slog.w(TAG, "Defer updating IME target");
    L15:
        this.mUpdateImeRequestedWhileDeferred = true;
        return curTarget;
    }

    void computeImeTargetIfNeeded(ActivityRecord candidate) {
        if (this.mImeLayeringTarget != null) goto L5;
        return;
    L5:
        if (this.mImeLayeringTarget.mActivityRecord != candidate) goto L9;
        computeImeTarget(true);
        return;
    }

    private boolean isImeControlledByApp() {
        if (this.mImeInputTarget != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mImeInputTarget.shouldControlIme() == false) goto L7;
        return true;
    }

    boolean shouldImeAttachedToApp() {
        if (this.mImeWindowsContainer.isOrganized() == false) goto L6;
        return false;
    L6:
        if (this.mMagnificationSpec != null) goto L8;
        boolean allowAttachToApp = true;
    L9:
        if (allowAttachToApp == true) goto L11;
        return false;
    L11:
        if (isImeControlledByApp() == true) goto L13;
        return false;
    L13:
        if (this.mImeLayeringTarget != null) goto L15;
        return false;
    L15:
        if (this.mImeLayeringTarget.mActivityRecord != null) goto L17;
        return false;
    L17:
        if (this.mImeLayeringTarget.getWindowingMode() == 1) goto L19;
        return false;
    L19:
        if (this.mImeLayeringTarget.getBounds().equals(this.mImeWindowsContainer.getBounds()) == true) goto L21;
        return false;
    L21:
        if (this.mImeLayeringTarget.matchesDisplayAreaBounds() == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        allowAttachToApp = false;
        goto L9
    }

    boolean isImeAttachedToApp() {
        if (shouldImeAttachedToApp() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mInputMethodSurfaceParent == null) goto L9;
        if (this.mInputMethodSurfaceParent.isSameSurface(this.mImeLayeringTarget.mActivityRecord.getSurfaceControl()) == false) goto L9;
        return true;
    }

    InsetsControlTarget getImeHostOrFallback(WindowState target) {
        if (target != null) goto L4;
    L6:
        DisplayContent defaultDc = getUserMainDisplayContent();
        return defaultDc.mRemoteInsetsControlTarget;
    L4:
        if (target.getDisplayContent().getImePolicy() != 0) goto L6;
        return target;
    }

    InsetsControlTarget getImeFallback() {
        DisplayContent defaultDc = getUserMainDisplayContent();
        WindowState statusBar = defaultDc.getDisplayPolicy().getStatusBar();
        if (statusBar == null) goto L6;
        return statusBar;
    L6:
        return defaultDc.mRemoteInsetsControlTarget;
    }

    private DisplayContent getUserMainDisplayContent() {
        int userId = this.mWmService.mUmInternal.getUserAssignedToDisplay(this.mDisplayId);
        DisplayContent defaultDc = this.mWmService.getUserMainDisplayContentLocked(userId);
        if (defaultDc == null) goto L6;
        return defaultDc;
    L6:
        throw new IllegalStateException("No default display was assigned to user " + userId);
    }

    InsetsControlTarget getImeTarget(int type) {
        switch(type) {
            case 0: goto L8;
            case 1: goto L3;
            case 2: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return this.mImeControlTarget;
    L8:
        return this.mImeLayeringTarget;
    }

    InputTarget getImeInputTarget() {
        return this.mImeInputTarget;
    }

    int getImePolicy() {
        if (isTrusted() == true) goto L5;
        return 1;
    L5:
        int imePolicy = this.mWmService.mDisplayWindowSettings.getImePolicyLocked(this);
        if (imePolicy == 1) goto L8;
    L15:
        return imePolicy;
    L8:
        if (isPublicSecondaryDisplayWithDesktopModeForceEnabled() == false) goto L10;
        return 0;
    L10:
        if (getDisplay().getName().equals(ActivityStarterHook.CAR_DISPLAY_NAME2) == false) goto L12;
        return 0;
    L12:
        if (getDisplay().getName().equals(ActivityStarterHook.CAR_DISPLAY_NAME) == false) goto L15;
        return 0;
    }

    void onShowImeRequested() {
        if (this.mInputMethodWindow != null) goto L6;
        return;
    L6:
        if (this.mFixedRotationLaunchingApp == null) goto L11;
        this.mInputMethodWindow.mToken.linkFixedRotationTransform(this.mFixedRotationLaunchingApp);
        if (this.mAsyncRotationController == null) goto L12;
        this.mAsyncRotationController.hideImeImmediately();
        return;
    L12:
        return;
    }

    void setImeLayeringTarget(WindowState target) {
        this.mImeLayeringTarget = target;
    }

    private void setImeLayeringTargetInner(WindowState target) {
        if (target == this.mImeLayeringTarget) goto L5;
    L7:
        this.mLastImeInputTarget = this.mImeInputTarget;
        if (this.mImeLayeringTarget == null) goto L24;
        if (this.mImeLayeringTarget != this.mImeInputTarget) goto L24;
        if (this.mImeLayeringTarget.mAnimatingExit == true) goto L14;
    L18:
        boolean nonAppImeTargetAnimatingExit = false;
    L20:
        if (this.mImeLayeringTarget.inTransitionSelfOrParent() == true) goto L22;
        if (nonAppImeTargetAnimatingExit == false) goto L24;
    L22:
        showImeScreenshot();
        goto L24
    L14:
        if (this.mImeLayeringTarget.mAttrs.type == 1) goto L18;
        if (this.mImeLayeringTarget.isSelfAnimating(0, 16) == false) goto L18;
        nonAppImeTargetAnimatingExit = true;
    L24:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[2] == false) goto L27;
        String protoLogParam0 = String.valueOf(target);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_IME, 4464269036743635127L, 0, new Object[]{protoLogParam0});
    L27:
        if (target == this.mImeLayeringTarget) goto L29;
        boolean shouldUpdateImeParent = true;
    L30:
        this.mImeLayeringTarget = target;
        if (target != null) goto L33;
    L43:
        assignWindowLayers(true);
        this.mInsetsStateController.updateAboveInsetsState(this.mInsetsStateController.getRawInsetsState().isSourceOrDefaultVisible(InsetsSource.ID_IME, WindowInsets.Type.ime()));
        updateImeControlTarget(shouldUpdateImeParent);
        return;
    L33:
        if (this.mImeWindowsContainer.isOrganized() == true) goto L43;
        RootDisplayArea targetRoot = target.getRootDisplayArea();
        if (targetRoot == null) goto L43;
        if (targetRoot == this.mImeWindowsContainer.getRootDisplayArea()) goto L43;
        if (targetRoot.placeImeContainer(this.mImeWindowsContainer) == false) goto L43;
        shouldUpdateImeParent = true;
        if (this.mInputMethodWindow == null) goto L43;
        this.mInputMethodWindow.hide(false, false);
        goto L43
    L29:
        shouldUpdateImeParent = false;
        goto L30
    L5:
        if (this.mLastImeInputTarget != this.mImeInputTarget) goto L7;
    }

    void setImeInputTarget(InputTarget target) {
        if (this.mImeTargetTokenListenerPair == null) goto L8;
        WindowToken oldToken = this.mTokenMap.get(this.mImeTargetTokenListenerPair.first);
        if (oldToken == null) goto L7;
        oldToken.unregisterWindowContainerListener((WindowContainerListener) this.mImeTargetTokenListenerPair.second);
    L7:
        this.mImeTargetTokenListenerPair = null;
    L8:
        this.mImeInputTarget = target;
        if (target == null) goto L14;
        final WindowState targetWin = target.getWindowState();
        if (targetWin == null) goto L14;
        this.mImeTargetTokenListenerPair = new Pair(targetWin.mToken.token, new AnonymousClass3(this, targetWin));
        targetWin.mToken.registerWindowContainerListener((WindowContainerListener) this.mImeTargetTokenListenerPair.second);
        this.mWmService.dispatchImeInputTargetVisibilityChanged(targetWin.mClient.asBinder(), targetWin.isVisible(), false, this.mDisplayId);
    L14:
        if (this.mImeControlTarget == null) goto L22;
        if (this.mImeControlTarget != this.mRemoteInsetsControlTarget) goto L22;
        if (target != null) goto L19;
    L20:
        Slog.d(TAG, "setImeInputTarget: IME input target requested hidden, set visibility to false");
        this.mRemoteInsetsControlTarget.setImeInputTargetRequestedVisibility(false, null);
        goto L22
    L19:
        if (target.getImeControlTarget() != this.mRemoteInsetsControlTarget) goto L20;
    L22:
        if (refreshImeSecureFlag(getPendingTransaction()) == false) goto L25;
        this.mWmService.requestTraversal();
        return;
    }

    boolean refreshImeSecureFlag(SurfaceControl.Transaction t) {
        if (this.mImeInputTarget != null) goto L5;
    L8:
        boolean canScreenshot = true;
    L10:
        return this.mImeWindowsContainer.setCanScreenshot(t, canScreenshot);
    L5:
        if (this.mImeInputTarget.canScreenshotIme() == true) goto L8;
        canScreenshot = false;
        goto L10
    }

    void setImeControlTarget(InsetsControlTarget target) {
        this.mImeControlTarget = target;
    }

    private void attachImeScreenshotOnTargetIfNeeded() {
        if (shouldImeAttachedToApp() == true) goto L5;
        return;
    L5:
        if (this.mWmService.mPolicy.isScreenOn() == true) goto L8;
        return;
    L8:
        if (this.mInputMethodWindow != null) goto L10;
        return;
    L10:
        if (this.mInputMethodWindow.isVisible() == true) goto L12;
        return;
    L12:
        if (this.mWmService.getExt().isImeHidingAnimation() == false) goto L15;
        Slog.d(TAG, "not attach IME screenshot on target when IME is hiding animation");
        return;
    L15:
        attachImeScreenshotOnTarget(this.mImeLayeringTarget);
    }

    private void attachImeScreenshotOnTarget(WindowState imeTarget) {
        attachImeScreenshotOnTarget(imeTarget, false);
    }

    private void attachImeScreenshotOnTarget(WindowState imeTarget, boolean hideImeWindow) {
        if (getExt().hideImeForFreeformIfNeeded(imeTarget, hideImeWindow) == false) goto L5;
        return;
    L5:
        SurfaceControl.Transaction t = getPendingTransaction();
        removeImeSurfaceImmediately();
        this.mImeScreenshot = new ImeScreenshot(this.mWmService.mSurfaceControlFactory.get(), imeTarget);
        this.mImeScreenshot.attachAndShow(t, hideImeWindow);
        if (this.mImeScreenshot.getImeScreenshotSurface() != null) goto L9;
        return;
    L9:
        if (this.mInputMethodWindow == null) goto L13;
        if (hideImeWindow == false) goto L14;
        this.mInputMethodWindow.hide(false, false);
        return;
    L14:
        return;
    }

    void showImeScreenshot() {
        attachImeScreenshotOnTargetIfNeeded();
    }

    void showImeScreenshot(WindowState imeTarget) {
        attachImeScreenshotOnTarget(imeTarget, true);
    }

    void removeImeSurfaceByTarget(WindowContainer win) {
        if (this.mImeScreenshot == null) goto L22;
        if (win != null) goto L7;
        return;
    L7:
        if (win.asWindowState() != null) goto L9;
    L11:
        final WindowState screenshotTarget = this.mImeScreenshot.getImeTarget();
        if (win != screenshotTarget) goto L14;
    L17:
        boolean winIsOrContainsScreenshotTarget = true;
    L19:
        if (winIsOrContainsScreenshotTarget == false) goto L23;
        removeImeSurfaceImmediately();
        return;
    L23:
        return;
    L14:
        if (win.getWindow(new DisplayContent$$ExternalSyntheticLambda6(screenshotTarget)) != null) goto L17;
        winIsOrContainsScreenshotTarget = false;
        goto L19
    L9:
        if (win.asWindowState().mAttrs.type != 3) goto L11;
        return;
    }

    private static /* synthetic */ boolean lambda$removeImeSurfaceByTarget$23(WindowState screenshotTarget, Object w) {
        if (w != screenshotTarget) goto L4;
        return true;
    L4:
        return false;
    }

    void removeImeSurfaceImmediately() {
        if (this.mImeScreenshot == null) goto L6;
        this.mImeScreenshot.detach(getSyncTransaction());
        this.mImeScreenshot = null;
        return;
    }

    void updateImeInputAndControlTarget(InputTarget target) {
        if (this.mImeInputTarget == target) goto L17;
        boolean forceUpdateImeParent = false;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[2] == false) goto L7;
        String protoLogParam0 = String.valueOf(target);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_IME, -4354595179162289537L, 0, new Object[]{protoLogParam0});
    L7:
        setImeInputTarget(target);
        this.mInsetsStateController.updateAboveInsetsState(this.mInsetsStateController.getRawInsetsState().isSourceOrDefaultVisible(InsetsSource.ID_IME, WindowInsets.Type.ime()));
        if (this.mImeControlTarget == this.mRemoteInsetsControlTarget) goto L10;
    L15:
        updateImeControlTarget(forceUpdateImeParent);
        this.mInsetsStateController.getImeSourceProvider().onInputTargetChanged(target);
        return;
    L10:
        if (this.mInputMethodSurfaceParent == null) goto L15;
        if (this.mInputMethodSurfaceParent.isSameSurface(this.mImeWindowsContainer.getParent().mSurfaceControl) == true) goto L15;
        forceUpdateImeParent = true;
        goto L15
    }

    void updateImeControlTarget() {
        updateImeControlTarget(false);
    }

    void updateImeControlTarget(boolean forceUpdateImeParent) {
        InsetsControlTarget prevImeControlTarget = this.mImeControlTarget;
        this.mImeControlTarget = computeImeControlTarget();
        this.mInsetsStateController.onImeControlTargetChanged(this.mImeControlTarget);
        if (prevImeControlTarget == this.mImeControlTarget) goto L5;
        boolean imeControlChanged = true;
    L6:
        if (imeControlChanged == true) goto L8;
        if (forceUpdateImeParent == true) goto L8;
    L9:
        WindowState win = InsetsControlTarget.asWindowOrNull(this.mImeControlTarget);
        if (win == null) goto L12;
        final IBinder token = win.mClient.asBinder();
    L13:
        this.mWmService.mH.post(new DisplayContent$$ExternalSyntheticLambda54(token));
        return;
    L12:
        token = null;
    L8:
        updateImeParent();
        goto L9
    L5:
        imeControlChanged = false;
        goto L6
    }

    private static /* synthetic */ void lambda$updateImeControlTarget$24(IBinder token) {
        InputMethodManagerInternal.get().reportImeControl(token);
    }

    void updateImeParent() {
        SurfaceControl newParent = null;
        if (this.mImeWindowsContainer.isOrganized() == true) goto L5;
        WindowContainer newParentWindow = computeImeParent();
        if (newParentWindow == null) goto L12;
        newParent = newParentWindow.getSurfaceControl();
    L12:
        if (newParent == null) goto L20;
        if (newParent == this.mInputMethodSurfaceParent) goto L20;
        this.mInputMethodSurfaceParentWindow = newParentWindow;
        this.mInputMethodSurfaceParent = newParent;
        getSyncTransaction().reparent(this.mImeWindowsContainer.mSurfaceControl, newParent);
        if (ImeTracker.DEBUG_IME_VISIBILITY == false) goto L18;
        EventLog.writeEvent(EventLogTags.IMF_UPDATE_IME_PARENT, newParent.toString());
    L18:
        assignRelativeLayerForIme(getSyncTransaction(), true);
        scheduleAnimation();
        this.mWmService.mH.post(new DisplayContent$$ExternalSyntheticLambda18(this));
        return;
    L20:
        if (this.mImeControlTarget != null) goto L22;
        return;
    L22:
        if (this.mImeControlTarget != this.mImeLayeringTarget) goto L31;
        SurfaceControl lastRelativeLayer = this.mImeWindowsContainer.getLastRelativeLayer();
        if (lastRelativeLayer == this.mImeLayeringTarget.mSurfaceControl) goto L32;
        assignRelativeLayerForIme(getSyncTransaction(), false);
        if (lastRelativeLayer == this.mImeWindowsContainer.getLastRelativeLayer()) goto L33;
        scheduleAnimation();
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L5:
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L7;
        Slog.i(TAG, "ImeContainer is organized. Skip updateImeParent.");
    L7:
        this.mInputMethodSurfaceParentWindow = null;
        this.mInputMethodSurfaceParent = null;
    }

    private /* synthetic */ void lambda$updateImeParent$25() {
        InputMethodManagerInternal.get().onImeParentChanged(getDisplayId());
    }

    InsetsControlTarget computeImeControlTarget() {
        if (this.mImeInputTarget == null) goto L5;
        WindowState imeInputTarget = this.mImeInputTarget.getWindowState();
        if (isImeControlledByApp() == true) goto L17;
        if (this.mRemoteInsetsControlTarget == null) goto L17;
    L19:
        return this.mRemoteInsetsControlTarget;
    L17:
        if (getImeHostOrFallback(imeInputTarget) == this.mRemoteInsetsControlTarget) goto L19;
        return imeInputTarget;
    L5:
        if (isUserMainDisplay() == true) goto L7;
        return null;
    L7:
        if (this.mRemoteInsetsControlTarget != null) goto L9;
        return null;
    L9:
        return this.mRemoteInsetsControlTarget;
    }

    private boolean isUserMainDisplay() {
        int userId = this.mWmService.mUmInternal.getUserAssignedToDisplay(this.mDisplayId);
        if (this.mDisplayId != this.mWmService.mUmInternal.getMainDisplayAssignedToUser(userId)) goto L5;
        return true;
    L5:
        return false;
    }

    WindowContainer computeImeParent() {
        if (ImeTargetVisibilityPolicy.canComputeImeParent(this.mImeLayeringTarget, this.mImeInputTarget) == true) goto L7;
        return null;
    L7:
        if (shouldImeAttachedToApp() == false) goto L11;
        return this.mImeLayeringTarget.mActivityRecord;
    L11:
        return this.mImeWindowsContainer.getParent();
    }

    void setLayoutNeeded() {
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L5;
        Slog.w(TAG, "setLayoutNeeded: callers=" + Debug.getCallers(3));
    L5:
        this.mLayoutNeeded = true;
    }

    private void clearLayoutNeeded() {
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L5;
        Slog.w(TAG, "clearLayoutNeeded: callers=" + Debug.getCallers(3));
    L5:
        this.mLayoutNeeded = false;
    }

    boolean isLayoutNeeded() {
        return this.mLayoutNeeded;
    }

    void dumpTokens(PrintWriter pw, boolean dumpAll) {
        if (this.mTokenMap.isEmpty() == false) goto L5;
        return;
    L5:
        pw.println("  Display #" + this.mDisplayId);
        pw.println("    mInTouchMode=" + this.mInTouchMode);
        Iterator<WindowToken> it = this.mTokenMap.values().iterator();
    L7:
        if (it.hasNext() == false) goto L13;
        WindowToken token = it.next();
        pw.print("  ");
        pw.print(token);
        if (dumpAll == true) goto L10;
        pw.println();
        goto L7
    L10:
        pw.println(':');
        token.dump(pw, "    ", dumpAll);
        goto L7
    L13:
        this.mUnknownAppVisibilityController.dump(pw, "  ");
    }

    void dumpWindowAnimators(final PrintWriter pw, final String subPrefix) {
        final int[] index = new int[1];
        forAllWindows(new DisplayContent$$ExternalSyntheticLambda11(pw, subPrefix, index), false);
    }

    private static /* synthetic */ void lambda$dumpWindowAnimators$26(PrintWriter pw, String subPrefix, int[] index, WindowState w) {
        WindowStateAnimator wAnim = w.mWinAnimator;
        pw.println(subPrefix + "Window #" + index[0] + ": " + wAnim);
        index[0] = index[0] + 1;
    }

    boolean shouldWaitForSystemDecorWindowsOnBoot() {
        if (this.isDefaultDisplay == false) goto L5;
    L7:
        final SparseBooleanArray drawnWindowTypes = new SparseBooleanArray();
        drawnWindowTypes.put(2040, true);
        WindowState visibleNotDrawnWindow = getWindow(new DisplayContent$$ExternalSyntheticLambda34(this, drawnWindowTypes));
        if (visibleNotDrawnWindow == null) goto L11;
        return true;
    L11:
        if (this.mWmService.mContext.getResources().getBoolean(R.bool.config_enable_cellular_on_boot_default) == true) goto L13;
    L15:
        boolean wallpaperEnabled = false;
    L16:
        boolean haveBootMsg = drawnWindowTypes.get(2021);
        boolean haveApp = drawnWindowTypes.get(1);
        boolean haveWallpaper = drawnWindowTypes.get(2013);
        boolean haveKeyguard = drawnWindowTypes.get(2040);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SCREEN_ON_enabled[2] == false) goto L21;
        boolean protoLogParam0 = this.mWmService.mSystemBooted;
        boolean protoLogParam1 = this.mWmService.mShowingBootMessages;
        boolean protoLogParam5 = wallpaperEnabled;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_SCREEN_ON, 5683557566110711213L, 16383, new Object[]{Boolean.valueOf(protoLogParam0), Boolean.valueOf(protoLogParam1), Boolean.valueOf(haveBootMsg), Boolean.valueOf(haveApp), Boolean.valueOf(haveWallpaper), Boolean.valueOf(protoLogParam5), Boolean.valueOf(haveKeyguard)});
    L21:
        if (this.mWmService.mSystemBooted == true) goto L25;
        if (haveBootMsg == true) goto L25;
        return 1;
    L25:
        if (this.mWmService.mSystemBooted == false) goto L31;
        if (haveApp == true) goto L28;
        if (haveKeyguard == true) goto L28;
    L30:
        return r4;
    L28:
        if (wallpaperEnabled == false) goto L31;
        if (haveWallpaper == false) goto L30;
    L31:
        return 0;
    L13:
        if (this.mWmService.mContext.getResources().getBoolean(R.bool.config_customUserSwitchUi) == false) goto L15;
        wallpaperEnabled = true;
        goto L16
    L5:
        if (isSystemDecorationsSupported() == true) goto L7;
        return false;
    }

    private /* synthetic */ boolean lambda$shouldWaitForSystemDecorWindowsOnBoot$27(SparseBooleanArray drawnWindowTypes, WindowState w) {
        if (w.isVisible() == true) goto L5;
    L7:
        boolean isVisible = false;
    L8:
        boolean isDrawn = w.isDrawn();
        if (isVisible == false) goto L15;
        if (isDrawn == true) goto L15;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BOOT_enabled[0] == false) goto L14;
        long protoLogParam0 = w.mAttrs.type;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BOOT, 2432701541536053712L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L14:
        return true;
    L15:
        if (isDrawn == true) goto L17;
    L21:
        return false;
    L17:
        switch(w.mAttrs.type) {
            case 1: goto L20;
            case 2013: goto L20;
            case 2021: goto L20;
            case 2040: goto L19;
            default: goto L21;
        };
    L19:
        drawnWindowTypes.put(2040, this.mWmService.mPolicy.isKeyguardDrawnLw());
        goto L21
    L20:
        drawnWindowTypes.put(w.mAttrs.type, true);
        goto L21
    L5:
        if (w.mObscured == true) goto L7;
        isVisible = true;
        goto L8
    }

    void updateWindowsForAnimator() {
        forAllWindows(this.mUpdateWindowsForAnimator, true);
        if (this.mAsyncRotationController == null) goto L6;
        this.mAsyncRotationController.updateTargetWindows();
        return;
    }

    boolean isInputMethodClientFocus(int uid, int pid) {
        WindowState imFocus = computeImeTarget(false);
        if (imFocus != null) goto L6;
        return false;
    L6:
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L9;
        Slog.i(TAG, "Desired input method target: " + imFocus);
        Slog.i(TAG, "Current focus: " + this.mCurrentFocus + " displayId=" + this.mDisplayId);
    L9:
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L12;
        Slog.i(TAG, "IM target uid/pid: " + imFocus.mSession.mUid + SliceClientPermissions.SliceAuthority.DELIMITER + imFocus.mSession.mPid);
        Slog.i(TAG, "Requesting client uid/pid: " + uid + SliceClientPermissions.SliceAuthority.DELIMITER + pid);
    L12:
        if (imFocus.mSession.mUid == uid) goto L14;
        return false;
    L14:
        if (imFocus.mSession.mPid != pid) goto L18;
        return true;
    L18:
        return false;
    }

    private static /* synthetic */ boolean lambda$hasSecureWindowOnScreen$28(WindowState w) {
        if (w.isOnScreen() == true) goto L5;
    L7:
        return false;
    L5:
        if (w.isSecureLocked() == false) goto L7;
        return true;
    }

    boolean hasSecureWindowOnScreen() {
        WindowState win = getWindow(new DisplayContent$$ExternalSyntheticLambda25());
        if (win == null) goto L5;
        return true;
    L5:
        return false;
    }

    void applySurfaceChangesTransaction() {
        WindowSurfacePlacer surfacePlacer = this.mWmService.mWindowPlacerLocked;
        beginHoldScreenUpdate();
        this.mTmpUpdateAllDrawn.clear();
        if (WindowManagerDebugConfig.DEBUG_LAYOUT_REPEATS == false) goto L6;
        surfacePlacer.debugLayoutRepeats("On entry to LockedInner", this.pendingLayoutChanges);
    L6:
        if ((this.pendingLayoutChanges & 4) == 0) goto L9;
        this.mWallpaperController.adjustWallpaperWindows();
    L9:
        if ((this.pendingLayoutChanges & 2) == 0) goto L17;
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L14;
        Slog.v(TAG, "Computing new config from layout");
    L14:
        if (updateOrientation() == false) goto L17;
        setLayoutNeeded();
        sendNewConfiguration();
    L17:
        if ((this.pendingLayoutChanges & 1) == 0) goto L19;
        setLayoutNeeded();
    L19:
        performLayout(true, false);
        this.pendingLayoutChanges = 0;
        Trace.traceBegin(32, "applyPostLayoutPolicy");
        this.mDisplayPolicy.beginPostLayoutPolicyLw();     // Catch: Throwable -> L37
        forAllWindows(this.mApplyPostLayoutPolicy, true);     // Catch: Throwable -> L37
        this.mDisplayPolicy.finishPostLayoutPolicyLw();     // Catch: Throwable -> L37
        Trace.traceEnd(32);
        this.mInsetsStateController.onPostLayout();
        this.mTmpApplySurfaceChangesTransactionState.reset();
        Trace.traceBegin(32, "applyWindowSurfaceChanges");
        forAllWindows(this.mApplySurfaceChangesTransaction, true);     // Catch: Throwable -> L34
        Trace.traceEnd(32);
        this.mLastHasContent = this.mTmpApplySurfaceChangesTransactionState.displayHasContent;
        if (inTransition() == true) goto L26;
        this.mWmService.mDisplayManagerInternal.setDisplayProperties(this.mDisplayId, this.mLastHasContent, this.mTmpApplySurfaceChangesTransactionState.preferredRefreshRate, this.mTmpApplySurfaceChangesTransactionState.preferredModeId, this.mTmpApplySurfaceChangesTransactionState.preferredMinRefreshRate, this.mTmpApplySurfaceChangesTransactionState.preferredMaxRefreshRate, this.mTmpApplySurfaceChangesTransactionState.preferMinimalPostProcessing, this.mTmpApplySurfaceChangesTransactionState.disableHdrConversion, true);
    L26:
        updateRecording();
        boolean wallpaperVisible = this.mWallpaperController.isWallpaperVisible();
        if (wallpaperVisible == this.mLastWallpaperVisible) goto L30;
        this.mLastWallpaperVisible = wallpaperVisible;
        this.mWmService.mWallpaperVisibilityListeners.notifyWallpaperVisibilityChanged(this);
    L30:
        if (this.mTmpUpdateAllDrawn.isEmpty() == true) goto L32;
        ActivityRecord activity = this.mTmpUpdateAllDrawn.removeLast();
        activity.updateAllDrawn();
        goto L30
    L32:
        finishHoldScreenUpdate();
        return;
    L34:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    L37:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    private void getBounds(Rect out, int rotation) {
        getBounds(out);
        int currentRotation = this.mDisplayInfo.rotation;
        int rotationDelta = RotationUtils.deltaRotation(currentRotation, rotation);
        if (rotationDelta != 1) goto L5;
    L6:
        out.set(0, 0, out.height(), out.width());
        return;
    L5:
        if (rotationDelta == 3) goto L6;
    }

    int getNaturalOrientation() {
        if (this.mBaseDisplayWidth > this.mBaseDisplayHeight) goto L5;
        return 1;
    L5:
        return 2;
    }

    int getNaturalConfigurationOrientation() {
        Configuration config = getConfiguration();
        if (config.windowConfiguration.getDisplayRotation() == 0) goto L5;
        Rect frame = this.mDisplayPolicy.getDecorInsetsInfo(0, this.mBaseDisplayWidth, this.mBaseDisplayHeight).mConfigFrame;
        if (frame.width() > frame.height()) goto L9;
        return 1;
    L9:
        return 2;
    L5:
        return config.orientation;
    }

    void performLayout(boolean initial, boolean updateInputWindows) {
        Trace.traceBegin(32, "performLayout");
        performLayoutNoTrace(initial, updateInputWindows);     // Catch: Throwable -> L6
        Trace.traceEnd(32);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    private void performLayoutNoTrace(boolean initial, boolean updateInputWindows) {
        if (isLayoutNeeded() == true) goto L5;
        return;
    L5:
        clearLayoutNeeded();
        if (WindowManagerDebugConfig.DEBUG_LAYOUT == false) goto L8;
        Slog.v(TAG, "-------------------------------------");
        Slog.v(TAG, "performLayout: dw=" + this.mDisplayInfo.logicalWidth + " dh=" + this.mDisplayInfo.logicalHeight);
    L8:
        int seq = this.mLayoutSeq + 1;
        if (seq >= 0) goto L11;
        seq = 0;
    L11:
        this.mLayoutSeq = seq;
        this.mTmpInitial = initial;
        forAllWindows(this.mPerformLayout, true);
        forAllWindows(this.mPerformLayoutAttached, true);
        this.mInputMonitor.setUpdateInputWindowsNeededLw();
        if (updateInputWindows == false) goto L15;
        this.mInputMonitor.updateInputWindowsLw(false);
        return;
    }

    ScreenCapture.LayerCaptureArgs getLayerCaptureArgs(final ToBooleanFunction<WindowState> predicate) {
        if (this.mWmService.mPolicy.isScreenOn() == false) goto L5;
        getBounds(this.mTmpRect);
        this.mTmpRect.offsetTo(0, 0);
        ScreenCapture.LayerCaptureArgs.Builder builder = new ScreenCapture.LayerCaptureArgs.Builder(getSurfaceControl()).setSourceCrop(this.mTmpRect);
        if (predicate == null) goto L15;
        final ArrayList<SurfaceControl> excludeLayers = new ArrayList();
        forAllWindows(new DisplayContent$$ExternalSyntheticLambda52(predicate, excludeLayers), true);
        if (excludeLayers.isEmpty() == true) goto L15;
        builder.setExcludeLayers((SurfaceControl[]) excludeLayers.toArray(new SurfaceControl[0]));
    L15:
        return builder.build();
    L5:
        if (WindowManagerDebugConfig.DEBUG_SCREENSHOT == false) goto L16;
        Slog.i(TAG, "Attempted to take screenshot while display was off.");
        return null;
    L16:
        return null;
    }

    private static /* synthetic */ void lambda$getLayerCaptureArgs$29(ToBooleanFunction predicate, ArrayList excludeLayers, WindowState window) {
        if (predicate.apply(window) == true) goto L6;
        excludeLayers.add(window.mSurfaceControl);
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void onDescendantOverrideConfigurationChanged() {
        setLayoutNeeded();
        this.mWmService.requestTraversal();
    }

    @Override // com.android.server.wm.WindowContainer
    boolean okToDisplay() {
        return okToDisplay(false, false);
    }

    boolean okToDisplay(boolean ignoreFrozen, boolean ignoreScreenOn) {
        if (this.mDisplayId != 0) goto L13;
        if (this.mWmService.mDisplayEnabled == false) goto L16;
        if (ignoreScreenOn == true) goto L11;
        if (this.mWmService.mPolicy.isScreenOn() == true) goto L11;
        return false;
    L11:
        return true;
    L16:
        return false;
    L13:
        if (this.mDisplayInfo.state == 2) goto L15;
        return false;
    L15:
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean okToAnimate(boolean ignoreFrozen, boolean ignoreScreenOn) {
        if (okToDisplay(ignoreFrozen, ignoreScreenOn) == true) goto L5;
    L13:
        return false;
    L5:
        if (this.mDisplayId == 0) goto L7;
    L9:
        if (ignoreFrozen == false) goto L11;
    L12:
        return true;
    L11:
        if (this.mDisplayPolicy.isScreenOnFully() == false) goto L13;
    L7:
        if (this.mWmService.mPolicy.okToAnimate(ignoreScreenOn) == false) goto L13;
        goto L9
    }

    @Override // com.android.server.wm.WindowContainer
    SurfaceControl.Builder makeChildSurface(WindowContainer child) {
        SurfaceControl.Builder b = this.mWmService.makeSurfaceBuilder().setContainerLayer();
        if (child != null) goto L6;
        return b;
    L6:
        return b.setName(child.getName()).setParent(this.mSurfaceControl);
    }

    SurfaceControl.Builder makeOverlay() {
        return this.mWmService.makeSurfaceBuilder().setParent(getOverlayLayer());
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public SurfaceControl.Builder makeAnimationLeash() {
        return this.mWmService.makeSurfaceBuilder().setParent(this.mSurfaceControl).setContainerLayer();
    }

    void reparentToOverlay(SurfaceControl.Transaction transaction, SurfaceControl surface) {
        transaction.reparent(surface, getOverlayLayer());
    }

    void applyMagnificationSpec(MagnificationSpec spec) {
        if (spec.scale == 1.0d) goto L5;
        this.mMagnificationSpec = spec;
    L6:
        updateImeParent();
        if (spec.scale == 1.0d) goto L9;
        applyMagnificationSpec(getPendingTransaction(), spec);
    L10:
        getPendingTransaction().apply();
        return;
    L9:
        clearMagnificationSpec(getPendingTransaction());
        goto L10
    L5:
        this.mMagnificationSpec = null;
        goto L6
    }

    void reapplyMagnificationSpec() {
        if (this.mMagnificationSpec == null) goto L6;
        applyMagnificationSpec(getPendingTransaction(), this.mMagnificationSpec);
        return;
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    void onParentChanged(ConfigurationContainer newParent, ConfigurationContainer oldParent) {
        if (isReady() == true) goto L12;
        this.mDisplayReady = true;
        if (this.mWmService.mDisplayManagerInternal == null) goto L8;
        setDisplayInfoOverride();
        configureDisplayPolicy();
    L8:
        if (this.isDefaultDisplay == true) goto L10;
        this.mDisplayRotation.updateRotationUnchecked(true);
    L10:
        reconfigureDisplayLocked();
        onRequestedOverrideConfigurationChanged(getRequestedOverrideConfiguration());
        this.mWmService.mDisplayNotificationController.dispatchDisplayAdded(this);
        registerSystemUiContext();
        return;
    }

    private void registerSystemUiContext() {
        Context systemUiContext = getDisplayUiContext();
        WindowProcessController wpc = this.mAtmService.getProcessController(systemUiContext.getIApplicationThread());
        this.mWmService.mWindowContextListenerController.registerWindowContainerListener(wpc, systemUiContext.getWindowContextToken(), this, -1, null);
        if (wpc != null) goto L6;
        Slog.w(TAG, "Failed to register SystemUI context for " + this + ": WindowProcessController not found for " + systemUiContext.getIApplicationThread());
        return;
    L6:
        systemUiContext.registerComponentCallbacks(this.mSysUiContextConfigCallback);
    }

    @Override // com.android.server.wm.WindowContainer
    void assignChildLayers(SurfaceControl.Transaction t) {
        assignRelativeLayerForIme(t, false);
        super.assignChildLayers(t);
    }

    private void assignRelativeLayerForIme(SurfaceControl.Transaction t, boolean forceUpdate) {
        if (this.mImeWindowsContainer.isOrganized() == true) goto L5;
        this.mImeWindowsContainer.setNeedsLayer();
        WindowState imeTarget = this.mImeLayeringTarget;
        if (imeTarget == null) goto L41;
        if (imeTarget.mActivityRecord == null) goto L15;
        if (imeTarget.mActivityRecord.hasStartingWindow() == true) goto L41;
    L15:
        if (this.mImeControlTarget != null) goto L17;
    L19:
        WindowToken imeControlTargetToken = null;
    L21:
        if (imeTarget.getSurfaceControl() != null) goto L23;
    L27:
        boolean canImeTargetSetRelativeLayer = false;
    L29:
        if (canImeTargetSetRelativeLayer == false) goto L41;
        if (imeTarget.mActivityRecord != null) goto L33;
    L38:
        this.mImeWindowsContainer.assignRelativeLayer(t, imeTarget.getSurfaceControl(), 1, forceUpdate);
        return;
    L33:
        if (InputMethodManagerInternal.get().isAiPanelShow() == false) goto L38;
        if (imeTarget.mActivityRecord.getExt().hasSubPanel() == false) goto L38;
        this.mImeWindowsContainer.assignRelativeLayer(t, imeTarget.mActivityRecord.getSurfaceControl(), 1, forceUpdate);
        Slog.w(TAG, "assign the ime layer to activity record");
        return;
    L23:
        if (imeTarget.mToken != imeControlTargetToken) goto L27;
        if (imeTarget.inMultiWindowMode() == true) goto L27;
        canImeTargetSetRelativeLayer = true;
        goto L29
    L17:
        if (this.mImeControlTarget.getWindow() == null) goto L19;
        imeControlTargetToken = this.mImeControlTarget.getWindow().mToken;
    L41:
        if (this.mInputMethodSurfaceParent == null) goto L45;
        this.mImeWindowsContainer.assignRelativeLayer(t, this.mInputMethodSurfaceParent, 1, forceUpdate);
        return;
    L45:
        return;
    L5:
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L44;
        Slog.i(TAG, "ImeContainer is organized. Skip assignRelativeLayerForIme.");
        return;
    }

    void assignRelativeLayerForImeTargetChild(SurfaceControl.Transaction t, WindowContainer child) {
        child.assignRelativeLayer(t, this.mImeWindowsContainer.getSurfaceControl(), 1);
    }

    @Override // com.android.server.wm.DisplayArea.Dimmable, com.android.server.wm.WindowContainer
    void prepareSurfaces() {
        Trace.traceBegin(32, "prepareSurfaces");
        super.prepareSurfaces();     // Catch: Throwable -> L6
        Trace.traceEnd(32);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    void deferUpdateImeTarget() {
        if (this.mDeferUpdateImeTargetCount != 0) goto L5;
        this.mUpdateImeRequestedWhileDeferred = false;
    L5:
        this.mDeferUpdateImeTargetCount++;
    }

    void continueUpdateImeTarget() {
        if (this.mDeferUpdateImeTargetCount != 0) goto L5;
        return;
    L5:
        this.mDeferUpdateImeTargetCount--;
        if (this.mDeferUpdateImeTargetCount == 0) goto L8;
        return;
    L8:
        if (this.mUpdateImeRequestedWhileDeferred == false) goto L12;
        computeImeTarget(true);
        return;
    }

    private boolean canUpdateImeTarget() {
        if (this.mDeferUpdateImeTargetCount != 0) goto L5;
        return true;
    L5:
        return false;
    }

    InputMonitor getInputMonitor() {
        return this.mInputMonitor;
    }

    boolean getLastHasContent() {
        return this.mLastHasContent;
    }

    void setLastHasContent() {
        this.mLastHasContent = true;
    }

    void registerPointerEventListener(WindowManagerPolicyConstants.PointerEventListener listener) {
        this.mPointerEventDispatcher.registerInputEventListener(listener);
    }

    void unregisterPointerEventListener(WindowManagerPolicyConstants.PointerEventListener listener) {
        this.mPointerEventDispatcher.unregisterInputEventListener(listener);
    }

    void requestTransitionAndLegacyPrepare(int transit, int flags, WindowContainer trigger) {
        this.mTransitionController.requestTransitionIfNeeded(transit, flags, trigger, this);
    }

    void executeAppTransition() {
        this.mTransitionController.setReady(this);
    }

    boolean isNextTransitionForward() {
        int type = this.mTransitionController.getCollectingTransitionType();
        if (type != 1) goto L5;
        return true;
    L5:
        if (type == 3) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean shouldNeverShowSystemDecorations() {
        if (this.mDisplayId != this.mWmService.mVr2dDisplayId) goto L6;
        return true;
    L6:
        if (isTrusted() == true) goto L8;
        return true;
    L8:
        return false;
    }

    boolean isSystemDecorationsSupported() {
        if (shouldNeverShowSystemDecorations() == false) goto L6;
        return false;
    L6:
        if (this.mWmService.mDisplayWindowSettings.shouldShowSystemDecorsLocked(this) == false) goto L8;
    L19:
        return true;
    L8:
        if ((this.mDisplay.getFlags() & 64) != 0) goto L19;
        if (DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT.isTrue() == false) goto L13;
    L18:
        return false;
    L13:
        if (isPublicSecondaryDisplayWithDesktopModeForceEnabled() == false) goto L18;
        if ((this.mDisplay.getFlags() & 8192) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    boolean isPublicSecondaryDisplayWithDesktopModeForceEnabled() {
        if (this.mWmService.mForceDesktopModeOnExternalDisplays == true) goto L5;
    L13:
        return false;
    L5:
        if (this.isDefaultDisplay == true) goto L13;
        if (isPrivate() == true) goto L13;
        int deviceId = this.mRootWindowContainer.mTaskSupervisor.getDeviceIdForDisplayId(this.mDisplayId);
        if (deviceId != 0) goto L14;
        return true;
    L14:
        return false;
    }

    boolean isHomeSupported() {
        if (this.mWmService.mDisplayWindowSettings.isHomeSupportedLocked(this) == false) goto L7;
        if (isTrusted() == false) goto L7;
    L8:
        return true;
    L7:
        if (isSystemDecorationsSupported() == true) goto L8;
        return false;
    }

    boolean isDisplayIgnoreActivitySizeRestrictions() {
        return this.mIgnoreActivitySizeRestrictions;
    }

    SurfaceControl getWindowingLayer() {
        return this.mDisplayAreaPolicy.getWindowingArea().mSurfaceControl;
    }

    DisplayArea.Tokens getImeContainer() {
        return this.mImeWindowsContainer;
    }

    SurfaceControl getOverlayLayer() {
        return this.mOverlayLayer;
    }

    SurfaceControl getInputOverlayLayer() {
        return this.mInputOverlayLayer;
    }

    SurfaceControl getA11yOverlayLayer() {
        return this.mA11yOverlayLayer;
    }

    SurfaceControl[] findRoundedCornerOverlays() {
        List<SurfaceControl> roundedCornerOverlays = new ArrayList();
        Iterator<WindowToken> r1 = this.mTokenMap.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        WindowToken token = r1.next();
        if (token.mRoundedCornerOverlay == false) goto L4;
        if (token.isVisible() == false) goto L4;
        roundedCornerOverlays.add(token.mSurfaceControl);
        goto L4
    L12:
        return (SurfaceControl[]) roundedCornerOverlays.toArray(new SurfaceControl[0]);
    }

    boolean updateSystemGestureExclusion() {
        if (this.mSystemGestureExclusionListeners.getRegisteredCallbackCount() != 0) goto L5;
        return false;
    L5:
        Region systemGestureExclusion = Region.obtain();
        if (LostModeUtil.beingLostModeEnabled(getDisplayUiContext()) == false) goto L8;
        this.mSystemGestureExclusionWasRestricted = false;
        systemGestureExclusion.set(0, 0, this.mDisplayInfo.logicalWidth, this.mDisplayInfo.logicalHeight);
        this.mSystemGestureExclusionUnrestricted.set(systemGestureExclusion);
    L35:
    L16:
        th = move-exception;
        systemGestureExclusion.recycle();
        throw th;
    L10:
        if (this.mSystemGestureExclusion.equals(systemGestureExclusion) == false) goto L14;
        systemGestureExclusion.recycle();
        return false;
    L14:
        if (this.mTransitionController.getExt().isInRecentsFromRemote() == false) goto L18;
        systemGestureExclusion.setEmpty();     // Catch: Throwable -> L16
    L18:
        this.mSystemGestureExclusion.set(systemGestureExclusion);     // Catch: Throwable -> L16
        if (this.mSystemGestureExclusionWasRestricted == false) goto L21;
        Region unrestrictedOrNull = this.mSystemGestureExclusionUnrestricted;     // Catch: Throwable -> L16
    L23:
        int i = this.mSystemGestureExclusionListeners.beginBroadcast() - 1;
    L24:
        if (i < 0) goto L30;
        this.mSystemGestureExclusionListeners.getBroadcastItem(i).onSystemGestureExclusionChanged(this.mDisplayId, systemGestureExclusion, unrestrictedOrNull);     // Catch: Throwable -> L16 RemoteException -> L27
    L29:
        i = i - 1;     // Catch: Throwable -> L16
    L27:
        e = move-exception;
        Slog.e(TAG, "Failed to notify SystemGestureExclusionListener", e);     // Catch: Throwable -> L16
        goto L29
    L30:
        this.mSystemGestureExclusionListeners.finishBroadcast();     // Catch: Throwable -> L16
        systemGestureExclusion.recycle();
        return true;
    L21:
        unrestrictedOrNull = null;
        goto L23
    L8:
        this.mSystemGestureExclusionWasRestricted = calculateSystemGestureExclusion(systemGestureExclusion, this.mSystemGestureExclusionUnrestricted);
        goto L35
    }

    boolean calculateSystemGestureExclusion(final Region outExclusion, final Region outExclusionUnrestricted) {
        outExclusion.setEmpty();
        if (outExclusionUnrestricted == null) goto L5;
        outExclusionUnrestricted.setEmpty();
    L5:
        final Region unhandled = Region.obtain();
        unhandled.set(0, 0, this.mDisplayFrames.mWidth, this.mDisplayFrames.mHeight);
        InsetsState state = this.mInsetsStateController.getRawInsetsState();
        Rect df = state.getDisplayFrame();
        Insets gestureInsets = state.calculateInsets(df, WindowInsets.Type.systemGestures(), false);
        this.mSystemGestureFrameLeft.set(df.left, df.top, df.left + gestureInsets.left, df.bottom);
        this.mSystemGestureFrameRight.set(df.right - gestureInsets.right, df.top, df.right, df.bottom);
        final Region touchableRegion = Region.obtain();
        final Region local = Region.obtain();
        final int[] remainingLeftRight = {this.mSystemGestureExclusionLimit, this.mSystemGestureExclusionLimit};
        forAllWindows(new DisplayContent$$ExternalSyntheticLambda15(this, unhandled, touchableRegion, local, remainingLeftRight, outExclusion, outExclusionUnrestricted), true);
        local.recycle();
        touchableRegion.recycle();
        unhandled.recycle();
        if (remainingLeftRight[0] < this.mSystemGestureExclusionLimit) goto L10;
        if (remainingLeftRight[1] < this.mSystemGestureExclusionLimit) goto L10;
        return false;
    L10:
        return true;
    }

    private /* synthetic */ void lambda$calculateSystemGestureExclusion$30(Region unhandled, Region touchableRegion, Region local, int[] remainingLeftRight, Region outExclusion, Region outExclusionUnrestricted, WindowState w) {
        if (w.canReceiveTouchInput() == true) goto L5;
        return;
    L5:
        if (w.isVisible() == true) goto L7;
        return;
    L7:
        if ((w.mAttrs.flags & 16) == 0) goto L9;
        return;
    L9:
        if (unhandled.isEmpty() == false) goto L12;
        return;
    L12:
        if (Features.FEAT_QUICK_WIN == true) goto L14;
    L16:
        w.getEffectiveTouchableRegion(touchableRegion);
        touchableRegion.op(unhandled, Region.Op.INTERSECT);
        if (w.isImplicitlyExcludingAllSystemGestures() == false) goto L19;
        local.set(touchableRegion);
    L21:
        if (needsGestureExclusionRestrictions(w, false) == false) goto L23;
        remainingLeftRight[0] = addToGlobalAndConsumeLimit(local, outExclusion, this.mSystemGestureFrameLeft, remainingLeftRight[0], w, 0);
        remainingLeftRight[1] = addToGlobalAndConsumeLimit(local, outExclusion, this.mSystemGestureFrameRight, remainingLeftRight[1], w, 1);
        Region middle = Region.obtain(local);
        middle.op(this.mSystemGestureFrameLeft, Region.Op.DIFFERENCE);
        middle.op(this.mSystemGestureFrameRight, Region.Op.DIFFERENCE);
        outExclusion.op(middle, Region.Op.UNION);
        middle.recycle();
    L27:
        if (outExclusionUnrestricted == null) goto L29;
        outExclusionUnrestricted.op(local, Region.Op.UNION);
    L29:
        unhandled.op(touchableRegion, Region.Op.DIFFERENCE);
        return;
    L23:
        boolean loggable = needsGestureExclusionRestrictions(w, true);
        if (loggable == false) goto L26;
        addToGlobalAndConsumeLimit(local, outExclusion, this.mSystemGestureFrameLeft, Integer.MAX_VALUE, w, 0);
        addToGlobalAndConsumeLimit(local, outExclusion, this.mSystemGestureFrameRight, Integer.MAX_VALUE, w, 1);
    L26:
        outExclusion.op(local, Region.Op.UNION);
        goto L27
    L19:
        RegionUtils.rectListToRegion(w.getSystemGestureExclusion(), local);
        local.scale(w.mGlobalScale);
        Rect frame = w.getWindowFrames().mFrame;
        local.translate(frame.left, frame.top);
        local.op(touchableRegion, Region.Op.INTERSECT);
        goto L21
    L14:
        if (w.inFreeformWindowingMode() == false) goto L16;
    }

    private static boolean needsGestureExclusionRestrictions(WindowState win, boolean ignoreRequest) {
        int type = win.mAttrs.type;
        int privateFlags = win.mAttrs.privateFlags;
        if (win.isRequestedVisible(WindowInsets.Type.navigationBars()) == false) goto L5;
    L7:
        boolean stickyHideNav = false;
    L8:
        if (stickyHideNav == false) goto L11;
        if (ignoreRequest == true) goto L11;
        return false;
    L11:
        if (type != 2011) goto L13;
        return false;
    L13:
        if (type != 2040) goto L15;
        return false;
    L15:
        if (win.getActivityType() != 2) goto L17;
        return false;
    L17:
        if ((privateFlags & 32) == 0) goto L20;
        return false;
    L20:
        return true;
    L5:
        if (win.mAttrs.insetsFlags.behavior != 2) goto L7;
        stickyHideNav = true;
        goto L8
    }

    static boolean logsGestureExclusionRestrictions(WindowState win) {
        if (win.mWmService.mConstants.mSystemGestureExclusionLogDebounceTimeoutMillis > 0) goto L5;
        return false;
    L5:
        WindowManager.LayoutParams attrs = win.mAttrs;
        int type = attrs.type;
        if (type != 2013) goto L8;
        return false;
    L8:
        if (type != 3) goto L10;
        return false;
    L10:
        if (type != 2019) goto L12;
        return false;
    L12:
        if ((attrs.flags & 16) == 0) goto L14;
        return false;
    L14:
        if (needsGestureExclusionRestrictions(win, true) == true) goto L16;
        return false;
    L16:
        if (win.getDisplayContent().mDisplayPolicy.hasSideGestures() == true) goto L19;
        return false;
    L19:
        return true;
    }

    private static int addToGlobalAndConsumeLimit(Region local, final Region global, Rect edge, int limit, WindowState win, int side) {
        Region r = Region.obtain(local);
        r.op(edge, Region.Op.INTERSECT);
        final int[] remaining = {limit};
        final int[] requestedExclusion = {0};
        RegionUtils.forEachRectReverse(r, new DisplayContent$$ExternalSyntheticLambda1(remaining, requestedExclusion, global));
        int grantedExclusion = limit - remaining[0];
        win.setLastExclusionHeights(side, requestedExclusion[0], grantedExclusion);
        r.recycle();
        return remaining[0];
    }

    private static /* synthetic */ void lambda$addToGlobalAndConsumeLimit$31(int[] remaining, int[] requestedExclusion, Region global, Rect rect) {
        if (remaining[0] > 0) goto L5;
        return;
    L5:
        int height = rect.height();
        requestedExclusion[0] = requestedExclusion[0] + height;
        if (height <= remaining[0]) goto L8;
        rect.top = rect.bottom - remaining[0];
    L8:
        remaining[0] = remaining[0] - height;
        global.op(rect, Region.Op.UNION);
    }

    void registerSystemGestureExclusionListener(ISystemGestureExclusionListener listener) {
        this.mSystemGestureExclusionListeners.register(listener);
        if (this.mSystemGestureExclusionListeners.getRegisteredCallbackCount() != 1) goto L5;
        boolean changed = updateSystemGestureExclusion();
    L6:
        if (changed == false) goto L8;
        return;
    L8:
        if (this.mSystemGestureExclusionWasRestricted == false) goto L10;
        Region unrestrictedOrNull = this.mSystemGestureExclusionUnrestricted;
    L16:
        listener.onSystemGestureExclusionChanged(this.mDisplayId, this.mSystemGestureExclusion, unrestrictedOrNull);     // Catch: RemoteException -> L13
        return;
    L13:
        e = move-exception;
        Slog.e(TAG, "Failed to notify SystemGestureExclusionListener during register", e);
        return;
    L10:
        unrestrictedOrNull = null;
        goto L16
    L5:
        changed = false;
        goto L6
    }

    void unregisterSystemGestureExclusionListener(ISystemGestureExclusionListener listener) {
        this.mSystemGestureExclusionListeners.unregister(listener);
    }

    void registerDecorViewGestureListener(IDecorViewGestureListener listener) {
        this.mDecorViewGestureListener.register(listener);
    }

    void unregisterDecorViewGestureListener(IDecorViewGestureListener listener) {
        this.mDecorViewGestureListener.unregister(listener);
    }

    void updateDecorViewGestureIntercepted(IBinder token, boolean intercepted) {
        int i = this.mDecorViewGestureListener.beginBroadcast() - 1;
    L3:
        if (i < 0) goto L9;
        this.mDecorViewGestureListener.getBroadcastItem(i).onInterceptionChanged(token, intercepted);     // Catch: RemoteException -> L6
    L8:
        i = i - 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to notify DecorViewGestureListener", e);
        goto L8
    L9:
        this.mDecorViewGestureListener.finishBroadcast();
    }

    void updateKeepClearAreas() {
        Set<Rect> restrictedKeepClearAreas = new ArraySet();
        Set<Rect> unrestrictedKeepClearAreas = new ArraySet();
        getKeepClearAreas(restrictedKeepClearAreas, unrestrictedKeepClearAreas);
        if (this.mRestrictedKeepClearAreas.equals(restrictedKeepClearAreas) == true) goto L5;
    L6:
        this.mRestrictedKeepClearAreas = restrictedKeepClearAreas;
        this.mUnrestrictedKeepClearAreas = unrestrictedKeepClearAreas;
        this.mWmService.mDisplayNotificationController.dispatchKeepClearAreasChanged(this, restrictedKeepClearAreas, unrestrictedKeepClearAreas);
        return;
    L5:
        if (this.mUnrestrictedKeepClearAreas.equals(unrestrictedKeepClearAreas) == false) goto L6;
    }

    void getKeepClearAreas(final Set<Rect> outRestricted, final Set<Rect> outUnrestricted) {
        final Matrix tmpMatrix = new Matrix();
        final float[] tmpFloat9 = new float[9];
        forAllWindows(new DisplayContent$$ExternalSyntheticLambda3(outRestricted, outUnrestricted, tmpMatrix, tmpFloat9), true);
    }

    private static /* synthetic */ boolean lambda$getKeepClearAreas$33(Set outRestricted, final Set outUnrestricted, Matrix tmpMatrix, float[] tmpFloat9, WindowState w) {
        if (w.isVisible() == false) goto L10;
        if (w.inPinnedWindowingMode() == true) goto L10;
        w.getKeepClearAreas(outRestricted, outUnrestricted, tmpMatrix, tmpFloat9);
        if (w.mIsImWindow == false) goto L10;
        Region touchableRegion = Region.obtain();
        w.getEffectiveTouchableRegion(touchableRegion);
        RegionUtils.forEachRect(touchableRegion, new DisplayContent$$ExternalSyntheticLambda9(outUnrestricted));
        touchableRegion.recycle();
    L10:
        if (w.getWindowType() == 1) goto L12;
    L14:
        return false;
    L12:
        if (w.getWindowingMode() != 1) goto L14;
        return true;
    }

    private static /* synthetic */ void lambda$getKeepClearAreas$32(Set outUnrestricted, Rect rect) {
        outUnrestricted.add(rect);
    }

    Set<Rect> getKeepClearAreas() {
        Set<Rect> keepClearAreas = new ArraySet();
        getKeepClearAreas(keepClearAreas, keepClearAreas);
        return keepClearAreas;
    }

    protected MetricsLogger getMetricsLogger() {
        if (this.mMetricsLogger != null) goto L6;
        this.mMetricsLogger = new MetricsLogger();
    L6:
        return this.mMetricsLogger;
    }

    void requestDisplayUpdate(Runnable onDisplayChangeApplied) {
        this.mAtmService.deferWindowLayout();
        this.mDisplayUpdater.updateDisplayInfo(onDisplayChangeApplied);     // Catch: Throwable -> L6
        this.mAtmService.continueWindowLayout();
        return;
    L6:
        th = move-exception;
        this.mAtmService.continueWindowLayout();
        throw th;
    }

    void onDisplayInfoUpdated(DisplayInfo newDisplayInfo) {
        int lastDisplayState = this.mDisplayInfo.state;
        updateDisplayInfo(newDisplayInfo);
        int displayId = this.mDisplay.getDisplayId();
        int displayState = this.mDisplayInfo.state;
        if (displayId != 0) goto L5;
    L15:
        this.mWallpaperController.resetLargestDisplay(this.mDisplay);
        if (Display.isSuspendedState(lastDisplayState) == true) goto L18;
    L21:
        this.mWmService.requestTraversal();
        return;
    L18:
        if (Display.isSuspendedState(displayState) == true) goto L21;
        if (displayState == 0) goto L21;
        this.mWmService.mWindowContextListenerController.dispatchPendingConfigurationIfNeeded(this.mDisplayId);
        goto L21
    L5:
        if (displayState != 1) goto L8;
        this.mRootWindowContainer.mDisplayOffTokenAcquirer.acquire(this.mDisplayId);
    L10:
        ObricAutoActionDisplayStateReporter.reportWmDisplayStateChanged(this.mDisplayId, this.mDisplayInfo.name, this.mDisplayInfo.ownerPackageName, this.mDisplayInfo.type, lastDisplayState, displayState);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L13;
        long protoLogParam0 = this.mDisplayId;
        long protoLogParam1 = lastDisplayState;
        long protoLogParam2 = displayState;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -8165317816061445169L, 21, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});
    L13:
        if (lastDisplayState == displayState) goto L15;
        updateRecording();
        goto L15
    L8:
        if (displayState != 2) goto L10;
        this.mRootWindowContainer.mDisplayOffTokenAcquirer.release(this.mDisplayId);
        goto L10
    }

    static boolean alwaysCreateRootTask(int windowingMode, int activityType) {
        if (activityType != 1) goto L5;
    L6:
        if (windowingMode != 1) goto L8;
        return true;
    L8:
        if (windowingMode != 5) goto L10;
        return true;
    L10:
        if (windowingMode != 2) goto L12;
        return true;
    L12:
        if (windowingMode == 6) goto L19;
    L14:
        return false;
    L19:
        return true;
    L5:
        if (activityType != 3) goto L14;
        goto L6
    }

    Task getFocusedRootTask() {
        return (Task) getItemFromTaskDisplayAreas(new DisplayContent$$ExternalSyntheticLambda20());
    }

    void removeRootTasksInWindowingModes(final int... windowingModes) {
        if (windowingModes != null) goto L4;
        return;
    L4:
        if (windowingModes.length == 0) goto L13;
        final ArrayList<Task> rootTasks = new ArrayList();
        forAllRootTasks(new DisplayContent$$ExternalSyntheticLambda12(windowingModes, rootTasks));
        int i = rootTasks.size() - 1;
    L7:
        if (i < 0) goto L10;
        this.mRootWindowContainer.mTaskSupervisor.removeRootTask(rootTasks.get(i));
        i = i - 1;
        goto L7
    L10:
        return;
    }

    private static /* synthetic */ void lambda$removeRootTasksInWindowingModes$34(int[] windowingModes, ArrayList rootTasks, Task rootTask) {
        int r0 = windowingModes.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        int windowingMode = windowingModes[r1];
        if (rootTask.mCreatedByOrganizer == true) goto L12;
        if (rootTask.getWindowingMode() != windowingMode) goto L12;
        if (rootTask.isActivityTypeStandardOrUndefined() == false) goto L12;
        rootTasks.add(rootTask);
    L12:
        r1 = r1 + 1;
        goto L3
    }

    void removeRootTasksWithActivityTypes(final int... activityTypes) {
        if (activityTypes != null) goto L4;
        return;
    L4:
        if (activityTypes.length == 0) goto L13;
        final ArrayList<Task> rootTasks = new ArrayList();
        getDefaultTaskDisplayArea().forAllRootTasks(new DisplayContent$$ExternalSyntheticLambda21(activityTypes, rootTasks));
        int i = rootTasks.size() - 1;
    L7:
        if (i < 0) goto L10;
        this.mRootWindowContainer.mTaskSupervisor.removeRootTask(rootTasks.get(i));
        i = i - 1;
        goto L7
    L10:
        return;
    }

    private static /* synthetic */ void lambda$removeRootTasksWithActivityTypes$35(int[] activityTypes, ArrayList rootTasks, Task rootTask) {
        int r0 = activityTypes.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        int activityType = activityTypes[r1];
        if (rootTask.mCreatedByOrganizer == false) goto L14;
        int k = rootTask.getChildCount() - 1;
    L7:
        if (k < 0) goto L16;
        Task task = (Task) rootTask.getChildAt(k);
        if (task.getActivityType() != activityType) goto L11;
        rootTasks.add(task);
    L11:
        k = k - 1;
    L16:
        r1 = r1 + 1;
        goto L3
    L14:
        if (rootTask.getActivityType() != activityType) goto L16;
        rootTasks.add(rootTask);
        goto L16
    }

    ActivityRecord topRunningActivity() {
        return topRunningActivity(false);
    }

    ActivityRecord topRunningActivity(final boolean considerKeyguardState) {
        return (ActivityRecord) getItemFromTaskDisplayAreas(new DisplayContent$$ExternalSyntheticLambda13(considerKeyguardState));
    }

    private static /* synthetic */ ActivityRecord lambda$topRunningActivity$36(boolean considerKeyguardState, TaskDisplayArea taskDisplayArea) {
        return taskDisplayArea.topRunningActivity(considerKeyguardState);
    }

    boolean updateDisplayOverrideConfigurationLocked() {
        Configuration values = new Configuration();
        computeScreenConfiguration(values);
        this.mAtmService.mH.sendMessage(PooledLambda.obtainMessage(new ActivityTaskManagerService$$ExternalSyntheticLambda25(), this.mAtmService.mAmInternal, Integer.valueOf(this.mDisplayId)));
        Settings.System.clearConfiguration(values);
        updateDisplayOverrideConfigurationLocked(values, null, false);
        if (this.mAtmService.mTmpUpdateConfigurationResult.changes == 0) goto L6;
        return true;
    L6:
        return false;
    }

    boolean updateDisplayOverrideConfigurationLocked(Configuration values, ActivityRecord starting, boolean deferResume) {
        int changes = 0;
        boolean kept = true;
        this.mAtmService.deferWindowLayout();
        boolean r2 = false;
        if (values != null) goto L21;
    L11:
        if (deferResume == true) goto L16;
        kept = this.mAtmService.ensureConfigAndVisibilityAfterUpdate(starting, changes);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        this.mAtmService.continueWindowLayout();
        throw th;
    L16:
        this.mAtmService.continueWindowLayout();
        ActivityTaskManagerService.UpdateConfigurationResult r3 = this.mAtmService.mTmpUpdateConfigurationResult;
        if (kept == true) goto L19;
        r2 = true;
    L19:
        r3.activityRelaunched = r2;
        return kept;
    L21:
        if (this.mDisplayId != 0) goto L9;
        changes = this.mAtmService.updateGlobalConfigurationLocked(values, false, false, ProcessList.INVALID_ADJ);     // Catch: Throwable -> L7
    L10:
        this.mAtmService.mTmpUpdateConfigurationResult.changes = changes;     // Catch: Throwable -> L7
        goto L11
    L9:
        int changes2 = performDisplayOverrideConfigUpdate(values);     // Catch: Throwable -> L7
        changes = changes2;
        goto L10
    }

    int performDisplayOverrideConfigUpdate(Configuration values) {
        this.mTempConfig.setTo(getRequestedOverrideConfiguration());
        int changes = this.mTempConfig.updateFrom(values);
        if (changes == 0) goto L23;
        Slog.i(TAG, "Override config changes=" + Integer.toHexString(changes) + " " + this.mTempConfig + " for displayId=" + this.mDisplayId);
        if (isReady() == true) goto L7;
    L14:
        onRequestedOverrideConfigurationChanged(this.mTempConfig);
        if ((changes & 4096) == 0) goto L17;
        boolean isDensityChange = true;
    L18:
        if (isDensityChange == true) goto L20;
    L22:
        this.mWmService.mDisplayNotificationController.dispatchDisplayChanged(this, getConfiguration());
        goto L23
    L20:
        if (this.mDisplayId != 0) goto L22;
        this.mAtmService.mAppWarnings.onDensityChanged();
        SysOptBridge.getFactory().getSysPrefetchService().notifyDensityChanged();
        Message msg = PooledLambda.obtainMessage(new DisplayContent$$ExternalSyntheticLambda10(), this.mAtmService.mAmInternal, 24, 6);
        this.mAtmService.mH.sendMessage(msg);
        goto L22
    L17:
        isDensityChange = false;
        goto L18
    L7:
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L14;
        if (this.mLastHasContent == false) goto L14;
        Transition transition = this.mTransitionController.getCollectingTransition();
        if (transition == null) goto L13;
        collectDisplayChange(transition);
        goto L14
    L13:
        requestChangeTransition(changes, null);
    L23:
        return changes;
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void onRequestedOverrideConfigurationChanged(Configuration overrideConfiguration) {
        Configuration currOverrideConfig = getRequestedOverrideConfiguration();
        int currRotation = currOverrideConfig.windowConfiguration.getRotation();
        int overrideRotation = overrideConfiguration.windowConfiguration.getRotation();
        if (currRotation == (-1)) goto L7;
        if (overrideRotation == (-1)) goto L7;
        if (currRotation == overrideRotation) goto L7;
        applyRotationAndFinishFixedRotation(currRotation, overrideRotation);
    L7:
        this.mCurrentOverrideConfigurationChanges = currOverrideConfig.diff(overrideConfiguration);
        super.onRequestedOverrideConfigurationChanged(overrideConfiguration);
        this.mCurrentOverrideConfigurationChanges = 0;
        if (this.mWaitingForConfig == false) goto L10;
        this.mWaitingForConfig = false;
    L10:
        this.mAtmService.addWindowLayoutReasons(1);
    }

    @Override // com.android.server.wm.WindowContainer
    void onResize() {
        super.onResize();
        if (this.mWmService.mAccessibilityController.hasCallbacks() == false) goto L6;
        this.mWmService.mAccessibilityController.onDisplaySizeChanged(this);
        return;
    }

    private void applyRotationAndFinishFixedRotation(final int oldRotation, final int newRotation) {
        WindowToken rotatedLaunchingApp = this.mFixedRotationLaunchingApp;
        if (rotatedLaunchingApp != null) goto L6;
        applyRotation(oldRotation, newRotation);
        return;
    L6:
        rotatedLaunchingApp.finishFixedRotationTransform(new DisplayContent$$ExternalSyntheticLambda7(this, oldRotation, newRotation));
        setFixedRotationLaunchingAppUnchecked(null);
    }

    private /* synthetic */ void lambda$applyRotationAndFinishFixedRotation$37(int oldRotation, int newRotation) {
        applyRotation(oldRotation, newRotation);
    }

    void handleActivitySizeCompatModeIfNeeded(ActivityRecord r) {
        Task organizedTask = r.getOrganizedTask();
        if (organizedTask != null) goto L7;
        this.mActiveSizeCompatActivities.remove(r);
        return;
    L7:
        if (r.isState(ActivityRecord.State.RESUMED) == false) goto L15;
        if (r.inSizeCompatMode() == false) goto L15;
        if (this.mActiveSizeCompatActivities.add(r) == false) goto L18;
        organizedTask.onSizeCompatActivityChanged();
        return;
    L18:
        return;
    L15:
        if (this.mActiveSizeCompatActivities.remove(r) == false) goto L19;
        organizedTask.onSizeCompatActivityChanged();
        return;
    }

    boolean isUidPresent(int uid) {
        Predicate<ActivityRecord> r0 = PooledLambda.obtainPredicate(new DisplayContent$$ExternalSyntheticLambda8(), PooledLambda.__(ActivityRecord.class), Integer.valueOf(uid));
        if (this.mDisplayContent.getActivity(r0) == null) goto L5;
        boolean isUidPresent = true;
    L6:
        r0.recycle();
        return isUidPresent;
    L5:
        isUidPresent = false;
        goto L6
    }

    boolean isRemoved() {
        return this.mRemoved;
    }

    boolean isRemoving() {
        return this.mRemoving;
    }

    private void clearAllTasksOnDisplay(Runnable clearTasksCallback, final boolean isRemovingDisplay) {
        this.mRootWindowContainer.mTaskSupervisor.beginDeferResume();
        Task lastReparentedRootTask = (Task) reduceOnAllTaskDisplayAreas(new DisplayContent$$ExternalSyntheticLambda50(isRemovingDisplay), null, false);     // Catch: Throwable -> L10
        this.mRootWindowContainer.mTaskSupervisor.endDeferResume();
        if (clearTasksCallback == null) goto L7;
        clearTasksCallback.run();
    L7:
        if (lastReparentedRootTask == null) goto L15;
        lastReparentedRootTask.resumeNextFocusAfterReparent();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        this.mRootWindowContainer.mTaskSupervisor.endDeferResume();
        throw th;
    }

    private static /* synthetic */ Task lambda$clearAllTasksOnDisplay$38(boolean isRemovingDisplay, TaskDisplayArea taskDisplayArea, Task rootTask) {
        if (isRemovingDisplay == false) goto L4;
        Task lastReparentedRootTaskFromArea = taskDisplayArea.prepareForRemoval();
    L6:
        if (lastReparentedRootTaskFromArea == null) goto L8;
        return lastReparentedRootTaskFromArea;
    L8:
        return rootTask;
    L4:
        lastReparentedRootTaskFromArea = taskDisplayArea.setShouldKeepNoTask(true);
        goto L6
    }

    void remove() {
        this.mRemoving = true;
        getExt().remove(this.mWmService.mContext);
        if (getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L5;
        getObricExt().onDisplayRemoval();
    L5:
        clearAllTasksOnDisplay(new DisplayContent$$ExternalSyntheticLambda4(this), true);
        releaseSelfIfNeeded();
        this.mDisplayPolicy.release();
        if (this.mAllSleepTokens.isEmpty() == true) goto L9;
        this.mAllSleepTokens.forEach(new DisplayContent$$ExternalSyntheticLambda5(this));
        this.mAllSleepTokens.clear();
        this.mAtmService.updateSleepIfNeededLocked();
        return;
    }

    private /* synthetic */ void lambda$remove$39() {
        this.mRemoved = true;
        if (this.mContentRecorder == null) goto L6;
        this.mContentRecorder.stopRecording();
        return;
    }

    private /* synthetic */ void lambda$remove$40(RootWindowContainer.SleepToken token) {
        this.mRootWindowContainer.mSleepTokens.remove(token.mHashKey);
    }

    void releaseSelfIfNeeded() {
        if (this.mRemoved == true) goto L5;
        return;
    L5:
        boolean hasNonEmptyHomeRootTask = forAllRootTasks(new DisplayContent$$ExternalSyntheticLambda16());
        if (hasNonEmptyHomeRootTask == true) goto L11;
        if (getRootTaskCount() <= 0) goto L11;
        forAllRootTasks(new DisplayContent$$ExternalSyntheticLambda17());
        return;
    L11:
        if (getTopRootTask() != null) goto L15;
        removeIfPossible();
        return;
    }

    private static /* synthetic */ boolean lambda$releaseSelfIfNeeded$41(Task rootTask) {
        if (rootTask.isActivityTypeHome() == true) goto L5;
    L8:
        return true;
    L5:
        if (rootTask.hasChild() == true) goto L8;
        return false;
    }

    private static /* synthetic */ void lambda$releaseSelfIfNeeded$42(Task t) {
        t.removeIfPossible("releaseSelfIfNeeded");
    }

    IntArray getPresentUIDs() {
        this.mDisplayAccessUIDs.clear();
        this.mDisplayContent.forAllActivities(new DisplayContent$$ExternalSyntheticLambda29(this));
        return this.mDisplayAccessUIDs;
    }

    private /* synthetic */ void lambda$getPresentUIDs$43(ActivityRecord r) {
        this.mDisplayAccessUIDs.add(r.getUid());
    }

    boolean shouldDestroyContentOnRemove() {
        if (getRemoveContentMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    int getRemoveContentMode() {
        return this.mWmService.mDisplayWindowSettings.getRemoveContentModeLocked(this);
    }

    boolean shouldSleep() {
        if (getRootTaskCount() == 0) goto L7;
        if (this.mAllSleepTokens.isEmpty() == false) goto L7;
    L9:
        return false;
    L7:
        if (this.mAtmService.mRunningVoice != null) goto L9;
        return true;
    }

    void ensureActivitiesVisible(final ActivityRecord starting, final boolean notifyClients) {
        if (this.mInEnsureActivitiesVisible == false) goto L5;
        return;
    L5:
        this.mAtmService.mTaskSupervisor.beginActivityVisibilityUpdate();
        this.mInEnsureActivitiesVisible = true;     // Catch: Throwable -> L14
        forAllRootTasks(new DisplayContent$$ExternalSyntheticLambda27(starting, notifyClients));     // Catch: Throwable -> L14
        if (this.mTransitionController.useShellTransitionsRotation() == true) goto L9;
    L16:
        this.mAtmService.mTaskSupervisor.endActivityVisibilityUpdate();
        this.mInEnsureActivitiesVisible = false;
        return;
    L9:
        if (this.mTransitionController.isCollecting() == false) goto L16;
        if (this.mWallpaperController.getWallpaperTarget() == null) goto L16;
        this.mWallpaperController.adjustWallpaperWindows();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mAtmService.mTaskSupervisor.endActivityVisibilityUpdate();
        this.mInEnsureActivitiesVisible = false;
        throw th;
    }

    private static /* synthetic */ void lambda$ensureActivitiesVisible$44(ActivityRecord starting, boolean notifyClients, Task rootTask) {
        rootTask.ensureActivitiesVisible(starting, notifyClients);
    }

    boolean isSleeping() {
        return this.mSleeping;
    }

    void setIsSleeping(boolean asleep) {
        this.mSleeping = asleep;
    }

    void notifyKeyguardFlagsChanged() {
        if (isKeyguardLocked() == true) goto L5;
        return;
    L5:
        this.mRootWindowContainer.ensureActivitiesVisible();
        executeAppTransition();
    }

    boolean canShowWithInsecureKeyguard() {
        int flags = this.mDisplay.getFlags();
        if ((flags & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isKeyguardLocked() {
        return this.mRootWindowContainer.mTaskSupervisor.getKeyguardController().isKeyguardLocked(this.mDisplayId);
    }

    boolean isKeyguardLockedOrAodShowing() {
        if (isKeyguardLocked() == false) goto L5;
    L8:
        return true;
    L5:
        if (isAodShowing() == true) goto L8;
        return false;
    }

    boolean isAodShowing() {
        boolean isAodShowing = this.mRootWindowContainer.mTaskSupervisor.getKeyguardController().isAodShowing(this.mDisplayId);
        if (this.mDisplayId != 0) goto L7;
        if (isAodShowing == false) goto L7;
        return !isKeyguardGoingAway();
    L7:
        return isAodShowing;
    }

    boolean isKeyguardGoingAway() {
        return this.mRootWindowContainer.mTaskSupervisor.getKeyguardController().isKeyguardGoingAway(this.mDisplayId);
    }

    boolean isKeyguardAlwaysUnlocked() {
        if ((this.mDisplayInfo.flags & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean shouldRotateWithContent() {
        if ((this.mDisplayInfo.flags & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasOwnFocus() {
        if (this.mWmService.mPerDisplayFocusEnabled == false) goto L5;
    L8:
        return true;
    L5:
        if ((this.mDisplayInfo.flags & 2048) != 0) goto L8;
        return false;
    }

    boolean isKeyguardOccluded() {
        return this.mRootWindowContainer.mTaskSupervisor.getKeyguardController().isKeyguardOccluded(this.mDisplayId);
    }

    Task getTaskOccludingKeyguard() {
        KeyguardController keyguardController = this.mRootWindowContainer.mTaskSupervisor.getKeyguardController();
        if (keyguardController.getTopOccludingActivity(this.mDisplayId) == null) goto L7;
        return keyguardController.getTopOccludingActivity(this.mDisplayId).getRootTask();
    L7:
        if (keyguardController.getDismissKeyguardActivity(this.mDisplayId) != null) goto L9;
        return null;
    L9:
        return keyguardController.getDismissKeyguardActivity(this.mDisplayId).getRootTask();
    }

    private static /* synthetic */ void lambda$removeAllTasks$45(Task t) {
        t.getRootTask().removeChild(t, "removeAllTasks");
    }

    void removeAllTasks() {
        forAllTasks(new DisplayContent$$ExternalSyntheticLambda28());
    }

    Context getDisplayUiContext() {
        return this.mDisplayPolicy.getSystemUiContext();
    }

    boolean isLargeScreen() {
        if (getConfiguration().smallestScreenWidthDp < 600) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.wm.DisplayArea
    boolean getIgnoreOrientationRequest() {
        if (this.mHasSetIgnoreOrientationRequest == true) goto L12;
        if (isLargeScreen() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mWmService.isIgnoreOrientationRequestDisabled() == true) goto L9;
        return true;
    L12:
        return super.getIgnoreOrientationRequest();
    }

    @Override // com.android.server.wm.DisplayArea
    boolean setIgnoreOrientationRequest(boolean ignoreOrientationRequest) {
        this.mHasSetIgnoreOrientationRequest = true;
        if (this.mSetIgnoreOrientationRequest != ignoreOrientationRequest) goto L6;
        return false;
    L6:
        boolean rotationChanged = super.setIgnoreOrientationRequest(ignoreOrientationRequest);
        this.mWmService.mDisplayWindowSettings.setIgnoreOrientationRequest(this, Boolean.valueOf(this.mSetIgnoreOrientationRequest));
        if (ignoreOrientationRequest == true) goto L9;
    L11:
        return rotationChanged;
    L9:
        if (this.mWmService.mFlags.mRespectNonTopVisibleFixedOrientation == false) goto L11;
        forAllActivities(new DisplayContent$$ExternalSyntheticLambda23());
        goto L11
    }

    private static /* synthetic */ void lambda$setIgnoreOrientationRequest$46(ActivityRecord r) {
        r.finishFixedRotationTransform();
    }

    void onIsIgnoreOrientationRequestDisabledChanged() {
        if (this.mFocusedApp == null) goto L6;
        onLastFocusedTaskDisplayAreaChanged(this.mFocusedApp.getDisplayArea());
    L6:
        if (this.mSetIgnoreOrientationRequest == false) goto L9;
        updateOrientation();
        return;
    }

    WindowState findScrollCaptureTargetWindow(final WindowState searchBehind, final int taskId) {
        WindowState targetWindow = getWindow(new AnonymousClass4(this, searchBehind, taskId));
        return getExt().adjustScrollCaptureTargetWindow(targetWindow, taskId);
    }

    void recordScreenshotSourceWindow() {
        getExt().recordScreenshotSourceWindow();
    }

    boolean isScreenshotSourceWindow(WindowState w) {
        return getExt().isScreenshotSourceWindow(w);
    }

    WindowState getScreenshotSourceWindow() {
        return getExt().getScreenshotSourceWindow();
    }

    void clearScreenshotSourceWindowIfMatch(IBinder client) {
        getExt().clearScreenshotSourceWindowIfMatch(client);
    }

    @Override // com.android.server.wm.DisplayArea, com.android.server.wm.ConfigurationContainer
    public boolean providesMaxBounds() {
        return true;
    }

    void setSandboxDisplayApis(boolean sandboxDisplayApis) {
        this.mSandboxDisplayApis = sandboxDisplayApis;
    }

    boolean sandboxDisplayApis() {
        return this.mSandboxDisplayApis;
    }

    private ContentRecorder getContentRecorder() {
        if (this.mContentRecorder != null) goto L6;
        this.mContentRecorder = new ContentRecorder(this);
    L6:
        return this.mContentRecorder;
    }

    void onMirrorOutputSurfaceOrientationChanged() {
        if (this.mContentRecorder == null) goto L6;
        this.mContentRecorder.onMirrorOutputSurfaceOrientationChanged();
        return;
    }

    void pauseRecording() {
        if (this.mContentRecorder == null) goto L6;
        this.mContentRecorder.pauseRecording();
        return;
    }

    void setContentRecordingSession(ContentRecordingSession session) {
        getContentRecorder().setContentRecordingSession(session);
    }

    boolean setDisplayMirroring() {
        int mirrorDisplayId = this.mWmService.mDisplayManagerInternal.getDisplayIdToMirror(this.mDisplayId);
        if (mirrorDisplayId != (-1)) goto L6;
        return false;
    L6:
        if (mirrorDisplayId == this.mDisplayId) goto L8;
        DisplayContent mirrorDc = this.mRootWindowContainer.getDisplayContentOrCreate(mirrorDisplayId);
        if (mirrorDc != null) goto L22;
        if (this.mDisplayId != 0) goto L22;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[3] == false) goto L20;
        long protoLogParam0 = mirrorDisplayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 5489691866309868814L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L20:
        return false;
    L22:
        if (mirrorDc != null) goto L26;
        mirrorDc = this.mRootWindowContainer.getDefaultDisplay();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[3] == false) goto L26;
        long protoLogParam1 = mirrorDisplayId;
        long protoLogParam2 = this.mDisplayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -39794010824230928L, 5, new Object[]{Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});
    L26:
        ContentRecordingSession session = ContentRecordingSession.createDisplaySession(mirrorDc.getDisplayId()).setVirtualDisplayId(this.mDisplayId);
        setContentRecordingSession(session);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L29;
        long protoLogParam3 = this.mDisplayId;
        long protoLogParam4 = mirrorDisplayId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 6545352723229848841L, 5, new Object[]{Long.valueOf(protoLogParam3), Long.valueOf(protoLogParam4)});
    L29:
        return true;
    L8:
        if (this.mDisplayId != 0) goto L10;
    L12:
        return false;
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[3] == false) goto L12;
        long protoLogParam5 = mirrorDisplayId;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 4162342172327950908L, 1, new Object[]{Long.valueOf(protoLogParam5)});
        goto L12
    }

    void updateRecording() {
        if (this.mContentRecorder == null) goto L7;
        if (this.mContentRecorder.isContentRecordingSessionSet() == false) goto L7;
    L9:
        this.mContentRecorder.updateRecording();
        return;
    L7:
        if (setDisplayMirroring() == true) goto L9;
    }

    boolean isCurrentlyRecording() {
        if (this.mContentRecorder != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mContentRecorder.isCurrentlyRecording() == false) goto L7;
        return true;
    }

    MagnificationSpec getMagnificationSpec() {
        return this.mMagnificationSpec;
    }

    DisplayArea findAreaForWindowType(int windowType, Bundle options, boolean ownerCanManageAppToken, boolean roundedCornerOverlay) {
        if (windowType < 1) goto L9;
        if (windowType > 99) goto L9;
        return this.mDisplayAreaPolicy.getTaskDisplayArea(options);
    L9:
        if (windowType == 2011) goto L16;
        if (windowType == 2012) goto L16;
        return this.mDisplayAreaPolicy.findAreaForWindowType(windowType, options, ownerCanManageAppToken, roundedCornerOverlay);
    L16:
        return getImeContainer();
    }

    DisplayArea findAreaForToken(WindowToken windowToken) {
        return findAreaForWindowType(windowToken.getWindowType(), windowToken.mOptions, windowToken.mOwnerCanManageAppTokens, windowToken.mRoundedCornerOverlay);
    }

    @Override // com.android.server.wm.WindowContainer
    DisplayContent asDisplayContent() {
        return this;
    }

    @Override // com.android.server.wm.WindowContainer
    int getRelativeDisplayRotation() {
        return 0;
    }

    public void replaceContent(SurfaceControl sc) {
        new SurfaceControl.Transaction().reparent(sc, getSurfaceControl()).reparent(this.mOverlayLayer, null).reparent(this.mInputOverlayLayer, null).reparent(this.mA11yOverlayLayer, null).apply();
    }

    public IExtDisplayContent getExt() {
        return this.mExt;
    }

    ActivityRecord getFixedRotationLaunchingApp() {
        return this.mFixedRotationLaunchingApp;
    }

    public IObricDisplayContent getObricExt() {
        return this.mObricExt;
    }
}

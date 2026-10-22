package com.android.server.accessibility.magnification;

import android.accessibilityservice.MagnificationConfig;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.MathUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseDoubleArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.TypedValue;
import android.view.Display;
import android.view.accessibility.MagnificationAnimationCallback;
import com.android.internal.accessibility.util.AccessibilityStatsLogUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalServices;
import com.android.server.accessibility.AccessibilityManagerService;
import com.android.server.wm.WindowManagerInternal;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class MagnificationController implements MagnificationConnectionManager.Callback, MagnificationGestureHandler.Callback, MagnificationKeyHandler.Callback, FullScreenMagnificationController.MagnificationInfoChangedCallback, WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks {
    private static final boolean DEBUG = false;
    public static final int KEYBOARD_REPEAT_INTERVAL_MS = 60;
    public static final int PAN_DIRECTION_DOWN = 3;
    public static final int PAN_DIRECTION_LEFT = 0;
    public static final int PAN_DIRECTION_RIGHT = 1;
    public static final int PAN_DIRECTION_UP = 2;
    private static final String TAG = "MagnificationController";
    public static final int ZOOM_DIRECTION_IN = 0;
    public static final int ZOOM_DIRECTION_OUT = 1;
    private final SparseArray<WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks> mAccessibilityCallbacksDelegateArray;
    private boolean[] mActivePanDirections;
    private int mActivePanDisplay;
    private int mActiveZoomDirection;
    private int mActiveZoomDisplay;
    private final AlwaysOnMagnificationFeatureFlag mAlwaysOnMagnificationFeatureFlag;
    private final AccessibilityManagerService mAms;
    private final Executor mBackgroundExecutor;
    private final Context mContext;
    private final SparseIntArray mCurrentMagnificationModeArray;
    private FullScreenMagnificationController mFullScreenMagnificationController;
    private final SparseLongArray mFullScreenModeEnabledTimeArray;
    private final Handler mHandler;
    private int mInitialKeyboardRepeatIntervalMs;
    private final SparseBooleanArray mIsImeVisibleArray;
    private final SparseIntArray mLastMagnificationActivatedModeArray;
    private long mLastPannedTime;
    private final Object mLock;
    private int mMagnificationCapabilities;
    private MagnificationConnectionManager mMagnificationConnectionManager;
    private final SparseArray<DisableMagnificationCallback> mMagnificationEndRunnableSparseArray;
    private final MagnificationPanStepProvider mPanStepProvider;
    private boolean mRepeatKeysEnabled;
    private final MagnificationScaleProvider mScaleProvider;
    private final MagnificationScaleStepProvider mScaleStepProvider;
    private final boolean mSupportWindowMagnification;
    private SystemClock mSystemClock;
    private final PointF mTempPoint;
    private final SparseArray<Integer> mTransitionModes;
    private int mUserId;
    private final SparseLongArray mWindowModeEnabledTimeArray;

    public static class DefaultMagnificationPanStepProvider implements MagnificationPanStepProvider, DisplayManager.DisplayListener {
        private static final float DEFAULT_SCALE = 2.0f;
        private static final float PAN_STEP_AT_DEFAULT_SCALE_DIP = 40.0f;
        private static final float SCALE_FOR_1_DIP_PAN = 20.0f;
        private final DisplayManager mDisplayManager;
        private SparseDoubleArray mPanStepIntercepts;
        private SparseDoubleArray mPanStepSlopes;

        DefaultMagnificationPanStepProvider(Context context) {
            this.mDisplayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
            this.mDisplayManager.registerDisplayListener(this, null);
            this.mPanStepSlopes = new SparseDoubleArray();
            this.mPanStepIntercepts = new SparseDoubleArray();
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int displayId) {
            updateForDisplay(displayId);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int displayId) {
            updateForDisplay(displayId);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int displayId) {
            this.mPanStepSlopes.delete(displayId);
            this.mPanStepIntercepts.delete(displayId);
        }

        @Override // com.android.server.accessibility.magnification.MagnificationController.MagnificationPanStepProvider
        public float nextPanStep(float currentScale, int displayId) {
            if (this.mPanStepSlopes.indexOfKey(displayId) >= 0) goto L6;
            updateForDisplay(displayId);
        L6:
            return Math.max((float) ((this.mPanStepSlopes.get(displayId) * ((double) currentScale)) + this.mPanStepIntercepts.get(displayId)), 1.0f);
        }

        private void updateForDisplay(int displayId) {
            Display display = this.mDisplayManager.getDisplay(displayId);
            if (display != null) goto L5;
            return;
        L5:
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            float panStepAtDefaultScaleInPx = TypedValue.convertDimensionToPixels(1, PAN_STEP_AT_DEFAULT_SCALE_DIP, metrics);
            float panStepAtMaxScaleInPx = TypedValue.convertDimensionToPixels(1, 1.0f, metrics);
            float panStepSlope = (panStepAtMaxScaleInPx - panStepAtDefaultScaleInPx) / 18.0f;
            this.mPanStepSlopes.put(displayId, panStepSlope);
            this.mPanStepIntercepts.put(displayId, panStepAtDefaultScaleInPx - (DEFAULT_SCALE * panStepSlope));
        }
    }

    public static class DefaultMagnificationScaleStepProvider implements MagnificationScaleStepProvider {
        public static final float ZOOM_STEP_SCALE_FACTOR = 1.1892071f;

        public DefaultMagnificationScaleStepProvider() {
        }

        @Override // com.android.server.accessibility.magnification.MagnificationController.MagnificationScaleStepProvider
        public float nextScaleStep(float currentScale, int direction) {
            if (direction != 0) goto L4;
            int stepDelta = 1;
        L5:
            long scaleIndex = Math.round(Math.log(currentScale) / Math.log(1.1892070770263672d));
            float nextScale = (float) Math.pow(1.1892070770263672d, ((long) stepDelta) + scaleIndex);
            return MagnificationScaleProvider.constrainScale(nextScale);
        L4:
            stepDelta = -1;
            goto L5
        }
    }

    private final class DisableMagnificationCallback implements MagnificationAnimationCallback {
        private final boolean mAnimate;
        private final PointF mCurrentCenter;
        private final int mCurrentMode;
        private final float mCurrentScale;
        private final int mDisplayId;
        private boolean mExpired;
        private final int mTargetMode;
        private final TransitionCallBack mTransitionCallBack;
        final /* synthetic */ MagnificationController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmCurrentMode, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m853$$Nest$fgetmCurrentMode(DisableMagnificationCallback r0) {
            return r0.mCurrentMode;
        }

        DisableMagnificationCallback(MagnificationController r1, TransitionCallBack transitionCallBack, int displayId, int targetMode, float scale, PointF currentCenter, boolean animate) {
            this.this$0 = r1;
            this.mExpired = false;
            this.mCurrentCenter = new PointF();
            this.mTransitionCallBack = transitionCallBack;
            this.mDisplayId = displayId;
            this.mTargetMode = targetMode;
            this.mCurrentMode = this.mTargetMode ^ 3;
            this.mCurrentScale = scale;
            this.mCurrentCenter.set(currentCenter);
            this.mAnimate = animate;
        }

        public void onResult(boolean success) {
            Object r0 = MagnificationController.m849$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mExpired == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            setExpiredAndRemoveFromListLocked();     // Catch: Throwable -> L8
            MagnificationController.m851$$Nest$msetTransitionState(this.this$0, Integer.valueOf(this.mDisplayId), null);     // Catch: Throwable -> L8
            if (success == false) goto L13;
            adjustCurrentCenterIfNeededLocked();     // Catch: Throwable -> L8
            applyMagnificationModeLocked(this.mTargetMode);     // Catch: Throwable -> L8
        L18:
            MagnificationController.m852$$Nest$mupdateMagnificationUIControls(this.this$0, this.mDisplayId, this.mTargetMode);     // Catch: Throwable -> L8
            if (this.mTransitionCallBack == null) goto L21;
            this.mTransitionCallBack.onResult(this.mDisplayId, success);     // Catch: Throwable -> L8
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L13:
            FullScreenMagnificationController screenMagnificationController = this.this$0.getFullScreenMagnificationController();     // Catch: Throwable -> L8
            if (this.mCurrentMode != 1) goto L18;
            if (screenMagnificationController.isActivated(this.mDisplayId) == true) goto L18;
            MagnificationConfig.Builder configBuilder = new MagnificationConfig.Builder();     // Catch: Throwable -> L8
            Region region = new Region();     // Catch: Throwable -> L8
            configBuilder.setMode(1).setActivated(screenMagnificationController.isActivated(this.mDisplayId)).setScale(screenMagnificationController.getScale(this.mDisplayId)).setCenterX(screenMagnificationController.getCenterX(this.mDisplayId)).setCenterY(screenMagnificationController.getCenterY(this.mDisplayId));     // Catch: Throwable -> L8
            screenMagnificationController.getMagnificationRegion(this.mDisplayId, region);     // Catch: Throwable -> L8
            MagnificationController.m848$$Nest$fgetmAms(this.this$0).notifyMagnificationChanged(this.mDisplayId, region, configBuilder.build());     // Catch: Throwable -> L8
            goto L18
        }

        private void adjustCurrentCenterIfNeededLocked() {
            if (this.mTargetMode != 2) goto L5;
            return;
        L5:
            Region outRegion = new Region();
            this.this$0.getFullScreenMagnificationController().getMagnificationRegion(this.mDisplayId, outRegion);
            if (outRegion.contains((int) this.mCurrentCenter.x, (int) this.mCurrentCenter.y) == false) goto L8;
            return;
        L8:
            Rect bounds = outRegion.getBounds();
            this.mCurrentCenter.set(bounds.exactCenterX(), bounds.exactCenterY());
        }

        void restoreToCurrentMagnificationMode() {
            Object r0 = MagnificationController.m849$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mExpired == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            setExpiredAndRemoveFromListLocked();     // Catch: Throwable -> L8
            MagnificationController.m851$$Nest$msetTransitionState(this.this$0, Integer.valueOf(this.mDisplayId), null);     // Catch: Throwable -> L8
            applyMagnificationModeLocked(this.mCurrentMode);     // Catch: Throwable -> L8
            MagnificationController.m852$$Nest$mupdateMagnificationUIControls(this.this$0, this.mDisplayId, this.mCurrentMode);     // Catch: Throwable -> L8
            if (this.mTransitionCallBack == null) goto L13;
            this.mTransitionCallBack.onResult(this.mDisplayId, true);     // Catch: Throwable -> L8
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        void setExpiredAndRemoveFromListLocked() {
            this.mExpired = true;
            MagnificationController.m850$$Nest$msetDisableMagnificationCallbackLocked(this.this$0, this.mDisplayId, null);
        }

        private void applyMagnificationModeLocked(int mode) {
            if (mode != 1) goto L8;
            FullScreenMagnificationController fullScreenMagnificationController = this.this$0.getFullScreenMagnificationController();
            if (fullScreenMagnificationController.isRegistered(this.mDisplayId) == true) goto L7;
            fullScreenMagnificationController.register(this.mDisplayId);
        L7:
            fullScreenMagnificationController.setScaleAndCenter(this.mDisplayId, this.mCurrentScale, this.mCurrentCenter.x, this.mCurrentCenter.y, this.mAnimate, 0);
            return;
        L8:
            MagnificationConnectionManager r1 = this.this$0.getMagnificationConnectionManager();
            int r2 = this.mDisplayId;
            float r3 = this.mCurrentScale;
            float r4 = this.mCurrentCenter.x;
            float r5 = this.mCurrentCenter.y;
            if (this.mAnimate == false) goto L12;
            MagnificationAnimationCallback r0 = MagnificationAnimationCallback.STUB_ANIMATION_CALLBACK;
        L13:
            r1.enableWindowMagnification(r2, r3, r4, r5, r0, 0);
            return;
        L12:
            r0 = null;
            goto L13
        }
    }

    public interface MagnificationPanStepProvider {
        float nextPanStep(float r1, int r2);
    }

    public interface MagnificationScaleStepProvider {
        float nextScaleStep(float r1, int r2);
    }

    public @interface PanDirection {
    }

    interface SystemClock {
        long uptimeMillis();
    }

    private static class SystemClockImpl implements SystemClock {
        /* synthetic */ SystemClockImpl(MagnificationControllerIA r1) {
            this();
        }

        private SystemClockImpl() {
        }

        @Override // com.android.server.accessibility.magnification.MagnificationController.SystemClock
        public long uptimeMillis() {
            return android.os.SystemClock.uptimeMillis();
        }
    }

    public interface TransitionCallBack {
        void onResult(int r1, boolean r2);
    }

    public @interface ZoomDirection {
    }

    /* JADX INFO: renamed from: $r8$lambda$-JjdcX8hsnJgy97WdKBAPK8G4lU, reason: not valid java name */
    public static /* synthetic */ void m845$r8$lambda$JjdcX8hsnJgy97WdKBAPK8G4lU(MagnificationController r0) {
        r0.maybeContinueZoom();
    }

    /* JADX INFO: renamed from: $r8$lambda$R3k8N3qbC-xGQ3K5bFGkfo5pSVk, reason: not valid java name */
    public static /* synthetic */ void m846$r8$lambda$R3k8N3qbCxGQ3K5bFGkfo5pSVk(MagnificationController r0) {
        r0.maybeContinuePan();
    }

    public static /* synthetic */ Boolean $r8$lambda$RK4GNS1IfZDRx9pPFHvEPIoaYjc(MagnificationController r0) {
        return r0.lambda$getFullScreenMagnificationController$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$hDLBh-fi6zCVpWqZQdsbmMSqy4A, reason: not valid java name */
    public static /* synthetic */ void m847$r8$lambda$hDLBhfi6zCVpWqZQdsbmMSqy4A(MagnificationController r0, int r1, int r2, boolean r3) {
        r0.lambda$transitionMagnificationConfigMode$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAms, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityManagerService m848$$Nest$fgetmAms(MagnificationController r0) {
        return r0.mAms;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m849$$Nest$fgetmLock(MagnificationController r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$msetDisableMagnificationCallbackLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m850$$Nest$msetDisableMagnificationCallbackLocked(MagnificationController r0, int r1, DisableMagnificationCallback r2) {
        r0.setDisableMagnificationCallbackLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetTransitionState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m851$$Nest$msetTransitionState(MagnificationController r0, Integer r1, Integer r2) {
        r0.setTransitionState(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMagnificationUIControls, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m852$$Nest$mupdateMagnificationUIControls(MagnificationController r0, int r1, int r2) {
        r0.updateMagnificationUIControls(r1, r2);
    }

    public MagnificationController(AccessibilityManagerService ams, Object lock, Context context, MagnificationScaleProvider scaleProvider, Executor backgroundExecutor, Looper looper) {
        this.mTempPoint = new PointF();
        this.mMagnificationEndRunnableSparseArray = new SparseArray();
        this.mMagnificationCapabilities = 1;
        this.mActivePanDirections = new boolean[]{false, false, false, false};
        this.mActivePanDisplay = -1;
        this.mLastPannedTime = 0;
        this.mRepeatKeysEnabled = true;
        this.mActiveZoomDirection = 0;
        this.mActiveZoomDisplay = -1;
        this.mInitialKeyboardRepeatIntervalMs = 400;
        this.mCurrentMagnificationModeArray = new SparseIntArray();
        this.mLastMagnificationActivatedModeArray = new SparseIntArray();
        this.mUserId = 0;
        this.mIsImeVisibleArray = new SparseBooleanArray();
        this.mWindowModeEnabledTimeArray = new SparseLongArray();
        this.mFullScreenModeEnabledTimeArray = new SparseLongArray();
        this.mTransitionModes = new SparseArray();
        this.mAccessibilityCallbacksDelegateArray = new SparseArray();
        this.mAms = ams;
        this.mLock = lock;
        this.mContext = context;
        this.mScaleProvider = scaleProvider;
        this.mBackgroundExecutor = backgroundExecutor;
        this.mHandler = new Handler(looper);
        this.mSystemClock = new SystemClockImpl(null);
        ((WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class)).getAccessibilityController().setUiChangesForAccessibilityCallbacks(this);
        this.mSupportWindowMagnification = context.getPackageManager().hasSystemFeature("android.software.window_magnification");
        this.mScaleStepProvider = new DefaultMagnificationScaleStepProvider();
        this.mPanStepProvider = new DefaultMagnificationPanStepProvider(this.mContext);
        this.mAlwaysOnMagnificationFeatureFlag = new AlwaysOnMagnificationFeatureFlag(context);
        AlwaysOnMagnificationFeatureFlag r0 = this.mAlwaysOnMagnificationFeatureFlag;
        Executor r1 = this.mBackgroundExecutor;
        final AccessibilityManagerService r2 = this.mAms;
        r2.getClass();
        r0.addOnChangedListener(r1, new MagnificationController$$ExternalSyntheticLambda1(r2));
    }

    public MagnificationController(AccessibilityManagerService ams, Object lock, Context context, FullScreenMagnificationController fullScreenMagnificationController, MagnificationConnectionManager magnificationConnectionManager, MagnificationScaleProvider scaleProvider, Executor backgroundExecutor, Looper looper, SystemClock systemClock) {
        this(ams, lock, context, scaleProvider, backgroundExecutor, looper);
        this.mFullScreenMagnificationController = fullScreenMagnificationController;
        this.mMagnificationConnectionManager = magnificationConnectionManager;
        this.mSystemClock = systemClock;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationConnectionManager.Callback
    public void onPerformScaleAction(int displayId, float scale, boolean updatePersistence) {
        if (getFullScreenMagnificationController().isActivated(displayId) == false) goto L8;
        getFullScreenMagnificationController().setScaleAndCenter(displayId, scale, Float.NaN, Float.NaN, !updatePersistence, false, 0);
        if (updatePersistence == false) goto L13;
        getFullScreenMagnificationController().persistScale(displayId);
        return;
    L13:
        return;
    L8:
        if (getMagnificationConnectionManager().isWindowMagnifierEnabled(displayId) == false) goto L15;
        getMagnificationConnectionManager().setScale(displayId, scale);
        if (updatePersistence == false) goto L16;
        getMagnificationConnectionManager().persistScale(displayId);
        return;
    L16:
        return;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationConnectionManager.Callback
    public void onAccessibilityActionPerformed(int displayId) {
        updateMagnificationUIControls(displayId, 2);
    }

    @Override // com.android.server.accessibility.magnification.MagnificationGestureHandler.Callback
    public void onTouchInteractionStart(int displayId, int mode) {
        handleUserInteractionChanged(displayId, mode);
    }

    @Override // com.android.server.accessibility.magnification.MagnificationGestureHandler.Callback
    public void onTouchInteractionEnd(int displayId, int mode) {
        handleUserInteractionChanged(displayId, mode);
    }

    @Override // com.android.server.accessibility.magnification.MagnificationKeyHandler.Callback
    public void onPanMagnificationStart(int displayId, int direction) {
        if (this.mActivePanDisplay == (-1)) goto L5;
        boolean isAlreadyPanning = true;
    L6:
        this.mActivePanDisplay = displayId;
        this.mActivePanDirections[direction] = true;
        panMagnificationByStep(this.mActivePanDisplay, this.mActivePanDirections);
        if (isAlreadyPanning == false) goto L9;
        return;
    L9:
        if (this.mRepeatKeysEnabled == false) goto L13;
        this.mHandler.sendMessageDelayed(PooledLambda.obtainMessage(new MagnificationController$$ExternalSyntheticLambda3(), this), this.mInitialKeyboardRepeatIntervalMs);
        return;
    L13:
        return;
    L5:
        isAlreadyPanning = false;
        goto L6
    }

    @Override // com.android.server.accessibility.magnification.MagnificationKeyHandler.Callback
    public void onPanMagnificationStop(int direction) {
        this.mActivePanDirections[direction] = false;
        if (this.mActivePanDirections[0] == false) goto L5;
        return;
    L5:
        if (this.mActivePanDirections[1] == false) goto L7;
        return;
    L7:
        if (this.mActivePanDirections[2] == false) goto L9;
        return;
    L9:
        if (this.mActivePanDirections[3] == true) goto L15;
        this.mActivePanDisplay = -1;
        return;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationKeyHandler.Callback
    public void onScaleMagnificationStart(int displayId, int direction) {
        if (this.mActiveZoomDisplay == (-1)) goto L5;
        return;
    L5:
        this.mActiveZoomDirection = direction;
        this.mActiveZoomDisplay = displayId;
        scaleMagnificationByStep(displayId, direction);
        if (this.mRepeatKeysEnabled == false) goto L9;
        this.mHandler.sendMessageDelayed(PooledLambda.obtainMessage(new MagnificationController$$ExternalSyntheticLambda2(), this), this.mInitialKeyboardRepeatIntervalMs);
        return;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationKeyHandler.Callback
    public void onScaleMagnificationStop(int direction) {
        if (direction != this.mActiveZoomDirection) goto L6;
        this.mActiveZoomDisplay = -1;
        return;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationKeyHandler.Callback
    public void onKeyboardInteractionStop() {
        this.mActiveZoomDisplay = -1;
        this.mActivePanDisplay = -1;
        this.mActivePanDirections = new boolean[]{false, false, false, false};
    }

    private void maybeContinuePan() {
        if (this.mActivePanDisplay != (-1)) goto L6;
        return;
    L6:
        if ((this.mSystemClock.uptimeMillis() - this.mLastPannedTime) < 60) goto L9;
        panMagnificationByStep(this.mActivePanDisplay, this.mActivePanDirections);
    L9:
        if (this.mRepeatKeysEnabled == false) goto L12;
        this.mHandler.sendMessageDelayed(PooledLambda.obtainMessage(new MagnificationController$$ExternalSyntheticLambda3(), this), 60);
        return;
    }

    private void maybeContinueZoom() {
        if (this.mActiveZoomDisplay == (-1)) goto L8;
        scaleMagnificationByStep(this.mActiveZoomDisplay, this.mActiveZoomDirection);
        if (this.mRepeatKeysEnabled == false) goto L9;
        this.mHandler.sendMessageDelayed(PooledLambda.obtainMessage(new MagnificationController$$ExternalSyntheticLambda2(), this), 60);
        return;
    L9:
        return;
    }

    public void setRepeatKeysEnabled(boolean isRepeatKeysEnabled) {
        this.mRepeatKeysEnabled = isRepeatKeysEnabled;
    }

    public void setRepeatKeysTimeoutMs(int repeatKeysTimeoutMs) {
        this.mInitialKeyboardRepeatIntervalMs = repeatKeysTimeoutMs;
    }

    public int getInitialKeyboardRepeatIntervalMs() {
        return this.mInitialKeyboardRepeatIntervalMs;
    }

    private void handleUserInteractionChanged(int displayId, int mode) {
        if (this.mMagnificationCapabilities == 3) goto L5;
        return;
    L5:
        updateMagnificationUIControls(displayId, mode);
    }

    private void updateMagnificationUIControls(int displayId, int mode) {
        boolean isActivated = isActivated(displayId, mode);
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean enableSettingsPanel = false;
        if (isActivated == true) goto L29;
    L11:
        boolean showModeSwitchButton = false;
    L13:
        if (isActivated == true) goto L15;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (showModeSwitchButton == false) goto L23;
        getMagnificationConnectionManager().showMagnificationButton(displayId, mode);
    L24:
        if (enableSettingsPanel == true) goto L31;
        getMagnificationConnectionManager().removeMagnificationSettingsPanel(displayId);
        return;
    L31:
        return;
    L23:
        getMagnificationConnectionManager().removeMagnificationButton(displayId);
    L9:
        th = move-exception;
        throw th;
    L15:
        if (this.mMagnificationCapabilities != 3) goto L17;
    L18:
        enableSettingsPanel = true;
        goto L20
    L17:
        if (this.mMagnificationCapabilities != 2) goto L20;
    L29:
        if (this.mMagnificationCapabilities != 3) goto L11;
        showModeSwitchButton = true;
        goto L13
    }

    public boolean supportWindowMagnification() {
        return this.mSupportWindowMagnification;
    }

    public void transitionMagnificationModeLocked(int displayId, int targetMode, TransitionCallBack transitionCallBack) {
        if (isActivated(displayId, targetMode) == false) goto L6;
        transitionCallBack.onResult(displayId, true);
        return;
    L6:
        PointF currentCenter = getCurrentMagnificationCenterLocked(displayId, targetMode);
        DisableMagnificationCallback animationCallback = getDisableMagnificationEndRunnableLocked(displayId);
        if (currentCenter != null) goto L12;
        if (animationCallback != null) goto L12;
        transitionCallBack.onResult(displayId, true);
        return;
    L12:
        if (animationCallback != null) goto L14;
        if (currentCenter != null) goto L22;
        Slog.w(TAG, "Invalid center, ignore it");
        transitionCallBack.onResult(displayId, true);
        return;
    L22:
        setTransitionState(Integer.valueOf(displayId), Integer.valueOf(targetMode));
        FullScreenMagnificationController screenMagnificationController = getFullScreenMagnificationController();
        MagnificationConnectionManager magnificationConnectionManager = getMagnificationConnectionManager();
        float scale = getTargetModeScaleFromCurrentMagnification(displayId, targetMode);
        DisableMagnificationCallback animationEndCallback = new DisableMagnificationCallback(this, transitionCallBack, displayId, targetMode, scale, currentCenter, true);
        setDisableMagnificationCallbackLocked(displayId, animationEndCallback);
        if (targetMode != 2) goto L25;
        screenMagnificationController.reset(displayId, animationEndCallback);
        return;
    L25:
        magnificationConnectionManager.disableWindowMagnification(displayId, false, animationEndCallback);
        return;
    L14:
        if (DisableMagnificationCallback.m853$$Nest$fgetmCurrentMode(animationCallback) != targetMode) goto L17;
        animationCallback.restoreToCurrentMagnificationMode();
        return;
    L17:
        Slog.w(TAG, "discard duplicate request");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void transitionMagnificationConfigMode(final int r19, MagnificationConfig r20, boolean r21, int r22) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        final int r0 = r20.getMode();     // Catch: Throwable -> L9
        boolean r12 = r20.isActivated();     // Catch: Throwable -> L9
        PointF r1 = getCurrentMagnificationCenterLocked(r19, r0);     // Catch: Throwable -> L9
        PointF r2 = new PointF(r20.getCenterX(), r20.getCenterY());     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
    L17:
        DisableMagnificationCallback r3 = getDisableMagnificationEndRunnableLocked(r19);     // Catch: Throwable -> L9
        if (r3 == null) goto L20;
        Slog.w(TAG, "Discard previous animation request");     // Catch: Throwable -> L9
        r3.setExpiredAndRemoveFromListLocked();     // Catch: Throwable -> L9
    L20:
        FullScreenMagnificationController r4 = getFullScreenMagnificationController();     // Catch: Throwable -> L9
        MagnificationConnectionManager r5 = getMagnificationConnectionManager();     // Catch: Throwable -> L9
        if (Float.isNaN(r20.getScale()) == false) goto L24;
        float r6 = getTargetModeScaleFromCurrentMagnification(r19, r0);     // Catch: Throwable -> L9
    L100:
        setTransitionState(Integer.valueOf(r19), Integer.valueOf(r0));     // Catch: Throwable -> L78
        if (r21 == true) goto L94;
        MagnificationAnimationCallback r7 = null;
    L102:
        if (r0 == 2) goto L96;
        Integer r13 = null;
        if (r0 != 1) goto L73;
        r5.disableWindowMagnification(r19, false, null);     // Catch: Throwable -> L66
        if (r12 == false) goto L69;
        if (r4.isRegistered(r19) == true) goto L61;
        r4.register(r19);     // Catch: Throwable -> L43
    L61:
        r4.setScaleAndCenter(r19, r6, r2.x, r2.y, false, r7, r22);     // Catch: Throwable -> L64
    L89:
        goto L73
    L69:
        if (r4.isRegistered(r19) == false) goto L89;
        r4.reset(r19, false);     // Catch: Throwable -> L64
    L64:
        th = th;
        Integer r14 = r13;
    L80:
        if (r21 == true) goto L82;
        this.mAms.changeMagnificationMode(r19, r0);     // Catch: Throwable -> L9
    L82:
        setTransitionState(Integer.valueOf(r19), r14);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L66:
        th = th;
        r14 = r13;
    L73:
        if (r21 == true) goto L75;
        this.mAms.changeMagnificationMode(r19, r0);     // Catch: Throwable -> L9
    L75:
        setTransitionState(Integer.valueOf(r19), r13);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L96:
        r4.reset(r19, false);     // Catch: Throwable -> L52
        if (r12 == true) goto L98;
        r13 = null;
        r5.disableWindowMagnification(r19, false);     // Catch: Throwable -> L43
        goto L73
    L98:
        r13 = null;
        r5.enableWindowMagnification(r19, r6, r2.x, r2.y, r7, r22);     // Catch: Throwable -> L43
    L45:
        th = th;
        Object r15 = null;
    L47:
        r14 = r15;
    L48:
        th = th;
        r15 = null;
    L52:
        th = th;
        r15 = null;
    L43:
        th = th;
        r14 = r12;
        goto L80
    L94:
        r7 = new MagnificationController$$ExternalSyntheticLambda4(this, r19, r0);     // Catch: Throwable -> L30
    L30:
        th = th;
        r14 = 0;
    L78:
        th = th;
        r14 = 0;
        goto L80
    L24:
        r6 = r20.getScale();     // Catch: Throwable -> L9
        goto L100
    L7:
        if (Float.isNaN(r20.getCenterX()) == false) goto L11;
        float r8 = r1.x;     // Catch: Throwable -> L9
    L13:
        if (Float.isNaN(r20.getCenterY()) == false) goto L15;
        float r9 = r1.y;     // Catch: Throwable -> L9
    L16:
        r2.set(r8, r9);     // Catch: Throwable -> L9
        goto L17
    L15:
        r9 = r20.getCenterY();     // Catch: Throwable -> L9
        goto L16
    L11:
        r8 = r20.getCenterX();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$transitionMagnificationConfigMode$0(int displayId, int targetMode, boolean success) {
        this.mAms.changeMagnificationMode(displayId, targetMode);
    }

    private void setTransitionState(Integer displayId, Integer targetMode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (targetMode != null) goto L9;
        if (displayId != null) goto L9;
        this.mTransitionModes.clear();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mTransitionModes.put(displayId.intValue(), targetMode);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private float getTargetModeScaleFromCurrentMagnification(int displayId, int targetMode) {
        if (targetMode != 2) goto L7;
        return getFullScreenMagnificationController().getScale(displayId);
    L7:
        return getMagnificationConnectionManager().getScale(displayId);
    }

    public boolean hasDisableMagnificationCallback(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisableMagnificationCallback animationCallback = getDisableMagnificationEndRunnableLocked(displayId);     // Catch: Throwable -> L9
        if (animationCallback == null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    private void setCurrentMagnificationModeAndSwitchDelegate(int displayId, int mode) {
        this.mCurrentMagnificationModeArray.put(displayId, mode);
        assignMagnificationWindowManagerDelegateByMode(displayId, mode);
    }

    private void assignMagnificationWindowManagerDelegateByMode(int displayId, int mode) {
        if (mode != 1) goto L6;
        this.mAccessibilityCallbacksDelegateArray.put(displayId, getFullScreenMagnificationController());
        return;
    L6:
        if (mode != 2) goto L8;
        this.mAccessibilityCallbacksDelegateArray.put(displayId, getMagnificationConnectionManager());
        return;
    L8:
        this.mAccessibilityCallbacksDelegateArray.delete(displayId);
    }

    @Override // com.android.server.wm.WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks
    public void onRectangleOnScreenRequested(int displayId, int left, int top, int right, int bottom) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks delegate = this.mAccessibilityCallbacksDelegateArray.get(displayId);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (delegate == null) goto L9;
        delegate.onRectangleOnScreenRequested(displayId, left, top, right, bottom);
        return;
    L9:
        return;
    L10:
        th = th;
    L16:
        throw th;
    L14:
        th = th;
        goto L16
    }

    @Override // com.android.server.accessibility.magnification.FullScreenMagnificationController.MagnificationInfoChangedCallback
    public void onRequestMagnificationSpec(int displayId, int serviceId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateMagnificationUIControls(displayId, 1);     // Catch: Throwable -> L10
        MagnificationConnectionManager magnificationConnectionManager = this.mMagnificationConnectionManager;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (magnificationConnectionManager == null) goto L15;
        this.mMagnificationConnectionManager.disableWindowMagnification(displayId, false);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationConnectionManager.Callback
    public void onWindowMagnificationActivationState(int displayId, boolean activated) {
        if (activated == false) goto L12;
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mWindowModeEnabledTimeArray.put(displayId, this.mSystemClock.uptimeMillis());     // Catch: Throwable -> L9
        setCurrentMagnificationModeAndSwitchDelegate(displayId, 2);     // Catch: Throwable -> L9
        this.mLastMagnificationActivatedModeArray.put(displayId, 2);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        logMagnificationModeWithImeOnIfNeeded(displayId);
        disableFullScreenMagnificationIfNeeded(displayId);
    L18:
        updateMagnificationUIControls(displayId, 2);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        Object r2 = this.mLock;
        monitor-enter(r2);
        setCurrentMagnificationModeAndSwitchDelegate(displayId, 0);     // Catch: Throwable -> L20
        long duration = this.mSystemClock.uptimeMillis() - this.mWindowModeEnabledTimeArray.get(displayId);     // Catch: Throwable -> L20
        float scale = this.mMagnificationConnectionManager.getLastActivatedScale(displayId);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        logMagnificationUsageState(2, duration, scale);
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.accessibility.magnification.MagnificationConnectionManager.Callback
    public void onChangeMagnificationMode(int displayId, int magnificationMode) {
        this.mAms.changeMagnificationMode(displayId, magnificationMode);
    }

    @Override // com.android.server.accessibility.magnification.MagnificationConnectionManager.Callback
    public void onSourceBoundsChanged(int displayId, Rect bounds) {
        if (shouldNotifyMagnificationChange(displayId, 2) == false) goto L6;
        this.mMagnificationConnectionManager.onUserMagnificationScaleChanged(this.mUserId, displayId, getMagnificationConnectionManager().getScale(displayId));
        MagnificationConfig config = new MagnificationConfig.Builder().setMode(2).setActivated(getMagnificationConnectionManager().isWindowMagnifierEnabled(displayId)).setScale(getMagnificationConnectionManager().getScale(displayId)).setCenterX(bounds.exactCenterX()).setCenterY(bounds.exactCenterY()).build();
        this.mAms.notifyMagnificationChanged(displayId, new Region(bounds), config);
        return;
    }

    @Override // com.android.server.accessibility.magnification.FullScreenMagnificationController.MagnificationInfoChangedCallback
    public void onFullScreenMagnificationChanged(int displayId, Region region, MagnificationConfig config) {
        if (shouldNotifyMagnificationChange(displayId, 1) == false) goto L6;
        this.mMagnificationConnectionManager.onUserMagnificationScaleChanged(this.mUserId, displayId, config.getScale());
        this.mAms.notifyMagnificationChanged(displayId, region, config);
        return;
    }

    private boolean shouldNotifyMagnificationChange(int displayId, int changeMode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mFullScreenMagnificationController != null) goto L7;
    L11:
        boolean fullScreenActivated = false;
    L13:
        if (this.mMagnificationConnectionManager != null) goto L15;
    L17:
        boolean windowEnabled = false;
    L18:
        Integer transitionMode = this.mTransitionModes.get(displayId);     // Catch: Throwable -> L9
        if (changeMode != 1) goto L22;
        if (fullScreenActivated == false) goto L22;
    L24:
        if (transitionMode != null) goto L27;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L27:
        if (fullScreenActivated == true) goto L32;
        if (windowEnabled == true) goto L32;
        if (transitionMode != null) goto L32;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L32:
        if (transitionMode != null) goto L34;
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L34:
        if (changeMode != transitionMode.intValue()) goto L37;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L22:
        if (changeMode != 2) goto L27;
        if (windowEnabled == false) goto L27;
    L15:
        if (this.mMagnificationConnectionManager.isWindowMagnifierEnabled(displayId) == false) goto L17;
        windowEnabled = true;
        goto L18
    L7:
        if (this.mFullScreenMagnificationController.isActivated(displayId) == false) goto L11;
        fullScreenActivated = true;
        goto L13
    }

    private void disableFullScreenMagnificationIfNeeded(int displayId) {
        FullScreenMagnificationController fullScreenMagnificationController = getFullScreenMagnificationController();
        if (fullScreenMagnificationController.getIdOfLastServiceToMagnify(displayId) <= 0) goto L5;
        boolean isMagnifyByExternalRequest = true;
    L6:
        if (isMagnifyByExternalRequest == false) goto L8;
    L9:
        fullScreenMagnificationController.reset(displayId, false);
        return;
    L8:
        if (isActivated(displayId, 1) == true) goto L9;
        return;
    L5:
        isMagnifyByExternalRequest = false;
        goto L6
    }

    @Override // com.android.server.accessibility.magnification.FullScreenMagnificationController.MagnificationInfoChangedCallback
    public void onFullScreenMagnificationActivationState(int displayId, boolean activated) {
        getMagnificationConnectionManager().onFullscreenMagnificationActivationChanged(displayId, activated);
        if (activated == false) goto L12;
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mFullScreenModeEnabledTimeArray.put(displayId, this.mSystemClock.uptimeMillis());     // Catch: Throwable -> L9
        setCurrentMagnificationModeAndSwitchDelegate(displayId, 1);     // Catch: Throwable -> L9
        this.mLastMagnificationActivatedModeArray.put(displayId, 1);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        logMagnificationModeWithImeOnIfNeeded(displayId);
        disableWindowMagnificationIfNeeded(displayId);
    L18:
        updateMagnificationUIControls(displayId, 1);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        Object r2 = this.mLock;
        monitor-enter(r2);
        setCurrentMagnificationModeAndSwitchDelegate(displayId, 0);     // Catch: Throwable -> L20
        long duration = this.mSystemClock.uptimeMillis() - this.mFullScreenModeEnabledTimeArray.get(displayId);     // Catch: Throwable -> L20
        float scale = this.mFullScreenMagnificationController.getLastActivatedScale(displayId);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        logMagnificationUsageState(1, duration, scale);
    L20:
        th = move-exception;
        throw th;
    }

    private void disableWindowMagnificationIfNeeded(int displayId) {
        MagnificationConnectionManager magnificationConnectionManager = getMagnificationConnectionManager();
        if (isActivated(displayId, 2) == false) goto L6;
        magnificationConnectionManager.disableWindowMagnification(displayId, false);
        return;
    }

    @Override // com.android.server.accessibility.magnification.FullScreenMagnificationController.MagnificationInfoChangedCallback
    public void onImeWindowVisibilityChanged(int displayId, boolean shown) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsImeVisibleArray.put(displayId, shown);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        getMagnificationConnectionManager().onImeWindowVisibilityChanged(displayId, shown);
        logMagnificationModeWithImeOnIfNeeded(displayId);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public int getLastMagnificationActivatedMode(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mLastMagnificationActivatedModeArray.get(displayId, 1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void logMagnificationUsageState(int mode, long duration, float scale) {
        AccessibilityStatsLogUtils.logMagnificationUsageState(mode, duration, scale);
    }

    public void logMagnificationModeWithIme(int mode) {
        AccessibilityStatsLogUtils.logMagnificationModeWithImeOn(mode);
    }

    public void updateUserIdIfNeeded(int userId) {
        if (this.mUserId != userId) goto L5;
        return;
    L5:
        this.mUserId = userId;
        Object r0 = this.mLock;
        monitor-enter(r0);
        FullScreenMagnificationController fullMagnificationController = this.mFullScreenMagnificationController;     // Catch: Throwable -> L15
        MagnificationConnectionManager magnificationConnectionManager = this.mMagnificationConnectionManager;     // Catch: Throwable -> L15
        this.mAccessibilityCallbacksDelegateArray.clear();     // Catch: Throwable -> L15
        this.mCurrentMagnificationModeArray.clear();     // Catch: Throwable -> L15
        this.mLastMagnificationActivatedModeArray.clear();     // Catch: Throwable -> L15
        this.mIsImeVisibleArray.clear();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        this.mScaleProvider.onUserChanged(userId);
        if (fullMagnificationController == null) goto L12;
        fullMagnificationController.resetAllIfNeeded(false);
    L12:
        if (magnificationConnectionManager == null) goto L20;
        magnificationConnectionManager.disableAllWindowMagnifiers();
        return;
    L20:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void onDisplayRemoved(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mFullScreenMagnificationController == null) goto L10;
        this.mFullScreenMagnificationController.onDisplayRemoved(displayId);     // Catch: Throwable -> L7
    L10:
        if (this.mMagnificationConnectionManager == null) goto L12;
        this.mMagnificationConnectionManager.onDisplayRemoved(displayId);     // Catch: Throwable -> L7
    L12:
        this.mAccessibilityCallbacksDelegateArray.delete(displayId);     // Catch: Throwable -> L7
        this.mCurrentMagnificationModeArray.delete(displayId);     // Catch: Throwable -> L7
        this.mLastMagnificationActivatedModeArray.delete(displayId);     // Catch: Throwable -> L7
        this.mIsImeVisibleArray.delete(displayId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mScaleProvider.onDisplayRemoved(displayId);
    }

    public void onUserRemoved(int userId) {
        this.mScaleProvider.onUserRemoved(userId);
    }

    public void setMagnificationCapabilities(int capabilities) {
        this.mMagnificationCapabilities = capabilities;
    }

    public void setMagnificationFollowTypingEnabled(boolean enabled) {
        getMagnificationConnectionManager().setMagnificationFollowTypingEnabled(enabled);
        getFullScreenMagnificationController().setMagnificationFollowTypingEnabled(enabled);
    }

    public void setAlwaysOnMagnificationEnabled(boolean enabled) {
        getFullScreenMagnificationController().setAlwaysOnMagnificationEnabled(enabled);
    }

    public boolean isAlwaysOnMagnificationFeatureFlagEnabled() {
        return this.mAlwaysOnMagnificationFeatureFlag.isFeatureFlagEnabled();
    }

    private DisableMagnificationCallback getDisableMagnificationEndRunnableLocked(int displayId) {
        return this.mMagnificationEndRunnableSparseArray.get(displayId);
    }

    private void setDisableMagnificationCallbackLocked(int displayId, DisableMagnificationCallback callback) {
        this.mMagnificationEndRunnableSparseArray.put(displayId, callback);
    }

    private void logMagnificationModeWithImeOnIfNeeded(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int currentActivateMode = this.mCurrentMagnificationModeArray.get(displayId, 0);     // Catch: Throwable -> L11
        if (this.mIsImeVisibleArray.get(displayId, false) == false) goto L13;
        if (currentActivateMode == 0) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        logMagnificationModeWithIme(currentActivateMode);
        return;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public FullScreenMagnificationController getFullScreenMagnificationController() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = th;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L17
    L5:
        if (this.mFullScreenMagnificationController != null) goto L13;
        MagnificationController r6 = this;
        r6.mFullScreenMagnificationController = new FullScreenMagnificationController(this.mContext, this.mAms.getTraceManager(), this.mLock, r6, this.mScaleProvider, this.mBackgroundExecutor, new MagnificationController$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L9
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r6.mFullScreenMagnificationController;
    L13:
        r6 = this;
        goto L14
    }

    private /* synthetic */ Boolean lambda$getFullScreenMagnificationController$1() {
        return Boolean.valueOf(isMagnificationSystemUIConnectionReady());
    }

    private boolean isMagnificationSystemUIConnectionReady() {
        if (isMagnificationConnectionManagerInitialized() == true) goto L5;
    L7:
        return false;
    L5:
        if (getMagnificationConnectionManager().waitConnectionWithTimeoutIfNeeded() == false) goto L7;
        return true;
    }

    public boolean isFullScreenMagnificationControllerInitialized() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mFullScreenMagnificationController == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public MagnificationConnectionManager getMagnificationConnectionManager() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = th;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L17
    L5:
        if (this.mMagnificationConnectionManager != null) goto L13;
        MagnificationController r5 = this;
        r5.mMagnificationConnectionManager = new MagnificationConnectionManager(this.mContext, this.mLock, r5, this.mAms.getTraceManager(), this.mScaleProvider);     // Catch: Throwable -> L9
    L14:
        MagnificationConnectionManager r0 = r5.mMagnificationConnectionManager;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r0;
    L13:
        r5 = this;
        goto L14
    }

    private boolean isMagnificationConnectionManagerInitialized() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mMagnificationConnectionManager == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    private PointF getCurrentMagnificationCenterLocked(int displayId, int targetMode) {
        if (targetMode != 1) goto L12;
        if (this.mMagnificationConnectionManager != null) goto L7;
    L10:
        return null;
    L7:
        if (this.mMagnificationConnectionManager.isWindowMagnifierEnabled(displayId) == false) goto L10;
        this.mTempPoint.set(this.mMagnificationConnectionManager.getCenterX(displayId), this.mMagnificationConnectionManager.getCenterY(displayId));
    L18:
        return this.mTempPoint;
    L12:
        if (this.mFullScreenMagnificationController != null) goto L14;
    L19:
        return null;
    L14:
        if (this.mFullScreenMagnificationController.isActivated(displayId) == false) goto L19;
        this.mTempPoint.set(this.mFullScreenMagnificationController.getCenterX(displayId), this.mFullScreenMagnificationController.getCenterY(displayId));
        goto L18
    }

    public boolean isActivated(int displayId, int mode) {
        boolean isActivated = false;
        if (mode != 1) goto L18;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.mFullScreenMagnificationController != null) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return false;
    L12:
        isActivated = this.mFullScreenMagnificationController.isActivated(displayId);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
    L32:
        return isActivated;
    L18:
        if (mode != 2) goto L32;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L25:
        th = move-exception;
        throw th;
    L22:
        if (this.mMagnificationConnectionManager != null) goto L27;
        monitor-exit(r2);     // Catch: Throwable -> L25
        return false;
    L27:
        isActivated = this.mMagnificationConnectionManager.isWindowMagnifierEnabled(displayId);     // Catch: Throwable -> L25
        monitor-exit(r2);     // Catch: Throwable -> L25
        goto L32
    }

    private void scaleMagnificationByStep(int displayId, int direction) {
        if (getFullScreenMagnificationController().isActivated(displayId) == false) goto L5;
        float magnificationScale = getFullScreenMagnificationController().getScale(displayId);
        float nextMagnificationScale = this.mScaleStepProvider.nextScaleStep(magnificationScale, direction);
        int displayId2 = displayId;
        getFullScreenMagnificationController().setScaleAndCenter(displayId2, nextMagnificationScale, Float.NaN, Float.NaN, true, 0);
    L7:
        if (getMagnificationConnectionManager().isWindowMagnifierEnabled(displayId2) == false) goto L10;
        float magnificationScale2 = getMagnificationConnectionManager().getScale(displayId2);
        float nextMagnificationScale2 = this.mScaleStepProvider.nextScaleStep(magnificationScale2, direction);
        getMagnificationConnectionManager().setScale(displayId2, nextMagnificationScale2);
        return;
    L10:
        return;
    L5:
        displayId2 = displayId;
        goto L7
    }

    private void panMagnificationByStep(int r18, boolean[] r19) {
        if (r19.length == 4) goto L6;
        Slog.d(TAG, "Invalid number of panning directions");
        return;
    L6:
        boolean r9 = getFullScreenMagnificationController().isActivated(r18);
        boolean r10 = getMagnificationConnectionManager().isWindowMagnifierEnabled(r18);
        if (r9 == true) goto L10;
        if (r10 == true) goto L10;
        return;
    L10:
        boolean r3 = r19[0];
        boolean r5 = r19[1];
        int r11 = (((r3 ? 1 : 0) + (r5 ? 1 : 0)) + (r19[2] ? 1 : 0)) + (r19[3] ? 1 : 0);
        if (r11 != 0) goto L13;
        return;
    L13:
        if (r9 == false) goto L15;
        float r4 = getFullScreenMagnificationController().getScale(r18);
    L16:
        float r7 = this.mPanStepProvider.nextPanStep(r4, r18);
        if (r11 != 2) goto L19;
        float r12 = r7 / MathUtils.sqrt(2.0f);
    L20:
        float r8 = 0.0f;
        float r13 = 0.0f;
        if (r19[0] == false) goto L24;
        r8 = 0.0f - r12;
    L24:
        if (r19[1] == false) goto L26;
        float r14 = r8 + r12;
    L28:
        if (r19[2] == false) goto L31;
        r13 = 0.0f - r12;
    L31:
        if (r19[3] == false) goto L33;
        r13 = r13 + r12;
    L33:
        if (r9 == false) goto L35;
        float r15 = getFullScreenMagnificationController().getCenterX(r18);
        float r16 = getFullScreenMagnificationController().getCenterY(r18);
        getFullScreenMagnificationController().setScaleAndCenter(r18, r4, r15 + r14, r16 + r13, true, 0);
    L36:
        this.mLastPannedTime = this.mSystemClock.uptimeMillis();
        return;
    L35:
        getMagnificationConnectionManager().moveWindowMagnification(r18, r14, r13);
        goto L36
    L26:
        r14 = r8;
        goto L28
    L19:
        r12 = r7;
        goto L20
    L15:
        r4 = getMagnificationConnectionManager().getScale(r18);
        goto L16
    }
}

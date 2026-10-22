package com.android.server.accessibility.magnification;

import android.R;
import android.accessibilityservice.MagnificationConfig;
import android.animation.Animator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.CompatibilityInfo;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.display.DisplayManagerInternal;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.MathUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.DisplayInfo;
import android.view.MagnificationSpec;
import android.view.WindowManager;
import android.view.accessibility.MagnificationAnimationCallback;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalServices;
import com.android.server.accessibility.AccessibilityTraceManager;
import com.android.server.input.InputManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FullScreenMagnificationController implements WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_SET_MAGNIFICATION_SPEC = false;
    private static final String LOG_TAG = "FullScreenMagnificationController";
    private boolean mAlwaysOnMagnificationEnabled;
    private final ControllerContext mControllerCtx;
    private final DisplayManagerInternal mDisplayManagerInternal;
    private final SparseArray<DisplayMagnification> mDisplays;
    private boolean mIsPointerMotionFilterInstalled;
    private final Object mLock;
    private final Supplier<Boolean> mMagnificationConnectionStateSupplier;
    private boolean mMagnificationFollowTypingEnabled;
    private final ArrayList<MagnificationInfoChangedCallback> mMagnificationInfoChangedCallbacks;
    private final MagnificationThumbnailFeatureFlag mMagnificationThumbnailFeatureFlag;
    private final long mMainThreadId;
    private final MagnificationScaleProvider mScaleProvider;
    private final ScreenStateObserver mScreenStateObserver;
    private final Supplier<Scroller> mScrollerSupplier;
    private final Rect mTempRect;
    private final Supplier<MagnificationThumbnail> mThumbnailSupplier;
    private final Supplier<TimeAnimator> mTimeAnimatorSupplier;

    public static class ControllerContext {
        private final Long mAnimationDuration;
        private final Context mContext;
        private final Handler mHandler;
        private final InputManagerInternal mInputManager;
        private final AccessibilityTraceManager mTrace;
        private final WindowManagerInternal mWindowManager;

        public ControllerContext(Context context, AccessibilityTraceManager traceManager, WindowManagerInternal windowManager, InputManagerInternal inputManager, Handler handler, long animationDuration) {
            this.mContext = context;
            this.mTrace = traceManager;
            this.mWindowManager = windowManager;
            this.mInputManager = inputManager;
            this.mHandler = handler;
            this.mAnimationDuration = Long.valueOf(animationDuration);
        }

        public Context getContext() {
            return this.mContext;
        }

        public AccessibilityTraceManager getTraceManager() {
            return this.mTrace;
        }

        public WindowManagerInternal getWindowManager() {
            return this.mWindowManager;
        }

        public InputManagerInternal getInputManager() {
            return this.mInputManager;
        }

        public Handler getHandler() {
            return this.mHandler;
        }

        public ValueAnimator newValueAnimator() {
            return new ValueAnimator();
        }

        public long getAnimationDuration() {
            return this.mAnimationDuration.longValue();
        }
    }

    private final class DisplayMagnification implements WindowManagerInternal.MagnificationCallbacks {
        private final MagnificationSpec mCurrentMagnificationSpec;
        private boolean mDeleteAfterUnregister;
        private final int mDisplayId;
        private int mIdOfLastServiceToMagnify;
        private boolean mMagnificationActivated;
        private final Rect mMagnificationBounds;
        private final Region mMagnificationRegion;
        private MagnificationThumbnail mMagnificationThumbnail;
        private boolean mRegistered;
        private final SpecAnimationBridge mSpecAnimationBridge;
        private final Rect mTempRect;
        private final Rect mTempRect1;
        private boolean mUnregisterPending;
        private boolean mZoomedOutFromService;
        final /* synthetic */ FullScreenMagnificationController this$0;

        /* JADX INFO: renamed from: $r8$lambda$-qwsSre2CuZ6keMkDR_4ZLIlnAY, reason: not valid java name */
        public static /* synthetic */ void m786$r8$lambda$qwsSre2CuZ6keMkDR_4ZLIlnAY(DisplayMagnification r0, MagnificationInfoChangedCallback r1) {
            r0.lambda$setActivated$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$0tgaD9aUo13QDAnopPEGSYX7ERw(DisplayMagnification r0, MagnificationInfoChangedCallback r1) {
            r0.lambda$setScaleAndCenter$2(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$nc9sJC0AIRwMSzkb-vNNnf00g6A, reason: not valid java name */
        public static /* synthetic */ void m787$r8$lambda$nc9sJC0AIRwMSzkbvNNnf00g6A(DisplayMagnification r0, MagnificationConfig r1, MagnificationInfoChangedCallback r2) {
            r0.lambda$onMagnificationChangedLocked$0(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCurrentMagnificationSpec, reason: not valid java name */
        static /* bridge */ /* synthetic */ MagnificationSpec m788$$Nest$fgetmCurrentMagnificationSpec(DisplayMagnification r0) {
            return r0.mCurrentMagnificationSpec;
        }

        DisplayMagnification(FullScreenMagnificationController r9, int displayId) {
            this.this$0 = r9;
            this.mCurrentMagnificationSpec = new MagnificationSpec();
            this.mMagnificationRegion = Region.obtain();
            this.mMagnificationBounds = new Rect();
            this.mTempRect = new Rect();
            this.mTempRect1 = new Rect();
            this.mIdOfLastServiceToMagnify = -1;
            this.mMagnificationActivated = false;
            this.mZoomedOutFromService = false;
            this.mDisplayId = displayId;
            this.mSpecAnimationBridge = new SpecAnimationBridge(FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(r9), FullScreenMagnificationController.m774$$Nest$fgetmLock(r9), this.mDisplayId, FullScreenMagnificationController.m778$$Nest$fgetmScrollerSupplier(r9), FullScreenMagnificationController.m780$$Nest$fgetmTimeAnimatorSupplier(r9), null);
        }

        boolean register() {
            if (FullScreenMagnificationController.m783$$Nest$mtraceEnabled(this.this$0) == false) goto L5;
            FullScreenMagnificationController.m781$$Nest$mlogTrace(this.this$0, "setMagnificationCallbacks", "displayID=" + this.mDisplayId + ";callback=" + this);
        L5:
            this.mRegistered = FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getWindowManager().setMagnificationCallbacks(this.mDisplayId, this);
            if (this.mRegistered == true) goto L9;
            Slog.w(FullScreenMagnificationController.LOG_TAG, "set magnification callbacks fail, displayId:" + this.mDisplayId);
            return false;
        L9:
            this.mSpecAnimationBridge.setEnabled(true);
            if (FullScreenMagnificationController.m783$$Nest$mtraceEnabled(this.this$0) == false) goto L12;
            FullScreenMagnificationController.m781$$Nest$mlogTrace(this.this$0, "getMagnificationRegion", "displayID=" + this.mDisplayId + ";region=" + this.mMagnificationRegion);
        L12:
            FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getWindowManager().getMagnificationRegion(this.mDisplayId, this.mMagnificationRegion);
            this.mMagnificationRegion.getBounds(this.mMagnificationBounds);
            createThumbnailIfSupported();
            return true;
        }

        void unregister(boolean delete) {
            if (this.mRegistered == false) goto L8;
            this.mSpecAnimationBridge.setEnabled(false);
            if (FullScreenMagnificationController.m783$$Nest$mtraceEnabled(this.this$0) == false) goto L7;
            FullScreenMagnificationController.m781$$Nest$mlogTrace(this.this$0, "setMagnificationCallbacks", "displayID=" + this.mDisplayId + ";callback=null");
        L7:
            FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getWindowManager().setMagnificationCallbacks(this.mDisplayId, null);
            this.mMagnificationRegion.setEmpty();
            this.mRegistered = false;
            FullScreenMagnificationController.m784$$Nest$munregisterCallbackLocked(this.this$0, this.mDisplayId, delete);
            destroyThumbnail();
        L8:
            this.mUnregisterPending = false;
        }

        void unregisterPending(boolean delete) {
            this.mDeleteAfterUnregister = delete;
            this.mUnregisterPending = true;
            reset(true);
        }

        boolean isRegistered() {
            return this.mRegistered;
        }

        boolean isActivated() {
            return this.mMagnificationActivated;
        }

        float getScale() {
            return this.mCurrentMagnificationSpec.scale;
        }

        float getOffsetX() {
            return this.mCurrentMagnificationSpec.offsetX;
        }

        float getOffsetY() {
            return this.mCurrentMagnificationSpec.offsetY;
        }

        boolean isAtEdge() {
            if (isAtLeftEdge(0.0f) == false) goto L5;
        L12:
            return true;
        L5:
            if (isAtRightEdge(0.0f) == true) goto L12;
            if (isAtTopEdge(0.0f) == true) goto L12;
            if (isAtBottomEdge(0.0f) == true) goto L12;
            return false;
        }

        boolean isAtLeftEdge(float slop) {
            if (MathUtils.abs(getOffsetX() - getMaxOffsetXLocked()) > slop) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isAtRightEdge(float slop) {
            if (MathUtils.abs(getOffsetX() - getMinOffsetXLocked()) > slop) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isAtTopEdge(float slop) {
            if (MathUtils.abs(getOffsetY() - getMaxOffsetYLocked()) > slop) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isAtBottomEdge(float slop) {
            if (MathUtils.abs(getOffsetY() - getMinOffsetYLocked()) > slop) goto L5;
            return true;
        L5:
            return false;
        }

        float getCenterX() {
            return (((this.mMagnificationBounds.width() / 2.0f) + this.mMagnificationBounds.left) - getOffsetX()) / getScale();
        }

        float getCenterY() {
            return (((this.mMagnificationBounds.height() / 2.0f) + this.mMagnificationBounds.top) - getOffsetY()) / getScale();
        }

        float getSentScale() {
            return SpecAnimationBridge.m789$$Nest$fgetmSentMagnificationSpec(this.mSpecAnimationBridge).scale;
        }

        float getSentOffsetX() {
            return SpecAnimationBridge.m789$$Nest$fgetmSentMagnificationSpec(this.mSpecAnimationBridge).offsetX;
        }

        float getSentOffsetY() {
            return SpecAnimationBridge.m789$$Nest$fgetmSentMagnificationSpec(this.mSpecAnimationBridge).offsetY;
        }

        @Override // com.android.server.wm.WindowManagerInternal.MagnificationCallbacks
        public void onMagnificationRegionChanged(Region magnificationRegion) {
            Message m = PooledLambda.obtainMessage(new FullScreenMagnificationController$DisplayMagnification$$ExternalSyntheticLambda5(), this, Region.obtain(magnificationRegion));
            FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getHandler().sendMessage(m);
        }

        @Override // com.android.server.wm.WindowManagerInternal.MagnificationCallbacks
        public void onRectangleOnScreenRequested(int left, int top, int right, int bottom) {
            Message m = PooledLambda.obtainMessage(new FullScreenMagnificationController$DisplayMagnification$$ExternalSyntheticLambda8(), this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
            FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getHandler().sendMessage(m);
        }

        @Override // com.android.server.wm.WindowManagerInternal.MagnificationCallbacks
        public void onDisplaySizeChanged() {
            onUserContextChanged();
        }

        @Override // com.android.server.wm.WindowManagerInternal.MagnificationCallbacks
        public void onUserContextChanged() {
            Message m = PooledLambda.obtainMessage(new FullScreenMagnificationController$DisplayMagnification$$ExternalSyntheticLambda4(), this.this$0, Integer.valueOf(this.mDisplayId));
            FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getHandler().sendMessage(m);
            Object r1 = FullScreenMagnificationController.m774$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            refreshThumbnail();     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.wm.WindowManagerInternal.MagnificationCallbacks
        public void onImeWindowVisibilityChanged(boolean shown) {
            Message m = PooledLambda.obtainMessage(new FullScreenMagnificationController$DisplayMagnification$$ExternalSyntheticLambda3(), this.this$0, Integer.valueOf(this.mDisplayId), Boolean.valueOf(shown));
            FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getHandler().sendMessage(m);
        }

        void updateMagnificationRegion(Region magnified) {
            Object r0 = FullScreenMagnificationController.m774$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mRegistered == true) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.mMagnificationRegion.equals(magnified) == true) goto L16;
            this.mMagnificationRegion.set(magnified);     // Catch: Throwable -> L8
            this.mMagnificationRegion.getBounds(this.mMagnificationBounds);     // Catch: Throwable -> L8
            refreshThumbnail();     // Catch: Throwable -> L8
            if (updateCurrentSpecWithOffsetsLocked(this.mCurrentMagnificationSpec.offsetX, this.mCurrentMagnificationSpec.offsetY) == false) goto L15;
            sendSpecToAnimation(this.mCurrentMagnificationSpec, null);     // Catch: Throwable -> L8
        L15:
            onMagnificationChangedLocked(false);     // Catch: Throwable -> L8
        L16:
            magnified.recycle();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        void sendSpecToAnimation(MagnificationSpec spec, MagnificationAnimationCallback animationCallback) {
            if (Thread.currentThread().getId() != FullScreenMagnificationController.m777$$Nest$fgetmMainThreadId(this.this$0)) goto L5;
            this.mSpecAnimationBridge.updateSentSpecMainThread(spec, animationCallback);
            return;
        L5:
            Message m = PooledLambda.obtainMessage(new FullScreenMagnificationController$DisplayMagnification$$ExternalSyntheticLambda6(), this.mSpecAnimationBridge, spec, animationCallback);
            FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getHandler().sendMessage(m);
        }

        void startFlingAnimation(float xPixelsPerSecond, float yPixelsPerSecond, MagnificationAnimationCallback animationCallback) {
            if (Thread.currentThread().getId() != FullScreenMagnificationController.m777$$Nest$fgetmMainThreadId(this.this$0)) goto L5;
            this.mSpecAnimationBridge.startFlingAnimation(xPixelsPerSecond, yPixelsPerSecond, getMinOffsetXLocked(), getMaxOffsetXLocked(), getMinOffsetYLocked(), getMaxOffsetYLocked(), animationCallback);
            return;
        L5:
            Message m = PooledLambda.obtainMessage(new FullScreenMagnificationController$DisplayMagnification$$ExternalSyntheticLambda0(), this.mSpecAnimationBridge, Float.valueOf(xPixelsPerSecond), Float.valueOf(yPixelsPerSecond), Float.valueOf(getMinOffsetXLocked()), Float.valueOf(getMaxOffsetXLocked()), Float.valueOf(getMinOffsetYLocked()), Float.valueOf(getMaxOffsetYLocked()), animationCallback);
            FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getHandler().sendMessage(m);
        }

        void cancelFlingAnimation() {
            if (Thread.currentThread().getId() != FullScreenMagnificationController.m777$$Nest$fgetmMainThreadId(this.this$0)) goto L5;
            this.mSpecAnimationBridge.cancelFlingAnimation();
            return;
        L5:
            Handler r0 = FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getHandler();
            final SpecAnimationBridge r1 = this.mSpecAnimationBridge;
            r1.getClass();
            r0.post(new FullScreenMagnificationController$DisplayMagnification$$ExternalSyntheticLambda9(r1));
        }

        int getIdOfLastServiceToMagnify() {
            return this.mIdOfLastServiceToMagnify;
        }

        void onMagnificationChangedLocked(boolean isScaleTransient) {
            float scale = getScale();
            float centerX = getCenterX();
            float centerY = getCenterY();
            final MagnificationConfig config = new MagnificationConfig.Builder().setMode(1).setActivated(this.mMagnificationActivated).setScale(scale).setCenterX(centerX).setCenterY(centerY).build();
            FullScreenMagnificationController.m776$$Nest$fgetmMagnificationInfoChangedCallbacks(this.this$0).forEach(new FullScreenMagnificationController$DisplayMagnification$$ExternalSyntheticLambda1(this, config));
            if (this.mUnregisterPending == false) goto L8;
            if (isActivated() == true) goto L8;
            unregister(this.mDeleteAfterUnregister);
        L8:
            if (isActivated() == false) goto L10;
            updateThumbnail(scale, centerX, centerY);
        L11:
            if (isScaleTransient == true) goto L14;
            this.this$0.notifyScaleForInput(this.mDisplayId, scale);
            return;
        L14:
            return;
        L10:
            hideThumbnail();
            goto L11
        }

        private /* synthetic */ void lambda$onMagnificationChangedLocked$0(MagnificationConfig config, MagnificationInfoChangedCallback callback) {
            callback.onFullScreenMagnificationChanged(this.mDisplayId, this.mMagnificationRegion, config);
        }

        boolean magnificationRegionContains(float x, float y) {
            return this.mMagnificationRegion.contains((int) x, (int) y);
        }

        void getMagnificationBounds(Rect outBounds) {
            outBounds.set(this.mMagnificationBounds);
        }

        void getMagnificationRegion(Region outRegion) {
            outRegion.set(this.mMagnificationRegion);
        }

        private DisplayMetrics getDisplayMetricsForId() {
            DisplayMetrics outMetrics = new DisplayMetrics();
            DisplayInfo displayInfo = FullScreenMagnificationController.m773$$Nest$fgetmDisplayManagerInternal(this.this$0).getDisplayInfo(this.mDisplayId);
            if (displayInfo == null) goto L5;
            displayInfo.getLogicalMetrics(outMetrics, CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, null);
        L6:
            return outMetrics;
        L5:
            outMetrics.setToDefaults();
            goto L6
        }

        void requestRectangleOnScreen(int left, int top, int right, int bottom) {
            Object r6 = FullScreenMagnificationController.m774$$Nest$fgetmLock(this.this$0);
            monitor-enter(r6);
            Rect magnifiedFrame = this.mTempRect;     // Catch: Throwable -> L8
            getMagnificationBounds(magnifiedFrame);     // Catch: Throwable -> L8
            if (magnifiedFrame.intersects(left, top, right, bottom) == true) goto L10;
            monitor-exit(r6);     // Catch: Throwable -> L8
            return;
        L10:
            Rect magnifFrameInScreenCoords = this.mTempRect1;     // Catch: Throwable -> L8
            getMagnifiedFrameInContentCoordsLocked(magnifFrameInScreenCoords);     // Catch: Throwable -> L8
            DisplayMetrics metrics = getDisplayMetricsForId();     // Catch: Throwable -> L8
            float offsetViewportX = magnifFrameInScreenCoords.width() / 4.0f;     // Catch: Throwable -> L8
            float offsetViewportY = TypedValue.applyDimension(1, 10.0f, metrics);     // Catch: Throwable -> L8
            if ((right - left) <= magnifFrameInScreenCoords.width()) goto L18;
            int direction = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault());     // Catch: Throwable -> L8
            if (direction != 0) goto L15;
            float scrollX = left - magnifFrameInScreenCoords.left;     // Catch: Throwable -> L8
        L25:
            if ((bottom - top) <= magnifFrameInScreenCoords.height()) goto L28;
            float scrollY = top - magnifFrameInScreenCoords.top;     // Catch: Throwable -> L8
        L34:
            float scale = getScale();     // Catch: Throwable -> L8
            offsetMagnifiedRegion(scrollX * scale, scrollY * scale, -1);     // Catch: Throwable -> L8
            monitor-exit(r6);     // Catch: Throwable -> L8
            return;
        L28:
            if (top >= magnifFrameInScreenCoords.top) goto L31;
            scrollY = (top - magnifFrameInScreenCoords.top) - offsetViewportY;     // Catch: Throwable -> L8
            goto L34
        L31:
            if (bottom <= magnifFrameInScreenCoords.bottom) goto L33;
            scrollY = (bottom - magnifFrameInScreenCoords.bottom) + offsetViewportY;     // Catch: Throwable -> L8
            goto L34
        L33:
            scrollY = 0.0f;
            goto L34
        L15:
            scrollX = right - magnifFrameInScreenCoords.right;     // Catch: Throwable -> L8
            goto L25
        L18:
            if (left >= magnifFrameInScreenCoords.left) goto L21;
            scrollX = (left - magnifFrameInScreenCoords.left) - offsetViewportX;     // Catch: Throwable -> L8
            goto L25
        L21:
            if (right <= magnifFrameInScreenCoords.right) goto L23;
            scrollX = (right - magnifFrameInScreenCoords.right) + offsetViewportX;     // Catch: Throwable -> L8
            goto L25
        L23:
            scrollX = 0.0f;
        L8:
            th = move-exception;
            throw th;
        }

        void getMagnifiedFrameInContentCoordsLocked(Rect outFrame) {
            float scale = getSentScale();
            float offsetX = getSentOffsetX();
            float offsetY = getSentOffsetY();
            getMagnificationBounds(outFrame);
            outFrame.offset((int) (-offsetX), (int) (-offsetY));
            outFrame.scale(1.0f / scale);
        }

        private boolean setActivated(boolean activated) {
            if (this.mMagnificationActivated == activated) goto L5;
            boolean changed = true;
        L6:
            if (changed == false) goto L8;
            this.mMagnificationActivated = activated;
            FullScreenMagnificationController.m776$$Nest$fgetmMagnificationInfoChangedCallbacks(this.this$0).forEach(new FullScreenMagnificationController$DisplayMagnification$$ExternalSyntheticLambda7(this));
            FullScreenMagnificationController.m772$$Nest$fgetmControllerCtx(this.this$0).getWindowManager().setFullscreenMagnificationActivated(this.mDisplayId, activated);
        L8:
            return changed;
        L5:
            changed = false;
            goto L6
        }

        private /* synthetic */ void lambda$setActivated$1(MagnificationInfoChangedCallback callback) {
            callback.onFullScreenMagnificationActivationState(this.mDisplayId, this.mMagnificationActivated);
        }

        void zoomOutFromService() {
            setScaleAndCenter(1.0f, Float.NaN, Float.NaN, false, FullScreenMagnificationController.m785$$Nest$smtransformToStubCallback(true), 0);
            this.mZoomedOutFromService = true;
        }

        boolean isZoomedOutFromService() {
            return this.mZoomedOutFromService;
        }

        boolean reset(boolean animate) {
            return reset(FullScreenMagnificationController.m785$$Nest$smtransformToStubCallback(animate));
        }

        boolean reset(MagnificationAnimationCallback animationCallback) {
            if (this.mRegistered == true) goto L5;
            return false;
        L5:
            MagnificationSpec spec = this.mCurrentMagnificationSpec;
            boolean changed = isActivated();
            setActivated(false);
            if (changed == false) goto L8;
            spec.clear();
            onMagnificationChangedLocked(false);
        L8:
            this.mIdOfLastServiceToMagnify = -1;
            sendSpecToAnimation(spec, animationCallback);
            hideThumbnail();
            return changed;
        }

        boolean setScale(float scale, float pivotX, float pivotY, boolean isScaleTransient, boolean animate, int id) {
            if (this.mRegistered == true) goto L6;
            return false;
        L6:
            float scale2 = MagnificationScaleProvider.constrainScale(scale);
            Rect viewport = this.mTempRect;
            this.mMagnificationRegion.getBounds(viewport);
            MagnificationSpec spec = this.mCurrentMagnificationSpec;
            float oldScale = spec.scale;
            float oldCenterX = (((viewport.width() / 2.0f) - spec.offsetX) + viewport.left) / oldScale;
            float oldCenterY = (((viewport.height() / 2.0f) - spec.offsetY) + viewport.top) / oldScale;
            float normPivotX = (pivotX - spec.offsetX) / oldScale;
            float normPivotY = (pivotY - spec.offsetY) / oldScale;
            float offsetX = (oldCenterX - normPivotX) * (oldScale / scale2);
            float offsetY = (oldCenterY - normPivotY) * (oldScale / scale2);
            float centerX = normPivotX + offsetX;
            float centerY = normPivotY + offsetY;
            this.mIdOfLastServiceToMagnify = id;
            return setScaleAndCenter(scale2, centerX, centerY, isScaleTransient, FullScreenMagnificationController.m785$$Nest$smtransformToStubCallback(animate), id);
        }

        boolean setScaleAndCenter(float scale, float centerX, float centerY, boolean isScaleTransient, MagnificationAnimationCallback animationCallback, int id) {
            if (this.mRegistered == true) goto L6;
            return false;
        L6:
            if (((Boolean) FullScreenMagnificationController.m775$$Nest$fgetmMagnificationConnectionStateSupplier(this.this$0).get()).booleanValue() == true) goto L8;
            return false;
        L8:
            boolean changed = setActivated(true);
            boolean changed2 = changed | updateMagnificationSpecLocked(scale, centerX, centerY, isScaleTransient);
            sendSpecToAnimation(this.mCurrentMagnificationSpec, animationCallback);
            if (isActivated() == true) goto L11;
        L13:
            this.mZoomedOutFromService = false;
            return changed2;
        L11:
            if (id == (-1)) goto L13;
            this.mIdOfLastServiceToMagnify = id;
            FullScreenMagnificationController.m776$$Nest$fgetmMagnificationInfoChangedCallbacks(this.this$0).forEach(new FullScreenMagnificationController$DisplayMagnification$$ExternalSyntheticLambda2(this));
            goto L13
        }

        private /* synthetic */ void lambda$setScaleAndCenter$2(MagnificationInfoChangedCallback callback) {
            callback.onRequestMagnificationSpec(this.mDisplayId, this.mIdOfLastServiceToMagnify);
        }

        void updateThumbnail(float scale, float centerX, float centerY) {
            if (this.mMagnificationThumbnail == null) goto L6;
            this.mMagnificationThumbnail.updateThumbnail(scale, centerX, centerY);
            return;
        }

        void refreshThumbnail() {
            if (this.mMagnificationThumbnail == null) goto L6;
            this.mMagnificationThumbnail.setThumbnailBounds(this.mMagnificationBounds, getScale(), getCenterX(), getCenterY());
            return;
        }

        void hideThumbnail() {
            if (this.mMagnificationThumbnail == null) goto L6;
            this.mMagnificationThumbnail.hideThumbnail();
            return;
        }

        void createThumbnailIfSupported() {
            if (this.mMagnificationThumbnail != null) goto L6;
            this.mMagnificationThumbnail = (MagnificationThumbnail) FullScreenMagnificationController.m779$$Nest$fgetmThumbnailSupplier(this.this$0).get();
            refreshThumbnail();
            return;
        }

        void destroyThumbnail() {
            if (this.mMagnificationThumbnail == null) goto L6;
            hideThumbnail();
            this.mMagnificationThumbnail = null;
            return;
        }

        void onThumbnailFeatureFlagChanged() {
            Object r0 = FullScreenMagnificationController.m774$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            destroyThumbnail();     // Catch: Throwable -> L7
            createThumbnailIfSupported();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        boolean updateMagnificationSpecLocked(float scale, float centerX, float centerY, boolean isScaleTransient) {
            if (Float.isNaN(centerX) == false) goto L6;
            centerX = getCenterX();
        L6:
            if (Float.isNaN(centerY) == false) goto L9;
            centerY = getCenterY();
        L9:
            if (Float.isNaN(scale) == false) goto L11;
            scale = getScale();
        L11:
            boolean changed = false;
            float normScale = MagnificationScaleProvider.constrainScale(scale);
            if (Float.compare(this.mCurrentMagnificationSpec.scale, normScale) == 0) goto L14;
            this.mCurrentMagnificationSpec.scale = normScale;
            changed = true;
        L14:
            float nonNormOffsetX = ((this.mMagnificationBounds.width() / 2.0f) + this.mMagnificationBounds.left) - (centerX * normScale);
            float nonNormOffsetY = ((this.mMagnificationBounds.height() / 2.0f) + this.mMagnificationBounds.top) - (centerY * normScale);
            boolean changed2 = changed | updateCurrentSpecWithOffsetsLocked(nonNormOffsetX, nonNormOffsetY);
            if (changed2 == false) goto L17;
            onMagnificationChangedLocked(isScaleTransient);
        L17:
            return changed2;
        }

        void offsetMagnifiedRegion(float offsetX, float offsetY, int id) {
            if (this.mRegistered == true) goto L5;
            return;
        L5:
            setOffset(this.mCurrentMagnificationSpec.offsetX - offsetX, this.mCurrentMagnificationSpec.offsetY - offsetY, id);
        }

        void setOffset(float offsetX, float offsetY, int id) {
            if (this.mRegistered == true) goto L6;
            return;
        L6:
            if (updateCurrentSpecWithOffsetsLocked(offsetX, offsetY) == false) goto L9;
            onMagnificationChangedLocked(false);
        L9:
            if (id == (-1)) goto L11;
            this.mIdOfLastServiceToMagnify = id;
        L11:
            sendSpecToAnimation(this.mCurrentMagnificationSpec, null);
        }

        void startFling(float xPixelsPerSecond, float yPixelsPerSecond, int id) {
            if (this.mRegistered == true) goto L6;
            return;
        L6:
            if (isActivated() == true) goto L9;
            return;
        L9:
            if (id == (-1)) goto L11;
            this.mIdOfLastServiceToMagnify = id;
        L11:
            startFlingAnimation(xPixelsPerSecond, yPixelsPerSecond, new AnonymousClass1(this));
        }

        void cancelFling(int id) {
            if (this.mRegistered == true) goto L6;
            return;
        L6:
            if (id == (-1)) goto L8;
            this.mIdOfLastServiceToMagnify = id;
        L8:
            cancelFlingAnimation();
        }

        boolean updateCurrentSpecWithOffsetsLocked(float nonNormOffsetX, float nonNormOffsetY) {
            boolean changed = false;
            float offsetX = MathUtils.constrain(nonNormOffsetX, getMinOffsetXLocked(), getMaxOffsetXLocked());
            if (Float.compare(this.mCurrentMagnificationSpec.offsetX, offsetX) == 0) goto L5;
            this.mCurrentMagnificationSpec.offsetX = offsetX;
            changed = true;
        L5:
            float offsetY = MathUtils.constrain(nonNormOffsetY, getMinOffsetYLocked(), getMaxOffsetYLocked());
            if (Float.compare(this.mCurrentMagnificationSpec.offsetY, offsetY) == 0) goto L9;
            this.mCurrentMagnificationSpec.offsetY = offsetY;
            return true;
        L9:
            return changed;
        }

        float getMinOffsetXLocked() {
            float viewportWidth = this.mMagnificationBounds.width();
            float viewportLeft = this.mMagnificationBounds.left;
            return (viewportLeft + viewportWidth) - ((viewportLeft + viewportWidth) * this.mCurrentMagnificationSpec.scale);
        }

        float getMaxOffsetXLocked() {
            return this.mMagnificationBounds.left - (this.mMagnificationBounds.left * this.mCurrentMagnificationSpec.scale);
        }

        float getMinOffsetYLocked() {
            float viewportHeight = this.mMagnificationBounds.height();
            float viewportTop = this.mMagnificationBounds.top;
            return (viewportTop + viewportHeight) - ((viewportTop + viewportHeight) * this.mCurrentMagnificationSpec.scale);
        }

        float getMaxOffsetYLocked() {
            return this.mMagnificationBounds.top - (this.mMagnificationBounds.top * this.mCurrentMagnificationSpec.scale);
        }

        public String toString() {
            return "DisplayMagnification[mCurrentMagnificationSpec=" + this.mCurrentMagnificationSpec + ", mMagnificationRegion=" + this.mMagnificationRegion + ", mMagnificationBounds=" + this.mMagnificationBounds + ", mDisplayId=" + this.mDisplayId + ", mIdOfLastServiceToMagnify=" + this.mIdOfLastServiceToMagnify + ", mRegistered=" + this.mRegistered + ", mUnregisterPending=" + this.mUnregisterPending + ']';
        }
    }

    interface MagnificationInfoChangedCallback {
        void onFullScreenMagnificationActivationState(int r1, boolean r2);

        void onFullScreenMagnificationChanged(int r1, Region r2, MagnificationConfig r3);

        void onImeWindowVisibilityChanged(int r1, boolean r2);

        void onRequestMagnificationSpec(int r1, int r2);
    }

    private static class ScreenStateObserver extends BroadcastReceiver {
        private final Context mContext;
        private final FullScreenMagnificationController mController;
        private boolean mRegistered;

        ScreenStateObserver(Context context, FullScreenMagnificationController controller) {
            this.mRegistered = false;
            this.mContext = context;
            this.mController = controller;
        }

        public void registerIfNecessary() {
            if (this.mRegistered == true) goto L6;
            this.mContext.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_OFF"));
            this.mRegistered = true;
            return;
        }

        public void unregister() {
            if (this.mRegistered == false) goto L6;
            this.mContext.unregisterReceiver(this);
            this.mRegistered = false;
            return;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            FullScreenMagnificationController.m782$$Nest$monScreenTurnedOff(this.mController);
        }
    }

    private static class SpecAnimationBridge implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
        private MagnificationAnimationCallback mAnimationCallback;
        private final ControllerContext mControllerCtx;
        private final int mDisplayId;
        private boolean mEnabled;
        private final MagnificationSpec mEndMagnificationSpec;
        private final Object mLock;
        private final TimeAnimator mScrollAnimator;
        private final Scroller mScroller;
        private final MagnificationSpec mSentMagnificationSpec;
        private final MagnificationSpec mStartMagnificationSpec;
        private final ValueAnimator mValueAnimator;

        /* JADX INFO: renamed from: -$$Nest$fgetmSentMagnificationSpec, reason: not valid java name */
        static /* bridge */ /* synthetic */ MagnificationSpec m789$$Nest$fgetmSentMagnificationSpec(SpecAnimationBridge r0) {
            return r0.mSentMagnificationSpec;
        }

        /* synthetic */ SpecAnimationBridge(ControllerContext r1, Object r2, int r3, Supplier r4, Supplier r5, FullScreenMagnificationControllerIA r6) {
            this(r1, r2, r3, r4, r5);
        }

        private SpecAnimationBridge(ControllerContext ctx, Object lock, int displayId, Supplier<Scroller> scrollerSupplier, Supplier<TimeAnimator> timeAnimatorSupplier) {
            this.mSentMagnificationSpec = new MagnificationSpec();
            this.mStartMagnificationSpec = new MagnificationSpec();
            this.mEndMagnificationSpec = new MagnificationSpec();
            this.mEnabled = false;
            this.mControllerCtx = ctx;
            this.mLock = lock;
            this.mDisplayId = displayId;
            long animationDuration = this.mControllerCtx.getAnimationDuration();
            this.mValueAnimator = this.mControllerCtx.newValueAnimator();
            this.mValueAnimator.setDuration(animationDuration);
            this.mValueAnimator.setInterpolator(new DecelerateInterpolator(2.5f));
            this.mValueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
            this.mValueAnimator.addUpdateListener(this);
            this.mValueAnimator.addListener(this);
            this.mScroller = null;
            this.mScrollAnimator = null;
        }

        private /* synthetic */ void lambda$new$0(TimeAnimator animation, long totalTime, long deltaTime) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mEnabled == true) goto L7;
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (this.mScroller.computeScrollOffset() == true) goto L13;
            animation.end();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            this.mEndMagnificationSpec.offsetX = this.mScroller.getCurrX();     // Catch: Throwable -> L11
            this.mEndMagnificationSpec.offsetY = this.mScroller.getCurrY();     // Catch: Throwable -> L11
            setMagnificationSpecLocked(this.mEndMagnificationSpec);     // Catch: Throwable -> L11
            goto L14
        }

        public void setEnabled(boolean enabled) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (enabled == this.mEnabled) goto L14;
            this.mEnabled = enabled;     // Catch: Throwable -> L11
            if (this.mEnabled == true) goto L14;
            this.mSentMagnificationSpec.clear();     // Catch: Throwable -> L11
            if (this.mControllerCtx.getTraceManager().isA11yTracingEnabledForTypes(512) == false) goto L13;
            this.mControllerCtx.getTraceManager().logTrace("WindowManagerInternal.setMagnificationSpec", 512, "displayID=" + this.mDisplayId + ";spec=" + this.mSentMagnificationSpec);     // Catch: Throwable -> L11
        L13:
            this.mControllerCtx.getWindowManager().setMagnificationSpec(this.mDisplayId, this.mSentMagnificationSpec);     // Catch: Throwable -> L11
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L11
        }

        void updateSentSpecMainThread(MagnificationSpec spec, MagnificationAnimationCallback animationCallback) {
            cancelAnimations();
            this.mAnimationCallback = animationCallback;
            Object r0 = this.mLock;
            monitor-enter(r0);
            boolean changed = !this.mSentMagnificationSpec.equals(spec);     // Catch: Throwable -> L9
            if (changed == true) goto L7;
            sendEndCallbackMainThread(true);     // Catch: Throwable -> L9
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L7:
            if (this.mAnimationCallback == null) goto L11;
            animateMagnificationSpecLocked(spec);     // Catch: Throwable -> L9
            goto L13
        L11:
            setMagnificationSpecLocked(spec);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        private void sendEndCallbackMainThread(boolean success) {
            if (this.mAnimationCallback == null) goto L6;
            this.mAnimationCallback.onResult(success, this.mSentMagnificationSpec);
            this.mAnimationCallback = null;
            return;
        }

        private void setMagnificationSpecLocked(MagnificationSpec spec) {
            if (this.mEnabled == false) goto L9;
            this.mSentMagnificationSpec.setTo(spec);
            if (this.mControllerCtx.getTraceManager().isA11yTracingEnabledForTypes(512) == false) goto L7;
            this.mControllerCtx.getTraceManager().logTrace("WindowManagerInternal.setMagnificationSpec", 512, "displayID=" + this.mDisplayId + ";spec=" + this.mSentMagnificationSpec);
        L7:
            this.mControllerCtx.getWindowManager().setMagnificationSpec(this.mDisplayId, this.mSentMagnificationSpec);
            return;
        }

        private void animateMagnificationSpecLocked(MagnificationSpec toSpec) {
            this.mEndMagnificationSpec.setTo(toSpec);
            this.mStartMagnificationSpec.setTo(this.mSentMagnificationSpec);
            this.mValueAnimator.start();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mEnabled == false) goto L9;
            float fract = animation.getAnimatedFraction();     // Catch: Throwable -> L7
            MagnificationSpec magnificationSpec = new MagnificationSpec();     // Catch: Throwable -> L7
            magnificationSpec.scale = this.mStartMagnificationSpec.scale + ((this.mEndMagnificationSpec.scale - this.mStartMagnificationSpec.scale) * fract);     // Catch: Throwable -> L7
            magnificationSpec.offsetX = this.mStartMagnificationSpec.offsetX + ((this.mEndMagnificationSpec.offsetX - this.mStartMagnificationSpec.offsetX) * fract);     // Catch: Throwable -> L7
            magnificationSpec.offsetY = this.mStartMagnificationSpec.offsetY + ((this.mEndMagnificationSpec.offsetY - this.mStartMagnificationSpec.offsetY) * fract);     // Catch: Throwable -> L7
            setMagnificationSpecLocked(magnificationSpec);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            sendEndCallbackMainThread(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            sendEndCallbackMainThread(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        public void startFlingAnimation(float xPixelsPerSecond, float yPixelsPerSecond, float minX, float maxX, float minY, float maxY, MagnificationAnimationCallback animationCallback) {
        }

        void cancelAnimations() {
            if (this.mValueAnimator.isRunning() == false) goto L5;
            this.mValueAnimator.cancel();
        L5:
            cancelFlingAnimation();
        }

        void cancelFlingAnimation() {
        }
    }

    public static /* synthetic */ void $r8$lambda$7n_dN5UiM5usi00tn_UsqKkiJYM(int r0, boolean r1, MagnificationInfoChangedCallback r2) {
        lambda$notifyImeWindowVisibilityChanged$2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$K3AE0MkA_GL-moLGxj_xSVHI3_s, reason: not valid java name */
    public static /* synthetic */ MagnificationThumbnail m770$r8$lambda$K3AE0MkA_GLmoLGxj_xSVHI3_s(FullScreenMagnificationController r0, ControllerContext r1) {
        return r0.lambda$new$1(r1);
    }

    public static /* synthetic */ Scroller $r8$lambda$LzH4H8xN2RuqUsumAAtmD1fOgXg(Context r0) {
        return lambda$new$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$NbPaDhBfYnK_t-HFau9nBUtkYsk, reason: not valid java name */
    public static /* synthetic */ void m771$r8$lambda$NbPaDhBfYnK_tHFau9nBUtkYsk(FullScreenMagnificationController r0) {
        r0.onMagnificationThumbnailFeatureFlagChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmControllerCtx, reason: not valid java name */
    static /* bridge */ /* synthetic */ ControllerContext m772$$Nest$fgetmControllerCtx(FullScreenMagnificationController r0) {
        return r0.mControllerCtx;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayManagerInternal m773$$Nest$fgetmDisplayManagerInternal(FullScreenMagnificationController r0) {
        return r0.mDisplayManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m774$$Nest$fgetmLock(FullScreenMagnificationController r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMagnificationConnectionStateSupplier, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m775$$Nest$fgetmMagnificationConnectionStateSupplier(FullScreenMagnificationController r0) {
        return r0.mMagnificationConnectionStateSupplier;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMagnificationInfoChangedCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m776$$Nest$fgetmMagnificationInfoChangedCallbacks(FullScreenMagnificationController r0) {
        return r0.mMagnificationInfoChangedCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMainThreadId, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m777$$Nest$fgetmMainThreadId(FullScreenMagnificationController r2) {
        return r2.mMainThreadId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScrollerSupplier, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m778$$Nest$fgetmScrollerSupplier(FullScreenMagnificationController r0) {
        return r0.mScrollerSupplier;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThumbnailSupplier, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m779$$Nest$fgetmThumbnailSupplier(FullScreenMagnificationController r0) {
        return r0.mThumbnailSupplier;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTimeAnimatorSupplier, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m780$$Nest$fgetmTimeAnimatorSupplier(FullScreenMagnificationController r0) {
        return r0.mTimeAnimatorSupplier;
    }

    /* JADX INFO: renamed from: -$$Nest$mlogTrace, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m781$$Nest$mlogTrace(FullScreenMagnificationController r0, String r1, String r2) {
        r0.logTrace(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monScreenTurnedOff, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m782$$Nest$monScreenTurnedOff(FullScreenMagnificationController r0) {
        r0.onScreenTurnedOff();
    }

    /* JADX INFO: renamed from: -$$Nest$mtraceEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m783$$Nest$mtraceEnabled(FullScreenMagnificationController r0) {
        return r0.traceEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterCallbackLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m784$$Nest$munregisterCallbackLocked(FullScreenMagnificationController r0, int r1, boolean r2) {
        r0.unregisterCallbackLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smtransformToStubCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ MagnificationAnimationCallback m785$$Nest$smtransformToStubCallback(boolean r0) {
        return transformToStubCallback(r0);
    }

    public FullScreenMagnificationController(final Context context, AccessibilityTraceManager traceManager, Object lock, MagnificationInfoChangedCallback magnificationInfoChangedCallback, MagnificationScaleProvider scaleProvider, Executor backgroundExecutor, Supplier<Boolean> magnificationConnectionStateSupplier) {
        this(new ControllerContext(context, traceManager, (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class), (InputManagerInternal) LocalServices.getService(InputManagerInternal.class), new Handler(context.getMainLooper()), context.getResources().getInteger(R.integer.config_longAnimTime)), lock, magnificationInfoChangedCallback, scaleProvider, null, backgroundExecutor, new FullScreenMagnificationController$$ExternalSyntheticLambda4(context), new FullScreenMagnificationController$$ExternalSyntheticLambda5(), magnificationConnectionStateSupplier);
    }

    private static /* synthetic */ Scroller lambda$new$0(Context context) {
        return new Scroller(context);
    }

    public FullScreenMagnificationController(final ControllerContext ctx, Object lock, MagnificationInfoChangedCallback magnificationInfoChangedCallback, MagnificationScaleProvider scaleProvider, Supplier<MagnificationThumbnail> thumbnailSupplier, Executor backgroundExecutor, Supplier<Scroller> scrollerSupplier, Supplier<TimeAnimator> timeAnimatorSupplier, Supplier<Boolean> magnificationConnectionStateSupplier) {
        this.mMagnificationInfoChangedCallbacks = new ArrayList();
        this.mDisplays = new SparseArray(0);
        this.mTempRect = new Rect();
        this.mMagnificationFollowTypingEnabled = true;
        this.mAlwaysOnMagnificationEnabled = false;
        this.mIsPointerMotionFilterInstalled = false;
        this.mControllerCtx = ctx;
        this.mLock = lock;
        this.mScrollerSupplier = scrollerSupplier;
        this.mTimeAnimatorSupplier = timeAnimatorSupplier;
        this.mMagnificationConnectionStateSupplier = magnificationConnectionStateSupplier;
        this.mMainThreadId = this.mControllerCtx.getContext().getMainLooper().getThread().getId();
        this.mScreenStateObserver = new ScreenStateObserver(this.mControllerCtx.getContext(), this);
        addInfoChangedCallback(magnificationInfoChangedCallback);
        this.mScaleProvider = scaleProvider;
        this.mDisplayManagerInternal = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
        this.mMagnificationThumbnailFeatureFlag = new MagnificationThumbnailFeatureFlag();
        this.mMagnificationThumbnailFeatureFlag.addOnChangedListener(backgroundExecutor, new FullScreenMagnificationController$$ExternalSyntheticLambda2(this));
        if (thumbnailSupplier == null) goto L5;
        this.mThumbnailSupplier = thumbnailSupplier;
        return;
    L5:
        this.mThumbnailSupplier = new FullScreenMagnificationController$$ExternalSyntheticLambda3(this, ctx);
    }

    private /* synthetic */ MagnificationThumbnail lambda$new$1(ControllerContext ctx) {
        if (this.mMagnificationThumbnailFeatureFlag.isFeatureFlagEnabled() == true) goto L5;
        return null;
    L5:
        return new MagnificationThumbnail(ctx.getContext(), (WindowManager) ctx.getContext().getSystemService(WindowManager.class), new Handler(ctx.getContext().getMainLooper()));
    }

    private void onMagnificationThumbnailFeatureFlagChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mDisplays.size()) goto L11;
        onMagnificationThumbnailFeatureFlagChanged(this.mDisplays.keyAt(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void onMagnificationThumbnailFeatureFlagChanged(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        display.onThumbnailFeatureFlagChanged();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void register(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L7
        if (display != null) goto L10;
        display = new DisplayMagnification(this, displayId);     // Catch: Throwable -> L7
    L10:
        if (display.isRegistered() == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L14:
        if (display.register() == false) goto L16;
        this.mDisplays.put(displayId, display);     // Catch: Throwable -> L7
        this.mScreenStateObserver.registerIfNecessary();     // Catch: Throwable -> L7
        configurePointerMotionFilter(true);     // Catch: Throwable -> L7
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregister(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        unregisterLocked(displayId, false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregisterAll() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<DisplayMagnification> displays = this.mDisplays.clone();     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= displays.size()) goto L11;
        unregisterLocked(displays.keyAt(i), false);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks
    public void onRectangleOnScreenRequested(int displayId, int left, int top, int right, int bottom) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mMagnificationFollowTypingEnabled == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        if (display.isActivated() == true) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        Rect magnifiedRegionBounds = this.mTempRect;     // Catch: Throwable -> L8
        display.getMagnifiedFrameInContentCoordsLocked(magnifiedRegionBounds);     // Catch: Throwable -> L8
        if (magnifiedRegionBounds.contains(left, top, right, bottom) == false) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L22:
        display.onRectangleOnScreenRequested(left, top, right, bottom);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    void setMagnificationFollowTypingEnabled(boolean enabled) {
        this.mMagnificationFollowTypingEnabled = enabled;
    }

    boolean isMagnificationFollowTypingEnabled() {
        return this.mMagnificationFollowTypingEnabled;
    }

    void setAlwaysOnMagnificationEnabled(boolean enabled) {
        this.mAlwaysOnMagnificationEnabled = enabled;
    }

    boolean isAlwaysOnMagnificationEnabled() {
        return this.mAlwaysOnMagnificationEnabled;
    }

    void onUserContextChanged(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isActivated(displayId) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (isAlwaysOnMagnificationEnabled() == true) goto L13;
        reset(displayId, true);     // Catch: Throwable -> L8
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        if (this.mControllerCtx.getContext().getResources().getBoolean(R.bool.config_multiuserDelayUserDataLocking) == true) goto L16;
        zoomOutFromService(displayId);     // Catch: Throwable -> L8
        goto L16
    }

    public void onDisplayRemoved(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        unregisterLocked(displayId, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isRegistered(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = display.isRegistered();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isActivated(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = display.isActivated();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean magnificationRegionContains(int displayId, float x, float y) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = display.magnificationRegionContains(x, y);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public void getMagnificationBounds(int displayId, Rect outBounds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        display.getMagnificationBounds(outBounds);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void getMagnificationRegion(int displayId, Region outRegion) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        display.getMagnificationRegion(outRegion);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public float getScale(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 1.0f;
    L11:
        float r2 = display.getScale();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    protected float getLastActivatedScale(int displayId) {
        return getScale(displayId);
    }

    public float getOffsetX(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0.0f;
    L11:
        float r2 = display.getOffsetX();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public float getCenterX(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0.0f;
    L11:
        float r2 = display.getCenterX();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isAtEdge(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = display.isAtEdge();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isAtLeftEdge(int displayId, float slop) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = display.isAtLeftEdge(slop);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isAtRightEdge(int displayId, float slop) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = display.isAtRightEdge(slop);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isAtTopEdge(int displayId, float slop) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = display.isAtTopEdge(slop);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isAtBottomEdge(int displayId, float slop) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = display.isAtBottomEdge(slop);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public float getOffsetY(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0.0f;
    L11:
        float r2 = display.getOffsetY();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public float getCenterY(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0.0f;
    L11:
        float r2 = display.getCenterY();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean reset(int displayId, boolean animate) {
        if (animate == false) goto L4;
        MagnificationAnimationCallback r0 = MagnificationAnimationCallback.STUB_ANIMATION_CALLBACK;
    L6:
        return reset(displayId, r0);
    L4:
        r0 = null;
        goto L6
    }

    public boolean reset(int displayId, MagnificationAnimationCallback animationCallback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = display.reset(animationCallback);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean setScale(int displayId, float scale, float pivotX, float pivotY, boolean isScaleTransient, boolean animate, int id) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r0 = display.setScale(scale, pivotX, pivotY, isScaleTransient, animate, id);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean setCenter(int displayId, float centerX, float centerY, boolean animate, int id) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L23
        if (display != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return false;
    L13:
        if (animate == false) goto L16;
        MagnificationAnimationCallback r0 = MagnificationAnimationCallback.STUB_ANIMATION_CALLBACK;     // Catch: Throwable -> L10
    L18:
        boolean r11 = display.setScaleAndCenter(Float.NaN, centerX, centerY, false, r0, id);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r11;
    L16:
        r0 = null;
    L10:
        th = th;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L21
        throw th;
    L21:
        th = th;
    L23:
        th = th;
        goto L25
    }

    public boolean setScaleAndCenter(int displayId, float scale, float centerX, float centerY, boolean animate, int id) {
        return setScaleAndCenter(displayId, scale, centerX, centerY, false, transformToStubCallback(animate), id);
    }

    public boolean setScaleAndCenter(int displayId, float scale, float centerX, float centerY, boolean isScaleTransient, boolean animate, int id) {
        return setScaleAndCenter(displayId, scale, centerX, centerY, isScaleTransient, transformToStubCallback(animate), id);
    }

    public boolean setScaleAndCenter(int displayId, float scale, float centerX, float centerY, boolean isScaleTransient, MagnificationAnimationCallback animationCallback, int id) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r0 = display.setScaleAndCenter(scale, centerX, centerY, isScaleTransient, animationCallback, id);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public void setOffset(int displayId, float offsetX, float offsetY, int id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        display.setOffset(offsetX, offsetY, id);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void offsetMagnifiedRegion(int displayId, float offsetX, float offsetY, int id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        display.offsetMagnifiedRegion(offsetX, offsetY, id);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void startFling(int displayId, float xPixelsPerSecond, float yPixelsPerSecond, int id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        display.startFling(xPixelsPerSecond, yPixelsPerSecond, id);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void cancelFling(int displayId, int id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L8
        if (display != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        display.cancelFling(id);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public int getIdOfLastServiceToMagnify(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L9
        if (display != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -1;
    L11:
        int r2 = display.getIdOfLastServiceToMagnify();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public void persistScale(int displayId) {
        float scale = getScale(displayId);
        notifyScaleForInput(displayId, scale);
        if (scale >= 1.3f) goto L5;
        return;
    L5:
        this.mScaleProvider.putScale(scale, displayId);
    }

    public float getPersistedScale(int displayId) {
        return MathUtils.constrain(this.mScaleProvider.getScale(displayId), 1.3f, MagnificationScaleProvider.MAX_SCALE);
    }

    private void zoomOutFromService(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L12
        if (display == null) goto L14;
        if (display.isActivated() == false) goto L14;
        display.zoomOutFromService();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean isZoomedOutFromService(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L12
        if (display == null) goto L14;
        if (display.isActivated() == false) goto L14;
        boolean r2 = display.isZoomedOutFromService();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public void notifyScaleForInput(int displayId, float scale) {
        this.mControllerCtx.getInputManager().setAccessibilityPointerIconScaleFactor(displayId, scale);
    }

    public void resetAllIfNeeded(int connectionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mDisplays.size()) goto L11;
        resetIfNeeded(this.mDisplays.keyAt(i), connectionId);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    boolean resetIfNeeded(int displayId, boolean animate) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L13
        if (display == null) goto L15;
        if (display.isActivated() == false) goto L15;
        display.reset(animate);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    boolean resetIfNeeded(int displayId, int connectionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DisplayMagnification display = this.mDisplays.get(displayId);     // Catch: Throwable -> L14
        if (display != null) goto L7;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L7:
        if (display.isActivated() == false) goto L16;
        if (connectionId != display.getIdOfLastServiceToMagnify()) goto L16;
        display.reset(true);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        throw th;
    }

    void notifyImeWindowVisibilityChanged(final int displayId, final boolean shown) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mMagnificationInfoChangedCallbacks.forEach(new FullScreenMagnificationController$$ExternalSyntheticLambda1(displayId, shown));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$notifyImeWindowVisibilityChanged$2(int displayId, boolean shown, MagnificationInfoChangedCallback callback) {
        callback.onImeWindowVisibilityChanged(displayId, shown);
    }

    private void onScreenTurnedOff() {
        Message m = PooledLambda.obtainMessage(new FullScreenMagnificationController$$ExternalSyntheticLambda0(), this, false);
        this.mControllerCtx.getHandler().sendMessage(m);
    }

    void resetAllIfNeeded(boolean animate) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mDisplays.size()) goto L11;
        resetIfNeeded(this.mDisplays.keyAt(i), animate);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void unregisterLocked(int displayId, boolean delete) {
        DisplayMagnification display = this.mDisplays.get(displayId);
        if (display != null) goto L6;
        return;
    L6:
        if (display.isRegistered() == true) goto L11;
        if (delete == false) goto L15;
        this.mDisplays.remove(displayId);
        return;
    L15:
        return;
    L11:
        if (display.isActivated() == true) goto L13;
        display.unregister(delete);
        return;
    L13:
        display.unregisterPending(delete);
    }

    private void unregisterCallbackLocked(int displayId, boolean delete) {
        if (delete == false) goto L4;
        this.mDisplays.remove(displayId);
    L4:
        boolean hasRegister = false;
        int i = 0;
    L6:
        if (i >= this.mDisplays.size()) goto L11;
        DisplayMagnification display = this.mDisplays.valueAt(i);
        hasRegister = display.isRegistered();
        if (hasRegister == true) goto L11;
        i = i + 1;
    L11:
        if (hasRegister == true) goto L16;
        this.mScreenStateObserver.unregister();
        configurePointerMotionFilter(false);
        return;
    }

    void addInfoChangedCallback(MagnificationInfoChangedCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mMagnificationInfoChangedCallbacks.add(callback);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeInfoChangedCallback(MagnificationInfoChangedCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mMagnificationInfoChangedCallbacks.remove(callback);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void configurePointerMotionFilter(boolean enabled) {
    }

    private boolean traceEnabled() {
        return this.mControllerCtx.getTraceManager().isA11yTracingEnabledForTypes(512);
    }

    private void logTrace(String methodName, String params) {
        this.mControllerCtx.getTraceManager().logTrace("WindowManagerInternal." + methodName, 512, params);
    }

    public String toString() {
        return "MagnificationController[, mDisplays=" + this.mDisplays + ", mScaleProvider=" + this.mScaleProvider + "]";
    }

    private static MagnificationAnimationCallback transformToStubCallback(boolean animate) {
        if (animate == true) goto L6;
        return null;
    L6:
        return MagnificationAnimationCallback.STUB_ANIMATION_CALLBACK;
    }
}

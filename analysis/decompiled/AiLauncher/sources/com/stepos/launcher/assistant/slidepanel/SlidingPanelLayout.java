package com.stepos.launcher.assistant.slidepanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.utils.XLog;
import com.stepos.launcher.client.R$dimen;
import com.stepos.launcher.client.libraries.ILauncherOverlayCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SlidingPanelLayout extends FrameLayout {
    public static boolean DEBUG = false;
    public static boolean DEBUG_OVERLAY_INDICATOR = false;
    public static boolean DEBUG_OVERLAY_SNAP = false;
    private static final float EXTERNAL_OPEN_THRESHOLD = 0.14f;
    private static final float EXTERNAL_QUICK_FLING_MIN_PROGRESS = 0.1f;
    private static final int PAGE_INDICATOR_HIDE_DELAY_MS = 600;
    private static final int PANEL_STATE_CLOSED = 0;
    private static final int PANEL_STATE_CLOSING = 1;
    private static final int PANEL_STATE_OPENED = 2;
    private static final int PANEL_STATE_OPENING = 3;
    private static final String SETTINGS_KEY_USER_SWIPED_PANEL = "stepos_overlay_page_indicator_swiped";
    private static final long SNAP_IDLE_MS = 160;
    private static final float SNAP_OPEN_THRESHOLD = 0.4f;
    private static final String TAG = "SlidingPanelLayout";
    public int animateTime;
    private boolean mAcceptExternalMove;
    public int mActivePointerId;
    private boolean mAllowOverScroll;
    public View mContentView;
    public DecelerateInterpolator mDecelerateInterpolator;
    public float mDensity;
    public float mDownX;
    public float mDownY;
    private final OverScrollEdgeEffect mEdgeEffect;
    boolean mExternalDrag;
    public int mFlingThresholdVelocity;
    public boolean mForceDrag;
    private final Runnable mHidePageIndicatorRunnable;
    public boolean mIsPageMoving;
    public boolean mIsPanelOpen;
    public final boolean mIsRtl;
    private float mLastDispatchedOverlayProgress;
    public float mLastMotionX;
    private int mLastMoveDirection;
    private boolean mLastNotifiedAllTasksEntryVisible;
    public int mMaximumVelocity;
    public int mMinFlingVelocity;
    public int mMinSnapVelocity;
    public int mMinimumFlingVelocity;
    private boolean mMinusOneFullyEngaged;
    private float mNextFlingVelocity;
    private final Runnable mNotifyPanelClosedRunnable;
    private OverlayPillPageIndicatorView mPageIndicator;
    private int mPageIndicatorBottomMarginPx;
    private boolean mPageIndicatorDismissed;
    private boolean mPanelClosedNotificationPending;
    private boolean mPanelDragEnable;
    public float mPanelPositionRatio;
    private int mPanelState;
    public int mPanelX;
    private float mPanelXFloat;
    private boolean mPanelXFloatValid;
    private ILauncherOverlayCallback mProxyCallbacks;
    private boolean mRoutingTouchToPageIndicator;
    public boolean mSettling;
    private final List<WeakReference<SlidingPanelDragListener>> mSlidingPanelDragListeners;
    public SlidingPanelLayoutInterpolator mSlidingPanelLayoutInterpolator;
    private final Runnable mSnapToTerminalIfIdle;
    public float mStartTouchPanelX;
    private final float[] mTmpFloat;
    public float mTotalMotionX;
    public int mTouchSlop;
    private int mTouchState;
    private boolean mUserSwipedPanel;
    public VelocityTracker mVelocityTracker;
    public float minMoveDis;
    public int minVelocity;
    public float startScrollX;
    public static final SlidingPanelLayoutProperty PANEL_X = new SlidingPanelLayoutProperty(Integer.class, "panelX");
    public static boolean enableAlpha = false;
    public static boolean hardware = false;

    public SlidingPanelLayout(Context context) {
        super(context);
        this.mLastDispatchedOverlayProgress = Float.NaN;
        this.mActivePointerId = -1;
        this.mTouchState = 0;
        this.mIsPanelOpen = false;
        this.mIsPageMoving = false;
        this.animateTime = ConstConfig.getMinusAnimateTime();
        this.minMoveDis = 15.0f;
        this.minVelocity = -10000;
        this.mDecelerateInterpolator = new DecelerateInterpolator(3.0f);
        this.mSlidingPanelLayoutInterpolator = new SlidingPanelLayoutInterpolator(this);
        this.mIsRtl = isRtl(getResources());
        this.mSlidingPanelDragListeners = new ArrayList();
        this.mPanelDragEnable = true;
        this.mLastMoveDirection = 0;
        this.mTmpFloat = new float[1];
        this.mPanelState = 0;
        this.mNextFlingVelocity = Float.NaN;
        this.mHidePageIndicatorRunnable = new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f30164a.lambda$new$0();
            }
        };
        this.mNotifyPanelClosedRunnable = new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f30165a.notifyPanelClosed();
            }
        };
        this.mSnapToTerminalIfIdle = new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f30166a.snapToTerminalIfIdle();
            }
        };
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mDensity = getResources().getDisplayMetrics().density;
        this.mFlingThresholdVelocity = getResources().getDimensionPixelSize(R$dimen.fling_threshold_velocity);
        this.mMinFlingVelocity = getResources().getDimensionPixelSize(R$dimen.min_fling_velocity);
        this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMinSnapVelocity = getResources().getDimensionPixelSize(R$dimen.min_page_snap_velocity);
        this.mPageIndicatorBottomMarginPx = 0;
        this.mEdgeEffect = new OverScrollEdgeEffect(context);
        this.mUserSwipedPanel = readUserSwipedPanel();
        Log.d(TAG, "onNewInstance: " + this + " userSwipedPanel=" + this.mUserSwipedPanel);
    }

    private void acquireVelocityTrackerAndAddMovement(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.mVelocityTracker = velocityTrackerObtain;
            velocityTrackerObtain.clear();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void applyPanelX(float f10, boolean z10) {
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth <= 0) {
            return;
        }
        if (Float.isNaN(f10)) {
            f10 = 0.0f;
        }
        if (!this.mAllowOverScroll) {
            f10 = Math.max(0.0f, Math.min(f10, measuredWidth));
        }
        if (!this.mPanelXFloatValid || Math.abs(f10 - this.mPanelXFloat) >= 0.01f) {
            this.mPanelXFloat = f10;
            this.mPanelXFloatValid = true;
            float f11 = f10 / measuredWidth;
            this.mPanelPositionRatio = f11;
            if (Float.isNaN(f11)) {
                this.mPanelPositionRatio = 0.0f;
            }
            this.mPanelX = Math.round(f10);
            View view = this.mContentView;
            if (view == null) {
                if (z10 && !this.mExternalDrag) {
                    overlayScrollChanged(this.mPanelPositionRatio);
                    return;
                }
                Log.i(TAG, "skip overlayScrollChanged: contentView null notify=" + z10 + " externalDrag=" + this.mExternalDrag + " progress=" + this.mPanelPositionRatio);
                return;
            }
            if (this.mIsRtl) {
                f10 = -f10;
            }
            view.setTranslationX(f10);
            updateContentAlphaForProgress();
            updatePageIndicatorOnScroll();
            if (z10 && !this.mExternalDrag) {
                overlayScrollChanged(this.mPanelPositionRatio);
            } else if (z10) {
                Log.i(TAG, "skip overlayScrollChanged: externalDrag progress=" + this.mPanelPositionRatio);
            }
        }
    }

    private void cancelPageIndicatorHide() {
        removeCallbacks(this.mHidePageIndicatorRunnable);
    }

    private void dispatchTerminalProgressIfStale(float f10, float f11) {
        if (Float.isNaN(this.mLastDispatchedOverlayProgress) || Math.abs(this.mLastDispatchedOverlayProgress - f10) > f11) {
            overlayScrollChanged(f10);
        }
    }

    private boolean dispatchTouchEventToPageIndicator(MotionEvent motionEvent) {
        if (!isPageIndicatorVisibleForTouch()) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(-this.mPageIndicator.getLeft(), -this.mPageIndicator.getTop());
        boolean zDispatchTouchEvent = this.mPageIndicator.dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zDispatchTouchEvent;
    }

    private void ensurePageIndicator() {
        if (enableAlpha || this.mPageIndicator != null) {
            return;
        }
        this.mPageIndicator = new OverlayPillPageIndicatorView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = this.mPageIndicatorBottomMarginPx;
        this.mPageIndicator.setVisibility(8);
        this.mPageIndicator.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.launcher.assistant.slidepanel.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f30167a.lambda$ensurePageIndicator$1(view);
            }
        });
        super.addView(this.mPageIndicator);
        if (DEBUG_OVERLAY_INDICATOR) {
            Log.d(TAG, "ensurePageIndicator created bottomMargin=" + this.mPageIndicatorBottomMarginPx);
        }
    }

    private IOverlayAllTasksEntryListener findAllTasksEntryListener() {
        KeyEvent.Callback callback = this.mContentView;
        if (callback instanceof IOverlayAllTasksEntryListener) {
            return (IOverlayAllTasksEntryListener) callback;
        }
        return null;
    }

    private void flushPanelClosedNotification() {
        if (this.mPanelClosedNotificationPending) {
            removeCallbacks(this.mNotifyPanelClosedRunnable);
            notifyPanelClosed();
        }
    }

    private float getUndampedOverScrollShift() {
        float f10;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.mEdgeEffect.isFinished()) {
            f10 = 0.0f;
        } else {
            this.mEdgeEffect.setSize(measuredWidth, measuredHeight);
            this.mEdgeEffect.getTranslationShift(this.mTmpFloat);
            f10 = this.mTmpFloat[0];
            postInvalidateOnAnimation();
        }
        return f10 * measuredWidth;
    }

    private boolean isPageIndicatorVisibleForTouch() {
        OverlayPillPageIndicatorView overlayPillPageIndicatorView;
        return (enableAlpha || (overlayPillPageIndicatorView = this.mPageIndicator) == null || overlayPillPageIndicatorView.getVisibility() != 0) ? false : true;
    }

    private boolean isPanelFullyOpen() {
        return this.mIsPanelOpen && this.mPanelPositionRatio >= 0.999f;
    }

    public static boolean isRtl(Resources resources) {
        return resources.getConfiguration().getLayoutDirection() == 1;
    }

    private boolean isTouchInPageIndicator(MotionEvent motionEvent) {
        if (!isPageIndicatorVisibleForTouch()) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        return x10 >= ((float) this.mPageIndicator.getLeft()) && x10 < ((float) this.mPageIndicator.getRight()) && y10 >= ((float) this.mPageIndicator.getTop()) && y10 < ((float) this.mPageIndicator.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensurePageIndicator$1(View view) {
        onOverlayPageIndicatorClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        if (isPanelFullyOpen() && !this.mIsPageMoving && this.mUserSwipedPanel) {
            this.mPageIndicatorDismissed = true;
            updatePageIndicatorVisibility();
        }
    }

    private void layoutPageIndicator() {
        OverlayPillPageIndicatorView overlayPillPageIndicatorView;
        if (enableAlpha || (overlayPillPageIndicatorView = this.mPageIndicator) == null || overlayPillPageIndicatorView.getVisibility() == 8) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPageIndicator.getLayoutParams();
        int measuredWidth = this.mPageIndicator.getMeasuredWidth();
        int measuredHeight = this.mPageIndicator.getMeasuredHeight();
        int i10 = layoutParams != null ? layoutParams.bottomMargin : this.mPageIndicatorBottomMarginPx;
        int width = (getWidth() - measuredWidth) / 2;
        int height = getHeight() - i10;
        int i11 = height - measuredHeight;
        int i12 = width + measuredWidth;
        this.mPageIndicator.layout(width, i11, i12, height);
        if (DEBUG_OVERLAY_INDICATOR) {
            Log.d(TAG, "onLayout indicator bounds=[" + width + Const.STR_MART_COMMA + i11 + Const.STR_MART_COMMA + i12 + Const.STR_MART_COMMA + height + "] size=" + measuredWidth + "x" + measuredHeight);
        }
    }

    private boolean moveToLauncherDirection() {
        if (this.mIsRtl) {
            boolean z10 = this.mIsPanelOpen;
            if (z10 && this.mPanelState != 1) {
                return this.mLastMoveDirection > 0;
            }
            if (!z10 && this.mPanelState == 3) {
                return this.mLastMoveDirection > 0;
            }
        }
        return this.mLastMoveDirection < 0;
    }

    private void notifyAllTasksEntryVisibilityIfChanged() {
        boolean zShouldShowAllTasksEntry;
        if (enableAlpha || (zShouldShowAllTasksEntry = shouldShowAllTasksEntry()) == this.mLastNotifiedAllTasksEntryVisible) {
            return;
        }
        this.mLastNotifiedAllTasksEntryVisible = zShouldShowAllTasksEntry;
        IOverlayAllTasksEntryListener iOverlayAllTasksEntryListenerFindAllTasksEntryListener = findAllTasksEntryListener();
        if (iOverlayAllTasksEntryListenerFindAllTasksEntryListener == null) {
            if (DEBUG_OVERLAY_INDICATOR) {
                Log.d(TAG, "notifyAllTasksEntry skipped: listener null visible=" + zShouldShowAllTasksEntry);
                return;
            }
            return;
        }
        if (DEBUG_OVERLAY_INDICATOR) {
            Log.d(TAG, "notifyAllTasksEntry visible=" + zShouldShowAllTasksEntry);
        }
        iOverlayAllTasksEntryListenerFindAllTasksEntryListener.onAllTasksEntryVisibilityChanged(zShouldShowAllTasksEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPanelClosed() {
        if (this.mPanelClosedNotificationPending) {
            this.mPanelClosedNotificationPending = false;
            Iterator<WeakReference<SlidingPanelDragListener>> it = this.mSlidingPanelDragListeners.iterator();
            while (it.hasNext()) {
                SlidingPanelDragListener slidingPanelDragListener = it.next().get();
                if (slidingPanelDragListener != null) {
                    slidingPanelDragListener.close();
                }
            }
            overlayStatusChanged(1);
        }
    }

    private void onClosePanel() {
        this.mIsPageMoving = true;
        this.mPanelState = 1;
        Iterator<WeakReference<SlidingPanelDragListener>> it = this.mSlidingPanelDragListeners.iterator();
        while (it.hasNext()) {
            SlidingPanelDragListener slidingPanelDragListener = it.next().get();
            if (slidingPanelDragListener != null) {
                slidingPanelDragListener.closing(this.mTouchState == 1);
            }
        }
        this.mSettling = true;
        revealPageIndicator();
        updatePageIndicatorVisibility();
    }

    private void onOverlayPageIndicatorClicked() {
        if (enableAlpha || this.mPageIndicator == null) {
            return;
        }
        IOverlayAllTasksEntryListener iOverlayAllTasksEntryListenerFindAllTasksEntryListener = findAllTasksEntryListener();
        if (iOverlayAllTasksEntryListenerFindAllTasksEntryListener != null) {
            iOverlayAllTasksEntryListenerFindAllTasksEntryListener.onOverlayPageIndicatorClicked(this.mPageIndicator);
        } else {
            OverlayAllTasksBroadcastHelper.openAllSessions(getContext(), this.mPageIndicator);
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() >> 8) & 255;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i10 = action == 0 ? 1 : 0;
            float x10 = motionEvent.getX(i10);
            this.startScrollX += x10 - this.mLastMotionX;
            this.mDownX = x10;
            this.mLastMotionX = x10;
            this.mActivePointerId = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void persistUserSwipedPanel() {
        try {
            Settings.Global.putInt(getContext().getContentResolver(), SETTINGS_KEY_USER_SWIPED_PANEL, 1);
        } catch (RuntimeException e10) {
            Log.w(TAG, "persist userSwipedPanel failed", e10);
        }
    }

    private boolean readUserSwipedPanel() {
        try {
            return Settings.Global.getInt(getContext().getContentResolver(), SETTINGS_KEY_USER_SWIPED_PANEL, 0) == 1;
        } catch (RuntimeException e10) {
            Log.w(TAG, "read userSwipedPanel failed", e10);
            return false;
        }
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void resetTouchState() {
        releaseVelocityTracker();
        this.mForceDrag = false;
        this.mExternalDrag = false;
        this.mTouchState = 0;
        this.mActivePointerId = -1;
        this.mNextFlingVelocity = Float.NaN;
    }

    private boolean resolveFlingOpenPanel(int i10, boolean z10, float f10) {
        if (z10 && this.mIsPanelOpen) {
            return true;
        }
        if (z10) {
            return false;
        }
        boolean z11 = this.mExternalDrag;
        if (!z11 || this.mIsPanelOpen) {
            return this.mLastMoveDirection == 0 ? z11 ? f10 >= EXTERNAL_OPEN_THRESHOLD : i10 > 0 : !moveToLauncherDirection();
        }
        if (f10 >= EXTERNAL_OPEN_THRESHOLD || this.mPanelPositionRatio >= EXTERNAL_OPEN_THRESHOLD) {
            return true;
        }
        return Math.abs(i10) >= this.mMinimumFlingVelocity && Math.max(f10, this.mPanelPositionRatio) > 0.05f;
    }

    private void revealPageIndicator() {
        cancelPageIndicatorHide();
        boolean z10 = this.mPageIndicatorDismissed;
        this.mPageIndicatorDismissed = false;
        if (z10 || this.mLastNotifiedAllTasksEntryVisible) {
            updatePageIndicatorVisibility();
        }
    }

    private boolean routePageIndicatorTouch(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mRoutingTouchToPageIndicator = this.mTouchState == 0 && isPageIndicatorVisibleForTouch() && isTouchInPageIndicator(motionEvent);
        }
        if (!this.mRoutingTouchToPageIndicator) {
            return false;
        }
        boolean zDispatchTouchEventToPageIndicator = dispatchTouchEventToPageIndicator(motionEvent);
        if (actionMasked != 1 && actionMasked != 3 && zDispatchTouchEventToPageIndicator) {
            return zDispatchTouchEventToPageIndicator;
        }
        this.mRoutingTouchToPageIndicator = false;
        return zDispatchTouchEventToPageIndicator;
    }

    private void schedulePageIndicatorHide() {
        cancelPageIndicatorHide();
        if (enableAlpha || this.mPageIndicator == null || !this.mUserSwipedPanel) {
            return;
        }
        postDelayed(this.mHidePageIndicatorRunnable, 600L);
    }

    private boolean shouldOpenPanelOnRelease(float f10, float f11) {
        if (f10 >= 0.4f || this.mPanelPositionRatio >= 0.4f) {
            return true;
        }
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth <= 0) {
            return false;
        }
        if (this.mExternalDrag && !this.mIsPanelOpen && (f10 >= EXTERNAL_OPEN_THRESHOLD || this.mPanelPositionRatio >= EXTERNAL_OPEN_THRESHOLD || f11 > measuredWidth * EXTERNAL_OPEN_THRESHOLD)) {
            return true;
        }
        if (this.mIsRtl) {
            f11 = -f11;
        }
        return f11 > ((float) measuredWidth) * 0.4f && !moveToLauncherDirection();
    }

    private boolean shouldShowAllTasksEntry() {
        return isPanelFullyOpen() && this.mPageIndicatorDismissed;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0105 A[PHI: r3
      0x0105: PHI (r3v3 boolean) = (r3v0 boolean), (r3v4 boolean) binds: [B:49:0x00db, B:58:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void snapPanelOnRelease(int r10, float r11, boolean r12, float r13) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.launcher.assistant.slidepanel.SlidingPanelLayout.snapPanelOnRelease(int, float, boolean, float):void");
    }

    private void springSettle(boolean z10, int i10, boolean z11) {
        if (!z11 && this.mIsRtl) {
            i10 = -i10;
        }
        if (!z10) {
            closePanel(i10 < 0 ? i10 : 0.0f);
            return;
        }
        clearExternalDragState(true);
        openPanel(Math.abs(i10));
        scheduleSnapToTerminalIfIdle();
    }

    private void updateContentAlphaForProgress() {
        View view = this.mContentView;
        if (view == null || view.getAlpha() == 1.0f) {
            return;
        }
        this.mContentView.setAlpha(1.0f);
    }

    private void updatePageIndicatorOnScroll() {
        if (enableAlpha || this.mPageIndicator == null) {
            return;
        }
        if (this.mPanelPositionRatio <= 0.001f) {
            this.mMinusOneFullyEngaged = false;
        }
        if (this.mIsPageMoving) {
            revealPageIndicator();
        } else if (!isPanelFullyOpen() && (!this.mMinusOneFullyEngaged || this.mPanelPositionRatio < 0.98f)) {
            if (this.mPanelPositionRatio < 0.98f) {
                this.mMinusOneFullyEngaged = false;
            }
            revealPageIndicator();
        }
        updatePageIndicatorVisibility();
    }

    private void updatePageIndicatorVisibility() {
        if (enableAlpha || this.mPageIndicator == null) {
            return;
        }
        boolean z10 = OverlayIndicatorState.isOverlayPillHandoffOwner(this.mPanelPositionRatio) && (this.mPanelPositionRatio > 0.0f || this.mIsPanelOpen) && !this.mPageIndicatorDismissed;
        this.mPageIndicator.setOverlayProgress(this.mPanelPositionRatio);
        this.mPageIndicator.setVisibility(z10 ? 0 : 8);
        if (z10 && this.mContentView != null) {
            View childAt = getChildAt(getChildCount() - 1);
            View view = this.mContentView;
            if (childAt != view) {
                bringChildToFront(view);
            }
        }
        if (DEBUG_OVERLAY_INDICATOR) {
            Log.d(TAG, "updatePageIndicatorVisibility show=" + z10 + " progress=" + this.mPanelPositionRatio + " panelOpen=" + this.mIsPanelOpen + " panelState=" + this.mPanelState);
        }
        notifyAllTasksEntryVisibilityIfChanged();
    }

    private void updateScrollOnTouchDown() {
        int i10 = this.mPanelX;
        boolean z10 = i10 > getMeasuredWidth();
        boolean z11 = i10 < 0;
        if ((z10 || z11) && this.mEdgeEffect.isFinished()) {
            this.mEdgeEffect.onPullToDistance((i10 - getMeasuredWidth()) / getMeasuredWidth(), 0.0f);
            setPanelX(getMeasuredWidth());
            invalidate();
        }
    }

    public final void addContentView(View view) {
        this.mContentView = view;
        super.addView(view);
        ensurePageIndicator();
    }

    public void addSlidingPanelDragListener(SlidingPanelDragListener slidingPanelDragListener) {
        this.mSlidingPanelDragListeners.add(new WeakReference<>(slidingPanelDragListener));
    }

    public void applyExternalScrollProgress(float f10) {
        int i10;
        float fMax = Math.max(0.0f, Math.min(1.0f, f10));
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth <= 0) {
            return;
        }
        int i11 = (int) (fMax * measuredWidth);
        if (this.mExternalDrag && i11 != (i10 = this.mPanelX)) {
            this.mLastMoveDirection = i11 - i10;
            this.mTotalMotionX += Math.abs(r0);
            this.mLastMotionX = i11;
        }
        setPanelX(i11);
    }

    public void applyPageIndicatorProgress(float f10) {
        if (enableAlpha || this.mPageIndicator == null) {
            return;
        }
        ensurePageIndicator();
        OverlayPillPageIndicatorView overlayPillPageIndicatorView = this.mPageIndicator;
        if (overlayPillPageIndicatorView == null) {
            return;
        }
        overlayPillPageIndicatorView.setOverlayProgress(f10);
        updatePageIndicatorVisibility();
    }

    public void applyPageIndicatorState(Bundle bundle) {
        boolean z10;
        int i10;
        if (enableAlpha || bundle == null) {
            if (DEBUG_OVERLAY_INDICATOR) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("applyPageIndicatorState skip: enableAlpha=");
                sb2.append(enableAlpha);
                sb2.append(" stateNull=");
                sb2.append(bundle == null);
                Log.d(TAG, sb2.toString());
                return;
            }
            return;
        }
        ensurePageIndicator();
        if (this.mPageIndicator == null) {
            if (DEBUG_OVERLAY_INDICATOR) {
                Log.w(TAG, "applyPageIndicatorState: indicator view is null");
                return;
            }
            return;
        }
        if (!bundle.containsKey(OverlayIndicatorState.KEY_PAGE_COUNT)) {
            if (bundle.containsKey(OverlayIndicatorState.KEY_OVERLAY_PROGRESS)) {
                applyPageIndicatorProgress(bundle.getFloat(OverlayIndicatorState.KEY_OVERLAY_PROGRESS));
                return;
            }
            return;
        }
        if (!bundle.containsKey(OverlayIndicatorState.KEY_BOTTOM_MARGIN) || (i10 = bundle.getInt(OverlayIndicatorState.KEY_BOTTOM_MARGIN)) == this.mPageIndicatorBottomMarginPx) {
            z10 = false;
        } else {
            this.mPageIndicatorBottomMarginPx = i10;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPageIndicator.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.bottomMargin = this.mPageIndicatorBottomMarginPx;
                this.mPageIndicator.setLayoutParams(layoutParams);
            }
            z10 = true;
        }
        int activePage = this.mPageIndicator.getActivePage();
        boolean zApplyState = z10 | this.mPageIndicator.applyState(bundle, true);
        if (bundle.containsKey(OverlayIndicatorState.KEY_ACTIVE_PAGE) && this.mPageIndicator.getActivePage() != activePage && isPanelFullyOpen()) {
            revealPageIndicator();
            schedulePageIndicatorHide();
        }
        updatePageIndicatorVisibility();
        if (DEBUG_OVERLAY_INDICATOR) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("applyPageIndicatorState pageCount=");
            sb3.append(bundle.getInt(OverlayIndicatorState.KEY_PAGE_COUNT, -1));
            sb3.append(" activePage=");
            sb3.append(bundle.getInt(OverlayIndicatorState.KEY_ACTIVE_PAGE, -1));
            sb3.append(" progress=");
            sb3.append(bundle.getFloat(OverlayIndicatorState.KEY_OVERLAY_PROGRESS, -1.0f));
            sb3.append(" bottomMargin=");
            sb3.append(this.mPageIndicatorBottomMarginPx);
            sb3.append(" visible=");
            sb3.append(this.mPageIndicator.getVisibility() == 0);
            Log.d(TAG, sb3.toString());
        }
        if (zApplyState) {
            requestLayout();
        }
    }

    public void assignPanelX(int i10) {
        this.mPanelX = i10;
        this.mPanelXFloat = i10;
        this.mPanelXFloatValid = true;
    }

    public void clearExternalDragState(boolean z10) {
        String str = TAG;
        if (!z10 && isLocalDragInProgress()) {
            if (DEBUG || DEBUG_OVERLAY_SNAP) {
                if (DEBUG_OVERLAY_SNAP) {
                    str = "OverlaySnapDbg";
                }
                Log.i(str, "clearExternalDragState skip, local drag in progress");
            }
            this.mForceDrag = false;
            this.mExternalDrag = false;
            setAcceptExternalMove(false);
            return;
        }
        if (DEBUG || DEBUG_OVERLAY_SNAP || this.mExternalDrag || this.mForceDrag || this.mAcceptExternalMove || this.mTouchState != 0) {
            if (DEBUG_OVERLAY_SNAP) {
                str = "OverlaySnapDbg";
            }
            Log.i(str, "clearExternalDragState externalDrag=" + this.mExternalDrag + " forceDrag=" + this.mForceDrag + " acceptExternal=" + this.mAcceptExternalMove + " touchState=" + this.mTouchState + " interruptLocal=" + z10);
        }
        setAcceptExternalMove(false);
        resetTouchState();
    }

    public final void closePanel(int i10) {
        onClosePanel();
        this.mSlidingPanelLayoutInterpolator.animatorToX(0, i10);
        Log.d(TAG, "closePanel, time = " + i10);
    }

    public void determineScrollingStart(MotionEvent motionEvent, float f10) {
        int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        if (iFindPointerIndex != -1) {
            float x10 = motionEvent.getX(iFindPointerIndex);
            if (((int) Math.abs(x10 - this.mDownX)) > Math.round(this.mTouchSlop * f10)) {
                if (this.mExternalDrag) {
                    this.mTotalMotionX += Math.abs(this.mLastMotionX - x10);
                    this.mLastMoveDirection = (int) (x10 - this.mLastMotionX);
                    this.mLastMotionX = x10;
                } else {
                    this.mTotalMotionX += Math.abs(this.mLastMotionX - x10);
                    this.startScrollX = x10;
                    this.mLastMoveDirection = (int) (x10 - this.mLastMotionX);
                    this.mLastMotionX = x10;
                    this.mExternalDrag = false;
                    startDrag();
                }
            }
        }
    }

    public final void disableHardwareIfNeed() {
        if (hardware) {
            setLayerType(0, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (enableAlpha) {
            super.dispatchDraw(canvas);
            return;
        }
        if (this.mEdgeEffect.isFinished()) {
            super.dispatchDraw(canvas);
            return;
        }
        long drawingTime = getDrawingTime();
        int childCount = getChildCount();
        float undampedOverScrollShift = getUndampedOverScrollShift();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt == this.mPageIndicator) {
                drawChild(canvas, childAt, drawingTime);
            } else {
                int iSave = canvas.save();
                canvas.translate(undampedOverScrollShift, 0.0f);
                drawChild(canvas, childAt, drawingTime);
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (enableAlpha || motionEvent == null || !routePageIndicatorTouch(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void finishExternalScroll(float f10) {
        if ((this.mExternalDrag || this.mAcceptExternalMove) && this.mTouchState == 1) {
            float fMax = Math.max(0.0f, Math.min(1.0f, f10));
            applyExternalScrollProgress(fMax);
            snapPanelOnRelease(0, fMax, false, Math.max(getMeasuredWidth(), 1) * fMax);
        } else if (DEBUG_OVERLAY_SNAP) {
            Log.d("OverlaySnapDbg", "finishExternalScroll skipped externalDrag=" + this.mExternalDrag + " acceptExternal=" + this.mAcceptExternalMove + " touchState=" + this.mTouchState + " progress=" + f10);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public float getPanelXFloat() {
        return this.mPanelXFloatValid ? this.mPanelXFloat : this.mPanelX;
    }

    public List<WeakReference<SlidingPanelDragListener>> getSlidingPanelDragListeners() {
        return this.mSlidingPanelDragListeners;
    }

    public boolean isAcceptExternalMove() {
        return this.mAcceptExternalMove;
    }

    public boolean isLocalDragInProgress() {
        return this.mTouchState == 1 && !this.mExternalDrag;
    }

    public boolean isPanelDragEnable() {
        return this.mPanelDragEnable;
    }

    public boolean isSettlingClosed() {
        return this.mSettling && !this.mSlidingPanelLayoutInterpolator.isFinished() && this.mSlidingPanelLayoutInterpolator.mFinalX == 0;
    }

    public boolean isSettlingOpen() {
        return this.mSettling && !this.mSlidingPanelLayoutInterpolator.isFinished() && this.mSlidingPanelLayoutInterpolator.mFinalX > 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        flushPanelClosedNotification();
        removeCallbacks(this.mSnapToTerminalIfIdle);
        super.onDetachedFromWindow();
        this.mSlidingPanelLayoutInterpolator.cancelAll();
        Log.d(TAG, "onDetachedFromWindow");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() <= 0 || !this.mPanelDragEnable) {
            if (enableAlpha && this.mIsPanelOpen) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.mExternalDrag && !this.mForceDrag) {
            if (DEBUG_OVERLAY_SNAP) {
                Log.d("OverlaySnapDbg", "onInterceptTouchEvent skip real touch externalDrag=" + this.mExternalDrag + " action=" + motionEvent.getActionMasked());
            }
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "onInterceptTouchEvent");
        }
        acquireVelocityTrackerAndAddMovement(motionEvent);
        if (motionEvent.getAction() == 2 && this.mTouchState == 1) {
            if (DEBUG) {
                Log.d(TAG, "action = move & touchState = 1");
            }
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if (DEBUG) {
                Log.d(TAG, "Intercept touch down: " + String.valueOf(motionEvent));
            }
            this.mDownX = x10;
            this.mDownY = y10;
            this.mStartTouchPanelX = this.mPanelX;
            this.mLastMotionX = x10;
            this.mTotalMotionX = 0.0f;
            this.mLastMoveDirection = 0;
            this.mActivePointerId = motionEvent.getPointerId(0);
            if ((Math.abs(this.mSlidingPanelLayoutInterpolator.mFinalX - this.mPanelX) >= this.mTouchSlop / 3 && !this.mSettling) || this.mForceDrag) {
                this.mExternalDrag = this.mForceDrag;
                this.mForceDrag = false;
                startDrag();
                this.startScrollX = x10;
            }
            if (DEBUG) {
                Log.d(TAG, "onInterceptTouchEvent ACTION_DOWN");
            }
        } else if (action == 2) {
            if (this.mActivePointerId != -1) {
                determineScrollingStart(motionEvent, 1.0f);
            }
            if (DEBUG) {
                Log.d(TAG, "onInterceptTouchEvent ACTION_MOVE");
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
            releaseVelocityTracker();
            resetTouchState();
            if (DEBUG) {
                Log.d(TAG, "onInterceptTouchEvent ACTION_POINTER_UP");
            }
        }
        if (DEBUG) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onInterceptTouchEvent return:");
            sb2.append(this.mTouchState != 0);
            Log.d(TAG, sb2.toString());
        }
        return this.mTouchState != 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View view = this.mContentView;
        if (view != null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = this.mContentView.getMeasuredHeight();
            if (enableAlpha) {
                this.mContentView.layout(0, 0, measuredWidth, measuredHeight);
                boolean z11 = this.mIsPanelOpen;
                if (z11 || this.mIsPageMoving) {
                    Log.d(TAG, String.format("onLayout: panel state - isOpen=%s, isMoving=%s, alpha=%.2f", Boolean.valueOf(z11), Boolean.valueOf(this.mIsPageMoving), Float.valueOf(this.mContentView.getAlpha())));
                } else {
                    this.mContentView.setAlpha(0.0f);
                }
            } else {
                View view2 = this.mContentView;
                boolean z12 = this.mIsRtl;
                view2.layout(z12 ? measuredWidth : -measuredWidth, 0, z12 ? measuredWidth * 2 : 0, measuredHeight);
                updateContentAlphaForProgress();
            }
        }
        layoutPageIndicator();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        OverlayPillPageIndicatorView overlayPillPageIndicatorView;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        View view = this.mContentView;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
        if (!enableAlpha && (overlayPillPageIndicatorView = this.mPageIndicator) != null && overlayPillPageIndicatorView.getVisibility() != 8) {
            this.mPageIndicator.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        }
        setMeasuredDimension(size, size2);
        if (enableAlpha) {
            return;
        }
        applyPanelX(size * this.mPanelPositionRatio, false);
    }

    public void onOneshotFlingVelocity(float f10) {
        this.mNextFlingVelocity = f10;
    }

    public final void onPanelClosed() {
        overlayScrollChanged(0.0f);
        disableHardwareIfNeed();
        cancelPageIndicatorHide();
        this.mMinusOneFullyEngaged = false;
        this.mPageIndicatorDismissed = false;
        this.mIsPanelOpen = false;
        this.mIsPageMoving = false;
        this.mPanelState = 0;
        clearExternalDragState();
        this.mPanelClosedNotificationPending = true;
        removeCallbacks(this.mNotifyPanelClosedRunnable);
        if (isAttachedToWindow()) {
            postOnAnimation(this.mNotifyPanelClosedRunnable);
        } else {
            notifyPanelClosed();
        }
        updatePageIndicatorVisibility();
    }

    public final void onPanelOpened() {
        overlayScrollChanged(1.0f);
        disableHardwareIfNeed();
        this.mIsPanelOpen = true;
        this.mIsPageMoving = false;
        this.mPanelState = 2;
        Iterator<WeakReference<SlidingPanelDragListener>> it = this.mSlidingPanelDragListeners.iterator();
        while (it.hasNext()) {
            SlidingPanelDragListener slidingPanelDragListener = it.next().get();
            if (slidingPanelDragListener != null) {
                slidingPanelDragListener.open();
            }
        }
        overlayStatusChanged(3);
        this.mMinusOneFullyEngaged = true;
        this.mPageIndicatorDismissed = false;
        clearExternalDragState();
        updatePageIndicatorVisibility();
        schedulePageIndicatorHide();
    }

    public final void onPanelOpening() {
        flushPanelClosedNotification();
        this.mIsPageMoving = true;
        revealPageIndicator();
        this.mPanelState = 3;
        Iterator<WeakReference<SlidingPanelDragListener>> it = this.mSlidingPanelDragListeners.iterator();
        while (it.hasNext()) {
            SlidingPanelDragListener slidingPanelDragListener = it.next().get();
            if (slidingPanelDragListener != null) {
                slidingPanelDragListener.dragTouchable();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00ef  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.launcher.assistant.slidepanel.SlidingPanelLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void openPanel(int i10) {
        clearExternalDragState(true);
        onPanelOpening();
        this.mSettling = true;
        this.mSlidingPanelLayoutInterpolator.animatorToX(getMeasuredWidth(), i10);
        scheduleSnapToTerminalIfIdle();
        Log.d(TAG, "openPanel, time = " + i10);
    }

    public void overlayScrollChanged(float f10) {
        if (this.mProxyCallbacks == null) {
            Log.i(TAG, "skip overlayScrollChanged: callback null progress=" + f10);
            return;
        }
        if (Float.isNaN(f10)) {
            return;
        }
        try {
            this.mProxyCallbacks.overlayScrollChanged(f10);
            this.mLastDispatchedOverlayProgress = f10;
        } catch (RemoteException e10) {
            Log.e(TAG, "exception= " + e10.getMessage());
        }
    }

    public void overlayStatusChanged(int i10) {
        ILauncherOverlayCallback iLauncherOverlayCallback = this.mProxyCallbacks;
        if (iLauncherOverlayCallback == null) {
            return;
        }
        try {
            iLauncherOverlayCallback.overlayStateChanged(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public void removeSlidingPanelDragListener(SlidingPanelDragListener slidingPanelDragListener) {
        Iterator<WeakReference<SlidingPanelDragListener>> it = this.mSlidingPanelDragListeners.iterator();
        while (it.hasNext()) {
            WeakReference<SlidingPanelDragListener> next = it.next();
            if (next.get() != null && next.get() == slidingPanelDragListener) {
                it.remove();
            }
        }
    }

    public void scheduleSnapToTerminalIfIdle() {
        if (isAttachedToWindow()) {
            removeCallbacks(this.mSnapToTerminalIfIdle);
            postDelayed(this.mSnapToTerminalIfIdle, SNAP_IDLE_MS);
        }
    }

    public void setAcceptExternalMove(boolean z10) {
        this.mAcceptExternalMove = z10;
    }

    public void setAllowOverScroll(boolean z10) {
        this.mAllowOverScroll = z10;
    }

    public void setCallback(ILauncherOverlayCallback iLauncherOverlayCallback) {
        Log.d(XLog.getTag(), "SlidingPanelLayout= " + this + ", callback=" + iLauncherOverlayCallback, new Throwable());
        this.mProxyCallbacks = iLauncherOverlayCallback;
    }

    public void setPanelDragEnable(boolean z10) {
        this.mPanelDragEnable = z10;
    }

    public final void setPanelX(int i10) {
        applyPanelX(i10, true);
    }

    public void snapToTerminalIfIdle() {
        boolean z10 = true;
        if (this.mTouchState == 1) {
            return;
        }
        if (!this.mSlidingPanelLayoutInterpolator.isFinished()) {
            if (this.mPanelState != 1) {
                scheduleSnapToTerminalIfIdle();
                return;
            }
            return;
        }
        float f10 = this.mPanelPositionRatio;
        if (Float.isNaN(f10)) {
            f10 = 0.0f;
        }
        if (f10 <= 0.01f) {
            if (this.mPanelX != 0) {
                setPanelX(0);
            }
            if (this.mPanelState == 0) {
                dispatchTerminalProgressIfStale(0.0f, 0.01f);
                return;
            }
            Log.w(TAG, "snapToTerminalIfIdle force close leftover state=" + this.mPanelState);
            onPanelClosed();
            return;
        }
        if (f10 >= 0.99f) {
            int measuredWidth = getMeasuredWidth();
            if (measuredWidth > 0 && this.mPanelX != measuredWidth) {
                setPanelX(measuredWidth);
            }
            int i10 = this.mPanelState;
            if (i10 == 1) {
                return;
            }
            if (i10 == 2) {
                dispatchTerminalProgressIfStale(1.0f, 0.01f);
                return;
            }
            Log.w(TAG, "snapToTerminalIfIdle force open leftover state=" + this.mPanelState);
            onPanelOpened();
            return;
        }
        int i11 = this.mPanelState;
        if (i11 == 1 || (i11 != 3 && f10 < 0.4f)) {
            z10 = false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("snapToTerminalIfIdle ratio=");
        sb2.append(f10);
        sb2.append(" -> ");
        sb2.append(z10 ? "open" : "close");
        Log.w(TAG, sb2.toString());
        if (z10) {
            openPanel(0);
        } else {
            closePanel(0);
        }
    }

    public final void startDrag() {
        flushPanelClosedNotification();
        if (!this.mUserSwipedPanel) {
            this.mUserSwipedPanel = true;
            persistUserSwipedPanel();
            Log.i(TAG, "user swipe persisted: page indicator may dismiss");
        }
        this.mTouchState = 1;
        this.mIsPageMoving = true;
        revealPageIndicator();
        this.mSettling = false;
        if (hardware) {
            setLayerType(2, null);
        }
        if (DEBUG) {
            Log.d(TAG, "onDragStarted");
        }
        Iterator<WeakReference<SlidingPanelDragListener>> it = this.mSlidingPanelDragListeners.iterator();
        while (it.hasNext()) {
            SlidingPanelDragListener slidingPanelDragListener = it.next().get();
            if (slidingPanelDragListener != null) {
                slidingPanelDragListener.startDrag();
            }
        }
        scheduleSnapToTerminalIfIdle();
    }

    public final void setPanelX(float f10) {
        applyPanelX(f10, true);
    }

    public final void closePanel(float f10) {
        onClosePanel();
        this.mSlidingPanelLayoutInterpolator.animateToX(0, f10);
        Log.d(TAG, "closePanel, velocity = " + f10);
    }

    public final void openPanel(float f10) {
        onPanelOpening();
        this.mSettling = true;
        this.mSlidingPanelLayoutInterpolator.animateToX(getMeasuredWidth(), f10);
        Log.d(TAG, "openPanel, velocity = " + f10);
    }

    public void clearExternalDragState() {
        clearExternalDragState(false);
    }
}

package com.stepos.launcher.assistant.slidepanel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.quickstep.QuickstepObjectFactory;
import com.stepos.launcher.assistant.quickstep.RemoteTransitionDelegate;
import com.stepos.launcher.assistant.quickstep.RemoteTransitionParams;
import com.stepos.launcher.assistant.utils.Utils;
import com.stepos.launcher.client.R$style;
import com.stepos.launcher.client.libraries.ILauncherOverlayCallback;
import io.ktor.util.cio.ByteBufferPoolKt;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class ScrollOverlayComponent extends OverlayComponent implements IBinder.DeathRecipient {
    private static final String CLOSE_DBG = "MinusOneCloseDbg";
    private static final String RECENTS_OVERLAY_DBG = "RecentsOverlayDbg";
    private static final float RECENTS_PANEL_ENGAGED_EPSILON = 0.05f;
    private static final float RECENTS_PANEL_SNAP_OPEN_THRESHOLD = 0.4f;
    private static final long RECREATE_COOLDOWN_MS = 2500;
    private static final String SURFACE_DBG = "OverlaySurfaceDbg";
    private static final String TAG = "OverlayComponent";
    boolean fitSystemWindows;
    private boolean mAcceptExternalMove;
    private Animator mAlphaAnimator;
    private boolean mAlphaTargetOpen;
    public ILauncherOverlayCallback mCallback;
    private boolean mDelegateResolved;
    private boolean mDestroyCompleted;
    private long mDownTime;
    private int mEventX;
    private long mLastCreateElapsed;
    private long mLastDeferredDestroyElapsed;
    private float mLastExternalProgress;
    private long mLastRealDestroyElapsed;
    SlidingPanelDragListener mOverlayControllerStateChanger;
    private boolean mOverlayInputSuspendedByRecents;
    private PanelState mPanelState;
    private Runnable mPendingClosedEnd;
    private Runnable mPendingDestroyRunnable;
    private boolean mPendingOverlayInputAfterRecents;
    private ILauncherOverlayCallback mProxyCallbacks;
    private RemoteTransitionDelegate mRemoteTransitionDelegate;
    private final RootSurfaceTracker mRootSurfaceTracker;
    private SlidingPanelLayout mSlidingPanelLayout;

    public ScrollOverlayComponent(Context context) {
        super(context, R$style.AssistantOverlayWindowTheme);
        this.mOverlayControllerStateChanger = new OverlayControllerStateChanger(this);
        this.mLastExternalProgress = 0.0f;
        this.mPanelState = PanelState.CLOSED;
        this.mEventX = 0;
        this.mDownTime = 0L;
        this.mAcceptExternalMove = false;
        this.fitSystemWindows = true;
        this.mRootSurfaceTracker = new RootSurfaceTracker(new Consumer() { // from class: com.stepos.launcher.assistant.slidepanel.q
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f30155a.onSurfaceChanged((SurfaceControl) obj);
            }
        });
        this.mLastCreateElapsed = SystemClock.elapsedRealtime();
    }

    private void applyOverlayClosedEnd(SlidingPanelLayout slidingPanelLayout) {
        cancelPendingClosedEnd();
        this.mAlphaTargetOpen = false;
        MinusOneOverlayMeshMaskController.cancel();
        View view = slidingPanelLayout.mContentView;
        view.setAlpha(0.0f);
        view.setScaleX(0.9f);
        view.setScaleY(0.9f);
        view.setTranslationX(0.0f);
        slidingPanelLayout.mPanelPositionRatio = 0.0f;
        slidingPanelLayout.assignPanelX(0);
        slidingPanelLayout.mIsPanelOpen = false;
        slidingPanelLayout.mIsPageMoving = false;
        setTouchable(false);
        setFocusable(false);
        notifyDragListenersScroll(0.0f);
        slidingPanelLayout.onPanelClosed();
        setWindowAlpha(0.0f);
        View view2 = this.mDecorView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private void applyOverlayInputSuspendedByRecents(boolean z10) {
        if (this.mOverlayInputSuspendedByRecents == z10) {
            return;
        }
        this.mOverlayInputSuspendedByRecents = z10;
        Log.i(RECENTS_OVERLAY_DBG, "overlayInputSuspendedByRecents=" + z10 + " panelOpen=" + isPanelOpen());
        if (!z10) {
            finishPendingOverlayInputAfterRecents("recentsSuspendCleared");
        } else {
            setTouchable(false);
            setFocusable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyOverlayOpenEnd(SlidingPanelLayout slidingPanelLayout) {
        this.mAlphaTargetOpen = true;
        View view = slidingPanelLayout.mContentView;
        view.setTranslationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
        slidingPanelLayout.mPanelPositionRatio = 1.0f;
        slidingPanelLayout.assignPanelX(slidingPanelLayout.getMeasuredWidth());
        slidingPanelLayout.mIsPanelOpen = true;
        slidingPanelLayout.mIsPageMoving = false;
        notifyDragListenersScroll(1.0f);
        prepareOverlayWindowForInput();
        slidingPanelLayout.onPanelOpened();
        finishPendingOverlayInputAfterRecents("overlayOpenEnd");
    }

    private void applyOverlayPageIndicatorProgress(Bundle bundle) {
        SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        if (slidingPanelLayout == null || SlidingPanelLayout.enableAlpha) {
            return;
        }
        slidingPanelLayout.applyPageIndicatorProgress(bundle.getFloat(OverlayIndicatorState.KEY_OVERLAY_PROGRESS));
    }

    private void applyOverlayPageIndicatorState(Bundle bundle) {
        if (this.mSlidingPanelLayout == null || SlidingPanelLayout.enableAlpha) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("applyOverlayPageIndicatorState skip: panelNull=");
            sb2.append(this.mSlidingPanelLayout == null);
            sb2.append(" enableAlpha=");
            sb2.append(SlidingPanelLayout.enableAlpha);
            Log.d("OverlayComponent", sb2.toString());
            return;
        }
        Log.d("OverlayComponent", "applyOverlayPageIndicatorState pageCount=" + bundle.getInt(OverlayIndicatorState.KEY_PAGE_COUNT, -1) + " progress=" + bundle.getFloat(OverlayIndicatorState.KEY_OVERLAY_PROGRESS, -1.0f));
        this.mSlidingPanelLayout.applyPageIndicatorState(bundle);
    }

    private ValueAnimator buildCloseProgressAnimator(final SlidingPanelLayout slidingPanelLayout) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(333L);
        valueAnimatorOfFloat.setInterpolator(MinusOneTransitionSpec.OUTGOING);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.launcher.assistant.slidepanel.t
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f30159a.lambda$buildCloseProgressAnimator$3(slidingPanelLayout, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private ValueAnimator buildOpenProgressAnimator(final SlidingPanelLayout slidingPanelLayout) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(333L);
        valueAnimatorOfFloat.setInterpolator(MinusOneTransitionSpec.INCOMING);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.launcher.assistant.slidepanel.s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f30157a.lambda$buildOpenProgressAnimator$2(slidingPanelLayout, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private ValueAnimator buildWindowAlphaAnimator(float f10, float f11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.launcher.assistant.slidepanel.u
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f30161a.lambda$buildWindowAlphaAnimator$1(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void cancelAlphaAnimator() {
        Animator animator = this.mAlphaAnimator;
        if (animator != null) {
            animator.cancel();
            this.mAlphaAnimator = null;
        }
    }

    private void cancelDebouncedDestroy() {
        Runnable runnable = this.mPendingDestroyRunnable;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
            this.mPendingDestroyRunnable = null;
        }
    }

    private void cancelPendingClosedEnd() {
        Runnable runnable = this.mPendingClosedEnd;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
            this.mPendingClosedEnd = null;
        }
    }

    private void clearExternalScrollSession(String str) {
        SlidingPanelLayout slidingPanelLayout;
        boolean z10 = this.mAcceptExternalMove || ((slidingPanelLayout = this.mSlidingPanelLayout) != null && (slidingPanelLayout.mExternalDrag || slidingPanelLayout.mForceDrag || slidingPanelLayout.isAcceptExternalMove()));
        this.mAcceptExternalMove = false;
        this.mLastExternalProgress = 0.0f;
        if (this.mSlidingPanelLayout != null) {
            if (z10) {
                Log.i("OverlayComponent", "clearExternalScrollSession reason=" + str + " panelState=" + this.mPanelState + " externalDrag=" + this.mSlidingPanelLayout.mExternalDrag);
            }
            this.mSlidingPanelLayout.clearExternalDragState(true);
        }
    }

    private void finishPendingOverlayInputAfterRecents(String str) {
        if (this.mOverlayInputSuspendedByRecents) {
            return;
        }
        if (isPanelBeingDragged()) {
            settlePanelAfterRecentsInterrupt();
        }
        if (!shouldRestoreOverlayInputAfterRecents()) {
            this.mPendingOverlayInputAfterRecents = false;
            Log.d(RECENTS_OVERLAY_DBG, "restore input skipped: panelOpen=false panelState=" + this.mPanelState + " ratio=" + getPanelPositionRatio());
            return;
        }
        this.mPendingOverlayInputAfterRecents = false;
        prepareOverlayWindowForInput();
        setTouchable(true);
        setFocusable(true);
        Log.i(RECENTS_OVERLAY_DBG, "restore overlay input reason=" + str + " panelState=" + this.mPanelState + " ratio=" + getPanelPositionRatio());
    }

    private float getPanelPositionRatio() {
        SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        if (slidingPanelLayout != null) {
            return slidingPanelLayout.mPanelPositionRatio;
        }
        return 0.0f;
    }

    private boolean isAlphaAnimating() {
        return this.mAlphaAnimator != null;
    }

    private boolean isAlphaAnimatingToClosed() {
        return (this.mAlphaAnimator == null || this.mAlphaTargetOpen) ? false : true;
    }

    private boolean isAlphaAnimatingToOpen() {
        return this.mAlphaAnimator != null && this.mAlphaTargetOpen;
    }

    private boolean isContentAttached() {
        return this.mSlidingPanelLayout != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildCloseProgressAnimator$3(SlidingPanelLayout slidingPanelLayout, ValueAnimator valueAnimator) {
        float fFloatValue = 1.0f - (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.5f);
        updatePanelProgress(slidingPanelLayout, fFloatValue);
        notifyDragListenersScroll(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildOpenProgressAnimator$2(SlidingPanelLayout slidingPanelLayout, ValueAnimator valueAnimator) {
        float fFloatValue = (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.5f) + 0.5f;
        updatePanelProgress(slidingPanelLayout, fFloatValue);
        notifyDragListenersScroll(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildWindowAlphaAnimator$1(ValueAnimator valueAnimator) {
        setWindowAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleDebouncedDestroy$0() {
        this.mPendingDestroyRunnable = null;
        if (shouldDeferDestroy()) {
            scheduleDebouncedDestroy();
        } else {
            performRealDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleOverlayClosedEnd$4(SlidingPanelLayout slidingPanelLayout) {
        this.mPendingClosedEnd = null;
        if (this.mSlidingPanelLayout == slidingPanelLayout) {
            applyOverlayClosedEnd(slidingPanelLayout);
        }
    }

    private void linkCallbackDeath() throws RemoteException {
        ILauncherOverlayCallback iLauncherOverlayCallback = this.mProxyCallbacks;
        if (iLauncherOverlayCallback == null) {
            return;
        }
        try {
            iLauncherOverlayCallback.asBinder().linkToDeath(this, 0);
        } catch (RemoteException unused) {
            Log.e("OverlayComponent", "Failed to link callback death recipient");
        }
    }

    private void notifyCloseProgressKickoff() {
        notifyDragListenersScroll(1.0f);
        notifyDragListenersScroll(0.98f);
    }

    private void notifyDragListenersScroll(float f10) {
        SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        if (slidingPanelLayout == null) {
            return;
        }
        Iterator<WeakReference<SlidingPanelDragListener>> it = slidingPanelLayout.getSlidingPanelDragListeners().iterator();
        while (it.hasNext()) {
            SlidingPanelDragListener slidingPanelDragListener = it.next().get();
            if (slidingPanelDragListener != null) {
                slidingPanelDragListener.overlayScrollChanged(f10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceChanged(SurfaceControl surfaceControl) {
        ILauncherOverlayCallback iLauncherOverlayCallback = this.mProxyCallbacks;
        if (iLauncherOverlayCallback == null) {
            return;
        }
        try {
            iLauncherOverlayCallback.onOverlaySurfaceChanged(surfaceControl);
        } catch (DeadObjectException unused) {
            Log.w(SURFACE_DBG, "onSurfaceChanged: callback dead, clearing proxy");
            unlinkCallbackDeath();
            this.mCallback = null;
            this.mProxyCallbacks = null;
        } catch (RemoteException e10) {
            Log.w(SURFACE_DBG, "onSurfaceChanged failed", e10);
        }
    }

    private void prepareContentPivot(SlidingPanelLayout slidingPanelLayout) {
        View view = slidingPanelLayout.mContentView;
        if (view == null) {
            return;
        }
        int measuredWidth = slidingPanelLayout.getMeasuredWidth();
        int measuredHeight = slidingPanelLayout.getMeasuredHeight();
        if (measuredWidth <= 0) {
            measuredWidth = view.getWidth();
        }
        if (measuredHeight <= 0) {
            measuredHeight = view.getHeight();
        }
        view.setPivotX(measuredWidth / 2.0f);
        view.setPivotY(measuredHeight / 2.0f);
    }

    private RemoteTransitionDelegate resolveDelegate() throws IllegalAccessException, PackageManager.NameNotFoundException, ClassNotFoundException, IllegalArgumentException {
        if (!this.mDelegateResolved) {
            this.mDelegateResolved = true;
            QuickstepObjectFactory factory = QuickstepObjectFactory.getFactory(this);
            this.mRemoteTransitionDelegate = factory != null ? factory.createRemoteTransitionDelegate(this) : null;
        }
        return this.mRemoteTransitionDelegate;
    }

    private void restoreOverlayOpenVisualStateIfNeeded() {
        if (this.mSlidingPanelLayout == null || !isPanelOpen()) {
            return;
        }
        cancelPendingClosedEnd();
        cancelAlphaAnimator();
        applyOverlayOpenEnd(this.mSlidingPanelLayout);
    }

    private void scheduleDebouncedDestroy() {
        cancelDebouncedDestroy();
        this.mLastDeferredDestroyElapsed = SystemClock.elapsedRealtime();
        Runnable runnable = new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f30156a.lambda$scheduleDebouncedDestroy$0();
            }
        };
        this.mPendingDestroyRunnable = runnable;
        this.mMainHandler.postDelayed(runnable, 1200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleOverlayClosedEnd(final SlidingPanelLayout slidingPanelLayout) {
        cancelPendingClosedEnd();
        Runnable runnable = new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f30162a.lambda$scheduleOverlayClosedEnd$4(slidingPanelLayout);
            }
        };
        this.mPendingClosedEnd = runnable;
        this.mMainHandler.postDelayed(runnable, 333L);
    }

    private void setWindowAlpha(float f10) {
        Window window = this.mWindow;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f10;
            this.mWindow.setAttributes(attributes);
        }
    }

    private void settleAlphaAnimator() {
        SlidingPanelLayout slidingPanelLayout;
        boolean z10 = this.mPendingClosedEnd != null;
        cancelPendingClosedEnd();
        if (this.mAlphaAnimator == null) {
            if (!z10 || (slidingPanelLayout = this.mSlidingPanelLayout) == null) {
                return;
            }
            applyOverlayClosedEnd(slidingPanelLayout);
            return;
        }
        SlidingPanelLayout slidingPanelLayout2 = this.mSlidingPanelLayout;
        boolean z11 = this.mAlphaTargetOpen;
        cancelAlphaAnimator();
        if (slidingPanelLayout2 == null) {
            return;
        }
        if (z11) {
            applyOverlayOpenEnd(slidingPanelLayout2);
        } else {
            applyOverlayClosedEnd(slidingPanelLayout2);
        }
    }

    private boolean settleBeforeOpen() {
        if (SlidingPanelLayout.enableAlpha) {
            Log.w("OverlayComponent", "openOverlay: panel state is " + this.mPanelState + ", expected CLOSED. Forcing reset.");
            this.mPanelState = PanelState.CLOSED;
            SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
            slidingPanelLayout.mIsPanelOpen = false;
            slidingPanelLayout.mIsPageMoving = false;
            return true;
        }
        Log.w("OverlayComponent", "openOverlay: panel state is " + this.mPanelState + ", expected CLOSED. ratio=" + getPanelPositionRatio());
        if (isPanelOpen()) {
            this.mSlidingPanelLayout.onPanelOpened();
            syncLauncherProgressAfterForcedSettle(1.0f);
            return false;
        }
        if (this.mSlidingPanelLayout.getMeasuredWidth() > 0) {
            this.mPanelState = PanelState.CLOSED;
            return true;
        }
        SlidingPanelLayout slidingPanelLayout2 = this.mSlidingPanelLayout;
        slidingPanelLayout2.mPanelPositionRatio = 1.0f;
        slidingPanelLayout2.onPanelOpened();
        syncLauncherProgressAfterForcedSettle(1.0f);
        return false;
    }

    private void settlePanelAfterRecentsInterrupt() {
        if (!isPanelBeingDragged() || this.mSlidingPanelLayout == null) {
            return;
        }
        float panelPositionRatio = getPanelPositionRatio();
        Log.i(RECENTS_OVERLAY_DBG, "settle panel after recents interrupt ratio=" + panelPositionRatio + " panelState=" + this.mPanelState);
        if (SlidingPanelLayout.enableAlpha) {
            if (panelPositionRatio >= 0.4f) {
                prepareOverlayWindowForInput();
                return;
            } else {
                if (panelPositionRatio > 0.05f) {
                    closeOverlayAlpha(0);
                    return;
                }
                return;
            }
        }
        int measuredWidth = this.mSlidingPanelLayout.getMeasuredWidth();
        if (panelPositionRatio < 0.4f) {
            if (panelPositionRatio > 0.05f) {
                this.mSlidingPanelLayout.closePanel(0);
                syncLauncherProgressAfterForcedSettle(0.0f);
                return;
            }
            return;
        }
        if (measuredWidth <= 0) {
            SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
            slidingPanelLayout.mPanelPositionRatio = 1.0f;
            slidingPanelLayout.onPanelOpened();
        } else {
            this.mSlidingPanelLayout.openPanel(0);
        }
        syncLauncherProgressAfterForcedSettle(1.0f);
    }

    private boolean shouldDeferDestroy() {
        View view;
        if (this.mDestroyCompleted) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.mLastCreateElapsed;
        long jElapsedRealtime2 = this.mLastRealDestroyElapsed > 0 ? SystemClock.elapsedRealtime() - this.mLastRealDestroyElapsed : Long.MAX_VALUE;
        if (jElapsedRealtime < 2500 || jElapsedRealtime2 < 2500 || this.mRootSurfaceTracker.getNullPending()) {
            return (isAttachToWindow() && (view = this.mDecorView) != null && view.getVisibility() == 0 && isPanelOpen()) || this.mRootSurfaceTracker.getNullPending();
        }
        return false;
    }

    private boolean shouldRestoreOverlayInputAfterRecents() {
        if (isPanelOpen()) {
            return true;
        }
        return isPanelBeingDragged() && getPanelPositionRatio() > 0.05f;
    }

    private void syncLauncherProgressAfterForcedSettle(float f10) {
        SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        if (slidingPanelLayout == null) {
            return;
        }
        slidingPanelLayout.mExternalDrag = false;
        slidingPanelLayout.overlayScrollChanged(f10);
    }

    private void unlinkCallbackDeath() {
        ILauncherOverlayCallback iLauncherOverlayCallback = this.mProxyCallbacks;
        if (iLauncherOverlayCallback == null) {
            return;
        }
        try {
            iLauncherOverlayCallback.asBinder().unlinkToDeath(this, 0);
        } catch (Exception e10) {
            Log.w(SURFACE_DBG, "unlink callback death failed", e10);
        }
    }

    private void updatePanelProgress(SlidingPanelLayout slidingPanelLayout, float f10) {
        float fMax = Math.max(0.0f, Math.min(1.0f, f10));
        slidingPanelLayout.mPanelPositionRatio = fMax;
        slidingPanelLayout.assignPanelX((int) (fMax * slidingPanelLayout.getMeasuredWidth()));
    }

    public void addSlidingPanelDragListener(SlidingPanelDragListener slidingPanelDragListener) {
        SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        if (slidingPanelLayout != null) {
            slidingPanelLayout.addSlidingPanelDragListener(slidingPanelDragListener);
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void applyContentViewProperties(Bundle bundle) {
        super.applyContentViewProperties(bundle);
        if (bundle.containsKey(ConstConfig.KEY_VIEW_ALPHA_PROPERTY)) {
            setAlpha(bundle.getFloat(ConstConfig.KEY_VIEW_ALPHA_PROPERTY));
        }
        if (bundle.containsKey(ConstConfig.KEY_VIEW_SCALE_PROPERTY)) {
            setScale(bundle.getFloat(ConstConfig.KEY_VIEW_SCALE_PROPERTY));
        }
        if (bundle.containsKey(ConstConfig.KEY_VIEW_TRANSLATION_X_PROPERTY)) {
            setTranslationX(bundle.getFloat(ConstConfig.KEY_VIEW_TRANSLATION_X_PROPERTY));
        }
        if (bundle.containsKey(ConstConfig.KEY_VIEW_TRANSLATION_Y_PROPERTY)) {
            setTranslationY(bundle.getFloat(ConstConfig.KEY_VIEW_TRANSLATION_Y_PROPERTY));
        }
        if (bundle.containsKey(OverlayIndicatorState.KEY_PAGE_COUNT)) {
            applyOverlayPageIndicatorState(bundle);
        } else if (bundle.containsKey(OverlayIndicatorState.KEY_OVERLAY_PROGRESS)) {
            applyOverlayPageIndicatorProgress(bundle);
        }
        if (!bundle.containsKey(OverlayComponent.KEY_OVERLAY_WINDOW_FOCUSABLE)) {
            if (bundle.containsKey(OverlayComponent.KEY_OVERLAY_WINDOW_TOUCHABLE)) {
                if (this.mOverlayInputSuspendedByRecents) {
                    Log.d(RECENTS_OVERLAY_DBG, "apply touchable ignored: recents suspended");
                    return;
                }
                setTouchable(bundle.getBoolean(OverlayComponent.KEY_OVERLAY_WINDOW_TOUCHABLE));
                Log.d(RECENTS_OVERLAY_DBG, "apply touchable=" + bundle.getBoolean(OverlayComponent.KEY_OVERLAY_WINDOW_TOUCHABLE));
                return;
            }
            return;
        }
        boolean z10 = bundle.getBoolean(OverlayComponent.KEY_OVERLAY_WINDOW_FOCUSABLE);
        applyOverlayInputSuspendedByRecents(!z10);
        Log.d(RECENTS_OVERLAY_DBG, "apply recentsInput focusable=" + z10 + " touchable=" + bundle.getBoolean(OverlayComponent.KEY_OVERLAY_WINDOW_TOUCHABLE, false) + " panelOpen=" + isPanelOpen() + " suspended=" + this.mOverlayInputSuspendedByRecents);
    }

    public void binderDied() {
        Log.w(SURFACE_DBG, "binderDied: clear callback only, skip full onDestroy");
        unlinkCallbackDeath();
        this.mCallback = null;
        this.mProxyCallbacks = null;
        QuickstepObjectFactory.invalidateCache();
    }

    public boolean canSoftReattach(ILauncherOverlayCallback iLauncherOverlayCallback, WindowManager.LayoutParams layoutParams) {
        if (iLauncherOverlayCallback == null || layoutParams == null || this.mSlidingPanelLayout == null || this.mDestroyCompleted) {
            return false;
        }
        return ((this.mLastDeferredDestroyElapsed > 0L ? 1 : (this.mLastDeferredDestroyElapsed == 0L ? 0 : -1)) > 0 ? SystemClock.elapsedRealtime() - this.mLastDeferredDestroyElapsed : Long.MAX_VALUE) < 2500 || this.mPendingDestroyRunnable != null || this.mRootSurfaceTracker.getNullPending();
    }

    public void closeOverlay(boolean z10) {
        if (this.mSlidingPanelLayout == null) {
            Log.w("OverlayComponent", "closeOverlay: mSlidingPanelLayout is null, skip");
            return;
        }
        clearExternalScrollSession("closeOverlay");
        int minusAnimateTime = z10 ? ConstConfig.getMinusAnimateTime() : 0;
        if (SlidingPanelLayout.enableAlpha) {
            closeOverlayAlpha(minusAnimateTime);
        } else {
            this.mSlidingPanelLayout.closePanel(minusAnimateTime);
        }
    }

    public void closeOverlayAlpha(int i10) {
        if (this.mSlidingPanelLayout == null) {
            Log.w(CLOSE_DBG, "closeOverlayAlpha skip: mSlidingPanelLayout is null");
            return;
        }
        if (!isPanelOpen() && !isPanelBeingDragged() && !isAlphaAnimatingToOpen()) {
            Log.w(CLOSE_DBG, "closeOverlayAlpha skip: open=" + isPanelOpen() + " dragging=" + isPanelBeingDragged() + " animatingOpen=" + isAlphaAnimatingToOpen());
            return;
        }
        MinusOneOverlayMeshMaskController.cancel();
        settleAlphaAnimator();
        final SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        View view = slidingPanelLayout.mContentView;
        slidingPanelLayout.mIsPageMoving = true;
        prepareContentPivot(slidingPanelLayout);
        if (i10 <= 0) {
            MinusOneOverlayMeshMaskController.cancel();
            applyOverlayClosedEnd(slidingPanelLayout);
            return;
        }
        float alpha = view.getAlpha();
        if (alpha <= 0.01f) {
            MinusOneOverlayMeshMaskController.cancel();
            applyOverlayClosedEnd(slidingPanelLayout);
            return;
        }
        MinusOneOverlayMeshMaskController.startClose(this.mDecorView);
        setWindowAlpha(1.0f);
        notifyCloseProgressKickoff();
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f, 0.8f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f, 0.8f);
        objectAnimatorOfFloat.setDuration(333L);
        objectAnimatorOfFloat2.setDuration(333L);
        Interpolator interpolator = MinusOneTransitionSpec.OUTGOING;
        objectAnimatorOfFloat.setInterpolator(interpolator);
        objectAnimatorOfFloat2.setInterpolator(interpolator);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, alpha, 0.0f);
        objectAnimatorOfFloat3.setDuration(333L);
        objectAnimatorOfFloat3.setInterpolator(MinusOneTransitionSpec.OUTGOING_OPACITY);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, buildCloseProgressAnimator(slidingPanelLayout));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent.2
            private boolean mCancelled;
            private final long mStartElapsed = SystemClock.elapsedRealtime();

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.mCancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ScrollOverlayComponent.this.mAlphaAnimator == animator) {
                    ScrollOverlayComponent.this.mAlphaAnimator = null;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.mStartElapsed;
                if (!this.mCancelled) {
                    ScrollOverlayComponent.this.setTouchable(false);
                    ScrollOverlayComponent.this.scheduleOverlayClosedEnd(slidingPanelLayout);
                    return;
                }
                Log.w(ScrollOverlayComponent.CLOSE_DBG, "closeOverlayAlpha CANCELLED elapsed=" + jElapsedRealtime + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
            }
        });
        this.mAlphaAnimator = animatorSet;
        this.mAlphaTargetOpen = false;
        animatorSet.start();
    }

    public final void dispatchTouchEvent(int i10, int i11, long j10) {
        if (this.mSlidingPanelLayout == null) {
            return;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(this.mDownTime, j10, i10, i11, 10.0f, 0);
        try {
            motionEventObtain.setSource(ByteBufferPoolKt.DEFAULT_BUFFER_SIZE);
            this.mSlidingPanelLayout.dispatchTouchEvent(motionEventObtain);
        } finally {
            motionEventObtain.recycle();
        }
    }

    public View findTransitionTarget(int i10, AppWidgetProviderInfo appWidgetProviderInfo) {
        return null;
    }

    public PanelState getPanelState() {
        return this.mPanelState;
    }

    public SlidingPanelLayout getRootView() {
        return this.mSlidingPanelLayout;
    }

    public SlidingPanelLayout getSlidingPanelLayout() {
        return this.mSlidingPanelLayout;
    }

    public boolean isOverlayInputSuspendedByRecents() {
        return this.mOverlayInputSuspendedByRecents;
    }

    public boolean isPanelBeingDragged() {
        return this.mPanelState == PanelState.DRAGGING;
    }

    public boolean isPanelOpen() {
        PanelState panelState = this.mPanelState;
        return panelState == PanelState.OPEN_AS_LAYER || panelState == PanelState.OPEN_AS_DRAWER;
    }

    @Override // com.stepos.launcher.assistant.slidepanel.DialogOverlayContextWrapper
    public void onBackPressed() {
        closeOverlay(true);
    }

    @Override // com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onDestroy() {
        if (shouldDeferDestroy()) {
            scheduleDebouncedDestroy();
        } else {
            performRealDestroy();
        }
    }

    public void onEndScroll() {
        SlidingPanelLayout slidingPanelLayout;
        if (SlidingPanelLayout.enableAlpha) {
            return;
        }
        if (this.mAcceptExternalMove && (slidingPanelLayout = this.mSlidingPanelLayout) != null) {
            slidingPanelLayout.finishExternalScroll(this.mLastExternalProgress);
        }
        clearExternalScrollSession("onEndScroll");
        SlidingPanelLayout slidingPanelLayout2 = this.mSlidingPanelLayout;
        if (slidingPanelLayout2 != null) {
            slidingPanelLayout2.snapToTerminalIfIdle();
            this.mSlidingPanelLayout.scheduleSnapToTerminalIfIdle();
        }
    }

    public void onFlingVelocity(float f10) {
        SlidingPanelLayout slidingPanelLayout;
        if (SlidingPanelLayout.enableAlpha || (slidingPanelLayout = this.mSlidingPanelLayout) == null) {
            return;
        }
        slidingPanelLayout.onOneshotFlingVelocity(f10);
    }

    public boolean onHomeKey() {
        return true;
    }

    public void onOverlayOpenInputDeferredByRecents() {
        this.mPendingOverlayInputAfterRecents = true;
    }

    public boolean onRecentKey() {
        return true;
    }

    public void onRemoteTransitionEnd(RemoteTransitionParams remoteTransitionParams) throws IllegalAccessException, PackageManager.NameNotFoundException, ClassNotFoundException, IllegalArgumentException {
        RemoteTransitionDelegate remoteTransitionDelegateResolveDelegate = resolveDelegate();
        if (remoteTransitionDelegateResolveDelegate == null) {
            Log.d("OverlayComponent", "No quickstep factory found");
        } else {
            remoteTransitionDelegateResolveDelegate.onRemoteTransitionEnd(remoteTransitionParams);
        }
    }

    public void onRemoteTransitionStart(RemoteTransitionParams remoteTransitionParams) throws IllegalAccessException, PackageManager.NameNotFoundException, ClassNotFoundException, IllegalArgumentException {
        RemoteTransitionDelegate remoteTransitionDelegateResolveDelegate = resolveDelegate();
        if (remoteTransitionDelegateResolveDelegate == null) {
            Log.d("OverlayComponent", "No quickstep factory found");
        } else {
            remoteTransitionDelegateResolveDelegate.onRemoteTransitionStart(remoteTransitionParams);
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.OverlayComponent
    public void onResume() {
        super.onResume();
        if (SlidingPanelLayout.enableAlpha && isPanelOpen()) {
            restoreOverlayOpenVisualStateIfNeeded();
        }
    }

    public void onScreenOff() {
        if (SlidingPanelLayout.enableAlpha && isPanelOpen()) {
            cancelPendingClosedEnd();
            cancelAlphaAnimator();
        }
    }

    public void onScreenOn() {
        restoreOverlayOpenVisualStateIfNeeded();
    }

    public void onScroll(float f10) {
        SlidingPanelLayout slidingPanelLayout;
        if (SlidingPanelLayout.enableAlpha || (slidingPanelLayout = this.mSlidingPanelLayout) == null || slidingPanelLayout.isLocalDragInProgress() || this.mSlidingPanelLayout.isSettlingOpen()) {
            return;
        }
        if (!this.mAcceptExternalMove) {
            if (f10 <= 0.001f) {
                if (SlidingPanelLayout.DEBUG) {
                    Log.d("OverlayComponent", "onScroll ignore rest progress outside external session");
                    return;
                }
                return;
            }
            onStartScroll(true);
        }
        if (this.mAcceptExternalMove) {
            float fMax = Math.max(0.0f, Math.min(1.0f, f10));
            this.mLastExternalProgress = fMax;
            this.mSlidingPanelLayout.applyExternalScrollProgress(fMax);
            this.mEventX = this.mSlidingPanelLayout.mPanelX;
        }
    }

    public void onStartScroll() {
        onStartScroll(false);
    }

    public void onTransitTargetInvisible(View view, int i10) {
    }

    public void onTransitTargetVisible(View view, int i10) {
    }

    public void openOverlay(int i10) {
        if (this.mSlidingPanelLayout == null) {
            Log.e("OverlayComponent", "openOverlay: mSlidingPanelLayout is null, cannot open");
            return;
        }
        clearExternalScrollSession("openOverlay");
        PanelState panelState = this.mPanelState;
        PanelState panelState2 = PanelState.CLOSED;
        if ((panelState == panelState2 || settleBeforeOpen()) && this.mPanelState == panelState2) {
            boolean z10 = (i10 & 1) != 0;
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            int minusAnimateTime = z10 ? ConstConfig.getMinusAnimateTime() : 0;
            if (SlidingPanelLayout.enableAlpha) {
                openOverlayAlpha(minusAnimateTime);
            } else {
                this.mSlidingPanelLayout.openPanel(minusAnimateTime);
            }
        }
    }

    public void openOverlayAlpha(int i10) {
        if (!isPanelOpen() || isAlphaAnimatingToClosed()) {
            settleAlphaAnimator();
            final SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
            View view = slidingPanelLayout.mContentView;
            setTouchable(true);
            slidingPanelLayout.mContentView.setTranslationX(0.0f);
            slidingPanelLayout.mPanelPositionRatio = 0.0f;
            slidingPanelLayout.mIsPageMoving = true;
            prepareContentPivot(slidingPanelLayout);
            if (i10 <= 0) {
                applyOverlayOpenEnd(slidingPanelLayout);
                return;
            }
            slidingPanelLayout.setAlpha(1.0f);
            view.setScaleX(0.9f);
            view.setScaleY(0.9f);
            view.setAlpha(0.0f);
            setWindowAlpha(1.0f);
            View view2 = this.mDecorView;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 0.9f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 0.9f, 1.0f);
            objectAnimatorOfFloat.setDuration(333L);
            objectAnimatorOfFloat2.setDuration(333L);
            Interpolator interpolator = MinusOneTransitionSpec.INCOMING;
            objectAnimatorOfFloat.setInterpolator(interpolator);
            objectAnimatorOfFloat2.setInterpolator(interpolator);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
            objectAnimatorOfFloat3.setDuration(333L);
            objectAnimatorOfFloat3.setInterpolator(MinusOneTransitionSpec.INCOMING_OPACITY);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, buildOpenProgressAnimator(slidingPanelLayout));
            AnimatorSet animatorSet2 = new AnimatorSet();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(333L);
            animatorSet2.play(animatorSet).after(valueAnimatorOfFloat);
            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.launcher.assistant.slidepanel.ScrollOverlayComponent.1
                private boolean mCancelled;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.mCancelled = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ScrollOverlayComponent.this.mAlphaAnimator == animator) {
                        ScrollOverlayComponent.this.mAlphaAnimator = null;
                    }
                    if (this.mCancelled) {
                        return;
                    }
                    ScrollOverlayComponent.this.applyOverlayOpenEnd(slidingPanelLayout);
                }
            });
            this.mAlphaAnimator = animatorSet2;
            this.mAlphaTargetOpen = true;
            animatorSet2.start();
        }
    }

    public void performRealDestroy() {
        if (this.mDestroyCompleted) {
            return;
        }
        cancelDebouncedDestroy();
        this.mDestroyCompleted = true;
        this.mLastRealDestroyElapsed = SystemClock.elapsedRealtime();
        this.mLastDeferredDestroyElapsed = 0L;
        Log.i(SURFACE_DBG, "performRealDestroy");
        unlinkCallbackDeath();
        super.onDestroy();
        this.mRootSurfaceTracker.clear();
        this.mCallback = null;
        this.mProxyCallbacks = null;
        this.mSlidingPanelLayout = null;
        this.mPanelState = PanelState.CLOSED;
    }

    public void prepareOverlayWindowForInput() {
        setWindowAlpha(1.0f);
        View view = this.mDecorView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void reattachToWindow(WindowManager.LayoutParams layoutParams, ILauncherOverlayCallback iLauncherOverlayCallback) throws RemoteException {
        cancelDebouncedDestroy();
        this.mDestroyCompleted = false;
        this.mLastDeferredDestroyElapsed = 0L;
        onPreCreated(layoutParams);
        setCallback(iLauncherOverlayCallback);
        SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        if (slidingPanelLayout != null) {
            slidingPanelLayout.setCallback(iLauncherOverlayCallback);
        }
        addDecorViewIfNeeded();
        onStart();
        this.mRootSurfaceTracker.reset(this.mDecorView);
        this.mLastCreateElapsed = SystemClock.elapsedRealtime();
        Log.i(SURFACE_DBG, "softReattach");
    }

    public void removeSlidingPanelDragListener(SlidingPanelDragListener slidingPanelDragListener) {
        SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        if (slidingPanelLayout != null) {
            slidingPanelLayout.removeSlidingPanelDragListener(slidingPanelDragListener);
        }
    }

    public void setAlpha(float f10) {
        if (isContentAttached()) {
            this.mSlidingPanelLayout.setAlpha(f10);
        }
    }

    public void setCallback(ILauncherOverlayCallback iLauncherOverlayCallback) throws RemoteException {
        unlinkCallbackDeath();
        this.mCallback = iLauncherOverlayCallback;
        this.mProxyCallbacks = iLauncherOverlayCallback;
        linkCallbackDeath();
        SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        if (slidingPanelLayout == null || !slidingPanelLayout.isAttachedToWindow()) {
            Log.d("OverlayComponent", "Attampt to set callback to a detached SlidingLayoutLayout, ignore.");
        } else {
            this.mSlidingPanelLayout.setCallback(iLauncherOverlayCallback);
        }
    }

    public void setContentView(int i10, int i11) {
        removeDecorViewIfNeeded();
        this.mWindow.clearFlags(67108864);
        Context contextCreateThemeContext = Utils.createThemeContext(this, i10);
        OverlayControllerSlidingPanelLayout overlayControllerSlidingPanelLayout = new OverlayControllerSlidingPanelLayout(contextCreateThemeContext, this);
        this.mSlidingPanelLayout = overlayControllerSlidingPanelLayout;
        overlayControllerSlidingPanelLayout.setCallback(this.mProxyCallbacks);
        LayoutInflater layoutInflaterCloneInContext = LayoutInflater.from(contextCreateThemeContext).cloneInContext(contextCreateThemeContext);
        SlidingPanelLayout slidingPanelLayout = this.mSlidingPanelLayout;
        slidingPanelLayout.addContentView(layoutInflaterCloneInContext.inflate(i11, (ViewGroup) slidingPanelLayout, false));
        this.mSlidingPanelLayout.addSlidingPanelDragListener(this.mOverlayControllerStateChanger);
        this.mWindow.setContentView(this.mSlidingPanelLayout);
        View decorView = this.mWindow.getDecorView();
        this.mDecorView = decorView;
        decorView.setFitsSystemWindows(true);
        this.mRootSurfaceTracker.reset(this.mDecorView);
        this.mDecorView.setSystemUiVisibility(1798);
        addDecorViewIfNeeded();
        setTouchable(false);
        this.mPanelState = PanelState.CLOSED;
        this.mDestroyCompleted = false;
        this.mLastCreateElapsed = SystemClock.elapsedRealtime();
    }

    public void setPanelState(PanelState panelState) {
        if (panelState != this.mPanelState) {
            this.mPanelState = panelState;
        }
    }

    public void setScale(float f10) {
        if (isContentAttached()) {
            this.mSlidingPanelLayout.setPivotX(r0.getWidth() / 2.0f);
            this.mSlidingPanelLayout.setPivotY(r0.getHeight() / 2.0f);
            this.mSlidingPanelLayout.setScaleX(f10);
            this.mSlidingPanelLayout.setScaleY(f10);
        }
    }

    public void setTranslationX(float f10) {
        if (isContentAttached()) {
            this.mSlidingPanelLayout.setTranslationX(f10);
        }
    }

    public void setTranslationY(float f10) {
        if (isContentAttached()) {
            this.mSlidingPanelLayout.setTranslationY(f10);
        }
    }

    public boolean shouldDeferWindowDetach() {
        return shouldDeferDestroy();
    }

    private void onStartScroll(boolean z10) {
        SlidingPanelLayout slidingPanelLayout;
        if (SlidingPanelLayout.enableAlpha || (slidingPanelLayout = this.mSlidingPanelLayout) == null) {
            return;
        }
        if (!z10 && slidingPanelLayout.isSettlingClosed()) {
            Log.i("OverlayComponent", "onStartScroll skip: close interpolator settling");
            return;
        }
        this.mLastExternalProgress = 0.0f;
        if (!isPanelOpen()) {
            SlidingPanelLayout slidingPanelLayout2 = this.mSlidingPanelLayout;
            if (slidingPanelLayout2.mPanelX < slidingPanelLayout2.mTouchSlop) {
                this.mEventX = 0;
                this.mAcceptExternalMove = true;
                slidingPanelLayout2.setAcceptExternalMove(true);
                this.mSlidingPanelLayout.setPanelX(0);
                this.mSlidingPanelLayout.mForceDrag = true;
                dispatchTouchEvent(0, this.mEventX, SystemClock.uptimeMillis());
                dispatchTouchEvent(2, this.mEventX, SystemClock.uptimeMillis());
                return;
            }
        }
        if (isPanelOpen() || isPanelBeingDragged()) {
            SlidingPanelLayout slidingPanelLayout3 = this.mSlidingPanelLayout;
            this.mEventX = slidingPanelLayout3.mPanelX;
            this.mAcceptExternalMove = true;
            slidingPanelLayout3.setAcceptExternalMove(true);
            this.mSlidingPanelLayout.mForceDrag = true;
            dispatchTouchEvent(0, this.mEventX, SystemClock.uptimeMillis());
            dispatchTouchEvent(2, this.mEventX, SystemClock.uptimeMillis());
        }
    }

    public void closeOverlay(int i10) {
        if (this.mSlidingPanelLayout == null) {
            Log.w("OverlayComponent", "closeOverlay: mSlidingPanelLayout is null, skip");
            return;
        }
        clearExternalScrollSession("closeOverlay(duration)");
        if (SlidingPanelLayout.enableAlpha) {
            if (isPanelOpen() || isPanelBeingDragged() || isAlphaAnimating()) {
                closeOverlayAlpha(i10);
                return;
            }
            return;
        }
        if (isPanelOpen() || isPanelBeingDragged()) {
            this.mSlidingPanelLayout.closePanel(i10);
        }
    }
}

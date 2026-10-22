package com.android.server.wm;

import android.content.Context;
import android.os.HandlerExecutor;
import android.os.Trace;
import android.util.Slog;
import android.util.TimeUtils;
import android.view.Choreographer;
import android.view.SurfaceControl;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.policy.WindowManagerPolicy;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class WindowAnimator {
    static final int PENDING_STATE_HAS_CHANGES = 1;
    static final int PENDING_STATE_NEED_APPLY = 2;
    static final int PENDING_STATE_NONE = 0;
    private static final String TAG = "WindowManager";
    private ArrayList<Runnable> mAfterPrepareSurfacesRunnables;
    final Choreographer.FrameCallback mAnimationFrameCallback;
    private boolean mAnimationFrameCallbackScheduled;
    private WindowAnimatorSmtEx mAnimatorSmtEx;
    private Choreographer mChoreographer;
    final Context mContext;
    long mCurrentTime;
    private final HandlerExecutor mExecutor;
    private boolean mInitialized;
    private boolean mLastRootAnimating;
    boolean mNotifyWhenNoAnimation;
    int mPendingState;
    final WindowManagerPolicy mPolicy;
    final WindowManagerService mService;
    private final SurfaceControl.Transaction mTransaction;

    @Retention(RetentionPolicy.SOURCE)
    @interface PendingState {
    }

    /* JADX INFO: renamed from: $r8$lambda$AS_wbK9i-bc6ocCFop7s9PnXP80, reason: not valid java name */
    public static /* synthetic */ void m10377$r8$lambda$AS_wbK9ibc6ocCFop7s9PnXP80(WindowAnimator r0, long r1) {
        r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$W57Ag5fzVY7lre5WxW-Fd7sotY8, reason: not valid java name */
    public static /* synthetic */ void m10378$r8$lambda$W57Ag5fzVY7lre5WxWFd7sotY8(WindowAnimator r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$YA-_zT1Nyp9vmAAkWN_rtDVYlnE, reason: not valid java name */
    public static /* synthetic */ void m10379$r8$lambda$YA_zT1Nyp9vmAAkWN_rtDVYlnE(WindowAnimator r0, ArrayList r1) {
        r0.lambda$animate$2(r1);
    }

    WindowAnimator(WindowManagerService service) {
        this.mInitialized = false;
        this.mNotifyWhenNoAnimation = false;
        this.mAfterPrepareSurfacesRunnables = new ArrayList();
        this.mAnimatorSmtEx = null;
        this.mService = service;
        this.mContext = service.mContext;
        this.mPolicy = service.mPolicy;
        this.mTransaction = service.mTransactionFactory.get();
        service.mAnimationHandler.runWithScissors(new WindowAnimator$$ExternalSyntheticLambda0(this), 0);
        this.mExecutor = new HandlerExecutor(service.mAnimationHandler);
        this.mAnimationFrameCallback = new WindowAnimator$$ExternalSyntheticLambda1(this);
        this.mAnimatorSmtEx = new WindowAnimatorSmtEx(this, 2);
    }

    private /* synthetic */ void lambda$new$0() {
        this.mChoreographer = Choreographer.getSfInstance();
    }

    private /* synthetic */ void lambda$new$1(long frameTimeNs) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mAnimationFrameCallbackScheduled = false;     // Catch: Throwable -> L10
        animate(frameTimeNs);     // Catch: Throwable -> L10
        if (this.mNotifyWhenNoAnimation == true) goto L8;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        if (this.mLastRootAnimating == true) goto L12;
        this.mService.mGlobalLock.notifyAll();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void ready() {
        this.mInitialized = true;
    }

    private void animate(long frameTimeNs) {
        if (this.mInitialized == true) goto L5;
        return;
    L5:
        scheduleAnimation();
        RootWindowContainer root = this.mService.mRoot;
        boolean rootAnimating = false;
        this.mCurrentTime = frameTimeNs / 1000000;
        if (WindowManagerDebugConfig.DEBUG_WINDOW_TRACE == false) goto L9;
        Slog.i(TAG, "!!! animate: entry time=" + this.mCurrentTime);
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L57;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, -5360147928134631656L, 0, null);
    L57:
        root.handleCompleteDeferredRemoval();     // Catch: RuntimeException -> L14
        AccessibilityController accessibilityController = this.mService.mAccessibilityController;     // Catch: RuntimeException -> L14
        int numDisplays = root.getChildCount();     // Catch: RuntimeException -> L14
        int i = 0;
    L12:
        if (i >= numDisplays) goto L16;
        DisplayContent dc = root.getChildAt(i);     // Catch: RuntimeException -> L14
        dc.updateWindowsForAnimator();     // Catch: RuntimeException -> L14
        dc.prepareSurfaces();     // Catch: RuntimeException -> L14
        i = i + 1;     // Catch: RuntimeException -> L14
        goto L12
    L16:
        int i2 = 0;
    L17:
        if (i2 >= numDisplays) goto L30;
        DisplayContent dc2 = root.getChildAt(i2);     // Catch: RuntimeException -> L14
        if (accessibilityController.hasCallbacks() == false) goto L22;
        accessibilityController.recomputeMagnifiedRegionAndDrawMagnifiedRegionBorderIfNeeded(dc2.mDisplayId);     // Catch: RuntimeException -> L14
    L22:
        if (dc2.isAnimating(4, -1) == false) goto L27;
        rootAnimating = true;
        if (dc2.mLastContainsRunningSurfaceAnimator == true) goto L29;
        dc2.mLastContainsRunningSurfaceAnimator = true;     // Catch: RuntimeException -> L14
        dc2.enableHighFrameRate(true);     // Catch: RuntimeException -> L14
    L29:
        this.mTransaction.merge(dc2.getPendingTransaction());     // Catch: RuntimeException -> L14
        i2 = i2 + 1;     // Catch: RuntimeException -> L14
        goto L17
    L27:
        if (dc2.mLastContainsRunningSurfaceAnimator == false) goto L29;
        dc2.mLastContainsRunningSurfaceAnimator = false;     // Catch: RuntimeException -> L14
        dc2.enableHighFrameRate(false);     // Catch: RuntimeException -> L14
        goto L29
    L30:
        cancelAnimation();     // Catch: RuntimeException -> L14
        if (this.mService.mWatermark == null) goto L35;
        this.mService.mWatermark.drawIfNeeded();     // Catch: RuntimeException -> L14
    L35:
        boolean hasPendingLayoutChanges = root.hasPendingLayoutChanges(this);
        if (hasPendingLayoutChanges == false) goto L39;
        this.mService.mWindowPlacerLocked.requestTraversal();
    L39:
        if (rootAnimating == true) goto L41;
    L43:
        if (rootAnimating == false) goto L45;
    L47:
        this.mLastRootAnimating = rootAnimating;
        final ArrayList<Runnable> afterPrepareSurfacesRunnables = this.mAfterPrepareSurfacesRunnables;
        if (afterPrepareSurfacesRunnables.isEmpty() == true) goto L50;
        this.mAfterPrepareSurfacesRunnables = new ArrayList();
        this.mTransaction.addTransactionCommittedListener(this.mExecutor, new WindowAnimator$$ExternalSyntheticLambda2(this, afterPrepareSurfacesRunnables));
    L50:
        Trace.traceBegin(32, "applyTransaction");
        this.mTransaction.apply();
        Trace.traceEnd(32);
        this.mPendingState = 0;
        this.mService.mWindowTracing.logState("WindowAnimator");
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L53;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, -3993586364046165922L, 0, null);
    L53:
        this.mService.mAtmService.mTaskOrganizerController.dispatchPendingEvents();
        if (WindowManagerDebugConfig.DEBUG_WINDOW_TRACE == false) goto L65;
        Slog.i(TAG, "!!! animate: exit hasPendingLayoutChanges=" + hasPendingLayoutChanges);
        return;
    L65:
        return;
    L45:
        if (this.mLastRootAnimating == false) goto L47;
        this.mService.mWindowPlacerLocked.requestTraversal();
        Trace.asyncTraceEnd(32, "animating", 0);
        goto L47
    L41:
        if (this.mLastRootAnimating == true) goto L43;
        Trace.asyncTraceBegin(32, "animating", 0);
    L14:
        e = move-exception;
        Slog.wtf(TAG, "Unhandled exception in Window Manager", e);
        goto L35
    }

    private /* synthetic */ void lambda$animate$2(ArrayList afterPrepareSurfacesRunnables) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        int i = 0;
        int size = afterPrepareSurfacesRunnables.size();     // Catch: Throwable -> L8
    L6:
        if (i >= size) goto L10;
        ((Runnable) afterPrepareSurfacesRunnables.get(i)).run();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        afterPrepareSurfacesRunnables.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void dumpLocked(PrintWriter pw, String prefix, boolean dumpAll) {
        String subPrefix = "  " + prefix;
        int i = 0;
    L4:
        if (i >= this.mService.mRoot.getChildCount()) goto L6;
        DisplayContent dc = this.mService.mRoot.getChildAt(i);
        pw.print(prefix);
        pw.print(dc);
        pw.println(":");
        dc.dumpWindowAnimators(pw, subPrefix);
        pw.println();
        i = i + 1;
        goto L4
    L6:
        pw.println();
        if (dumpAll == false) goto L11;
        pw.print(prefix);
        pw.print("mCurrentTime=");
        pw.println(TimeUtils.formatUptime(this.mCurrentTime));
        return;
    }

    void scheduleAnimation() {
        if (this.mAnimationFrameCallbackScheduled == true) goto L6;
        this.mAnimationFrameCallbackScheduled = true;
        this.mChoreographer.postFrameCallback(this.mAnimationFrameCallback);
    L6:
        if (this.mAnimatorSmtEx == null) goto L9;
        this.mAnimatorSmtEx.scheduleAnimationBoost();
        return;
    }

    private void cancelAnimation() {
        if (this.mAnimationFrameCallbackScheduled == false) goto L6;
        this.mAnimationFrameCallbackScheduled = false;
        this.mChoreographer.removeFrameCallback(this.mAnimationFrameCallback);
        return;
    }

    boolean isAnimationScheduled() {
        return this.mAnimationFrameCallbackScheduled;
    }

    void applyPendingTransaction() {
        Trace.traceBegin(32, "applyPendingTransaction");
        this.mPendingState = 0;
        int numDisplays = this.mService.mRoot.getChildCount();
        if (numDisplays != 1) goto L5;
        this.mService.mRoot.getChildAt(0).getPendingTransaction().apply();
    L9:
        Trace.traceEnd(32);
        return;
    L5:
        int i = 0;
    L6:
        if (i >= numDisplays) goto L8;
        this.mTransaction.merge(this.mService.mRoot.getChildAt(i).getPendingTransaction());
        i = i + 1;
        goto L6
    L8:
        this.mTransaction.apply();
        goto L9
    }

    void addAfterPrepareSurfacesRunnable(Runnable r) {
        this.mAfterPrepareSurfacesRunnables.add(r);
        scheduleAnimation();
    }
}

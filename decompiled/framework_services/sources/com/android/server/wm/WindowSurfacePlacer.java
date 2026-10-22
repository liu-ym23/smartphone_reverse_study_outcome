package com.android.server.wm;

import android.app.SysFwBridge;
import android.os.Debug;
import android.util.Slog;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class WindowSurfacePlacer {
    private static final String TAG = "WindowManager";
    private int mDeferDepth;
    private int mDeferredRequests;
    private boolean mInLayout;
    private int mLayoutRepeatCount;
    private final Traverser mPerformSurfacePlacement;
    private final WindowManagerService mService;
    private boolean mTraversalScheduled;

    private class Traverser implements Runnable {
        final /* synthetic */ WindowSurfacePlacer this$0;

        /* synthetic */ Traverser(WindowSurfacePlacer r1, WindowSurfacePlacerIA r2) {
            this(r1);
        }

        private Traverser(WindowSurfacePlacer r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            WindowManagerGlobalLock r0 = WindowSurfacePlacer.m10480$$Nest$fgetmService(this.this$0).mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.performSurfacePlacement();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m10480$$Nest$fgetmService(WindowSurfacePlacer r0) {
        return r0.mService;
    }

    WindowSurfacePlacer(WindowManagerService service) {
        this.mInLayout = false;
        this.mDeferDepth = 0;
        this.mPerformSurfacePlacement = new Traverser(this, null);
        this.mService = service;
    }

    void deferLayout() {
        this.mDeferDepth++;
    }

    void continueLayout(boolean hasChanges) {
        this.mDeferDepth--;
        if (this.mDeferDepth <= 0) goto L6;
        return;
    L6:
        if (hasChanges == true) goto L14;
        if (this.mDeferredRequests > 0) goto L14;
        if (WindowManagerDebugConfig.DEBUG == false) goto L18;
        Slog.i(TAG, "Cancel continueLayout " + Debug.getCallers(2, 3));
        return;
    L18:
        return;
    L14:
        if (WindowManagerDebugConfig.DEBUG == false) goto L16;
        Slog.i(TAG, "continueLayout hasChanges=" + hasChanges + " deferredRequests=" + this.mDeferredRequests + " " + Debug.getCallers(2, 3));
    L16:
        performSurfacePlacement();
        this.mDeferredRequests = 0;
    }

    boolean isLayoutDeferred() {
        if (this.mDeferDepth <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void performSurfacePlacementIfScheduled() {
        if (this.mTraversalScheduled == false) goto L6;
        performSurfacePlacement();
        return;
    }

    final void performSurfacePlacement() {
        performSurfacePlacement(false);
    }

    final void performSurfacePlacement(boolean force) {
        if (SysFwBridge.getFactory().getPreStartingWindowOpt().getFeatureEnableEx() == false) goto L6;
        SysFwBridge.getFactory().getPreStartingWindowOpt().prePerformSurfacePlacementEx();
    L6:
        if (this.mDeferDepth <= 0) goto L10;
        if (force == true) goto L10;
        this.mDeferredRequests++;
        return;
    L10:
        int loopCount = 6;
    L11:
        this.mTraversalScheduled = false;
        performSurfacePlacementLoop();
        this.mService.mAnimationHandler.removeCallbacks(this.mPerformSurfacePlacement);
        loopCount = loopCount - 1;
        if (this.mTraversalScheduled == false) goto L14;
        if (loopCount > 0) goto L11;
        return;
    }

    private void performSurfacePlacementLoop() {
        if (this.mInLayout == true) goto L5;
        DisplayContent defaultDisplay = this.mService.getDefaultDisplayContentLocked();
        if (defaultDisplay.mWaitingForConfig == false) goto L14;
        return;
    L14:
        if (this.mService.mDisplayReady == true) goto L16;
        return;
    L16:
        this.mInLayout = true;
        if (this.mService.mForceRemoves.isEmpty() == false) goto L19;
    L50:
        this.mService.mRoot.performSurfacePlacement();     // Catch: RuntimeException -> L38
        this.mInLayout = false;     // Catch: RuntimeException -> L38
        if (this.mService.mRoot.isLayoutNeeded() == false) goto L41;
        int r2 = this.mLayoutRepeatCount + 1;     // Catch: RuntimeException -> L38
        this.mLayoutRepeatCount = r2;     // Catch: RuntimeException -> L38
        if (r2 >= 6) goto L40;
        requestTraversal();     // Catch: RuntimeException -> L38
    L43:
        if (this.mService.mWindowsChanged == true) goto L45;
        return;
    L45:
        if (this.mService.mWindowChangeListeners.isEmpty() == true) goto L58;
        this.mService.mH.removeMessages(19);     // Catch: RuntimeException -> L38
        this.mService.mH.sendEmptyMessage(19);     // Catch: RuntimeException -> L38
        return;
    L58:
        return;
    L40:
        Slog.e(TAG, "Performed 6 layouts in a row. Skipping");     // Catch: RuntimeException -> L38
        this.mLayoutRepeatCount = 0;     // Catch: RuntimeException -> L38
        goto L43
    L41:
        this.mLayoutRepeatCount = 0;     // Catch: RuntimeException -> L38
    L38:
        e = move-exception;
        this.mInLayout = false;
        Slog.wtf(TAG, "Unhandled exception while laying out windows", e);
        return;
    L19:
        if (this.mService.mForceRemoves.isEmpty() == true) goto L21;
        WindowState ws = this.mService.mForceRemoves.remove(0);
        Slog.i(TAG, "Force removing: " + ws);
        ws.removeImmediately();
        goto L19
    L21:
        Slog.w(TAG, "Due to memory failure, waiting a bit for next layout");
        Object tmp = new Object();
        monitor-enter(tmp);
        tmp.wait(250);     // Catch: Throwable -> L26 InterruptedException -> L28
    L26:
        th = move-exception;
        throw th;
    L29:
        monitor-exit(tmp);     // Catch: Throwable -> L26
        goto L50
    L5:
        if (WindowManagerDebugConfig.DEBUG == true) goto L9;
        Slog.w(TAG, "performLayoutAndPlaceSurfacesLocked called while in layout. Callers=" + Debug.getCallers(3));
        return;
    L9:
        throw new RuntimeException("Recursive call!");
    }

    void debugLayoutRepeats(String msg, int pendingLayoutChanges) {
        if (this.mLayoutRepeatCount < 4) goto L6;
        Slog.v(TAG, "Layouts looping: " + msg + ", mPendingLayoutChanges = 0x" + Integer.toHexString(pendingLayoutChanges));
        return;
    }

    boolean isInLayout() {
        return this.mInLayout;
    }

    boolean isTraversalScheduled() {
        return this.mTraversalScheduled;
    }

    void requestTraversal() {
        if (this.mTraversalScheduled == false) goto L5;
        return;
    L5:
        this.mTraversalScheduled = true;
        if (this.mDeferDepth <= 0) goto L11;
        this.mDeferredRequests++;
        if (WindowManagerDebugConfig.DEBUG == false) goto L13;
        Slog.i(TAG, "Defer requestTraversal " + Debug.getCallers(3));
        return;
    L13:
        return;
    L11:
        this.mService.mAnimationHandler.post(this.mPerformSurfacePlacement);
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "mTraversalScheduled=" + this.mTraversalScheduled);
    }
}

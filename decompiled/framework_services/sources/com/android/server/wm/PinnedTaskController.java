package com.android.server.wm;

import android.R;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.Slog;
import android.view.IPinnedTaskListener;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class PinnedTaskController {
    private static final int DEFER_ORIENTATION_CHANGE_TIMEOUT_MS = 1000;
    private static final String TAG = "WindowManager";
    private boolean mDeferOrientationChanging;
    private final Runnable mDeferOrientationTimeoutRunnable;
    private Rect mDestRotatedBounds;
    private final DisplayContent mDisplayContent;
    private boolean mFreezingTaskConfig;
    private int mImeHeight;
    private boolean mIsImeShowing;
    private float mMaxAspectRatio;
    private float mMinAspectRatio;
    private IPinnedTaskListener mPinnedTaskListener;
    private final PinnedTaskListenerDeathHandler mPinnedTaskListenerDeathHandler;
    private final WindowManagerService mService;

    private class PinnedTaskListenerDeathHandler implements IBinder.DeathRecipient {
        final /* synthetic */ PinnedTaskController this$0;

        /* synthetic */ PinnedTaskListenerDeathHandler(PinnedTaskController r1, PinnedTaskControllerIA r2) {
            this(r1);
        }

        private PinnedTaskListenerDeathHandler(PinnedTaskController r1) {
            this.this$0 = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            WindowManagerGlobalLock r0 = PinnedTaskController.m10086$$Nest$fgetmService(this.this$0).mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            PinnedTaskController.m10088$$Nest$fputmPinnedTaskListener(this.this$0, null);     // Catch: Throwable -> L8
            PinnedTaskController.m10087$$Nest$fputmFreezingTaskConfig(this.this$0, false);     // Catch: Throwable -> L8
            PinnedTaskController.m10085$$Nest$fgetmDeferOrientationTimeoutRunnable(this.this$0).run();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-PlVbdYwxlPC-3BP3QohDV7ZXes, reason: not valid java name */
    public static /* synthetic */ boolean m10083$r8$lambda$PlVbdYwxlPC3BP3QohDV7ZXes(ActivityRecord r0) {
        return lambda$deferOrientationChangeForEnteringPipFromFullScreenIfNeeded$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$3CMWN9t4IfoPqCn_Eo-Er4q1R88, reason: not valid java name */
    public static /* synthetic */ void m10084$r8$lambda$3CMWN9t4IfoPqCn_EoEr4q1R88(PinnedTaskController r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeferOrientationTimeoutRunnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m10085$$Nest$fgetmDeferOrientationTimeoutRunnable(PinnedTaskController r0) {
        return r0.mDeferOrientationTimeoutRunnable;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m10086$$Nest$fgetmService(PinnedTaskController r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFreezingTaskConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10087$$Nest$fputmFreezingTaskConfig(PinnedTaskController r0, boolean r1) {
        r0.mFreezingTaskConfig = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPinnedTaskListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10088$$Nest$fputmPinnedTaskListener(PinnedTaskController r0, IPinnedTaskListener r1) {
        r0.mPinnedTaskListener = r1;
    }

    PinnedTaskController(WindowManagerService service, DisplayContent displayContent) {
        this.mPinnedTaskListenerDeathHandler = new PinnedTaskListenerDeathHandler(this, null);
        this.mService = service;
        this.mDisplayContent = displayContent;
        this.mDeferOrientationTimeoutRunnable = new PinnedTaskController$$ExternalSyntheticLambda0(this);
        reloadResources();
    }

    private /* synthetic */ void lambda$new$0() {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mDeferOrientationChanging == false) goto L9;
        continueOrientationChange();     // Catch: Throwable -> L7
        this.mService.mWindowPlacerLocked.requestTraversal();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    void onPostDisplayConfigurationChanged() {
        reloadResources();
        this.mFreezingTaskConfig = false;
    }

    private void reloadResources() {
        Resources res = this.mService.mContext.getResources();
        this.mMinAspectRatio = res.getFloat(R.dimen.disabled_alpha_material_dark);
        this.mMaxAspectRatio = res.getFloat(R.dimen.disabled_alpha_leanback_formwizard);
    }

    void registerPinnedTaskListener(IPinnedTaskListener listener) {
        listener.asBinder().linkToDeath(this.mPinnedTaskListenerDeathHandler, 0);     // Catch: RemoteException -> L4
        this.mPinnedTaskListener = listener;     // Catch: RemoteException -> L4
        notifyImeVisibilityChanged(this.mIsImeShowing, this.mImeHeight);     // Catch: RemoteException -> L4
        notifyMovementBoundsChanged(false);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to register pinned task listener", e);
    }

    public boolean isValidPictureInPictureAspectRatio(float aspectRatio) {
        if (Float.compare(this.mMinAspectRatio, aspectRatio) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (Float.compare(aspectRatio, this.mMaxAspectRatio) > 0) goto L7;
        return true;
    }

    public boolean isValidExpandedPictureInPictureAspectRatio(float aspectRatio) {
        if (Float.compare(this.mMinAspectRatio, aspectRatio) <= 0) goto L5;
    L8:
        return true;
    L5:
        if (Float.compare(aspectRatio, this.mMaxAspectRatio) > 0) goto L8;
        return false;
    }

    void deferOrientationChangeForEnteringPipFromFullScreenIfNeeded() {
        ActivityRecord topFullscreen = this.mDisplayContent.getActivity(new PinnedTaskController$$ExternalSyntheticLambda1());
        if (topFullscreen != null) goto L5;
        return;
    L5:
        if (topFullscreen.hasFixedRotationTransform() == true) goto L13;
        int rotation = this.mDisplayContent.rotationForActivityInDifferentOrientation(topFullscreen);
        if (rotation != (-1)) goto L10;
        return;
    L10:
        this.mDisplayContent.setFixedRotationLaunchingApp(topFullscreen, rotation);
        this.mDeferOrientationChanging = true;
        this.mService.mH.removeCallbacks(this.mDeferOrientationTimeoutRunnable);
        float animatorScale = Math.max(1.0f, this.mService.getCurrentAnimatorScale());
        this.mService.mH.postDelayed(this.mDeferOrientationTimeoutRunnable, (int) (1000.0f * animatorScale));
        return;
    }

    private static /* synthetic */ boolean lambda$deferOrientationChangeForEnteringPipFromFullScreenIfNeeded$1(ActivityRecord a) {
        if (a.providesOrientation() == true) goto L5;
    L7:
        return false;
    L5:
        if (a.getTask().inMultiWindowMode() == true) goto L7;
        return true;
    }

    boolean shouldDeferOrientationChange() {
        return this.mDeferOrientationChanging;
    }

    void setEnterPipBounds(Rect bounds) {
        if (this.mDeferOrientationChanging == true) goto L5;
        return;
    L5:
        this.mFreezingTaskConfig = true;
        this.mDestRotatedBounds = new Rect(bounds);
        if (this.mDisplayContent.mTransitionController.isShellTransitionsEnabled() == true) goto L9;
        continueOrientationChange();
        return;
    }

    void setEnterPipWithRotatedTransientLaunch() {
        this.mFreezingTaskConfig = true;
    }

    private void continueOrientationChange() {
        this.mDeferOrientationChanging = false;
        this.mService.mH.removeCallbacks(this.mDeferOrientationTimeoutRunnable);
        WindowContainer<?> orientationSource = this.mDisplayContent.getLastOrientationSource();
        if (orientationSource != null) goto L5;
        return;
    L5:
        if (orientationSource.isAppTransitioning() == true) goto L9;
        this.mDisplayContent.continueUpdateOrientationForDiffOrienLaunchingApp();
        return;
    }

    boolean isFreezingTaskConfig(Task task) {
        if (this.mFreezingTaskConfig == true) goto L5;
    L7:
        return false;
    L5:
        if (task != this.mDisplayContent.getDefaultTaskDisplayArea().getRootPinnedTask()) goto L7;
        return true;
    }

    void onCancelFixedRotationTransform() {
        this.mFreezingTaskConfig = false;
        this.mDeferOrientationChanging = false;
        this.mDestRotatedBounds = null;
    }

    void setAdjustedForIme(boolean adjustedForIme, int imeHeight) {
        int imeHeight2 = 0;
        if (adjustedForIme == false) goto L6;
        if (imeHeight <= 0) goto L6;
        boolean imeShowing = true;
    L7:
        if (imeShowing == false) goto L10;
        imeHeight2 = imeHeight;
    L10:
        if (imeShowing == this.mIsImeShowing) goto L12;
    L14:
        this.mIsImeShowing = imeShowing;
        this.mImeHeight = imeHeight2;
        notifyImeVisibilityChanged(imeShowing, imeHeight2);
        notifyMovementBoundsChanged(true);
        return;
    L12:
        if (imeHeight2 != this.mImeHeight) goto L14;
        return;
    L6:
        imeShowing = false;
        goto L7
    }

    private void notifyImeVisibilityChanged(boolean imeVisible, int imeHeight) {
        if (this.mPinnedTaskListener != null) goto L10;
        return;
    L10:
        this.mPinnedTaskListener.onImeVisibilityChanged(imeVisible, imeHeight);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Error delivering ime visibility changed event.", e);
    }

    private void notifyMovementBoundsChanged(boolean fromImeAdjustment) {
        if (this.mPinnedTaskListener != null) goto L10;
        return;
    L10:
        this.mPinnedTaskListener.onMovementBoundsChanged(fromImeAdjustment);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Error delivering movement bounds changed event.", e);
    }

    void dump(String prefix, PrintWriter pw) {
        pw.println(prefix + "PinnedTaskController");
        if (this.mDeferOrientationChanging == false) goto L6;
        pw.println(prefix + "  mDeferOrientationChanging=true");
    L6:
        if (this.mFreezingTaskConfig == false) goto L9;
        pw.println(prefix + "  mFreezingTaskConfig=true");
    L9:
        if (this.mDestRotatedBounds == null) goto L11;
        pw.println(prefix + "  mPendingBounds=" + this.mDestRotatedBounds);
    L11:
        pw.println(prefix + "  mIsImeShowing=" + this.mIsImeShowing);
        pw.println(prefix + "  mImeHeight=" + this.mImeHeight);
        pw.println(prefix + "  mMinAspectRatio=" + this.mMinAspectRatio);
        pw.println(prefix + "  mMaxAspectRatio=" + this.mMaxAspectRatio);
    }
}

package com.android.server.wm;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes3.dex */
final class DisplayRotationImmersiveAppCompatPolicy {
    private final AppCompatConfiguration mAppCompatConfiguration;
    private final DisplayContent mDisplayContent;
    private final DisplayRotation mDisplayRotation;

    /* JADX INFO: renamed from: $r8$lambda$goMWfxf-NANK8C-U8-jjfWI8u4E, reason: not valid java name */
    public static /* synthetic */ void m9981$r8$lambda$goMWfxfNANK8CU8jjfWI8u4E(DisplayRotationImmersiveAppCompatPolicy r0, WindowOrientationListener r1) {
        r0.lambda$deferOrientationUpdate$0(r1);
    }

    static DisplayRotationImmersiveAppCompatPolicy createIfNeeded(AppCompatConfiguration appCompatConfiguration, DisplayRotation displayRotation, DisplayContent displayContent) {
        if (appCompatConfiguration.isDisplayRotationImmersiveAppCompatPolicyEnabledAtBuildTime() == true) goto L7;
        return null;
    L7:
        return new DisplayRotationImmersiveAppCompatPolicy(appCompatConfiguration, displayRotation, displayContent);
    }

    private DisplayRotationImmersiveAppCompatPolicy(AppCompatConfiguration appCompatConfiguration, DisplayRotation displayRotation, DisplayContent displayContent) {
        this.mDisplayRotation = displayRotation;
        this.mAppCompatConfiguration = appCompatConfiguration;
        this.mDisplayContent = displayContent;
    }

    boolean deferOrientationUpdate() {
        if (this.mDisplayRotation.getUserRotation() == 0) goto L5;
    L18:
        return false;
    L5:
        if (this.mDisplayRotation.getLastOrientation() != (-1)) goto L18;
        final WindowOrientationListener orientationListener = this.mDisplayRotation.getOrientationListener();
        if (orientationListener != null) goto L10;
    L17:
        return false;
    L10:
        if (orientationListener.getProposedRotation() == this.mDisplayRotation.getRotation()) goto L17;
        if (this.mDisplayContent.mTransitionController.hasTransientLaunch(this.mDisplayContent) == true) goto L15;
        return false;
    L15:
        this.mDisplayContent.mTransitionController.mStateValidators.add(new DisplayRotationImmersiveAppCompatPolicy$$ExternalSyntheticLambda0(this, orientationListener));
        return true;
    }

    private /* synthetic */ void lambda$deferOrientationUpdate$0(WindowOrientationListener orientationListener) {
        if (isRotationLockEnforcedLocked(orientationListener.getProposedRotation()) == true) goto L6;
        this.mDisplayContent.mWmService.updateRotation(false, false);
        return;
    }

    boolean isRotationLockEnforced(int proposedRotation) {
        if (this.mAppCompatConfiguration.isDisplayRotationImmersiveAppCompatPolicyEnabled() == true) goto L6;
        return false;
    L6:
        WindowManagerGlobalLock r0 = this.mDisplayContent.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        boolean r1 = isRotationLockEnforcedLocked(proposedRotation);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private boolean isRotationLockEnforcedLocked(int proposedRotation) {
        if (this.mDisplayContent.getIgnoreOrientationRequest() == true) goto L5;
        return false;
    L5:
        ActivityRecord activityRecord = this.mDisplayContent.topRunningActivity();
        if (activityRecord != null) goto L9;
        return false;
    L9:
        if (hasRequestedToHideStatusAndNavBars(activityRecord) == true) goto L12;
        return false;
    L12:
        if (activityRecord.getTask() != null) goto L14;
    L26:
        return false;
    L14:
        if (activityRecord.getTask().getWindowingMode() != 1) goto L26;
        if (activityRecord.areBoundsLetterboxed() == false) goto L20;
        return false;
    L20:
        if (activityRecord.getRequestedConfigurationOrientation() != 0) goto L23;
        return false;
    L23:
        if (activityRecord.getRequestedConfigurationOrientation() != surfaceRotationToConfigurationOrientation(proposedRotation)) goto L25;
        return false;
    L25:
        return true;
    }

    private boolean hasRequestedToHideStatusAndNavBars(ActivityRecord activity) {
        WindowState mainWindow = activity.findMainWindow();
        if (mainWindow != null) goto L6;
        return false;
    L6:
        if ((mainWindow.getRequestedVisibleTypes() & (WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars())) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    private int surfaceRotationToConfigurationOrientation(int rotation) {
        if (this.mDisplayRotation.isAnyPortrait(rotation) == false) goto L7;
        return 1;
    L7:
        if (this.mDisplayRotation.isLandscapeOrSeascape(rotation) == false) goto L10;
        return 2;
    L10:
        return 0;
    }
}

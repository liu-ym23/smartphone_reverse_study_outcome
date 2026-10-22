package com.android.server.wm;

import android.content.res.Configuration;
import android.window.DesktopModeFlags;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatCameraPolicy {
    final ActivityRefresher mActivityRefresher;
    final CameraCompatFreeformPolicy mCameraCompatFreeformPolicy;
    final CameraStateMonitor mCameraStateMonitor;
    final DisplayRotationCompatPolicy mDisplayRotationCompatPolicy;

    AppCompatCameraPolicy(WindowManagerService wmService, DisplayContent displayContent) {
        boolean needsDisplayRotationCompatPolicy = wmService.mAppCompatConfiguration.isCameraCompatTreatmentEnabledAtBuildTime();
        if (DesktopModeFlags.ENABLE_CAMERA_COMPAT_SIMULATE_REQUESTED_ORIENTATION.isTrue() == true) goto L5;
    L7:
        boolean needsCameraCompatFreeformPolicy = false;
    L8:
        CameraCompatFreeformPolicy r2 = null;
        if (needsDisplayRotationCompatPolicy == true) goto L13;
        if (needsCameraCompatFreeformPolicy == true) goto L13;
        this.mDisplayRotationCompatPolicy = null;
        this.mCameraCompatFreeformPolicy = null;
        this.mCameraStateMonitor = null;
        this.mActivityRefresher = null;
        return;
    L13:
        this.mCameraStateMonitor = new CameraStateMonitor(displayContent, wmService.mH);
        this.mActivityRefresher = new ActivityRefresher(wmService, wmService.mH);
        if (needsDisplayRotationCompatPolicy == false) goto L16;
        DisplayRotationCompatPolicy r3 = new DisplayRotationCompatPolicy(displayContent, this.mCameraStateMonitor, this.mActivityRefresher);
    L17:
        this.mDisplayRotationCompatPolicy = r3;
        if (needsCameraCompatFreeformPolicy == false) goto L21;
        r2 = new CameraCompatFreeformPolicy(displayContent, this.mCameraStateMonitor, this.mActivityRefresher);
    L21:
        this.mCameraCompatFreeformPolicy = r2;
        return;
    L16:
        r3 = null;
        goto L17
    L5:
        if (DesktopModeHelper.canEnterDesktopMode(wmService.mContext) == false) goto L7;
        needsCameraCompatFreeformPolicy = true;
        goto L8
    }

    static void onActivityRefreshed(ActivityRecord activity) {
        AppCompatCameraPolicy cameraPolicy = getAppCompatCameraPolicy(activity);
        if (cameraPolicy != null) goto L5;
        return;
    L5:
        if (cameraPolicy.mActivityRefresher == null) goto L9;
        cameraPolicy.mActivityRefresher.onActivityRefreshed(activity);
        return;
    }

    static AppCompatCameraPolicy getAppCompatCameraPolicy(ActivityRecord activityRecord) {
        if (activityRecord.mDisplayContent != null) goto L7;
        return null;
    L7:
        return activityRecord.mDisplayContent.mAppCompatCameraPolicy;
    }

    static void onActivityConfigurationChanging(ActivityRecord activity, Configuration newConfig, Configuration lastReportedConfig) {
        AppCompatCameraPolicy cameraPolicy = getAppCompatCameraPolicy(activity);
        if (cameraPolicy != null) goto L5;
        return;
    L5:
        if (cameraPolicy.mActivityRefresher == null) goto L9;
        cameraPolicy.mActivityRefresher.onActivityConfigurationChanging(activity, newConfig, lastReportedConfig);
        return;
    }

    void onScreenRotationAnimationFinished() {
        if (this.mDisplayRotationCompatPolicy == null) goto L6;
        this.mDisplayRotationCompatPolicy.onScreenRotationAnimationFinished();
        return;
    }

    static boolean isActivityEligibleForOrientationOverride(ActivityRecord activity) {
        AppCompatCameraPolicy cameraPolicy = getAppCompatCameraPolicy(activity);
        if (cameraPolicy != null) goto L5;
    L9:
        return false;
    L5:
        if (cameraPolicy.mDisplayRotationCompatPolicy == null) goto L9;
        if (cameraPolicy.mDisplayRotationCompatPolicy.isActivityEligibleForOrientationOverride(activity) == false) goto L9;
        return true;
    }

    static boolean isTreatmentEnabledForActivity(ActivityRecord activity) {
        AppCompatCameraPolicy cameraPolicy = getAppCompatCameraPolicy(activity);
        if (cameraPolicy != null) goto L5;
    L9:
        return false;
    L5:
        if (cameraPolicy.mDisplayRotationCompatPolicy == null) goto L9;
        if (cameraPolicy.mDisplayRotationCompatPolicy.isTreatmentEnabledForActivity(activity) == false) goto L9;
        return true;
    }

    void start() {
        if (this.mDisplayRotationCompatPolicy == null) goto L6;
        this.mDisplayRotationCompatPolicy.start();
    L6:
        if (this.mCameraCompatFreeformPolicy == null) goto L9;
        this.mCameraCompatFreeformPolicy.start();
    L9:
        if (this.mCameraStateMonitor == null) goto L12;
        this.mCameraStateMonitor.startListeningToCameraState();
        return;
    }

    void dispose() {
        if (this.mDisplayRotationCompatPolicy == null) goto L6;
        this.mDisplayRotationCompatPolicy.dispose();
    L6:
        if (this.mCameraCompatFreeformPolicy == null) goto L9;
        this.mCameraCompatFreeformPolicy.dispose();
    L9:
        if (this.mCameraStateMonitor == null) goto L12;
        this.mCameraStateMonitor.dispose();
        return;
    }

    boolean hasDisplayRotationCompatPolicy() {
        if (this.mDisplayRotationCompatPolicy == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasCameraCompatFreeformPolicy() {
        if (this.mCameraCompatFreeformPolicy == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasCameraStateMonitor() {
        if (this.mCameraStateMonitor == null) goto L5;
        return true;
    L5:
        return false;
    }

    int getOrientation() {
        if (this.mDisplayRotationCompatPolicy != null) goto L7;
        return -1;
    L7:
        return this.mDisplayRotationCompatPolicy.getOrientation();
    }

    static boolean shouldCameraCompatControlOrientation(ActivityRecord activity) {
        AppCompatCameraPolicy cameraPolicy = getAppCompatCameraPolicy(activity);
        if (cameraPolicy != null) goto L6;
        return false;
    L6:
        if (cameraPolicy.mDisplayRotationCompatPolicy == null) goto L10;
        if (cameraPolicy.mDisplayRotationCompatPolicy.shouldCameraCompatControlOrientation(activity) == false) goto L10;
    L13:
        return true;
    L10:
        if (cameraPolicy.mCameraCompatFreeformPolicy != null) goto L12;
        return false;
    L12:
        if (cameraPolicy.mCameraCompatFreeformPolicy.shouldCameraCompatControlOrientation(activity) == true) goto L13;
        return false;
    }

    static boolean isFreeformLetterboxingForCameraAllowed(ActivityRecord activity) {
        AppCompatCameraPolicy cameraPolicy = getAppCompatCameraPolicy(activity);
        if (cameraPolicy != null) goto L6;
        return false;
    L6:
        if (cameraPolicy.mCameraCompatFreeformPolicy != null) goto L8;
        return false;
    L8:
        if (cameraPolicy.mCameraCompatFreeformPolicy.isFreeformLetterboxingForCameraAllowed(activity) == false) goto L13;
        return true;
    L13:
        return false;
    }

    static boolean shouldCameraCompatControlAspectRatio(ActivityRecord activity) {
        AppCompatCameraPolicy cameraPolicy = getAppCompatCameraPolicy(activity);
        if (cameraPolicy != null) goto L6;
        return false;
    L6:
        if (cameraPolicy.mDisplayRotationCompatPolicy == null) goto L10;
        if (cameraPolicy.mDisplayRotationCompatPolicy.shouldCameraCompatControlAspectRatio(activity) == false) goto L10;
    L13:
        return true;
    L10:
        if (cameraPolicy.mCameraCompatFreeformPolicy != null) goto L12;
        return false;
    L12:
        if (cameraPolicy.mCameraCompatFreeformPolicy.shouldCameraCompatControlAspectRatio(activity) == true) goto L13;
        return false;
    }

    private static boolean isCameraRunningAndWindowingModeEligible(ActivityRecord activity) {
        AppCompatCameraPolicy cameraPolicy = getAppCompatCameraPolicy(activity);
        if (cameraPolicy != null) goto L6;
        return false;
    L6:
        if (cameraPolicy.mDisplayRotationCompatPolicy == null) goto L10;
        if (cameraPolicy.mDisplayRotationCompatPolicy.isCameraRunningAndWindowingModeEligible(activity, true) == false) goto L10;
    L15:
        return true;
    L10:
        if (cameraPolicy.mCameraCompatFreeformPolicy != null) goto L12;
        return false;
    L12:
        if (cameraPolicy.mCameraCompatFreeformPolicy.isCameraRunningAndWindowingModeEligible(activity) == true) goto L15;
        return false;
    }

    String getSummaryForDisplayRotationHistoryRecord() {
        if (this.mDisplayRotationCompatPolicy != null) goto L7;
        return null;
    L7:
        return this.mDisplayRotationCompatPolicy.getSummaryForDisplayRotationHistoryRecord();
    }

    static float getCameraCompatMinAspectRatio(ActivityRecord activity) {
        AppCompatCameraPolicy cameraPolicy = getAppCompatCameraPolicy(activity);
        float cameraCompatFreeformPolicyAspectRatio = 1.0f;
        if (cameraPolicy != null) goto L6;
        return 1.0f;
    L6:
        if (cameraPolicy.mDisplayRotationCompatPolicy == null) goto L8;
        float displayRotationCompatPolicyAspectRatio = cameraPolicy.mDisplayRotationCompatPolicy.getCameraCompatAspectRatio(activity);
    L10:
        if (cameraPolicy.mCameraCompatFreeformPolicy == null) goto L14;
        cameraCompatFreeformPolicyAspectRatio = cameraPolicy.mCameraCompatFreeformPolicy.getCameraCompatAspectRatio(activity);
    L14:
        return Math.max(displayRotationCompatPolicyAspectRatio, cameraCompatFreeformPolicyAspectRatio);
    L8:
        displayRotationCompatPolicyAspectRatio = 1.0f;
        goto L10
    }

    static int getCameraCompatFreeformMode(ActivityRecord activity) {
        AppCompatCameraPolicy cameraPolicy = getAppCompatCameraPolicy(activity);
        if (cameraPolicy != null) goto L5;
    L7:
        return 1;
    L5:
        if (cameraPolicy.mCameraCompatFreeformPolicy == null) goto L7;
        return cameraPolicy.mCameraCompatFreeformPolicy.getCameraCompatMode(activity);
    }

    static boolean shouldOverrideMinAspectRatioForCamera(ActivityRecord activityRecord) {
        if (isCameraRunningAndWindowingModeEligible(activityRecord) == true) goto L5;
    L7:
        return false;
    L5:
        if (activityRecord.mAppCompatController.getCameraOverrides().isOverrideMinAspectRatioForCameraEnabled() == false) goto L7;
        return true;
    }
}

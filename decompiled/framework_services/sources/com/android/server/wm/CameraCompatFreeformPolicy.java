package com.android.server.wm;

import android.app.CameraCompatTaskInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.os.RemoteException;
import android.view.DisplayInfo;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;

/* JADX INFO: loaded from: classes3.dex */
final class CameraCompatFreeformPolicy implements CameraStateMonitor.CameraCompatStateListener, ActivityRefresher.Evaluator {
    private static final String TAG = "WindowManager";
    private final ActivityRefresher mActivityRefresher;
    private final CameraStateMonitor mCameraStateMonitor;
    private Task mCameraTask;
    private final DisplayContent mDisplayContent;
    private boolean mIsRunning;

    CameraCompatFreeformPolicy(DisplayContent displayContent, CameraStateMonitor cameraStateMonitor, ActivityRefresher activityRefresher) {
        this.mDisplayContent = displayContent;
        this.mCameraStateMonitor = cameraStateMonitor;
        this.mActivityRefresher = activityRefresher;
    }

    void start() {
        this.mCameraStateMonitor.addCameraStateListener(this);
        this.mActivityRefresher.addEvaluator(this);
        this.mIsRunning = true;
    }

    void dispose() {
        this.mCameraStateMonitor.removeCameraStateListener(this);
        this.mActivityRefresher.removeEvaluator(this);
        this.mIsRunning = false;
    }

    boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // com.android.server.wm.ActivityRefresher.Evaluator
    public boolean shouldRefreshActivity(ActivityRecord activity, Configuration newConfig, Configuration lastReportedConfig) {
        if (isTreatmentEnabledForActivity(activity, true) == true) goto L5;
    L7:
        return false;
    L5:
        if (haveCameraCompatAttributesChanged(newConfig, lastReportedConfig) == false) goto L7;
        return true;
    }

    private boolean haveCameraCompatAttributesChanged(Configuration newConfig, Configuration lastReportedConfig) {
        long diff = newConfig.windowConfiguration.diff(lastReportedConfig.windowConfiguration, true);
        if ((2 & diff) == 0) goto L5;
        boolean appBoundsChanged = true;
    L7:
        if ((128 & diff) == 0) goto L9;
        boolean displayRotationChanged = true;
    L10:
        if (appBoundsChanged == true) goto L15;
        if (displayRotationChanged == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return true;
    L9:
        displayRotationChanged = false;
        goto L10
    L5:
        appBoundsChanged = false;
        goto L7
    }

    @Override // com.android.server.wm.CameraStateMonitor.CameraCompatStateListener
    public void onCameraOpened(ActivityRecord cameraActivity) {
        if (isTreatmentEnabledForActivity(cameraActivity, false) == true) goto L5;
        return;
    L5:
        this.mCameraTask = cameraActivity.getTask();
        updateAndDispatchCameraConfiguration();
    }

    @Override // com.android.server.wm.CameraStateMonitor.CameraCompatStateListener
    public boolean canCameraBeClosed(String cameraId) {
        ActivityRecord topActivity = getTopActivityFromCameraTask();
        if (topActivity != null) goto L5;
    L11:
        return true;
    L5:
        if (isActivityForCameraIdRefreshing(topActivity, cameraId) == false) goto L11;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[1] == false) goto L12;
        long protoLogParam0 = this.mDisplayContent.mDisplayId;
        String protoLogParam1 = String.valueOf(cameraId);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STATES, -2283066544361882071L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
        return false;
    L12:
        return false;
    }

    @Override // com.android.server.wm.CameraStateMonitor.CameraCompatStateListener
    public void onCameraClosed() {
        ActivityRecord topActivity = getTopActivityFromCameraTask();
        if (topActivity != null) goto L5;
    L6:
        updateAndDispatchCameraConfiguration();
        this.mCameraTask = null;
        return;
    L5:
        if (this.mCameraStateMonitor.isCameraRunningForActivity(topActivity) == false) goto L6;
    }

    private void updateAndDispatchCameraConfiguration() {
        if (this.mCameraTask != null) goto L5;
        return;
    L5:
        ActivityRecord activity = getTopActivityFromCameraTask();
        if (activity == null) goto L8;
        activity.recomputeConfiguration();
        this.mCameraTask.dispatchTaskInfoChangedIfNeeded(true);
        updateCompatibilityInfo(activity);
        activity.ensureActivityConfiguration(true);
        return;
    L8:
        this.mCameraTask.dispatchTaskInfoChangedIfNeeded(true);
    }

    private void updateCompatibilityInfo(ActivityRecord activityRecord) {
        CompatibilityInfo compatibilityInfo = activityRecord.mAtmService.compatibilityInfoForPackageLocked(activityRecord.info.applicationInfo);
        compatibilityInfo.applicationDisplayRotation = CameraCompatTaskInfo.getDisplayRotationFromCameraCompatMode(getCameraCompatMode(activityRecord));
        activityRecord.app.getThread().updatePackageCompatibilityInfo(activityRecord.packageName, compatibilityInfo);     // Catch: RemoteException -> L5
        return;
    L7:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STATES_enabled[3] == false) goto L12;
        String protoLogParam0 = String.valueOf(activityRecord.app);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_STATES, -2517048921524521659L, 0, new Object[]{protoLogParam0});
        return;
    }

    boolean isFreeformLetterboxingForCameraAllowed(ActivityRecord activity) {
        return isCameraRunningAndWindowingModeEligible(activity);
    }

    boolean shouldCameraCompatControlOrientation(ActivityRecord activity) {
        return isCameraRunningAndWindowingModeEligible(activity);
    }

    boolean isCameraRunningAndWindowingModeEligible(ActivityRecord activity) {
        if (activity.mAppCompatController.getCameraOverrides().shouldApplyFreeformTreatmentForCameraCompat() == true) goto L5;
    L9:
        return false;
    L5:
        if (activity.inFreeformWindowingMode() == false) goto L9;
        if (this.mCameraStateMonitor.isCameraRunningForActivity(activity) == false) goto L9;
        return true;
    }

    boolean shouldCameraCompatControlAspectRatio(ActivityRecord activity) {
        if (isInFreeformCameraCompatMode(activity) == true) goto L5;
    L7:
        return false;
    L5:
        if (activity.mAppCompatController.getCameraOverrides().isOverrideMinAspectRatioForCameraEnabled() == true) goto L7;
        return true;
    }

    boolean isInFreeformCameraCompatMode(ActivityRecord activity) {
        if (getCameraCompatMode(activity) != 0) goto L5;
    L7:
        return false;
    L5:
        if (getCameraCompatMode(activity) == 1) goto L7;
        return true;
    }

    float getCameraCompatAspectRatio(ActivityRecord activityRecord) {
        if (shouldCameraCompatControlAspectRatio(activityRecord) == true) goto L5;
        return 1.0f;
    L5:
        return activityRecord.mWmService.mAppCompatConfiguration.getCameraCompatAspectRatio();
    }

    int getCameraCompatMode(ActivityRecord topActivity) {
        if (isTreatmentEnabledForActivity(topActivity, true) == true) goto L5;
        return 1;
    L5:
        int appOrientation = topActivity.getRequestedConfigurationOrientation();
        DisplayInfo displayInfo = topActivity.mWmService.mDisplayManagerInternal.getDisplayInfo(topActivity.getDisplayId());
        if (displayInfo.getNaturalHeight() > displayInfo.getNaturalWidth()) goto L8;
    L21:
        return 1;
    L8:
        if (appOrientation == 1) goto L10;
        if (appOrientation != 2) goto L21;
        if (isDisplayRotationPortrait(displayInfo.rotation) == false) goto L19;
        return 5;
    L19:
        return 3;
    L10:
        if (isDisplayRotationPortrait(displayInfo.rotation) == false) goto L13;
        return 4;
    L13:
        return 2;
    }

    private static boolean isDisplayRotationPortrait(int displayRotation) {
        if (displayRotation != 0) goto L4;
    L7:
        return true;
    L4:
        if (displayRotation == 2) goto L7;
        return false;
    }

    boolean isTreatmentEnabledForActivity(ActivityRecord activity, boolean checkOrientation) {
        int orientation = activity.getRequestedConfigurationOrientation();
        if (activity.mAppCompatController.getCameraOverrides().shouldApplyFreeformTreatmentForCameraCompat() == true) goto L5;
    L17:
        return false;
    L5:
        if (this.mCameraStateMonitor.isCameraRunningForActivity(activity) == false) goto L17;
        if (checkOrientation == false) goto L9;
        if (orientation == 0) goto L17;
    L9:
        if (activity.inFreeformWindowingMode() == false) goto L17;
        if (activity.getRequestedOrientation() == 5) goto L17;
        if (activity.getRequestedOrientation() == 14) goto L17;
        if (activity.isEmbedded() == true) goto L17;
        return true;
    }

    private ActivityRecord getTopActivityFromCameraTask() {
        if (this.mCameraTask != null) goto L7;
        return null;
    L7:
        return this.mCameraTask.getTopActivity(false, false);
    }

    private boolean isActivityForCameraIdRefreshing(ActivityRecord topActivity, String cameraId) {
        if (isTreatmentEnabledForActivity(topActivity, true) == true) goto L5;
        return false;
    L5:
        if (this.mCameraStateMonitor.isCameraWithIdRunningForActivity(topActivity, cameraId) == true) goto L8;
        return false;
    L8:
        return topActivity.mAppCompatController.getCameraOverrides().isRefreshRequested();
    }
}

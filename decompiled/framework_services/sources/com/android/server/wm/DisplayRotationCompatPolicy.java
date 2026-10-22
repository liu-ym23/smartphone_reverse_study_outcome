package com.android.server.wm;

import android.R;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.widget.Toast;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.UiThread;

/* JADX INFO: loaded from: classes3.dex */
final class DisplayRotationCompatPolicy implements CameraStateMonitor.CameraCompatStateListener, ActivityRefresher.Evaluator {
    private final ActivityRefresher mActivityRefresher;
    private final CameraStateMonitor mCameraStateMonitor;
    private Task mCameraTask;
    private final DisplayContent mDisplayContent;
    private boolean mIsRunning;
    private int mLastReportedOrientation;
    private final WindowManagerService mWmService;

    public static /* synthetic */ void $r8$lambda$Av6CGuCLDbwTspiKjtkFraTeB3o(DisplayRotationCompatPolicy r0, int r1, String r2) {
        r0.lambda$showToast$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$rFDLn8Ryhtmu-6HkJyhQZfSckGU, reason: not valid java name */
    public static /* synthetic */ void m9980$r8$lambda$rFDLn8Ryhtmu6HkJyhQZfSckGU(DisplayRotationCompatPolicy r0, int r1) {
        r0.lambda$showToast$0(r1);
    }

    DisplayRotationCompatPolicy(DisplayContent displayContent, CameraStateMonitor cameraStateMonitor, ActivityRefresher activityRefresher) {
        this.mLastReportedOrientation = -2;
        this.mDisplayContent = displayContent;
        this.mWmService = displayContent.mWmService;
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

    int getOrientation() {
        this.mLastReportedOrientation = getOrientationInternal();
        if (this.mLastReportedOrientation == (-1)) goto L5;
        rememberOverriddenOrientationIfNeeded();
    L7:
        return this.mLastReportedOrientation;
    L5:
        restoreOverriddenOrientationIfNeeded();
        goto L7
    }

    float getCameraCompatAspectRatio(ActivityRecord unusedActivity) {
        return 1.0f;
    }

    private synchronized int getOrientationInternal() {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (isTreatmentEnabledForDisplay() == true) goto L8;
        monitor-exit(this);
        return -1;
    L8:
        ActivityRecord topActivity = this.mDisplayContent.topRunningActivity(true);     // Catch: Throwable -> L31
        if (isTreatmentEnabledForActivity(topActivity) == true) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        int orientation = 0;
        if (topActivity.getRequestedConfigurationOrientation() != 1) goto L16;
        boolean isPortraitActivity = true;
    L18:
        if (this.mDisplayContent.getNaturalOrientation() != 1) goto L20;
        boolean isNaturalDisplayOrientationPortrait = true;
    L21:
        if (isPortraitActivity == false) goto L23;
        if (isNaturalDisplayOrientationPortrait == false) goto L23;
    L25:
        orientation = 1;
    L28:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L33;
        long protoLogParam0 = this.mDisplayContent.mDisplayId;     // Catch: Throwable -> L31
        String protoLogParam1 = String.valueOf(ActivityInfo.screenOrientationToString(orientation));     // Catch: Throwable -> L31
        boolean protoLogParam2 = isPortraitActivity;
        boolean protoLogParam3 = isNaturalDisplayOrientationPortrait;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 7429138692709430028L, 241, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1, Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3)});     // Catch: Throwable -> L31
    L33:
        monitor-exit(this);
        return orientation;
    L23:
        if (isPortraitActivity == true) goto L28;
        if (isNaturalDisplayOrientationPortrait == true) goto L28;
    L20:
        isNaturalDisplayOrientationPortrait = false;
        goto L21
    L16:
        isPortraitActivity = false;
        goto L18
    }

    void onScreenRotationAnimationFinished() {
        ActivityRecord topActivity = this.mDisplayContent.topRunningActivity(true);
        if (isTreatmentEnabledForDisplay() == true) goto L5;
        return;
    L5:
        if (isTreatmentEnabledForActivity(topActivity) == false) goto L10;
        showToast(R.string.eventTypeCustom);
        return;
    }

    String getSummaryForDisplayRotationHistoryRecord() {
        String summaryIfEnabled = "";
        if (isTreatmentEnabledForDisplay() == false) goto L10;
        ActivityRecord topActivity = this.mDisplayContent.topRunningActivity(true);
        StringBuilder r2 = new StringBuilder();
        r2.append(" mLastReportedOrientation=");
        r2.append(ActivityInfo.screenOrientationToString(this.mLastReportedOrientation));
        r2.append(" topActivity=");
        if (topActivity != null) goto L7;
        String r3 = "null";
    L8:
        r2.append(r3);
        r2.append(" isTreatmentEnabledForActivity=");
        r2.append(isTreatmentEnabledForActivity(topActivity));
        r2.append("mCameraStateMonitor=");
        r2.append(this.mCameraStateMonitor.getSummary());
        summaryIfEnabled = r2.toString();
        goto L10
    L7:
        r3 = topActivity.shortComponentName;
    L10:
        return "DisplayRotationCompatPolicy{ isTreatmentEnabledForDisplay=" + isTreatmentEnabledForDisplay() + summaryIfEnabled + " }";
    }

    private void restoreOverriddenOrientationIfNeeded() {
        if (isOrientationOverridden() == true) goto L6;
        return;
    L6:
        if (this.mDisplayContent.getRotationReversionController().revertOverride(1) == true) goto L8;
        return;
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L10;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -5176775281239247368L, 0, null);
    L10:
        this.mDisplayContent.mLastOrientationSource = null;
    }

    private boolean isOrientationOverridden() {
        return this.mDisplayContent.getRotationReversionController().isOverrideActive(1);
    }

    private void rememberOverriddenOrientationIfNeeded() {
        if (isOrientationOverridden() == true) goto L8;
        this.mDisplayContent.getRotationReversionController().beforeOverrideApplied(1);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L9;
        long protoLogParam0 = this.mDisplayContent.getLastOrientation();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -2188976047008497712L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        return;
    L9:
        return;
    }

    @Override // com.android.server.wm.ActivityRefresher.Evaluator
    public boolean shouldRefreshActivity(ActivityRecord activity, Configuration newConfig, Configuration lastReportedConfig) {
        if (newConfig.windowConfiguration.getDisplayRotation() == lastReportedConfig.windowConfiguration.getDisplayRotation()) goto L5;
        boolean displayRotationChanged = true;
    L7:
        if (isTreatmentEnabledForDisplay() == true) goto L9;
        return false;
    L9:
        if (isTreatmentEnabledForActivity(activity) == true) goto L11;
        return false;
    L11:
        if (activity.mAppCompatController.getCameraOverrides().shouldRefreshActivityForCameraCompat() == false) goto L20;
        if (displayRotationChanged == true) goto L17;
        if (activity.mAppCompatController.getCameraOverrides().isCameraCompatSplitScreenAspectRatioAllowed() == true) goto L17;
        return false;
    L17:
        return true;
    L20:
        return false;
    L5:
        displayRotationChanged = false;
        goto L7
    }

    private boolean isTreatmentEnabledForDisplay() {
        if (this.mWmService.mAppCompatConfiguration.isCameraCompatTreatmentEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mDisplayContent.getIgnoreOrientationRequest() == false) goto L9;
        if (this.mDisplayContent.getDisplay().getType() != 1) goto L9;
        return true;
    }

    boolean isActivityEligibleForOrientationOverride(ActivityRecord activity) {
        if (isTreatmentEnabledForDisplay() == true) goto L5;
    L9:
        return false;
    L5:
        if (isCameraRunningAndWindowingModeEligible(activity, true) == false) goto L9;
        if (activity.mAppCompatController.getCameraOverrides().shouldForceRotateForCameraCompat() == false) goto L9;
        return true;
    }

    boolean isTreatmentEnabledForActivity(ActivityRecord activity) {
        return isTreatmentEnabledForActivity(activity, true);
    }

    boolean shouldCameraCompatControlOrientation(ActivityRecord activity) {
        return isCameraRunningAndWindowingModeEligible(activity, true);
    }

    boolean shouldCameraCompatControlAspectRatio(ActivityRecord unusedActivity) {
        return false;
    }

    boolean isCameraRunningAndWindowingModeEligible(ActivityRecord activity, boolean mustBeFullscreen) {
        if (mustBeFullscreen == false) goto L6;
        if (activity.inMultiWindowMode() == false) goto L6;
    L8:
        return false;
    L6:
        if (this.mCameraStateMonitor.isCameraRunningForActivity(activity) == false) goto L8;
        return true;
    }

    private boolean isTreatmentEnabledForActivity(ActivityRecord activity, boolean mustBeFullscreen) {
        if (activity != null) goto L4;
    L14:
        return false;
    L4:
        if (isCameraRunningAndWindowingModeEligible(activity, mustBeFullscreen) == false) goto L14;
        if (activity.getRequestedConfigurationOrientation() == 0) goto L14;
        if (activity.getOverrideOrientation() == 5) goto L14;
        if (activity.getOverrideOrientation() == 14) goto L14;
        if (activity.mAppCompatController.getCameraOverrides().shouldForceRotateForCameraCompat() == false) goto L14;
        return true;
    }

    @Override // com.android.server.wm.CameraStateMonitor.CameraCompatStateListener
    public void onCameraOpened(ActivityRecord cameraActivity) {
        this.mCameraTask = cameraActivity.getTask();
        if (cameraActivity.getWindowingMode() != 1) goto L7;
        recomputeConfigurationForCameraCompatIfNeeded(cameraActivity);
        this.mDisplayContent.updateOrientation();
        return;
    L7:
        if (this.mCameraTask != null) goto L9;
        return;
    L9:
        if (this.mCameraTask.getWindowingMode() == 6) goto L11;
        return;
    L11:
        if (isTreatmentEnabledForActivity(cameraActivity, false) == false) goto L24;
        PackageManager packageManager = this.mWmService.mContext.getPackageManager();
        showToast(R.string.eventTypeOther, (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(cameraActivity.packageName, 0)));     // Catch: PackageManager.NameNotFoundException -> L15
        return;
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[4] == false) goto L25;
        String protoLogParam0 = String.valueOf(cameraActivity.packageName);
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -1534784331886673955L, 0, new Object[]{protoLogParam0});
        return;
    L25:
        return;
    }

    void showToast(final int stringRes) {
        UiThread.getHandler().post(new DisplayRotationCompatPolicy$$ExternalSyntheticLambda0(this, stringRes));
    }

    private /* synthetic */ void lambda$showToast$0(int stringRes) {
        Toast.makeText(this.mWmService.mContext, stringRes, 1).show();
    }

    void showToast(final int stringRes, final String applicationLabel) {
        UiThread.getHandler().post(new DisplayRotationCompatPolicy$$ExternalSyntheticLambda1(this, stringRes, applicationLabel));
    }

    private /* synthetic */ void lambda$showToast$1(int stringRes, String applicationLabel) {
        Toast.makeText(this.mWmService.mContext, this.mWmService.mContext.getString(stringRes, new Object[]{applicationLabel}), 1).show();
    }

    @Override // com.android.server.wm.CameraStateMonitor.CameraCompatStateListener
    public boolean canCameraBeClosed(String cameraId) {
        ActivityRecord topActivity = getTopActivity();
        if (topActivity != null) goto L5;
        return true;
    L5:
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (isActivityForCameraIdRefreshing(topActivity, cameraId) == true) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L11
        return true;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L13;
        long protoLogParam0 = this.mDisplayContent.mDisplayId;     // Catch: Throwable -> L11
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -5121743609317543819L, 1, new Object[]{Long.valueOf(protoLogParam0)});     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L11
        return false;
    }

    @Override // com.android.server.wm.CameraStateMonitor.CameraCompatStateListener
    public void onCameraClosed() {
        ActivityRecord topActivity = getTopActivity();
        if (topActivity != null) goto L5;
    L6:
        this.mCameraTask = null;
    L7:
        if (topActivity != null) goto L10;
        return;
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L13;
        long protoLogParam0 = this.mDisplayContent.mDisplayId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 1769752961776628557L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L13:
        if (topActivity.getWindowingMode() == 1) goto L15;
        return;
    L15:
        recomputeConfigurationForCameraCompatIfNeeded(topActivity);
        this.mDisplayContent.updateOrientation();
        return;
    L5:
        if (this.mCameraStateMonitor.isCameraRunningForActivity(topActivity) == true) goto L7;
        goto L6
    }

    private boolean isActivityForCameraIdRefreshing(ActivityRecord activity, String cameraId) {
        if (isTreatmentEnabledForActivity(activity) == true) goto L5;
        return false;
    L5:
        if (this.mCameraStateMonitor.isCameraWithIdRunningForActivity(activity, cameraId) == true) goto L8;
        return false;
    L8:
        return this.mActivityRefresher.isActivityRefreshing(activity);
    }

    private void recomputeConfigurationForCameraCompatIfNeeded(ActivityRecord activityRecord) {
        if (shouldRecomputeConfigurationForCameraCompat(activityRecord) == false) goto L6;
        activityRecord.recomputeConfiguration();
        return;
    }

    private ActivityRecord getTopActivity() {
        return this.mDisplayContent.topRunningActivity(true);
    }

    private boolean shouldRecomputeConfigurationForCameraCompat(ActivityRecord activityRecord) {
        AppCompatCameraOverrides overrides = activityRecord.mAppCompatController.getCameraOverrides();
        if (overrides.isOverrideOrientationOnlyForCameraEnabled() == false) goto L5;
    L10:
        return true;
    L5:
        if (overrides.isCameraCompatSplitScreenAspectRatioAllowed() == true) goto L10;
        if (shouldOverrideMinAspectRatio(activityRecord) == true) goto L10;
        return false;
    }

    private boolean shouldOverrideMinAspectRatio(ActivityRecord activityRecord) {
        if (activityRecord.mAppCompatController.getCameraOverrides().isOverrideMinAspectRatioForCameraEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (isCameraRunningAndWindowingModeEligible(activityRecord, true) == false) goto L7;
        return true;
    }
}

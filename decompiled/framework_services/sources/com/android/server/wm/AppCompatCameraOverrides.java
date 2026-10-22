package com.android.server.wm;

import android.window.DesktopModeFlags;
import com.android.server.wm.utils.OptPropFactory;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatCameraOverrides {
    private static final String TAG = "ActivityTaskManager";
    private final ActivityRecord mActivityRecord;
    private final OptPropFactory.OptProp mAllowMinAspectRatioOverrideOptProp;
    private final AppCompatCameraOverridesState mAppCompatCameraOverridesState;
    private final AppCompatConfiguration mAppCompatConfiguration;
    private final OptPropFactory.OptProp mCameraCompatAllowForceRotationOptProp;
    private final OptPropFactory.OptProp mCameraCompatAllowOrientationTreatmentOptProp;
    private final OptPropFactory.OptProp mCameraCompatAllowRefreshOptProp;
    private final OptPropFactory.OptProp mCameraCompatEnableRefreshViaPauseOptProp;

    static class AppCompatCameraOverridesState {
        private boolean mIsRefreshRequested;

        /* JADX INFO: renamed from: -$$Nest$fgetmIsRefreshRequested, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9710$$Nest$fgetmIsRefreshRequested(AppCompatCameraOverridesState r0) {
            return r0.mIsRefreshRequested;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIsRefreshRequested, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9711$$Nest$fputmIsRefreshRequested(AppCompatCameraOverridesState r0, boolean r1) {
            r0.mIsRefreshRequested = r1;
        }

        AppCompatCameraOverridesState() {
        }
    }

    AppCompatCameraOverrides(ActivityRecord activityRecord, AppCompatConfiguration appCompatConfiguration, OptPropFactory optPropBuilder) {
        this.mActivityRecord = activityRecord;
        this.mAppCompatConfiguration = appCompatConfiguration;
        this.mAppCompatCameraOverridesState = new AppCompatCameraOverridesState();
        this.mAllowMinAspectRatioOverrideOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_ALLOW_MIN_ASPECT_RATIO_OVERRIDE");
        final AppCompatConfiguration r0 = this.mAppCompatConfiguration;
        r0.getClass();
        BooleanSupplier isCameraCompatTreatmentEnabled = AppCompatUtils.asLazy(new AppCompatCameraOverrides$$ExternalSyntheticLambda0(r0));
        this.mCameraCompatAllowRefreshOptProp = optPropBuilder.create("android.window.PROPERTY_CAMERA_COMPAT_ALLOW_REFRESH", isCameraCompatTreatmentEnabled);
        this.mCameraCompatEnableRefreshViaPauseOptProp = optPropBuilder.create("android.window.PROPERTY_CAMERA_COMPAT_ENABLE_REFRESH_VIA_PAUSE", isCameraCompatTreatmentEnabled);
        this.mCameraCompatAllowForceRotationOptProp = optPropBuilder.create("android.window.PROPERTY_CAMERA_COMPAT_ALLOW_FORCE_ROTATION", isCameraCompatTreatmentEnabled);
        this.mCameraCompatAllowOrientationTreatmentOptProp = optPropBuilder.create("android.window.PROPERTY_CAMERA_COMPAT_ALLOW_SIMULATE_REQUESTED_ORIENTATION", isCameraCompatTreatmentEnabled);
    }

    boolean isOverrideMinAspectRatioForCameraEnabled() {
        return this.mAllowMinAspectRatioOverrideOptProp.shouldEnableWithOptInOverrideAndOptOutProperty(AppCompatUtils.isChangeEnabled(this.mActivityRecord, 325586858));
    }

    boolean shouldRefreshActivityForCameraCompat() {
        return this.mCameraCompatAllowRefreshOptProp.shouldEnableWithOptOutOverrideAndProperty(AppCompatUtils.isChangeEnabled(this.mActivityRecord, 264304459));
    }

    boolean shouldRefreshActivityViaPauseForCameraCompat() {
        return this.mCameraCompatEnableRefreshViaPauseOptProp.shouldEnableWithOverrideAndProperty(AppCompatUtils.isChangeEnabled(this.mActivityRecord, 264301586));
    }

    boolean shouldForceRotateForCameraCompat() {
        return this.mCameraCompatAllowForceRotationOptProp.shouldEnableWithOptOutOverrideAndProperty(AppCompatUtils.isChangeEnabled(this.mActivityRecord, 263959004));
    }

    boolean shouldApplyFreeformTreatmentForCameraCompat() {
        if (DesktopModeFlags.ENABLE_CAMERA_COMPAT_SIMULATE_REQUESTED_ORIENTATION.isTrue() == true) goto L5;
    L9:
        return false;
    L5:
        if (shouldEnableCameraCompatFreeformTreatmentForApp() == false) goto L7;
    L8:
        return true;
    L7:
        if (shouldEnableCameraCompatFreeformTreatmentForAllApps() == false) goto L9;
        goto L8
    }

    private boolean shouldEnableCameraCompatFreeformTreatmentForApp() {
        if (this.mCameraCompatAllowOrientationTreatmentOptProp == null) goto L7;
        return this.mCameraCompatAllowOrientationTreatmentOptProp.shouldEnableWithOptOutOverrideAndProperty(AppCompatUtils.isChangeEnabled(this.mActivityRecord, 398195815));
    L7:
        return AppCompatUtils.isChangeEnabled(this.mActivityRecord, 314961188);
    }

    private boolean shouldEnableCameraCompatFreeformTreatmentForAllApps() {
        return this.mActivityRecord.mWmService.mAppCompatConfiguration.isCameraCompatFreeformWindowingTreatmentEnabled();
    }

    boolean isOverrideOrientationOnlyForCameraEnabled() {
        return AppCompatUtils.isChangeEnabled(this.mActivityRecord, 265456536);
    }

    boolean isRefreshRequested() {
        return AppCompatCameraOverridesState.m9710$$Nest$fgetmIsRefreshRequested(this.mAppCompatCameraOverridesState);
    }

    void setIsRefreshRequested(boolean isRequested) {
        AppCompatCameraOverridesState.m9711$$Nest$fputmIsRefreshRequested(this.mAppCompatCameraOverridesState, isRequested);
    }

    boolean isCameraCompatSplitScreenAspectRatioAllowed() {
        if (this.mAppCompatConfiguration.isCameraCompatSplitScreenAspectRatioEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mActivityRecord.shouldCreateAppCompatDisplayInsets() == true) goto L7;
        return true;
    }
}

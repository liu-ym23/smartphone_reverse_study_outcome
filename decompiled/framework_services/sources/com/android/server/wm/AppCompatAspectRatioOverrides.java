package com.android.server.wm;

import android.R;
import android.content.pm.ActivityInfo;
import android.content.pm.IPackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.wm.utils.OptPropFactory;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatAspectRatioOverrides {
    private static final String TAG = "ActivityTaskManager";
    private final ActivityRecord mActivityRecord;
    private final OptPropFactory.OptProp mAllowMinAspectRatioOverrideOptProp;
    private final OptPropFactory.OptProp mAllowOrientationOverrideOptProp;
    private final OptPropFactory.OptProp mAllowUserAspectRatioFullscreenOverrideOptProp;
    private final OptPropFactory.OptProp mAllowUserAspectRatioOverrideOptProp;
    private final AppCompatConfiguration mAppCompatConfiguration;
    private final AppCompatDeviceStateQuery mAppCompatDeviceStateQuery;
    private final AppCompatReachabilityOverrides mAppCompatReachabilityOverrides;
    private final UserAspectRatioState mUserAspectRatioState;

    private static class UserAspectRatioState {
        private boolean mHasBeenSet;
        private int mUserAspectRatio;

        /* JADX INFO: renamed from: -$$Nest$fgetmUserAspectRatio, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9704$$Nest$fgetmUserAspectRatio(UserAspectRatioState r0) {
            return r0.mUserAspectRatio;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetUserAspectRatio, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9705$$Nest$mgetUserAspectRatio(UserAspectRatioState r0, ActivityRecord r1) {
            return r0.getUserAspectRatio(r1);
        }

        /* synthetic */ UserAspectRatioState(AppCompatAspectRatioOverridesIA r1) {
            this();
        }

        private UserAspectRatioState() {
            this.mUserAspectRatio = 0;
            this.mHasBeenSet = false;
        }

        private int getUserAspectRatio(ActivityRecord activityRecord) {
            if (this.mHasBeenSet == true) goto L13;
            IPackageManager pm = activityRecord.mAtmService.getPackageManager();     // Catch: RemoteException -> L8
            if (pm == null) goto L13;
            this.mUserAspectRatio = pm.getUserMinAspectRatio(activityRecord.packageName, activityRecord.mUserId);     // Catch: RemoteException -> L8
            this.mHasBeenSet = true;     // Catch: RemoteException -> L8
        L8:
            e = move-exception;
            Slog.w(AppCompatAspectRatioOverrides.TAG, "Exception thrown retrieving aspect ratio user override " + this, e);
        L13:
            return this.mUserAspectRatio;
        }
    }

    AppCompatAspectRatioOverrides(ActivityRecord activityRecord, AppCompatConfiguration appCompatConfiguration, OptPropFactory optPropBuilder, AppCompatDeviceStateQuery appCompatDeviceStateQuery, AppCompatReachabilityOverrides appCompatReachabilityOverrides) {
        this.mActivityRecord = activityRecord;
        this.mAppCompatConfiguration = appCompatConfiguration;
        this.mAppCompatDeviceStateQuery = appCompatDeviceStateQuery;
        this.mUserAspectRatioState = new UserAspectRatioState(null);
        this.mAppCompatReachabilityOverrides = appCompatReachabilityOverrides;
        this.mAllowMinAspectRatioOverrideOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_ALLOW_MIN_ASPECT_RATIO_OVERRIDE");
        final AppCompatConfiguration r0 = this.mAppCompatConfiguration;
        r0.getClass();
        this.mAllowUserAspectRatioOverrideOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_ALLOW_USER_ASPECT_RATIO_OVERRIDE", new AppCompatAspectRatioOverrides$$ExternalSyntheticLambda0(r0));
        final AppCompatConfiguration r1 = this.mAppCompatConfiguration;
        r1.getClass();
        this.mAllowUserAspectRatioFullscreenOverrideOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_ALLOW_USER_ASPECT_RATIO_FULLSCREEN_OVERRIDE", new AppCompatAspectRatioOverrides$$ExternalSyntheticLambda1(r1));
        this.mAllowOrientationOverrideOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_ALLOW_ORIENTATION_OVERRIDE");
    }

    boolean shouldOverrideMinAspectRatio() {
        return this.mAllowMinAspectRatioOverrideOptProp.shouldEnableWithOptInOverrideAndOptOutProperty(AppCompatUtils.isChangeEnabled(this.mActivityRecord, 174042980));
    }

    boolean shouldApplyUserMinAspectRatioOverride() {
        if (shouldEnableUserAspectRatioSettings() == true) goto L5;
        return false;
    L5:
        int aspectRatio = getUserMinAspectRatioOverrideCode();
        if (aspectRatio != 0) goto L8;
        return false;
    L8:
        if (aspectRatio != 7) goto L10;
        return false;
    L10:
        if (aspectRatio == 6) goto L15;
        return true;
    L15:
        return false;
    }

    boolean userPreferenceCompatibleWithNonResizability() {
        int aspectRatio = getUserMinAspectRatioOverrideCode();
        if (aspectRatio != 0) goto L5;
    L8:
        return true;
    L5:
        if (aspectRatio == 6) goto L8;
        return false;
    }

    boolean shouldApplyUserFullscreenOverride() {
        if (isUserFullscreenOverrideEnabled() == false) goto L8;
        int aspectRatio = getUserMinAspectRatioOverrideCode();
        if (aspectRatio != 6) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    boolean isUserFullscreenOverrideEnabled() {
        if (this.mAllowUserAspectRatioOverrideOptProp.isFalse() == false) goto L5;
        return false;
    L5:
        if (this.mAllowUserAspectRatioFullscreenOverrideOptProp.isFalse() == false) goto L7;
        return false;
    L7:
        if (this.mAppCompatConfiguration.isUserAppAspectRatioFullscreenEnabled() == false) goto L14;
        return true;
    L14:
        return false;
    }

    boolean isSystemOverrideToFullscreenEnabled() {
        int aspectRatio = getUserMinAspectRatioOverrideCode();
        if (AppCompatUtils.isChangeEnabled(this.mActivityRecord, 310816437) == true) goto L5;
    L10:
        return false;
    L5:
        if (this.mAllowOrientationOverrideOptProp.isFalse() == true) goto L10;
        if (aspectRatio != 0) goto L8;
    L9:
        return true;
    L8:
        if (aspectRatio != 6) goto L10;
        goto L9
    }

    boolean shouldEnableUserAspectRatioSettings() {
        if (this.mAllowUserAspectRatioOverrideOptProp.isFalse() == false) goto L5;
    L11:
        return false;
    L5:
        if (this.mAppCompatConfiguration.isUserAppAspectRatioSettingsEnabled() == false) goto L11;
        if (this.mActivityRecord.mDisplayContent == null) goto L11;
        if (this.mActivityRecord.mDisplayContent.getIgnoreOrientationRequest() == false) goto L11;
        return true;
    }

    boolean hasFullscreenOverride() {
        if (shouldApplyUserFullscreenOverride() == false) goto L5;
    L10:
        return true;
    L5:
        if (isSystemOverrideToFullscreenEnabled() == true) goto L10;
        if (shouldIgnoreActivitySizeRestrictionsForDisplay() == true) goto L10;
        return false;
    }

    boolean shouldIgnoreActivitySizeRestrictionsForDisplay() {
        if (AppCompatUtils.isDisplayIgnoreActivitySizeRestrictions(this.mActivityRecord) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAllowOrientationOverrideOptProp.isFalse() == true) goto L7;
        return true;
    }

    float getUserMinAspectRatio() {
        switch(getUserMinAspectRatioOverrideCode()) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        return 1.5f;
    L8:
        return 1.7777778f;
    L10:
        return 1.3333334f;
    L5:
        throw new AssertionError("Unexpected user min aspect ratio override: " + UserAspectRatioState.m9704$$Nest$fgetmUserAspectRatio(this.mUserAspectRatioState));
    L13:
        return getDisplaySizeMinAspectRatio();
    L15:
        return getSplitScreenAspectRatio();
    }

    float getSplitScreenAspectRatio() {
        DisplayArea displayArea = this.mActivityRecord.getDisplayArea();
        if (displayArea == null) goto L5;
        int dividerWindowWidth = getResources().getDimensionPixelSize(R.dimen.kg_runway_lights_top_margin);
        int dividerInsets = getResources().getDimensionPixelSize(R.dimen.kg_runway_lights_height);
        int dividerSize = dividerWindowWidth - (dividerInsets * 2);
        Rect bounds = new Rect(displayArea.getWindowConfiguration().getAppBounds());
        if (bounds.width() < bounds.height()) goto L9;
        bounds.inset(dividerSize / 2, 0);
        bounds.right = bounds.centerX();
    L11:
        return AppCompatUtils.computeAspectRatio(bounds);
    L9:
        bounds.inset(0, dividerSize / 2);
        bounds.bottom = bounds.centerY();
        goto L11
    L5:
        return getDefaultMinAspectRatioForUnresizableApps();
    }

    float getFixedOrientationLetterboxAspectRatio(Configuration parentConfiguration) {
        if (shouldUseSplitScreenAspectRatio(parentConfiguration) == false) goto L6;
        return getSplitScreenAspectRatio();
    L6:
        if (this.mActivityRecord.shouldCreateAppCompatDisplayInsets() == false) goto L9;
        return getDefaultMinAspectRatioForUnresizableApps();
    L9:
        return getDefaultMinAspectRatio();
    }

    float getDefaultMinAspectRatioForUnresizableAppsFromConfig() {
        return this.mAppCompatConfiguration.getDefaultMinAspectRatioForUnresizableApps();
    }

    boolean isSplitScreenAspectRatioForUnresizableAppsEnabled() {
        return this.mAppCompatConfiguration.getIsSplitScreenAspectRatioForUnresizableAppsEnabled();
    }

    float getDisplaySizeMinAspectRatio() {
        DisplayArea displayArea = this.mActivityRecord.getDisplayArea();
        if (displayArea == null) goto L5;
        Rect bounds = new Rect(displayArea.getWindowConfiguration().getAppBounds());
        return AppCompatUtils.computeAspectRatio(bounds);
    L5:
        return this.mActivityRecord.info.getMinAspectRatio();
    }

    private boolean shouldUseSplitScreenAspectRatio(Configuration parentConfiguration) {
        boolean isBookMode = this.mAppCompatDeviceStateQuery.isDisplayFullScreenAndInPosture(false);
        if (this.mAppCompatReachabilityOverrides.getHorizontalPositionMultiplier(parentConfiguration) == 0.5f) goto L5;
        boolean isNotCenteredHorizontally = true;
    L6:
        boolean isTabletopMode = this.mAppCompatDeviceStateQuery.isDisplayFullScreenAndInPosture(true);
        boolean isLandscape = ActivityInfo.isFixedOrientationLandscape(this.mActivityRecord.getOverrideOrientation());
        AppCompatCameraOverrides cameraOverrides = this.mActivityRecord.mAppCompatController.getCameraOverrides();
        if (isBookMode == false) goto L9;
        if (isNotCenteredHorizontally == false) goto L9;
    L17:
        return true;
    L9:
        if (isTabletopMode == false) goto L12;
        if (isLandscape == true) goto L17;
    L12:
        if (cameraOverrides.isCameraCompatSplitScreenAspectRatioAllowed() == true) goto L14;
        return false;
    L14:
        if (AppCompatCameraPolicy.isTreatmentEnabledForActivity(this.mActivityRecord) == true) goto L17;
        return false;
    L5:
        isNotCenteredHorizontally = false;
        goto L6
    }

    boolean getAllowUserAspectRatioOverridePropertyValue() {
        return !this.mAllowUserAspectRatioOverrideOptProp.isFalse();
    }

    int getUserMinAspectRatioOverrideCode() {
        return UserAspectRatioState.m9705$$Nest$mgetUserAspectRatio(this.mUserAspectRatioState, this.mActivityRecord);
    }

    private float getDefaultMinAspectRatioForUnresizableApps() {
        if (this.mAppCompatConfiguration.getIsSplitScreenAspectRatioForUnresizableAppsEnabled() == false) goto L10;
        if (this.mActivityRecord.getDisplayArea() == null) goto L10;
        return getSplitScreenAspectRatio();
    L10:
        if (this.mAppCompatConfiguration.getDefaultMinAspectRatioForUnresizableApps() <= 1.0f) goto L13;
        return this.mAppCompatConfiguration.getDefaultMinAspectRatioForUnresizableApps();
    L13:
        return getDefaultMinAspectRatio();
    }

    float getDefaultMinAspectRatio() {
        if (this.mActivityRecord.getDisplayArea() == null) goto L10;
        if (this.mAppCompatConfiguration.getIsDisplayAspectRatioEnabledForFixedOrientationLetterbox() == false) goto L10;
        return getDisplaySizeMinAspectRatio();
    L10:
        return this.mAppCompatConfiguration.getFixedOrientationLetterboxAspectRatio();
    }

    private Resources getResources() {
        return this.mActivityRecord.mWmService.mContext.getResources();
    }
}

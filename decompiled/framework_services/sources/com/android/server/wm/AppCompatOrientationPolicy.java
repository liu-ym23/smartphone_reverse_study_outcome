package com.android.server.wm;

import android.content.pm.ActivityInfo;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatOrientationPolicy {
    private static final String TAG = "ActivityTaskManager";
    private final ActivityRecord mActivityRecord;
    private final AppCompatOverrides mAppCompatOverrides;

    AppCompatOrientationPolicy(ActivityRecord activityRecord, AppCompatOverrides appCompatOverrides) {
        this.mActivityRecord = activityRecord;
        this.mAppCompatOverrides = appCompatOverrides;
    }

    int overrideOrientationIfNeeded(int candidate) {
        AppCompatAspectRatioOverrides aspectRatioOverrides = this.mAppCompatOverrides.getAspectRatioOverrides();
        if (aspectRatioOverrides.shouldIgnoreActivitySizeRestrictionsForDisplay() == false) goto L5;
        return 2;
    L5:
        DisplayContent displayContent = this.mActivityRecord.mDisplayContent;
        if (displayContent != null) goto L8;
    L10:
        boolean isIgnoreOrientationRequestEnabled = false;
    L11:
        boolean hasFullscreenOverride = aspectRatioOverrides.hasFullscreenOverride();
        boolean shouldCameraCompatControlOrientation = AppCompatCameraPolicy.shouldCameraCompatControlOrientation(this.mActivityRecord);
        if (hasFullscreenOverride == false) goto L21;
        if (isIgnoreOrientationRequestEnabled == false) goto L21;
        if (ActivityInfo.isFixedOrientationLandscape(candidate) == false) goto L17;
    L18:
        if (shouldCameraCompatControlOrientation == true) goto L21;
        Slog.v(TAG, "Requested orientation " + ActivityInfo.screenOrientationToString(candidate) + " for " + this.mActivityRecord + " is overridden to " + ActivityInfo.screenOrientationToString(2));
        return 2;
    L17:
        if (ActivityInfo.isFixedOrientationPortrait(candidate) == true) goto L18;
    L21:
        int candidate2 = this.mActivityRecord.mWmService.mapOrientationRequest(candidate);
        boolean shouldApplyUserMinAspectRatioOverride = aspectRatioOverrides.shouldApplyUserMinAspectRatioOverride();
        if (shouldApplyUserMinAspectRatioOverride == false) goto L30;
        if (ActivityInfo.isFixedOrientation(candidate2) == true) goto L26;
    L27:
        Slog.v(TAG, "Requested orientation " + ActivityInfo.screenOrientationToString(candidate2) + " for " + this.mActivityRecord + " is overridden to " + ActivityInfo.screenOrientationToString(1) + " by user aspect ratio settings.");
        return 1;
    L26:
        if (candidate2 == 14) goto L27;
    L30:
        if (this.mAppCompatOverrides.getOrientationOverrides().isAllowOrientationOverrideOptOut() == false) goto L33;
        return candidate2;
    L33:
        if (displayContent != null) goto L35;
    L39:
        AppCompatOrientationOverrides.OrientationOverridesState capabilityState = this.mAppCompatOverrides.getOrientationOverrides().mOrientationOverridesState;
        if (capabilityState.mIsOverrideToReverseLandscapeOrientationEnabled == false) goto L48;
        if (ActivityInfo.isFixedOrientationLandscape(candidate2) == false) goto L44;
    L45:
        Slog.w(TAG, "Requested orientation  " + ActivityInfo.screenOrientationToString(candidate2) + " for " + this.mActivityRecord + " is overridden to " + ActivityInfo.screenOrientationToString(8));
        return 8;
    L44:
        if (capabilityState.mIsOverrideAnyOrientationEnabled == true) goto L45;
    L48:
        if (capabilityState.mIsOverrideAnyOrientationEnabled == true) goto L53;
        if (ActivityInfo.isFixedOrientation(candidate2) == false) goto L53;
        return candidate2;
    L53:
        if (capabilityState.mIsOverrideToPortraitOrientationEnabled == false) goto L57;
        Slog.w(TAG, "Requested orientation  " + ActivityInfo.screenOrientationToString(candidate2) + " for " + this.mActivityRecord + " is overridden to " + ActivityInfo.screenOrientationToString(1));
        return 1;
    L57:
        if (capabilityState.mIsOverrideToNosensorOrientationEnabled == false) goto L60;
        Slog.w(TAG, "Requested orientation  " + ActivityInfo.screenOrientationToString(candidate2) + " for " + this.mActivityRecord + " is overridden to " + ActivityInfo.screenOrientationToString(5));
        return 5;
    L60:
        return candidate2;
    L35:
        if (this.mAppCompatOverrides.getCameraOverrides().isOverrideOrientationOnlyForCameraEnabled() == false) goto L39;
        if (AppCompatCameraPolicy.isActivityEligibleForOrientationOverride(this.mActivityRecord) == true) goto L39;
        return candidate2;
    L8:
        if (displayContent.getIgnoreOrientationRequest() == false) goto L10;
        isIgnoreOrientationRequestEnabled = true;
        goto L11
    }

    boolean shouldIgnoreRequestedOrientation(int requestedOrientation) {
        AppCompatOrientationOverrides orientationOverrides = this.mAppCompatOverrides.getOrientationOverrides();
        if (orientationOverrides.shouldEnableIgnoreOrientationRequest() == false) goto L13;
        if (orientationOverrides.getIsRelaunchingAfterRequestedOrientationChanged() == false) goto L9;
        Slog.w(TAG, "Ignoring orientation update to " + ActivityInfo.screenOrientationToString(requestedOrientation) + " due to relaunching after setRequestedOrientation for " + this.mActivityRecord);
        return true;
    L9:
        if (AppCompatCameraPolicy.isTreatmentEnabledForActivity(this.mActivityRecord) == false) goto L13;
        Slog.w(TAG, "Ignoring orientation update to " + ActivityInfo.screenOrientationToString(requestedOrientation) + " due to camera compat treatment for " + this.mActivityRecord);
        return true;
    L13:
        if (orientationOverrides.shouldIgnoreOrientationRequestLoop() == false) goto L16;
        Slog.w(TAG, "Ignoring orientation update to " + ActivityInfo.screenOrientationToString(requestedOrientation) + " as orientation request loop was detected for " + this.mActivityRecord);
        return true;
    L16:
        return false;
    }
}

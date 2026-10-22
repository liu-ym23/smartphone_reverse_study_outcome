package com.android.server.wm;

import android.R;
import android.app.WindowConfiguration;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
public class DesktopAppCompatAspectRatioPolicy {
    private final ActivityRecord mActivityRecord;
    private final AppCompatConfiguration mAppCompatConfiguration;
    private final AppCompatOverrides mAppCompatOverrides;
    private final TransparentPolicy mTransparentPolicy;

    DesktopAppCompatAspectRatioPolicy(ActivityRecord activityRecord, AppCompatOverrides appCompatOverrides, TransparentPolicy transparentPolicy, AppCompatConfiguration appCompatConfiguration) {
        this.mActivityRecord = activityRecord;
        this.mAppCompatOverrides = appCompatOverrides;
        this.mTransparentPolicy = transparentPolicy;
        this.mAppCompatConfiguration = appCompatConfiguration;
    }

    float calculateAspectRatio(Task task, boolean hasOrientationMismatch) {
        float maxAspectRatio = getMaxAspectRatio();
        float minAspectRatio = getMinAspectRatio(task);
        float desiredAspectRatio = getDesiredAspectRatio(task, hasOrientationMismatch);
        if (maxAspectRatio < 1.0f) goto L8;
        if (desiredAspectRatio <= maxAspectRatio) goto L8;
        return maxAspectRatio;
    L8:
        if (minAspectRatio >= 1.0f) goto L10;
        return desiredAspectRatio;
    L10:
        if (desiredAspectRatio < minAspectRatio) goto L12;
        return desiredAspectRatio;
    L12:
        return minAspectRatio;
    }

    float getDesiredAspectRatio(Task task, boolean hasOrientationMismatch) {
        float letterboxAspectRatioOverride = getFixedOrientationLetterboxAspectRatio(task);
        if (isDefaultMultiWindowLetterboxAspectRatioDesired(task) == false) goto L6;
        return 1.01f;
    L6:
        if (hasOrientationMismatch == false) goto L11;
        if (letterboxAspectRatioOverride <= 1.0f) goto L11;
        return letterboxAspectRatioOverride;
    L11:
        return AppCompatUtils.computeAspectRatio(task.getDisplayArea().getBounds());
    }

    private float getFixedOrientationLetterboxAspectRatio(Task task) {
        if (this.mActivityRecord.shouldCreateAppCompatDisplayInsets() == false) goto L6;
        return getDefaultMinAspectRatioForUnresizableApps(task);
    L6:
        return getDefaultMinAspectRatio(task);
    }

    private float getSplitScreenAspectRatio(Task task) {
        DisplayArea displayArea = task.getDisplayArea();
        int dividerWindowWidth = this.mActivityRecord.mWmService.mContext.getResources().getDimensionPixelSize(R.dimen.kg_runway_lights_top_margin);
        int dividerInsets = this.mActivityRecord.mWmService.mContext.getResources().getDimensionPixelSize(R.dimen.kg_runway_lights_height);
        int dividerSize = dividerWindowWidth - (dividerInsets * 2);
        Rect bounds = new Rect(displayArea.getWindowConfiguration().getAppBounds());
        if (bounds.width() < bounds.height()) goto L5;
        bounds.inset(dividerSize / 2, 0);
        bounds.right = bounds.centerX();
    L7:
        return AppCompatUtils.computeAspectRatio(bounds);
    L5:
        bounds.inset(0, dividerSize / 2);
        bounds.bottom = bounds.centerY();
        goto L7
    }

    private float getDefaultMinAspectRatioForUnresizableApps(Task task) {
        if (this.mAppCompatConfiguration.getIsSplitScreenAspectRatioForUnresizableAppsEnabled() == true) goto L10;
        if (this.mAppCompatConfiguration.getDefaultMinAspectRatioForUnresizableApps() <= 1.0f) goto L8;
        return this.mAppCompatConfiguration.getDefaultMinAspectRatioForUnresizableApps();
    L8:
        return getDefaultMinAspectRatio(task);
    L10:
        return getSplitScreenAspectRatio(task);
    }

    private float getDefaultMinAspectRatio(Task task) {
        if (this.mAppCompatConfiguration.getIsDisplayAspectRatioEnabledForFixedOrientationLetterbox() == true) goto L7;
        return this.mAppCompatConfiguration.getFixedOrientationLetterboxAspectRatio();
    L7:
        return getDisplayAreaMinAspectRatio(task);
    }

    private float getDisplayAreaMinAspectRatio(Task task) {
        DisplayArea displayArea = task.getDisplayArea();
        Rect bounds = new Rect(displayArea.getWindowConfiguration().getAppBounds());
        return AppCompatUtils.computeAspectRatio(bounds);
    }

    private boolean isDefaultMultiWindowLetterboxAspectRatioDesired(Task task) {
        DisplayContent dc = task.mDisplayContent;
        int windowingMode = task.getDisplayArea().getWindowingMode();
        if (WindowConfiguration.inMultiWindowMode(windowingMode) == true) goto L5;
    L7:
        return false;
    L5:
        if (dc.getIgnoreOrientationRequest() == true) goto L7;
        return true;
    }

    private float getMinAspectRatio(Task task) {
        if (this.mTransparentPolicy.isRunning() == true) goto L5;
        ActivityInfo info = this.mActivityRecord.info;
        AppCompatAspectRatioOverrides aspectRatioOverrides = this.mAppCompatOverrides.getAspectRatioOverrides();
        if (shouldApplyUserMinAspectRatioOverride(task) == false) goto L11;
        return aspectRatioOverrides.getUserMinAspectRatio();
    L11:
        if (aspectRatioOverrides.shouldOverrideMinAspectRatio() == true) goto L22;
        if (AppCompatCameraPolicy.shouldOverrideMinAspectRatioForCamera(this.mActivityRecord) == true) goto L22;
        float minAspectRatio = info.getMinAspectRatio();
        if (minAspectRatio != 0.0f) goto L17;
    L20:
        return 0.0f;
    L17:
        if (this.mActivityRecord.isUniversalResizeable() == true) goto L20;
        return minAspectRatio;
    L22:
        if (info.isChangeEnabled(203647190) == false) goto L28;
        if (ActivityInfo.isFixedOrientationPortrait(this.mActivityRecord.getOverrideOrientation()) == true) goto L28;
        return info.getMinAspectRatio();
    L28:
        if (info.isChangeEnabled(218959984) == false) goto L34;
        if (isFullscreenPortrait(task) == false) goto L34;
        return info.getMinAspectRatio();
    L34:
        if (info.isChangeEnabled(208648326) == false) goto L38;
        return Math.max(aspectRatioOverrides.getSplitScreenAspectRatio(), info.getMinAspectRatio());
    L38:
        if (info.isChangeEnabled(180326787) == false) goto L42;
        return Math.max(1.7777778f, info.getMinAspectRatio());
    L42:
        if (info.isChangeEnabled(180326845) == false) goto L46;
        return Math.max(1.5f, info.getMinAspectRatio());
    L46:
        if (info.isChangeEnabled(349045028) == false) goto L50;
        return Math.max(1.3333334f, info.getMinAspectRatio());
    L50:
        return info.getMinAspectRatio();
    L5:
        return this.mTransparentPolicy.getInheritedMinAspectRatio();
    }

    private float getMaxAspectRatio() {
        if (this.mTransparentPolicy.isRunning() == true) goto L5;
        float maxAspectRatio = this.mActivityRecord.info.getMaxAspectRatio();
        if (maxAspectRatio != 0.0f) goto L9;
    L12:
        return 0.0f;
    L9:
        if (this.mActivityRecord.isUniversalResizeable() == true) goto L12;
        return maxAspectRatio;
    L5:
        return this.mTransparentPolicy.getInheritedMaxAspectRatio();
    }

    boolean hasMinAspectRatioOverride(Task task) {
        if (this.mActivityRecord.info.getMinAspectRatio() >= getMinAspectRatio(task)) goto L5;
        return true;
    L5:
        return false;
    }

    boolean shouldApplyUserMinAspectRatioOverride(Task task) {
        if (shouldEnableUserAspectRatioSettings(task) == true) goto L5;
        return false;
    L5:
        int userAspectRatioCode = this.mAppCompatOverrides.getAspectRatioOverrides().getUserMinAspectRatioOverrideCode();
        if (userAspectRatioCode != 0) goto L8;
        return false;
    L8:
        if (userAspectRatioCode != 7) goto L10;
        return false;
    L10:
        if (userAspectRatioCode == 6) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean shouldEnableUserAspectRatioSettings(Task task) {
        if (this.mAppCompatOverrides.getAspectRatioOverrides().getAllowUserAspectRatioOverridePropertyValue() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mAppCompatConfiguration.isUserAppAspectRatioSettingsEnabled() == false) goto L9;
        if (task.mDisplayContent.getIgnoreOrientationRequest() == false) goto L9;
        return true;
    }

    private boolean isFullscreenPortrait(Task task) {
        if (task.getConfiguration().orientation == 1) goto L5;
    L7:
        return false;
    L5:
        if (task.getWindowConfiguration().getWindowingMode() != 1) goto L7;
        return true;
    }
}

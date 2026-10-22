package com.android.server.wm;

import android.app.WindowConfiguration;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.window.DesktopModeFlags;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatAspectRatioPolicy {
    private static final float ASPECT_RATIO_ROUNDING_TOLERANCE = 0.005f;
    private final ActivityRecord mActivityRecord;
    private final AppCompatAspectRatioState mAppCompatAspectRatioState;
    private final AppCompatOverrides mAppCompatOverrides;
    private final Rect mTmpBounds;
    private final TransparentPolicy mTransparentPolicy;

    private static class AppCompatAspectRatioState {
        private boolean mIsAspectRatioApplied;
        private Rect mLetterboxBoundsForAspectRatio;
        private Rect mLetterboxBoundsForFixedOrientationAndAspectRatio;

        /* JADX INFO: renamed from: -$$Nest$fgetmIsAspectRatioApplied, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9706$$Nest$fgetmIsAspectRatioApplied(AppCompatAspectRatioState r0) {
            return r0.mIsAspectRatioApplied;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIsAspectRatioApplied, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9707$$Nest$fputmIsAspectRatioApplied(AppCompatAspectRatioState r0, boolean r1) {
            r0.mIsAspectRatioApplied = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmLetterboxBoundsForAspectRatio, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9708$$Nest$fputmLetterboxBoundsForAspectRatio(AppCompatAspectRatioState r0, Rect r1) {
            r0.mLetterboxBoundsForAspectRatio = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmLetterboxBoundsForFixedOrientationAndAspectRatio, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9709$$Nest$fputmLetterboxBoundsForFixedOrientationAndAspectRatio(AppCompatAspectRatioState r0, Rect r1) {
            r0.mLetterboxBoundsForFixedOrientationAndAspectRatio = r1;
        }

        /* synthetic */ AppCompatAspectRatioState(AppCompatAspectRatioPolicyIA r1) {
            this();
        }

        private AppCompatAspectRatioState() {
            this.mIsAspectRatioApplied = false;
        }

        Rect getLetterboxedContainerBounds() {
            if (this.mLetterboxBoundsForFixedOrientationAndAspectRatio == null) goto L6;
            return this.mLetterboxBoundsForFixedOrientationAndAspectRatio;
        L6:
            return this.mLetterboxBoundsForAspectRatio;
        }

        void reset() {
            this.mIsAspectRatioApplied = false;
            this.mLetterboxBoundsForFixedOrientationAndAspectRatio = null;
            this.mLetterboxBoundsForAspectRatio = null;
        }

        boolean isLetterboxedForFixedOrientationAndAspectRatio() {
            if (this.mLetterboxBoundsForFixedOrientationAndAspectRatio == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isLetterboxedForAspectRatioOnly() {
            if (this.mLetterboxBoundsForAspectRatio == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    AppCompatAspectRatioPolicy(ActivityRecord activityRecord, TransparentPolicy transparentPolicy, AppCompatOverrides appCompatOverrides) {
        this.mTmpBounds = new Rect();
        this.mActivityRecord = activityRecord;
        this.mTransparentPolicy = transparentPolicy;
        this.mAppCompatOverrides = appCompatOverrides;
        this.mAppCompatAspectRatioState = new AppCompatAspectRatioState(null);
    }

    void reset() {
        this.mAppCompatAspectRatioState.reset();
    }

    private float getDesiredAspectRatio(Configuration newParentConfig, Rect parentBounds) {
        float letterboxAspectRatioOverride = this.mAppCompatOverrides.getAspectRatioOverrides().getFixedOrientationLetterboxAspectRatio(newParentConfig);
        if (isDefaultMultiWindowLetterboxAspectRatioDesired(newParentConfig) == false) goto L7;
        return 1.01f;
    L7:
        if (letterboxAspectRatioOverride <= 1.0f) goto L10;
        return letterboxAspectRatioOverride;
    L10:
        return AppCompatUtils.computeAspectRatio(parentBounds);
    }

    void applyDesiredAspectRatio(Configuration newParentConfig, Rect parentBounds, Rect resolvedBounds, Rect containingBoundsWithInsets, Rect containingBounds) {
        float desiredAspectRatio = getDesiredAspectRatio(newParentConfig, parentBounds);
        AppCompatAspectRatioState.m9707$$Nest$fputmIsAspectRatioApplied(this.mAppCompatAspectRatioState, applyAspectRatio(resolvedBounds, containingBoundsWithInsets, containingBounds, desiredAspectRatio));
    }

    void applyAspectRatioForLetterbox(Rect outBounds, Rect containingAppBounds, Rect containingBounds) {
        AppCompatAspectRatioState.m9707$$Nest$fputmIsAspectRatioApplied(this.mAppCompatAspectRatioState, applyAspectRatio(outBounds, containingAppBounds, containingBounds, 0.0f));
    }

    boolean isAspectRatioApplied() {
        return AppCompatAspectRatioState.m9706$$Nest$fgetmIsAspectRatioApplied(this.mAppCompatAspectRatioState);
    }

    float getMinAspectRatio() {
        if (this.mTransparentPolicy.isRunning() == true) goto L5;
        ActivityInfo info = this.mActivityRecord.info;
        if (AppCompatCameraPolicy.shouldCameraCompatControlAspectRatio(this.mActivityRecord) == true) goto L9;
        AppCompatAspectRatioOverrides aspectRatioOverrides = this.mAppCompatOverrides.getAspectRatioOverrides();
        if (aspectRatioOverrides.shouldApplyUserMinAspectRatioOverride() == false) goto L15;
        return aspectRatioOverrides.getUserMinAspectRatio();
    L15:
        if (aspectRatioOverrides.shouldOverrideMinAspectRatio() == true) goto L26;
        if (AppCompatCameraPolicy.shouldOverrideMinAspectRatioForCamera(this.mActivityRecord) == true) goto L26;
        float minAspectRatio = info.getMinAspectRatio();
        if (minAspectRatio != 0.0f) goto L21;
    L24:
        return 0.0f;
    L21:
        if (this.mActivityRecord.isUniversalResizeable() == true) goto L24;
        return minAspectRatio;
    L26:
        if (info.isChangeEnabled(203647190) == false) goto L32;
        if (ActivityInfo.isFixedOrientationPortrait(this.mActivityRecord.getOverrideOrientation()) == true) goto L32;
        return info.getMinAspectRatio();
    L32:
        if (info.isChangeEnabled(218959984) == false) goto L38;
        if (isParentFullscreenPortrait() == false) goto L38;
        return info.getMinAspectRatio();
    L38:
        if (info.isChangeEnabled(208648326) == false) goto L42;
        return Math.max(aspectRatioOverrides.getSplitScreenAspectRatio(), info.getMinAspectRatio());
    L42:
        if (info.isChangeEnabled(180326787) == false) goto L46;
        return Math.max(1.7777778f, info.getMinAspectRatio());
    L46:
        if (info.isChangeEnabled(180326845) == false) goto L50;
        return Math.max(1.5f, info.getMinAspectRatio());
    L50:
        if (info.isChangeEnabled(349045028) == false) goto L54;
        return Math.max(1.3333334f, info.getMinAspectRatio());
    L54:
        return info.getMinAspectRatio();
    L9:
        return Math.max(AppCompatCameraPolicy.getCameraCompatMinAspectRatio(this.mActivityRecord), info.getMinAspectRatio());
    L5:
        return this.mTransparentPolicy.getInheritedMinAspectRatio();
    }

    float getMaxAspectRatio() {
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

    Rect getLetterboxedContainerBounds() {
        return this.mAppCompatAspectRatioState.getLetterboxedContainerBounds();
    }

    boolean isLetterboxedForFixedOrientationAndAspectRatio() {
        return this.mAppCompatAspectRatioState.isLetterboxedForFixedOrientationAndAspectRatio();
    }

    boolean isLetterboxedForAspectRatioOnly() {
        return this.mAppCompatAspectRatioState.isLetterboxedForAspectRatioOnly();
    }

    void setLetterboxBoundsForFixedOrientationAndAspectRatio(Rect bounds) {
        AppCompatAspectRatioState.m9709$$Nest$fputmLetterboxBoundsForFixedOrientationAndAspectRatio(this.mAppCompatAspectRatioState, bounds);
    }

    void setLetterboxBoundsForAspectRatio(Rect bounds) {
        AppCompatAspectRatioState.m9708$$Nest$fputmLetterboxBoundsForAspectRatio(this.mAppCompatAspectRatioState, bounds);
    }

    boolean hasFixedAspectRatio() {
        if (getMaxAspectRatio() == 0.0f) goto L5;
    L8:
        return true;
    L5:
        if (getMinAspectRatio() != 0.0f) goto L8;
        return false;
    }

    void resolveAspectRatioRestrictionIfNeeded(Configuration newParentConfiguration) {
        if (this.mActivityRecord.getExt().shouldDisableLetterboxInSplitScreen() == false) goto L6;
        return;
    L6:
        if (isLetterboxedForFixedOrientationAndAspectRatio() == false) goto L8;
        return;
    L8:
        if (getOverrides().hasFullscreenOverride() == true) goto L22;
        Configuration resolvedConfig = this.mActivityRecord.getResolvedOverrideConfiguration();
        Rect parentAppBounds = this.mActivityRecord.mResolveConfigHint.mParentAppBoundsOverride;
        Rect parentBounds = this.mActivityRecord.mResolveConfigHint.mParentBoundsOverride;
        Rect resolvedBounds = resolvedConfig.windowConfiguration.getBounds();
        this.mTmpBounds.setEmpty();
        applyAspectRatioForLetterbox(this.mTmpBounds, parentAppBounds, parentBounds);
        if (this.mTmpBounds.isEmpty() == true) goto L14;
        resolvedBounds.set(this.mTmpBounds);
    L14:
        if (resolvedBounds.isEmpty() == false) goto L16;
        return;
    L16:
        if (resolvedBounds.equals(parentBounds) == true) goto L21;
        TaskFragment.ConfigOverrideHint r4 = this.mActivityRecord.mResolveConfigHint;
        r4.mTmpOverrideDisplayInfo = this.mActivityRecord.getFixedRotationTransformDisplayInfo();
        this.mActivityRecord.computeConfigByResolveHint(resolvedConfig, newParentConfiguration);
        setLetterboxBoundsForAspectRatio(new Rect(resolvedBounds));
        return;
    L21:
        return;
    }

    private boolean isParentFullscreenPortrait() {
        WindowContainer<?> parent = this.mActivityRecord.getParent();
        if (parent != null) goto L5;
    L9:
        return false;
    L5:
        if (parent.getConfiguration().orientation != 1) goto L9;
        if (parent.getWindowConfiguration().getWindowingMode() != 1) goto L9;
        return true;
    }

    private boolean applyAspectRatio(Rect outBounds, Rect containingAppBounds, Rect containingBounds, float desiredAspectRatio) {
        float maxAspectRatio = getMaxAspectRatio();
        Task rootTask = this.mActivityRecord.getRootTask();
        Task task = this.mActivityRecord.getTask();
        float minAspectRatio = getMinAspectRatio();
        TaskFragment organizedTf = this.mActivityRecord.getOrganizedTaskFragment();
        float aspectRatioToApply = desiredAspectRatio;
        if (task == null) goto L74;
        if (rootTask == null) goto L74;
        if (maxAspectRatio >= 1.0f) goto L14;
        if (minAspectRatio >= 1.0f) goto L14;
        if (aspectRatioToApply >= 1.0f) goto L14;
        return false;
    L14:
        if (AppCompatUtils.isInVrUiMode(this.mActivityRecord.getConfiguration()) == true) goto L78;
        if (organizedTf == null) goto L21;
        if (organizedTf.fillsParent() == true) goto L21;
        return false;
    L21:
        if (DesktopModeFlags.IGNORE_ASPECT_RATIO_RESTRICTIONS_FOR_RESIZEABLE_FREEFORM_ACTIVITIES.isTrue() == true) goto L23;
    L29:
        int containingAppWidth = containingAppBounds.width();
        int containingAppHeight = containingAppBounds.height();
        float containingRatio = AppCompatUtils.computeAspectRatio(containingAppBounds);
        if (aspectRatioToApply >= 1.0f) goto L33;
        aspectRatioToApply = containingRatio;
    L33:
        if (maxAspectRatio < 1.0f) goto L38;
        if (aspectRatioToApply <= maxAspectRatio) goto L38;
        aspectRatioToApply = maxAspectRatio;
    L42:
        int activityWidth = containingAppWidth;
        int activityHeight = containingAppHeight;
        if ((containingRatio - aspectRatioToApply) <= ASPECT_RATIO_ROUNDING_TOLERANCE) goto L48;
        if (containingAppWidth >= containingAppHeight) goto L46;
        activityHeight = (int) ((activityWidth * aspectRatioToApply) + 0.5f);
        boolean r16 = false;
    L60:
        if (containingAppWidth > activityWidth) goto L63;
        if (containingAppHeight > activityHeight) goto L63;
        return r16;
    L63:
        int right = containingAppBounds.left + activityWidth;
        int left = containingAppBounds.left;
        if (right < containingAppBounds.right) goto L66;
        right = containingBounds.right;
        left = containingBounds.left;
    L66:
        int bottom = containingAppBounds.top + activityHeight;
        int top = containingAppBounds.top;
        int top2 = containingAppBounds.bottom;
        if (bottom < top2) goto L69;
        bottom = containingBounds.bottom;
        int top3 = containingBounds.top;
    L70:
        outBounds.set(left, top3, right, bottom);
        return true;
    L69:
        top3 = top;
        goto L70
    L46:
        activityWidth = (int) ((activityHeight * aspectRatioToApply) + 0.5f);
        r16 = false;
        goto L60
    L48:
        if ((aspectRatioToApply - containingRatio) > ASPECT_RATIO_ROUNDING_TOLERANCE) goto L50;
        r16 = false;
        goto L60
    L50:
        switch(this.mActivityRecord.getRequestedConfigurationOrientation()) {
            case 1: goto L55;
            case 2: goto L54;
            default: goto L51;
        };
    L51:
        if (containingAppWidth >= containingAppHeight) goto L53;
        boolean adjustWidth = true;
    L56:
        if (adjustWidth == false) goto L58;
        r16 = false;
        activityWidth = (int) ((activityHeight / aspectRatioToApply) + 0.5f);
        goto L60
    L58:
        r16 = false;
        activityHeight = (int) ((activityWidth / aspectRatioToApply) + 0.5f);
        goto L60
    L53:
        adjustWidth = false;
        goto L56
    L54:
        adjustWidth = false;
        goto L56
    L55:
        adjustWidth = true;
    L38:
        if (minAspectRatio < 1.0f) goto L42;
        if (aspectRatioToApply >= minAspectRatio) goto L42;
        aspectRatioToApply = minAspectRatio;
        goto L42
    L23:
        if (task.getWindowingMode() != 5) goto L29;
        if (this.mActivityRecord.shouldCreateAppCompatDisplayInsets() == true) goto L29;
        if (AppCompatCameraPolicy.shouldCameraCompatControlAspectRatio(this.mActivityRecord) == true) goto L29;
        return false;
    L78:
        return false;
    L74:
        return false;
    }

    private boolean isDefaultMultiWindowLetterboxAspectRatioDesired(Configuration parentConfig) {
        DisplayContent dc = this.mActivityRecord.mDisplayContent;
        if (dc != null) goto L5;
        return false;
    L5:
        int windowingMode = parentConfig.windowConfiguration.getWindowingMode();
        if (WindowConfiguration.inMultiWindowMode(windowingMode) == true) goto L8;
        return false;
    L8:
        if (dc.getIgnoreOrientationRequest() == true) goto L13;
        return true;
    L13:
        return false;
    }

    private AppCompatAspectRatioOverrides getOverrides() {
        return this.mActivityRecord.mAppCompatController.getAspectRatioOverrides();
    }
}

package com.android.server.wm;

import android.app.AppCompatTaskInfo;
import android.app.TaskInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.InsetsSource;
import android.view.InsetsState;
import android.view.WindowInsets;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes3.dex */
final class AppCompatUtils {
    /* JADX INFO: renamed from: $r8$lambda$L9SqUNqcwkBnFgT--g2ID_uX7xA, reason: not valid java name */
    public static /* synthetic */ Rect m9726$r8$lambda$L9SqUNqcwkBnFgTg2ID_uX7xA(ActivityRecord r0, Rect r1) {
        return lambda$getAppBounds$0(r0, r1);
    }

    AppCompatUtils() {
    }

    static BooleanSupplier asLazy(final BooleanSupplier supplier) {
        return new AnonymousClass1(supplier);
    }

    static float computeAspectRatio(Rect rect) {
        int width = rect.width();
        int height = rect.height();
        if (width == 0) goto L8;
        if (height != 0) goto L7;
        return 0.0f;
    L7:
        return Math.max(width, height) / Math.min(width, height);
    L8:
        return 0.0f;
    }

    static boolean isInVrUiMode(Configuration config) {
        if ((config.uiMode & 15) != 7) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isChangeEnabled(ActivityRecord activityRecord, long overrideChangeId) {
        if (activityRecord.info.isChangeEnabled(overrideChangeId) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDisplayIgnoreActivitySizeRestrictions(activityRecord) == true) goto L7;
        return true;
    }

    static boolean isDisplayIgnoreActivitySizeRestrictions(ActivityRecord activityRecord) {
        DisplayContent dc = activityRecord.mDisplayContent;
        if (dc != null) goto L5;
    L7:
        return false;
    L5:
        if (dc.isDisplayIgnoreActivitySizeRestrictions() == false) goto L7;
        return true;
    }

    static Rect getAppBounds(final ActivityRecord activityRecord) {
        final Rect appBounds = activityRecord.getConfiguration().windowConfiguration.getAppBounds();
        if (appBounds != null) goto L7;
        return activityRecord.getBounds();
    L7:
        return (Rect) activityRecord.mAppCompatController.getTransparentPolicy().findOpaqueNotFinishingActivityBelow().map(new AppCompatUtils$$ExternalSyntheticLambda0()).orElseGet(new AppCompatUtils$$ExternalSyntheticLambda1(activityRecord, appBounds));
    }

    private static /* synthetic */ Rect lambda$getAppBounds$0(ActivityRecord activityRecord, Rect appBounds) {
        if (activityRecord.hasSizeCompatBounds() == true) goto L5;
        return appBounds;
    L5:
        return activityRecord.getScreenResolvedBounds();
    }

    static void fillAppCompatTaskInfo(Task task, TaskInfo info, ActivityRecord top) {
        AppCompatTaskInfo appCompatTaskInfo = info.appCompatTaskInfo;
        clearAppCompatTaskInfo(appCompatTaskInfo);
        if (top != null) goto L5;
        return;
    L5:
        AppCompatReachabilityOverrides reachabilityOverrides = top.mAppCompatController.getReachabilityOverrides();
        boolean eligibleForAspectRatioButton = true;
        if (top.getOrganizedTask() == task) goto L8;
    L10:
        boolean isTopActivityResumed = false;
    L12:
        if (top.getOrganizedTask() == task) goto L14;
    L16:
        boolean isTopActivityVisible = false;
    L17:
        if (isTopActivityVisible == true) goto L19;
    L21:
        boolean r6 = false;
    L22:
        appCompatTaskInfo.setTopActivityInSizeCompat(r6);
        if (appCompatTaskInfo.isTopActivityInSizeCompat() == true) goto L25;
    L28:
        if (isTopActivityResumed == true) goto L30;
    L32:
        boolean r7 = false;
    L33:
        appCompatTaskInfo.setEligibleForLetterboxEducation(r7);
        appCompatTaskInfo.setLetterboxEducationEnabled(top.mAppCompatController.getLetterboxOverrides().isLetterboxEducationEnabled());
        appCompatTaskInfo.setRestartMenuEnabledForDisplayMove(top.mAppCompatController.getDisplayCompatModePolicy().isRestartMenuEnabledForDisplayMove());
        AppCompatAspectRatioOverrides aspectRatioOverrides = top.mAppCompatController.getAspectRatioOverrides();
        appCompatTaskInfo.setUserFullscreenOverrideEnabled(aspectRatioOverrides.shouldApplyUserFullscreenOverride());
        appCompatTaskInfo.setSystemFullscreenOverrideEnabled(aspectRatioOverrides.isSystemOverrideToFullscreenEnabled());
        appCompatTaskInfo.setIsFromLetterboxDoubleTap(reachabilityOverrides.isFromDoubleTap());
        appCompatTaskInfo.topActivityAppBounds.set(getAppBounds(top));
        boolean isTopActivityLetterboxed = top.areBoundsLetterboxed();
        appCompatTaskInfo.setTopActivityLetterboxed(isTopActivityLetterboxed);
        if (isTopActivityLetterboxed == false) goto L48;
        Rect bounds = top.getBounds();
        appCompatTaskInfo.topActivityLetterboxWidth = bounds.width();
        appCompatTaskInfo.topActivityLetterboxHeight = bounds.height();
        appCompatTaskInfo.topActivityLetterboxBounds = bounds;
        appCompatTaskInfo.setLetterboxDoubleTapEnabled(reachabilityOverrides.isLetterboxDoubleTapEducationEnabled());
        if (appCompatTaskInfo.isLetterboxDoubleTapEnabled() == false) goto L48;
        if (appCompatTaskInfo.isTopActivityPillarboxShaped() == false) goto L44;
        if (reachabilityOverrides.allowHorizontalReachabilityForThinLetterbox() == false) goto L42;
        appCompatTaskInfo.topActivityLetterboxHorizontalPosition = reachabilityOverrides.getLetterboxPositionForHorizontalReachability();
        goto L48
    L42:
        appCompatTaskInfo.setLetterboxDoubleTapEnabled(false);
        goto L48
    L44:
        if (reachabilityOverrides.allowVerticalReachabilityForThinLetterbox() == false) goto L46;
        appCompatTaskInfo.topActivityLetterboxVerticalPosition = reachabilityOverrides.getLetterboxPositionForVerticalReachability();
        goto L48
    L46:
        appCompatTaskInfo.setLetterboxDoubleTapEnabled(false);
    L48:
        if (info.isTopActivityTransparent == false) goto L50;
    L54:
        eligibleForAspectRatioButton = false;
    L55:
        appCompatTaskInfo.setEligibleForUserAspectRatioButton(eligibleForAspectRatioButton);
        appCompatTaskInfo.cameraCompatTaskInfo.freeformCameraCompatMode = AppCompatCameraPolicy.getCameraCompatFreeformMode(top);
        appCompatTaskInfo.setHasMinAspectRatioOverride(top.mAppCompatController.getDesktopAspectRatioPolicy().hasMinAspectRatioOverride(task));
        appCompatTaskInfo.setOptOutEdgeToEdge(top.mOptOutEdgeToEdge);
        return;
    L50:
        if (appCompatTaskInfo.isTopActivityInSizeCompat() == true) goto L54;
        if (aspectRatioOverrides.shouldEnableUserAspectRatioSettings() == false) goto L54;
    L30:
        if (top.mAppCompatController.getLetterboxPolicy().isEligibleForLetterboxEducation() == false) goto L32;
        r7 = true;
        goto L33
    L25:
        if (top.mWmService.mAppCompatConfiguration.isTranslucentLetterboxingEnabled() == false) goto L28;
        appCompatTaskInfo.setTopActivityInSizeCompat(top.fillsParent());
        goto L28
    L19:
        if (top.inSizeCompatMode() == false) goto L21;
        r6 = true;
        goto L22
    L14:
        if (top.isVisible() == false) goto L16;
        isTopActivityVisible = true;
        goto L17
    L8:
        if (top.isState(ActivityRecord.State.RESUMED) == false) goto L10;
        isTopActivityResumed = true;
        goto L12
    }

    static String getLetterboxReasonString(ActivityRecord activityRecord, WindowState mainWin) {
        if (activityRecord.inSizeCompatMode() == false) goto L6;
        return "SIZE_COMPAT_MODE";
    L6:
        AppCompatAspectRatioPolicy aspectRatioPolicy = activityRecord.mAppCompatController.getAspectRatioPolicy();
        if (aspectRatioPolicy.isLetterboxedForFixedOrientationAndAspectRatio() == false) goto L11;
        return "FIXED_ORIENTATION";
    L11:
        if (mainWin.isLetterboxedForDisplayCutout() == false) goto L15;
        return "DISPLAY_CUTOUT";
    L15:
        if (aspectRatioPolicy.isLetterboxedForAspectRatioOnly() == false) goto L19;
        return "ASPECT_RATIO";
    L19:
        if (activityRecord.mAppCompatController.getSafeRegionPolicy().isLetterboxedForSafeRegionOnlyAllowed() == false) goto L22;
        return "SAFE_REGION";
    L22:
        return "UNKNOWN_REASON";
    }

    static InsetsSource getExpandedTaskbarOrNull(WindowState mainWindow) {
        InsetsState state = mainWindow.getInsetsState();
        int i = state.sourceSize() - 1;
    L3:
        if (i < 0) goto L12;
        InsetsSource source = state.sourceAt(i);
        if (source.getType() != WindowInsets.Type.navigationBars()) goto L11;
        if (source.hasFlags(2) == false) goto L11;
        if (source.isVisible() == false) goto L11;
        return source;
    L11:
        i = i - 1;
        goto L3
    L12:
        return null;
    }

    static void adjustBoundsForTaskbar(WindowState mainWindow, Rect bounds) {
        InsetsSource expandedTaskbarOrNull = getExpandedTaskbarOrNull(mainWindow);
        if (expandedTaskbarOrNull == null) goto L6;
        bounds.bottom = Math.min(bounds.bottom, expandedTaskbarOrNull.getFrame().top);
        return;
    }

    static void offsetBounds(Configuration inOutConfig, int offsetX, int offsetY) {
        inOutConfig.windowConfiguration.getBounds().offset(offsetX, offsetY);
        inOutConfig.windowConfiguration.getAppBounds().offset(offsetX, offsetY);
    }

    static boolean isInDesktopMode(Context context, int parentWindowingMode) {
        if (parentWindowingMode == 5) goto L5;
    L7:
        return false;
    L5:
        if (DesktopModeHelper.canEnterDesktopMode(context) == false) goto L7;
        return true;
    }

    private static void clearAppCompatTaskInfo(AppCompatTaskInfo info) {
        info.topActivityLetterboxVerticalPosition = -1;
        info.topActivityLetterboxHorizontalPosition = -1;
        info.topActivityLetterboxWidth = -1;
        info.topActivityLetterboxHeight = -1;
        info.topActivityAppBounds.setEmpty();
        info.topActivityLetterboxBounds = null;
        info.cameraCompatTaskInfo.freeformCameraCompatMode = 0;
        info.clearTopActivityFlags();
    }
}

package com.android.server.wm;

import android.app.ActivityOptions;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.os.SystemProperties;
import android.util.Size;
import android.window.DesktopModeFlags;
import com.android.internal.policy.DesktopModeCompatUtils;
import com.android.internal.policy.SystemBarUtils;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class DesktopModeBoundsCalculator {
    public static final float DESKTOP_MODE_INITIAL_BOUNDS_SCALE = 0.0f;
    public static final int DESKTOP_MODE_LANDSCAPE_APP_PADDING = 0;
    public static final float WINDOW_HEIGHT_PROPORTION = 0.375f;

    public DesktopModeBoundsCalculator() {
    }

    static {
        DESKTOP_MODE_INITIAL_BOUNDS_SCALE = SystemProperties.getInt("persist.wm.debug.desktop_mode_initial_bounds_scale", 75) / 100.0f;
        DESKTOP_MODE_LANDSCAPE_APP_PADDING = SystemProperties.getInt("persist.wm.debug.desktop_mode_landscape_app_padding", 25);
    }

    static void updateInitialBounds(Task task, ActivityInfo.WindowLayout layout, ActivityRecord activity, ActivityOptions options, LaunchParamsController.LaunchParams outParams, Consumer<String> logger) {
        Rect stableBounds = new Rect();
        task.getDisplayArea().getStableRect(stableBounds);
        int r4 = 0;
        if (activity != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        boolean hasFullscreenOverride = r5;
        if (options != null) goto L11;
    L14:
        boolean r6 = false;
    L15:
        boolean updateOptionBoundsSize = r6;
        if (updateOptionBoundsSize == true) goto L18;
    L20:
        boolean shouldRespectOptionPosition = false;
    L22:
        if (activity != null) goto L24;
    L26:
        int captionHeight = r4;
        if (options == null) goto L35;
        if (options.getLaunchBounds() == null) goto L35;
        if (updateOptionBoundsSize == true) goto L35;
        outParams.mBounds.set(options.getLaunchBounds());
        logger.accept("inherit-from-options=" + outParams.mBounds);
    L44:
        if (updateOptionBoundsSize == false) goto L48;
        if (captionHeight == 0) goto L49;
        outParams.mAppBounds.set(outParams.mBounds);
        outParams.mAppBounds.top += captionHeight;
        logger.accept("excluding caption height from app bounds");
        return;
    L49:
        return;
    L48:
        return;
    L35:
        if (layout == null) goto L43;
        int verticalGravity = layout.gravity & 112;
        int horizontalGravity = layout.gravity & 7;
        if (layout.hasSpecifiedSize() == false) goto L39;
        LaunchParamsUtil.calculateLayoutBounds(stableBounds, layout, outParams.mBounds, calculateIdealSize(stableBounds, DESKTOP_MODE_INITIAL_BOUNDS_SCALE));
        LaunchParamsUtil.applyLayoutGravity(verticalGravity, horizontalGravity, outParams.mBounds, stableBounds);
        logger.accept("layout specifies sizes, inheriting size and applying gravity");
        goto L44
    L39:
        if (verticalGravity > 0) goto L41;
        if (horizontalGravity <= 0) goto L44;
    L41:
        outParams.mBounds.set(calculateInitialBounds(task, activity, stableBounds, options, shouldRespectOptionPosition, captionHeight));
        LaunchParamsUtil.applyLayoutGravity(verticalGravity, horizontalGravity, outParams.mBounds, stableBounds);
        logger.accept("layout specifies gravity, applying desired bounds and gravity");
        logger.accept("respecting option bounds cascaded position=" + shouldRespectOptionPosition);
        goto L44
    L43:
        outParams.mBounds.set(calculateInitialBounds(task, activity, stableBounds, options, shouldRespectOptionPosition, captionHeight));
        logger.accept("layout not specified, applying desired bounds");
        logger.accept("respecting option bounds cascaded position=" + shouldRespectOptionPosition);
        goto L44
    L24:
        if (DesktopModeCompatUtils.shouldExcludeCaptionFromAppBounds(activity.info, task.isResizeable(), activity.mOptOutEdgeToEdge) == false) goto L26;
        r4 = SystemBarUtils.getDesktopViewAppHeaderHeightPx(activity.mWmService.mContext);
        goto L26
    L18:
        if (DesktopModeFlags.ENABLE_CASCADING_WINDOWS.isTrue() == false) goto L20;
        shouldRespectOptionPosition = true;
        goto L22
    L11:
        if (options.getFlexibleLaunchSize() == false) goto L14;
        if (hasFullscreenOverride == true) goto L14;
        r6 = true;
        goto L15
    L5:
        if (activity.mAppCompatController.getAspectRatioOverrides().hasFullscreenOverride() == false) goto L7;
        r5 = true;
        goto L8
    }

    private static Rect calculateInitialBounds(Task task, ActivityRecord activity, Rect stableBounds, ActivityOptions options, boolean shouldRespectOptionPosition, int captionHeight) {
        TaskDisplayArea displayArea = task.getDisplayArea();
        Rect screenBounds = displayArea.getBounds();
        Size idealSize = calculateIdealSize(screenBounds, DESKTOP_MODE_INITIAL_BOUNDS_SCALE);
        if (DesktopModeFlags.ENABLE_WINDOWING_DYNAMIC_INITIAL_BOUNDS.isTrue() == true) goto L7;
        return centerInScreen(idealSize, screenBounds);
    L7:
        if (activity.mAppCompatController.getAspectRatioOverrides().hasFullscreenOverride() == true) goto L9;
        DesktopAppCompatAspectRatioPolicy desktopAppCompatAspectRatioPolicy = activity.mAppCompatController.getDesktopAspectRatioPolicy();
        boolean hasOrientationMismatch = true;
        if (stableBounds.height() < stableBounds.width()) goto L13;
        int stableBoundsOrientation = 1;
    L14:
        int activityOrientation = getActivityConfigurationOrientation(activity, task, stableBoundsOrientation);
        if (stableBoundsOrientation != activityOrientation) goto L18;
        hasOrientationMismatch = false;
    L18:
        float appAspectRatio = desktopAppCompatAspectRatioPolicy.calculateAspectRatio(task, hasOrientationMismatch);
        float tdaWidth = stableBounds.width();
        float tdaHeight = stableBounds.height();
        switch(stableBoundsOrientation) {
            case 1: goto L30;
            case 2: goto L22;
            default: goto L38;
        };
    L30:
        int customPortraitWidthForLandscapeApp = screenBounds.width() - (DESKTOP_MODE_LANDSCAPE_APP_PADDING * 2);
        if (canChangeAspectRatio(desktopAppCompatAspectRatioPolicy, task) == false) goto L40;
        if (hasOrientationMismatch == false) goto L38;
        if (appAspectRatio != 0.0f) goto L36;
        appAspectRatio = tdaWidth / (tdaWidth - 1.0f);
    L36:
        Size initialSize = new Size(customPortraitWidthForLandscapeApp, (int) ((tdaWidth / appAspectRatio) + 0.5f));
    L46:
        if (shouldRespectOptionPosition == false) goto L50;
        return respectShellCascading(initialSize, stableBounds, options.getLaunchBounds());
    L50:
        return centerInScreen(initialSize, screenBounds);
    L40:
        if (appAspectRatio != 0.0f) goto L42;
        appAspectRatio = 1.0f;
    L42:
        if (hasOrientationMismatch == false) goto L44;
        initialSize = maximizeSizeGivenAspectRatio(activityOrientation, new Size(customPortraitWidthForLandscapeApp, idealSize.getHeight()), appAspectRatio, captionHeight);
        goto L46
    L44:
        initialSize = maximizeSizeGivenAspectRatio(activityOrientation, idealSize, appAspectRatio, captionHeight);
    L38:
        initialSize = idealSize;
        goto L46
    L22:
        if (appAspectRatio != 0.0f) goto L25;
        appAspectRatio = 1.0f;
    L25:
        if (canChangeAspectRatio(desktopAppCompatAspectRatioPolicy, task) == false) goto L29;
        if (hasOrientationMismatch == false) goto L28;
        initialSize = new Size((int) ((tdaHeight / appAspectRatio) + 0.5f), idealSize.getHeight());
        goto L46
    L28:
        initialSize = idealSize;
        goto L46
    L29:
        initialSize = maximizeSizeGivenAspectRatio(activityOrientation, idealSize, appAspectRatio, captionHeight);
        goto L46
    L13:
        stableBoundsOrientation = 2;
        goto L14
    L9:
        return centerInScreen(idealSize, screenBounds);
    }

    private static boolean canChangeAspectRatio(DesktopAppCompatAspectRatioPolicy desktopAppCompatAspectRatioPolicy, Task task) {
        if (task.isResizeable() == true) goto L5;
    L7:
        return false;
    L5:
        if (desktopAppCompatAspectRatioPolicy.hasMinAspectRatioOverride(task) == true) goto L7;
        return true;
    }

    private static int getActivityConfigurationOrientation(ActivityRecord activity, Task task, int stableBoundsOrientation) {
        int activityOrientation = activity.getOverrideOrientation();
        DesktopAppCompatAspectRatioPolicy desktopAppCompatAspectRatioPolicy = activity.mAppCompatController.getDesktopAspectRatioPolicy();
        if (desktopAppCompatAspectRatioPolicy.shouldApplyUserMinAspectRatioOverride(task) == false) goto L9;
        if (ActivityInfo.isFixedOrientation(activityOrientation) == true) goto L7;
        return 1;
    L7:
        if (activityOrientation != 14) goto L9;
        return 1;
    L9:
        if (ActivityInfo.isFixedOrientationPortrait(activityOrientation) == false) goto L13;
        return 1;
    L13:
        if (ActivityInfo.isFixedOrientationLandscape(activityOrientation) == false) goto L16;
        return 2;
    L16:
        return stableBoundsOrientation;
    }

    private static Size maximizeSizeGivenAspectRatio(int orientation, Size targetArea, float aspectRatio, int captionHeight) {
        int targetHeight = targetArea.getHeight() - captionHeight;
        int targetWidth = targetArea.getWidth();
        if (orientation != 1) goto L9;
        int tempWidth = (int) (targetHeight / aspectRatio);
        if (tempWidth > targetWidth) goto L7;
        int finalHeight = targetHeight;
        int finalWidth = tempWidth;
    L14:
        return new Size(finalWidth, finalHeight + captionHeight);
    L7:
        finalWidth = targetWidth;
        finalHeight = (int) (finalWidth * aspectRatio);
        goto L14
    L9:
        int tempWidth2 = (int) (targetHeight * aspectRatio);
        if (tempWidth2 > targetWidth) goto L12;
        finalHeight = targetHeight;
        finalWidth = tempWidth2;
        goto L14
    L12:
        finalWidth = targetWidth;
        finalHeight = (int) (finalWidth / aspectRatio);
        goto L14
    }

    private static Size calculateIdealSize(Rect screenBounds, float scale) {
        int width = (int) (screenBounds.width() * scale);
        int height = (int) (screenBounds.height() * scale);
        return new Size(width, height);
    }

    static Rect centerInScreen(Size desiredSize, Rect screenBounds) {
        int heightOffset = (int) ((screenBounds.height() - desiredSize.getHeight()) * 0.375f);
        int widthOffset = (screenBounds.width() - desiredSize.getWidth()) / 2;
        Rect resultBounds = new Rect(0, 0, desiredSize.getWidth(), desiredSize.getHeight());
        resultBounds.offset(screenBounds.left + widthOffset, screenBounds.top + heightOffset);
        return resultBounds;
    }

    private static Rect respectShellCascading(Size desiredSize, Rect stableBounds, Rect optionBounds) {
        boolean bottomAligned = false;
        if (stableBounds.left != optionBounds.left) goto L5;
        boolean leftAligned = true;
    L7:
        if (stableBounds.right != optionBounds.right) goto L9;
        boolean rightAligned = true;
    L11:
        if (stableBounds.top != optionBounds.top) goto L13;
        boolean topAligned = true;
    L15:
        if (stableBounds.bottom != optionBounds.bottom) goto L17;
        bottomAligned = true;
    L17:
        if (leftAligned == false) goto L21;
        if (topAligned == false) goto L21;
        return new Rect(optionBounds.left, optionBounds.top, optionBounds.left + desiredSize.getWidth(), optionBounds.top + desiredSize.getHeight());
    L21:
        if (leftAligned == false) goto L25;
        if (bottomAligned == false) goto L25;
        return new Rect(optionBounds.left, optionBounds.bottom - desiredSize.getHeight(), optionBounds.left + desiredSize.getWidth(), optionBounds.bottom);
    L25:
        if (rightAligned == false) goto L29;
        if (topAligned == false) goto L29;
        return new Rect(optionBounds.right - desiredSize.getWidth(), optionBounds.top, optionBounds.right, optionBounds.top + desiredSize.getHeight());
    L29:
        if (rightAligned == false) goto L34;
        if (bottomAligned == false) goto L34;
        return new Rect(optionBounds.right - desiredSize.getWidth(), optionBounds.bottom - desiredSize.getHeight(), optionBounds.right, optionBounds.bottom);
    L34:
        return centerInScreen(desiredSize, stableBounds);
    L13:
        topAligned = false;
        goto L15
    L9:
        rightAligned = false;
        goto L11
    L5:
        leftAligned = false;
        goto L7
    }
}

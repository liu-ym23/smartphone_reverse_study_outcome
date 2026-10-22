package com.android.server.wm;

import android.graphics.Rect;
import android.view.InsetsState;
import android.view.RoundedCorner;
import android.view.SurfaceControl;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatRoundedCorners {
    private final ActivityRecord mActivityRecord;
    private final Predicate<WindowState> mRoundedCornersWindowCondition;

    AppCompatRoundedCorners(ActivityRecord activityRecord, Predicate<WindowState> roundedCornersWindowCondition) {
        this.mActivityRecord = activityRecord;
        this.mRoundedCornersWindowCondition = roundedCornersWindowCondition;
    }

    void updateRoundedCornersIfNeeded(WindowState mainWindow) {
        SurfaceControl windowSurface = mainWindow.getSurfaceControl();
        if (windowSurface != null) goto L5;
        return;
    L5:
        if (windowSurface.isValid() == false) goto L10;
        this.mActivityRecord.getSyncTransaction().setCrop(windowSurface, getCropBoundsIfNeeded(mainWindow)).setCornerRadius(windowSurface, getRoundedCornersRadius(mainWindow));
        return;
    }

    Rect getCropBoundsIfNeeded(WindowState mainWindow) {
        if (requiresRoundedCorners(mainWindow) == true) goto L5;
        return null;
    L5:
        Rect cropBounds = new Rect(this.mActivityRecord.getBounds());
        TransparentPolicy transparentPolicy = this.mActivityRecord.mAppCompatController.getTransparentPolicy();
        if (transparentPolicy.isRunning() == true) goto L8;
    L12:
        AppCompatUtils.adjustBoundsForTaskbar(mainWindow, cropBounds);
        float scale = mainWindow.mInvGlobalScale;
        if (scale != 1.0f) goto L15;
    L17:
        cropBounds.offsetTo(0, 0);
        return cropBounds;
    L15:
        if (scale <= 0.0f) goto L17;
        cropBounds.scale(scale);
        goto L17
    L8:
        if (cropBounds.width() == mainWindow.mRequestedWidth) goto L10;
    L11:
        return null;
    L10:
        if (cropBounds.height() == mainWindow.mRequestedHeight) goto L12;
        goto L11
    }

    int getRoundedCornersRadius(WindowState mainWindow) {
        if (requiresRoundedCorners(mainWindow) == true) goto L6;
        return 0;
    L6:
        AppCompatLetterboxOverrides letterboxOverrides = this.mActivityRecord.mAppCompatController.getLetterboxOverrides();
        if (letterboxOverrides.getLetterboxActivityCornersRadius() < 0) goto L9;
        int radius = letterboxOverrides.getLetterboxActivityCornersRadius();
    L10:
        float scale = mainWindow.mInvGlobalScale;
        if (scale == 1.0f) goto L16;
        if (scale <= 0.0f) goto L16;
        return (int) (radius * scale);
    L16:
        return radius;
    L9:
        InsetsState insetsState = mainWindow.getInsetsState();
        radius = Math.min(getInsetsStateCornerRadius(insetsState, 3), getInsetsStateCornerRadius(insetsState, 2));
        goto L10
    }

    private static int getInsetsStateCornerRadius(InsetsState insetsState, int position) {
        RoundedCorner corner = insetsState.getRoundedCorners().getRoundedCorner(position);
        if (corner != null) goto L6;
        return 0;
    L6:
        return corner.getRadius();
    }

    private boolean requiresRoundedCorners(WindowState mainWindow) {
        AppCompatLetterboxOverrides letterboxOverrides = this.mActivityRecord.mAppCompatController.getLetterboxOverrides();
        if (this.mRoundedCornersWindowCondition.test(mainWindow) == true) goto L5;
    L7:
        return false;
    L5:
        if (letterboxOverrides.isLetterboxActivityCornersRounded() == false) goto L7;
        return true;
    }
}

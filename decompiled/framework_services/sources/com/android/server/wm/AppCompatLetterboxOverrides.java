package com.android.server.wm;

import android.app.ActivityManager;
import android.graphics.Color;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.util.Slog;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatLetterboxOverrides {
    private static final String TAG = "ActivityTaskManager";
    private final ActivityRecord mActivityRecord;
    private final AppCompatConfiguration mAppCompatConfiguration;
    private boolean mShowWallpaperForLetterboxBackground;

    AppCompatLetterboxOverrides(ActivityRecord activityRecord, AppCompatConfiguration appCompatConfiguration) {
        this.mActivityRecord = activityRecord;
        this.mAppCompatConfiguration = appCompatConfiguration;
    }

    boolean shouldLetterboxHaveRoundedCorners() {
        if (this.mAppCompatConfiguration.isLetterboxActivityCornersRounded() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mActivityRecord.fillsParent() == false) goto L7;
        return true;
    }

    boolean isLetterboxEducationEnabled() {
        return this.mAppCompatConfiguration.getIsEducationEnabled();
    }

    boolean hasWallpaperBackgroundForLetterbox() {
        return this.mShowWallpaperForLetterboxBackground;
    }

    boolean checkWallpaperBackgroundForLetterbox(boolean wallpaperShouldBeShown) {
        if (this.mShowWallpaperForLetterboxBackground == wallpaperShouldBeShown) goto L6;
        this.mShowWallpaperForLetterboxBackground = wallpaperShouldBeShown;
        return true;
    L6:
        return false;
    }

    Color getLetterboxBackgroundColor() {
        WindowState w = this.mActivityRecord.findMainWindow();
        if (w == null) goto L31;
        if (w.isLetterboxedForDisplayCutout() == true) goto L31;
        int letterboxBackgroundType = this.mAppCompatConfiguration.getLetterboxBackgroundType();
        ActivityManager.TaskDescription taskDescription = this.mActivityRecord.taskDescription;
        switch(letterboxBackgroundType) {
            case 0: goto L29;
            case 1: goto L21;
            case 2: goto L16;
            case 3: goto L12;
            default: goto L10;
        };
    L16:
        if (taskDescription != null) goto L18;
    L27:
        return this.mAppCompatConfiguration.getLetterboxBackgroundColor();
    L18:
        if (taskDescription.getBackgroundColorFloating() == 0) goto L27;
        return Color.valueOf(taskDescription.getBackgroundColorFloating());
    L21:
        if (taskDescription == null) goto L27;
        if (taskDescription.getBackgroundColor() == 0) goto L27;
        return Color.valueOf(taskDescription.getBackgroundColor());
    L10:
        throw new AssertionError("Unexpected letterbox background type: " + letterboxBackgroundType);
    L12:
        if (hasWallpaperBackgroundForLetterbox() == true) goto L14;
        Slog.w(TAG, "Wallpaper option is selected for letterbox background but blur is not supported by a device or not supported in the current window configuration or both alpha scrim and blur radius aren't provided so using solid color background");
        goto L27
    L14:
        return this.mAppCompatConfiguration.getLetterboxBackgroundColor();
    L29:
        return this.mAppCompatConfiguration.getLetterboxBackgroundColor();
    L31:
        return Color.valueOf(AudioFormat.MAIN_MASK);
    }

    int getLetterboxActivityCornersRadius() {
        return this.mAppCompatConfiguration.getLetterboxActivityCornersRadius();
    }

    boolean isLetterboxActivityCornersRounded() {
        return this.mAppCompatConfiguration.isLetterboxActivityCornersRounded();
    }

    int getLetterboxBackgroundType() {
        return this.mAppCompatConfiguration.getLetterboxBackgroundType();
    }

    int getLetterboxWallpaperBlurRadiusPx() {
        int blurRadius = this.mAppCompatConfiguration.getLetterboxBackgroundWallpaperBlurRadiusPx();
        return Math.max(blurRadius, 0);
    }

    float getLetterboxWallpaperDarkScrimAlpha() {
        float alpha = this.mAppCompatConfiguration.getLetterboxBackgroundWallpaperDarkScrimAlpha();
        if (alpha >= 0.0f) goto L5;
        return 0.0f;
    L5:
        if (alpha < 1.0f) goto L8;
        return 0.0f;
    L8:
        return alpha;
    }

    boolean isLetterboxWallpaperBlurSupported() {
        return ((WindowManager) this.mAppCompatConfiguration.mContext.getSystemService(WindowManager.class)).isCrossWindowBlurEnabled();
    }
}

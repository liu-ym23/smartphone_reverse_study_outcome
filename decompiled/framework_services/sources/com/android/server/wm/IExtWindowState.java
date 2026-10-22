package com.android.server.wm;

import android.graphics.Point;
import android.graphics.Rect;
import android.pico.utils.IExtBase;
import android.view.SurfaceControl;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtWindowState extends IExtBase {
    boolean cannotRelativeToIme();

    Rect getLastAttachedFrame();

    float getResolutionScaleByUser();

    boolean isForceStatusBarController();

    boolean isNeedShowWhenLockedWallpaper();

    boolean isSmtLauncher();

    boolean isSplashStartingWindow();

    void onAssignLayer(SurfaceControl.Transaction r1);

    void onInitCompleted();

    void onSurfaceShownChanged(SurfaceControl.Transaction r1, boolean r2);

    void reportImeWindowShown(boolean r1);

    void reportWindowModeChange(int r1);

    void setLastAttachedFrame(Rect r1);

    void setNeedShowWhenLockedWallpaper(boolean r1);

    boolean shouldApplyDims();

    void updateResolutionScaleToServer(float r1);

    default boolean isWmTraceEnable() {
        return false;
    }

    default void tracePerformShowLocked(String winName) {
    }

    default void traceWindowFrame(String winName, boolean isFirstFrame, Rect frame, WindowManager.LayoutParams attrs) {
    }

    default boolean shouldSkipShowIme() {
        return false;
    }

    default int adjustRequestedVisibleTypes(int requestedVisibleTypes) {
        return requestedVisibleTypes;
    }

    default boolean computeMoveAnimationOldPosition(Point oldPosition) {
        return false;
    }

    default boolean shouldForceShowWallpaper() {
        return false;
    }
}

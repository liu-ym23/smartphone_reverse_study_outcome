package com.android.server.wm;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.os.IBinder;
import android.pico.utils.IExtBase;
import android.view.DisplayInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtDisplayContent extends IExtBase {
    public static final float[] mFloat9 = null;

    void collectFixedRotationLaunchingApp(ActivityRecord r1);

    WindowState findFocusedObricTaskViewWindow();

    DisplayFrames getFixedRotatedDisplayFrames();

    DisplayInfo getFixedRotatedDisplayInfo();

    Matrix getFixedRotatedMatrix(int r1, int r2);

    Configuration getFixedRotatedOverrideConfiguration();

    boolean hasFocusedWindowAboveKeyguard();

    void init(Context r1);

    boolean isObricVirtualDisplay();

    boolean okToAnimate();

    void onApplyRotation(int r1, int r2);

    void onWindowSecureChanged(boolean r1);

    void remove(Context r1);

    boolean restoreResolutionFromForcedProperties();

    boolean setForcedDisplayDensityAndSize(int r1, int r2, int r3, int r4);

    boolean shouldSkipUpdateOrientationForDiffOrienLaunchingApp();

    void updateFixedRotatedWindow();

    static {
        mFloat9 = new float[9];
    }

    default void onDisplayOrientationChanged(int orientation) {
    }

    default boolean hasRemoteTransition() {
        return false;
    }

    default boolean hideImeForFreeformIfNeeded(WindowState imeTarget, boolean hideImeWindow) {
        return false;
    }

    default boolean shouldDeferFixedRotationForNonTopVisibleActivity(ActivityRecord ar) {
        return false;
    }

    default boolean shouldSkipFixedRotationReleaseForSplitReplace(ActivityRecord finishActivity) {
        return false;
    }

    default boolean shouldRejectSplitReplaceSelectingFocusWindow(WindowState win) {
        return false;
    }

    default boolean shouldSkipStatusBarForceShowingAndConsuming() {
        return false;
    }

    default boolean shouldDeferUpdateOrientationForSplit(int req, int lastOrientation, boolean forceUpdate, int displayId) {
        return false;
    }

    default void finishDeferUpdateOrientationForSplit() {
    }

    default void recordScreenshotSourceWindow() {
    }

    default boolean isScreenshotSourceWindow(WindowState w) {
        return false;
    }

    default WindowState getScreenshotSourceWindow() {
        return null;
    }

    default void clearScreenshotSourceWindowIfMatch(IBinder client) {
    }

    default WindowState adjustScrollCaptureTargetWindow(WindowState targetWindow, int taskId) {
        return targetWindow;
    }
}

package com.android.server.wm;

import android.pico.utils.IExtBase;
import android.view.SurfaceControl;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtKeyguardController extends IExtBase {
    void dump(PrintWriter r1, String r2);

    void init(ActivityTaskManagerService r1);

    boolean isKeyguardOccluded();

    boolean isKeyguardShowing();

    boolean okToAnimate();

    void onApplyRotation(SurfaceControl.Transaction r1, int r2);

    void onKeyguardOccludedChanged(boolean r1, ActivityRecord r2);

    void onScreenTurningOff();

    void onScreenTurningOn();

    void onStackOrderChanged(TaskDisplayArea r1);

    void onSurfaceShownChanged(SurfaceControl.Transaction r1, boolean r2);

    void setForceHideKeyguard(boolean r1);

    void setKeyguardShown(boolean r1, boolean r2);

    void updateKeyguardSleepToken(int r1);

    default void scheduleWallpaperRedoOnKeyguardGone(boolean keyguardChanged, boolean keyguardShowing, int displayId, DisplayContent dc) {
    }

    default void traceOccludedChanged(boolean occluded, ActivityRecord topOccludesActivity, ActivityRecord dismissingKeyguardActivity, ActivityRecord topActivity, int displayId) {
    }
}

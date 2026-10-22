package com.android.server.wm;

import android.pico.utils.IExtBase;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtWindowStateAnimator extends IExtBase {
    float getAlphaMulti();

    void setAlphaMulti(float r1);

    void showWallpaperWhenLockScreenUnderOccludedWindowIfNeeded(SurfaceControl.Transaction r1);
}

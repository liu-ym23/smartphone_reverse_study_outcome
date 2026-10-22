package com.android.server.wm;

import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes3.dex */
public class WindowStateAnimatorSmtEx {
    private WindowStateAnimator mWindowStateAnimator;

    public WindowStateAnimatorSmtEx(WindowStateAnimator windowStateAnimator) {
        this.mWindowStateAnimator = windowStateAnimator;
    }

    void stopFreezingScreen() {
    }

    SurfaceControl getSurfaceControl() {
        return this.mWindowStateAnimator.mSurfaceControl;
    }
}

package com.android.server.wm;

import android.graphics.Rect;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes3.dex */
interface AppCompatLetterboxPolicyState {
    void getLetterboxInnerBounds(Rect r1);

    Rect getLetterboxInsets();

    void getLetterboxOuterBounds(Rect r1);

    void hide();

    boolean isFullyTransparentBarAllowed(Rect r1);

    boolean isRunning();

    void layoutLetterboxIfNeeded(WindowState r1);

    void onMovedToDisplay(int r1);

    void stop();

    void updateLetterboxSurfaceIfNeeded(WindowState r1, SurfaceControl.Transaction r2, SurfaceControl.Transaction r3);
}

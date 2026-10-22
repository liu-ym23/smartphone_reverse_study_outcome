package com.android.server.accessibility.magnification;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public final class MouseEventHandler {
    private final FullScreenMagnificationController mFullScreenMagnificationController;

    public MouseEventHandler(FullScreenMagnificationController fullScreenMagnificationController) {
        this.mFullScreenMagnificationController = fullScreenMagnificationController;
    }

    public void onEvent(MotionEvent event, int displayId) {
        if (event.getClassification() == 0) goto L5;
        boolean isSynthesizedFromTouchpad = true;
    L6:
        if (isSynthesizedFromTouchpad == true) goto L20;
        if (event.getAction() != 7) goto L10;
    L15:
        float eventX = event.getX();
        float eventY = event.getY();
        if (this.mFullScreenMagnificationController.magnificationRegionContains(displayId, eventX, eventY) == false) goto L23;
        this.mFullScreenMagnificationController.setCenter(displayId, eventX, eventY, false, 0);
        return;
    L23:
        return;
    L10:
        if (event.getAction() != 2) goto L21;
        if (event.getSource() == 8194) goto L15;
    L21:
        return;
    L20:
        return;
    L5:
        isSynthesizedFromTouchpad = false;
        goto L6
    }
}

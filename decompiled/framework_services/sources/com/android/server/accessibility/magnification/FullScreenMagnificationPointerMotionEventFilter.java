package com.android.server.accessibility.magnification;

import com.android.server.input.InputManagerInternal;

/* JADX INFO: loaded from: classes.dex */
public class FullScreenMagnificationPointerMotionEventFilter implements InputManagerInternal.AccessibilityPointerMotionFilter {
    private final FullScreenMagnificationController mController;

    public FullScreenMagnificationPointerMotionEventFilter(FullScreenMagnificationController controller) {
        this.mController = controller;
    }

    @Override // com.android.server.input.InputManagerInternal.AccessibilityPointerMotionFilter
    public float[] filterPointerMotionEvent(float dx, float dy, float currentX, float currentY, int displayId) {
        if (this.mController.isActivated(displayId) == false) goto L5;
        float scale = this.mController.getScale(displayId);
        float newCursorX = currentX + dx;
        float newCursorY = currentY + dy;
        this.mController.setOffset(displayId, newCursorX - (newCursorX * scale), newCursorY - (newCursorY * scale), 0);
        return new float[]{dx, dy};
    L5:
        return new float[]{dx, dy};
    }
}

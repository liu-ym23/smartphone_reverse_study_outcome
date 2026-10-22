package com.stepos.launcher.assistant.slidepanel;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class OverlayControllerSlidingPanelLayout extends SlidingPanelLayout {
    private final ScrollOverlayComponent mOverlayController;

    public OverlayControllerSlidingPanelLayout(Context context, ScrollOverlayComponent scrollOverlayComponent) {
        super(context);
        this.mOverlayController = scrollOverlayComponent;
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelLayout
    public void determineScrollingStart(MotionEvent motionEvent, float f10) {
        if (motionEvent.findPointerIndex(this.mActivePointerId) != -1) {
            float fAbs = Math.abs(motionEvent.getX() - this.mDownX);
            float fAbs2 = Math.abs(motionEvent.getY() - this.mDownY);
            if (Float.compare(fAbs, 0.0f) != 0) {
                float fAtan = (float) Math.atan(fAbs2 / fAbs);
                if (this.mIsPanelOpen) {
                    boolean z10 = this.mIsPageMoving;
                }
                if (fAtan > 1.0471976f) {
                    return;
                }
                if (fAtan > 0.5235988f) {
                    super.determineScrollingStart(motionEvent, (((float) Math.sqrt((fAtan - 0.5235988f) / 0.5235988f)) * 4.0f) + 1.0f);
                } else {
                    super.determineScrollingStart(motionEvent, f10);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return !this.mOverlayController.fitSystemWindows || super.fitSystemWindows(rect);
    }
}

package com.stepos.launcher.assistant.slidepanel;

import android.view.WindowManager;

/* loaded from: classes.dex */
public final class TransparentOverlayController implements SlidingPanelDragListener {
    private final ScrollOverlayComponent mScrollOverlayComponent;

    public TransparentOverlayController(ScrollOverlayComponent scrollOverlayComponent) {
        this.mScrollOverlayComponent = scrollOverlayComponent;
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void close() {
        WindowManager.LayoutParams attributes = this.mScrollOverlayComponent.mWindow.getAttributes();
        float f10 = attributes.alpha;
        attributes.alpha = 0.0f;
        if (f10 != 0.0f) {
            this.mScrollOverlayComponent.mWindow.setAttributes(attributes);
        }
        this.mScrollOverlayComponent.setTouchable(false);
        PanelState panelState = this.mScrollOverlayComponent.getPanelState();
        PanelState panelState2 = PanelState.CLOSED;
        if (panelState != panelState2) {
            this.mScrollOverlayComponent.setPanelState(panelState2);
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void closing(boolean z10) {
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void dragTouchable() {
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void open() {
        this.mScrollOverlayComponent.setTouchable(true);
        WindowManager.LayoutParams attributes = this.mScrollOverlayComponent.mWindow.getAttributes();
        float f10 = attributes.alpha;
        attributes.alpha = 1.0f;
        if (f10 != 1.0f) {
            this.mScrollOverlayComponent.mWindow.setAttributes(attributes);
        }
        this.mScrollOverlayComponent.setPanelState(PanelState.OPEN_AS_LAYER);
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void overlayScrollChanged(float f10) {
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void startDrag() {
    }
}

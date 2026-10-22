package com.stepos.launcher.assistant.slidepanel;

import android.util.Log;
import android.view.WindowManager;

/* loaded from: classes.dex */
public final class OverlayControllerStateChanger implements SlidingPanelDragListener {
    private static final String RECENTS_OVERLAY_DBG = "RecentsOverlayDbg";
    private static final String TAG = "SlidingPanelDragListener";
    private final ScrollOverlayComponent mOverlayController;

    public OverlayControllerStateChanger(ScrollOverlayComponent scrollOverlayComponent) {
        this.mOverlayController = scrollOverlayComponent;
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void close() {
        Log.d(TAG, "close");
        ScrollOverlayComponent scrollOverlayComponent = this.mOverlayController;
        if (scrollOverlayComponent.mWindow != null) {
            scrollOverlayComponent.setFocusable(false);
            this.mOverlayController.setTouchable(false);
            WindowManager.LayoutParams attributes = this.mOverlayController.mWindow.getAttributes();
            float f10 = attributes.alpha;
            attributes.alpha = 0.0f;
            if (f10 != 0.0f) {
                this.mOverlayController.mWindow.setAttributes(attributes);
            }
            this.mOverlayController.setPanelState(PanelState.CLOSED);
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void closing(boolean z10) {
        Log.d(TAG, "closing :" + z10);
        PanelState panelState = this.mOverlayController.getPanelState();
        PanelState panelState2 = PanelState.DRAGGING;
        if (panelState != panelState2) {
            this.mOverlayController.setPanelState(panelState2);
        }
        this.mOverlayController.setFocusable(false);
        this.mOverlayController.setTouchable(false);
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void dragTouchable() {
        Log.d(TAG, "dragTouchable");
        PanelState panelState = this.mOverlayController.getPanelState();
        PanelState panelState2 = PanelState.DRAGGING;
        if (panelState != panelState2) {
            this.mOverlayController.setPanelState(panelState2);
        }
        this.mOverlayController.prepareOverlayWindowForInput();
        if (this.mOverlayController.isOverlayInputSuspendedByRecents()) {
            Log.d(RECENTS_OVERLAY_DBG, "dragTouchable touch/focus skipped: recents suspended");
        } else {
            this.mOverlayController.setTouchable(true);
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void open() {
        Log.d(TAG, "open");
        this.mOverlayController.setPanelState(PanelState.OPEN_AS_DRAWER);
        this.mOverlayController.prepareOverlayWindowForInput();
        if (this.mOverlayController.isOverlayInputSuspendedByRecents()) {
            Log.d(RECENTS_OVERLAY_DBG, "open focus/touch deferred: recents suspended");
            this.mOverlayController.onOverlayOpenInputDeferredByRecents();
        } else {
            this.mOverlayController.setFocusable(true);
            this.mOverlayController.setTouchable(true);
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void overlayScrollChanged(float f10) {
        Log.d(TAG, "overlayScrollChanged position:" + f10);
        if (this.mOverlayController.mCallback == null || Float.isNaN(f10)) {
            Log.w("MinusOneCloseDbg", "overlayScrollChanged dropped: callback null progress=" + f10);
            return;
        }
        try {
            this.mOverlayController.mCallback.overlayScrollChanged(f10);
        } catch (Throwable th) {
            Log.e("wo.OverlayController", "Error notfying client", th);
        }
    }

    @Override // com.stepos.launcher.assistant.slidepanel.SlidingPanelDragListener
    public void startDrag() {
        Log.d(TAG, "startDrag");
        WindowManager.LayoutParams attributes = this.mOverlayController.mWindow.getAttributes();
        if (1.0f != attributes.alpha) {
            attributes.alpha = 1.0f;
            this.mOverlayController.mWindow.setAttributes(attributes);
        }
    }
}

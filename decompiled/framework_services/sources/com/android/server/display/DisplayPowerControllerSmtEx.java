package com.android.server.display;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayPowerControllerSmtEx {
    private DisplayPowerController mController;
    protected boolean mRequestFromCallLock;

    public DisplayPowerControllerSmtEx(DisplayPowerController controller) {
        this.mRequestFromCallLock = false;
        this.mController = controller;
    }

    public float getScreenBrightness() {
        return this.mController.mPowerState.getScreenBrightness();
    }
}

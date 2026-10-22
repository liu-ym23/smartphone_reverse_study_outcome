package com.android.server.display.state;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayStateControllerSmtEx {
    private final DisplayStateController mController;
    protected boolean mRequestFromCallLock;

    public DisplayStateControllerSmtEx(DisplayStateController displayStateController) {
        this.mRequestFromCallLock = false;
        this.mController = displayStateController;
    }
}

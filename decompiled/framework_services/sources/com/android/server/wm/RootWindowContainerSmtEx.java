package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public class RootWindowContainerSmtEx extends RootWindowContainerSmtBase {
    WindowState mHoldPcScreenWindow;
    boolean mPhoneStateIdel;

    public RootWindowContainerSmtEx(RootWindowContainer container) {
        super(container);
        this.mHoldPcScreenWindow = null;
        this.mPhoneStateIdel = true;
    }

    public Task getTopDisplayFullScreenTask() {
        TaskDisplayArea taskDisplayArea = this.mContainer.getDefaultTaskDisplayArea();
        return taskDisplayArea.getRootTask(1, 0);
    }
}

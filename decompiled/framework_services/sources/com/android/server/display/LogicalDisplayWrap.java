package com.android.server.display;

import android.view.DisplayInfo;

/* JADX INFO: loaded from: classes2.dex */
public class LogicalDisplayWrap {
    private static final String TAG = "NDMCtrl.LogicalDisplayWrap";
    LogicalDisplay mLogicalDisplay;

    public LogicalDisplayWrap(LogicalDisplay display) {
        this.mLogicalDisplay = null;
        this.mLogicalDisplay = display;
    }

    public LogicalDisplay getLogicalDisplay() {
        return this.mLogicalDisplay;
    }

    public int getDisplayIdLocked() {
        if (this.mLogicalDisplay != null) goto L7;
        return -1;
    L7:
        return this.mLogicalDisplay.getDisplayIdLocked();
    }

    public DisplayInfo getDisplayInfoLocked() {
        if (this.mLogicalDisplay != null) goto L7;
        return null;
    L7:
        return this.mLogicalDisplay.getDisplayInfoLocked();
    }

    public DisplayDevice getPrimaryDisplayDeviceLocked() {
        return this.mLogicalDisplay.getPrimaryDisplayDeviceLocked();
    }

    public String getPrimaryDisplayDeviceUniqueId() {
        if (this.mLogicalDisplay != null) goto L5;
        return null;
    L5:
        if (this.mLogicalDisplay.getPrimaryDisplayDeviceLocked() != null) goto L8;
        return null;
    L8:
        return this.mLogicalDisplay.getPrimaryDisplayDeviceLocked().getUniqueId();
    }

    public String toString() {
        if (this.mLogicalDisplay != null) goto L7;
        return "null";
    L7:
        return this.mLogicalDisplay.toString();
    }
}

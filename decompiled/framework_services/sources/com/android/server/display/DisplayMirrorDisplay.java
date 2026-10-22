package com.android.server.display;

import android.util.SparseArray;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayMirrorDisplay {
    private static final String TAG = "NDMCtrl.DisplayMirrorDisplay";
    private SparseArray<LogicalDisplay> mLogicalDisplays;

    public interface DisplayContentProxy {
        SurfaceControl getSurfaceControl();

        SurfaceControl.Builder makeSurface();
    }

    public DisplayMirrorDisplay() {
        this.mLogicalDisplays = null;
    }

    public void setLogicalDisplays(SparseArray<LogicalDisplay> logicalDisplays) {
        this.mLogicalDisplays = logicalDisplays;
    }

    public void updateLogicalDisplay(SparseArray<LogicalDisplayWrap> logicalDisplayWraps) {
        logicalDisplayWraps.clear();
        int count = this.mLogicalDisplays.size();
        int i = 0;
    L3:
        if (i >= count) goto L6;
        LogicalDisplay logicalDisplay = this.mLogicalDisplays.valueAt(i);
        logicalDisplayWraps.put(logicalDisplay.getDisplayIdLocked(), new LogicalDisplayWrap(logicalDisplay));
        i = i + 1;
        goto L3
    }

    public void changeDisplayDeviceInfoIfNeed(DisplayDeviceInfo info, LogicalDisplayWrap display) {
        DisplayDeviceInfo defaultInfo = display.getPrimaryDisplayDeviceLocked().getDisplayDeviceInfoLocked();
        info.displayCutout = defaultInfo.displayCutout;
        info.rotation = defaultInfo.rotation;
        info.frameRateOverrides = defaultInfo.frameRateOverrides;
        info.roundedCorners = defaultInfo.roundedCorners;
        info.colorMode = defaultInfo.colorMode;
        info.supportedColorModes = defaultInfo.supportedColorModes;
        info.hdrCapabilities = defaultInfo.hdrCapabilities;
    }

    public LogicalDisplay getLogicalDisplayById(int displayId) {
        return this.mLogicalDisplays.get(displayId);
    }
}

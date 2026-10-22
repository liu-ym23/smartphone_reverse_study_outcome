package com.android.server.display;

import android.hardware.display.DisplayManagerGlobal;
import android.view.DisplayInfo;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayInfoProxy {
    private DisplayInfo mInfo;

    public DisplayInfoProxy(DisplayInfo info) {
        this.mInfo = info;
    }

    public void set(DisplayInfo info) {
        this.mInfo = info;
        DisplayManagerGlobal.invalidateLocalDisplayInfoCaches();
    }

    public DisplayInfo get() {
        return this.mInfo;
    }
}

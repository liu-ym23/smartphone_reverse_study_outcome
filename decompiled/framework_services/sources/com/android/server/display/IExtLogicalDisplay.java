package com.android.server.display;

import android.pico.utils.IExtBase;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtLogicalDisplay extends IExtBase {
    void setDisplayFlagsLocked(SurfaceControl.Transaction r1, DisplayDevice r2);
}

package com.android.server.wm;

import android.pico.utils.IExtBase;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtDimmerAnimationHelper extends IExtBase {
    void reparent(Dimmer.DimState r1, SurfaceControl r2, WindowContainer<?> r3, WindowContainer<?> r4, SurfaceControl.Transaction r5);
}

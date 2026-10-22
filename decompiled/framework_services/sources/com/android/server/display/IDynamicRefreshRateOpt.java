package com.android.server.display;

import android.content.Context;
import android.os.Handler;
import android.view.DisplayInfo;
import android.view.SurfaceControl;
import com.android.server.display.mode.DisplayModeDirector;

/* JADX INFO: loaded from: classes2.dex */
public interface IDynamicRefreshRateOpt {
    default void init(Context context, Handler handler, Object syncRoot, LogicalDisplayMapper logicalDisplayMapper, DisplayModeDirector displayModeDirector) {
    }

    default SurfaceControl.DynamicDisplayInfo updateDefaultDisplaySupportMode() {
        return null;
    }

    default DisplayModeDirector.DesiredDisplayModeSpecs getCurrentDisplayModeSpecs() {
        return null;
    }

    default DisplayInfo getDefaultDisplayInfo() {
        return null;
    }

    default void shouldUpdateDisplayModeSpecs(SurfaceControl.DesiredDisplayModeSpecs modeSpecs) {
    }

    default void notifyDesiredDisplayModeSpecsChanged() {
    }
}

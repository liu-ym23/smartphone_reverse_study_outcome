package com.android.server.wm;

import android.view.SurfaceControl;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricWindowState extends IObricBase {
    default void onAssignLayer(SurfaceControl.Transaction t) {
    }

    default void setShouldShowWhenLocked(boolean show) {
    }

    default boolean shouldShowWhenLocked() {
        return false;
    }

    default void onSurfaceShownChanged(boolean shown) {
    }
}

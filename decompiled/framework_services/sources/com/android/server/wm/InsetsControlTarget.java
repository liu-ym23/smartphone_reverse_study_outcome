package com.android.server.wm;

import android.os.IBinder;
import android.view.WindowInsets;
import android.view.inputmethod.ImeTracker;

/* JADX INFO: loaded from: classes3.dex */
interface InsetsControlTarget extends InsetsTarget {
    default void notifyInsetsControlChanged(int displayId) {
    }

    default WindowState getWindow() {
        return null;
    }

    @Override // com.android.server.wm.InsetsTarget
    default IBinder getWindowToken() {
        return null;
    }

    @Override // com.android.server.wm.InsetsTarget
    default boolean isRequestedVisible(int types) {
        if ((WindowInsets.Type.defaultVisible() & types) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.wm.InsetsTarget
    default int getRequestedVisibleTypes() {
        return WindowInsets.Type.defaultVisible();
    }

    default void showInsets(int types, boolean fromIme, ImeTracker.Token statsToken) {
    }

    default void hideInsets(int types, boolean fromIme, ImeTracker.Token statsToken) {
    }

    default boolean canShowTransient() {
        return false;
    }

    default void setImeInputTargetRequestedVisibility(boolean visible, ImeTracker.Token statsToken) {
    }

    default int getAnimatingTypes() {
        return 0;
    }

    default void setAnimatingTypes(int animatingTypes, ImeTracker.Token statsToken) {
    }

    static WindowState asWindowOrNull(InsetsControlTarget target) {
        if (target != null) goto L6;
        return null;
    L6:
        return target.getWindow();
    }
}

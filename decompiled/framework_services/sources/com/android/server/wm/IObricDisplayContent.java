package com.android.server.wm;

import android.content.res.Configuration;
import android.view.DisplayCutout;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricDisplayContent extends IObricBase {
    default void onWindowSecureChanged(boolean secure) {
    }

    default DisplayCutout calculateDisplayCutoutForRotation(int rotation) {
        return null;
    }

    default void onDisplayRemoval() {
    }

    default void onFocusChanged(WindowState oldFocus, WindowState newFocus) {
    }

    default void onWindowRemoved(WindowState window) {
    }

    default void calculateScreenConfiguration(Configuration config) {
    }

    default void syncObricDisplayOverride() {
    }
}

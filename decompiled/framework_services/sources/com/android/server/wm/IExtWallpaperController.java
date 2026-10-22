package com.android.server.wm;

import android.pico.utils.IExtBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtWallpaperController extends IExtBase {
    boolean keepVisibleIfNeed(WindowState r1, boolean r2, boolean r3, boolean r4);

    default boolean isWmTraceEnable() {
        return false;
    }

    default void traceNewWallpaperTarget(Object wallpaperTarget, Object prevTarget) {
    }
}

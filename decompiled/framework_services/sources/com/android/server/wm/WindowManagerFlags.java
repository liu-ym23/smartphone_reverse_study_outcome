package com.android.server.wm;

import android.app.AppGlobals;

/* JADX INFO: loaded from: classes3.dex */
class WindowManagerFlags {
    final boolean mAllowsScreenSizeDecoupledFromStatusBarAndCutout;
    final boolean mAodTransition;
    final boolean mEnsureWallpaperInTransitions;
    final boolean mInsetsDecoupledConfiguration;
    final boolean mRespectNonTopVisibleFixedOrientation;
    final boolean mWallpaperOffsetAsync;

    WindowManagerFlags() {
        this.mWallpaperOffsetAsync = true;
        this.mAllowsScreenSizeDecoupledFromStatusBarAndCutout = true;
        this.mInsetsDecoupledConfiguration = true;
        this.mRespectNonTopVisibleFixedOrientation = true;
        this.mAodTransition = false;
        boolean isWatch = AppGlobals.getPackageManager().hasSystemFeature("android.hardware.type.watch", 0);     // Catch: Throwable -> L5
    L7:
        if (isWatch == true) goto L10;
    L10:
        this.mEnsureWallpaperInTransitions = true;
        return;
    L6:
        isWatch = false;
        goto L7
    }
}

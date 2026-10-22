package com.android.server.wm;

import android.window.TaskSnapshot;

/* JADX INFO: loaded from: classes3.dex */
class SplashScreenStartingData extends StartingData {
    private final TaskSnapshot mSnapshot;
    private final int mTheme;

    SplashScreenStartingData(WindowManagerService service, int theme, int typeParams, TaskSnapshot snapshot) {
        super(service, typeParams);
        this.mTheme = theme;
        this.mSnapshot = snapshot;
    }

    SplashScreenStartingData(WindowManagerService service, int theme, int typeParams) {
        this(service, theme, typeParams, null);
    }

    @Override // com.android.server.wm.StartingData
    StartingSurfaceController.StartingSurface createStartingSurface(ActivityRecord activity) {
        return this.mService.mStartingSurfaceController.createSplashScreenStartingSurface(activity, this.mTheme, this.mSnapshot);
    }

    @Override // com.android.server.wm.StartingData
    boolean needRevealAnimation() {
        return true;
    }
}

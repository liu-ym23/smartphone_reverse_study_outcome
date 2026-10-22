package com.android.server.wallpaper;

import android.app.IWallpaperManager;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
interface IWallpaperManagerService extends IWallpaperManager, IBinder {
    void onBootPhase(int r1);

    void onUnlockUser(int r1);
}

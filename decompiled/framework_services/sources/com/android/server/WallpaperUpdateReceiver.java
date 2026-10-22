package com.android.server;

import android.app.ActivityThread;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class WallpaperUpdateReceiver extends BroadcastReceiver {
    private static final boolean DEBUG = false;
    private static final String TAG = "WallpaperUpdateReceiver";

    public static /* synthetic */ void $r8$lambda$OHZiJO_XDLx35rrZdZ9edsGpdRA(WallpaperUpdateReceiver r0) {
        r0.updateWallpaper();
    }

    public WallpaperUpdateReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) goto L4;
        return;
    L4:
        if ("android.intent.action.DEVICE_CUSTOMIZATION_READY".equals(intent.getAction()) == false) goto L8;
        AsyncTask.execute(new WallpaperUpdateReceiver$$ExternalSyntheticLambda0(this));
        return;
    }

    private void updateWallpaper() {
        ActivityThread currentActivityThread = ActivityThread.currentActivityThread();     // Catch: Exception -> L7
        Context uiContext = currentActivityThread.getSystemUiContext();     // Catch: Exception -> L7
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(uiContext);     // Catch: Exception -> L7
        if (isUserSetWallpaper(wallpaperManager, uiContext) == false) goto L10;
        Slog.i(TAG, "User has set wallpaper, skip to resetting");     // Catch: Exception -> L7
        return;
    L10:
        if (wallpaperManager.getWallpaperInfo() != null) goto L17;
        wallpaperManager.clearWallpaper();     // Catch: Exception -> L7
        return;
    L17:
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to customize system wallpaper." + e);
    }

    private boolean isUserSetWallpaper(WallpaperManager wm, Context context) {
        WallpaperInfo info = wm.getWallpaperInfo();
        if (info != null) goto L10;
        ParcelFileDescriptor sysWallpaper = wm.getWallpaperFile(1);
        ParcelFileDescriptor lockWallpaper = wm.getWallpaperFile(2);
        if (sysWallpaper != null) goto L9;
        if (lockWallpaper != null) goto L9;
        return false;
    L9:
        return true;
    L10:
        ComponentName currCN = info.getComponent();
        ComponentName defaultCN = WallpaperManager.getCmfDefaultWallpaperComponent(context);
        if (currCN.equals(defaultCN) == true) goto L13;
        return true;
    L13:
        return false;
    }
}

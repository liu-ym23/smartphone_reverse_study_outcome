package com.android.server.wallpaper;

import android.app.IWallpaperManagerExt;
import android.os.IBinder;
import android.pico.utils.IExtBase;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public interface IExtWallpaperManagerService extends IExtBase {
    int enableWPmsDebugConfig(WallpaperManagerShellCommand r1, PrintWriter r2);

    IWallpaperManagerExt getIExt();

    ExtWallpaperManagerInternal getLocalService();

    void traceBindWallpaperComponent(String r1, int r2, int r3);

    void traceConnectLocked(String r1, int r2, int r3, int r4, IBinder r5);

    void traceDetachWallpaperLocked(WallpaperData r1);

    void traceDisconnectLocked(Object r1, IBinder r2);

    void traceSetWallpaper(String r1, int r2, int r3);

    void traceSetWallpaperDescriptionInternal(String r1, int r2, int r3, boolean r4);

    void traceUpdateWallpapers(int r1, String r2, WallpaperData r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10);
}

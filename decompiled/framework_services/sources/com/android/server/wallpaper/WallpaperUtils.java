package com.android.server.wallpaper;

import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class WallpaperUtils {
    static final String RECORD_FILE = "decode_record";
    static final String RECORD_LOCK_FILE = "decode_lock_record";
    static final String WALLPAPER = "wallpaper_orig";
    static final String WALLPAPER_CROP = "wallpaper";
    static final String WALLPAPER_INFO = "wallpaper_info.xml";
    static final String WALLPAPER_LOCK_CROP = "wallpaper_lock";
    static final String WALLPAPER_LOCK_ORIG = "wallpaper_lock_orig";
    private static final String[] sPerUserFiles = null;
    private static int sWallpaperId;

    WallpaperUtils() {
    }

    static {
        sPerUserFiles = new String[]{WALLPAPER, WALLPAPER_CROP, WALLPAPER_LOCK_ORIG, WALLPAPER_LOCK_CROP, WALLPAPER_INFO};
    }

    static File getWallpaperDir(int userId) {
        return Environment.getUserSystemDirectory(userId);
    }

    static int makeWallpaperIdLocked() {
    L2:
        sWallpaperId++;
        if (sWallpaperId == 0) goto L2;
        return sWallpaperId;
    }

    static int getCurrentWallpaperId() {
        return sWallpaperId;
    }

    static void setCurrentWallpaperId(int id) {
        sWallpaperId = id;
    }

    static List<File> getWallpaperFiles(int userId) {
        File wallpaperDir = getWallpaperDir(userId);
        List<File> result = new ArrayList();
        int i = 0;
    L4:
        if (i >= sPerUserFiles.length) goto L7;
        result.add(new File(wallpaperDir, sPerUserFiles[i]));
        i = i + 1;
        goto L4
    L7:
        return result;
    }
}

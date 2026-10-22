package com.danikula.videocache;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
final class StorageUtils {
    private static final String INDIVIDUAL_DIR_NAME = "video-cache";

    public StorageUtils() {
    }

    private static File getCacheDirectory(Context r10, boolean r11) {
        String r12 = Environment.getExternalStorageState();     // Catch: NullPointerException -> L4
    L5:
        if (r11 == true) goto L7;
    L9:
        File r13 = null;
    L10:
        if (r13 != null) goto L12;
        r13 = r10.getCacheDir();
    L12:
        if (r13 != null) goto L17;
        String r14 = "/data/data/" + r10.getPackageName() + "/cache/";
        KLog.w("Can't define system cache directory! '" + r14 + "%s' will be used.");
        return new File(r14);
    L17:
        return r13;
    L7:
        if ("mounted".equals(r12) == false) goto L9;
        r13 = getExternalCacheDir(r10);
    L4:
        r12 = "";
        goto L5
    }

    private static File getExternalCacheDir(Context r10) {
        File r11 = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), r10.getPackageName()), "cache");
        if (r11.exists() == false) goto L5;
    L8:
        return r11;
    L5:
        if (r11.mkdirs() == true) goto L8;
        KLog.w("Unable to create external cache directory");
        return null;
    }

    public static File getIndividualCacheDirectory(Context r10) {
        return new File(getCacheDirectory(r10, true), INDIVIDUAL_DIR_NAME);
    }
}

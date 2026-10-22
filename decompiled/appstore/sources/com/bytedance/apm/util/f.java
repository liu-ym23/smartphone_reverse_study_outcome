package com.bytedance.apm.util;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    static {
    }

    public static File a(Context r10) {
        File r11 = null;
        if (r10 != null) goto L10;
        return null;
    L10:
        r11 = r10.getExternalFilesDir(null);     // Catch: Throwable -> L9
    L6:
        r11 = r11.getParentFile();     // Catch: Throwable -> L9
        if (r11.getAbsolutePath().contains("/Android") == true) goto L6;
    L8:
        return r11;
    }

    public static long b(File r10) {
        long r11 = -1;
        if (r10.exists() == true) goto L6;
        return -1;
    L6:
        if (r10.isFile() == false) goto L10;
        return r10.length();
    L10:
        if (r10.isDirectory() == false) goto L14;
        File[] r12 = r10.listFiles();
        int r13 = r12.length;
        r11 = 0;
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L14;
        r11 = r11 + b(r12[r14]);
        r14 = r14 + 1;
    L14:
        return r11;
    }
}

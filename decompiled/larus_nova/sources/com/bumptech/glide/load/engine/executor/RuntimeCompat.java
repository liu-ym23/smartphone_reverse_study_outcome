package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import com.bumptech.glide.util.GlideLogUtil;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes39.dex */
final class RuntimeCompat {
    private static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final String CPU_NAME_REGEX = "cpu[0-9]+";
    private static final String TAG = "GlideRuntimeCompat";

    public static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    private static int getCoreCountPre17() {
        StrictMode.ThreadPolicy r100 = StrictMode.allowThreadDiskReads();
        PolarisFileWrapper r101 = new PolarisFileWrapper(CPU_LOCATION);     // Catch: Throwable -> L5
        final Pattern r102 = Pattern.compile(CPU_NAME_REGEX);     // Catch: Throwable -> L5
        File[] r103 = r101.listFiles(new AnonymousClass1(r102));     // Catch: Throwable -> L5
        StrictMode.setThreadPolicy(r100);
    L8:
        if (r103 == null) goto L10;
        int r104 = r103.length;
    L12:
        return Math.max(1, r104);
    L10:
        r104 = 0;
    L5:
        th = move-exception;
        GlideLogUtil.e(TAG, "Failed to calculate accurate cpu count", th);     // Catch: Throwable -> L13
        StrictMode.setThreadPolicy(r100);
        r103 = null;
    L13:
        th = move-exception;
        StrictMode.setThreadPolicy(r100);
        throw th;
    }

    private RuntimeCompat() {
    }
}

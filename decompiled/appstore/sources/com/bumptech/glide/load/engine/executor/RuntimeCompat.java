package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
final class RuntimeCompat {
    private static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final String CPU_NAME_REGEX = "cpu[0-9]+";
    private static final String TAG = "GlideRuntimeCompat";

    private RuntimeCompat() {
    }

    public static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    private static int getCoreCountPre17() {
        StrictMode.ThreadPolicy r10 = StrictMode.allowThreadDiskReads();
        File r11 = new File(CPU_LOCATION);     // Catch: Throwable -> L5
        final Pattern r12 = Pattern.compile(CPU_NAME_REGEX);     // Catch: Throwable -> L5
        File[] r13 = r11.listFiles(new AnonymousClass1(r12));     // Catch: Throwable -> L5
        StrictMode.setThreadPolicy(r10);
    L14:
        if (r13 == null) goto L16;
        int r14 = r13.length;
    L18:
        return Math.max(1, r14);
    L16:
        r14 = 0;
    L5:
        th = move-exception;
    L11:
        th = move-exception;
        StrictMode.setThreadPolicy(r10);
        throw th;
    L8:
        if (Log.isLoggable(TAG, 6) == false) goto L13;
        Log.e(TAG, "Failed to calculate accurate cpu count", th);     // Catch: Throwable -> L11
    L13:
        StrictMode.setThreadPolicy(r10);
        r13 = null;
        goto L14
    }
}

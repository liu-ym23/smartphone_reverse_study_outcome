package com.android.server;

import android.os.StrictMode;
import android.util.Slog;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ResourcePressureUtil {
    private static final List<String> PSI_FILES = null;
    private static final String PSI_ROOT = "/proc/pressure";
    private static final String TAG = "ResourcePressureUtil";

    public static /* synthetic */ String $r8$lambda$YqRwUJ2GaBiqQtdp5zJtNgfVUt0(String r0) {
        return readResourcePsiState(r0);
    }

    static {
        PSI_FILES = Arrays.asList(new String[]{"/proc/pressure/memory", "/proc/pressure/cpu", "/proc/pressure/io"});
    }

    private static String readResourcePsiState(String filePath) {
        StringWriter contents = new StringWriter();
    L7:
        e = move-exception;
        Slog.e(TAG, " could not read " + filePath, e);
    L12:
        return contents.toString();
    L4:
        if (new File(filePath).exists() == false) goto L12;
        contents.append("----- Output from " + filePath + " -----\n");     // Catch: IOException -> L7
        contents.append(IoUtils.readFileAsString(filePath));     // Catch: IOException -> L7
        contents.append("----- End output from " + filePath + " -----\n");     // Catch: IOException -> L7
        goto L12
    }

    public static String currentPsiState() {
        StrictMode.ThreadPolicy savedPolicy = StrictMode.allowThreadDiskReads();
        final StringWriter aggregatedState = new StringWriter();
        PSI_FILES.stream().map(new ResourcePressureUtil$$ExternalSyntheticLambda0()).forEach(new ResourcePressureUtil$$ExternalSyntheticLambda1(aggregatedState));     // Catch: Throwable -> L9
        StrictMode.setThreadPolicy(savedPolicy);
        String psiState = aggregatedState.toString();
        if (psiState.length() <= 0) goto L8;
        return psiState + "\n";
    L8:
        return psiState;
    L9:
        th = move-exception;
        StrictMode.setThreadPolicy(savedPolicy);
        throw th;
    }

    private ResourcePressureUtil() {
    }
}

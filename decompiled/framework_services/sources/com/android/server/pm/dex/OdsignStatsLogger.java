package com.android.server.pm.dex;

import android.util.Slog;
import com.android.internal.art.ArtStatsLog;
import com.android.internal.os.BackgroundThread;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
public class OdsignStatsLogger {
    private static final String COMPOS_METRIC_NAME = "comp_os_artifacts_check_record";
    private static final String METRICS_FILE = "/data/misc/odsign/metrics/odsign-metrics.txt";
    private static final String ODSIGN_METRIC_NAME = "odsign_record";
    private static final String TAG = "OdsignStatsLogger";

    /* JADX INFO: renamed from: $r8$lambda$5UQTBxO3KU1lWEi5-bo1kDq6QXM, reason: not valid java name */
    public static /* synthetic */ void m7046$r8$lambda$5UQTBxO3KU1lWEi5bo1kDq6QXM() {
        writeStats();
    }

    public OdsignStatsLogger() {
    }

    public static void triggerStatsWrite() {
        BackgroundThread.getExecutor().execute(new OdsignStatsLogger$$ExternalSyntheticLambda0());
    }

    private static void writeStats() {
        String lines = IoUtils.readFileAsString(METRICS_FILE);     // Catch: IOException -> L6 FileNotFoundException -> L46
        if (new File(METRICS_FILE).delete() == true) goto L8;
        Slog.w(TAG, "Failed to delete metrics file");     // Catch: IOException -> L6 FileNotFoundException -> L46
    L8:
        String[] r0 = lines.split("\n");     // Catch: IOException -> L6 FileNotFoundException -> L46
        int r4 = r0.length;     // Catch: IOException -> L6 FileNotFoundException -> L46
        int r6 = 0;
    L9:
        if (r6 >= r4) goto L62;
        String line = r0[r6];     // Catch: IOException -> L6 FileNotFoundException -> L46
        String[] metrics = line.split(" ");     // Catch: IOException -> L6 FileNotFoundException -> L46
        if (line.isEmpty() == true) goto L41;
        if (metrics.length < 1) goto L41;
        String r9 = metrics[0];     // Catch: IOException -> L6 FileNotFoundException -> L46
        switch(r9.hashCode()) {
            case 890271774: goto L22;
            case 1023928721: goto L19;
            default: goto L24;
        };     // Catch: IOException -> L6 FileNotFoundException -> L46
    L24:
        byte r10 = -1;
    L26:
        switch(r10) {
            case 0: goto L38;
            case 1: goto L30;
            default: goto L27;
        };
    L27:
        Slog.w(TAG, "Malformed metrics line '" + line + "'");     // Catch: IOException -> L6 FileNotFoundException -> L46
    L42:
        r6 = r6 + 1;
        goto L9
    L30:
        if (metrics.length == 2) goto L49;
        Slog.w(TAG, "Malformed odsign metrics line '" + line + "'");     // Catch: IOException -> L6 FileNotFoundException -> L46
        goto L42
    L49:
        int status = Integer.parseInt(metrics[1]);     // Catch: IOException -> L6 NumberFormatException -> L35 FileNotFoundException -> L46
        ArtStatsLog.write(ArtStatsLog.ODSIGN_REPORTED, status);     // Catch: IOException -> L6 NumberFormatException -> L35 FileNotFoundException -> L46
    L36:
        Slog.w(TAG, "Malformed odsign metrics line '" + line + "'");     // Catch: IOException -> L6 FileNotFoundException -> L46
        goto L42
    L38:
        if (metrics.length == 4) goto L40;
        Slog.w(TAG, "Malformed CompOS metrics line '" + line + "'");     // Catch: IOException -> L6 FileNotFoundException -> L46
        goto L42
    L40:
        boolean currentArtifactsOk = metrics[1].equals("1");     // Catch: IOException -> L6 FileNotFoundException -> L46
        boolean compOsPendingArtifactsExists = metrics[2].equals("1");     // Catch: IOException -> L6 FileNotFoundException -> L46
        boolean useCompOsGeneratedArtifacts = metrics[3].equals("1");     // Catch: IOException -> L6 FileNotFoundException -> L46
        ArtStatsLog.write(ArtStatsLog.EARLY_BOOT_COMP_OS_ARTIFACTS_CHECK_REPORTED, currentArtifactsOk, compOsPendingArtifactsExists, useCompOsGeneratedArtifacts);     // Catch: IOException -> L6 FileNotFoundException -> L46
        goto L42
    L19:
        if (r9.equals(COMPOS_METRIC_NAME) == false) goto L24;
        r10 = 0;
        goto L26
    L22:
        if (r9.equals(ODSIGN_METRIC_NAME) == false) goto L24;
        r10 = 1;
    L41:
        Slog.w(TAG, "Empty metrics line");     // Catch: IOException -> L6 FileNotFoundException -> L46
        goto L42
        goto L61
    L62:
        return;
    L6:
        e = move-exception;
        Slog.w(TAG, "Reading metrics file failed", e);
        return;
    }
}

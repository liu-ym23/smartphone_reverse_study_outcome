package com.stepos.activeview.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.stepos.activeview.listener.OnZipExtractListener;
import com.stepos.activeview.task.ZipExtractTask;

/* loaded from: classes.dex */
public class ZipExtractor {
    public static AsyncTask extractAssetsFileAsync(Context context, String str, boolean z4, OnZipExtractListener onZipExtractListener) {
        ZipExtractTask zipExtractTask = new ZipExtractTask(context, str, z4, onZipExtractListener);
        zipExtractTask.execute(new Void[0]);
        return zipExtractTask;
    }

    public static String extractFile(String str, Context context) {
        return new ZipExtractTask(str, context).doUnzipSync();
    }

    public static AsyncTask extractFileAsync(String str, Context context, OnZipExtractListener onZipExtractListener) {
        ZipExtractTask zipExtractTask = new ZipExtractTask(str, context, onZipExtractListener);
        zipExtractTask.execute(new Void[0]);
        return zipExtractTask;
    }

    public static AsyncTask extractFileSpecificPath(Context context, String str, OnZipExtractListener onZipExtractListener, String str2) {
        ZipExtractTask zipExtractTask = new ZipExtractTask(context, str, str2, onZipExtractListener);
        zipExtractTask.execute(new Void[0]);
        return zipExtractTask;
    }

    public static boolean extractFileSpecificSync(String str, String str2) {
        return ZipExtractTask.unzip(str, str2);
    }
}

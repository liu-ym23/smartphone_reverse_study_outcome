package com.stepos.activeview.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.stepos.activeview.listener.OnDownloadListener;
import com.stepos.activeview.task.DownloadTask;

/* loaded from: classes.dex */
public class FileDownloader {
    public static String downloadFile(String str, Context context) {
        return new DownloadTask(str, context).doDownloadSync();
    }

    public static AsyncTask downloadFileAsync(String str, Context context, OnDownloadListener onDownloadListener) {
        DownloadTask downloadTask = new DownloadTask(str, context, onDownloadListener);
        downloadTask.execute(new Void[0]);
        return downloadTask;
    }
}

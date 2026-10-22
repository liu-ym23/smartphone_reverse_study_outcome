package com.ss.android.socialbase.downloader.exception;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadOnlyWifiException extends DownloadRetryNeedlessException {
    public DownloadOnlyWifiException() {
        super(DownloadErrorCode.ERROR_ONLY_WIFI, "download only wifi");
    }
}

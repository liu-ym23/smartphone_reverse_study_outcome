package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: loaded from: classes4.dex */
public class StreamClosedException extends BaseException {
    public StreamClosedException(String r2) {
        super(DownloadErrorCode.ERROR_STREAM_CLOSED, r2);
    }
}

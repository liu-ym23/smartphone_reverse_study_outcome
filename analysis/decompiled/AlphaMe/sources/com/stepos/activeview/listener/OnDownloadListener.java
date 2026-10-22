package com.stepos.activeview.listener;

/* loaded from: classes.dex */
public interface OnDownloadListener {
    public static final int DOWNLOAD_FAIL = 0;
    public static final int DOWNLOAD_FILE_DATA_ERROR = 3;
    public static final int DOWNLOAD_FILE_LENGTH_ERROR = 4;
    public static final int DOWNLOAD_SUCESS = 1;

    void onDownloadError(int i4);

    void onDownloadFinished(int i4, String str);

    void onDownloadStart(String str);
}

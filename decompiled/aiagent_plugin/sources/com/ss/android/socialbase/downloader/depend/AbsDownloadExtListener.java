package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsDownloadExtListener extends AbsDownloadListener implements IDownloadExtListener {
    private static final String TAG = "AbsDownloadExtListener";

    static {
    }

    public AbsDownloadExtListener() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadExtListener
    public void onWaitingDownloadCompleteHandler(DownloadInfo r3) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onWaitingDownloadCompleteHandler", "Name:" + r3.getName());
        return;
    L8:
        return;
    }
}

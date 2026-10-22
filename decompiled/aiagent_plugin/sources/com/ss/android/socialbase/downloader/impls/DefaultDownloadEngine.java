package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.thread.DownloadThreadPool;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultDownloadEngine extends AbsDownloadEngine {
    private static final String TAG = "DefaultDownloadEngine";
    private static DownloadThreadPool downloadThreadPool;

    public DefaultDownloadEngine() {
        downloadThreadPool = new DownloadThreadPool();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public boolean isDownloading(int r3) {
        if (downloadThreadPool.containsTask(r3) == true) goto L5;
        return false;
    L5:
        DownloadInfo r2 = getDownloadInfo(r3);
        if (r2 != null) goto L9;
        return false;
    L9:
        if (DownloadStatus.isDownloading(r2.getStatus()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void removeDownloadRunnable(DownloadRunnable r1) {
        downloadThreadPool.removeUnAliveDownloadRunnable(r1);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public Future doDownload(DownloadTask r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (Logger.debugScene(r5.getDownloadInfo()) == false) goto L8;
        Logger.taskDebug(TAG, r5.getDownloadInfo(), "doDownload", "start doDownload for task");
    L8:
        DownloadTimingInfo r0 = r5.getTimingInfo();
        r0.doDownloadTime = System.currentTimeMillis();
        return downloadThreadPool.execute(new DownloadRunnable(r5, this.mainHandler));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doPause(int r1) {
        downloadThreadPool.pause(r1);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public DownloadRunnable doCancel(int r1) {
        return downloadThreadPool.cancel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public List<Integer> getAllAliveDownloadIds() {
        return downloadThreadPool.getAllAliveDownloadIds();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public void doSetThrottleNetSpeed(int r1, long r2, int r4) {
        downloadThreadPool.setThrottleNetSpeed(r1, r2, r4);
    }
}

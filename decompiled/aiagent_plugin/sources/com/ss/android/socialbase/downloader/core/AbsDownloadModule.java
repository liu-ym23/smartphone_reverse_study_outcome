package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsDownloadModule implements IDownloadModule {
    protected DownloadCommonParams mCommonParams;
    protected IDownloadCache mDownloadCache;
    protected DownloadInfo mDownloadInfo;
    protected DownloadTask mDownloadTask;
    protected DownloadSetting mSetting;
    protected DownloadStatusHandler mStatusHandler;

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void setThrottleNetSpeed(long r1, int r3) {
    }

    public AbsDownloadModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r2) {
        this.mCommonParams = r2;
        this.mDownloadCache = r2.mDownloadCache;
        this.mDownloadTask = r2.mDownloadTask;
        this.mDownloadInfo = r2.mDownloadInfo;
        this.mSetting = r2.mSetting;
        this.mStatusHandler = r2.mStatusHandler;
        return this;
    }

    public boolean checkTaskFinishByUser() {
        if (this.mCommonParams.mDownloadInfo.getStatus() != (-2)) goto L9;
        if (this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_PAUSE) goto L7;
        DownloadCommonParams r3 = this.mCommonParams;
        r3.mRunStatus = RunStatus.RUN_STATUS_PAUSE;
    L7:
        return true;
    L9:
        if (this.mCommonParams.mDownloadInfo.getStatus() != (-4)) goto L15;
        if (this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_CANCELED) goto L13;
        DownloadCommonParams r4 = this.mCommonParams;
        r4.mRunStatus = RunStatus.RUN_STATUS_CANCELED;
    L13:
        return true;
    L15:
        if (this.mCommonParams.mRunStatus != RunStatus.RUN_STATUS_CANCELED) goto L17;
        return true;
    L17:
        if (this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_PAUSE) goto L22;
        return false;
    L22:
        return true;
    }
}

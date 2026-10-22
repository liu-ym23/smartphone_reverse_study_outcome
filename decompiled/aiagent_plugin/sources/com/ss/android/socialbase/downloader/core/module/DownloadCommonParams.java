package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadCommonParams {
    public IDownloadCache mDownloadCache;
    public DownloadInfo mDownloadInfo;
    public DownloadTask mDownloadTask;
    public boolean mEnableSegmentDownload;
    public String mExistTargetFileName;
    public String mExistTargetFilePath;
    public NetworkFailoverStrategy mFailoverStrategy;
    public boolean mHasRunNetworkModule;
    public volatile boolean mIsAlive;
    public boolean mNeedCheckIfModified;
    public NetworkRetryStrategy mRetryStrategy;
    public RunStatus mRunStatus;
    public DownloadSetting mSetting;
    public DownloadStatusHandler mStatusHandler;

    public DownloadCommonParams() {
        this.mRunStatus = RunStatus.RUN_STATUS_NONE;
        this.mIsAlive = true;
        this.mEnableSegmentDownload = true;
        this.mHasRunNetworkModule = false;
    }
}

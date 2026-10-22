package com.ss.android.socialbase.downloader.core;

import android.os.Handler;
import android.os.Process;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.module.DownloadBandwidthSamplerModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckFileExistModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckHasAnotherSameTaskModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckPathModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckTaskCanResumedModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckTaskRepetitionModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckWifiTaskValidModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.core.module.DownloadCompleteModule;
import com.ss.android.socialbase.downloader.core.module.DownloadLoadCacheModule;
import com.ss.android.socialbase.downloader.core.module.DownloadMimeTypeInterceptModule;
import com.ss.android.socialbase.downloader.core.module.DownloadPrepareModule;
import com.ss.android.socialbase.downloader.core.module.DownloadRetryModule;
import com.ss.android.socialbase.downloader.core.module.DownloadStartModule;
import com.ss.android.socialbase.downloader.core.module.DownloadTaskInterceptModule;
import com.ss.android.socialbase.downloader.core.module.fast.DownloadFastModule;
import com.ss.android.socialbase.downloader.core.module.multi.DownloadMultiSegmentModule;
import com.ss.android.socialbase.downloader.core.module.normal.DownloadSingleSegmentModule;
import com.ss.android.socialbase.downloader.core.module.pcdn.DownloadPCDNSegmentModule;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadRunnable implements Runnable {
    private static final String TAG = "DownloadRunnable";
    private DownloadCommonParams mCommonParams;
    private DownloadModuleChain mDownloadModuleChain;
    private Future mFuture;

    public DownloadRunnable(DownloadTask r3, Handler r4) {
        this.mCommonParams = new DownloadCommonParams();
        this.mDownloadModuleChain = new DownloadModuleChain(this.mCommonParams);
        this.mCommonParams.mDownloadTask = r3;
        DownloadCommonParams r0 = this.mCommonParams;
        r0.mDownloadInfo = r3.getDownloadInfo();
        DownloadCommonParams r1 = this.mCommonParams;
        r1.mStatusHandler = new DownloadStatusHandler(r3, r4);
        DownloadCommonParams r5 = this.mCommonParams;
        r5.mSetting = DownloadSetting.obtain(r5.mDownloadInfo.getId());
        DownloadCommonParams r6 = this.mCommonParams;
        r6.mDownloadCache = DownloadComponentManager.getDownloadCache();
        DownloadCommonParams r7 = this.mCommonParams;
        r7.mRetryStrategy = new NetworkRetryStrategy(this.mCommonParams.mDownloadInfo);
        DownloadCommonParams r8 = this.mCommonParams;
        r8.mFailoverStrategy = new NetworkFailoverStrategy(this.mCommonParams.mDownloadInfo);
    }

    @Override // java.lang.Runnable
    public void run() {
        DownloadTimingInfo r0 = this.mCommonParams.mDownloadTask.getTimingInfo();
        r0.threadExecuteTime = System.currentTimeMillis();
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "run", "Run");
    L5:
        Process.setThreadPriority(10);
        DownloadModuleChain r1 = new DownloadModuleChain(this.mCommonParams).addDownloadModule(new DownloadCheckPathModule()).addDownloadModule(new DownloadCheckHasAnotherSameTaskModule()).addDownloadModule(new DownloadCheckWifiTaskValidModule()).addDownloadModule(new DownloadCheckTaskCanResumedModule()).addDownloadModule(new DownloadFastModule()).addDownloadModule(new DownloadMultiSegmentModule()).addDownloadModule(new DownloadPCDNSegmentModule()).addDownloadModule(new DownloadSingleSegmentModule()).addDownloadModule(new DownloadCompleteModule());
        this.mDownloadModuleChain.addDownloadModule(new DownloadCheckTaskRepetitionModule()).addDownloadModule(new DownloadBandwidthSamplerModule()).addDownloadModule(new DownloadPrepareModule()).addDownloadModule(new DownloadTaskInterceptModule()).addDownloadModule(new DownloadLoadCacheModule()).addDownloadModule(new DownloadStartModule()).addDownloadModule(new DownloadMimeTypeInterceptModule()).addDownloadModule(new DownloadCheckFileExistModule()).addDownloadModule(new DownloadRetryModule(r1));
        this.mDownloadModuleChain.proceed();     // Catch: Throwable -> L8
    L10:
        afterDownload();
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        this.mCommonParams.mStatusHandler.onError(new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_RUNNABLE_UNKNOWN, th));
        goto L10
    }

    private void afterDownload() {
        resetStats();
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "run", "Run Time:" + (System.currentTimeMillis() - this.mCommonParams.mDownloadTask.getTimingInfo().threadExecuteTime));
    L5:
        IDownloadStatusListener r0 = DownloadComponentManager.getDownloadStatusListener();
        if (r0 == null) goto L13;
        r0.onFinish(this.mCommonParams.mDownloadInfo.getStatus());
    L13:
        DownloadComponentManager.getDownloadEngine().removeDownloadRunnable(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public void pause() {
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "pause", "Run");
    L5:
        DownloadCommonParams r0 = this.mCommonParams;
        r0.mRunStatus = RunStatus.RUN_STATUS_PAUSE;
        this.mDownloadModuleChain.pause();
        if (this.mDownloadModuleChain.isStartDownload() == true) goto L9;
        this.mCommonParams.mStatusHandler.onPause();
        resetStats();
        return;
    }

    public void cancel() {
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "cancel", "Run");
    L5:
        DownloadCommonParams r0 = this.mCommonParams;
        r0.mRunStatus = RunStatus.RUN_STATUS_CANCELED;
        this.mDownloadModuleChain.cancel();
        if (this.mDownloadModuleChain.isStartDownload() == true) goto L9;
        this.mCommonParams.mStatusHandler.onCancel();
        resetStats();
        return;
    }

    public void setThrottleNetSpeed(long r1, int r3) {
        this.mDownloadModuleChain.setThrottleNetSpeed(r1, r3);
    }

    public DownloadTask getDownloadTask() {
        return this.mCommonParams.mDownloadTask;
    }

    public boolean isAlive() {
        return this.mCommonParams.mIsAlive;
    }

    public int getDownloadId() {
        return this.mCommonParams.mDownloadInfo.getId();
    }

    public DownloadInfo getDownloadInfo() {
        return this.mCommonParams.mDownloadInfo;
    }

    public void prepareDownload() {
        this.mCommonParams.mStatusHandler.onPrepare();
    }

    public void setEnableSegmentDownload(boolean r1) {
        this.mCommonParams.mEnableSegmentDownload = r1;
    }

    public Future getFuture() {
        return this.mFuture;
    }

    public void setFuture(Future r3) {
        this.mFuture = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.aiagent.plugin");
    }

    private void resetStats() {
        this.mCommonParams.mDownloadTask.getTimingInfo().reset();
        this.mCommonParams.mDownloadTask.getThreadInfo().reset();
    }
}

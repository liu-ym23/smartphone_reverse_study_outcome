package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadTaskInterceptModule extends AbsDownloadModule {
    private static final String TAG = "DownloadTaskInterceptModule";

    public DownloadTaskInterceptModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r2) {
        if (r2.mDownloadInfo.isFastDownload() == false) goto L5;
        return null;
    L5:
        if (r2.mDownloadTask.getInterceptor() != null) goto L7;
        return null;
    L7:
        if (r2.mDownloadInfo.isIgnoreInterceptor() == false) goto L10;
        return null;
    L10:
        return super.init(r2);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r5) {
        IDownloadModuleChain r6 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L13;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L13:
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        r6.proceed();
        return;
    L6:
        if (this.mDownloadTask.getInterceptor().intercepte() == false) goto L11;
        DownloadCommonParams r4 = this.mCommonParams;     // Catch: Throwable -> L9
        r4.mRunStatus = RunStatus.RUN_STATUS_INTERCEPT;     // Catch: Throwable -> L9
    }
}

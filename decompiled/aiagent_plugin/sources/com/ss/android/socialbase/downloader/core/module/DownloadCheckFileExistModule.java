package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadCheckFileExistModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckFileExistModule";

    public DownloadCheckFileExistModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r2) {
        if (r2.mDownloadInfo.isFastDownload() == false) goto L7;
        return null;
    L7:
        return super.init(r2);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r5) {
        IDownloadModuleChain r6 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L6;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L6:
        if (TextUtils.isEmpty(this.mCommonParams.mExistTargetFileName) == true) goto L15;
        if (this.mDownloadInfo.isExpiredRedownload() == false) goto L11;
        DownloadCommonParams r0 = this.mCommonParams;
        r0.mNeedCheckIfModified = DownloadUtils.cacheExpiredWithHttp(this.mDownloadInfo, this.mDownloadInfo.isExpiredHttpCheck());
    L11:
        if (this.mCommonParams.mNeedCheckIfModified == true) goto L15;
        finishWithFileExist(this.mCommonParams);
        return;
    L15:
        if (this.mDownloadInfo.isExpiredRedownload() == true) goto L21;
        if (this.mDownloadInfo.isDownloaded() == false) goto L21;
        DownloadCommonParams r7 = this.mCommonParams;
        r7.mExistTargetFileName = this.mDownloadInfo.getName();
        DownloadCommonParams r8 = this.mCommonParams;
        r8.mExistTargetFilePath = this.mDownloadInfo.getSavePath();
        finishWithFileExist(this.mCommonParams);
        return;
    L21:
        if (this.mDownloadInfo.getChunkCount() <= 1) goto L23;
        this.mDownloadInfo.reset();
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
    L23:
        r6.proceed();
    }

    public static void finishWithFileExist(DownloadCommonParams r2) {
        if (r2.mExistTargetFileName.equals(r2.mDownloadInfo.getName()) == false) goto L5;
        r2.mRunStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
    L6:
        r2.mDownloadInfo.setCacheExistsInDownloading(true);
        return;
    L5:
        r2.mRunStatus = RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
        goto L6
    }
}

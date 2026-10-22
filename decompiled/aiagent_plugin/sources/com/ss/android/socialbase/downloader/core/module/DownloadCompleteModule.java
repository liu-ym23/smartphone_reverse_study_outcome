package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadCompleteModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCompleteModule";
    private BaseException mException;

    public DownloadCompleteModule() {
    }

    static /* synthetic */ DownloadCommonParams access$000(DownloadCompleteModule r0) {
        return r0.mCommonParams;
    }

    static /* synthetic */ DownloadInfo access$100(DownloadCompleteModule r0) {
        return r0.mDownloadInfo;
    }

    static /* synthetic */ DownloadInfo access$200(DownloadCompleteModule r0) {
        return r0.mDownloadInfo;
    }

    static /* synthetic */ BaseException access$302(DownloadCompleteModule r0, BaseException r1) {
        r0.mException = r1;
        return r1;
    }

    static /* synthetic */ DownloadCommonParams access$400(DownloadCompleteModule r0) {
        return r0.mCommonParams;
    }

    static /* synthetic */ DownloadInfo access$500(DownloadCompleteModule r0) {
        return r0.mDownloadInfo;
    }

    static /* synthetic */ DownloadInfo access$600(DownloadCompleteModule r0) {
        return r0.mDownloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r4) {
        IDownloadModuleChain r5 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L6;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L6:
        if (isFinishStatus() == false) goto L8;
        return;
    L8:
        checkCompleted();
    }

    private boolean isFinishStatus() {
        if (checkTaskFinishByUser() == false) goto L5;
    L14:
        return true;
    L5:
        if (this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_INTERCEPT) goto L14;
        if (this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L14;
        if (this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_END_RIGHT_NOW) goto L14;
        if (this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_END_FOR_FILE_EXIST) goto L14;
        return false;
    }

    private void checkCompleted() {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "checkCompleted", "Run");
    L5:
        this.mException = null;
        if (this.mDownloadInfo.isChunked() == false) goto L8;
        this.mDownloadInfo.setTotalBytes(this.mDownloadInfo.getCurBytes());
    L8:
        this.mDownloadInfo.setFirstDownload(false);
        if (this.mDownloadInfo.isIgnoreDataVerify() == true) goto L17;
        if (this.mDownloadInfo.getCurBytes() == this.mDownloadInfo.getTotalBytes()) goto L17;
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L15;
        Logger.taskDebug(TAG, this.mDownloadInfo, "checkCompleted", "Error curBytes != totalBytes");
    L15:
        this.mException = new BaseException(DownloadErrorCode.ERROR_CUR_NOT_EQUALS_TOTAL, "current bytes is not equals to total bytes");
    L32:
        if (this.mException != null) goto L35;
        return;
    L35:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L37;
        Logger.taskDebug(TAG, this.mDownloadInfo, "checkCompleted", "Download fail and reset" + this.mException);
    L37:
        this.mDownloadInfo.reset();
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        this.mDownloadCache.removeSegments(this.mDownloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        throw this.mException;
    L17:
        if (this.mDownloadInfo.getCurBytes() > 0) goto L23;
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L21;
        Logger.taskDebug(TAG, this.mDownloadInfo, "checkCompleted", "Error curBytes <=0");
    L21:
        this.mException = new BaseException(DownloadErrorCode.ERROR_CUR_BYTES_ZERO, "curBytes <= 0");
        goto L32
    L23:
        if (this.mDownloadInfo.isIgnoreDataVerify() == false) goto L25;
    L30:
        DownloadHelper.saveFileAsTargetName(this.mDownloadInfo, this.mDownloadTask.getMonitorDepend(), new AnonymousClass1(this));
        goto L32
    L25:
        if (this.mDownloadInfo.getTotalBytes() > 0) goto L30;
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L29;
        Logger.taskDebug(TAG, this.mDownloadInfo, "checkCompleted", "Error totalBytes <=0");
    L29:
        this.mException = new BaseException(DownloadErrorCode.ERROR_TOTAL_BYTES_ZERO, "TotalBytes <= 0");
        goto L32
    }
}

package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadCheckHasAnotherSameTaskModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckHasAnotherSameTaskModule";

    public DownloadCheckHasAnotherSameTaskModule() {
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
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L5:
        checkHasAnotherSameTask();
        r6.proceed();
    }

    private void checkHasAnotherSameTask() {
        int r0 = this.mDownloadInfo.getId();
        int r1 = DownloadComponentManager.getDownloadId(this.mDownloadInfo);
        DownloadInfo r2 = this.mDownloadCache.getDownloadInfo(r1);
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getId() != r0) goto L7;
        return;
    L7:
        if (r2.equalsTask(this.mDownloadInfo) == true) goto L10;
        return;
    L10:
        if (DownloadComponentManager.getDownloadEngine().isDownloading(r2.getId()) == true) goto L16;
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        this.mDownloadCache.removeDownloadTaskData(r1);
        if (r2.isFileDataValid() == true) goto L14;
        return;
    L14:
        this.mDownloadInfo.copyFromCacheData(r2, false);
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        throw new BaseException(DownloadErrorCode.ERROR_INNER_RETRY, "retry task because id generator changed");
    L16:
        this.mDownloadCache.removeDownloadTaskData(r0);
        throw new BaseException(DownloadErrorCode.ERROR_ANOTHER_TASK_EXIST, "another same task is downloading");
    }
}

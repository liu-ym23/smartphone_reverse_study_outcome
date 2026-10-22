package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadLoadCacheModule extends AbsDownloadModule {
    private static final String TAG = "DownloadLoadCacheModule";

    public DownloadLoadCacheModule() {
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
        doLoadCache();
        if (checkTaskFinishByUser() == false) goto L8;
        return;
    L8:
        r6.proceed();
    }

    private void doLoadCache() {
        int r0 = this.mDownloadInfo.getId();
        boolean r1 = this.mDownloadCache.ensureDownloadCacheSyncSuccess();
        DownloadInfo r2 = this.mDownloadCache.getDownloadInfo(r0);
        if (r2 != null) goto L9;
        if (r1 == true) goto L6;
    L7:
        r2 = ((DefaultDownloadCache) ZeusTransformUtils.preCheckCast(this.mDownloadCache, DefaultDownloadCache.class, "com.obric.aiagent.plugin")).getSqlDownloadCache().getDownloadInfo(r0);
        goto L9
    L6:
        if (DownloadHelper.hitSkipDbInitScene(DownloadHelper.getSkipDbInitSceneSet(), DownloadHelper.getSkipDbInitExpectMimeTypeSet(), DownloadHelper.getDbInitSceneSet(), this.mDownloadInfo.getMimeType(), this.mDownloadInfo.getMonitorScene()) == true) goto L7;
    L9:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L11;
        Logger.taskDebug(TAG, this.mDownloadInfo, "doLoadCache", "Find Cache:" + r1 + "CacheDownloadInfo" + r2);
    L11:
        boolean r3 = true;
        if (r2 != null) goto L14;
    L35:
        this.mDownloadInfo.reset();
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L38;
        Logger.taskDebug(TAG, this.mDownloadInfo, "doLoadCache", "Download reset");
    L38:
        if (r3 == false) goto L41;
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
    L41:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L44;
        Logger.taskDebug(TAG, this.mDownloadInfo, "doLoadCache", "After load:" + this.mDownloadInfo);
        return;
    L44:
        return;
    L14:
        if (r2.isNewTask() == true) goto L35;
        if (r2.isForce() == true) goto L35;
        if (this.mDownloadInfo.getStartOffset() != r2.getStartOffset()) goto L35;
        if (this.mDownloadInfo.getEndOffset() != r2.getEndOffset()) goto L35;
        this.mDownloadInfo.copyFromCacheData(r2, true);
        if (r2 == this.mDownloadInfo) goto L25;
        boolean r4 = true;
    L27:
        if (this.mDownloadInfo.getSavePath().equals(r2.getSavePath()) == false) goto L32;
        if (r2.isDownloaded() == false) goto L32;
        this.mCommonParams.mExistTargetFileName = r2.getName();
        this.mCommonParams.mExistTargetFilePath = r2.getSavePath();
    L34:
        r3 = r4;
    L32:
        if (DownloadComponentManager.getDownloadId(r2) == r0) goto L34;
        this.mDownloadCache.removeDownloadTaskData(r0);
        goto L38
    L25:
        r4 = false;
        goto L27
    }
}

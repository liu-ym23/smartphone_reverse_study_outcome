package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadCheckTaskCanResumedModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckTaskCanResumedModule";

    public DownloadCheckTaskCanResumedModule() {
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
        checkTaskCanResume();
        r6.proceed();
    }

    private void checkTaskCanResume() {
        long r0 = DownloadHelper.getCurByte(this.mDownloadInfo);
        long r2 = this.mDownloadInfo.getCurBytes();
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "checkTaskCanResume", "Offset:" + r0 + " curBytes: " + r2);
    L5:
        this.mDownloadInfo.setCurBytes(r0);
        if (r0 <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L17;
        if (this.mCommonParams.mNeedCheckIfModified == true) goto L17;
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L15;
        Logger.taskDebug(TAG, this.mDownloadInfo, "checkTaskCanResume", "deleteAllDownloadFiles");
    L15:
        this.mDownloadCache.removeSegments(this.mDownloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
    L17:
        if (this.mSetting.optInt(DownloadSettingKeys.CLEAN_INSTALLED_APK) <= 0) goto L20;
        this.mDownloadInfo.setInstalledTimeStamp(0);
        this.mDownloadInfo.setHasDoInstallation(false);
        return;
    L20:
        return;
    L8:
        r1 = false;
        goto L9
    }
}

package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadCheckPathModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckPathModule";

    public DownloadCheckPathModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r5) {
        IDownloadModuleChain r6 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L5:
        checkSavePathValid();
        r6.proceed();
    }

    private void checkSavePathValid() {
        DownloadFile r0 = new DownloadFile(this.mDownloadInfo.getSavePath(), this.mDownloadInfo.getName());
        if (r0.isTypeError() == false) goto L5;
        this.mDownloadCache.removeDownloadTaskData(this.mDownloadInfo.getId());
        throw new BaseException(DownloadErrorCode.ERROR_FILE_TYPE, "download savePath error:" + this.mDownloadInfo.getSavePath() + " extra:" + r0.getExtraMsg());
    L5:
        if (this.mSetting.optInt(DownloadSettingKeys.FIX_VULNERABILITY_FILE_NAME, 1) <= 0) goto L14;
        if (TextUtils.isEmpty(this.mDownloadInfo.getName()) == true) goto L14;
        if (this.mDownloadInfo.getName().contains(DownloadConstants.VULNERABILITY_PATH) == false) goto L14;
        throw new BaseException(DownloadErrorCode.ERROR_FILE_NAME, "File name error:" + this.mDownloadInfo.getName());
    L14:
        if (r0.isTypeMediaStore() == false) goto L16;
        return;
    L16:
        File r1 = new File(this.mDownloadInfo.getSavePath());
        if (r1.exists() == true) goto L41;
        boolean r2 = r1.mkdirs();
        if (r2 == false) goto L21;
        return;
    L21:
        if (r1.exists() == true) goto L57;
        int r3 = 0;
    L24:
        if (r2 == true) goto L30;
        int r4 = r3 + 1;
        if (r3 >= 3) goto L30;
        Thread.sleep(10);     // Catch: InterruptedException -> L52
        r2 = r1.mkdirs();
        r3 = r4;
    L30:
        if (r2 == false) goto L32;
        return;
    L32:
        if (r1.exists() == false) goto L34;
        return;
    L34:
        if (DownloadUtils.getAvailableSpaceBytes(this.mDownloadInfo.getSavePath()) >= 16384) goto L38;
        throw new BaseException(1006, "download savePath directory can not created:" + this.mDownloadInfo.getSavePath());
    L38:
        throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_CREATE_FAILED, "download savePath directory can not created:" + this.mDownloadInfo.getSavePath());
    L57:
        return;
    L41:
        if (r1.isDirectory() == true) goto L59;
        r1.delete();
        if (r1.mkdirs() == false) goto L45;
        return;
    L45:
        if (r1.exists() == false) goto L48;
        return;
    L48:
        throw new BaseException(DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:path=" + this.mDownloadInfo.getSavePath());
    }
}

package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.depend.AbsDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadMimeTypeInterceptModule extends AbsDownloadModule {
    private static final String TAG = "DownloadMimeTypeInterceptModule";

    public DownloadMimeTypeInterceptModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r2) {
        if (checkModuleEnabled(r2.mDownloadInfo) == true) goto L7;
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
        if (TextUtils.isEmpty(this.mDownloadInfo.getMimeType()) == false) goto L8;
    L12:
        r6.proceed();
        return;
    L8:
        if (checkGlobalIntercept(this.mDownloadInfo) == false) goto L12;
        throw new BaseException(DownloadErrorCode.ERROR_BIZ_INTERCEPTOR, "download global intercept mimeType");
    }

    public static boolean checkGlobalIntercept(DownloadInfo r6) {
        if (checkModuleEnabled(r6) == true) goto L28;
        return false;
    L28:
        IDownloadInterceptor r2 = DownloadComponentManager.getDownloadInterceptor();     // Catch: Throwable -> L17
        boolean r3 = r2.intercepte();     // Catch: Throwable -> L17
        if (r3 == false) goto L30;
    L14:
        if (r3 == false) goto L16;
    L15:
        r6.setInterceptFlag(1);
    L22:
        return r3;
    L16:
        r6.setInterceptFlag(0);
        goto L22
    L30:
    L12:
        th = th;
    L32:
        th.printStackTrace();     // Catch: Throwable -> L23
        if (r3 == false) goto L16;
    L23:
        th = move-exception;
        if (r3 == false) goto L26;
        r6.setInterceptFlag(1);
    L27:
        throw th;
    L26:
        r6.setInterceptFlag(0);
        goto L27
    L9:
        if (ZeusTransformUtils.instanceOf(r2, AbsDownloadInterceptor.class) == false) goto L14;
        r3 = ((AbsDownloadInterceptor) ZeusTransformUtils.preCheckCast(r2, AbsDownloadInterceptor.class, "com.obric.aiagent.plugin")).intercept(r6);     // Catch: Throwable -> L12
    L17:
        th = th;
        r3 = false;
        goto L32
    }

    private static boolean checkModuleEnabled(DownloadInfo r1) {
        if (r1.isFastDownload() == false) goto L5;
    L9:
        return false;
    L5:
        if (DownloadComponentManager.getDownloadInterceptor() == null) goto L9;
        if (r1.isIgnoreInterceptor() == true) goto L9;
        return true;
    }
}

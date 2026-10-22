package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadStartModule extends AbsDownloadModule {
    public DownloadStartModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r3) {
        IDownloadModuleChain r4 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        this.mDownloadInfo.updateStartDownloadTime();
        this.mDownloadInfo.resetRealStartDownloadTime();
        this.mDownloadInfo.setCacheExistsInDownloading(false);
        this.mStatusHandler.onStart();
        r4.proceed();
    }
}

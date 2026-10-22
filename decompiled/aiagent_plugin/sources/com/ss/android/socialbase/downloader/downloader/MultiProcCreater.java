package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper;
import com.ss.android.socialbase.downloader.impls.IndependentDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class MultiProcCreater implements DownloadComponentManager.IndependentHolderCreator {
    public MultiProcCreater() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public IDownloadServiceHandler createServiceHandler() {
        return new IndependentDownloadServiceHandler();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public IDownloadProxy createProxy() {
        return new IndependentProcessDownloadHandler();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public ISqlDownloadCache createCache(DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener r2) {
        DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener r1 = (DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener) ZeusTransformUtils.wrapperContextForParams(r2, DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener.class, "com.obric.aiagent.plugin");
        SqlDownloadCacheAidlWrapper r3 = new SqlDownloadCacheAidlWrapper();
        r3.setOnMainProcessRebindErrorCallback(r1);
        return r3;
    }
}

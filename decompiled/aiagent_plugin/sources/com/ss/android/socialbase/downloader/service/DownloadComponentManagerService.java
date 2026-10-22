package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadMemoryInfoListener;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadComponentManagerService implements IDownloadComponentManagerService {
    public DownloadComponentManagerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public Context getAppContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setAppContext(Context r2) {
        DownloadComponentManager.setAppContext((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public JSONObject getDownloadSetting() {
        return DownloadComponentManager.getDownloadSetting();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public IDownloadInterceptor getDownloadInterceptor() {
        return DownloadComponentManager.getDownloadInterceptor();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public boolean isInit() {
        return DownloadComponentManager.isInit();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void initComponent(DownloaderBuilder r1) {
        DownloadComponentManager.initComponent(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void coverComponent(DownloaderBuilder r1) {
        DownloadComponentManager.coverComponent(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void unRegisterDownloadReceiver() {
        DownloadComponentManager.unRegisterDownloadReceiver();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadInMultiProcess() {
        DownloadComponentManager.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public IReserveWifiStatusListener getReserveWifiStatusListener() {
        return DownloadComponentManager.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setReserveWifiStatusListener(IReserveWifiStatusListener r2) {
        DownloadComponentManager.setReserveWifiStatusListener((IReserveWifiStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IReserveWifiStatusListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public ITTNetHandler getTTNetHandler() {
        return DownloadComponentManager.getTTNetHandler();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void updateDownloadInfo(DownloadInfo r1) {
        DownloadHelper.checkWorkerThread("updateDownloadInfo");
        DownloadComponentManager.getDownloadCache().updateDownloadInfo(r1);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public long clearAllDownloadCache(boolean r1) {
        return DownloadComponentManager.clearAllDownloadCache(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void clearMemoryCacheData(final double r2) {
        DownloadComponentManager.submitIOTask(new AnonymousClass1(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void submitSingleTask(Runnable r2) {
        DownloadComponentManager.submitSingleTask((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void submitIOTask(Runnable r2) {
        DownloadComponentManager.submitIOTask((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void submitScheduleTask(Runnable r2, long r3, TimeUnit r5) {
        DownloadComponentManager.submitScheduleTask((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), r3, r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r2) {
        DownloadComponentManager.setDownloadMemoryInfoListener((IDownloadMemoryInfoListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMemoryInfoListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadDBListener(IDownloadDBListener r2) {
        DownloadComponentManager.setDownloadDBListener((IDownloadDBListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadDBListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadStatusListener(IDownloadStatusListener r2) {
        DownloadComponentManager.setDownloadStatusListener((IDownloadStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadStatusListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void initDownloadCacheImmediately() {
        DownloadComponentManager.initDownloadCacheImmediately();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void setDownloadThreadCheckListener(IDownloadThreadCheckListener r2) {
        DownloadComponentManager.setDownloadThreadCheckListener((IDownloadThreadCheckListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadThreadCheckListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void enableLruCache() {
        DownloadComponentManager.enableLruCache();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void startThrottle(String[] r1, long r2) {
        DownloadComponentManager.getTTNetHandler().startThrottle(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void stopThrottle(String[] r1) {
        DownloadComponentManager.getTTNetHandler().stopThrottle(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public void updateDownloadSpInfo() {
        IDownloadCache r2 = DownloadComponentManager.getDownloadCache();
        if (ZeusTransformUtils.instanceOf(r2, DefaultDownloadCache.class) == false) goto L6;
        ((DefaultDownloadCache) ZeusTransformUtils.preCheckCast(r2, DefaultDownloadCache.class, "com.obric.aiagent.plugin")).updateDownloadSpInfo();
        return;
    }
}

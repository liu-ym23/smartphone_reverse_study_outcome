package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.downloader.IDownloadMemoryInfoListener;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadComponentManagerService {

    public static class DefaultDownloadComponentManagerService implements IDownloadComponentManagerService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public long clearAllDownloadCache(boolean r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void clearMemoryCacheData(double r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void coverComponent(DownloaderBuilder r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void enableLruCache() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public Context getAppContext() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public IDownloadInterceptor getDownloadInterceptor() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public IReserveWifiStatusListener getReserveWifiStatusListener() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void initComponent(DownloaderBuilder r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void initDownloadCacheImmediately() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public boolean isInit() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setAppContext(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadDBListener(IDownloadDBListener r2) {
            IDownloadDBListener r1 = (IDownloadDBListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadDBListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadInMultiProcess() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r2) {
            IDownloadMemoryInfoListener r1 = (IDownloadMemoryInfoListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMemoryInfoListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadStatusListener(IDownloadStatusListener r2) {
            IDownloadStatusListener r1 = (IDownloadStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadStatusListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadThreadCheckListener(IDownloadThreadCheckListener r2) {
            IDownloadThreadCheckListener r1 = (IDownloadThreadCheckListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadThreadCheckListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setReserveWifiStatusListener(IReserveWifiStatusListener r2) {
            IReserveWifiStatusListener r1 = (IReserveWifiStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IReserveWifiStatusListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void startThrottle(String[] r1, long r2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void stopThrottle(String[] r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void submitIOTask(Runnable r2) {
            Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void submitScheduleTask(Runnable r1, long r2, TimeUnit r4) {
            Runnable r0 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r1, Runnable.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void submitSingleTask(Runnable r2) {
            Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void unRegisterDownloadReceiver() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void updateDownloadInfo(DownloadInfo r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void updateDownloadSpInfo() {
        }

        public DefaultDownloadComponentManagerService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public JSONObject getDownloadSetting() {
            return DownloadConstants.EMPTY_JSON;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public ITTNetHandler getTTNetHandler() {
            return new ITTNetHandler.DefaultTTNetHandler();
        }
    }

    long clearAllDownloadCache(boolean r1);

    void clearMemoryCacheData(double r1);

    void coverComponent(DownloaderBuilder r1);

    void enableLruCache();

    Context getAppContext();

    IDownloadInterceptor getDownloadInterceptor();

    JSONObject getDownloadSetting();

    IReserveWifiStatusListener getReserveWifiStatusListener();

    ITTNetHandler getTTNetHandler();

    void initComponent(DownloaderBuilder r1);

    void initDownloadCacheImmediately();

    boolean isInit();

    void setAppContext(Context r1);

    void setDownloadDBListener(IDownloadDBListener r1);

    void setDownloadInMultiProcess();

    void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r1);

    void setDownloadStatusListener(IDownloadStatusListener r1);

    void setDownloadThreadCheckListener(IDownloadThreadCheckListener r1);

    void setReserveWifiStatusListener(IReserveWifiStatusListener r1);

    void startThrottle(String[] r1, long r2);

    void stopThrottle(String[] r1);

    void submitIOTask(Runnable r1);

    void submitScheduleTask(Runnable r1, long r2, TimeUnit r4);

    void submitSingleTask(Runnable r1);

    void unRegisterDownloadReceiver();

    void updateDownloadInfo(DownloadInfo r1);

    void updateDownloadSpInfo();
}

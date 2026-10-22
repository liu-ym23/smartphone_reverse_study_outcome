package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public class DownloaderBuilder {
    private ExecutorService chunkDownloadExecutor;
    private final Context context;
    private ExecutorService cpuThreadExecutor;
    private ExecutorService customThreadExecutor;
    private ExecutorService dbThreadExecutor;
    private List<IDownloadCompleteHandler> downloadCompleteHandlers;
    private IDownloadDns downloadDns;
    private boolean downloadInMultiProcess;
    private IDownloadInterceptor downloadInterceptor;
    private IDownloadLaunchHandler downloadLaunchHandler;
    private IDownloadMonitorListener downloadMonitorListener;
    private IDownloadSettings downloadSetting;
    private IDownloadHttpService httpService;
    private IDownloadIdGenerator idGenerator;
    private ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private ExecutorService mixApkDownloadExecutor;
    private ExecutorService mixDefaultDownloadExecutor;
    private ExecutorService mixFrequentDownloadExecutor;
    private IMonitorConfig monitorConfig;
    private boolean needAutoRefreshUnSuccessTask;
    private INotificationClickCallback notificationClickCallback;
    private ExecutorService okHttpDispatcherExecutor;
    private ITTNetHandler ttNetHandler;
    private int writeBufferSize;

    @Deprecated
    public DownloaderBuilder downloadExpSwitch(int r1) {
        return this;
    }

    @Deprecated
    public DownloaderBuilder headHttpService(IDownloadHeadHttpService r3) {
        IDownloadHeadHttpService r4 = (IDownloadHeadHttpService) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadHeadHttpService.class, "com.obric.aiagent.plugin");
        return this;
    }

    @Deprecated
    public DownloaderBuilder maxDownloadPoolSize(int r1) {
        return this;
    }

    public DownloaderBuilder(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.downloadCompleteHandlers = new ArrayList();
        this.needAutoRefreshUnSuccessTask = true;
        this.context = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    public DownloaderBuilder writeBufferSize(int r1) {
        this.writeBufferSize = r1;
        return this;
    }

    public DownloaderBuilder idGenerator(IDownloadIdGenerator r3) {
        this.idGenerator = (IDownloadIdGenerator) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadIdGenerator.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService r3) {
        this.httpService = (IDownloadHttpService) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadHttpService.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(IDownloadLaunchHandler r3) {
        this.downloadLaunchHandler = (IDownloadLaunchHandler) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadLaunchHandler.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService r3) {
        this.cpuThreadExecutor = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService r3) {
        this.ioThreadExecutor = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService r3) {
        this.mixDefaultDownloadExecutor = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService r3) {
        this.mixFrequentDownloadExecutor = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService r3) {
        this.mixApkDownloadExecutor = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService r3) {
        this.dbThreadExecutor = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService r3) {
        this.chunkDownloadExecutor = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService r3) {
        this.okHttpDispatcherExecutor = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder customThreadExecutor(ExecutorService r3) {
        this.customThreadExecutor = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean r1) {
        this.downloadInMultiProcess = r1;
        return this;
    }

    public DownloaderBuilder monitorConfig(IMonitorConfig r3) {
        this.monitorConfig = (IMonitorConfig) ZeusTransformUtils.wrapperContextForParams(r3, IMonitorConfig.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder ttNetHandler(ITTNetHandler r3) {
        this.ttNetHandler = (ITTNetHandler) ZeusTransformUtils.wrapperContextForParams(r3, ITTNetHandler.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder downloadInterceptor(IDownloadInterceptor r3) {
        this.downloadInterceptor = (IDownloadInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadInterceptor.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder addDownloadCompleteHandler(IDownloadCompleteHandler r3) {
        IDownloadCompleteHandler r4 = (IDownloadCompleteHandler) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadCompleteHandler.class, "com.obric.aiagent.plugin");
        List<IDownloadCompleteHandler> r0 = this.downloadCompleteHandlers;
        monitor-enter(r0);
        if (r4 != null) goto L16;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return this;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.downloadCompleteHandlers.contains(r4) == true) goto L11;
        this.downloadCompleteHandlers.add(r4);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return this;
    }

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean r1) {
        this.needAutoRefreshUnSuccessTask = r1;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(INotificationClickCallback r3) {
        this.notificationClickCallback = (INotificationClickCallback) ZeusTransformUtils.wrapperContextForParams(r3, INotificationClickCallback.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder downloadSetting(IDownloadSettings r3) {
        this.downloadSetting = (IDownloadSettings) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadSettings.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(IDownloadMonitorListener r3) {
        this.downloadMonitorListener = (IDownloadMonitorListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadMonitorListener.class, "com.obric.aiagent.plugin");
        return this;
    }

    public DownloaderBuilder downloadDns(IDownloadDns r3) {
        this.downloadDns = (IDownloadDns) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadDns.class, "com.obric.aiagent.plugin");
        return this;
    }

    public Context getContext() {
        return this.context;
    }

    public IDownloadIdGenerator getIdGenerator() {
        return this.idGenerator;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public IDownloadLaunchHandler getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public ExecutorService getCustomThreadExecutor() {
        return this.customThreadExecutor;
    }

    public List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public IMonitorConfig getMonitorConfig() {
        return this.monitorConfig;
    }

    public ITTNetHandler getTTNetHandler() {
        return this.ttNetHandler;
    }

    public IDownloadInterceptor getDownloadInterceptor() {
        return this.downloadInterceptor;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }

    public INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public IDownloadSettings getDownloadSetting() {
        return this.downloadSetting;
    }

    public IDownloadMonitorListener getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public IDownloadDns getDownloadDns() {
        return this.downloadDns;
    }

    public Downloader build() {
        return new Downloader(this);
    }
}

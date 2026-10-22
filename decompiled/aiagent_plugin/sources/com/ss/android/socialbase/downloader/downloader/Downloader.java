package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.util.Log;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Downloader extends BaseDownloader {
    private static final String TAG = "Downloader";
    private static volatile Downloader instance = null;
    private static volatile boolean mSetContext = false;

    static {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void addMainThreadListener(int r3, IDownloadListener r4) {
        super.addMainThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void addNotificationListener(int r3, IDownloadListener r4) {
        super.addNotificationListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void addSubThreadListener(int r3, IDownloadListener r4) {
        super.addSubThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean canResume(int r1) {
        return super.canResume(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int r1) {
        super.cancel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int r1, boolean r2) {
        super.cancel(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long clearAllDownloadCache(boolean r1) {
        return super.clearAllDownloadCache(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int r1) {
        super.clearDownloadData(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int r1, boolean r2) {
        super.clearDownloadData(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearMemoryCacheData(double r1) {
        super.clearMemoryCacheData(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void enableLruCache() {
        super.enableLruCache();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long getCurBytes(int r1) {
        return super.getCurBytes(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IDownloadFileUriProvider getDownloadFileUriProvider(int r1) {
        return super.getDownloadFileUriProvider(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getDownloadId(String r1, String r2) {
        return super.getDownloadId(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int r1) {
        return super.getDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String r1, String r2) {
        return super.getDownloadInfo(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String r1) {
        return super.getDownloadInfoList(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfosByFileExtension(String r1) {
        return super.getDownloadInfosByFileExtension(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IDownloadNotificationEventListener getDownloadNotificationEventListener(int r1) {
        return super.getDownloadNotificationEventListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String r1) {
        return super.getDownloadingDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IReserveWifiStatusListener getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getStatus(int r1) {
        return super.getStatus(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String r1) {
        return super.getSuccessedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String r1) {
        return super.getUnCompletedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void initDownloadCacheImmediately() {
        super.initDownloadCacheImmediately();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1) {
        return super.isDownloadSuccessAndFileNotExist(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloading(int r1) {
        return super.isDownloading(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pause(int r1) {
        super.pause(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r3) {
        super.registerDownloadCacheSyncListener((IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r3) {
        super.registerDownloaderProcessConnectedListener((IDownloaderProcessConnectedListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void removeMainThreadListener(int r3, IDownloadListener r4) {
        super.removeMainThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void removeNotificationListener(int r3, IDownloadListener r4) {
        super.removeNotificationListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void removeSubThreadListener(int r3, IDownloadListener r4) {
        super.removeSubThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int r1) {
        super.removeTaskMainListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int r1) {
        super.removeTaskNotificationListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int r1) {
        super.removeTaskSubListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restart(int r1) {
        super.restart(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void restartAllFailedDownloadTasks(List r3) {
        super.restartAllFailedDownloadTasks((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List r3) {
        super.restartAllPauseReserveOnWifiDownloadTasks((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resume(int r1) {
        super.resume(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String r1) {
        super.setDefaultSavePath(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String r1) {
        super.setDefaultSaveTempPath(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setDownloadDBListener(IDownloadDBListener r3) {
        super.setDownloadDBListener((IDownloadDBListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadDBListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r3) {
        super.setDownloadMemoryInfoListener((IDownloadMemoryInfoListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadMemoryInfoListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setDownloadNotificationEventListener(int r3, IDownloadNotificationEventListener r4) {
        super.setDownloadNotificationEventListener(r3, (IDownloadNotificationEventListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadNotificationEventListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setDownloadStatusListener(IDownloadStatusListener r3) {
        super.setDownloadStatusListener((IDownloadStatusListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadStatusListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setDownloadThreadCheckListener(IDownloadThreadCheckListener r3) {
        super.setDownloadThreadCheckListener((IDownloadThreadCheckListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadThreadCheckListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setLogLevel(int r1) {
        super.setLogLevel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* synthetic */ void setMainThreadListener(int r3, IDownloadListener r4) {
        super.setMainThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* synthetic */ void setMainThreadListener(int r3, IDownloadListener r4, boolean r5) {
        super.setMainThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* synthetic */ void setNotificationListener(int r3, IDownloadListener r4) {
        super.setNotificationListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void setReserveWifiStatusListener(IReserveWifiStatusListener r3) {
        super.setReserveWifiStatusListener((IReserveWifiStatusListener) ZeusTransformUtils.wrapperContextForParams(r3, IReserveWifiStatusListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    @Deprecated
    public /* synthetic */ void setSubThreadListener(int r3, IDownloadListener r4) {
        super.setSubThreadListener(r3, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int r1, long r2) {
        super.setThrottleNetSpeed(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int r1, long r2, int r4) {
        super.setThrottleNetSpeed(r1, r2, r4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void startThrottle(String[] r1, long r2) {
        super.startThrottle(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void stopThrottle(String[] r1) {
        super.stopThrottle(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r3) {
        super.unRegisterDownloadCacheSyncListener((IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* synthetic */ void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r3) {
        super.unRegisterDownloaderProcessConnectedListener((IDownloaderProcessConnectedListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void updateDownloadInfo(DownloadInfo r1) {
        super.updateDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void updateDownloadSpInfo() {
        super.updateDownloadSpInfo();
    }

    private Downloader() {
    }

    public static void loadService(IDownloadServiceLoader r2) {
        DownloadServiceManager.loadService((IDownloadServiceLoader) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadServiceLoader.class, "com.obric.aiagent.plugin"));
    }

    public static void init(DownloaderBuilder r1) {
        initOrCover(r1, false);
    }

    public static synchronized void initOrCover(DownloaderBuilder r4, boolean r5) {
        monitor-enter(Downloader.class);
        if (r4 != null) goto L22;
        monitor-exit(Downloader.class);
        return;
    L22:
    L19:
        th = move-exception;
        throw th;
    L8:
        if (instance != null) goto L12;
        instance = r4.build();     // Catch: Throwable -> L19
        monitor-exit(Downloader.class);
        return;
    L12:
        IDownloadComponentManagerService r1 = (IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r1.isInit() == true) goto L15;
        r1.initComponent(r4);     // Catch: Throwable -> L19
    L17:
        monitor-exit(Downloader.class);
        return;
    L15:
        if (r5 == false) goto L17;
        r1.coverComponent(r4);     // Catch: Throwable -> L19
        goto L17
    }

    Downloader(DownloaderBuilder r3) {
        ((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).initComponent(r3);
    }

    public static Downloader getInstance(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (instance == null) goto L5;
    L14:
        checkContext(r5);
        return instance;
    L5:
        monitor-enter(Downloader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        ((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).setAppContext(r5);     // Catch: Throwable -> L11
        instance = new Downloader();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Downloader.class);     // Catch: Throwable -> L11
        goto L14
    }

    private static void checkContext(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (mSetContext == false) goto L6;
        return;
    L6:
        monitor-enter(Downloader.class);
    L21:
        th = move-exception;
        throw th;
    L8:
        if (mSetContext == false) goto L25;
        monitor-exit(Downloader.class);     // Catch: Throwable -> L21
        return;
    L25:
        if (r6 == null) goto L14;
        ((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).setAppContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
        mSetContext = true;     // Catch: Throwable -> L17
    L24:
    L19:
        monitor-exit(Downloader.class);     // Catch: Throwable -> L21
        return;
    L14:
        if (Logger.debug() == false) goto L24;
        Logger.globalDebug(TAG, "checkContext", "Context is null " + Log.getStackTraceString(new Throwable("context_empty")));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        Logger.globalError(TAG, "checkContext", "Error:" + th);     // Catch: Throwable -> L21
        goto L19
    }
}

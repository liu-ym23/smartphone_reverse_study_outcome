package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class BaseDownloader {
    private static IDownloadGlobalThrottleService globalThrottleService;
    private IDownloadComponentManagerService componentService;
    private IDownloadProcessDispatcherService dispatcherService;
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    BaseDownloader() {
        this.dispatcherService = (IDownloadProcessDispatcherService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadProcessDispatcherService.class), IDownloadProcessDispatcherService.class, "com.obric.aiagent.plugin");
        this.componentService = (IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin");
    }

    static {
        globalThrottleService = (IDownloadGlobalThrottleService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadGlobalThrottleService.class), IDownloadGlobalThrottleService.class, "com.obric.aiagent.plugin");
    }

    public static DownloadTask with(Context r2) {
        Downloader.getInstance((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
        return new DownloadTask();
    }

    public void pause(int r1) {
        this.dispatcherService.pause(r1);
    }

    public int getDownloadId(String r1, String r2) {
        return this.dispatcherService.getDownloadId(r1, r2);
    }

    public List<DownloadInfo> getDownloadInfoList(String r1) {
        return this.dispatcherService.getDownloadInfoList(r1);
    }

    public void cancel(int r2) {
        cancel(r2, true);
    }

    public void cancel(int r1, boolean r2) {
        this.dispatcherService.cancel(r1, r2);
    }

    public void resume(int r1) {
        this.dispatcherService.resume(r1);
    }

    public boolean canResume(int r1) {
        return this.dispatcherService.canResume(r1);
    }

    public void restart(int r1) {
        this.dispatcherService.restart(r1);
    }

    public void pauseAll() {
        this.dispatcherService.pauseAll();
    }

    public void restartAllFailedDownloadTasks(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.dispatcherService.restartAllFailedDownloadTasks(r4);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.dispatcherService.restartAllPauseReserveOnWifiDownloadTasks(r4);
    }

    public long getCurBytes(int r1) {
        return this.dispatcherService.getCurBytes(r1);
    }

    public int getStatus(int r1) {
        return this.dispatcherService.getStatus(r1);
    }

    public boolean isDownloading(int r1) {
        return this.dispatcherService.isDownloading(r1);
    }

    public DownloadInfo getDownloadInfo(int r1) {
        return this.dispatcherService.getDownloadInfo(r1);
    }

    public DownloadInfo getDownloadInfo(String r1, String r2) {
        return this.dispatcherService.getDownloadInfo(r1, r2);
    }

    public void updateDownloadInfo(DownloadInfo r1) {
        this.componentService.updateDownloadInfo(r1);
    }

    public long clearAllDownloadCache(boolean r1) {
        return this.componentService.clearAllDownloadCache(r1);
    }

    public void clearMemoryCacheData(double r1) {
        this.componentService.clearMemoryCacheData(r1);
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r1) {
        return this.dispatcherService.getDownloadNotificationEventListener(r1);
    }

    public void setDownloadNotificationEventListener(int r3, IDownloadNotificationEventListener r4) {
        IDownloadNotificationEventListener r5 = (IDownloadNotificationEventListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadNotificationEventListener.class, "com.obric.aiagent.plugin");
        this.dispatcherService.setDownloadNotificationEventListener(r3, r5);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) {
        return this.dispatcherService.getSuccessedDownloadInfosWithMimeType(r1);
    }

    public void clearDownloadData(int r2) {
        this.dispatcherService.clearDownloadData(r2, true);
    }

    public void clearDownloadData(int r1, boolean r2) {
        this.dispatcherService.clearDownloadData(r1, r2);
    }

    @Deprecated
    public void removeTaskMainListener(int r4) {
        this.dispatcherService.removeDownloadListener(r4, null, ListenerType.MAIN, true);
    }

    public void removeMainThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.removeDownloadListener(r3, r5, ListenerType.MAIN, false);
    }

    @Deprecated
    public void setMainThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.addDownloadListener(r3, r5, ListenerType.MAIN, true);
    }

    @Deprecated
    public void setMainThreadListener(int r7, IDownloadListener r8, boolean r9) {
        IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r8, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        this.dispatcherService.addDownloadListener(r7, r2, ListenerType.MAIN, true, r9);
    }

    public void addMainThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.addDownloadListener(r3, r5, ListenerType.MAIN, false);
    }

    @Deprecated
    public void setSubThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.addDownloadListener(r3, r5, ListenerType.SUB, true);
    }

    public void addSubThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.addDownloadListener(r3, r5, ListenerType.SUB, false);
    }

    @Deprecated
    public void removeTaskSubListener(int r4) {
        this.dispatcherService.removeDownloadListener(r4, null, ListenerType.SUB, true);
    }

    public void removeSubThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.removeDownloadListener(r3, r5, ListenerType.SUB, false);
    }

    @Deprecated
    public void removeTaskNotificationListener(int r4) {
        this.dispatcherService.removeDownloadListener(r4, null, ListenerType.NOTIFICATION, true);
    }

    public void removeNotificationListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.removeDownloadListener(r3, r5, ListenerType.NOTIFICATION, false);
    }

    @Deprecated
    public void setNotificationListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.addDownloadListener(r3, r5, ListenerType.NOTIFICATION, true);
    }

    public void addNotificationListener(int r3, IDownloadListener r4) {
        IDownloadListener r5 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.dispatcherService.addDownloadListener(r3, r5, ListenerType.NOTIFICATION, false);
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1) {
        return this.dispatcherService.isDownloadSuccessAndFileNotExist(r1);
    }

    public boolean isHttpServiceInit() {
        return this.dispatcherService.isHttpServiceInit();
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) {
        return this.dispatcherService.getUnCompletedDownloadInfosWithMimeType(r1);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1) {
        return this.dispatcherService.getDownloadingDownloadInfosWithMimeType(r1);
    }

    public List<DownloadInfo> getDownloadInfosByFileExtension(String r1) {
        return this.dispatcherService.getDownloadInfosByFileExtension(r1);
    }

    @Deprecated
    public List<DownloadInfo> getAllDownloadInfo() {
        return this.dispatcherService.getAllDownloadInfo();
    }

    public void destoryDownloader() {
        this.componentService.unRegisterDownloadReceiver();
    }

    public void setLogLevel(int r1) {
        this.dispatcherService.setLogLevel(r1);
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r3) {
        IDownloadCacheSyncStatusListener r4 = (IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin");
        this.dispatcherService.registerDownloadCacheSyncListener(r4);
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r3) {
        IDownloadCacheSyncStatusListener r4 = (IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin");
        this.dispatcherService.unRegisterDownloadCacheSyncListener(r4);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return this.dispatcherService.isDownloadCacheSyncSuccess();
    }

    public void setDownloadInMultiProcess() {
        this.componentService.setDownloadInMultiProcess();
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int r1) {
        return this.dispatcherService.getDownloadFileUriProvider(r1);
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r3) {
        IDownloaderProcessConnectedListener r4 = (IDownloaderProcessConnectedListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin");
        this.dispatcherService.registerDownloaderProcessConnectedListener(r4);
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r3) {
        IDownloaderProcessConnectedListener r4 = (IDownloaderProcessConnectedListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin");
        this.dispatcherService.unRegisterDownloaderProcessConnectedListener(r4);
    }

    public IReserveWifiStatusListener getReserveWifiStatusListener() {
        return this.componentService.getReserveWifiStatusListener();
    }

    public void setReserveWifiStatusListener(IReserveWifiStatusListener r3) {
        IReserveWifiStatusListener r4 = (IReserveWifiStatusListener) ZeusTransformUtils.wrapperContextForParams(r3, IReserveWifiStatusListener.class, "com.obric.aiagent.plugin");
        this.componentService.setReserveWifiStatusListener(r4);
    }

    public void setThrottleNetSpeed(int r2, long r3) {
        setThrottleNetSpeed(r2, r3, 0);
    }

    public void setThrottleNetSpeed(int r1, long r2, int r4) {
        this.dispatcherService.setThrottleNetSpeed(r1, r2, r4);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath);
    }

    private File getGlobalSaveDir(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        File r1 = new File(r2);
        if (DownloadDirUtils.isValidDirectory(r1) == false) goto L8;
        return r1;
    L8:
        return null;
    }

    public void setDefaultSavePath(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.globalDefaultSavePath = r2;
        return;
    }

    public void setDefaultSaveTempPath(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.globalDefaultSaveTempPath = r2;
        return;
    }

    public void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r3) {
        IDownloadMemoryInfoListener r4 = (IDownloadMemoryInfoListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadMemoryInfoListener.class, "com.obric.aiagent.plugin");
        this.componentService.setDownloadMemoryInfoListener(r4);
    }

    public void setDownloadDBListener(IDownloadDBListener r3) {
        IDownloadDBListener r4 = (IDownloadDBListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadDBListener.class, "com.obric.aiagent.plugin");
        this.componentService.setDownloadDBListener(r4);
    }

    public void setDownloadStatusListener(IDownloadStatusListener r3) {
        IDownloadStatusListener r4 = (IDownloadStatusListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadStatusListener.class, "com.obric.aiagent.plugin");
        this.componentService.setDownloadStatusListener(r4);
    }

    public void initDownloadCacheImmediately() {
        this.componentService.initDownloadCacheImmediately();
    }

    public void setDownloadThreadCheckListener(IDownloadThreadCheckListener r3) {
        IDownloadThreadCheckListener r4 = (IDownloadThreadCheckListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadThreadCheckListener.class, "com.obric.aiagent.plugin");
        this.componentService.setDownloadThreadCheckListener(r4);
    }

    public void enableLruCache() {
        this.componentService.enableLruCache();
    }

    public static void setGlobalThrottleSpeed(Context r2, int r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        globalThrottleService.setGlobalThrottle(r3, r4);
    }

    public void startThrottle(String[] r1, long r2) {
        this.componentService.startThrottle(r1, r2);
    }

    public void stopThrottle(String[] r1) {
        this.componentService.stopThrottle(r1);
    }

    public void updateDownloadSpInfo() {
        this.componentService.updateDownloadSpInfo();
    }
}

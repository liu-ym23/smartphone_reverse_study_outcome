package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadProcessDispatcherService implements IDownloadProcessDispatcherService {
    private static final String TAG = "DownloadProcessDispatcherService";

    public DownloadProcessDispatcherService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void tryDownload(DownloadTask r6) {
        if (Logger.alog() == false) goto L8;
        if (r6 == null) goto L8;
        DownloadInfo r5 = r6.getDownloadInfo();
        if (r5 == null) goto L8;
        Logger.taskDebug(TAG, r5, "tryDownload", r5.toDetailString(), true);
        Logger.taskDebug(TAG, r5, "tryDownload", "Setting:" + DownloadSetting.obtain(r5.getId()), true);
    L8:
        DownloadProcessDispatcher.getInstance().tryDownload(r6);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void pause(int r1) {
        DownloadProcessDispatcher.getInstance().pause(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public int getDownloadId(String r1, String r2) {
        return DownloadProcessDispatcher.getInstance().getDownloadId(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfoList(String r1) {
        DownloadHelper.checkWorkerThread("getDownloadInfoList");
        return DownloadProcessDispatcher.getInstance().getDownloadInfoList(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void cancel(int r1, boolean r2) {
        DownloadProcessDispatcher.getInstance().cancel(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void resume(int r1) {
        DownloadProcessDispatcher.getInstance().resume(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean canResume(int r1) {
        DownloadHelper.checkWorkerThread("canResume");
        return DownloadProcessDispatcher.getInstance().canResume(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void restart(int r1) {
        DownloadProcessDispatcher.getInstance().restart(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void pauseAll() {
        DownloadProcessDispatcher.getInstance().pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void restartAllFailedDownloadTasks(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        DownloadProcessDispatcher.getInstance().restartAllFailedDownloadTasks(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        DownloadProcessDispatcher.getInstance().restartAllPauseReserveOnWifiDownloadTasks(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public long getCurBytes(int r1) {
        DownloadHelper.checkWorkerThread("getCurBytes");
        return DownloadProcessDispatcher.getInstance().getCurBytes(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public int getStatus(int r1) {
        DownloadHelper.checkWorkerThread("getStatus");
        return DownloadProcessDispatcher.getInstance().getStatus(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isDownloading(int r1) {
        DownloadHelper.checkWorkerThread("isDownloading");
        return DownloadProcessDispatcher.getInstance().isDownloading(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public DownloadInfo getDownloadInfo(int r1) {
        DownloadHelper.checkWorkerThread("getDownloadInfo");
        return DownloadProcessDispatcher.getInstance().getDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public DownloadInfo getDownloadInfo(String r1, String r2) {
        DownloadHelper.checkWorkerThread("getDownloadInfo");
        return DownloadProcessDispatcher.getInstance().getDownloadInfo(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r1) {
        DownloadHelper.checkWorkerThread("getDownloadNotificationEventListener");
        return DownloadProcessDispatcher.getInstance().getDownloadNotificationEventListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setDownloadNotificationEventListener(int r2, IDownloadNotificationEventListener r3) {
        IDownloadNotificationEventListener r1 = (IDownloadNotificationEventListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadNotificationEventListener.class, "com.obric.aiagent.plugin");
        DownloadHelper.checkWorkerThread("setDownloadNotificationEventListener");
        DownloadProcessDispatcher.getInstance().setDownloadNotificationEventListener(r2, r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) {
        DownloadHelper.checkWorkerThread("getSuccessedDownloadInfosWithMimeType");
        return DownloadProcessDispatcher.getInstance().getSuccessedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void clearDownloadData(int r2) {
        DownloadProcessDispatcher.getInstance().clearDownloadData(r2, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void clearDownloadData(int r1, boolean r2) {
        DownloadProcessDispatcher.getInstance().clearDownloadData(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeDownloadListener(int r1, IDownloadListener r2, ListenerType r3, boolean r4) {
        IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.aiagent.plugin");
        DownloadHelper.checkWorkerThread("removeDownloadListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(r1, r0, r3, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void addDownloadListener(int r2, IDownloadListener r3, ListenerType r4, boolean r5) {
        IDownloadListener r1 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadListener.class, "com.obric.aiagent.plugin");
        DownloadHelper.checkWorkerThread("addDownloadListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(r2, r1, r4, r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void addDownloadListener(int r7, IDownloadListener r8, ListenerType r9, boolean r10, boolean r11) {
        IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r8, IDownloadListener.class, "com.obric.aiagent.plugin");
        DownloadHelper.checkWorkerThread("addDownloadListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(r7, r2, r9, r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeTaskSubListener(int r4) {
        DownloadHelper.checkWorkerThread("removeTaskSubListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(r4, null, ListenerType.SUB, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeSubThreadListener(int r3, IDownloadListener r4) {
        IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        DownloadHelper.checkWorkerThread("removeSubThreadListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(r3, r2, ListenerType.SUB, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeTaskNotificationListener(int r4) {
        DownloadHelper.checkWorkerThread("removeTaskNotificationListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(r4, null, ListenerType.NOTIFICATION, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void removeNotificationListener(int r3, IDownloadListener r4) {
        IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        DownloadHelper.checkWorkerThread("removeNotificationListener");
        DownloadProcessDispatcher.getInstance().removeDownloadListener(r3, r2, ListenerType.NOTIFICATION, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setNotificationListener(int r3, IDownloadListener r4) {
        IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        DownloadHelper.checkWorkerThread("setNotificationListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(r3, r2, ListenerType.NOTIFICATION, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void addNotificationListener(int r3, IDownloadListener r4) {
        IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        DownloadHelper.checkWorkerThread("addNotificationListener");
        DownloadProcessDispatcher.getInstance().addDownloadListener(r3, r2, ListenerType.NOTIFICATION, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1) {
        DownloadHelper.checkWorkerThread("isDownloadSuccessAndFileNotExist");
        return DownloadProcessDispatcher.getInstance().isDownloadSuccessAndFileNotExist(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isHttpServiceInit() {
        return DownloadProcessDispatcher.getInstance().isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) {
        DownloadHelper.checkWorkerThread("getUnCompletedDownloadInfosWithMimeType");
        return DownloadProcessDispatcher.getInstance().getUnCompletedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1) {
        DownloadHelper.checkWorkerThread("getDownloadingDownloadInfosWithMimeType");
        return DownloadProcessDispatcher.getInstance().getDownloadingDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r1) {
        DownloadHelper.checkWorkerThread("getDownloadInfosByFileExtension");
        return DownloadProcessDispatcher.getInstance().getDownloadInfosByFileExtension(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getAllDownloadInfo() {
        DownloadHelper.checkWorkerThread("getAllDownloadInfo");
        return DownloadProcessDispatcher.getInstance().getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) {
        DownloadHelper.checkWorkerThread("getDownloadInfosByFilters");
        return DownloadProcessDispatcher.getInstance().getDownloadInfosByFilters(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setLogLevel(int r1) {
        DownloadProcessDispatcher.getInstance().setLogLevel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        IDownloadCacheSyncStatusListener r1 = (IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin");
        DownloadProcessDispatcher.getInstance().registerDownloadCacheSyncListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        IDownloadCacheSyncStatusListener r1 = (IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin");
        DownloadProcessDispatcher.getInstance().unRegisterDownloadCacheSyncListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public boolean isDownloadCacheSyncSuccess() {
        return DownloadProcessDispatcher.getInstance().isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public IDownloadFileUriProvider getDownloadFileUriProvider(int r1) {
        DownloadHelper.checkWorkerThread("getDownloadFileUriProvider");
        return DownloadProcessDispatcher.getInstance().getDownloadFileUriProvider(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r2) {
        IDownloaderProcessConnectedListener r1 = (IDownloaderProcessConnectedListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin");
        DownloadProcessDispatcher.getInstance().registerDownloaderProcessConnectedListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r2) {
        IDownloaderProcessConnectedListener r1 = (IDownloaderProcessConnectedListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin");
        DownloadProcessDispatcher.getInstance().unRegisterDownloaderProcessConnectedListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public void setThrottleNetSpeed(int r1, long r2, int r4) {
        DownloadProcessDispatcher.getInstance().setThrottleNetSpeed(r1, r2, r4);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
    public INotificationClickCallback getNotificationClickCallback(int r1) {
        return DownloadProcessDispatcher.getInstance().getNotificationClickCallback(r1);
    }
}

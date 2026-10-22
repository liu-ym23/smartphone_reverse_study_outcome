package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IDownloadProcessDispatcherService {

    public static class DefaultDownloadProcessDispatcherService implements IDownloadProcessDispatcherService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void addDownloadListener(int r1, IDownloadListener r2, ListenerType r3, boolean r4) {
            IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void addDownloadListener(int r1, IDownloadListener r2, ListenerType r3, boolean r4, boolean r5) {
            IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void addNotificationListener(int r1, IDownloadListener r2) {
            IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean canResume(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void cancel(int r1, boolean r2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void clearDownloadData(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void clearDownloadData(int r1, boolean r2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getAllDownloadInfo() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public long getCurBytes(int r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public IDownloadFileUriProvider getDownloadFileUriProvider(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public int getDownloadId(String r1, String r2) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public DownloadInfo getDownloadInfo(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public DownloadInfo getDownloadInfo(String r1, String r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfoList(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfosByFileExtension(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public INotificationClickCallback getNotificationClickCallback(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public int getStatus(int r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isDownloadCacheSyncSuccess() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isDownloading(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isHttpServiceInit() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void pause(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void pauseAll() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
            IDownloadCacheSyncStatusListener r1 = (IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r2) {
            IDownloaderProcessConnectedListener r1 = (IDownloaderProcessConnectedListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeDownloadListener(int r1, IDownloadListener r2, ListenerType r3, boolean r4) {
            IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeNotificationListener(int r1, IDownloadListener r2) {
            IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeSubThreadListener(int r1, IDownloadListener r2) {
            IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeTaskNotificationListener(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeTaskSubListener(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void restart(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void restartAllFailedDownloadTasks(List<String> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void resume(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setDownloadNotificationEventListener(int r1, IDownloadNotificationEventListener r2) {
            IDownloadNotificationEventListener r0 = (IDownloadNotificationEventListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadNotificationEventListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setLogLevel(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setNotificationListener(int r1, IDownloadListener r2) {
            IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setThrottleNetSpeed(int r1, long r2, int r4) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void tryDownload(DownloadTask r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
            IDownloadCacheSyncStatusListener r1 = (IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r2) {
            IDownloaderProcessConnectedListener r1 = (IDownloaderProcessConnectedListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin");
        }

        public DefaultDownloadProcessDispatcherService() {
        }
    }

    void addDownloadListener(int r1, IDownloadListener r2, ListenerType r3, boolean r4);

    void addDownloadListener(int r1, IDownloadListener r2, ListenerType r3, boolean r4, boolean r5);

    void addNotificationListener(int r1, IDownloadListener r2);

    boolean canResume(int r1);

    void cancel(int r1, boolean r2);

    void clearDownloadData(int r1);

    void clearDownloadData(int r1, boolean r2);

    List<DownloadInfo> getAllDownloadInfo();

    long getCurBytes(int r1);

    IDownloadFileUriProvider getDownloadFileUriProvider(int r1);

    int getDownloadId(String r1, String r2);

    DownloadInfo getDownloadInfo(int r1);

    DownloadInfo getDownloadInfo(String r1, String r2);

    List<DownloadInfo> getDownloadInfoList(String r1);

    List<DownloadInfo> getDownloadInfosByFileExtension(String r1);

    List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2);

    IDownloadNotificationEventListener getDownloadNotificationEventListener(int r1);

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1);

    INotificationClickCallback getNotificationClickCallback(int r1);

    int getStatus(int r1);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1);

    boolean isDownloadCacheSyncSuccess();

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1);

    boolean isDownloading(int r1);

    boolean isHttpServiceInit();

    void pause(int r1);

    void pauseAll();

    void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r1);

    void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r1);

    void removeDownloadListener(int r1, IDownloadListener r2, ListenerType r3, boolean r4);

    void removeNotificationListener(int r1, IDownloadListener r2);

    void removeSubThreadListener(int r1, IDownloadListener r2);

    @Deprecated
    void removeTaskNotificationListener(int r1);

    @Deprecated
    void removeTaskSubListener(int r1);

    void restart(int r1);

    void restartAllFailedDownloadTasks(List<String> r1);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> r1);

    void resume(int r1);

    void setDownloadNotificationEventListener(int r1, IDownloadNotificationEventListener r2);

    void setLogLevel(int r1);

    @Deprecated
    void setNotificationListener(int r1, IDownloadListener r2);

    void setThrottleNetSpeed(int r1, long r2, int r4);

    void tryDownload(DownloadTask r1);

    void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r1);

    void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r1);
}

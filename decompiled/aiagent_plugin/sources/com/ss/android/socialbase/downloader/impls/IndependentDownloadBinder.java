package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class IndependentDownloadBinder extends IDownloadAidlService.Stub {
    private static final String TAG = "IndependentDownloadBinder";
    private final IDownloadProxy downloadProxy;

    static {
    }

    public IndependentDownloadBinder() {
        this.downloadProxy = new ProcessDownloadHandler(true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void tryDownload(DownloadAidlTask r3) {
        DownloadAidlTask r4 = (DownloadAidlTask) ZeusTransformUtils.wrapperContextForParams(r3, DownloadAidlTask.class, "com.obric.aiagent.plugin");
        IDownloadProxy r2 = this.downloadProxy;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.tryDownloadWithEngine(IPCUtils.convertDownloadTaskFromAidl(r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void pause(int r1, boolean r2) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.pause(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void cancel(int r1, boolean r2) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.cancel(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean canResume(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canResume(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void resume(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.resume(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restart(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.restart(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void pauseAll() {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public long getCurBytes(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurBytes(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getStatus(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getStatus(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloading(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isDownloading(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public DownloadInfo getDownloadInfo(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getDownloadInfoList(String r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadInfoList(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getDownloadId(String r1, String r2) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getDownloadId(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public DownloadInfo getDownloadInfoByUrlAndPath(String r1, String r2) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadInfo(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSuccessedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadingDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadInfosByFileExtension(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getAllDownloadInfo() {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadInfosByFilters(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restartAllFailedDownloadTasks(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        IDownloadProxy r2 = this.downloadProxy;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.restartAllFailedDownloadTasks(r4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        IDownloadProxy r2 = this.downloadProxy;
        if (r2 == null) goto L6;
        r2.restartAllPauseReserveOnWifiDownloadTasks(r4);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void clearDownloadData(int r1, boolean r2, boolean r3) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.clearDownloadData(r1, r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void resetDownloadData(int r2, boolean r3) {
        IDownloadProxy r1 = this.downloadProxy;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.clearDownloadData(r2, r3, false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void removeDownloadListener(int r7, int r8, IDownloadAidlListener r9, int r10, boolean r11) {
        IDownloadAidlListener r12 = (IDownloadAidlListener) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadAidlListener.class, "com.obric.aiagent.plugin");
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeDownloadListener(r7, r8, IPCUtils.convertListenerFromAidl(r12), DownloadHelper.convertListenerType(r10), r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addDownloadListener(int r7, int r8, IDownloadAidlListener r9, int r10, boolean r11) {
        IDownloadAidlListener r12 = (IDownloadAidlListener) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadAidlListener.class, "com.obric.aiagent.plugin");
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.addDownloadListener(r7, r8, IPCUtils.convertListenerFromAidl(r12), DownloadHelper.convertListenerType(r10), r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addDownloadListener1(int r8, int r9, IDownloadAidlListener r10, int r11, boolean r12, boolean r13) {
        IDownloadAidlListener r14 = (IDownloadAidlListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadAidlListener.class, "com.obric.aiagent.plugin");
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.addDownloadListener(r8, r9, IPCUtils.convertListenerFromAidl(r14), DownloadHelper.convertListenerType(r11), r12, r13);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isDownloadSuccessAndFileNotExist(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setThrottleNetSpeed(int r1, long r2, int r4) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setThrottleNetSpeed(r1, r2, r4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isHttpServiceInit() {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUnCompletedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setLogLevel(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setLogLevel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean isDownloadCacheSyncSuccess() {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setDownloadWithIndependentProcessStatus(int r1, boolean r2) {
        DownloadProcessDispatcher.getInstance().setDownloadIndependentProcessStatus(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public int getDownloadWithIndependentProcessStatus(int r1) {
        return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatusInner(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean updateDownloadInfo(DownloadInfo r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.updateDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean removeDownloadInfo(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.removeDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public boolean removeDownloadTaskData(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.removeDownloadTaskData(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void clearData() {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void syncDownloadInfoFromOtherCache(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.syncDownloadInfoFromOtherCache(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void addProcessCallback(ProcessAidlCallback r3) {
        ProcessAidlCallback r4 = (ProcessAidlCallback) ZeusTransformUtils.wrapperContextForParams(r3, ProcessAidlCallback.class, "com.obric.aiagent.plugin");
        IDownloadProxy r2 = this.downloadProxy;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.addProcessCallback(IPCUtils.convertProcessAidlCallbackFromAidl(r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void dispatchProcessCallback(int r1, int r2) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.dispatchProcessCallback(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return IPCUtils.convertDownloadNotificationEventListenerToAidl(r0.getDownloadNotificationEventListener(r1));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public INotificationClickAidlCallback getNotificationClickCallback(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return IPCUtils.convertNotificationClickCallbackToAidl(r0.getNotificationClickCallback(r1));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public void setDownloadNotificationEventListener(int r3, IDownloadNotificationEventAidlListener r4) {
        IDownloadNotificationEventAidlListener r5 = (IDownloadNotificationEventAidlListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadNotificationEventAidlListener.class, "com.obric.aiagent.plugin");
        IDownloadProxy r2 = this.downloadProxy;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.setDownloadNotificationEventListener(r3, IPCUtils.convertDownloadNotificationEventListenerFromAidl(r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public IDownloadAidlFileProvider getDownloadFileUriProvider(int r1) {
        IDownloadProxy r0 = this.downloadProxy;
        if (r0 != null) goto L7;
        return null;
    L7:
        return IPCUtils.convertFileProviderToAidl(r0.getDownloadFileUriProvider(r1));
    }
}

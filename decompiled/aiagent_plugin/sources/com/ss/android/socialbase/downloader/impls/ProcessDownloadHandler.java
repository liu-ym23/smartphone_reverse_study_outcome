package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ProcessDownloadHandler implements IDownloadProxy {
    private static final String TAG = "ProcessDownloadHandler";
    private final IDownloadCache downloadCache;
    private final AbsDownloadEngine downloadEngine;
    private final IDownloadServiceHandler downloadServiceHandler;
    private final boolean enableSingleThread;

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void startService() {
    }

    static /* synthetic */ AbsDownloadEngine access$000(ProcessDownloadHandler r0) {
        return r0.downloadEngine;
    }

    static /* synthetic */ IDownloadServiceHandler access$100(ProcessDownloadHandler r0) {
        return r0.downloadServiceHandler;
    }

    public ProcessDownloadHandler() {
        this(false);
    }

    public ProcessDownloadHandler(boolean r2) {
        this.downloadEngine = DownloadComponentManager.getDownloadEngine();
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        if (r2 == true) goto L5;
        this.downloadServiceHandler = DownloadComponentManager.getDownloadServiceHandler();
    L7:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SINGLE_ASYNC_HANDLE_OPERATION) <= 0) goto L9;
        boolean r3 = true;
    L10:
        this.enableSingleThread = r3;
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        this.downloadServiceHandler = DownloadComponentManager.getIndependentDownloadServiceHandler();
        goto L7
    }

    private void runInSingleThread(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.enableSingleThread == false) goto L5;
        DownloadComponentManager.submitSingleTask(r4);
        return;
    L5:
        r4.run();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pause(final int r2, boolean r3) {
        Runnable r0 = new AnonymousClass1(this, r2);
        if (r3 == false) goto L5;
        r0.run();
        return;
    L5:
        runInSingleThread(r0);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void cancel(final int r2, final boolean r3) {
        runInSingleThread(new AnonymousClass2(this, r2, r3));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean canResume(int r1) {
        AbsDownloadEngine r0 = this.downloadEngine;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isInDownloadTaskPool(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resume(final int r2) {
        runInSingleThread(new AnonymousClass3(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restart(final int r2) {
        runInSingleThread(new AnonymousClass4(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void pauseAll() {
        runInSingleThread(new AnonymousClass5(this));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getAllDownloadInfo() {
        IDownloadCache r0 = this.downloadCache;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) {
        IDownloadCache r0 = this.downloadCache;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getDownloadInfosByFilters(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllFailedDownloadTasks(List<String> r3) {
        final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        runInSingleThread(new AnonymousClass6(this, r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r3) {
        final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        runInSingleThread(new AnonymousClass7(this, r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public long getCurBytes(int r3) {
        IDownloadCache r2 = this.downloadCache;
        if (r2 != null) goto L5;
        return 0;
    L5:
        DownloadInfo r4 = r2.getDownloadInfo(r3);
        if (r4 != null) goto L9;
        return 0;
    L9:
        return r4.getCurBytes();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getStatus(int r1) {
        DownloadInfo r0 = this.downloadEngine.getDownloadInfo(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloading(int r1) {
        return this.downloadEngine.isDownloading(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(int r1) {
        return this.downloadEngine.getDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfoList(String r1) {
        return this.downloadEngine.getDownloadInfoList(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public DownloadInfo getDownloadInfo(String r1, String r2) {
        return getDownloadInfo(DownloadComponentManager.getDownloadId(r1, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadId(String r1, String r2) {
        return DownloadComponentManager.getDownloadId(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearDownloadData(final int r2, final boolean r3, final boolean r4) {
        runInSingleThread(new AnonymousClass8(this, r2, r3, r4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void resetDownloadData(final int r2, final boolean r3) {
        runInSingleThread(new AnonymousClass9(this, r2, r3));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int r7, int r8, IDownloadListener r9, ListenerType r10, boolean r11) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadListener.class, "com.obric.aiagent.plugin");
        this.downloadEngine.addDownloadListener(r7, r8, r3, r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addDownloadListener(int r8, int r9, IDownloadListener r10, ListenerType r11, boolean r12, boolean r13) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadListener.class, "com.obric.aiagent.plugin");
        this.downloadEngine.addDownloadListener(r8, r9, r3, r11, r12, r13);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void removeDownloadListener(int r7, int r8, IDownloadListener r9, ListenerType r10, boolean r11) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadListener.class, "com.obric.aiagent.plugin");
        this.downloadEngine.removeDownloadListener(r7, r8, r3, r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        boolean r0 = DownloadUtils.isDownloadSuccessAndFileNotExist(r4.getStatus(), r4.getSavePath(), r4.getName());
        if (r0 == false) goto L8;
        resetDownloadData(r4.getId(), true);
    L8:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r1) {
        return this.downloadEngine.getDownloadingDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r1) {
        return this.downloadCache.getDownloadInfosByFileExtension(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownload(final DownloadTask r2) {
        DownloadComponentManager.updateCurrentDownloadThreadInfo(r2, true);
        runInSingleThread(new AnonymousClass10(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void tryDownloadWithEngine(final DownloadTask r2) {
        DownloadComponentManager.updateCurrentDownloadThreadInfo(r2, true);
        runInSingleThread(new AnonymousClass11(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setLogLevel(int r1) {
        Logger.setLogLevel(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isDownloadCacheSyncSuccess() {
        return this.downloadCache.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfo(DownloadInfo r1) {
        this.downloadCache.syncDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadWithIndependentProcessStatus(int r1, boolean r2) {
        DownloadProcessDispatcher.getInstance().setDownloadWithIndependentProcessStatus(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public int getDownloadWithIndependentProcessStatus(int r1) {
        return DownloadProcessDispatcher.getInstance().getDownloadWithIndependentProcessStatus(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean updateDownloadInfo(DownloadInfo r1) {
        return this.downloadCache.updateDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadInfo(int r1) {
        return this.downloadCache.removeDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean removeDownloadTaskData(int r1) {
        return this.downloadCache.removeDownloadTaskData(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void clearData() {
        this.downloadCache.clearData();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void syncDownloadInfoFromOtherCache(int r1) {
        this.downloadCache.syncDownloadInfoFromOtherCache(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public boolean isServiceAlive() {
        IDownloadServiceHandler r0 = this.downloadServiceHandler;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isServiceAlive() == false) goto L7;
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void addProcessCallback(ProcessCallback r2) {
        DownloadComponentManager.addProcessCallback((ProcessCallback) ZeusTransformUtils.wrapperContextForParams(r2, ProcessCallback.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void dispatchProcessCallback(int r4, int r5) {
        if (DownloadComponentManager.getProcessCallbacks() == null) goto L10;
        Iterator<ProcessCallback> r3 = DownloadComponentManager.getProcessCallbacks().iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        ProcessCallback r0 = (ProcessCallback) ZeusTransformUtils.preCheckCast(r3.next(), ProcessCallback.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.callback(r5, r4);
        goto L6
    L16:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r1) {
        return this.downloadEngine.getDownloadNotificationEventListener(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public INotificationClickCallback getNotificationClickCallback(int r1) {
        INotificationClickCallback r0 = this.downloadEngine.getNotificationClickCallback(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return DownloadComponentManager.getNotificationClickCallback();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setDownloadNotificationEventListener(int r3, IDownloadNotificationEventListener r4) {
        IDownloadNotificationEventListener r5 = (IDownloadNotificationEventListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadNotificationEventListener.class, "com.obric.aiagent.plugin");
        this.downloadEngine.setDownloadNotificationEventListener(r3, r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public IDownloadFileUriProvider getDownloadFileUriProvider(int r1) {
        return this.downloadEngine.getDownloadFileUriProvider(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public void setThrottleNetSpeed(final int r8, final long r9, final int r11) {
        runInSingleThread(new AnonymousClass12(this, r8, r9, r11));
    }
}

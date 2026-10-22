package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.cleaner.Cleaner;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadProcessDispatcher {
    private static volatile DownloadProcessDispatcher instance;
    private volatile SparseArray<Boolean> independentMap;
    private volatile List<IDownloaderProcessConnectedListener> processConnectedListeners;

    static {
    }

    public DownloadProcessDispatcher() {
        this.independentMap = new SparseArray();
        this.processConnectedListeners = new ArrayList();
    }

    public static DownloadProcessDispatcher getInstance() {
        if (instance != null) goto L13;
        monitor-enter(DownloadProcessDispatcher.class);
        instance = new DownloadProcessDispatcher();     // Catch: Throwable -> L9
        monitor-exit(DownloadProcessDispatcher.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return instance;
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r3) {
        IDownloaderProcessConnectedListener r4 = (IDownloaderProcessConnectedListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (DownloadHelper.isDownloaderProcess() == false) goto L10;
        r4.onConnected();
        return;
    L10:
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L12;
        r4.onConnected();
    L12:
        List<IDownloaderProcessConnectedListener> r0 = this.processConnectedListeners;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (this.processConnectedListeners.contains(r4) == true) goto L17;
        this.processConnectedListeners.add(r4);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r3) {
        IDownloaderProcessConnectedListener r4 = (IDownloaderProcessConnectedListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        List<IDownloaderProcessConnectedListener> r0 = this.processConnectedListeners;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.processConnectedListeners.contains(r4) == false) goto L10;
        this.processConnectedListeners.remove(r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void dispatchDownloaderProcessConnectedEvent() {
        List<IDownloaderProcessConnectedListener> r0 = this.processConnectedListeners;
        monitor-enter(r0);
        Iterator<IDownloaderProcessConnectedListener> r4 = this.processConnectedListeners.iterator();     // Catch: Throwable -> L12
    L6:
        if (r4.hasNext() == false) goto L10;
        IDownloaderProcessConnectedListener r1 = (IDownloaderProcessConnectedListener) ZeusTransformUtils.preCheckCast(r4.next(), IDownloaderProcessConnectedListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L6;
        r1.onConnected();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void setDownloadWithIndependentProcessStatus(int r3, boolean r4) {
        setDownloadIndependentProcessStatus(r3, r4);
        if (DownloadComponentManager.supportMultiProc() == false) goto L10;
        if (DownloadHelper.isDownloaderProcess() == true) goto L10;
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L10;
        DownloadProxy.get(true).setDownloadWithIndependentProcessStatus(r3, r4);
    L10:
        if (DownloadComponentManager.isDownloadInMultiProcess() == false) goto L12;
        return;
    L12:
        if (DownloadHelper.isDownloaderProcess() == false) goto L14;
        return;
    L14:
        if (DownloadHelper.isMainProcess() == true) goto L24;
        Intent r2 = new Intent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), DownloadHandleService.class);     // Catch: Throwable -> L17
        r2.setAction(DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY);     // Catch: Throwable -> L17
        r2.putExtra("extra_download_id", r3);     // Catch: Throwable -> L17
        ZeusTransformUtils.startService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public synchronized void setDownloadIndependentProcessStatus(int r2, boolean r3) {
        monitor-enter(this);
        SparseArray<Boolean> r0 = this.independentMap;     // Catch: Throwable -> L10
        if (r3 == false) goto L6;
        Boolean r4 = Boolean.TRUE;     // Catch: Throwable -> L10
    L7:
        r0.put(r2, r4);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r4 = Boolean.FALSE;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public int getDownloadWithIndependentProcessStatus(int r3) {
        if (DownloadComponentManager.supportMultiProc() == true) goto L7;
        return -1;
    L7:
        if (DownloadHelper.isDownloaderProcess() == true) goto L13;
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L13;
        return DownloadProxy.get(true).getDownloadWithIndependentProcessStatus(r3);
    L13:
        return getDownloadWithIndependentProcessStatusInner(r3);
    }

    public synchronized int getDownloadWithIndependentProcessStatusInner(int r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.independentMap.get(r3) == null) goto L6;
        boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(this.independentMap.get(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4 ? 1 : 0;
    L6:
        monitor-exit(this);
        return -1;
    }

    public IDownloadProxy getDownloadHandler(int r1) {
        int r0 = getDownloadWithIndependentProcessStatus(r1);
        boolean r2 = true;
        if (r0 == 1) goto L5;
    L7:
        r2 = false;
    L9:
        return DownloadProxy.get(r2);
    L5:
        if (DownloadHelper.isDownloaderProcess() == true) goto L7;
        goto L7
    }

    private IDownloadProxy getDownloadHandler(DownloadTask r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        DownloadInfo r1 = r6.getDownloadInfo();
        if (r1 != null) goto L8;
        return null;
    L8:
        boolean r2 = false;
        if (r1.isFastDownload() == true) goto L41;
        if (r1.isNeedCurrentProcess() == true) goto L41;
        boolean r0 = r1.isNeedIndependentProcess();
        if (DownloadHelper.isDownloaderProcess() == false) goto L16;
    L17:
        r0 = true;
    L18:
        int r3 = getDownloadWithIndependentProcessStatus(r1.getId());
        if (r3 < 0) goto L31;
        if (r3 == r0) goto L31;
        if (r3 != 1) goto L28;
        if (DownloadHelper.isMainProcess() == false) goto L43;
        DownloadProxy.get(true).pause(r1.getId(), true);     // Catch: Throwable -> L42
        DownloadInfo r7 = DownloadProxy.get(true).getDownloadInfo(r1.getId());     // Catch: Throwable -> L42
        if (r7 == null) goto L43;
        DownloadProxy.get(false).syncDownloadInfo(r7);     // Catch: Throwable -> L42
    L43:
        goto L31
    L28:
        if (DownloadHelper.isMainProcess() == false) goto L30;
        DownloadProxy.get(false).pause(r1.getId(), true);     // Catch: Throwable -> L42
        goto L43
    L30:
        r6.setNeedDelayForCacheSync(true);     // Catch: Throwable -> L42
        DownloadProxy.get(true).dispatchProcessCallback(1, r1.getId());     // Catch: Throwable -> L42
    L31:
        int r8 = r1.getId();
        if (r0 != true) goto L34;
        boolean r4 = true;
    L35:
        setDownloadWithIndependentProcessStatus(r8, r4);
        if (r0 != true) goto L39;
        r2 = true;
    L39:
        return DownloadProxy.get(r2);
    L34:
        r4 = false;
        goto L35
    L16:
        if (DownloadHelper.isMainProcess() == true) goto L18;
    L41:
        return DownloadProxy.get(false);
    }

    public void pause(int r2) {
        IDownloadProxy r1 = getDownloadHandler(r2);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.pause(r2, false);
    }

    public void cancel(int r3, boolean r4) {
        if (DownloadHelper.isMainProcess() == false) goto L10;
        IDownloadProxy r2 = DownloadProxy.get(true);
        if (r2 == null) goto L7;
        r2.cancel(r3, r4);
    L7:
        IDownloadProxy r5 = DownloadProxy.get(false);
        if (r5 == null) goto L15;
        r5.cancel(r3, r4);
        return;
    L15:
        return;
    L10:
        IDownloadProxy r6 = getDownloadHandler(r3);
        if (r6 == null) goto L13;
        r6.cancel(r3, r4);
    L13:
        DownloadProxy.get(true).dispatchProcessCallback(2, r3);
    }

    public boolean canResume(int r1) {
        IDownloadProxy r0 = getDownloadHandler(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canResume(r1);
    }

    public void resume(int r1) {
        IDownloadProxy r0 = getDownloadHandler(r1);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.resume(r1);
    }

    public void restart(int r1) {
        IDownloadProxy r0 = getDownloadHandler(r1);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.restart(r1);
    }

    public void pauseAll() {
        IDownloadProxy r0 = DownloadProxy.get(false);
        if (r0 == null) goto L5;
        r0.pauseAll();
    L5:
        IDownloadProxy r1 = DownloadProxy.get(true);
        if (r1 == null) goto L9;
        r1.pauseAll();
        return;
    }

    public long getCurBytes(int r2) {
        IDownloadProxy r1 = getDownloadHandler(r2);
        if (r1 != null) goto L5;
        return 0;
    L5:
        if (Cleaner.getInstance().isExistInCleanSet(r2) == false) goto L8;
        return 0;
    L8:
        return r1.getCurBytes(r2);
    }

    public int getStatus(int r1) {
        IDownloadProxy r0 = getDownloadHandler(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getStatus(r1);
    }

    public boolean isDownloading(int r1) {
        IDownloadProxy r0 = getDownloadHandler(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isDownloading(r1);
    }

    public DownloadInfo getDownloadInfo(int r3) {
        IDownloadProxy r2 = getDownloadHandler(r3);
        if (r2 != null) goto L6;
        return null;
    L6:
        if (Cleaner.getInstance().isExistInCleanSet(r3) == false) goto L9;
        return null;
    L9:
        return r2.getDownloadInfo(r3);
    }

    public int getDownloadId(String r1, String r2) {
        return DownloadComponentManager.getDownloadId(r1, r2);
    }

    public DownloadInfo getDownloadInfo(String r2, String r3) {
        int r4 = getDownloadId(r2, r3);
        if (Cleaner.getInstance().isExistInCleanSet(r4) == false) goto L5;
        return null;
    L5:
        IDownloadProxy r1 = getDownloadHandler(r4);
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getDownloadInfo(r4);
    }

    public List<DownloadInfo> getDownloadInfoList(String r5) {
        List<DownloadInfo> r4 = DownloadProxy.get(false).getDownloadInfoList(r5);
        List<DownloadInfo> r6 = DownloadProxy.get(true).getDownloadInfoList(r5);
        if (r4 != null) goto L8;
        if (r6 != null) goto L8;
        return null;
    L8:
        if (r4 == null) goto L15;
        Iterator<DownloadInfo> r1 = r4.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        DownloadInfo r2 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r1.next(), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (Cleaner.getInstance().isExistInCleanSet(r2.getId()) == false) goto L11;
        r1.remove();
    L15:
        if (r6 == null) goto L22;
        Iterator<DownloadInfo> r3 = r6.iterator();
    L18:
        if (r3.hasNext() == false) goto L22;
        DownloadInfo r7 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r3.next(), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (Cleaner.getInstance().isExistInCleanSet(r7.getId()) == false) goto L18;
        r3.remove();
    L22:
        if (r4 == null) goto L26;
        if (r6 == null) goto L26;
        ArrayList r0 = new ArrayList(r4);
        r0.addAll(r6);
        return r0;
    L26:
        if (r4 == null) goto L29;
        return r4;
    L29:
        return r6;
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r1) {
        IDownloadProxy r0 = getDownloadHandler(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadNotificationEventListener(r1);
    }

    public INotificationClickCallback getNotificationClickCallback(int r1) {
        IDownloadProxy r0 = getDownloadHandler(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getNotificationClickCallback(r1);
    }

    public void setDownloadNotificationEventListener(int r3, IDownloadNotificationEventListener r4) {
        IDownloadNotificationEventListener r5 = (IDownloadNotificationEventListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadNotificationEventListener.class, "com.obric.aiagent.plugin");
        IDownloadProxy r2 = getDownloadHandler(r3);
        if (r2 != null) goto L5;
        return;
    L5:
        r2.setDownloadNotificationEventListener(r3, r5);
    }

    private List<DownloadInfo> handleDownloadInfos(List<DownloadInfo> r4, List<DownloadInfo> r5, SparseArray<DownloadInfo> r6) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        ArrayList r8 = new ArrayList();
        if (r3 == null) goto L12;
        Iterator r9 = r3.iterator();
    L6:
        if (r9.hasNext() == false) goto L12;
        DownloadInfo r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r9.next(), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        if (r6.get(r1.getId()) != null) goto L6;
        r6.put(r1.getId(), r1);
    L12:
        if (r7 == null) goto L21;
        Iterator r10 = r7.iterator();
    L15:
        if (r10.hasNext() == false) goto L21;
        DownloadInfo r11 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r10.next(), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L15;
        if (r6.get(r11.getId()) != null) goto L15;
        r6.put(r11.getId(), r11);
    L21:
        int r12 = 0;
    L23:
        if (r12 >= r6.size()) goto L28;
        DownloadInfo r13 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r6.get(r6.keyAt(r12)), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (Cleaner.getInstance().isExistInCleanSet(r13.getId()) == true) goto L27;
        r8.add(r13);
    L27:
        r12 = r12 + 1;
        goto L23
    L28:
        return r8;
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r5) {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        IDownloadProxy r1 = DownloadProxy.get(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.getSuccessedDownloadInfosWithMimeType(r5);
    L6:
        IDownloadProxy r4 = DownloadProxy.get(true);
        if (r4 == null) goto L10;
        r2 = r4.getSuccessedDownloadInfosWithMimeType(r5);
    L10:
        return handleDownloadInfos(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public void restartAllFailedDownloadTasks(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        IDownloadProxy r3 = DownloadProxy.get(false);
        if (r3 == null) goto L5;
        r3.restartAllFailedDownloadTasks(r1);
    L5:
        IDownloadProxy r4 = DownloadProxy.get(true);
        if (r4 == null) goto L9;
        r4.restartAllFailedDownloadTasks(r1);
        return;
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        IDownloadProxy r3 = DownloadProxy.get(false);
        if (r3 == null) goto L5;
        r3.restartAllPauseReserveOnWifiDownloadTasks(r1);
    L5:
        IDownloadProxy r4 = DownloadProxy.get(true);
        if (r4 == null) goto L9;
        r4.restartAllPauseReserveOnWifiDownloadTasks(r1);
        return;
    }

    public void clearDownloadData(int r2, boolean r3) {
        IDownloadProxy r1 = getDownloadHandler(r2);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.clearDownloadData(r2, r3, true);
    }

    public void removeDownloadListener(int r7, IDownloadListener r8, ListenerType r9, boolean r10) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r8, IDownloadListener.class, "com.obric.aiagent.plugin");
        IDownloadProxy r0 = getDownloadHandler(r7);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        int r6 = 0;
    L8:
        r0.removeDownloadListener(r7, r6, r3, r9, r10);
        return;
    L7:
        r6 = r3.hashCode();
        goto L8
    }

    public void addDownloadListener(int r7, IDownloadListener r8, ListenerType r9, boolean r10) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r8, IDownloadListener.class, "com.obric.aiagent.plugin");
        IDownloadProxy r0 = getDownloadHandler(r7);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.addDownloadListener(r7, r3.hashCode(), r3, r9, r10);
    }

    public void addDownloadListener(int r8, IDownloadListener r9, ListenerType r10, boolean r11, boolean r12) {
        IDownloadListener r3 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadListener.class, "com.obric.aiagent.plugin");
        IDownloadProxy r0 = getDownloadHandler(r8);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.addDownloadListener(r8, r3.hashCode(), r3, r10, r11, r12);
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        IDownloadProxy r2 = getDownloadHandler(r3.getId());
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.isDownloadSuccessAndFileNotExist(r3);
    }

    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r5) {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        IDownloadProxy r1 = DownloadProxy.get(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.getUnCompletedDownloadInfosWithMimeType(r5);
    L6:
        IDownloadProxy r4 = DownloadProxy.get(true);
        if (r4 == null) goto L10;
        r2 = r4.getUnCompletedDownloadInfosWithMimeType(r5);
    L10:
        return handleDownloadInfos(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r5) {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        IDownloadProxy r1 = DownloadProxy.get(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.getDownloadingDownloadInfosWithMimeType(r5);
    L6:
        IDownloadProxy r4 = DownloadProxy.get(true);
        if (r4 == null) goto L10;
        r2 = r4.getDownloadingDownloadInfosWithMimeType(r5);
    L10:
        return handleDownloadInfos(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public List<DownloadInfo> getDownloadInfosByFileExtension(String r5) {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        IDownloadProxy r1 = DownloadProxy.get(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.getDownloadInfosByFileExtension(r5);
    L6:
        IDownloadProxy r4 = DownloadProxy.get(true);
        if (r4 == null) goto L10;
        r2 = r4.getDownloadInfosByFileExtension(r5);
    L10:
        return handleDownloadInfos(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        IDownloadProxy r1 = DownloadProxy.get(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.getAllDownloadInfo();
    L6:
        IDownloadProxy r4 = DownloadProxy.get(true);
        if (r4 == null) goto L10;
        r2 = r4.getAllDownloadInfo();
    L10:
        return handleDownloadInfos(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public List<DownloadInfo> getDownloadInfosByFilters(String r5, String r6) {
        SparseArray<DownloadInfo> r0 = new SparseArray();
        IDownloadProxy r1 = DownloadProxy.get(false);
        List<DownloadInfo> r2 = null;
        if (r1 == null) goto L5;
        List<DownloadInfo> r3 = r1.getDownloadInfosByFilters(r5, r6);
    L6:
        IDownloadProxy r4 = DownloadProxy.get(true);
        if (r4 == null) goto L10;
        r2 = r4.getDownloadInfosByFilters(r5, r6);
    L10:
        return handleDownloadInfos(r3, r2, r0);
    L5:
        r3 = null;
        goto L6
    }

    public void tryDownload(final DownloadTask r5) {
        final IDownloadProxy r0 = getDownloadHandler(r5);
        if (r0 != null) goto L11;
        if (r5 == null) goto L16;
        IDownloadMonitorDepend r4 = r5.getMonitorDepend();
        DownloadInfo r1 = r5.getDownloadInfo();
        BaseException r2 = new BaseException(1003, "tryDownload but getDownloadHandler failed");
        if (r5.getDownloadInfo() == null) goto L8;
        int r6 = r5.getDownloadInfo().getStatus();
    L9:
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r4, r1, r2, r6);
        return;
    L8:
        r6 = 0;
        goto L9
    L16:
        return;
    L11:
        Cleaner.getInstance().removeFromCleanSet(r5.getDownloadId());
        if (r5.isNeedDelayForCacheSync() == false) goto L14;
        DownloadComponentManager.submitScheduleTask(new AnonymousClass1(this, r0, r5), 500, TimeUnit.MILLISECONDS);
        return;
    L14:
        r0.tryDownload(r5);
    }

    public void setLogLevel(int r1) {
        IDownloadProxy r0 = DownloadProxy.get(false);
        if (r0 == null) goto L5;
        r0.setLogLevel(r1);
    L5:
        IDownloadProxy r2 = DownloadProxy.get(true);
        if (r2 == null) goto L9;
        r2.setLogLevel(r1);
        return;
    }

    public void recordTaskProcessIndependent(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        setDownloadIndependentProcessStatus(r2, Boolean.TRUE.booleanValue());
        IDownloadProxy r1 = DownloadProxy.get(true);
        if (r1 != null) goto L7;
        return;
    L7:
        r1.startService();
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        DownloadComponentManager.registerDownloadCacheSyncListener((IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin"));
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r2) {
        DownloadComponentManager.unRegisterDownloadCacheSyncListener((IDownloadCacheSyncStatusListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadCacheSyncStatusListener.class, "com.obric.aiagent.plugin"));
    }

    public boolean isDownloadCacheSyncSuccess() {
        IDownloadProxy r0 = DownloadProxy.get(false);
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isDownloadCacheSyncSuccess();
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int r1) {
        IDownloadProxy r0 = getDownloadHandler(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadFileUriProvider(r1);
    }

    public void setThrottleNetSpeed(int r1, long r2, int r4) {
        IDownloadProxy r0 = getDownloadHandler(r1);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setThrottleNetSpeed(r1, r2, r4);
    }
}

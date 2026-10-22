package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbsDownloadEngine implements WeakDownloadHandler.IHandler {
    private static final String TAG = "AbsDownloadEngine";
    private final IDownloadCache downloadCache;
    private final SparseArray<DownloadTask> downloadTaskMap;
    private final SparseArray<SparseArray<DownloadTask>> downloadTaskWithListenerMap;
    private final SparseArray<DownloadTask> failedDownloadTaskMap;
    private boolean fixAnrIsolateEngineAndCache;
    protected final WeakDownloadHandler mainHandler;
    private final LinkedBlockingDeque<DownloadTask> orderedTaskQueue;
    private final LruCache<Integer, DownloadTask> pengingTaskCache;
    private final SparseArray<DownloadTask> successDownloadTaskMap;
    private final SparseArray<DownloadTask> waitingAsyncDownloadTaskMap;

    public abstract DownloadRunnable doCancel(int r1);

    public abstract Future doDownload(DownloadTask r1);

    public abstract void doPause(int r1);

    public abstract void doSetThrottleNetSpeed(int r1, long r2, int r4);

    public abstract List<Integer> getAllAliveDownloadIds();

    public abstract boolean isDownloading(int r1);

    public abstract void removeDownloadRunnable(DownloadRunnable r1);

    static /* synthetic */ DownloadTask access$000(AbsDownloadEngine r0, int r1) {
        return r0.getDownloadTask(r1);
    }

    static /* synthetic */ void access$100(AbsDownloadEngine r0, int r1, boolean r2) {
        r0.resetDownloadDataInSubThread(r1, r2);
    }

    public AbsDownloadEngine() {
        this.downloadTaskMap = new SparseArray();
        this.successDownloadTaskMap = new SparseArray();
        this.failedDownloadTaskMap = new SparseArray();
        this.waitingAsyncDownloadTaskMap = new SparseArray();
        this.downloadTaskWithListenerMap = new SparseArray();
        this.pengingTaskCache = new LruCache();
        this.orderedTaskQueue = new LinkedBlockingDeque();
        this.mainHandler = new WeakDownloadHandler(Looper.getMainLooper(), this);
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_ANR_ISOLATE_ENGINE_AND_CACHE) <= 0) goto L5;
        boolean r0 = true;
    L6:
        this.fixAnrIsolateEngineAndCache = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void tryCacheSameTaskWithListenerHashCode(DownloadTask r6) {
        int r0 = r6.getHashCodeForSameTask();
        if (r0 == 0) goto L5;
    L7:
        if (r0 != 0) goto L9;
        return;
    L9:
        SparseArray<DownloadTask> r1 = (SparseArray) ZeusTransformUtils.preCheckCast(this.downloadTaskWithListenerMap.get(r6.getDownloadId()), SparseArray.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
        r1 = new SparseArray();
        this.downloadTaskWithListenerMap.put(r6.getDownloadId(), r1);
    L13:
        if (Logger.debugScene(r6.getDownloadInfo()) == false) goto L15;
        Logger.taskDebug(TAG, r6.getDownloadInfo(), "tryCacheSameTaskWithListenerHashCode", "Listener hashCode:" + r0);
    L15:
        r1.put(r0, r6);
        return;
    L5:
        if (r6.isAutoSetHashCodeForSameTask() == false) goto L7;
        r0 = r6.autoCalAndGetHashCodeForSameTask();
        goto L7
    }

    private void tryDownloadImpl(DownloadTask r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        DownloadInfo r0 = r11.getDownloadInfo();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEntityInvalid() == false) goto L11;
        Logger.taskError(TAG, r0.getId(), "tryDownload", "entity invalid");
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r11.getMonitorDepend(), r0, new BaseException(1003, "downloadInfo is Invalid, url is " + r0.getUrl() + " name is " + r0.getName() + " savePath is " + r0.getSavePath()), r0.getStatus());
        return;
    L11:
        r11.getTimingInfo().tryDownloadTime = System.currentTimeMillis();
        boolean r1 = true;
        DownloadComponentManager.updateCurrentDownloadThreadInfo(r11, true);
        int r7 = 0;
        if (DownloadSetting.obtain(r0.getId()).optInt(DownloadSettingKeys.NO_NET_OPT, 0) == 1) goto L14;
    L21:
        int r5 = r0.getId();
        if (Logger.debugScene(r0) == false) goto L25;
        Logger.taskDebug(TAG, r0, "tryDownload", "Url: " + r0.getUrl() + " savePath: " + r0.getSavePath() + " saveName: " + r0.getName());
    L25:
        if (this.failedDownloadTaskMap.get(r5) == null) goto L28;
        this.failedDownloadTaskMap.remove(r5);
    L28:
        if (this.successDownloadTaskMap.get(r5) == null) goto L31;
        this.successDownloadTaskMap.remove(r5);
    L31:
        if (this.waitingAsyncDownloadTaskMap.get(r5) == null) goto L34;
        this.waitingAsyncDownloadTaskMap.remove(r5);
    L34:
        if (isDownloading(r5) == false) goto L43;
        if (r0.canReStartAsyncTask() == true) goto L43;
        if (Logger.debugScene(r0) == false) goto L40;
        Logger.taskDebug(TAG, r0, "tryDownload", "Another task with same id is downloading when tryDownload");
    L40:
        r11.addListenerToDownloadingSameTask();
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r11.getMonitorDepend(), r0, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), r0.getStatus());
        return;
    L43:
        if (Logger.debugScene(r0) == false) goto L46;
        Logger.taskDebug(TAG, r0, "tryDownload", "No downloading task");
    L46:
        if (r0.canReStartAsyncTask() == false) goto L48;
        r0.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_RESTART);
    L48:
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.pengingTaskCache.remove(Integer.valueOf(r5)), DownloadTask.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L52;
        r11.copyListenerFromPendingTask(r2);
    L52:
        if (DownloadConstants.MIME_PLG.equals(r0.getMimeType()) == false) goto L54;
        r11.getDownloadInfo().safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_EXECUTOR, 3);
    L54:
        DownloadTask r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r5), DownloadTask.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L63;
        DownloadInfo r4 = r3.getDownloadInfo();
        if (r4 == null) goto L63;
        int r6 = r4.getStatus();
        if (DownloadStatus.isDownloading(r6) == true) goto L62;
        r1 = false;
    L62:
        r7 = r6;
    L65:
        if (Logger.debugScene(r0) == false) goto L67;
        Logger.taskDebug(TAG, r0, "tryDownload", "Can add listener " + r1 + " , oldTaskStatus is :" + r7);
    L67:
        if (r1 == false) goto L69;
        r11.addListenerToDownloadingSameTask();
        return;
    L69:
        tryCacheSameTaskWithListenerHashCode(r11);
        this.downloadTaskMap.put(r5, r11);
        doDownload(r11);
        return;
    L63:
        r1 = false;
        goto L65
    L14:
        if (DownloadUtils.isNetworkConnected((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L21;
        if (r0.isFirstDownload() == true) goto L21;
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK) == true) goto L21;
        new DownloadStatusHandler(r11, this.mainHandler).onError(new BaseException(DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, "network_not_available"));
    }

    public synchronized void tryDownload(DownloadTask r3) {
        monitor-enter(this);
        if (r3 != null) goto L20;
        monitor-exit(this);
        return;
    L20:
        DownloadInfo r0 = r3.getDownloadInfo();     // Catch: Throwable -> L17
        if (r0 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        r0.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L17
        if (r0.getEnqueueType() == EnqueueType.ENQUEUE_NONE) goto L14;
        enqueue(r3);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L14:
        tryDownloadImpl(r3);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private void enqueue(DownloadTask r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        DownloadInfo r0 = r5.getDownloadInfo();
        if (r0 != null) goto L8;
        return;
    L8:
        if (PluginDownloadEngine.isEnabledDownloadPluginOpt(r0) == false) goto L41;
        PluginDownloadEngine.getInstance().download(r5);
        return;
    L41:
        if (this.orderedTaskQueue.isEmpty() == false) goto L16;
        tryDownloadImpl(r5);     // Catch: InterruptedException -> L40
        this.orderedTaskQueue.put(r5);     // Catch: InterruptedException -> L40
        return;
    L16:
        if (r0.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) goto L18;
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.orderedTaskQueue.getFirst(), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L40
        if (r1.getDownloadId() == r5.getDownloadId()) goto L34;
    L36:
        pause(r1.getDownloadId());     // Catch: InterruptedException -> L40
        tryDownloadImpl(r5);     // Catch: InterruptedException -> L40
        if (r1.getDownloadId() == r5.getDownloadId()) goto L50;
        this.orderedTaskQueue.putFirst(r5);     // Catch: InterruptedException -> L40
        return;
    L50:
        return;
    L34:
        if (isDownloading(r5.getDownloadId()) == false) goto L36;
        return;
    L18:
        if (((DownloadTask) ZeusTransformUtils.preCheckCast(this.orderedTaskQueue.getFirst(), DownloadTask.class, "com.obric.aiagent.plugin")).getDownloadId() == r5.getDownloadId()) goto L20;
    L22:
        Iterator<DownloadTask> r2 = this.orderedTaskQueue.iterator();     // Catch: InterruptedException -> L40
    L24:
        if (r2.hasNext() == false) goto L30;
        DownloadTask r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(r2.next(), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L40
        if (r3 == null) goto L24;
        if (r3.getDownloadId() != r5.getDownloadId()) goto L24;
        r2.remove();     // Catch: InterruptedException -> L40
    L30:
        this.orderedTaskQueue.put(r5);     // Catch: InterruptedException -> L40
        return;
    L20:
        if (isDownloading(r5.getDownloadId()) == false) goto L22;
        return;
    }

    public DownloadInfo getDownloadInfo(int r4) {
        if (this.fixAnrIsolateEngineAndCache == false) goto L5;
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r4);
        if (r0 != null) goto L17;
        monitor-enter(this);
        DownloadTask r5 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r5 == null) goto L12;
        r0 = r5.getDownloadInfo();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        return r0;
    L5:
        return getDownloadInfoImpl(r4);
    }

    private synchronized DownloadInfo getDownloadInfoImpl(int r4) {
        monitor-enter(this);
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r4);     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        DownloadTask r5 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r5 == null) goto L8;
        r0 = r5.getDownloadInfo();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    public List<DownloadInfo> getDownloadInfoList(String r7) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L7;
        return getDownloadInfoListImpl(r7);
    L7:
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return null;
    L10:
        List<DownloadInfo> r0 = this.downloadCache.getDownloadInfoList(r7);
        if (r0 != null) goto L13;
    L16:
        monitor-enter(this);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L29
        int r2 = this.downloadTaskMap.size();     // Catch: Throwable -> L29
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L27;
        DownloadTask r4 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.valueAt(r3), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (r4 == null) goto L26;
        if (r4.getDownloadInfo() == null) goto L26;
        if (r7.equals(r4.getDownloadInfo().getUrl()) == false) goto L26;
        r1.add(r4.getDownloadInfo());     // Catch: Throwable -> L29
    L26:
        r3 = r3 + 1;     // Catch: Throwable -> L29
        goto L18
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return r1;
    L29:
        th = move-exception;
        throw th;
    L13:
        if (r0.isEmpty() == true) goto L16;
        return r0;
    }

    private synchronized List<DownloadInfo> getDownloadInfoListImpl(String r7) {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r7) == true) goto L6;
        List<DownloadInfo> r0 = this.downloadCache.getDownloadInfoList(r7);     // Catch: Throwable -> L27
        if (r0 != null) goto L11;
    L15:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L27
        int r2 = this.downloadTaskMap.size();     // Catch: Throwable -> L27
        int r3 = 0;
    L16:
        if (r3 >= r2) goto L25;
        DownloadTask r4 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.valueAt(r3), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r4 == null) goto L24;
        if (r4.getDownloadInfo() == null) goto L24;
        if (r7.equals(r4.getDownloadInfo().getUrl()) == false) goto L24;
        r1.add(r4.getDownloadInfo());     // Catch: Throwable -> L27
    L24:
        r3 = r3 + 1;
        goto L16
    L25:
        monitor-exit(this);
        return r1;
    L11:
        if (r0.isEmpty() == true) goto L15;
        monitor-exit(this);
        return r0;
    L6:
        monitor-exit(this);
        return null;
    }

    public boolean pause(int r5) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L7;
        return pauseImpl(r5);
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, r5, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));
    L9:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r5);
        if (r0 != null) goto L12;
    L14:
        doPause(r5);
        monitor-enter(this);
        if (r0 != null) goto L24;
        DownloadTask r6 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r5), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r6 == null) goto L35;
        new DownloadStatusHandler(r6, this.mainHandler).onPause();     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return true;
    L35:
        monitor-exit(this);     // Catch: Throwable -> L37
        return false;
    L24:
        if (r0.getStatus() != 1) goto L31;
        DownloadTask r7 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r5), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r7 == null) goto L35;
        new DownloadStatusHandler(r7, this.mainHandler).onPause();     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return true;
    L31:
        if (DownloadStatus.isDownloading(r0.getStatus()) == false) goto L35;
        r0.setStatus(-2);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return true;
    L37:
        th = move-exception;
        throw th;
    L12:
        if (r0.getStatus() != 11) goto L14;
        return false;
    }

    private synchronized boolean pauseImpl(int r5) {
        monitor-enter(this);
    L41:
        th = move-exception;
        throw th;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.taskDebug(TAG, r5, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L41
    L6:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r5);     // Catch: Throwable -> L41
        if (r0 != null) goto L10;
    L13:
        SparseArray<DownloadTask> r2 = this.downloadTaskMap;     // Catch: Throwable -> L41
        monitor-enter(r2);     // Catch: Throwable -> L41
        doPause(r5);     // Catch: Throwable -> L38
        monitor-exit(r2);     // Catch: Throwable -> L38
    L18:
        if (r0 != null) goto L25;
        DownloadTask r6 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r5), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if (r6 == null) goto L36;
        new DownloadStatusHandler(r6, this.mainHandler).onPause();     // Catch: Throwable -> L41
        monitor-exit(this);
        return true;
    L36:
        monitor-exit(this);
        return false;
    L25:
        if (r0.getStatus() != 1) goto L32;
        DownloadTask r7 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r5), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if (r7 == null) goto L36;
        new DownloadStatusHandler(r7, this.mainHandler).onPause();     // Catch: Throwable -> L41
        monitor-exit(this);
        return true;
    L32:
        if (DownloadStatus.isDownloading(r0.getStatus()) == false) goto L36;
        r0.setStatus(-2);     // Catch: Throwable -> L41
        monitor-exit(this);
        return true;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L10:
        if (r0.getStatus() != 11) goto L13;
        monitor-exit(this);
        return false;
    }

    public boolean cancel(int r10, boolean r11) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L7;
        return cancelImpl(r10, r11);
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, r10, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()));
    L9:
        final DownloadTask r7 = getDownloadTask(r10);
        if (r7 == null) goto L15;
        final DownloadInfo r6 = r7.getDownloadInfo();
        if (r6 == null) goto L14;
        r6.setStatus(-4);
    L14:
        final Map<Integer, IDownloadListener> r5 = r7.getDownloadListeners(ListenerType.MAIN);
        final Map<Integer, IDownloadListener> r8 = r7.getDownloadListeners(ListenerType.NOTIFICATION);
        this.mainHandler.post(new AnonymousClass1(this, r5, r6, r7, r8));
    L15:
        DownloadInfo r1 = this.downloadCache.getDownloadInfo(r10);
        if (r1 == null) goto L18;
        r1.setStatus(-4);
    L18:
        clearDownloadData(r10, r11, false);
        return true;
    }

    private synchronized boolean cancelImpl(int r9, boolean r10) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.taskDebug(TAG, r9, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L16
    L6:
        final DownloadTask r4 = getDownloadTask(r9);     // Catch: Throwable -> L16
        if (r4 == null) goto L9;
        final DownloadInfo r3 = r4.getDownloadInfo();     // Catch: Throwable -> L16
        final Map<Integer, IDownloadListener> r2 = r4.getDownloadListeners(ListenerType.MAIN);     // Catch: Throwable -> L16
        final Map<Integer, IDownloadListener> r5 = r4.getDownloadListeners(ListenerType.NOTIFICATION);     // Catch: Throwable -> L16
        this.mainHandler.post(new AnonymousClass2(this, r2, r3, r4, r5));     // Catch: Throwable -> L16
    L9:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r9);     // Catch: Throwable -> L16
        if (r0 == null) goto L12;
        r0.setStatus(-4);     // Catch: Throwable -> L16
    L12:
        clearDownloadData(r9, r10, false);     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    }

    public synchronized boolean resume(int r5) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.taskDebug(TAG, r5, "resume", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L16
    L6:
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r5), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r0 == null) goto L12;
        DownloadInfo r6 = r0.getDownloadInfo();     // Catch: Throwable -> L16
        if (r6 == null) goto L11;
        r6.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L16
    L11:
        tryDownload(r0);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return true;
    L12:
        restart(r5);     // Catch: Throwable -> L16
        goto L14
    }

    public synchronized boolean restart(int r5) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (Logger.debug() == false) goto L6;
        Logger.taskDebug(TAG, r5, "restart", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L17
    L6:
        DownloadTask r6 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.failedDownloadTaskMap.get(r5), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r6 == null) goto L15;
        DownloadInfo r1 = r6.getDownloadInfo();     // Catch: Throwable -> L17
        if (r1 == null) goto L11;
        r1.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L17
    L11:
        tryDownload(r6);     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    L15:
        monitor-exit(this);
        return false;
    }

    public synchronized void setDownloadNotificationEventListener(int r3, IDownloadNotificationEventListener r4) {
        monitor-enter(this);
        IDownloadNotificationEventListener r5 = (IDownloadNotificationEventListener) ZeusTransformUtils.wrapperContextForParams(r4, IDownloadNotificationEventListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        DownloadTask r6 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r3), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r6 == null) goto L6;
        r6.setNotificationEventListener(r5);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized INotificationClickCallback getNotificationClickCallback(int r4) {
        monitor-enter(this);
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r0 == null) goto L8;
        INotificationClickCallback r5 = r0.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r5;
    L8:
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.successDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r1 == null) goto L13;
        INotificationClickCallback r6 = r1.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r6;
    L13:
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.failedDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r2 == null) goto L18;
        INotificationClickCallback r7 = r2.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r7;
    L18:
        DownloadTask r8 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.waitingAsyncDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r8 == null) goto L24;
        INotificationClickCallback r9 = r8.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r9;
    L24:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized IDownloadNotificationEventListener getDownloadNotificationEventListener(int r4) {
        monitor-enter(this);
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r0 == null) goto L8;
        IDownloadNotificationEventListener r5 = r0.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r5;
    L8:
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.successDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r1 == null) goto L13;
        IDownloadNotificationEventListener r6 = r1.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r6;
    L13:
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.failedDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r2 == null) goto L18;
        IDownloadNotificationEventListener r7 = r2.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r7;
    L18:
        DownloadTask r8 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.waitingAsyncDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r8 == null) goto L24;
        IDownloadNotificationEventListener r9 = r8.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r9;
    L24:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized IDownloadFileUriProvider getDownloadFileUriProvider(int r4) {
        monitor-enter(this);
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r0 == null) goto L8;
        IDownloadFileUriProvider r5 = r0.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r5;
    L8:
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.successDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r1 == null) goto L13;
        IDownloadFileUriProvider r6 = r1.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r6;
    L13:
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.failedDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r2 == null) goto L18;
        IDownloadFileUriProvider r7 = r2.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r7;
    L18:
        DownloadTask r8 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.waitingAsyncDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r8 == null) goto L24;
        IDownloadFileUriProvider r9 = r8.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r9;
    L24:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized boolean restartAsyncWaitingTask(int r3) {
        monitor-enter(this);
        DownloadTask r4 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.waitingAsyncDownloadTaskMap.get(r3), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r4 == null) goto L14;
        DownloadInfo r0 = r4.getDownloadInfo();     // Catch: Throwable -> L16
        if (r0 == null) goto L14;
        if (r0.canReStartAsyncTask() == false) goto L11;
        tryDownload(r4);     // Catch: Throwable -> L16
    L11:
        monitor-exit(this);
        return true;
    L14:
        monitor-exit(this);
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized void restartAllFailedDownloadTasks(List<String> r8) {
        monitor-enter(this);
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        boolean r0 = DownloadUtils.isWifi((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L28 Throwable -> L32
        int r2 = 0;
    L5:
        if (r2 >= this.failedDownloadTaskMap.size()) goto L30;
        DownloadTask r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.failedDownloadTaskMap.get(this.failedDownloadTaskMap.keyAt(r2)), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28 Throwable -> L32
        if (r3 == null) goto L27;
        DownloadInfo r4 = r3.getDownloadInfo();     // Catch: Exception -> L28 Throwable -> L32
        if (r4 == null) goto L27;
        if (r4.isOnlyWifi() == false) goto L17;
        if (r0 == false) goto L27;
    L17:
        if (DownloadSetting.obtain(r4.getId()).optInt(DownloadSettingKeys.AUTO_RESUME, 0) != 1) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L22;
    L26:
        r4.setAutoResumed(true);     // Catch: Exception -> L28 Throwable -> L32
        r4.setShowNotificationForNetworkResumed(true);     // Catch: Exception -> L28 Throwable -> L32
        tryDownload(r3);     // Catch: Exception -> L28 Throwable -> L32
        goto L27
    L22:
        if (r4.getMimeType() == null) goto L27;
        if (r9.contains(r4.getMimeType()) == true) goto L26;
    L19:
        r5 = false;
    L27:
        r2 = r2 + 1;
    L30:
        monitor-exit(this);
        return;
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public synchronized void restartAllPauseReserveOnWifiDownloadTasks(List<String> r6) {
        monitor-enter(this);
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L31
    L29:
        monitor-exit(this);
        return;
    L5:
        if (DownloadUtils.isWifi((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= this.downloadTaskMap.size()) goto L29;
        int r1 = this.downloadTaskMap.keyAt(r0);     // Catch: Exception -> L27 Throwable -> L31
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r1), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27 Throwable -> L31
        if (r2 == null) goto L26;
        DownloadInfo r3 = r2.getDownloadInfo();     // Catch: Exception -> L27 Throwable -> L31
        if (r3 == null) goto L26;
        if (r3.getMimeType() == null) goto L26;
        if (r7.contains(r3.getMimeType()) == false) goto L26;
        if (isPauseReserveOnWifi(r3) == false) goto L26;
        r3.setAutoResumed(true);     // Catch: Exception -> L27 Throwable -> L31
        r3.setShowNotificationForNetworkResumed(true);     // Catch: Exception -> L27 Throwable -> L31
        tryDownload(r2);     // Catch: Exception -> L27 Throwable -> L31
        r3.setDownloadFromReserveWifi(true);     // Catch: Exception -> L27 Throwable -> L31
        IReserveWifiStatusListener r4 = Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getReserveWifiStatusListener();     // Catch: Exception -> L27 Throwable -> L31
        if (r4 == null) goto L26;
        r4.onStatusChanged(r3, 5, 2);     // Catch: Exception -> L27 Throwable -> L31
    L26:
        r0 = r0 + 1;
    L31:
        th = move-exception;
        throw th;
    }

    private boolean isPauseReserveOnWifi(DownloadInfo r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.statusInPause() == true) goto L8;
        return false;
    L8:
        return r2.isPauseReserveOnWifi();
    }

    public void shutDown() {
        List<Integer> r0 = getAllAliveDownloadIds();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<Integer> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        pause(((Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        goto L7
    }

    public void clearDownloadData(final int r4, final boolean r5, final boolean r6) {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, r4, "clearDownloadData", "DeleteFile:" + r5 + " deleteFileIgnoreSecurity:" + r6 + "Trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        this.mainHandler.post(new AnonymousClass3(this, r4));
        DownloadComponentManager.submitCPUTask(new AnonymousClass4(this, r4, r5, r6), false);
    }

    public void clearDownloadDataInSubThread(int r5, boolean r6, boolean r7) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L7;
        clearDownloadDataInSubThreadImpl(r5, r6, r7);
        return;
    L7:
        if (Logger.debug() == false) goto L42;
        Logger.taskDebug(TAG, r5, "clearDownloadDataInSubThread", "DeleteFile:" + r6 + " deleteFileIgnoreSecurity:" + r7);
    L42:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r5);     // Catch: Throwable -> L35
        if (r0 == null) goto L38;
        if (r6 == false) goto L15;
        if (r7 == false) goto L14;
        new DownloadFile(r0.getSavePath(), r0.getName(), false, false).delete();     // Catch: Throwable -> L35
    L14:
        DownloadUtils.deleteAllDownloadFiles(r0, r6);     // Catch: Throwable -> L35
    L16:
        r0.erase();     // Catch: Throwable -> L35
        goto L38
    L15:
        DownloadUtils.deleteFile(r0.getTempPath(), r0.getTempName());     // Catch: Throwable -> L35
    L38:
        this.downloadCache.removeDownloadTaskData(r5);     // Catch: SQLiteException -> L19 Throwable -> L35
    L21:
        monitor-enter(this);     // Catch: Throwable -> L35
        refreshDownloadTaskMap(r5, 0, -4);     // Catch: Throwable -> L32
        if (this.failedDownloadTaskMap.get(r5) == null) goto L27;
        this.failedDownloadTaskMap.remove(r5);     // Catch: Throwable -> L32
    L27:
        if (this.successDownloadTaskMap.get(r5) == null) goto L29;
        this.successDownloadTaskMap.remove(r5);     // Catch: Throwable -> L32
    L29:
        this.pengingTaskCache.remove(Integer.valueOf(r5));     // Catch: Throwable -> L32
        DownloadSetting.removeTaskDownloadSetting(r5);     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
    L44:
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();
    }

    private synchronized void clearDownloadDataInSubThreadImpl(int r5, boolean r6, boolean r7) {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (Logger.debug() == false) goto L36;
        Logger.taskDebug(TAG, r5, "clearDownloadDataInSubThread", "DeleteFile:" + r6 + " deleteFileIgnoreSecurity:" + r7);     // Catch: Throwable -> L30
    L36:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r5);     // Catch: Throwable -> L26
        if (r0 == null) goto L34;
        if (r6 == false) goto L12;
        if (r7 == false) goto L11;
        new DownloadFile(r0.getSavePath(), r0.getName(), false, false).delete();     // Catch: Throwable -> L26
    L11:
        DownloadUtils.deleteAllDownloadFiles(r0, r6);     // Catch: Throwable -> L26
    L13:
        r0.erase();     // Catch: Throwable -> L26
        goto L34
    L12:
        DownloadUtils.deleteFile(r0.getTempPath(), r0.getTempName());     // Catch: Throwable -> L26
    L34:
        this.downloadCache.removeDownloadTaskData(r5);     // Catch: SQLiteException -> L16 Throwable -> L26
    L18:
        refreshDownloadTaskMap(r5, 0, -4);     // Catch: Throwable -> L26
        if (this.failedDownloadTaskMap.get(r5) == null) goto L22;
        this.failedDownloadTaskMap.remove(r5);     // Catch: Throwable -> L26
    L22:
        if (this.successDownloadTaskMap.get(r5) == null) goto L24;
        this.successDownloadTaskMap.remove(r5);     // Catch: Throwable -> L26
    L24:
        this.pengingTaskCache.remove(Integer.valueOf(r5));     // Catch: Throwable -> L26
        DownloadSetting.removeTaskDownloadSetting(r5);     // Catch: Throwable -> L26
    L28:
        monitor-exit(this);
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L30
        goto L28
    }

    public void resetDownloadData(final int r4, final boolean r5) {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, r4, "resetDownloadData", "DeleteFile:" + r5 + "Trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        this.mainHandler.post(new AnonymousClass5(this, r4));
        DownloadComponentManager.submitCPUTask(new AnonymousClass6(this, r4, r5), false);
    }

    private void resetDownloadDataInSubThread(int r2, boolean r3) {
        if (this.fixAnrIsolateEngineAndCache == true) goto L33;
        resetDownloadDataInSubThreadImpl(r2, r3);
        return;
    L33:
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r2);     // Catch: Throwable -> L26
        if (r0 == null) goto L31;
        DownloadUtils.deleteAllDownloadFiles(r0, r3);     // Catch: Throwable -> L26
        r0.erase();     // Catch: Throwable -> L26
    L31:
        this.downloadCache.updateDownloadInfo(r0);     // Catch: SQLiteException -> L11 Throwable -> L26
    L13:
        monitor-enter(this);     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L15:
        if (this.failedDownloadTaskMap.get(r2) == null) goto L18;
        this.failedDownloadTaskMap.remove(r2);     // Catch: Throwable -> L23
    L18:
        if (this.successDownloadTaskMap.get(r2) == null) goto L20;
        this.successDownloadTaskMap.remove(r2);     // Catch: Throwable -> L23
    L20:
        this.pengingTaskCache.remove(Integer.valueOf(r2));     // Catch: Throwable -> L23
        DownloadSetting.removeTaskDownloadSetting(r2);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
    L35:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
    }

    private void resetDownloadDataInSubThreadImpl(int r2, boolean r3) {
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r2);     // Catch: Throwable -> L17
        if (r0 == null) goto L20;
        DownloadUtils.deleteAllDownloadFiles(r0, r3);     // Catch: Throwable -> L17
        r0.erase();     // Catch: Throwable -> L17
    L20:
        this.downloadCache.updateDownloadInfo(r0);     // Catch: SQLiteException -> L7 Throwable -> L17
    L10:
        if (this.failedDownloadTaskMap.get(r2) == null) goto L13;
        this.failedDownloadTaskMap.remove(r2);     // Catch: Throwable -> L17
    L13:
        if (this.successDownloadTaskMap.get(r2) == null) goto L15;
        this.successDownloadTaskMap.remove(r2);     // Catch: Throwable -> L17
    L15:
        this.pengingTaskCache.remove(Integer.valueOf(r2));     // Catch: Throwable -> L17
        DownloadSetting.removeTaskDownloadSetting(r2);     // Catch: Throwable -> L17
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    public synchronized boolean isInDownloadTaskPool(int r2) {
        monitor-enter(this);
        if (r2 != 0) goto L15;
    L12:
        boolean r3 = false;
    L13:
        monitor-exit(this);
        return r3;
    L15:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.downloadTaskMap.get(r2) != null) goto L8;
        if (this.failedDownloadTaskMap.get(r2) == null) goto L12;
    L8:
        r3 = true;
        goto L13
    }

    public synchronized void removeDownloadListener(int r3, int r4, IDownloadListener r5, ListenerType r6, boolean r7) {
        monitor-enter(this);
        IDownloadListener r8 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        DownloadTask r0 = getDownloadTask(r3);     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
        r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.pengingTaskCache.get(Integer.valueOf(r3)), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
    L6:
        if (r0 == null) goto L8;
        r0.removeDownloadListener(r4, r8, r6, r7);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void addDownloadListener(int r8, int r9, IDownloadListener r10, ListenerType r11, boolean r12) {
        addDownloadListener(r8, r9, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadListener.class, "com.obric.aiagent.plugin"), r11, r12, true);
    }

    public void addDownloadListener(int r8, int r9, IDownloadListener r10, final ListenerType r11, boolean r12, boolean r13) {
        final IDownloadListener r14 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadListener.class, "com.obric.aiagent.plugin");
        if (this.fixAnrIsolateEngineAndCache == true) goto L6;
        addDownloadListenerImpl(r8, r9, r14, r11, r12, r13);
        return;
    L6:
        monitor-enter(this);
        final DownloadTask r5 = getDownloadTask(r8);     // Catch: Throwable -> L42
        if (r5 == null) goto L27;
        r5.addDownloadListener(r9, r14, r11, r12);     // Catch: Throwable -> L42
        final DownloadInfo r4 = r5.getDownloadInfo();     // Catch: Throwable -> L42
        if (r13 == false) goto L25;
        if (r4 == null) goto L25;
        if (isDownloading(r8) == true) goto L25;
        if (r11 != ListenerType.MAIN) goto L17;
    L18:
        boolean r15 = true;
        if (r11 == ListenerType.NOTIFICATION) goto L21;
    L23:
        if (r15 == false) goto L25;
        final int r3 = r4.getStatus();     // Catch: Throwable -> L42
        this.mainHandler.post(new AnonymousClass7(this, r14, r3, r4, r5, r11));     // Catch: Throwable -> L42
        goto L25
    L21:
        if (r4.canShowNotification() == true) goto L23;
        r15 = false;
        goto L23
    L17:
        if (r11 == ListenerType.NOTIFICATION) goto L18;
    L25:
        monitor-exit(this);     // Catch: Throwable -> L42
        return;
    L27:
        monitor-exit(this);     // Catch: Throwable -> L42
        DownloadInfo r16 = this.downloadCache.getDownloadInfo(r8);
        monitor-enter(this);
        if (r16 != null) goto L45;
    L37:
        monitor-exit(this);     // Catch: Throwable -> L39
        return;
    L39:
        th = move-exception;
        throw th;
    L45:
        if (r16.getStatus() == (-3)) goto L37;
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.pengingTaskCache.get(Integer.valueOf(r8)), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
        if (r0 != null) goto L36;
        r0 = new DownloadTask(r16);     // Catch: Throwable -> L39
        this.pengingTaskCache.put(Integer.valueOf(r8), r0);     // Catch: Throwable -> L39
    L36:
        r0.addDownloadListener(r9, r14, r11, r12);     // Catch: Throwable -> L39
    L42:
        th = move-exception;
        throw th;
    }

    private synchronized void addDownloadListenerImpl(int r7, int r8, IDownloadListener r9, final ListenerType r10, boolean r11, boolean r12) {
        monitor-enter(this);
        final IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        final DownloadTask r4 = getDownloadTask(r7);     // Catch: Throwable -> L31
        if (r4 == null) goto L21;
        r4.addDownloadListener(r8, r2, r10, r11);     // Catch: Throwable -> L31
        final DownloadInfo r3 = r4.getDownloadInfo();     // Catch: Throwable -> L31
        if (r12 == false) goto L29;
        if (r3 == null) goto L29;
        if (isDownloading(r7) == true) goto L29;
        if (r10 != ListenerType.MAIN) goto L13;
    L14:
        boolean r13 = true;
        if (r10 == ListenerType.NOTIFICATION) goto L17;
    L19:
        if (r13 == false) goto L29;
        this.mainHandler.post(new AnonymousClass8(this, r2, r3, r4, r10));     // Catch: Throwable -> L31
        goto L29
    L17:
        if (r3.canShowNotification() == true) goto L19;
        r13 = false;
        goto L19
    L13:
        if (r10 == ListenerType.NOTIFICATION) goto L14;
    L29:
        monitor-exit(this);
        return;
    L21:
        DownloadInfo r14 = this.downloadCache.getDownloadInfo(r7);     // Catch: Throwable -> L31
        if (r14 == null) goto L29;
        if (r14.getStatus() == (-3)) goto L29;
        DownloadTask r15 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.pengingTaskCache.get(Integer.valueOf(r7)), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (r15 != null) goto L28;
        r15 = new DownloadTask(r14);     // Catch: Throwable -> L31
        this.pengingTaskCache.put(Integer.valueOf(r7), r15);     // Catch: Throwable -> L31
    L28:
        r15.addDownloadListener(r8, r2, r10, r11);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    private DownloadTask getDownloadTask(int r4) {
        if (this.fixAnrIsolateEngineAndCache == false) goto L5;
        monitor-enter(this);
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.failedDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.successDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.waitingAsyncDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r0;
    L16:
        th = move-exception;
        throw th;
    L5:
        return getDownloadTaskImpl(r4);
    }

    private DownloadTask getDownloadTaskImpl(int r4) {
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L10;
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.failedDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L11;
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.successDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        return r2;
    L9:
        return (DownloadTask) ZeusTransformUtils.preCheckCast(this.waitingAsyncDownloadTaskMap.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");
    L11:
        return r1;
    L10:
        return r0;
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return null;
    L6:
        Iterator<Integer> r0 = getAllAliveDownloadIds().iterator();
        ArrayList r1 = new ArrayList();
    L8:
        if (r0.hasNext() == false) goto L14;
        DownloadInfo r2 = getDownloadInfo(((Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        if (r2 == null) goto L8;
        if (r6.equals(r2.getMimeType()) == false) goto L8;
        r1.add(r2);
        goto L8
    L14:
        return r1;
    }

    private void notifyDownloadTaskStatus(int r10, BaseException r11, DownloadTask r12) {
        if (r12 == null) goto L16;
        DownloadInfo r9 = r12.getDownloadInfo();
        if (r9 != null) goto L7;
        Logger.globalError(TAG, "notifyDownloadTaskStatus", "DownloadInfo is null\"");
        return;
    L7:
        Map<Integer, IDownloadListener> r1 = r12.getDownloadListeners(ListenerType.MAIN);
        Map<Integer, IDownloadListener> r7 = r12.getDownloadListeners(ListenerType.NOTIFICATION);
        if (r12.canShowNotification() == false) goto L10;
    L13:
        boolean r0 = true;
    L14:
        DownloadListenerUtils.notifyListener(r10, r1, true, r9, r11, ListenerType.MAIN, r12);
        DownloadListenerUtils.notifyListener(r10, r7, r0, r9, r11, ListenerType.NOTIFICATION, r12);
        return;
    L10:
        if (r9.isAutoInstallWithoutNotification() == true) goto L13;
        r0 = false;
        goto L14
    }

    private void tryDownloadNextTaskInQueue(int r4) {
        if (this.orderedTaskQueue.isEmpty() == false) goto L5;
        return;
    L5:
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.orderedTaskQueue.getFirst(), DownloadTask.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L11;
        if (r0.getDownloadId() != r4) goto L11;
        this.orderedTaskQueue.poll();
    L11:
        if (this.orderedTaskQueue.isEmpty() == false) goto L13;
        return;
    L13:
        DownloadTask r5 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.orderedTaskQueue.getFirst(), DownloadTask.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L17;
        tryDownloadImpl(r5);
        return;
    }

    private void removeTask(int r6, int r7) {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, r6, "removeTask", "Listener hashCode: " + r7);
    L5:
        if (r7 != 0) goto L7;
        this.downloadTaskMap.remove(r6);
        this.downloadTaskWithListenerMap.remove(r6);
        return;
    L7:
        SparseArray r0 = (SparseArray) ZeusTransformUtils.preCheckCast(this.downloadTaskWithListenerMap.get(r6), SparseArray.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L15;
        r0.remove(r7);
        if (Logger.debug() == false) goto L13;
        Logger.taskDebug(TAG, r6, "removeTask", "After downloadTaskWithListenerMap removeTask taskArray.size: " + r0.size());
    L13:
        if (r0.size() != 0) goto L18;
        this.downloadTaskMap.remove(r6);
        this.downloadTaskWithListenerMap.remove(r6);
        return;
    L18:
        return;
    L15:
        this.downloadTaskMap.remove(r6);
    }

    public void refreshDownloadTaskMap(int r3, int r4, int r5) {
        if (r5 != (-7)) goto L5;
    L48:
        monitor-enter(this);
        DownloadTask r6 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r3), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        if (r6 != null) goto L52;
    L55:
        tryDownloadNextTaskInQueue(r3);     // Catch: Throwable -> L58
        monitor-exit(this);     // Catch: Throwable -> L58
        return;
    L52:
        if (this.failedDownloadTaskMap.get(r3) != null) goto L54;
        this.failedDownloadTaskMap.put(r3, r6);     // Catch: Throwable -> L58
    L54:
        removeTask(r3, r4);     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        throw th;
    L5:
        if (r5 != (-6)) goto L7;
        monitor-enter(this);
        DownloadTask r7 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r3), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        this.successDownloadTaskMap.put(r3, r7);     // Catch: Throwable -> L45
        removeTask(r3, r4);     // Catch: Throwable -> L45
        monitor-exit(this);     // Catch: Throwable -> L45
        return;
    L45:
        th = move-exception;
        throw th;
    L7:
        if (r5 != (-4)) goto L9;
        monitor-enter(this);
        removeTask(r3, r4);     // Catch: Throwable -> L38
        tryDownloadNextTaskInQueue(r3);     // Catch: Throwable -> L38
        monitor-exit(this);     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        throw th;
    L9:
        if (r5 != (-3)) goto L11;
        monitor-enter(this);
        DownloadTask r8 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r3), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        this.successDownloadTaskMap.put(r3, r8);     // Catch: Throwable -> L31
        removeTask(r3, r4);     // Catch: Throwable -> L31
        tryDownloadNextTaskInQueue(r3);     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    L11:
        if (r5 == (-1)) goto L48;
        if (r5 != 8) goto L75;
        monitor-enter(this);
        DownloadTask r9 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r3), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r9 != null) goto L19;
    L21:
        tryDownloadNextTaskInQueue(r3);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L19:
        if (this.waitingAsyncDownloadTaskMap.get(r3) != null) goto L21;
        this.waitingAsyncDownloadTaskMap.put(r3, r9);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
    public void handleMsg(Message r8) {
        int r0 = r8.arg1;
        int r1 = r8.arg2;
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, r0, "handleMsg", "Listener hashCode: " + r1);
    L5:
        DownloadTask r3 = null;
        if (ZeusTransformUtils.instanceOf(r8.obj, Exception.class) == false) goto L8;
        BaseException r2 = (BaseException) ZeusTransformUtils.preCheckCast(r8.obj, BaseException.class, "com.obric.aiagent.plugin");
    L9:
        monitor-enter(this);
        if (r1 != 0) goto L12;
        r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r0), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
    L15:
        if (r3 != null) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L18:
        notifyDownloadTaskStatus(r8.what, r2, r3);     // Catch: Throwable -> L21
        refreshDownloadTaskMap(r0, r1, r8.what);     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L12:
        SparseArray r4 = (SparseArray) ZeusTransformUtils.preCheckCast(this.downloadTaskWithListenerMap.get(r0), SparseArray.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r4 == null) goto L15;
        r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(r4.get(r1), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L8:
        r2 = null;
        goto L9
    }

    public DownloadTask getDownloadTask(int r3, int r4) {
        monitor-enter(this);
        if (r4 != 0) goto L5;
        DownloadTask r5 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.downloadTaskMap.get(r3), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r5;
    L5:
        SparseArray r6 = (SparseArray) ZeusTransformUtils.preCheckCast(this.downloadTaskWithListenerMap.get(r3), SparseArray.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r6 == null) goto L8;
        r5 = (DownloadTask) ZeusTransformUtils.preCheckCast(r6.get(r4), DownloadTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        goto L9
    L8:
        r5 = null;
    L11:
        th = move-exception;
        throw th;
    }

    public void setThrottleNetSpeed(int r2, long r3, int r5) {
        DownloadInfo r0 = this.downloadCache.getDownloadInfo(r2);
        if (r0 == null) goto L5;
        r0.setThrottleNetSpeed(r3, r5);
    L5:
        doSetThrottleNetSpeed(r2, r3, r5);
    }
}

package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadStatusHandler {
    private static final String TAG = "DownloadStatusHandler";
    private IDownloadCache downloadCache;
    private DownloadInfo downloadInfo;
    private IDownloadMonitorDepend downloadMonitorDepend;
    private DownloadTask downloadTask;
    private final boolean fixAnrProcessHandleMsg;
    private final boolean fixSameTaskMonitorReport;
    private boolean forceRefreshProcess;
    private boolean hasSyncProgressBefore;
    private boolean isFastDownload;
    private volatile long lastSyncProgressTime;
    private boolean mRemoveUselessReport;
    private final Handler mainThreadHandler;
    private Map<Integer, IDownloadListener> mainThreadListeners;
    private long minByteIntervalForSyncProgress;
    private int minTimeIntervalForSyncProgress;
    private final AtomicLong msgPostDataBuffer;
    private Map<Integer, IDownloadListener> notificationListeners;
    private long prepareDownloadTime;
    private Map<Integer, IDownloadListener> subThreadListeners;

    static {
    }

    public DownloadStatusHandler(DownloadTask r4, Handler r5) {
        boolean r0 = false;
        this.forceRefreshProcess = false;
        this.lastSyncProgressTime = 0;
        this.msgPostDataBuffer = new AtomicLong();
        this.hasSyncProgressBefore = false;
        this.downloadTask = r4;
        this.downloadInfo = r4.getDownloadInfo();
        this.mainThreadListeners = r4.getDownloadListeners(ListenerType.MAIN);
        this.notificationListeners = r4.getDownloadListeners(ListenerType.NOTIFICATION);
        this.subThreadListeners = r4.getDownloadListeners(ListenerType.SUB);
        this.downloadMonitorDepend = r4.getMonitorDepend();
        this.mainThreadHandler = r5;
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        boolean r6 = this.downloadInfo.isFastDownload();
        this.isFastDownload = r6;
        if (r6 == false) goto L8;
        if (ZeusTransformUtils.instanceOf(this.downloadCache, DefaultDownloadCache.class) == false) goto L8;
        this.downloadCache = ((DefaultDownloadCache) ZeusTransformUtils.preCheckCast(this.downloadCache, DefaultDownloadCache.class, "com.obric.aiagent.plugin")).getDownloadCache();
    L8:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_ANR_PROGRESS_HANDLE_MSG) <= 0) goto L10;
        boolean r7 = true;
    L11:
        this.fixAnrProcessHandleMsg = r7;
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_SAME_TASK_MONITOR_REPORT) <= 0) goto L14;
        boolean r8 = true;
    L15:
        this.fixSameTaskMonitorReport = r8;
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.REMOVE_USELESS_MONITOR_REPORT) <= 0) goto L18;
        r0 = true;
    L18:
        this.mRemoveUselessReport = r0;
        return;
    L14:
        r8 = false;
        goto L15
    L10:
        r7 = false;
        goto L11
    }

    public void onPrepare() {
        this.prepareDownloadTime = System.currentTimeMillis();
        if (this.downloadInfo.canSkipStatusHandler() == false) goto L5;
        return;
    L5:
        this.downloadInfo.setStatus(1);
    }

    public void handlePrepare() {
        DownloadTimingInfo r0 = this.downloadTask.getTimingInfo();
        r0.beforeOnPrepareTime = System.currentTimeMillis();
        if (this.downloadInfo.canSkipStatusHandler() == true) goto L5;
        this.downloadCache.OnDownloadTaskPrepare(this.downloadInfo.getId());
        onStatusChanged(1, null);
    L5:
        long r1 = this.prepareDownloadTime;
        if (r1 > 0) goto L11;
    L8:
        DownloadTimingInfo r4 = this.downloadTask.getTimingInfo();
        r4.afterOnPrepareTime = System.currentTimeMillis();
        return;
    L11:
        this.downloadInfo.increaseDownloadPrepareTime(r1);     // Catch: Throwable -> L10
        goto L8
    }

    public void onStart() {
        DownloadTimingInfo r0 = this.downloadTask.getTimingInfo();
        r0.beforeOnStartTime = System.currentTimeMillis();
        if (this.downloadInfo.canSkipStatusHandler() == false) goto L6;
        this.downloadInfo.changeSkipStatus();
    L12:
        DownloadTimingInfo r4 = this.downloadTask.getTimingInfo();
        r4.afterOnStartTime = System.currentTimeMillis();
        return;
    L6:
        if (this.downloadInfo.getDownloadStartTimeStamp() > 0) goto L8;
        this.downloadInfo.setDownloadStartTimeStamp(System.currentTimeMillis());
    L8:
        this.downloadCache.onDownloadTaskStart(this.downloadInfo.getId());
        if (this.downloadInfo.isFirstDownload() == false) goto L11;
        onStatusChanged(6, null);
    L11:
        onStatusChanged(2, null);
        goto L12
    }

    public void onFirstConnectionSuccessed(long r8, String r10, String r11) {
        this.downloadInfo.setTotalBytes(r8);
        this.downloadInfo.seteTag(r10);
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L13:
        this.downloadCache.OnDownloadTaskConnected(this.downloadInfo.getId(), r8, r10, r11);     // Catch: Exception -> L9
    L11:
        onStatusChanged(3, null);
        this.minByteIntervalForSyncProgress = this.downloadInfo.getMinByteIntervalForPostToMainThread(r8);
        this.minTimeIntervalForSyncProgress = this.downloadInfo.getMinProgressTimeMsInterval();
        this.forceRefreshProcess = true;
        RetryScheduler.getInstance().scheduleRetryWhenHasTaskConnected();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L5:
        if (TextUtils.isEmpty(this.downloadInfo.getName()) == false) goto L13;
        this.downloadInfo.setName(r11);
        goto L13
    }

    public boolean onProgress(long r2) {
        this.msgPostDataBuffer.addAndGet(r2);
        this.downloadInfo.increaseCurBytes(r2);
        long r3 = SystemClock.uptimeMillis();
        return handleProgress(r3, needSyncProgress(r3));
    }

    public void onCancel() {
        onStatusChanged(-4, null);
    }

    public void onPause() {
        this.downloadInfo.setStatus(-2);
        this.downloadCache.OnDownloadTaskPause(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());     // Catch: SQLiteException -> L5
    L7:
        onStatusChanged(-2, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void onIntercept() {
        this.downloadInfo.setStatus(-7);
        this.downloadCache.OnDownloadTaskIntercept(this.downloadInfo.getId());     // Catch: SQLiteException -> L5
    L7:
        onStatusChanged(-7, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void onRetry(BaseException r4) {
        this.downloadInfo.setFirstDownload(false);
        this.msgPostDataBuffer.set(0);
        handleRetry(r4);
    }

    public void onError(BaseException r3) {
        this.downloadInfo.setFirstDownload(false);
        handleError(r3);
    }

    public void onReceiveData(byte[] r2, int r3) {
        DownloadListenerUtils.notifyReceiveData(this.subThreadListeners, this.downloadInfo, r2, r3);
    }

    public void onReceiveHeader(List<Pair<String, String>> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        DownloadListenerUtils.notifyReceiveHeader(this.subThreadListeners, this.downloadInfo, r4);
    }

    public void onReceiveRequestLog(String r2) {
        DownloadListenerUtils.notifyReceiveRequestLog(this.subThreadListeners, this.downloadInfo, r2);
    }

    private void handleError(BaseException r6) {
        String r0 = TAG;
        Logger.taskError(r0, this.downloadInfo.getId(), "handleError", "Exception:" + r6);
        if (Logger.debug() == false) goto L5;
        Logger.taskError(r0, this.downloadInfo.getId(), "handleError", "Exception Trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        if (r6 != null) goto L7;
    L28:
        this.downloadCache.OnDownloadTaskError(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());     // Catch: SQLiteException -> L16
    L20:
        BaseException r7 = reviseFailedException(r6);
        this.downloadInfo.setFailedException(r7);
        if (ZeusTransformUtils.instanceOf(r7, DownloadPauseReserveWifiException.class) == false) goto L23;
        int r1 = -2;
    L24:
        onStatusChanged(r1, r7);
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.RETRY_SCHEDULE, 0) <= 0) goto L33;
        RetryScheduler.getInstance().tryStartScheduleRetry(this.downloadInfo);
        return;
    L33:
        return;
    L23:
        r1 = -1;
    L16:
        this.downloadCache.removeDownloadTaskData(this.downloadInfo.getId());     // Catch: SQLiteException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L7:
        if (r6.getCause() == null) goto L28;
        if (ZeusTransformUtils.instanceOf(r6.getCause(), SQLiteFullException.class) == false) goto L28;
        this.downloadCache.removeDownloadTaskData(this.downloadInfo.getId());     // Catch: SQLiteException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    private BaseException reviseFailedException(BaseException r3) {
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.DOWNLOAD_FAILED_CHECK_NET, 1) == 1) goto L5;
    L14:
        return r3;
    L5:
        if (DownloadUtils.isNetworkError(r3) == false) goto L14;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L14;
        if (DownloadUtils.isNetworkConnected(r2) == true) goto L14;
        if (DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK) == true) goto L14;
        return new BaseException(DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, r3.getErrorMessage());
    }

    public void onSaveTempFileSuccess() {
    L17:
        th = move-exception;
        onError(new BaseException(1008, DownloadUtils.getErrorMsgWithTagPrefix(th, "onCompleted")));
        return;
    L3:
        if (Logger.debugScene(this.downloadInfo) == false) goto L21;
        Logger.taskDebug(TAG, this.downloadInfo, "onSaveTempFileSuccess", "Success");     // Catch: Throwable -> L17
    L21:
        downloadCompleteProcess();     // Catch: BaseException -> L14 Throwable -> L17
        DownloadInfo r0 = this.downloadInfo;     // Catch: Throwable -> L17
        if (r0 != null) goto L10;
        onError(new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_INFO_NULL, "onSaveTempFileSuccess DownloadInfo is null"));     // Catch: Throwable -> L17
        return;
    L10:
        r0.setFirstSuccess(false);     // Catch: Throwable -> L17
        this.downloadInfo.setSuccessByCache(false);     // Catch: Throwable -> L17
        if (this.downloadInfo.getDownloadFinishTimeStamp() > 0) goto L13;
        this.downloadInfo.setDownloadFinishTimeStamp(System.currentTimeMillis());     // Catch: Throwable -> L17
    L13:
        onStatusChanged(-3, null);     // Catch: Throwable -> L17
        this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());     // Catch: Throwable -> L17
        this.downloadCache.removeSegments(this.downloadInfo.getId());     // Catch: Throwable -> L17
        return;
    L14:
        e = move-exception;
        onError(e);     // Catch: Throwable -> L17
    }

    public void onCompleteForFileExist() {
        if (this.downloadInfo == null) goto L10;
        downloadCompleteProcess();
        if (Logger.debugScene(this.downloadInfo) == false) goto L7;
        Logger.taskDebug(TAG, this.downloadInfo, "onCompleteForFileExist", "Success");
    L7:
        this.downloadInfo.setSuccessByCache(true);
        onStatusChanged(-3, null);
        this.downloadCache.OnDownloadTaskCompleted(this.downloadInfo.getId(), this.downloadInfo.getTotalBytes());
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        return;
    L10:
        throw new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_INFO_NULL, "onCompleteForFileExist DownloadInfo is null");
    }

    public void onCompleteForFileExist(String r5, String r6) {
        if (Logger.debugScene(this.downloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.downloadInfo, "onCompleteForFileExist", "ExistTargetFileName:" + r6 + " but curName is " + this.downloadInfo.getName());
    L5:
        DownloadHelper.copyFileFromExistFileWithSameName(this.downloadInfo, r5, r6);
        downloadCompleteProcess();
        this.downloadInfo.setSuccessByCache(true);
        onStatusChanged(-3, null);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
    }

    private void downloadCompleteProcess() {
        List<IDownloadCompleteHandler> r0 = this.downloadTask.getDownloadCompleteHandlers();
        if (r0.isEmpty() == true) goto L17;
        DownloadInfo r1 = this.downloadInfo;
        onStatusChanged(11, null);
        this.downloadCache.updateDownloadInfo(r1);
        Iterator<IDownloadCompleteHandler> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L25;
        IDownloadCompleteHandler r3 = (IDownloadCompleteHandler) ZeusTransformUtils.preCheckCast(r2.next(), IDownloadCompleteHandler.class, "com.obric.aiagent.plugin");
    L15:
        e = move-exception;
        throw e;
    L12:
        th = move-exception;
        throw new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_COMPLETE_HANDLER, th);
    L9:
        if (r3.needHandle(r1) == false) goto L6;
        r3.handle(r1);     // Catch: Throwable -> L12 BaseException -> L15
        this.downloadCache.updateDownloadInfo(r1);     // Catch: Throwable -> L12 BaseException -> L15
    L25:
        return;
    }

    private boolean handleProgress(long r3, boolean r5) {
        boolean r4 = false;
        if (this.downloadInfo.getCurBytes() != this.downloadInfo.getTotalBytes()) goto L10;
        this.downloadCache.OnDownloadTaskProgress(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());     // Catch: Exception -> L6
    L8:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L10:
        if (this.forceRefreshProcess == false) goto L13;
        this.forceRefreshProcess = false;
        this.downloadInfo.setStatus(4);
    L13:
        if (this.downloadInfo.isNeedPostProgress() == false) goto L16;
        if (r5 == false) goto L16;
        r4 = true;
    L16:
        onStatusChanged(4, null, r4);
        return r5;
    }

    private boolean needSyncProgress(long r9) {
        boolean r1 = true;
        if (this.hasSyncProgressBefore == true) goto L6;
        this.hasSyncProgressBefore = true;
        return true;
    L6:
        long r2 = r9 - this.lastSyncProgressTime;
        if (this.msgPostDataBuffer.get() < this.minByteIntervalForSyncProgress) goto L9;
    L12:
        if (r1 == false) goto L14;
        this.lastSyncProgressTime = r9;
        this.msgPostDataBuffer.set(0);
    L14:
        return r1;
    L9:
        if (r2 >= this.minTimeIntervalForSyncProgress) goto L12;
        r1 = false;
        goto L12
    }

    private void handleRetry(BaseException r3) {
        this.downloadCache.OnDownloadTaskRetry(this.downloadInfo.getId());
        onStatusChanged(5, r3);
    }

    private void onStatusChanged(int r3, BaseException r4) {
        if (this.isFastDownload == false) goto L10;
        if (r3 != 1) goto L6;
        return;
    L6:
        if (r3 != 6) goto L8;
        return;
    L8:
        if (r3 != 2) goto L10;
        return;
    L10:
        onStatusChanged(r3, r4, true);
    }

    public void handleWaitingAsyncHandler() {
        this.downloadInfo.setStatus(8);
        this.downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_WAITING);
        AbsDownloadEngine r0 = DownloadComponentManager.getDownloadEngine();
        if (r0 == null) goto L6;
        r0.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), 8);
        return;
    }

    private void onStatusChanged(int r10, BaseException r11, boolean r12) {
        int r0 = this.downloadInfo.getStatus();
        if (r0 != (-3)) goto L10;
        if (r10 != 4) goto L10;
        if (Logger.debugScene(this.downloadInfo) == false) goto L65;
        Logger.taskDebug(TAG, this.downloadInfo, "onStatusChanged", "Status = " + r0 + ", monitorStatus = " + r10);
        return;
    L65:
        return;
    L10:
        if (r10 != 4) goto L12;
    L24:
        if (r10 != 6) goto L27;
        this.downloadInfo.setStatus(2);
    L30:
        if (r0 == (-3)) goto L34;
        if (r0 == (-1)) goto L34;
    L39:
        DownloadListenerUtils.notifyListener(r10, this.subThreadListeners, true, this.downloadInfo, r11, ListenerType.SUB, this.downloadTask);
        if (r10 != (-4)) goto L42;
        return;
    L42:
        if (r12 == true) goto L44;
    L61:
        AbsDownloadEngine r13 = DownloadComponentManager.getDownloadEngine();
        if (r13 == null) goto L68;
        r13.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), r10);
        return;
    L68:
        return;
    L44:
        if (this.mainThreadHandler == null) goto L61;
        Map<Integer, IDownloadListener> r14 = this.mainThreadListeners;
        if (r14 != null) goto L48;
    L49:
        Map<Integer, IDownloadListener> r15 = this.notificationListeners;
        if (r15 == null) goto L61;
        if (r15.size() <= 0) goto L61;
        if (this.downloadInfo.canShowNotification() == false) goto L56;
    L58:
        if (this.fixAnrProcessHandleMsg == false) goto L60;
        notifyDownloadTaskStatus(DownloadComponentManager.getDownloadEngine(), r10, r11);
        return;
    L60:
        this.mainThreadHandler.obtainMessage(r10, this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), r11).sendToTarget();
        return;
    L56:
        if (this.downloadInfo.isAutoInstallWithoutNotification() == false) goto L61;
    L48:
        if (r14.size() > 0) goto L58;
    L34:
        if (this.downloadInfo.getAsyncHandleStatus() != AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING) goto L37;
        this.downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADED);
    L37:
        if (this.downloadInfo.getByteInvalidRetryStatus() != ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) goto L39;
        this.downloadInfo.setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
        goto L39
    L27:
        if (r10 != (-6)) goto L29;
        this.downloadInfo.setStatus(-3);
        goto L30
    L29:
        this.downloadInfo.setStatus(r10);
        goto L30
    L12:
        if (DownloadStatus.isRealTimeUploadStatus(r10) == false) goto L17;
        this.downloadInfo.updateRealDownloadTime(false);
        if (DownloadStatus.isTimeUploadStatus(r10) == false) goto L17;
        this.downloadInfo.updateDownloadTime();
    L17:
        if (this.downloadInfo.isAddListenerToSameTask() == false) goto L21;
        if (this.fixSameTaskMonitorReport == false) goto L24;
    L21:
        if (this.mRemoveUselessReport == false) goto L23;
        if (r10 == 6) goto L24;
    L23:
        DownloadMonitorHelper.monitorSend(this.downloadTask, r11, r10);
        goto L24
    }

    private void notifyDownloadTaskStatus(AbsDownloadEngine r12, final int r13, final BaseException r14) {
        final DownloadTask r8 = r12.getDownloadTask(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask());
        if (r8 != null) goto L6;
        Logger.taskError(TAG, this.downloadInfo.getId(), "notifyDownloadTaskStatus", "DownloadTask is null");
        return;
    L6:
        final DownloadInfo r6 = r8.getDownloadInfo();
        if (r6 != null) goto L10;
        Logger.taskError(TAG, this.downloadInfo.getId(), "notifyDownloadTaskStatus", "DownloadInfo is null");
        return;
    L10:
        final Map<Integer, IDownloadListener> r5 = r8.getDownloadListeners(ListenerType.MAIN);
        final Map<Integer, IDownloadListener> r9 = r8.getDownloadListeners(ListenerType.NOTIFICATION);
        if (r8.canShowNotification() == false) goto L13;
    L16:
        boolean r0 = true;
    L17:
        final boolean r10 = r0;
        this.mainThreadHandler.post(new AnonymousClass1(this, r13, r5, r6, r14, r8, r9, r10));
        r12.refreshDownloadTaskMap(this.downloadInfo.getId(), this.downloadTask.getHashCodeForSameTask(), r13);
        return;
    L13:
        if (r6.isAutoInstallWithoutNotification() == true) goto L16;
        r0 = false;
        goto L17
    }
}

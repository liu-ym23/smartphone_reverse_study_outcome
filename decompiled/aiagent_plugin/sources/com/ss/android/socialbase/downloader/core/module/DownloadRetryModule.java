package com.ss.android.socialbase.downloader.core.module;

import android.util.Log;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadMultiSegmentException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.exception.DownloadPCDNException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.exception.RetryCheckStatus;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadRetryModule extends AbsDownloadModule {
    private static final String TAG = "DownloadRetryModule";
    private DownloadModuleChain mRealDownloadModuleChain;
    private int mRetainRetryTimes;

    static /* synthetic */ void access$000(DownloadRetryModule r2, List r3) {
        r2.handleForbiddenCallback((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void access$100(DownloadRetryModule r0) {
        r0.handleDiskSpaceCallback();
    }

    public DownloadRetryModule(DownloadModuleChain r1) {
        this.mRealDownloadModuleChain = r1;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
        DownloadModuleChain r0 = this.mRealDownloadModuleChain;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
        DownloadModuleChain r0 = this.mRealDownloadModuleChain;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void setThrottleNetSpeed(long r1, int r3) {
        DownloadModuleChain r0 = this.mRealDownloadModuleChain;
        if (r0 == null) goto L6;
        r0.setThrottleNetSpeed(r1, r3);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r6) {
        IDownloadModuleChain r7 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r6, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L5:
        updateRetainRetryTimes();
    L23:
        this.mRealDownloadModuleChain.reset();     // Catch: Throwable -> L8 BaseException -> L14 DownloadFileExistException -> L21
        this.mRealDownloadModuleChain.proceed();     // Catch: Throwable -> L8 BaseException -> L14 DownloadFileExistException -> L21
    L29:
        return;
    L21:
        DownloadCheckFileExistModule.finishWithFileExist(this.mCommonParams);
        return;
    L14:
        e = move-exception;
        Logger.taskError(TAG, this.mDownloadInfo.getId(), "proceed", "BaseException:" + e);
        if (checkTaskFinishByUser() == true) goto L17;
        if (handleException(e) != RetryCheckStatus.RETURN) goto L23;
        return;
    L17:
        return;
    L8:
        th = move-exception;
        Logger.taskError(TAG, this.mDownloadInfo.getId(), "proceed", "Throwable:" + th);
        if (checkTaskFinishByUser() == false) goto L13;
        return;
    L13:
        throw new BaseException(1000, th);
    }

    private void updateRetainRetryTimes() {
        if (this.mDownloadInfo.getRetryCount() > 0) goto L5;
        this.mDownloadInfo.setRetryCount(1);
    L5:
        this.mRetainRetryTimes = this.mDownloadInfo.getRetryCount();
    }

    private RetryCheckStatus handleException(BaseException r2) {
        if (handleSwitchBackupUrl(r2) == false) goto L7;
        return RetryCheckStatus.CONTINUE;
    L7:
        if (handleDownloadExists(r2) == false) goto L11;
        return RetryCheckStatus.RETURN;
    L11:
        if (canRetry(r2) == false) goto L15;
        return onRetry(r2);
    L15:
        throw getTargetException(r2);
    }

    private boolean handleSwitchBackupUrl(BaseException r4) {
        if (r4.getErrorCode() == 1089) goto L7;
        return false;
    L7:
        if (this.mRetainRetryTimes <= 0) goto L11;
        DownloadInfo r5 = this.mDownloadInfo;
        int r0 = this.mRetainRetryTimes - 1;
        this.mRetainRetryTimes = r0;
        r5.updateCurRetryTime(r0);
        this.mDownloadInfo.setStatus(5);
        return true;
    L11:
        if (this.mDownloadInfo.trySwitchToNextBackupUrl() == false) goto L15;
        this.mDownloadInfo.setStatus(5);
        this.mRetainRetryTimes = this.mDownloadInfo.getRetryCount();
        this.mDownloadInfo.updateCurRetryTime(this.mRetainRetryTimes);
        return true;
    L15:
        throw getTargetException(r4);
    }

    private BaseException getTargetException(BaseException r2) {
        Throwable r1 = r2.getCause();
        if (r1 != null) goto L5;
        return r2;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, BaseException.class) == false) goto L9;
        return (BaseException) ZeusTransformUtils.preCheckCast(r1, BaseException.class, "com.obric.aiagent.plugin");
    L9:
        return new BaseException(DownloadErrorCode.ERROR_INNER_RETRY, r1);
    }

    private boolean handleDownloadExists(BaseException r2) {
        if (r2.getErrorCode() != 1025) goto L6;
        DownloadCommonParams r1 = this.mCommonParams;
        r1.mRunStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        return true;
    L6:
        return false;
    }

    private boolean canRetry(BaseException r5) {
        if (DownloadHelper.isInterceptError(r5) == false) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DownloadMultiSegmentException.class) == false) goto L17;
        if (DownloadUtils.isNetworkError(r5) == false) goto L13;
        if (this.mRetainRetryTimes >= this.mDownloadInfo.getRetryCount()) goto L13;
        return false;
    L13:
        if (DownloadHelper.isResponseCodeError(r5) == false) goto L25;
        clearCurrentDownloadData();
        return true;
    L25:
        if (this.mRetainRetryTimes > 0) goto L33;
        if (this.mDownloadInfo.hasNextBackupUrl() == true) goto L33;
        if (DownloadHelper.isHttpsError(r5) == true) goto L31;
        return false;
    L31:
        if (this.mDownloadInfo.canReplaceHttpForRetry() == true) goto L33;
        return false;
    L33:
        if (ZeusTransformUtils.instanceOf(r5, DownloadRetryNeedlessException.class) == false) goto L35;
        return false;
    L35:
        return true;
    L17:
        if (ZeusTransformUtils.instanceOf(r5, DownloadPCDNException.class) == false) goto L22;
        if (DownloadUtils.isNetworkError(r5) == false) goto L25;
        return false;
    L22:
        if (this.mCommonParams.mRetryStrategy.canRetry(r5) == false) goto L25;
        return true;
    }

    private RetryCheckStatus onRetry(BaseException r3) {
        if (DownloadHelper.isHttpDataDirtyError(r3) == false) goto L5;
        clearCurrentDownloadData();
    L5:
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        if (checkTaskFinishByUser() == false) goto L10;
        return RetryCheckStatus.RETURN;
    L10:
        if (r3.getErrorCode() != 1047) goto L16;
        if (onRetryWithForbidden(r3) == RetryCheckStatus.RETURN) goto L14;
    L22:
        this.mStatusHandler.onRetry(r3);
        return RetryCheckStatus.CONTINUE;
    L14:
        return RetryCheckStatus.RETURN;
    L16:
        if (DownloadUtils.isInsufficientSpaceError(r3) == true) goto L18;
        handleRetryTime(r3);
        goto L22
    L18:
        if (onRetryWithInsufficientSpace(r3) != RetryCheckStatus.RETURN) goto L22;
        return RetryCheckStatus.RETURN;
    }

    private RetryCheckStatus onRetryWithForbidden(BaseException r3) {
        IDownloadForbiddenHandler r0 = this.mDownloadTask.getForbiddenHandler();
        if (r0 != null) goto L5;
    L13:
        handleRetryTime(r3);
    L15:
        return RetryCheckStatus.CONTINUE;
    L5:
        if (this.mDownloadInfo.isForbiddenRetryed() == true) goto L13;
        AbsDownloadForbiddenCallback r4 = new AnonymousClass1(this);
        boolean r1 = r0.onForbidden(r4);
        this.mDownloadInfo.setForbiddenRetryed();
        if (r1 == false) goto L15;
        if (r4.hasCallback() == true) goto L15;
        this.mStatusHandler.handleWaitingAsyncHandler();
        DownloadCommonParams r2 = this.mCommonParams;
        r2.mRunStatus = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
        return RetryCheckStatus.RETURN;
    }

    private RetryCheckStatus onRetryWithInsufficientSpace(BaseException r8) {
        IDownloadDiskSpaceHandler r1 = this.mDownloadTask.getDiskSpaceHandler();
        if (r1 == null) goto L31;
        final AtomicBoolean r0 = new AtomicBoolean(false);
        IDownloadDiskSpaceCallback r6 = new AnonymousClass2(this, r0);
        if (ZeusTransformUtils.instanceOf(r8, DownloadOutOfSpaceException.class) == false) goto L7;
        long r2 = ((DownloadOutOfSpaceException) ZeusTransformUtils.preCheckCast(r8, DownloadOutOfSpaceException.class, "com.obric.aiagent.plugin")).getAvaliableSpaceBytes();
        long r4 = ((DownloadOutOfSpaceException) ZeusTransformUtils.preCheckCast(r8, DownloadOutOfSpaceException.class, "com.obric.aiagent.plugin")).getRequiredSpaceBytes();
    L8:
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L10:
        if (r1.cleanUpDisk(r2, r4, r6) == false) goto L23;
        if (r0.get() == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L28
        handleRetryTime(r8);
        return RetryCheckStatus.CONTINUE;
    L14:
        if (this.mCommonParams.mRunStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L16;
        DownloadCommonParams r9 = this.mCommonParams;     // Catch: Throwable -> L28
        r9.mRunStatus = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;     // Catch: Throwable -> L28
        this.mStatusHandler.handleWaitingAsyncHandler();     // Catch: Throwable -> L28
    L16:
        RetryCheckStatus r10 = RetryCheckStatus.RETURN;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return r10;
    L23:
        if (this.mCommonParams.mRunStatus != RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L27;
        RetryCheckStatus r11 = RetryCheckStatus.RETURN;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return r11;
    L27:
        throw r8;     // Catch: Throwable -> L28
    L7:
        r2 = -1;
        r4 = this.mDownloadInfo.getTotalBytes();
        goto L8
    L31:
        throw r8;
    }

    private void handleRetryTime(BaseException r8) {
        if (ZeusTransformUtils.instanceOf(r8, DownloadMultiSegmentException.class) == false) goto L5;
    L10:
        boolean r1 = false;
        if (this.mRetainRetryTimes <= 0) goto L16;
        if (r8.getErrorCode() == 1070) goto L16;
        r1 = true;
    L27:
        if (r1 == false) goto L32;
        DownloadInfo r9 = this.mDownloadInfo;
        int r0 = this.mRetainRetryTimes - 1;
        this.mRetainRetryTimes = r0;
        r9.updateCurRetryTime(r0);
        return;
    L32:
        return;
    L16:
        if (this.mDownloadInfo.trySwitchToNextBackupUrl() == false) goto L19;
        this.mRetainRetryTimes = this.mDownloadInfo.getBackUpUrlRetryCount();
        this.mDownloadInfo.updateCurRetryTime(this.mRetainRetryTimes);
        goto L27
    L19:
        if (r8.getErrorCode() == 1011) goto L25;
        if (r8.getCause() == null) goto L31;
        if (ZeusTransformUtils.instanceOf(r8.getCause(), SSLHandshakeException.class) == true) goto L25;
    L31:
        throw new BaseException(r8.getErrorCode(), String.format(Locale.US, "retry for exception, but current retry time : %s , retry Time %d all used, last error is %s", new Object[]{String.valueOf(this.mRetainRetryTimes), Integer.valueOf(this.mDownloadInfo.getRetryCount()), r8.getErrorMessage()}));
    L25:
        if (this.mDownloadInfo.canReplaceHttpForRetry() == false) goto L31;
        this.mRetainRetryTimes = this.mDownloadInfo.getRetryCount();
        this.mDownloadInfo.updateCurRetryTime(this.mRetainRetryTimes);
        this.mDownloadInfo.setHttpsToHttpRetryUsed(true);
        goto L27
    L5:
        if (ZeusTransformUtils.instanceOf(r8, DownloadPCDNException.class) == true) goto L10;
        this.mCommonParams.mFailoverStrategy.handleError(r8);
        if (this.mCommonParams.mRetryStrategy.canRetry(r8) == false) goto L10;
        this.mCommonParams.mRetryStrategy.doRetry();
        this.mDownloadInfo.setCurNetworkRetryCount(this.mCommonParams.mRetryStrategy.getTotalRetryCount());
    }

    private void handleForbiddenCallback(List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L17;
        DownloadInfo r0 = this.mDownloadInfo;
        if (this.mCommonParams.mRunStatus != RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) goto L10;
        boolean r1 = true;
    L11:
        r0.setForbiddenBackupUrls(r5, r1);
        AbsDownloadEngine r6 = DownloadComponentManager.getDownloadEngine();
        if (r6 == null) goto L16;
        r6.restartAsyncWaitingTask(this.mDownloadInfo.getId());
        return;
    L16:
        return;
    L10:
        r1 = false;
        goto L11
    }

    private void handleDiskSpaceCallback() {
        if (checkTaskFinishByUser() == false) goto L5;
        return;
    L5:
        AbsDownloadEngine r0 = DownloadComponentManager.getDownloadEngine();
        if (r0 == null) goto L9;
        r0.restartAsyncWaitingTask(this.mDownloadInfo.getId());
        return;
    }

    private void clearCurrentDownloadData() {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L10;
        Logger.taskDebug(TAG, this.mDownloadInfo, "clearCurrentDownloadData", "Trace:" + Log.getStackTraceString(new Throwable()));
    L10:
        this.mDownloadCache.removeSegments(this.mDownloadInfo.getId());     // Catch: Throwable -> L7
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);     // Catch: Throwable -> L7
        this.mDownloadInfo.resetDataForEtagEndure("");     // Catch: Throwable -> L7
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}

package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadPrepareModule extends AbsDownloadModule {
    private static final String TAG = "DownloadPrepareModule";

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.core.module.DownloadPrepareModule$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$socialbase$downloader$constants$RunStatus = null;

        static {
            int[] r0 = new int[RunStatus.values().length];
            $SwitchMap$com$ss$android$socialbase$downloader$constants$RunStatus = r0;
            r0[RunStatus.RUN_STATUS_CANCELED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$ss$android$socialbase$downloader$constants$RunStatus[RunStatus.RUN_STATUS_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$ss$android$socialbase$downloader$constants$RunStatus[RunStatus.RUN_STATUS_INTERCEPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$ss$android$socialbase$downloader$constants$RunStatus[RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$ss$android$socialbase$downloader$constants$RunStatus[RunStatus.RUN_STATUS_END_RIGHT_NOW.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$ss$android$socialbase$downloader$constants$RunStatus[RunStatus.RUN_STATUS_END_FOR_FILE_EXIST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$android$socialbase$downloader$constants$RunStatus[RunStatus.RUN_STATUS_COMPLETED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public DownloadPrepareModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r5) {
        IDownloadModuleChain r6 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L6;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L6:
        if (checkTaskFinishByUser() == false) goto L8;
        return;
    L8:
        r6.onDownloadStart();
        this.mStatusHandler.handlePrepare();     // Catch: Throwable -> L11 BaseException -> L14
        r6.proceed();     // Catch: Throwable -> L11 BaseException -> L14
        onDownloadTaskEnd(null);
        return;
    L18:
        th = move-exception;
        onDownloadTaskEnd(null);
        throw th;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        onDownloadTaskEnd(e);
    L21:
        return;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
        onDownloadTaskEnd(new BaseException(1000, th));
        goto L21
    }

    private void onDownloadTaskEnd(BaseException r5) {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L14;
        Logger.taskDebug(TAG, this.mDownloadInfo, "onDownloadTaskEnd", "RunStatus: " + this.mCommonParams.mRunStatus);
    L14:
        this.mCommonParams.mDownloadTask.getTimingInfo().beforeOnEndCallbackTime = System.currentTimeMillis();     // Catch: Throwable -> L8 BaseException -> L10
        DownloadComponentManager.updateCurrentDownloadThreadInfo(this.mCommonParams.mDownloadTask, false);     // Catch: Throwable -> L8 BaseException -> L10
        doTaskStatusHandle(r5);     // Catch: Throwable -> L8 BaseException -> L10
    L12:
        this.mCommonParams.mIsAlive = false;
        return;
    L10:
        e = move-exception;
        this.mStatusHandler.onError(e);
    L8:
        th = move-exception;
        this.mStatusHandler.onError(new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_FINALLY_UNKNOWN, th));
        goto L12
    }

    private void doTaskStatusHandle(BaseException r4) {
        switch(AnonymousClass1.$SwitchMap$com$ss$android$socialbase$downloader$constants$RunStatus[this.mCommonParams.mRunStatus.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L14;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        if (r4 != null) goto L12;
        r4 = new BaseException(DownloadErrorCode.ERROR_RUN_STATUS, "Unknown runStatus:" + this.mCommonParams.mRunStatus);
    L12:
        this.mStatusHandler.onError(r4);
        return;
    L6:
        this.mStatusHandler.onSaveTempFileSuccess();
        RetryScheduler.getInstance().scheduleRetryWhenHasTaskSucceed();
        return;
    L7:
        this.mStatusHandler.onCompleteForFileExist(this.mCommonParams.mExistTargetFilePath, this.mCommonParams.mExistTargetFileName);
        return;
    L8:
        this.mStatusHandler.onCompleteForFileExist();
        return;
    L9:
        this.mStatusHandler.onIntercept();
        return;
    L10:
        this.mStatusHandler.onPause();
        return;
    L11:
        this.mStatusHandler.onCancel();
        return;
    }
}

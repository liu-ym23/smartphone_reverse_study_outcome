package com.ss.android.socialbase.downloader.core.module.multi;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadMimeTypeInterceptModule;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadMultiSegmentException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.segment.SegmentDispatcher;
import com.ss.android.socialbase.downloader.segment.SegmentStrategy;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadMultiSegmentModule extends BaseDownloadNetworkModule {
    private static final String TAG = "DownloadMultiSegmentModule";
    private SegmentDispatcher mSegmentDispatcher;

    public DownloadMultiSegmentModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r5) {
        IDownloadModuleChain r6 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L6;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L6:
        if (hasRunNetworkProceed(r6, false) == false) goto L8;
        return;
    L8:
        if (checkTaskFinishByUser() == true) goto L13;
        doDownload();
        r6.proceed();
        return;
    }

    private void doDownload() {
        if (this.mDownloadInfo.isExpiredRedownload() == false) goto L6;
        return;
    L6:
        if (this.mDownloadInfo.getChunkCount() == 1) goto L8;
        return;
    L8:
        if (this.mDownloadInfo.getThrottleNetSpeed() <= 0) goto L11;
        return;
    L11:
        if (this.mCommonParams.mEnableSegmentDownload == true) goto L13;
        return;
    L13:
        JSONObject r0 = this.mSetting.optJSONObject(DownloadSettingKeys.SEGMENT_CONFIG);
        List<Segment> r2 = this.mDownloadCache.getSegments(this.mDownloadInfo.getId());
        if (this.mDownloadInfo.getCurBytes() <= 0) goto L22;
        if (r2 != null) goto L17;
        return;
    L17:
        if (r2.isEmpty() == true) goto L46;
        if (r0 != null) goto L22;
        r0 = new JSONObject();
        goto L22
    L46:
        return;
    L22:
        if (r0 != null) goto L24;
        return;
    L24:
        SegmentStrategy r1 = SegmentStrategy.from(r0);
        this.mSegmentDispatcher = new SegmentDispatcher(this.mDownloadTask, this.mDownloadInfo, r1, this);
        if (checkTaskFinishByUser() == true) goto L27;
        this.mCommonParams.mHasRunNetworkModule = true;
        this.mSegmentDispatcher.downloadSegments(r2);     // Catch: Throwable -> L37 BaseException -> L40
        return;
    L40:
        e = move-exception;
        throw new DownloadMultiSegmentException(e.getErrorCode(), e.getErrorMessage());
    L37:
        th = move-exception;
        throw new DownloadMultiSegmentException(1000, th.getMessage());
    L27:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L30;
        Logger.taskDebug(TAG, this.mDownloadInfo, "downloadSegments", "Stopped by user");
    L30:
        if (this.mCommonParams.mRunStatus != RunStatus.RUN_STATUS_CANCELED) goto L32;
        this.mSegmentDispatcher.cancel();
        return;
    L32:
        this.mSegmentDispatcher.pause();
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void handleFirstConnection(String r17, IDownloadHeadHttpConnection r18, long r19) {
        IDownloadHeadHttpConnection r9 = (IDownloadHeadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r18, IDownloadHeadHttpConnection.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L112;
        return;
    L112:
        HttpResponse r10 = new HttpResponse(r17, r9);     // Catch: Throwable -> L107 BaseException -> L110
        int r11 = r10.responseCode;     // Catch: Throwable -> L107 BaseException -> L110
        String r1 = r10.getContentType();     // Catch: Throwable -> L107 BaseException -> L110
        if (TextUtils.isEmpty(this.mDownloadInfo.getMimeType()) == true) goto L8;
    L10:
        boolean r12 = r10.acceptPartial();     // Catch: Throwable -> L107 BaseException -> L110
        this.mDownloadInfo.setSupportPartial(r12);     // Catch: Throwable -> L107 BaseException -> L110
        boolean r13 = r10.isResponseDataFromBegin();     // Catch: Throwable -> L107 BaseException -> L110
        String r14 = this.mDownloadInfo.geteTag();     // Catch: Throwable -> L107 BaseException -> L110
        String r15 = r10.getEtag();     // Catch: Throwable -> L107 BaseException -> L110
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L15;
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleFirstConnection", "ResponseCode=" + r11 + " isDeleteCacheIfCheckFailed=" + this.mDownloadInfo.isDeleteCacheIfCheckFailed());     // Catch: Throwable -> L107 BaseException -> L110
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleFirstConnection", "firstOffset=" + r19 + " cur=" + r10.getTotalLength() + " before=" + this.mDownloadInfo.getTotalBytes());     // Catch: Throwable -> L107 BaseException -> L110
    L15:
        if (ZeusTransformUtils.instanceOf(r9, AbsDownloadHttpConnection.class) == false) goto L21;
        String r2 = ((AbsDownloadHttpConnection) ZeusTransformUtils.preCheckCast(r9, AbsDownloadHttpConnection.class, "com.obric.aiagent.plugin")).getRedirectPartialUrlResults();     // Catch: Throwable -> L107 BaseException -> L110
        if (TextUtils.isEmpty(r2) == true) goto L21;
        this.mDownloadInfo.setRedirectPartialUrlResults(r2);     // Catch: Throwable -> L107 BaseException -> L110
    L21:
        if (isResponseCodeError(r11, r14, r15, r13, r12) == false) goto L29;
        if (TextUtils.isEmpty(r14) == false) goto L25;
    L27:
        handleResponseCodeError(r15, "eTag of server file changed");     // Catch: Throwable -> L107 BaseException -> L110
        goto L29
    L25:
        if (r14.equals(r15) == false) goto L27;
        r15 = "";
    L29:
        if (r12 == true) goto L47;
        if (r13 == true) goto L47;
        if (r11 == 403) goto L46;
        if (this.mDownloadInfo.getStartOffset() < 0) goto L44;
        if (this.mDownloadInfo.getEndOffset() < 0) goto L42;
        if (this.mDownloadInfo.getStartOffset() > this.mDownloadInfo.getEndOffset()) goto L44;
    L42:
        throw new DownloadHttpException(1004, r11, "response code error : " + r11);     // Catch: Throwable -> L107 BaseException -> L110
    L44:
        throw new BaseException(DownloadErrorCode.ERROR_START_END_OFFSET, "startOffset = " + this.mDownloadInfo.getStartOffset() + ", endOffset = " + this.mDownloadInfo.getEndOffset() + ", response code error : " + r11);     // Catch: Throwable -> L107 BaseException -> L110
    L46:
        throw new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_FORBIDDEN, "response code error : 403");     // Catch: Throwable -> L107 BaseException -> L110
    L47:
        if (r13 == true) goto L49;
    L51:
        long r16 = r10.getContentLength();     // Catch: Throwable -> L107 BaseException -> L110
        if (r10.isChunked() == true) goto L64;
        String r20 = DownloadUtils.getRespHeadFieldIgnoreCase(r9, DownloadUtils.CONTENT_RANGE);     // Catch: Throwable -> L107 BaseException -> L110
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L57;
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleFirstConnection", "ContentRange:" + r20);     // Catch: Throwable -> L107 BaseException -> L110
    L57:
        if (TextUtils.isEmpty(r20) == true) goto L61;
        long r21 = DownloadHelper.parseContentRangeOfInstanceLength(r20);     // Catch: Throwable -> L107 BaseException -> L110
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L66;
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleFirstConnection", "TotalLength:" + r21);     // Catch: Throwable -> L107 BaseException -> L110
    L66:
        if (this.mDownloadInfo.getStartOffset() > 0) goto L70;
        if (this.mDownloadInfo.getEndOffset() >= 0) goto L70;
    L82:
        if (TextUtils.isEmpty(this.mDownloadInfo.getTaskKey()) == true) goto L89;
        if (this.mDownloadInfo.getTotalBytes() <= 0) goto L89;
        if (r21 == this.mDownloadInfo.getTotalBytes()) goto L89;
        handleResponseCodeError("", "file totalLength changed");     // Catch: Throwable -> L107 BaseException -> L110
    L89:
        if (checkTaskFinishByUser() == false) goto L92;
        return;
    L92:
        if (this.mDownloadInfo.getExpectFileLength() <= 0) goto L101;
        if (this.mSetting.optInt(DownloadSettingKeys.FORCE_CHECK_FILE_LENGTH) != 1) goto L101;
        if (this.mDownloadInfo.getExpectFileLength() == r21) goto L101;
        throw new BaseException(DownloadErrorCode.ERROR_CHECK_FILE_LENGTH_FAILED, "expectFileLength = " + this.mDownloadInfo.getExpectFileLength() + " , totalLength = " + r21);     // Catch: Throwable -> L107 BaseException -> L110
    L101:
        if (DownloadMimeTypeInterceptModule.checkGlobalIntercept(this.mDownloadInfo) == true) goto L104;
        this.mStatusHandler.onFirstConnectionSuccessed(r21, r15, this.mDownloadInfo.getName());     // Catch: Throwable -> L107 BaseException -> L110
        return;
    L104:
        throw new BaseException(DownloadErrorCode.ERROR_BIZ_INTERCEPTOR, "download global intercept");     // Catch: Throwable -> L107 BaseException -> L110
    L70:
        if (this.mDownloadInfo.getStartOffset() < 0) goto L106;
        if (this.mDownloadInfo.getEndOffset() >= r21) goto L106;
        if (this.mDownloadInfo.getEndOffset() < 0) goto L78;
        if (this.mDownloadInfo.getStartOffset() > this.mDownloadInfo.getEndOffset()) goto L106;
    L78:
        if (this.mDownloadInfo.getEndOffset() >= 0) goto L80;
        r21 = r21 - this.mDownloadInfo.getStartOffset();     // Catch: Throwable -> L107 BaseException -> L110
        goto L82
    L80:
        r21 = (this.mDownloadInfo.getEndOffset() - this.mDownloadInfo.getStartOffset()) + 1;     // Catch: Throwable -> L107 BaseException -> L110
    L106:
        throw new BaseException(DownloadErrorCode.ERROR_START_END_OFFSET, "startOffset = " + this.mDownloadInfo.getStartOffset() + ", endOffset = " + this.mDownloadInfo.getEndOffset() + ", totalLength = " + r21);     // Catch: Throwable -> L107 BaseException -> L110
    L61:
        r21 = r19 + r16;     // Catch: Throwable -> L107 BaseException -> L110
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L66;
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleFirstConnection", "TotalLength2:" + r21);     // Catch: Throwable -> L107 BaseException -> L110
        goto L66
    L64:
        this.mDownloadInfo.setXTotalBytes(r10.getXContentLength());     // Catch: Throwable -> L107 BaseException -> L110
        r21 = -1;
        goto L66
    L49:
        if (r19 <= 0) goto L51;
        handleResponseCodeError("", "isResponseFromBegin but firstOffset > 0");     // Catch: Throwable -> L107 BaseException -> L110
        goto L51
    L8:
        if (TextUtils.isEmpty(r1) == true) goto L10;
        this.mDownloadInfo.setMimeType(r1);     // Catch: Throwable -> L107 BaseException -> L110
    L110:
        e = move-exception;
        throw e;
    L107:
        th = move-exception;
        DownloadHelper.parseException(th, "HandleFirstConnection");
    }

    private void handleResponseCodeError(String r3, String r4) {
        this.mDownloadCache.removeSegments(this.mDownloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        this.mDownloadInfo.resetDataForEtagEndure(r3);
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
        throw new BaseException(DownloadErrorCode.ERROR_INNER_RETRY, r4);
    }

    private boolean isResponseCodeError(int r3, String r4, String r5, boolean r6, boolean r7) {
        if (r3 != 412) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L15;
        if (TextUtils.isEmpty(r5) == true) goto L15;
        if (r4.equals(r5) == true) goto L15;
        if (r6 == true) goto L13;
        if (r7 == false) goto L15;
    L13:
        return true;
    L15:
        if (r3 == 201) goto L19;
        if (r3 == 416) goto L19;
    L21:
        return false;
    L19:
        if (this.mDownloadInfo.getCurBytes() <= 0) goto L21;
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
        SegmentDispatcher r0 = this.mSegmentDispatcher;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
        SegmentDispatcher r0 = this.mSegmentDispatcher;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }
}

package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import android.util.Pair;
import com.obric.capabilitykit.entity.ResultCode;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadHttpUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class BaseDownloadNetworkModule extends AbsDownloadModule implements IDownloadRunnableCallback {
    private static final String TAG = "AbsDownloadNetworkModule";

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void handleFirstConnection(String r1, IDownloadHeadHttpConnection r2, long r3) {
        IDownloadHeadHttpConnection r0 = (IDownloadHeadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadHeadHttpConnection.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r2) {
        IDownloadModuleChain r1 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
    }

    public BaseDownloadNetworkModule() {
    }

    public boolean hasRunNetworkProceed(IDownloadModuleChain r3, boolean r4) {
        IDownloadModuleChain r5 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (this.mCommonParams.mHasRunNetworkModule == false) goto L6;
        r5.proceed();
        return true;
    L6:
        this.mCommonParams.mHasRunNetworkModule = r4;
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public boolean onProgress(long r1) {
        return this.mStatusHandler.onProgress(r1);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onReceiveData(byte[] r1, int r2) {
        this.mStatusHandler.onReceiveData(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onReceiveHeader(List<Pair<String, String>> r3) {
        List<Pair<String, String>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.mStatusHandler.onReceiveHeader(r4);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onReceiveRequestLog(String r1) {
        this.mStatusHandler.onReceiveRequestLog(r1);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void checkMaxBytes(long r4, int r6) {
        if (r4 <= 0) goto L10;
        if (r6 > 0) goto L6;
        return;
    L6:
        if (r4 > r6) goto L9;
        return;
    L9:
        throw new BaseException(DownloadErrorCode.ERROR_MAX_BYTE_LIMIT, "Current Bytes:" + r4 + "Limit bytes:" + r6);
    }

    public List<HttpHeader> buildRequestHeader(long r16, long r18, boolean r20) {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "buildRequestHeader", "CurrentOffset: endOffset:" + r18 + " handleBody:" + r20);
    L5:
        List<HttpHeader> r4 = this.mDownloadInfo.getExtraHeaders();
        ArrayList r5 = new ArrayList();
        String r6 = DownloadHelper.GZIP;
        boolean r9 = false;
        if (r4 != null) goto L8;
    L21:
        boolean r11 = false;
    L22:
        String r10 = this.mDownloadInfo.geteTag();
        if (this.mCommonParams.mNeedCheckIfModified == false) goto L31;
        if (TextUtils.isEmpty(r10) == true) goto L28;
        r5.add(new HttpHeader(DownloadHelper.IF_NONE_MATCH, r10));
    L28:
        if (TextUtils.isEmpty(this.mDownloadInfo.getLastModified()) == true) goto L33;
        r5.add(new HttpHeader(DownloadHelper.IF_MODIFIED_SINCE, this.mDownloadInfo.getLastModified()));
        r5.add(new HttpHeader(DownloadUtils.HEADER_TAG_DOWNLOAD_CACHE, DownloadUtils.HEADER_TAG_DOWNLOAD_CACHE));
    L33:
        String r12 = null;
        if (r18 <= 0) goto L37;
        r12 = String.format(Locale.US, "bytes=%d-%d", new Object[]{Long.valueOf(r16), Long.valueOf(r18)});
    L41:
        if (r12 == null) goto L43;
        r5.add(new HttpHeader("Range", r12));
    L45:
        if (r9 == true) goto L48;
        r6 = DownloadHelper.IDENTITY;
    L48:
        r5.add(new HttpHeader(DownloadHelper.ACCEPT_ENCODING, r6));
        r5.add(new HttpHeader("extra_download_id", String.valueOf(this.mDownloadInfo.getId())));
        DownloadHelper.addTTNetParam(this.mSetting, r5, this.mDownloadInfo);
        this.mCommonParams.mFailoverStrategy.handleHeader(r4);
        return r5;
    L43:
        r9 = r11;
        goto L45
    L37:
        if (r16 <= 0) goto L39;
        r12 = String.format(Locale.US, "bytes=%d-", new Object[]{Long.valueOf(r16)});
        goto L41
    L39:
        if (r20 == true) goto L41;
        r12 = "bytes=0-0";
        goto L41
    L31:
        if (TextUtils.isEmpty(r10) == true) goto L33;
        r5.add(new HttpHeader(DownloadHelper.IF_MATCH, r10));
        goto L33
    L8:
        if (r4.size() <= 0) goto L21;
        Iterator<HttpHeader> r13 = r4.iterator();
        r11 = false;
    L11:
        if (r13.hasNext() == false) goto L22;
        HttpHeader r14 = (HttpHeader) ZeusTransformUtils.preCheckCast(r13.next(), HttpHeader.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L11;
        if (DownloadHelper.ACCEPT_ENCODING.equalsIgnoreCase(r14.getName()) == false) goto L20;
        if (DownloadHelper.GZIP.equalsIgnoreCase(r14.getValue()) == false) goto L20;
        r11 = true;
    L20:
        r5.add(r14);
        goto L11
    }

    public IDownloadHttpConnection sendRequest(String r17, List<HttpHeader> r18, long r19) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        long r12 = System.currentTimeMillis();
        IDownloadHttpConnection r2 = DownloadComponentManager.downloadWithConnection(this.mDownloadInfo.isNeedDefaultHttpServiceBackUp(), this.mDownloadInfo.getMaxBytes(), r17, null, r6, this.mSetting.optInt(DownloadSettingKeys.NET_LIB_STRATEGY), false, this.mDownloadInfo);     // Catch: Throwable -> L11
        if (r2 == null) goto L10;
        int r0 = r2.getResponseCode();     // Catch: Throwable -> L7
        setHttpResponseStatus(r2, r0);
        DownloadMonitorHelper.monitorDownloadCDN(r17, r2, null, this.mDownloadTask.getCdnListener());
        IDownloadHttpConnection r3 = r2;
        Throwable r4 = null;
    L72:
        if (r0 != 304) goto L28;
        if (this.mDownloadInfo.isDownloaded() == true) goto L21;
        handleResponseCodeError("Status 304 file not found", null);     // Catch: Throwable -> L25
    L21:
        if (System.currentTimeMillis() <= this.mDownloadInfo.getCacheExpiredTime()) goto L24;
        setMaxAge(new HttpResponse(r17, r3, ResultCode.ERROR_MULTI_DETAIL));     // Catch: Throwable -> L25
    L24:
        throw new DownloadFileExistException();     // Catch: Throwable -> L25
    L28:
        if (r0 == 403) goto L60;
        if (r0 <= 0) goto L32;
        if (r0 >= 200) goto L32;
    L33:
        if (r4 == null) goto L35;
        DownloadTTNetException r7 = DownloadHelper.getTTNetException(r4, "sendRequest");     // Catch: Throwable -> L25
    L36:
        if (r7 != null) goto L38;
        r7 = new DownloadTTNetException(r0 + DownloadErrorCode.ERROR_CRONET_ERROR_BASE, "Status Error");     // Catch: Throwable -> L25
    L38:
        handleResponseCodeError("Http Status Error: " + r0, r7);     // Catch: Throwable -> L25
    L40:
        if (this.mCommonParams.mNeedCheckIfModified == false) goto L50;
        if (r0 < 200) goto L46;
        if (r0 >= 300) goto L46;
        resetDownloadInfo();     // Catch: Throwable -> L25
        return r3;
    L46:
        if (DownloadUtils.isFileDownloaded(this.mDownloadInfo, false, null) == true) goto L49;
        handleResponseCodeError("CheckIfModified file not found", null);     // Catch: Throwable -> L25
    L49:
        throw new DownloadFileExistException();     // Catch: Throwable -> L25
    L50:
        if (r4 == null) goto L53;
        DownloadHelper.parseException(r4, "DoConnect");     // Catch: Throwable -> L25
    L53:
        if (r0 != 206) goto L55;
    L57:
        this.mDownloadInfo.increaseAllConnectTime(System.currentTimeMillis() - r12);     // Catch: Throwable -> L25
        return r3;
    L55:
        if (r19 <= 0) goto L57;
        handleResponseCodeError("Http range not support", null);     // Catch: Throwable -> L25
        goto L57
    L35:
        r7 = null;
    L32:
        if (r0 < 300) goto L40;
    L60:
        throw new BaseException(DownloadErrorCode.ERROR_DOWNLOAD_FORBIDDEN, "Status Error:403", r4);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        if (r3 == null) goto L63;
        r3.end();
    L63:
        throw th;
    L10:
        throw new BaseException(DownloadErrorCode.ERROR_NO_CONNECTION, new IOException("Connection is null"));     // Catch: Throwable -> L7
    L7:
        th = th;
    L70:
        int r5 = ((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getTTNetHandler().getResponseCode(th);     // Catch: Throwable -> L64
        setHttpResponseStatus(r2, r5);
        DownloadMonitorHelper.monitorDownloadCDN(r17, r2, th, this.mDownloadTask.getCdnListener());
        IDownloadHttpConnection r15 = r2;
        r4 = th;
        r0 = r5;
        r3 = r15;
    L64:
        th = move-exception;
        setHttpResponseStatus(r2, -1);
        DownloadMonitorHelper.monitorDownloadCDN(r17, r2, null, this.mDownloadTask.getCdnListener());
        throw th;
    L11:
        th = th;
        r2 = null;
        goto L70
    }

    public void handleResponseHeader(String r16, long r17, IDownloadHttpConnection r19) {
        IDownloadHttpConnection r4 = (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r19, IDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        HttpResponse r6 = new HttpResponse(r16, r4);     // Catch: Throwable -> L82 BaseException -> L85
        int r7 = r6.responseCode;     // Catch: Throwable -> L82 BaseException -> L85
        String r8 = r6.getContentType();     // Catch: Throwable -> L82 BaseException -> L85
        if (TextUtils.isEmpty(this.mDownloadInfo.getMimeType()) == true) goto L6;
    L8:
        this.mDownloadInfo.setSupportPartial(r6.acceptPartial());     // Catch: Throwable -> L82 BaseException -> L85
        String r9 = r6.getEtag();     // Catch: Throwable -> L82 BaseException -> L85
        if (TextUtils.isEmpty(r9) == true) goto L11;
        this.mDownloadInfo.seteTag(r9);     // Catch: Throwable -> L82 BaseException -> L85
    L11:
        String r10 = r6.getLastModified();     // Catch: Throwable -> L82 BaseException -> L85
        if (TextUtils.isEmpty(r10) == true) goto L14;
        this.mDownloadInfo.setLastModified(r10);     // Catch: Throwable -> L82 BaseException -> L85
    L14:
        this.mDownloadInfo.setContentEncoding(r6.getContentEncoding());     // Catch: Throwable -> L82 BaseException -> L85
        if (DownloadHelper.GZIP.equalsIgnoreCase(this.mDownloadInfo.getContentEncoding()) == false) goto L17;
        this.mDownloadInfo.setIgnoreDataVerify(true);     // Catch: Throwable -> L82 BaseException -> L85
    L17:
        setMaxAge(r6);     // Catch: Throwable -> L82 BaseException -> L85
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L22;
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", "ResponseCode=" + r7 + " last_modified=" + r10 + " CACHE_CONTROL=" + r6.getCacheControl() + " max-age=" + r6.getMaxAge() + " isDeleteCacheIfCheckFailed=" + this.mDownloadInfo.isDeleteCacheIfCheckFailed());     // Catch: Throwable -> L82 BaseException -> L85
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", " cur=" + r10 + " before=" + this.mDownloadInfo.getLastModified() + " cur=" + r6.getTotalLength() + " before=" + this.mDownloadInfo.getTotalBytes());     // Catch: Throwable -> L82 BaseException -> L85
    L22:
        if (ZeusTransformUtils.instanceOf(r4, AbsDownloadHttpConnection.class) == false) goto L27;
        String r1 = ((AbsDownloadHttpConnection) ZeusTransformUtils.preCheckCast(r4, AbsDownloadHttpConnection.class, "com.obric.aiagent.plugin")).getRedirectPartialUrlResults();     // Catch: Throwable -> L82 BaseException -> L85
        if (TextUtils.isEmpty(r1) == true) goto L27;
        this.mDownloadInfo.setRedirectPartialUrlResults(r1);     // Catch: Throwable -> L82 BaseException -> L85
    L27:
        if (r6.isChunked() == true) goto L39;
        String r2 = r6.getContentRange();     // Catch: Throwable -> L82 BaseException -> L85
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L32;
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", "ContentRange:" + r2);     // Catch: Throwable -> L82 BaseException -> L85
    L32:
        if (TextUtils.isEmpty(r2) == true) goto L36;
        long r3 = DownloadHelper.parseContentRangeOfInstanceLength(r2);     // Catch: Throwable -> L82 BaseException -> L85
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L41;
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", "TotalLength:" + r3);     // Catch: Throwable -> L82 BaseException -> L85
    L41:
        if (this.mDownloadInfo.getStartOffset() > 0) goto L45;
        if (this.mDownloadInfo.getEndOffset() >= 0) goto L45;
    L57:
        if (TextUtils.isEmpty(this.mDownloadInfo.getTaskKey()) == true) goto L64;
        if (this.mDownloadInfo.getTotalBytes() <= 0) goto L64;
        if (r3 == this.mDownloadInfo.getTotalBytes()) goto L64;
        handleResponseCodeError("file totalLength changed", null);     // Catch: Throwable -> L82 BaseException -> L85
    L64:
        if (checkTaskFinishByUser() == false) goto L67;
        return;
    L67:
        if (this.mDownloadInfo.getExpectFileLength() <= 0) goto L76;
        if (this.mSetting.optInt(DownloadSettingKeys.FORCE_CHECK_FILE_LENGTH) != 1) goto L76;
        if (this.mDownloadInfo.getExpectFileLength() == r3) goto L76;
        throw new BaseException(DownloadErrorCode.ERROR_CHECK_FILE_LENGTH_FAILED, "expectFileLength = " + this.mDownloadInfo.getExpectFileLength() + " , totalLength = " + r3);     // Catch: Throwable -> L82 BaseException -> L85
    L76:
        if (DownloadMimeTypeInterceptModule.checkGlobalIntercept(this.mDownloadInfo) == true) goto L79;
        this.mStatusHandler.onFirstConnectionSuccessed(r3, r9, this.mDownloadInfo.getName());     // Catch: Throwable -> L82 BaseException -> L85
        return;
    L79:
        throw new BaseException(DownloadErrorCode.ERROR_BIZ_INTERCEPTOR, "download global intercept");     // Catch: Throwable -> L82 BaseException -> L85
    L45:
        if (this.mDownloadInfo.getStartOffset() < 0) goto L81;
        if (this.mDownloadInfo.getEndOffset() >= r3) goto L81;
        if (this.mDownloadInfo.getEndOffset() < 0) goto L53;
        if (this.mDownloadInfo.getStartOffset() > this.mDownloadInfo.getEndOffset()) goto L81;
    L53:
        if (this.mDownloadInfo.getEndOffset() >= 0) goto L55;
        r3 = r3 - this.mDownloadInfo.getStartOffset();     // Catch: Throwable -> L82 BaseException -> L85
        goto L57
    L55:
        r3 = (this.mDownloadInfo.getEndOffset() - this.mDownloadInfo.getStartOffset()) + 1;     // Catch: Throwable -> L82 BaseException -> L85
    L81:
        throw new BaseException(DownloadErrorCode.ERROR_START_END_OFFSET, "startOffset = " + this.mDownloadInfo.getStartOffset() + ", endOffset = " + this.mDownloadInfo.getEndOffset() + ", totalLength = " + r3);     // Catch: Throwable -> L82 BaseException -> L85
    L36:
        r3 = r17 + r6.getContentLength();     // Catch: Throwable -> L82 BaseException -> L85
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L41;
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", "TotalLength2:" + r3);     // Catch: Throwable -> L82 BaseException -> L85
        goto L41
    L39:
        r3 = -1;
        this.mDownloadInfo.setXTotalBytes(r6.getXContentLength());     // Catch: Throwable -> L82 BaseException -> L85
        goto L41
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L8;
        this.mDownloadInfo.setMimeType(r8);     // Catch: Throwable -> L82 BaseException -> L85
    L85:
        e = move-exception;
        throw e;
    L82:
        th = move-exception;
        DownloadHelper.parseException(th, "handleResponseHeader");
    }

    public void closeConnection(IDownloadHttpConnection r3) {
        final IDownloadHttpConnection r4 = (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        DownloadComponentManager.submitIOTask(new AnonymousClass1(this, r4), true);
    }

    private void setMaxAge(HttpResponse r7) {
        if (TextUtils.isEmpty(r7.getCacheControl()) == false) goto L6;
        return;
    L6:
        if (r7.getMaxAge() <= 0) goto L9;
        this.mDownloadInfo.setCacheExpiredTime(System.currentTimeMillis() + (r7.getMaxAge() * 1000));
        return;
    }

    public void handleResponseCodeError(String r2, Throwable r3) {
        resetDownloadInfo();
        throw new BaseException(DownloadErrorCode.ERROR_INNER_RETRY, r2, r3);
    }

    private void resetDownloadInfo() {
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        this.mCommonParams.mNeedCheckIfModified = false;
        this.mDownloadInfo.resetDataForEtagEndure("");
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
    }

    private void setHttpResponseStatus(IDownloadHttpConnection r7, int r8) {
        IDownloadHttpConnection r9 = (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r7, IDownloadHttpConnection.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L33;
        this.mDownloadInfo.setHttpStatusCode(-1);
        this.mDownloadInfo.setHttpStatusMessage("");
        return;
    L33:
        this.mDownloadInfo.setHttpStatusCode(r8);     // Catch: Throwable -> L24
        this.mDownloadInfo.setHttpStatusMessage(DownloadHttpUtils.httpCodeToMessage(r8));     // Catch: Throwable -> L24
        List<String> r10 = this.mDownloadInfo.getAccessHttpHeaderKeys();     // Catch: Throwable -> L24
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.isEmpty() == true) goto L45;
        HashMap r3 = new HashMap();     // Catch: Throwable -> L24
        Iterator<String> r11 = r10.iterator();     // Catch: Throwable -> L24
    L12:
        if (r11.hasNext() == false) goto L21;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r4 == null) goto L12;
        String r5 = r9.getResponseHeaderField(r4);     // Catch: Throwable -> L24
        if (r5 == null) goto L12;
        r3.put(r4, r5);     // Catch: Throwable -> L24
        goto L12
    L21:
        if (r3.isEmpty() == true) goto L46;
        this.mDownloadInfo.setHttpHeaders(r3);     // Catch: Throwable -> L24
        return;
    L46:
        return;
    L45:
        return;
    L24:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        this.mDownloadInfo.setHttpStatusCode(-1);
        this.mDownloadInfo.setHttpStatusMessage("");
        return;
    L28:
        th = move-exception;
        this.mDownloadInfo.setHttpStatusCode(-1);
        this.mDownloadInfo.setHttpStatusMessage("");
        throw th;
    }
}

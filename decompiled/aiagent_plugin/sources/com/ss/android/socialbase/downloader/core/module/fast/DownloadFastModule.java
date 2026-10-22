package com.ss.android.socialbase.downloader.core.module.fast;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadFastModule extends BaseDownloadNetworkModule {
    private static final String TAG = "DownloadFastModule";
    private DownloadSingleResponseHandler mDownloadResponseHandler;
    private IDownloadHttpConnection mHttpConnection;

    public DownloadFastModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r4) {
        if (r4.mDownloadInfo.isFastDownload() == true) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r4.mDownloadCache, DefaultDownloadCache.class) == false) goto L10;
        r4.mDownloadCache = ((DefaultDownloadCache) ZeusTransformUtils.preCheckCast(r4.mDownloadCache, DefaultDownloadCache.class, "com.obric.aiagent.plugin")).getDownloadCache();
    L10:
        return super.init(r4);
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r5) {
        IDownloadModuleChain r6 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L6;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L6:
        if (hasRunNetworkProceed(r6, true) == false) goto L8;
        return;
    L8:
        if (checkTaskFinishByUser() == false) goto L10;
        return;
    L10:
        if (checkFileExists() == true) goto L22;
        doDownload();     // Catch: Throwable -> L15
        closeConnection(this.mHttpConnection);
        r6.proceed();
        return;
    L15:
        th = move-exception;
        closeConnection(this.mHttpConnection);
        throw th;
    }

    private boolean checkFileExists() {
        if (new DownloadFile(this.mDownloadInfo.getSavePath(), this.mDownloadInfo.getName()).exists() == false) goto L6;
        DownloadCommonParams r0 = this.mCommonParams;
        r0.mRunStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        this.mCommonParams.mDownloadInfo.setCacheExistsInDownloading(true);
        return true;
    L6:
        return false;
    }

    private void doDownload() {
        String r0 = this.mDownloadInfo.getConnectionUrl();
        IDownloadHttpConnection r1 = sendRequest(r0, buildRequestHeader());
        this.mHttpConnection = r1;
        handleResponseHeader(r0, r1);
        if (checkTaskFinishByUser() == false) goto L5;
        return;
    L5:
        DownloadSingleResponseHandler r2 = new DownloadSingleResponseHandler(this.mCommonParams, this.mHttpConnection, 0, this.mDownloadInfo.getTotalBytes(), this);
        this.mDownloadResponseHandler = r2;
        r2.handleResponse();
    }

    public List<HttpHeader> buildRequestHeader() {
        List<HttpHeader> r0 = this.mDownloadInfo.getExtraHeaders();
        ArrayList r1 = new ArrayList();
        String r2 = DownloadHelper.GZIP;
        if (r0 == null) goto L16;
        Iterator<HttpHeader> r3 = r0.iterator();
        boolean r5 = false;
    L6:
        if (r3.hasNext() == false) goto L18;
        HttpHeader r6 = (HttpHeader) ZeusTransformUtils.preCheckCast(r3.next(), HttpHeader.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L6;
        if (DownloadHelper.ACCEPT_ENCODING.equalsIgnoreCase(r6.getName()) == false) goto L15;
        if (DownloadHelper.GZIP.equalsIgnoreCase(r6.getValue()) == false) goto L15;
        r5 = true;
    L15:
        r1.add(r6);
    L18:
        if (r5 == true) goto L21;
        r2 = DownloadHelper.IDENTITY;
    L21:
        r1.add(new HttpHeader(DownloadHelper.ACCEPT_ENCODING, r2));
        int r9 = this.mSetting.optInt(DownloadSettingKeys.TTNET_ERROR_PROTO_TYPE, 0);
        if (r9 <= 0) goto L24;
        r1.add(new HttpHeader(DownloadHelper.TTNET_PROTO_TYPE, String.valueOf(r9)));
    L24:
        return r1;
    L16:
        r5 = false;
        goto L18
    }

    public IDownloadHttpConnection sendRequest(String r12, List<HttpHeader> r13) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        DownloadTTNetException r14 = null;
        IDownloadHttpConnection r15 = DownloadComponentManager.downloadWithConnection(this.mDownloadInfo.isNeedDefaultHttpServiceBackUp(), this.mDownloadInfo.getMaxBytes(), r12, null, r6, this.mSetting.optInt(DownloadSettingKeys.NET_LIB_STRATEGY), false, this.mDownloadInfo);     // Catch: Throwable -> L10
        if (r15 == null) goto L9;
        int r0 = r15.getResponseCode();     // Catch: Throwable -> L6
        Throwable r1 = null;
    L13:
        if (r0 <= 0) goto L17;
        if (r0 >= 200) goto L17;
    L18:
        if (r1 != null) goto L32;
    L22:
        if (r14 != null) goto L24;
        r14 = new DownloadTTNetException(r0 + DownloadErrorCode.ERROR_CRONET_ERROR_BASE, "Status Error");     // Catch: Throwable -> L20
    L24:
        handleResponseCodeError("Http Status Error: " + r0, r14);     // Catch: Throwable -> L20
    L25:
        if (r1 == null) goto L31;
        DownloadHelper.parseException(r1, "DoConnect");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r15 == null) goto L30;
        r15.end();
    L30:
        throw th;
    L31:
        return r15;
    L32:
        r14 = DownloadHelper.getTTNetException(r1, "sendRequest");     // Catch: Throwable -> L20
    L17:
        if (r0 < 300) goto L25;
    L9:
        throw new BaseException(DownloadErrorCode.ERROR_NO_CONNECTION, new IOException("Connection is null"));     // Catch: Throwable -> L6
    L6:
        th = th;
    L12:
        r1 = th;
        r0 = ((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getTTNetHandler().getResponseCode(th);
    L10:
        th = th;
        r15 = null;
        goto L12
    }

    public void handleResponseHeader(String r6, IDownloadHttpConnection r7) {
        HttpResponse r1 = new HttpResponse(r6, (IDownloadHttpConnection) ZeusTransformUtils.wrapperContextForParams(r7, IDownloadHttpConnection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
        String r8 = r1.getContentType();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(this.mDownloadInfo.getMimeType()) == true) goto L6;
    L8:
        this.mDownloadInfo.setContentEncoding(r1.getContentEncoding());     // Catch: Throwable -> L26
        if (DownloadHelper.GZIP.equalsIgnoreCase(this.mDownloadInfo.getContentEncoding()) == false) goto L12;
        this.mDownloadInfo.setIgnoreDataVerify(true);     // Catch: Throwable -> L26
    L12:
        if (r1.isChunked() == true) goto L17;
        String r9 = r1.getContentRange();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r9) == true) goto L16;
        long r10 = DownloadHelper.parseContentRangeOfInstanceLength(r9);     // Catch: Throwable -> L26
    L19:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L22;
        Logger.taskDebug(TAG, this.mDownloadInfo, "handleResponseHeader", "totalLength:" + r10);     // Catch: Throwable -> L26
    L22:
        if (checkTaskFinishByUser() == false) goto L24;
        return;
    L24:
        this.mDownloadInfo.setCurBytes(0);     // Catch: Throwable -> L26
        this.mStatusHandler.onFirstConnectionSuccessed(r10, null, this.mDownloadInfo.getName());     // Catch: Throwable -> L26
        return;
    L16:
        r10 = r1.getContentLength();     // Catch: Throwable -> L26
        goto L19
    L17:
        r10 = -1;
        this.mDownloadInfo.setXTotalBytes(r1.getXContentLength());     // Catch: Throwable -> L26
        goto L19
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L8;
        this.mDownloadInfo.setMimeType(r8);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        DownloadHelper.parseException(th, "handleResponseHeader");
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
        DownloadSingleResponseHandler r0 = this.mDownloadResponseHandler;
        if (r0 == null) goto L5;
        r0.pause();
        return;
    L5:
        closeConnection(this.mHttpConnection);
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
        DownloadSingleResponseHandler r0 = this.mDownloadResponseHandler;
        if (r0 == null) goto L5;
        r0.cancel();
        return;
    L5:
        closeConnection(this.mHttpConnection);
    }
}

package com.ss.android.socialbase.downloader.core.module.normal;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadSingleSegmentModule extends BaseDownloadNetworkModule {
    private static final String TAG = "DownloadSingleSegmentModule";
    private DownloadSingleResponseHandler mDownloadResponseHandler;
    private IDownloadHttpConnection mHttpConnection;

    public DownloadSingleSegmentModule() {
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
        if (checkTaskFinishByUser() == true) goto L19;
        doDownload();     // Catch: Throwable -> L13
        closeConnection(this.mHttpConnection);
        r6.proceed();
        return;
    L13:
        th = move-exception;
        closeConnection(this.mHttpConnection);
        throw th;
    }

    private void doDownload() {
        String r0 = this.mDownloadInfo.getConnectionUrl();
        long r1 = DownloadHelper.getFirstOffset(this.mDownloadInfo);
        int r3 = this.mSetting.optInt(DownloadSettingKeys.VERIFY_RESPONSE_PRE_FILE_LENGTH);
        if (r3 > 0) goto L5;
    L9:
        long r4 = this.mDownloadInfo.getStartOffset() + r1;
        List<HttpHeader> r5 = buildRequestHeader(r4, this.mDownloadInfo.getEndOffset(), true);
        this.mCommonParams.mFailoverStrategy.handleHeader(r5);
        this.mDownloadInfo.setHttpRequestHeader(r5.toString());
        this.mHttpConnection = sendRequest(r0, r5, r4);
        if (checkTaskFinishByUser() == false) goto L12;
        return;
    L12:
        handleResponseHeader(r0, r1, this.mHttpConnection);
        long r6 = this.mDownloadInfo.getTotalBytes();
        checkMaxBytes(r6, this.mDownloadInfo.getMaxBytes());
        if (checkTaskFinishByUser() == false) goto L15;
        return;
    L15:
        DownloadSingleResponseHandler r2 = new DownloadSingleResponseHandler(this.mCommonParams, this.mHttpConnection, r4, r6 - r1, this);
        this.mDownloadResponseHandler = r2;
        r2.handleResponse();
        return;
    L5:
        if (r3 >= DownloadConstants.TTNET_DEFAULT_BUFFER_SIZE) goto L9;
        long r7 = r3;
        if (r1 <= r7) goto L9;
        this.mDownloadInfo.setVerifyCurBytes(r1);
        r1 = r1 - r7;
        this.mDownloadInfo.setCurBytes(r1);
        goto L9
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

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void setThrottleNetSpeed(long r4, int r6) {
        if (DownloadSetting.obtain(this.mDownloadInfo.getId()).optInt(DownloadSettingKeys.USE_DEFAULT_THROTTLE_SPEED, 1) == 1) goto L14;
        IDownloadHttpConnection r7 = this.mHttpConnection;
        if (r7 != null) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r7, AbsDownloadHttpConnection.class) == false) goto L21;
        ((AbsDownloadHttpConnection) ZeusTransformUtils.preCheckCast(this.mHttpConnection, AbsDownloadHttpConnection.class, "com.obric.aiagent.plugin")).setThrottleNetSpeedWhenRunning(r4);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L21:
        return;
    L14:
        DownloadSingleResponseHandler r3 = this.mDownloadResponseHandler;
        if (r3 == null) goto L23;
        r3.setThrottleNetSpeed(r4, r6);
        return;
    }
}

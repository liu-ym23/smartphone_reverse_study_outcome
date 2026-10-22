package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.os.Process;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public class PCDNChunkRunnableModule extends BaseDownloadNetworkModule implements PCDNBandwidthSampler.LowSpeedListener, Runnable {
    private static final String TAG = "PCDNChunkRunnableModule";
    private int mChunkRetryCount;
    private IDownloadChunkCallback mDownloadChunkCallback;
    private Future mFuture;
    private IDownloadHttpConnection mHttpConnection;
    private boolean mIsStop;
    private PCDNChunkUrlPolicy mOuterPcdnChunkUrlPolicy;
    private PCDNBandwidthSampler mPcdnBandwidthSampler;
    private PCDNChunk mPcdnChunk;
    private PCDNChunkAllocater mPcdnChunkAllocater;
    private PCDNChunkProgressManager mPcdnChunkProgressManager;
    private PCDNChunkUrlPolicy mPcdnChunkUrlPolicy;
    private PCDNRetryPolicy mPcdnRetryPolicy;
    private PCDNStats mPcdnStats;
    private DownloadSingleResponseHandler mSingleResponseHandler;

    public interface IDownloadChunkCallback {
        void onError(Throwable r1);
    }

    public PCDNChunkRunnableModule(PCDNChunkProgressManager r3, PCDNChunkAllocater r4, PCDNBandwidthSampler r5, PCDNStats r6, PCDNChunkUrlPolicy r7, int r8, IDownloadChunkCallback r9) {
        IDownloadChunkCallback r10 = (IDownloadChunkCallback) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadChunkCallback.class, "com.obric.aiagent.plugin");
        this.mIsStop = false;
        this.mPcdnChunkProgressManager = r3;
        this.mPcdnChunkAllocater = r4;
        this.mPcdnBandwidthSampler = r5;
        r5.register(this);
        this.mPcdnStats = r6;
        this.mOuterPcdnChunkUrlPolicy = r7;
        this.mChunkRetryCount = r8;
        this.mDownloadChunkCallback = r10;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "run", "Run");
    L5:
        this.mPcdnBandwidthSampler.startSampling();
    L7:
        if (checkStop() == true) goto L13;
        PCDNChunk r0 = this.mPcdnChunkAllocater.obtainPCDNChunk();
        this.mPcdnChunk = r0;
        if (r0 == null) goto L10;
        downloadChunk();
        goto L7
    L10:
        return;
    L13:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L18;
        Logger.taskDebug(TAG, this.mDownloadInfo, "run", "Run End");
        return;
    }

    private void downloadChunk() {
        PCDNChunkUrlPolicy r0 = this.mOuterPcdnChunkUrlPolicy;
        if (r0 != null) goto L5;
    L7:
        this.mPcdnChunkUrlPolicy = new PCDNChunkUrlPolicy(this.mDownloadInfo.getPcdnUrls(), this.mDownloadInfo.getCdnUrls());
    L8:
        this.mPcdnRetryPolicy = new PCDNRetryPolicy(this.mChunkRetryCount);
    L9:
        Throwable r1 = doDownload(this.mPcdnChunkUrlPolicy.obtainUrl(), this.mPcdnChunkUrlPolicy.isPCDN());
        if (r1 == null) goto L26;
        if (this.mPcdnRetryPolicy.canRetry(true) == false) goto L15;
        if (checkStop() == false) goto L9;
        return;
    L15:
        if (checkStop() == true) goto L25;
        this.mDownloadChunkCallback.onError(r1);
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (r0.isPCDN() == true) goto L7;
        this.mPcdnChunkUrlPolicy = this.mOuterPcdnChunkUrlPolicy.copy();
        goto L8
    }

    private Throwable doDownload(String r21, boolean r22) {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "doDownload", "Before Url:" + r21 + " isPcdn:" + r22 + " index:" + this.mPcdnChunk.mIndex);
    L5:
        this.mPcdnStats.beforeDownload(r21, r22);
        List<HttpHeader> r0 = buildRequestHeader(this.mPcdnChunk.mStartOffset, this.mPcdnChunk.mEndOffset, true);
        long r6 = (this.mPcdnChunk.mEndOffset - this.mPcdnChunk.mStartOffset) + 1;
        Throwable r16 = null;
        this.mHttpConnection = sendRequest(r21, r0, this.mPcdnChunk.mStartOffset);     // Catch: Throwable -> L8
        DownloadSingleResponseHandler r1 = new DownloadSingleResponseHandler(this.mCommonParams, this.mHttpConnection, this.mPcdnChunk.mStartOffset, r6, this);     // Catch: Throwable -> L8
        this.mSingleResponseHandler = r1;     // Catch: Throwable -> L8
        r1.handleResponse();     // Catch: Throwable -> L8
        this.mPcdnChunkProgressManager.onDownloadChunkFinish(this.mPcdnChunk.mIndex);     // Catch: Throwable -> L8
    L12:
        Throwable r2 = r16;
        this.mPcdnStats.afterDownload(r21, this.mPcdnChunk.mStartOffset, r22, checkStop(), this.mHttpConnection, this.mSingleResponseHandler, r2);
        DownloadSingleResponseHandler r4 = this.mSingleResponseHandler;
        if (r4 == null) goto L16;
        this.mPcdnChunk.mStartOffset = r4.getCurOffset();
    L16:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L18;
        Logger.taskDebug(TAG, this.mDownloadInfo, "doDownload", "After Url:" + r21 + " isPcdn:" + r22 + " index:" + this.mPcdnChunk.mIndex);
    L18:
        return r2;
    L8:
        th = move-exception;
        r16 = th;
        r16.printStackTrace();
        this.mPcdnChunkUrlPolicy.onError();
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L12;
        Logger.taskDebug(TAG, this.mDownloadInfo, "doDownload", "OnError index:" + this.mPcdnChunk.mIndex);
        goto L12
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public boolean onProgress(long r2) {
        if (this.mPcdnChunkUrlPolicy.isPCDN() == false) goto L6;
        this.mPcdnBandwidthSampler.addPcdnSample(r2);
    L6:
        return this.mPcdnChunkProgressManager.onProgress(this.mPcdnChunk.mIndex, r2);
    }

    @Override // com.ss.android.socialbase.downloader.core.module.pcdn.PCDNBandwidthSampler.LowSpeedListener
    public void onLowSpeed() {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "onLowSpeed", "Run");
    L5:
        PCDNRetryPolicy r0 = this.mPcdnRetryPolicy;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.canRetry(false) == false) goto L19;
        PCDNChunkUrlPolicy r1 = this.mPcdnChunkUrlPolicy;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.switchToCdn() == true) goto L14;
        return;
    L14:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L16;
        Logger.taskDebug(TAG, this.mDownloadInfo, "onLowSpeed", "Run switch cdn");
    L16:
        closeConnection(this.mHttpConnection);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
        this.mIsStop = true;
        DownloadSingleResponseHandler r0 = this.mSingleResponseHandler;
        if (r0 == null) goto L5;
        r0.cancel();
    L6:
        cancelThread();
        return;
    L5:
        closeConnection(this.mHttpConnection);
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
        this.mIsStop = true;
        DownloadSingleResponseHandler r0 = this.mSingleResponseHandler;
        if (r0 == null) goto L5;
        r0.pause();
    L6:
        cancelThread();
        return;
    L5:
        closeConnection(this.mHttpConnection);
        goto L6
    }

    private void cancelThread() {
        this.mFuture.cancel(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean checkStop() {
        if (checkTaskFinishByUser() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsStop == true) goto L8;
        return false;
    }

    public void setFuture(Future r3) {
        this.mFuture = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.aiagent.plugin");
    }

    public Future getFuture() {
        return this.mFuture;
    }
}

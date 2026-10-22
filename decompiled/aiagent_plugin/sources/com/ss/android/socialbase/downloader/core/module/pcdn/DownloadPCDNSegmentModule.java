package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadPCDNException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadPCDNSegmentModule extends BaseDownloadNetworkModule implements PCDNChunkRunnableModule.IDownloadChunkCallback {
    private static final String TAG = "DownloadPCDNSegmentModule";
    private int mChunkRetryCount;
    private List<PCDNChunkRunnableModule> mChunkRunnables;
    private int mChunkThreadCount;
    private IDownloadHttpConnection mConnection;
    private Throwable mError;
    private long mMaxChunkLength;
    private PCDNBandwidthSampler mPcdnBandwidthSampler;
    private PCDNChunkAllocater mPcdnChunkAllocater;
    private PCDNChunkProgressManager mPcdnChunkProgressManager;
    private PCDNChunkUrlPolicy mPcdnChunkUrlPolicy;
    private long mPcdnDegradeBandWidthLimit;
    private int mPcdnDegradeSampleCount;
    private PCDNStats mPcdnStats;

    public DownloadPCDNSegmentModule() {
        this.mChunkRunnables = new CopyOnWriteArrayList();
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r3) {
        JSONObject r0 = r3.mSetting.optJSONObject(DownloadSettingKeys.PCDN_CONFIG);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r3.mDownloadInfo.getPcdnUrls() == null) goto L9;
        if (r3.mDownloadInfo.getPcdnUrls().isEmpty() == true) goto L9;
    L13:
        initImpl(r0);
        return super.init(r3);
    L9:
        if (r3.mDownloadInfo.getCdnUrls() != null) goto L11;
        return null;
    L11:
        if (r3.mDownloadInfo.getCdnUrls().isEmpty() == false) goto L13;
        return null;
    }

    private void initImpl(JSONObject r5) {
        this.mMaxChunkLength = r5.optLong(DownloadSettingKeys.PCDNConfig.MAX_CHUNK_LENGTH);
        this.mChunkThreadCount = r5.optInt("thread_count");
        this.mChunkRetryCount = r5.optInt(DownloadSettingKeys.PCDNConfig.CHUNK_RETRY_COUNT);
        this.mPcdnDegradeBandWidthLimit = r5.optLong(DownloadSettingKeys.PCDNConfig.PCDN_DEGRADE_BANDWIDTH_LIMIT);
        int r6 = r5.optInt(DownloadSettingKeys.PCDNConfig.PCDN_DEGRADE_SAMPLE_COUNT);
        this.mPcdnDegradeSampleCount = r6;
        if (this.mMaxChunkLength > 0) goto L6;
        this.mMaxChunkLength = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
    L6:
        if (this.mChunkThreadCount > 0) goto L9;
        this.mChunkThreadCount = 3;
    L9:
        if (this.mChunkThreadCount <= 6) goto L12;
        this.mChunkThreadCount = 6;
    L12:
        if (this.mChunkRetryCount <= 20) goto L14;
        this.mChunkRetryCount = 20;
    L14:
        if (r6 >= 3) goto L17;
        this.mPcdnDegradeSampleCount = 3;
        return;
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r5) {
        IDownloadModuleChain r6 = (IDownloadModuleChain) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadModuleChain.class, "com.obric.aiagent.plugin");
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L6;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L6:
        if (hasRunNetworkProceed(r6, true) == false) goto L22;
        return;
    L22:
        checkTotalSize();     // Catch: Throwable -> L14 BaseException -> L17 DownloadFileExistException -> L20
        if (checkTaskFinishByUser() == false) goto L11;
        return;
    L11:
        init();     // Catch: Throwable -> L14 BaseException -> L17 DownloadFileExistException -> L20
        doDownload();     // Catch: Throwable -> L14 BaseException -> L17 DownloadFileExistException -> L20
        r6.proceed();
        return;
    L20:
        e = move-exception;
        throw e;
    L17:
        e = move-exception;
        throw new DownloadPCDNException(e.getErrorCode(), e.getErrorMessage());
    L14:
        th = move-exception;
        throw new DownloadPCDNException(1000, th.getMessage());
    }

    private void checkTotalSize() {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "checkTotalSize", "Run");
    L5:
        long r3 = this.mDownloadInfo.getTotalBytes();
        if (r3 > 0) goto L8;
    L9:
        fetchTotalSize();
        r3 = this.mDownloadInfo.getTotalBytes();
    L11:
        if (r3 <= 0) goto L17;
        checkMaxBytes(r3, this.mDownloadInfo.getMaxBytes());
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L18;
        Logger.taskDebug(TAG, this.mDownloadInfo, "checkTotalSize", "TotalSize: " + r3);
        return;
    L18:
        return;
    L17:
        throw new BaseException(DownloadErrorCode.ERROR_PCDN_CONTENT_LENGTH_EMPTY, "pcdn content-length empty");
    L8:
        if (this.mCommonParams.mNeedCheckIfModified == false) goto L11;
        goto L9
    }

    private void fetchTotalSize() {
        this.mPcdnChunkUrlPolicy = new PCDNChunkUrlPolicy(this.mDownloadInfo.getPcdnUrls(), this.mDownloadInfo.getCdnUrls());
        PCDNRetryPolicy r4 = new PCDNRetryPolicy(this.mChunkRetryCount);
        String r5 = null;
    L4:
        if (checkTaskFinishByUser() == true) goto L38;
        r5 = this.mPcdnChunkUrlPolicy.obtainUrl();     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L8;
        Logger.taskDebug(TAG, this.mDownloadInfo, "getTotalSize", "Before Url:" + r5 + " isPcdn:" + this.mPcdnChunkUrlPolicy.isPCDN());     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
    L8:
        IDownloadHttpConnection r6 = sendRequest(r5, buildRequestHeader(this.mDownloadInfo.getStartOffset(), this.mDownloadInfo.getEndOffset(), false), this.mDownloadInfo.getStartOffset());     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
        this.mConnection = r6;     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
        handleResponseHeader(r5, 0, r6);     // Catch: Throwable -> L16 BaseException -> L18 DownloadFileExistException -> L29
    L9:
        IDownloadHttpConnection r7 = this.mConnection;
        if (r7 == null) goto L13;
        r7.end();
    L13:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L49;
        Logger.taskDebug(TAG, this.mDownloadInfo, "getTotalSize", "After Url:" + r5 + " isPcdn:" + this.mPcdnChunkUrlPolicy.isPCDN());
        return;
    L49:
        return;
    L29:
        e = move-exception;
        throw e;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        IDownloadHttpConnection r8 = this.mConnection;
        if (r8 == null) goto L35;
        r8.end();
    L35:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L37;
        Logger.taskDebug(TAG, this.mDownloadInfo, "getTotalSize", "After Url:" + r5 + " isPcdn:" + this.mPcdnChunkUrlPolicy.isPCDN());
    L37:
        throw th;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        if (r4.canRetry(true) == false) goto L28;
        this.mPcdnChunkUrlPolicy.onError();     // Catch: Throwable -> L16
        IDownloadHttpConnection r9 = this.mConnection;
        if (r9 == null) goto L26;
        r9.end();
    L26:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L4;
        Logger.taskDebug(TAG, this.mDownloadInfo, "getTotalSize", "After Url:" + r5 + " isPcdn:" + this.mPcdnChunkUrlPolicy.isPCDN());
        goto L4
    L28:
        throw e;     // Catch: Throwable -> L16
    }

    private void init() {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mDownloadInfo, "init", "Run");
    L5:
        this.mPcdnChunkProgressManager = new PCDNChunkProgressManager(this, this.mCommonParams.mDownloadCache, this.mCommonParams.mDownloadInfo);
        this.mPcdnChunkAllocater = new PCDNChunkAllocater(this.mCommonParams.mDownloadInfo, this.mMaxChunkLength);
        this.mPcdnBandwidthSampler = new PCDNBandwidthSampler(this.mCommonParams.mDownloadInfo.getId(), this.mPcdnDegradeBandWidthLimit, this.mPcdnDegradeSampleCount);
        if (this.mPcdnStats != null) goto L8;
        this.mPcdnStats = new PCDNStats(this.mDownloadInfo, this.mChunkRetryCount);
    L8:
        this.mChunkRunnables.clear();
        this.mError = null;
    }

    private void doDownload() {
        long r0 = DownloadHelper.getFirstOffset(this.mDownloadInfo) + this.mDownloadInfo.getStartOffset();
        int r2 = (int) Math.ceil(((this.mDownloadInfo.getTotalBytes() - r0) * 1.0d) / this.mMaxChunkLength);
        int r3 = this.mChunkThreadCount;
        if (r2 >= r3) goto L6;
        r3 = r2;
    L6:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L8;
        Logger.taskDebug(TAG, this.mDownloadInfo, "doDownload", "StartOffset:" + r0 + " chunkCount:" + r2 + " threadCount:" + r3);
    L8:
        int r1 = 0;
    L9:
        if (r1 >= r3) goto L11;
        PCDNChunkRunnableModule r4 = new PCDNChunkRunnableModule(this.mPcdnChunkProgressManager, this.mPcdnChunkAllocater, this.mPcdnBandwidthSampler, this.mPcdnStats, this.mPcdnChunkUrlPolicy, this.mChunkRetryCount, this);
        r4.init(this.mCommonParams);
        r4.setFuture(DownloadComponentManager.getChunkDownloadThreadExecutorService().submit(r4));
        this.mChunkRunnables.add(r4);
        r1 = r1 + 1;
        goto L9
    L11:
        Iterator<PCDNChunkRunnableModule> r5 = this.mChunkRunnables.iterator();
    L13:
        if (r5.hasNext() == false) goto L20;
        ((PCDNChunkRunnableModule) ZeusTransformUtils.preCheckCast(r5.next(), PCDNChunkRunnableModule.class, "com.obric.aiagent.plugin")).getFuture().get();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L13
    L20:
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L22;
        Logger.taskDebug(TAG, this.mDownloadInfo, "doDownload", "ChunkRunnable End");
    L22:
        this.mPcdnBandwidthSampler.stopSampling();
        this.mPcdnStats.collectPCDNStats();
        if (checkTaskFinishByUser() == false) goto L25;
        return;
    L25:
        Throwable r6 = this.mError;
        if (r6 != null) goto L28;
        return;
    L28:
        if (ZeusTransformUtils.instanceOf(r6, BaseException.class) == false) goto L32;
        throw ((BaseException) ZeusTransformUtils.preCheckCast(this.mError, BaseException.class, "com.obric.aiagent.plugin"));
    L32:
        throw new BaseException(1000, this.mError);
    }

    @Override // com.ss.android.socialbase.downloader.core.module.pcdn.PCDNChunkRunnableModule.IDownloadChunkCallback
    public void onError(Throwable r1) {
        this.mError = r1;
        cancel();
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
        closeConnection(this.mConnection);
        Iterator<PCDNChunkRunnableModule> r3 = this.mChunkRunnables.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((PCDNChunkRunnableModule) ZeusTransformUtils.preCheckCast(r3.next(), PCDNChunkRunnableModule.class, "com.obric.aiagent.plugin")).pause();
        goto L4
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
        closeConnection(this.mConnection);
        Iterator<PCDNChunkRunnableModule> r3 = this.mChunkRunnables.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((PCDNChunkRunnableModule) ZeusTransformUtils.preCheckCast(r3.next(), PCDNChunkRunnableModule.class, "com.obric.aiagent.plugin")).cancel();
        goto L4
    }
}

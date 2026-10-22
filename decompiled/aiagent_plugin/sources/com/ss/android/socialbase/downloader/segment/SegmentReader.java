package com.ss.android.socialbase.downloader.segment;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
class SegmentReader implements Runnable {
    private static final int SEGMENT_APPLY_RETRY_MAX_COUNT = 50;
    private static final int SWITCH_URL_MAX_COUNT = 30;
    private static final String TAG = "SegmentReader";
    private volatile boolean changeSegment;
    private volatile boolean closed;
    volatile long connectEndTime;
    volatile long connectStartTime;
    String curHostIp;
    String curHostRealIp;
    private int curRetryCount;
    volatile Segment curSegment;
    private volatile long curSegmentReadOffset;
    String curUrl;
    private final DownloadInfo downloadInfo;
    private final DownloadTask downloadTask;
    private volatile long endOffsetInConnection;
    private boolean exited;
    private boolean failed;
    private BaseException failedException;
    private NetworkFailoverStrategy failoverStrategy;
    private Future future;
    private final ISegmentCallback host;
    private IDownloadHttpConnection httpConnection;
    private HttpResponse httpResponse;
    private boolean httpsToHttpRetryUsed;
    private long lastConnectStartTime;
    private final IBufferPool pool;
    private volatile long readBytes;
    volatile long readEndTime;
    volatile long readStartTime;
    private volatile boolean reconnect;
    private int retryCount;
    private NetworkRetryStrategy retryStrategy;
    private int segmentApplyRetryTimes;
    private volatile long segmentNewEndOffset;
    private final DownloadSetting setting;
    private long startOffsetInConnection;
    private DownloadStenographer stenographer;
    private final List<Segment> succeedSegments;
    private int switchUrlTimes;
    private Thread thread;
    private volatile boolean threadDirty;
    final int threadIndex;
    UrlRecord urlRecord;

    SegmentReader(DownloadTask r3, DownloadInfo r4, SegmentDispatcher r5, IBufferPool r6, UrlRecord r7, int r8) {
        IBufferPool r9 = (IBufferPool) ZeusTransformUtils.wrapperContextForParams(r6, IBufferPool.class, "com.obric.aiagent.plugin");
        this.succeedSegments = new ArrayList();
        this.curSegmentReadOffset = -1;
        this.downloadTask = r3;
        this.downloadInfo = r4;
        this.host = r5;
        this.pool = r9;
        this.setting = DownloadSetting.obtain(r4.getId());
        this.urlRecord = r7;
        this.threadIndex = r8;
        this.retryStrategy = new NetworkRetryStrategy(r4);
        this.failoverStrategy = new NetworkFailoverStrategy(r4);
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.thread = Thread.currentThread();     // Catch: Throwable -> L38
        this.host.onReaderRun(this);     // Catch: Throwable -> L38
        this.urlRecord.recordUse(this);     // Catch: Throwable -> L38
    L4:
        Segment r1 = this.host.obtainSegment(this, this.urlRecord);     // Catch: Throwable -> L38
        if (r1 == null) goto L8;
        this.curSegment = r1;     // Catch: Throwable -> L38
    L25:
        e = move-exception;
        Logger.taskError(TAG, this.downloadInfo.getId(), "run", "SegmentApplyException, Exception = " + e);     // Catch: Throwable -> L23
        int r4 = this.segmentApplyRetryTimes;     // Catch: Throwable -> L23
        if (r4 >= 50) goto L28;
        this.segmentApplyRetryTimes = r4 + 1;     // Catch: Throwable -> L23
        this.curSegment = null;     // Catch: Throwable -> L38
        ISegmentCallback r2 = this.host;     // Catch: Throwable -> L38
    L15:
        r2.unObtainSegment(this, r1);     // Catch: Throwable -> L38
        goto L4
    L28:
        Logger.taskError(TAG, this.downloadInfo.getId(), "run", "Segment apply failed " + this.segmentApplyRetryTimes + "times, thread_index = " + this.threadIndex);     // Catch: Throwable -> L23
        this.curSegment = null;     // Catch: Throwable -> L38
        ISegmentCallback r3 = this.host;     // Catch: Throwable -> L38
    L21:
        r3.unObtainSegment(this, r1);     // Catch: Throwable -> L38
    L31:
        this.urlRecord.recordUnUse(this);     // Catch: Throwable -> L48
        ISegmentCallback r5 = this.host;     // Catch: Throwable -> L48
    L41:
        r5.onReaderExit(this);     // Catch: Throwable -> L48
        goto L42
    L23:
        th = move-exception;
        this.curSegment = null;     // Catch: Throwable -> L38
        this.host.unObtainSegment(this, r1);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L12:
        if (download(r1) == false) goto L18;
        this.succeedSegments.add(r1);     // Catch: Throwable -> L23 SegmentApplyException -> L25
        this.curSegment = null;     // Catch: Throwable -> L38
        r2 = this.host;     // Catch: Throwable -> L38
        goto L15
    L18:
        if (this.closed == true) goto L20;
        Logger.taskError(TAG, this.downloadInfo.getId(), "run", "Download segment failed, segment = " + r1 + ", thread_index = " + this.threadIndex + ", failedException = " + this.failedException);     // Catch: Throwable -> L23 SegmentApplyException -> L25
    L20:
        this.curSegment = null;     // Catch: Throwable -> L38
        r3 = this.host;     // Catch: Throwable -> L38
        goto L21
    L8:
        if (Logger.debug() == false) goto L31;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "run", "No more segment, thread_index: " + this.threadIndex);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L44
        this.urlRecord.recordUnUse(this);     // Catch: Throwable -> L48
        r5 = this.host;     // Catch: Throwable -> L48
    L44:
        th = move-exception;
        this.urlRecord.recordUnUse(this);     // Catch: Throwable -> L49
        this.host.onReaderExit(this);     // Catch: Throwable -> L49
    L46:
        this.thread = null;
        throw th;
    L42:
        this.thread = null;
    }

    private boolean download(Segment r7) {
        initParams();
    L48:
        doConnect(r7);     // Catch: Throwable -> L6 SegmentApplyException -> L37
        loopAndRead(r7);     // Catch: Throwable -> L6 SegmentApplyException -> L37
    L4:
        releaseDownload();
        return true;
    L37:
        e = move-exception;
        this.failedException = e;     // Catch: Throwable -> L40
        throw e;     // Catch: Throwable -> L40
    L6:
        th = move-exception;
        Logger.taskError(TAG, this.downloadInfo.getId(), "download", "e = " + th + ", threadIndex = " + this.threadIndex + ", reconnect = " + this.reconnect + ", closed = " + this.closed);     // Catch: Throwable -> L40
        if (this.closed == true) goto L10;
        if (this.reconnect == false) goto L24;
        this.reconnect = false;     // Catch: Throwable -> L40
        Thread.interrupted();     // Catch: Throwable -> L17
    L20:
        if (this.changeSegment == false) goto L21;
        this.changeSegment = false;     // Catch: Throwable -> L40
        throw new SegmentApplyException(5, "download");     // Catch: Throwable -> L40
    L21:
        releaseDownload();
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L40
        goto L20
    L24:
        BaseException e2 = null;
        if (ZeusTransformUtils.instanceOf(th, BaseException.class) == false) goto L46;
        e2 = (BaseException) ZeusTransformUtils.preCheckCast(th, BaseException.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
    L31:
        if (e2 == null) goto L35;
        if (handleFailedAndCheckRetry(r7, e2) == true) goto L21;
    L35:
        releaseDownload();
        return false;
    L46:
        DownloadHelper.parseException(th, "download");     // Catch: BaseException -> L30 Throwable -> L40
    L30:
        e2 = e;
        goto L31
    L10:
        releaseDownload();
        return false;
    L40:
        th = move-exception;
        releaseDownload();
        throw th;
    }

    private void releaseDownload() {
        this.lastConnectStartTime = this.connectStartTime;
        this.connectStartTime = -1;
        this.connectEndTime = -1;
        this.readStartTime = -1;
        this.readEndTime = -1;
        closeConnection();
    }

    private void closeConnection() {
        IDownloadHttpConnection r0 = this.httpConnection;
        if (r0 == null) goto L12;
        if (Logger.debug() == false) goto L7;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "closeConnection", "Thread: " + this.threadIndex);     // Catch: Throwable -> L9
    L7:
        r0.end();     // Catch: Throwable -> L9
        r0.cancel();     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    private void initParams() {
        this.httpsToHttpRetryUsed = false;
        resetRetryTimes();
    }

    private void resetRetryTimes() {
        if (this.urlRecord.isMainUrl == false) goto L5;
        int r0 = this.downloadInfo.getRetryCount();
    L6:
        this.retryCount = r0;
        this.curRetryCount = 0;
        this.retryStrategy.reset();
        return;
    L5:
        r0 = this.downloadInfo.getBackUpUrlRetryCount();
        goto L6
    }

    boolean switchUrlRecord(UrlRecord r3) {
        int r0 = this.switchUrlTimes;
        if (r0 < 30) goto L6;
        return false;
    L6:
        this.switchUrlTimes = r0 + 1;
        UrlRecord r1 = this.urlRecord;
        if (r1 == null) goto L9;
        r1.recordUnUse(this);
    L9:
        r3.recordUse(this);
        this.urlRecord = r3;
        resetRetryTimes();
        return true;
    }

    int getCurRetryCount() {
        return this.curRetryCount;
    }

    int getRetryCount() {
        return this.retryCount;
    }

    private boolean handleFailedAndCheckRetry(Segment r9, BaseException r10) {
        Logger.taskError(TAG, this.downloadInfo.getId(), "handleFailedAndCheckRetry", "Exception = " + r10 + ", curRetryCount = " + this.curRetryCount + ", retryCount = " + this.retryCount);
        this.failedException = r10;
        this.urlRecord.recordFailed();
        if (this.host.onSegmentRetry(this, this.urlRecord, r9, r10, this.curRetryCount, this.retryCount) == true) goto L5;
        return false;
    L5:
        int r0 = this.curRetryCount;
        if (r0 >= this.retryCount) goto L9;
        this.curRetryCount = r0 + 1;
        return true;
    L9:
        this.failoverStrategy.handleError(r10);
        if (this.retryStrategy.canRetry(r10) == false) goto L14;
        this.retryStrategy.doRetry();
        this.downloadInfo.setCurNetworkRetryCount(this.retryStrategy.getTotalRetryCount());
        return true;
    L14:
        if (checkCanUseHttpsToHttpRetry(r10) == false) goto L16;
        return true;
    L16:
        this.host.onSegmentFailed(this, this.urlRecord, r9, r10);
        return false;
    }

    private boolean checkCanUseHttpsToHttpRetry(BaseException r3) {
        if (DownloadHelper.isHttpsError(r3) == true) goto L5;
        return false;
    L5:
        String r4 = this.urlRecord.url;
        if (TextUtils.isEmpty(r4) == false) goto L8;
    L18:
        return false;
    L8:
        if (r4.startsWith("https") == false) goto L18;
        if (this.downloadInfo.isNeedHttpsToHttpRetry() == true) goto L14;
        return false;
    L14:
        if (this.httpsToHttpRetryUsed == false) goto L16;
        return false;
    L16:
        this.httpsToHttpRetryUsed = true;
        resetRetryTimes();
        return true;
    }

    private void doConnect(Segment r4) {
        createConnection(r4);
        this.host.onSegmentConnected(this, r4, this.urlRecord, this.httpResponse);
        this.urlRecord.recordSucceed();
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0229: INVOKE 
      (r8v2 ?? I:java.lang.String)
      (r4 I:com.ss.android.socialbase.downloader.network.IDownloadHttpConnection)
      (r2 I:java.lang.Throwable)
      (r1 I:com.ss.android.socialbase.downloader.depend.IDownloadCdnListener)
     STATIC call: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadCDN(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void A[MD:(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void (m)], block:B:82:0x021d */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0229: INVOKE 
      (r8 I:java.lang.String)
      (r4 I:com.ss.android.socialbase.downloader.network.IDownloadHttpConnection)
      (r2 I:java.lang.Throwable)
      (r1 I:com.ss.android.socialbase.downloader.depend.IDownloadCdnListener)
     STATIC call: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorDownloadCDN(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void A[MD:(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHttpConnection, java.lang.Throwable, com.ss.android.socialbase.downloader.depend.IDownloadCdnListener):void (m)], block:B:82:0x021d */
    private void createConnection(Segment r23) {
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L71 BaseException -> L77
        this.connectEndTime = 0;     // Catch: Throwable -> L71 BaseException -> L77
        this.connectStartTime = r5;     // Catch: Throwable -> L71 BaseException -> L77
        this.startOffsetInConnection = r23.getCurrentOffsetRead();     // Catch: Throwable -> L71 BaseException -> L77
        this.endOffsetInConnection = r23.getEndOffset();     // Catch: Throwable -> L71 BaseException -> L77
        if (this.endOffsetInConnection > 0) goto L93;
    L15:
        this.stenographer = new DownloadStenographer();     // Catch: Throwable -> L71 BaseException -> L77
        List<HttpHeader> r7 = DownloadHelper.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), this.startOffsetInConnection, this.endOffsetInConnection);     // Catch: Throwable -> L71 BaseException -> L77
        r7.add(new HttpHeader("Segment-Index", String.valueOf(r23.getIndex())));     // Catch: Throwable -> L71 BaseException -> L77
        r7.add(new HttpHeader("Thread-Index", String.valueOf(this.threadIndex)));     // Catch: Throwable -> L71 BaseException -> L77
        r7.add(new HttpHeader("extra_download_id", String.valueOf(this.downloadInfo.getId())));     // Catch: Throwable -> L71 BaseException -> L77
        DownloadHelper.addTTNetParam(this.setting, r7, this.downloadInfo);     // Catch: Throwable -> L71 BaseException -> L77
        this.failoverStrategy.handleHeader(r7);     // Catch: Throwable -> L71 BaseException -> L77
        String r8 = this.urlRecord.url;     // Catch: Throwable -> L71 BaseException -> L77
    L66:
        th = th;
        String r9 = "createConn";
    L68:
        IDownloadHttpConnection r4 = null;
    L73:
        Throwable r2 = th;
    L74:
        DownloadHelper.parseException(r2, r9);     // Catch: Throwable -> L81
        this.connectEndTime = System.currentTimeMillis();
        DownloadMonitorHelper.monitorDownloadCDN(r8, r4, r2, this.downloadTask.getCdnListener());
        return;
    L69:
        e = e;
    L80:
        throw e;     // Catch: Throwable -> L81
    L17:
        if (this.httpsToHttpRetryUsed == true) goto L84;
    L29:
        String r3 = this.urlRecord.ip;     // Catch: Throwable -> L66 BaseException -> L69
        if (Logger.debug() == false) goto L33;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "createConnection", "Url = " + r8 + ", ip = " + r3 + ", segment = " + r23 + ", threadIndex = " + this.threadIndex);     // Catch: Throwable -> L24 BaseException -> L27
    L24:
        th = move-exception;
        r2 = th;
        r9 = "createConn";
    L26:
        r4 = null;
    L33:
        this.curUrl = r8;     // Catch: Throwable -> L66 BaseException -> L69
        this.curHostIp = r3;     // Catch: Throwable -> L66 BaseException -> L69
        boolean r14 = this.downloadInfo.isNeedDefaultHttpServiceBackUp();     // Catch: Throwable -> L66 BaseException -> L69
        int r0 = this.downloadInfo.getMaxBytes();     // Catch: Throwable -> L66 BaseException -> L69
        r9 = "createConn";
    L64:
        th = th;
        goto L68
    L37:
        if ((r5 - this.lastConnectStartTime) > WsConstants.EXIT_DELAY_TIME) goto L86;
    L43:
        boolean r6 = false;
    L45:
        IDownloadHttpConnection r10 = DownloadComponentManager.downloadWithConnection(r14, r0, r8, r3, r7, 0, r6, this.downloadInfo);     // Catch: Throwable -> L64 BaseException -> L69
    L95:
        if (r10 == null) goto L63;
        this.httpConnection = r10;     // Catch: Throwable -> L58 BaseException -> L60
        this.httpResponse = new HttpResponse(r8, r10);     // Catch: Throwable -> L58 BaseException -> L60
        if (this.closed == true) goto L57;
        if (ZeusTransformUtils.instanceOf(r10, AbsDownloadHttpConnection.class) == false) goto L53;
        this.curHostRealIp = ((AbsDownloadHttpConnection) ZeusTransformUtils.preCheckCast(r10, AbsDownloadHttpConnection.class, "com.obric.aiagent.plugin")).getHostIp();     // Catch: Throwable -> L58 BaseException -> L60
    L53:
        if (Logger.debug() == false) goto L55;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "createConnection", "Url = " + r8 + ", ip = " + r3 + ", hostRealIp = " + this.curHostRealIp + ", threadIndex = " + this.threadIndex);     // Catch: Throwable -> L58 BaseException -> L60
    L55:
        this.connectEndTime = System.currentTimeMillis();
        DownloadMonitorHelper.monitorDownloadCDN(r8, r10, null, this.downloadTask.getCdnListener());
        return;
    L57:
        throw new StreamClosedException(r9);     // Catch: Throwable -> L58 BaseException -> L60
    L63:
        throw new BaseException(DownloadErrorCode.ERROR_NO_CONNECTION, new IOException("download can't continue, chunk connection is null"));     // Catch: Throwable -> L58 BaseException -> L60
    L60:
        e = move-exception;
        throw e;     // Catch: Throwable -> L81
    L58:
        th = move-exception;
        r2 = th;
        r4 = r10;
        goto L74
    L86:
        if (this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT) <= 0) goto L43;
        r6 = true;
        goto L45
    L27:
        e = move-exception;
        throw e;     // Catch: Throwable -> L81
    L41:
        th = move-exception;
        r2 = th;
        goto L26
    L84:
        if (TextUtils.isEmpty(r8) == true) goto L29;
        if (r8.startsWith("https") == false) goto L29;
        r8 = r8.replaceFirst("https", "http");     // Catch: Throwable -> L24 BaseException -> L27
        goto L29
    L93:
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L81
    L11:
        th = move-exception;
        r2 = th;
        r9 = "createConn";
        r4 = null;
        r8 = null;
        goto L74
    L7:
        if (this.startOffsetInConnection <= this.endOffsetInConnection) goto L15;
        throw new SegmentApplyException(6, "createConn, " + r23);     // Catch: Throwable -> L11 BaseException -> L13
    L81:
        th = move-exception;
        this.connectEndTime = System.currentTimeMillis();
        DownloadMonitorHelper.monitorDownloadCDN(r8, r4, "https", this.downloadTask.getCdnListener());
        throw th;
    L77:
        e = e;
    L71:
        th = th;
        r9 = "createConn";
        r4 = null;
        r8 = null;
        goto L73
    }

    private void loopAndRead(Segment r41) {
        Segment r2 = r41;
        IBufferPool r3 = this.pool;
        this.readStartTime = System.currentTimeMillis();
        long r4 = r41.getCurrentOffsetRead();
        boolean r8 = false;
        InputStream r10 = this.httpConnection.getInputStream();     // Catch: Throwable -> L208 BaseException -> L238
        if (r10 == null) goto L203;
        long r11 = this.httpResponse.getContentLength();     // Catch: Throwable -> L196 BaseException -> L199
        if (r11 == 0) goto L195;
        Buffer r15 = probeFirstBuffer(r3, r10);     // Catch: Throwable -> L196 BaseException -> L199
    L309:
    L190:
        e = e;
        r4 = r4;
    L241:
        this.failedException = e;     // Catch: Throwable -> L243
        throw e;     // Catch: Throwable -> L243
    L187:
        th = th;
        r4 = r4;
    L189:
        long r13 = r4;
        IOutput r9 = null;
    L211:
        Logger.taskError(TAG, this.downloadInfo.getId(), "loopAndRead", "Exception: " + th + " stack: " + Log.getStackTraceString(th));     // Catch: Throwable -> L243
        th.printStackTrace();     // Catch: Throwable -> L243
        DownloadHelper.parseException(th, "loopAndRead");     // Catch: BaseException -> L235 Throwable -> L243
        DownloadUtils.safeClose(new Closeable[]{r10});
        if (r9 == null) goto L219;
        if (r15 == null) goto L279;
    L217:
        r15.size = -1;     // Catch: Throwable -> L265
        r9.write(r15);     // Catch: Throwable -> L265
        Buffer r12 = null;
    L220:
        if (r12 == null) goto L222;
        r3.recycle(r12);
    L222:
        this.readEndTime = System.currentTimeMillis();
        if (r13 <= r4) goto L232;
        DownloadSetting r0 = this.setting;
        DownloadInfo r5 = this.downloadInfo;
        String r6 = this.curUrl;
        String r7 = this.curHostIp;
        String r14 = this.curHostRealIp;
        if (this.closed == false) goto L227;
    L230:
        boolean r33 = true;
    L231:
        DownloadMonitorHelper.monitorSegmentIO(r0, r5, r6, r7, r14, r33, this.httpConnection, this.failedException, r13 - r4, TimeUnit.MILLISECONDS.toNanos(this.readEndTime - this.readStartTime));
        goto L232
    L227:
        if (this.reconnect == true) goto L230;
        r33 = false;
    L232:
        ISegmentCallback r1 = this.host;
    L233:
        r1.unApplySegment(this, r2);
        return;
    L279:
        r15 = r3.obtain();     // Catch: Throwable -> L265
    L219:
        r12 = r15;
        goto L220
    L235:
        e = move-exception;
        this.failedException = e;     // Catch: Throwable -> L243
        DownloadHelper.injectRemoteIp(this.httpConnection, e);     // Catch: Throwable -> L243
        throw e;     // Catch: Throwable -> L243
    L9:
        if (this.reconnect == false) goto L11;
    L180:
        r4 = r4;
    L185:
        e = e;
    L183:
        th = th;
        goto L189
    L182:
        throw new StreamClosedException("probe");     // Catch: Throwable -> L183 BaseException -> L185
    L11:
        if (this.closed == true) goto L180;
        this.retryStrategy.reset();     // Catch: Throwable -> L187 BaseException -> L190
        this.host.applySegment(this, r2);     // Catch: Throwable -> L187 BaseException -> L190
        r9 = this.host.createOutput(this, r2);     // Catch: Throwable -> L187 BaseException -> L190
        long r17 = r41.getEndOffset();     // Catch: Throwable -> L176 BaseException -> L178
        if (r17 > 0) goto L19;
        if (r11 <= 0) goto L18;
        r17 = (r11 + r4) - 1;     // Catch: Throwable -> L176 BaseException -> L178
        goto L19
    L18:
        r17 = Long.MAX_VALUE;
    L19:
        int r16 = r15.size;     // Catch: Throwable -> L176 BaseException -> L178
        long r18 = r16;
        r13 = r4 + r18;
        if (r13 <= r17) goto L50;
        long r19 = r17 + 1;
        if (r13 <= r19) goto L28;
        int r110 = (int) (r18 - (r13 - r19));
        if (r110 <= 0) goto L28;
        if (r110 >= r16) goto L28;
        r15.size = r110;     // Catch: Throwable -> L172 BaseException -> L174
        r13 = r19;
    L28:
        this.curSegmentReadOffset = r13;     // Catch: Throwable -> L172 BaseException -> L174
        r9.write(r15);     // Catch: Throwable -> L172 BaseException -> L174
        DownloadUtils.safeClose(new Closeable[]{r10});
        if (r9 != null) goto L289;
    L35:
        Buffer r20 = null;
    L36:
        if (r20 == null) goto L38;
        r3.recycle(r20);
    L38:
        this.readEndTime = System.currentTimeMillis();
        if (r13 <= r4) goto L48;
        DownloadSetting r111 = this.setting;
        DownloadInfo r21 = this.downloadInfo;
        String r22 = this.curUrl;
        String r23 = this.curHostIp;
        String r24 = this.curHostRealIp;
        if (this.closed == false) goto L43;
    L46:
        boolean r25 = true;
    L47:
        DownloadMonitorHelper.monitorSegmentIO(r111, r21, r22, r23, r24, r25, this.httpConnection, this.failedException, r13 - r4, TimeUnit.MILLISECONDS.toNanos(this.readEndTime - this.readStartTime));
        goto L48
    L43:
        if (this.reconnect == true) goto L46;
        r25 = false;
    L48:
        this.host.unApplySegment(this, r2);
        return;
    L289:
        Buffer r26 = r3.obtain();     // Catch: Throwable -> L267
        r26.size = -1;     // Catch: Throwable -> L34
        r9.write(r26);     // Catch: Throwable -> L34
    L34:
        r20 = r26;
        goto L36
    L50:
        this.curSegmentReadOffset = r13;     // Catch: Throwable -> L172 BaseException -> L174
        r9.write(r15);     // Catch: Throwable -> L172 BaseException -> L174
        long r112 = r17;
    L297:
        if (this.threadDirty == true) goto L269;
        r4 = r4;
    L305:
        r15 = r3.obtain();     // Catch: Throwable -> L164 BaseException -> L166
        int r27 = r10.read(r15.data);     // Catch: Throwable -> L160 BaseException -> L162
        r15.size = r27;     // Catch: Throwable -> L160 BaseException -> L162
        if (r27 == (-1)) goto L109;
        long r28 = r27;
        r13 = r13 + r28;     // Catch: Throwable -> L160 BaseException -> L162
        if (r13 > r112) goto L112;
        r2 = r41;
        this.curSegmentReadOffset = r13;     // Catch: Throwable -> L156 BaseException -> L158
        r9.write(r15);     // Catch: Throwable -> L156 BaseException -> L158
        r4 = r4;
        r8 = false;
        goto L297
    L158:
        e = e;
    L156:
        th = th;
        goto L211
    L112:
        long r29 = r112 + 1;     // Catch: Throwable -> L160 BaseException -> L162
        if (r13 <= r29) goto L118;
        int r30 = (int) (r28 - (r13 - r29));     // Catch: Throwable -> L160 BaseException -> L162
        if (r30 <= 0) goto L118;
        if (r30 >= r27) goto L118;
        r15.size = r30;     // Catch: Throwable -> L160 BaseException -> L162
        r13 = r29;
    L118:
        this.curSegmentReadOffset = r13;     // Catch: Throwable -> L160 BaseException -> L162
        r9.write(r15);     // Catch: Throwable -> L160 BaseException -> L162
        if (Logger.debug() == false) goto L122;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "loopAndRead", "BytesRead = " + (r13 - r4) + ", url = " + this.urlRecord.url);     // Catch: Throwable -> L164 BaseException -> L166
    L122:
        long r31 = 0;
    L124:
        if (r112 > r31) goto L126;
    L132:
        DownloadUtils.safeClose(new Closeable[]{r10});
        if (r9 != null) goto L275;
    L139:
        Buffer r32 = null;
    L140:
        if (r32 == null) goto L142;
        r3.recycle(r32);
    L142:
        this.readEndTime = System.currentTimeMillis();
        if (r13 <= r4) goto L152;
        DownloadSetting r34 = this.setting;
        DownloadInfo r35 = this.downloadInfo;
        String r36 = this.curUrl;
        String r37 = this.curHostIp;
        String r38 = this.curHostRealIp;
        if (this.closed == false) goto L147;
    L150:
        boolean r39 = true;
    L151:
        DownloadMonitorHelper.monitorSegmentIO(r34, r35, r36, r37, r38, r39, this.httpConnection, this.failedException, r13 - r4, TimeUnit.MILLISECONDS.toNanos(this.readEndTime - this.readStartTime));
        goto L152
    L147:
        if (this.reconnect == true) goto L150;
        r39 = false;
    L152:
        r1 = this.host;
        r2 = r41;
        goto L233
    L275:
        Buffer r40 = r3.obtain();     // Catch: Throwable -> L268
        r40.size = -1;     // Catch: Throwable -> L138
        r9.write(r40);     // Catch: Throwable -> L138
    L138:
        r32 = r40;
        goto L140
    L126:
        if (r112 == Long.MAX_VALUE) goto L132;
        if (r13 > r112) goto L132;
        throw new BaseException(DownloadErrorCode.ERROR_RESPONSE_DATA_NOT_EQUALS, String.format(Locale.US, "range[%d, %d] , but readCurrent[%d] , readStart[%d]", new Object[]{Long.valueOf(r4), Long.valueOf(r112), Long.valueOf(r13), Long.valueOf(r4)}));     // Catch: Throwable -> L164 BaseException -> L166
    L109:
        r9.write(r15);     // Catch: Throwable -> L160 BaseException -> L162
        r31 = 0;
        r9 = null;
    L162:
        e = e;
    L160:
        th = th;
        r2 = r41;
    L166:
        e = e;
    L164:
        th = th;
    L165:
        r2 = r41;
    L210:
        r15 = null;
        goto L211
    L269:
        monitor-enter(this);     // Catch: Throwable -> L101 BaseException -> L103
        this.threadDirty = r8;     // Catch: Throwable -> L95
        if (this.reconnect == true) goto L94;
        if (this.closed == true) goto L94;
        monitor-exit(this);     // Catch: Throwable -> L95
        ISegmentCallback r113 = this.host;     // Catch: Throwable -> L101 BaseException -> L103
        monitor-enter(r113);     // Catch: Throwable -> L101 BaseException -> L103
    L86:
        th = th;
    L88:
        monitor-exit(r113);     // Catch: Throwable -> L90
    L90:
        th = th;
        goto L88
    L89:
        throw th;     // Catch: Throwable -> L164 BaseException -> L166
    L63:
        if (this.segmentNewEndOffset != 0) goto L65;
        r4 = r4;
    L84:
        monitor-exit(r113);     // Catch: Throwable -> L90
        goto L305
    L65:
        if (Logger.debug() == false) goto L70;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "loopAndRead", "Change readEnd = " + r112 + ", segmentNewEndOffset = " + this.segmentNewEndOffset + ", segment = " + r2);     // Catch: Throwable -> L90
        goto L70
    L311:
        th = th;
    L70:
        r112 = refreshSegmentEndOffset();     // Catch: Throwable -> L90
        if (r13 <= r112) goto L84;
        long r42 = r112 + 1;     // Catch: Throwable -> L90
        long r43 = r13 - r42;     // Catch: Throwable -> L90
        if (r43 <= 0) goto L281;
        Logger.taskError(TAG, this.downloadInfo.getId(), "loopAndRead", "redundant: " + r43);     // Catch: Throwable -> L90
    L281:
        this.curSegmentReadOffset = r42;     // Catch: Throwable -> L80
        monitor-exit(r113);     // Catch: Throwable -> L80
        r13 = r42;
        r112 = r112;
    L80:
        th = th;
        goto L88
    L94:
        throw new StreamClosedException("loopAndRead");     // Catch: Throwable -> L99
    L95:
        th = th;
    L97:
        monitor-exit(this);     // Catch: Throwable -> L99
        throw th;     // Catch: Throwable -> L164 BaseException -> L166
    L99:
        th = th;
    L103:
        e = e;
    L101:
        th = th;
        r4 = r4;
        goto L165
    L170:
        e = e;
    L168:
        th = th;
        r4 = r4;
    L174:
        e = e;
    L172:
        th = th;
        r4 = r4;
        goto L211
    L178:
        e = e;
    L176:
        th = th;
        r4 = r4;
        r13 = r4;
        goto L211
    L195:
        throw new DownloadRetryNeedlessException(1004, "the content-length is 0, contentLength = " + r11);     // Catch: Throwable -> L204 BaseException -> L206
    L199:
        e = e;
    L196:
        th = th;
        r4 = r4;
    L198:
        r13 = r4;
        r9 = null;
        goto L210
    L203:
        throw new BaseException(DownloadErrorCode.ERROR_NETWORK_NO_INPUT_STREAM, new IOException("inputStream is null"));     // Catch: Throwable -> L204 BaseException -> L206
    L206:
        e = e;
    L204:
        th = th;
        goto L198
    L243:
        th = move-exception;
        DownloadUtils.safeClose(new Closeable[]{r10});
        if (r9 == null) goto L250;
        if (r15 == null) goto L277;
    L248:
        r15.size = -1;     // Catch: Throwable -> L266
        r9.write(r15);     // Catch: Throwable -> L266
        Buffer r44 = null;
    L251:
        if (r44 == null) goto L253;
        r3.recycle(r44);
    L253:
        this.readEndTime = System.currentTimeMillis();
        if (r13 <= r4) goto L263;
        DownloadSetting r45 = this.setting;
        DownloadInfo r46 = this.downloadInfo;
        String r47 = this.curUrl;
        String r48 = this.curHostIp;
        String r49 = this.curHostRealIp;
        if (this.closed == false) goto L258;
    L261:
        boolean r310 = true;
    L262:
        DownloadMonitorHelper.monitorSegmentIO(r45, r46, r47, r48, r49, r310, this.httpConnection, this.failedException, r13 - r4, TimeUnit.MILLISECONDS.toNanos(this.readEndTime - this.readStartTime));
        goto L263
    L258:
        if (this.reconnect == true) goto L261;
        r310 = false;
    L263:
        this.host.unApplySegment(this, r2);
        throw th;
    L277:
        r15 = r3.obtain();     // Catch: Throwable -> L266
    L250:
        r44 = r15;
    L238:
        e = e;
    L208:
        th = th;
        r4 = r4;
        r13 = r4;
        r9 = null;
        r10 = null;
        goto L210
    }

    private Buffer probeFirstBuffer(IBufferPool r5, InputStream r6) {
        IBufferPool r4 = (IBufferPool) ZeusTransformUtils.wrapperContextForParams(r5, IBufferPool.class, "com.obric.aiagent.plugin");
        Buffer r7 = r4.obtain();
        int r8 = r6.read(r7.data);     // Catch: Throwable -> L13
        if (r8 == (-1)) goto L12;
        r7.size = r8;     // Catch: Throwable -> L9
        if (r8 != (-1)) goto L8;
        r4.recycle(r7);
    L8:
        return r7;
    L12:
        throw new BaseException(DownloadErrorCode.ERROR_PROBE_FIRST_BUFFER, "probe");     // Catch: Throwable -> L9
    L9:
        th = th;
    L15:
        if (r8 != (-1)) goto L17;
        r4.recycle(r7);
    L17:
        throw th;
    L13:
        th = th;
        r8 = -1;
        goto L15
    }

    private long refreshSegmentEndOffset() {
        long r0 = this.segmentNewEndOffset;
        this.segmentNewEndOffset = 0;
        if (r0 > 0) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r0;
    }

    public boolean adjustSegmentEndOffset(long r7) {
        long r0 = this.endOffsetInConnection;
        if (r7 > 0) goto L8;
        if (r0 <= 0) goto L8;
        return false;
    L8:
        if (r7 > r0) goto L10;
    L12:
        this.segmentNewEndOffset = r7;
        this.threadDirty = true;
        return true;
    L10:
        if (r0 <= 0) goto L12;
        return false;
    }

    void updateReadBytes() {
        UrlRecord r0 = this.urlRecord;
        ISegmentCallback r1 = this.host;     // Catch: Throwable -> L15
        monitor-enter(r1);     // Catch: Throwable -> L15
        long r2 = getReadingBytes();     // Catch: Throwable -> L11
        if (r2 <= 0) goto L8;
        this.readBytes += r2;     // Catch: Throwable -> L11
        r0.increaseDownloadBytes(r2);     // Catch: Throwable -> L11
    L8:
        this.curSegmentReadOffset = -1;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        goto L19
    L14:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    }

    public long getReadBytes() {
        ISegmentCallback r0 = this.host;
        monitor-enter(r0);
        long r1 = this.readBytes + getReadingBytes();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long getReadingBytes() {
        ISegmentCallback r0 = this.host;
        monitor-enter(r0);
        long r1 = this.curSegmentReadOffset;     // Catch: Throwable -> L13
        long r3 = this.startOffsetInConnection;     // Catch: Throwable -> L13
        if (r3 >= 0) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return 0;
    L7:
        if (r1 <= r3) goto L11;
        long r2 = r1 - r3;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    public long getCurSegmentReadOffset() {
        return this.curSegmentReadOffset;
    }

    public void close() {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "close", "ThreadIndex: " + this.threadIndex);
    L5:
        monitor-enter(this);
        this.closed = true;     // Catch: Throwable -> L17
        this.threadDirty = true;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        closeConnection();
        Future r1 = this.future;
        if (r1 == null) goto L24;
        this.future = null;
        r1.cancel(true);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L24:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void reconnect() {
        reconnect(false);
    }

    public void reconnect(boolean r6) {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "reconnect", "ThreadIndex: " + this.threadIndex);
    L5:
        monitor-enter(this);
        this.changeSegment = r6;     // Catch: Throwable -> L15
        this.reconnect = true;     // Catch: Throwable -> L15
        this.threadDirty = true;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        closeConnection();
        Thread r7 = this.thread;
        if (r7 == null) goto L23;
        if (Logger.debug() == false) goto L13;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "reconnect", "Interrupt ThreadIndex: " + this.threadIndex);     // Catch: Throwable -> L18
    L13:
        r7.interrupt();     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L23:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    void setFuture(Future r3) {
        this.future = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.aiagent.plugin");
    }

    void setFailed(boolean r1) {
        this.failed = r1;
    }

    boolean isFailed() {
        return this.failed;
    }

    public boolean isExited() {
        return this.exited;
    }

    public void setExited(boolean r1) {
        this.exited = r1;
    }

    BaseException getFailedException() {
        return this.failedException;
    }

    void markProgress(long r7) {
        long r0 = this.curSegmentReadOffset;
        DownloadStenographer r2 = this.stenographer;
        if (r0 < 0) goto L11;
        if (r2 != null) goto L7;
        return;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "markProgress", "CurSegmentReadOffset = " + r0 + ", threadIndex = " + this.threadIndex);
    L9:
        r2.markProgress(r0, r7);
        return;
    }

    long getRecentDownloadSpeed(long r1, long r3) {
        DownloadStenographer r0 = this.stenographer;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getRecentDownloadSpeed(r1, r3);
    }

    long getCurSegmentDownloadSpeed(long r8) {
        long r0 = this.readStartTime;
        if (r0 > 0) goto L5;
        return -1;
    L5:
        long r9 = r8 - r0;
        if (r9 > 0) goto L8;
        return -1;
    L8:
        long r1 = this.curSegmentReadOffset;
        long r4 = this.startOffsetInConnection;
        if (r4 >= 0) goto L11;
    L14:
        return 0;
    L11:
        if (r1 < r4) goto L14;
        return (r1 - r4) / r9;
    }

    long getStartOffsetInConnection() {
        return this.startOffsetInConnection;
    }
}

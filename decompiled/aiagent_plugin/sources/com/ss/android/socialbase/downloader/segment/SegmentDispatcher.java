package com.ss.android.socialbase.downloader.segment;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.DownloadDnsManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SegmentDispatcher implements DownloadDnsManager.Callback, ISegmentCallback {
    private static final int READ_WATCH_TIME = 2000;
    private static final String TAG = "SegmentDispatcher";
    private volatile boolean allReaderFailed;
    private final BufferQueue bufferQueue;
    private volatile boolean canceled;
    private long connectTimeout;
    private final DownloadWatchDog.IWatcher connectWatcher;
    private final boolean debug;
    private final List<Segment> dispatchedSegments;
    private final DownloadInfo downloadInfo;
    private final DownloadTask downloadTask;
    private BaseException failedException;
    private HttpResponse firstBackupUrlHttpResponse;
    private final Object firstConnectionLock;
    private final IDownloadRunnableCallback hostCallback;
    private volatile boolean isAllContentDownloaded;
    private long lastReconnectTime;
    private HttpResponse mainUrlHttpResponse;
    private volatile boolean needWaitDnsResolve;
    private volatile boolean paused;
    private float poorSpeedRatio;
    private long readTimeout;
    private final DownloadWatchDog.IWatcher readWatcher;
    private final List<SegmentReader> readers;
    private int reconnectCount;
    private final DownloadStenographer stenographer;
    private final SegmentStrategy strategy;
    private final LinkedList<Segment> toDispatchSegments;
    private long totalLength;
    private int urlIndex;
    private final List<UrlRecord> urlRecords;
    private final DownloadWatchDog watchDog;
    private final MultiSegmentWriter writer;

    static /* synthetic */ boolean access$000(SegmentDispatcher r0) {
        return r0.canceled;
    }

    static /* synthetic */ boolean access$100(SegmentDispatcher r0) {
        return r0.paused;
    }

    static /* synthetic */ HttpResponse access$200(SegmentDispatcher r0) {
        return r0.mainUrlHttpResponse;
    }

    static /* synthetic */ HttpResponse access$300(SegmentDispatcher r0) {
        return r0.firstBackupUrlHttpResponse;
    }

    static /* synthetic */ long access$400(SegmentDispatcher r2) {
        return r2.connectTimeout;
    }

    static /* synthetic */ SegmentReader access$500(SegmentDispatcher r0, boolean r1, long r2, long r4) {
        return r0.findEarliestConnectTimeoutReader(r1, r2, r4);
    }

    static /* synthetic */ DownloadInfo access$600(SegmentDispatcher r0) {
        return r0.downloadInfo;
    }

    static /* synthetic */ boolean access$700(SegmentDispatcher r0, SegmentReader r1) {
        return r0.trySwitchNextUrlForReader(r1);
    }

    static /* synthetic */ List access$800(SegmentDispatcher r0) {
        return r0.urlRecords;
    }

    static /* synthetic */ long access$900(SegmentDispatcher r2) {
        return r2.scheduleWatchRead();
    }

    public SegmentDispatcher(DownloadTask r4, DownloadInfo r5, SegmentStrategy r6, IDownloadRunnableCallback r7) {
        IDownloadRunnableCallback r8 = (IDownloadRunnableCallback) ZeusTransformUtils.wrapperContextForParams(r7, IDownloadRunnableCallback.class, "com.obric.aiagent.plugin");
        boolean r0 = false;
        this.canceled = false;
        this.paused = false;
        this.readers = new ArrayList();
        this.urlRecords = new ArrayList();
        this.needWaitDnsResolve = true;
        this.toDispatchSegments = new LinkedList();
        this.dispatchedSegments = new ArrayList();
        this.firstConnectionLock = new Object();
        this.allReaderFailed = false;
        this.connectWatcher = new AnonymousClass1(this);
        this.readWatcher = new AnonymousClass2(this);
        this.downloadTask = r4;
        this.downloadInfo = r5;
        this.strategy = r6;
        BufferQueue r9 = new BufferQueue(r6.getBufferCount(), r6.getBufferSize());
        this.bufferQueue = r9;
        this.hostCallback = r8;
        this.writer = new MultiSegmentWriter(r5, r8, r9);
        this.watchDog = new DownloadWatchDog();
        this.stenographer = new DownloadStenographer();
        if (DownloadSetting.obtain(r5.getId()).optInt("debug") != 1) goto L5;
        r0 = true;
    L5:
        this.debug = r0;
    }

    public boolean downloadSegments(List<Segment> r8) {
        List<Segment> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        initUrlRecords();     // Catch: Throwable -> L34
        initSegments(r9);     // Catch: Throwable -> L34
        dispatchReadThread();     // Catch: Throwable -> L34
        initWatchDog();     // Catch: Throwable -> L34
        initDns();     // Catch: Throwable -> L34
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L34
        waitFirstConnection();     // Catch: Throwable -> L31
        long r5 = System.currentTimeMillis() - r3;     // Catch: Throwable -> L34
        this.downloadInfo.increaseAllConnectTime(r5);     // Catch: Throwable -> L34
        this.downloadInfo.setFirstSpeedTime(r5);     // Catch: Throwable -> L34
        if (this.paused == true) goto L22;
        if (this.canceled == true) goto L22;
        initWatchDog2();     // Catch: Throwable -> L34
        writeSegments();     // Catch: Throwable -> L34
        if (this.paused == false) goto L14;
    L19:
        this.watchDog.release();
        return true;
    L14:
        if (this.canceled == true) goto L19;
        if (Logger.debug() == false) goto L18;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "downloadSegments", "Finally pause");
    L18:
        pause();
    L22:
        if (this.paused == false) goto L24;
    L29:
        this.watchDog.release();
        return true;
    L24:
        if (this.canceled == true) goto L29;
        if (Logger.debug() == false) goto L28;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "downloadSegments", "Finally pause");
    L28:
        pause();
        goto L29
    L31:
        th = move-exception;
        long r6 = System.currentTimeMillis() - r3;     // Catch: Throwable -> L34
        this.downloadInfo.increaseAllConnectTime(r6);     // Catch: Throwable -> L34
        this.downloadInfo.setFirstSpeedTime(r6);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        if (this.paused == false) goto L38;
    L43:
        this.watchDog.release();
        throw th;
    L38:
        if (this.canceled == true) goto L43;
        if (Logger.debug() == false) goto L42;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "downloadSegments", "Finally pause");
    L42:
        pause();
        goto L43
    }

    private void initSegments(List<Segment> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        long r0 = this.downloadInfo.getTotalBytes();
        this.totalLength = r0;
        if (r0 > 0) goto L7;
        this.totalLength = this.downloadInfo.getExpectFileLength();
        if (Logger.debug() == false) goto L7;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "initSegments", "GetExpectFileLength: " + this.totalLength);
    L7:
        monitor-enter(this);
        this.toDispatchSegments.clear();     // Catch: Throwable -> L32
        if (r11 != null) goto L11;
    L18:
        long r4 = this.downloadInfo.getStartOffset();     // Catch: Throwable -> L32
        long r6 = this.downloadInfo.getEndOffset();     // Catch: Throwable -> L32
        if (r4 >= 0) goto L22;
        r4 = 0;
    L22:
        if (r6 > 0) goto L24;
    L26:
        arrangeSegmentLocked(this.toDispatchSegments, new Segment(r4, r6), false);     // Catch: Throwable -> L32
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "initSegments", "TotalLength: " + this.totalLength);     // Catch: Throwable -> L32
    L30:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L24:
        if (r6 >= r4) goto L26;
        Logger.taskError(TAG, this.downloadInfo.getId(), "initSegments", "DownloadInfo.getEndOffset invalid, start = " + r4 + ", end = " + r6);     // Catch: Throwable -> L32
        r6 = -1;
        goto L26
    L11:
        if (r11.isEmpty() == true) goto L18;
        Iterator r12 = r11.iterator();     // Catch: Throwable -> L32
    L15:
        if (r12.hasNext() == false) goto L17;
        arrangeSegmentLocked(this.toDispatchSegments, new Segment((Segment) ZeusTransformUtils.preCheckCast(r12.next(), Segment.class, "com.obric.aiagent.plugin")), false);     // Catch: Throwable -> L32
        goto L15
    L17:
        fixSegmentsLocked(this.toDispatchSegments);     // Catch: Throwable -> L32
        checkDownloadedBytesLocked(this.toDispatchSegments);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    private void waitFirstConnection() {
        Object r0 = this.firstConnectionLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mainUrlHttpResponse == null) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L19
        if (this.mainUrlHttpResponse == null) goto L13;
        return;
    L13:
        if (this.firstBackupUrlHttpResponse != null) goto L24;
        BaseException r2 = this.failedException;
        if (r2 == null) goto L25;
        throw r2;
    L25:
        return;
    L24:
        return;
    L7:
        if (this.firstBackupUrlHttpResponse != null) goto L9;
        this.firstConnectionLock.wait();     // Catch: Throwable -> L19
        goto L9
    }

    private void writeSegments() {
        this.writer.loopAndWrite(this.bufferQueue);     // Catch: BaseException -> L4 StreamClosedException -> L41
    L4:
        e = move-exception;
        Logger.taskError(TAG, this.downloadInfo.getId(), "writeSegments", "DispatchSegments: loopAndWrite e = " + e);
        onError(e);
        throw e;
    L8:
        if (this.paused == false) goto L10;
        return;
    L10:
        if (this.canceled == true) goto L56;
        monitor-enter(this);     // Catch: Throwable -> L25
    L42:
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L14:
        if (this.toDispatchSegments.isEmpty() == true) goto L19;
        Segment r0 = (Segment) ZeusTransformUtils.preCheckCast(this.toDispatchSegments.poll(), Segment.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r0 == null) goto L42;
        arrangeSegmentLocked(this.dispatchedSegments, r0, true);     // Catch: Throwable -> L22
        goto L42
    L19:
        checkDownloadedBytesLocked(this.dispatchedSegments);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
    L28:
        if (this.allReaderFailed == false) goto L35;
        if (this.failedException == null) goto L35;
        Logger.taskError(TAG, this.downloadInfo.getId(), "writeSegments", "DispatchSegments: failedException = " + this.failedException);
        throw this.failedException;
    L35:
        if (this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes()) goto L38;
        DownloadMonitorHelper.monitorSegmentsError(this.downloadInfo, this.dispatchedSegments);
    L38:
        if (Logger.debug() == false) goto L55;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "writeSegments", "DispatchSegments::download finished");
        return;
    L55:
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
        goto L28
    }

    private void checkDownloadedBytesLocked(List<Segment> r7) {
        long r0 = SegmentUtils.getDownloadedBytes((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin"));
        if (Logger.debug() == false) goto L6;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "checkDownloadedBytesLocked", "GetCurBytes = " + this.downloadInfo.getCurBytes() + ", totalBytes = " + this.downloadInfo.getTotalBytes() + ", downloadedBytes = " + r0);
    L6:
        if (r0 <= this.downloadInfo.getTotalBytes()) goto L11;
        if (this.downloadInfo.getTotalBytes() <= 0) goto L11;
        r0 = this.downloadInfo.getTotalBytes();
    L11:
        if (this.downloadInfo.getCurBytes() != this.downloadInfo.getTotalBytes()) goto L13;
        return;
    L13:
        if (this.downloadInfo.getCurBytes() == r0) goto L17;
        this.downloadInfo.setCurBytes(r0);
        return;
    }

    private void dispatchReadThread() {
        int r1 = 1;
        if (this.totalLength > 0) goto L5;
    L10:
        int r0 = 1;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "dispatchReadThread", "TotalLength = " + this.totalLength + ", threadCount = " + r0);
    L14:
        if (r0 <= 0) goto L17;
        r1 = r0;
    L17:
        monitor-enter(this);
    L35:
    L32:
        th = move-exception;
        throw th;
    L19:
        if (this.readers.size() >= r1) goto L30;
        if (this.paused == true) goto L28;
        if (this.canceled == true) goto L28;
        dispatchReadThreadOnce(obtainUrl());     // Catch: Throwable -> L32
        if (this.strategy.segmentOneByOne() == false) goto L35;
    L28:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L30:
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L5:
        if (this.needWaitDnsResolve == true) goto L10;
        r0 = this.strategy.getThreadCount();
        int r2 = (int) (this.totalLength / this.strategy.getSegmentMinInitSize());
        if (r0 <= r2) goto L12;
        r0 = r2;
        goto L12
    }

    private void initUrlRecords() {
        this.urlRecords.add(new UrlRecord(this.downloadInfo.getUrl(), true));
        List<String> r0 = this.downloadInfo.getBackUpUrls();
        if (r0 == null) goto L10;
        Iterator<String> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.urlRecords.add(new UrlRecord(r2, false));
    L10:
        this.strategy.updateUrlCount(this.urlRecords.size());
    }

    private void initWatchDog() {
        SegmentStrategy r0 = this.strategy;
        this.connectTimeout = r0.getConnectTimeout();
        this.readTimeout = r0.getReadTimeout();
        this.poorSpeedRatio = r0.getPoorSpeedRatio();
        int r1 = this.reconnectCount;
        if (r1 <= 0) goto L6;
        this.watchDog.addWatcher(this.connectWatcher, r1);
        return;
    }

    private void initWatchDog2() {
        if (this.readTimeout <= 0) goto L6;
        this.lastReconnectTime = System.currentTimeMillis();
        this.watchDog.addWatcher(this.readWatcher, 0);
        return;
    }

    private void initDns() {
        int r0 = this.strategy.getIpStrategy();
        if (r0 > 0) goto L6;
        this.needWaitDnsResolve = false;
        dispatchReadThread();
        return;
    L6:
        DownloadDnsManager r1 = DownloadDnsManager.getInstance();
        r1.resolveDnsAsync(this.downloadInfo.getUrl(), this, 2000);
        if (r0 <= 2) goto L16;
        List<String> r2 = this.downloadInfo.getBackUpUrls();
        if (r2 == null) goto L22;
        Iterator<String> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L23;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r4) == true) goto L12;
        r1.resolveDnsAsync(r4, this, 2000);
        goto L12
    L23:
        return;
    L22:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback
    public void onDnsResolved(String r3, List<InetAddress> r4) {
        List<InetAddress> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (this.paused == false) goto L5;
        return;
    L5:
        if (this.canceled == true) goto L29;
        List<UrlRecord> r0 = null;
        r0 = assembleIpAddress(r3, r5);     // Catch: Throwable -> L10
    L12:
        monitor-enter(this);
        if (r0 != null) goto L27;
    L15:
        this.needWaitDnsResolve = false;     // Catch: Throwable -> L21
        this.strategy.updateUrlCount(this.urlRecords.size());     // Catch: Throwable -> L21
        if (Logger.debug() == false) goto L18;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "onDnsResolved", "DispatchReadThread");     // Catch: Throwable -> L21
    L18:
        dispatchReadThread();     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L27:
        addIpListLocked(r3, r0);     // Catch: Throwable -> L21
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }

    private void addIpListLocked(String r7, List<UrlRecord> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (this.debug == false) goto L10;
        Iterator r0 = r9.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        UrlRecord r2 = (UrlRecord) ZeusTransformUtils.preCheckCast(r0.next(), UrlRecord.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "addIpListLocked", "UrlRecord: " + r2);
    L10:
        int r1 = this.strategy.getIpStrategy();
        if (r1 != 1) goto L13;
    L14:
        int r10 = indexOfUrl(r7);
        if (r10 >= 0) goto L17;
    L20:
        this.urlRecords.addAll(r9);
        return;
    L17:
        if (r10 >= this.urlRecords.size()) goto L20;
        this.urlRecords.addAll(r10 + 1, r9);
        return;
    L13:
        if (r1 != 3) goto L20;
        goto L14
    }

    private int indexOfUrl(String r6) {
        int r0 = this.urlRecords.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (TextUtils.equals(((UrlRecord) ZeusTransformUtils.preCheckCast(this.urlRecords.get(r1), UrlRecord.class, "com.obric.aiagent.plugin")).url, r6) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    private List<UrlRecord> assembleIpAddress(String r11, List<InetAddress> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L5;
    L36:
        return null;
    L5:
        if (r13.isEmpty() == true) goto L36;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r14 = r13.iterator();
        int r4 = 0;
    L9:
        if (r14.hasNext() == false) goto L23;
        InetAddress r5 = (InetAddress) ZeusTransformUtils.preCheckCast(r14.next(), InetAddress.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        String r6 = r5.getHostAddress();
        if (TextUtils.isEmpty(r6) == true) goto L9;
        if (this.debug == true) goto L17;
    L19:
        UrlRecord r7 = new UrlRecord(r11, r6);
        LinkedList r8 = (LinkedList) ZeusTransformUtils.preCheckCast(r2.get(r7.ipFamily), LinkedList.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L22;
        r8 = new LinkedList();
        r2.put(r7.ipFamily, r8);
    L22:
        r8.add(r7);
        r4 = r4 + 1;
        goto L9
    L17:
        if (Logger.debug() == false) goto L19;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "assembleIpAddress", "Ip: " + r6);
        goto L19
    L23:
        if (r4 <= 0) goto L36;
        ArrayList r10 = new ArrayList();
    L25:
        Iterator r15 = r2.entrySet().iterator();
        boolean r16 = false;
    L27:
        if (r15.hasNext() == false) goto L33;
        LinkedList r0 = (LinkedList) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), LinkedList.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L27;
        if (r0.isEmpty() == true) goto L27;
        r10.add((UrlRecord) ZeusTransformUtils.preCheckCast(r0.pollFirst(), UrlRecord.class, "com.obric.aiagent.plugin"));
        r4 = r4 - 1;
        r16 = true;
        goto L27
    L33:
        if (r4 <= 0) goto L35;
        if (r16 == true) goto L25;
    L35:
        return r10;
    }

    private UrlRecord obtainUrl() {
        monitor-enter(this);
        int r0 = this.urlIndex % this.urlRecords.size();     // Catch: Throwable -> L9
        if (this.strategy.urlBalance() == false) goto L6;
        this.urlIndex++;     // Catch: Throwable -> L9
    L6:
        UrlRecord r1 = (UrlRecord) ZeusTransformUtils.preCheckCast(this.urlRecords.get(r0), UrlRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    private void switchToNextUrl() {
        monitor-enter(this);
        this.urlIndex++;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void arrangeSegmentLocked(List<Segment> r7, Segment r8, boolean r9) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        long r1 = r8.getStartOffset();
        int r10 = r6.size();
        int r3 = 0;
    L3:
        if (r3 >= r10) goto L7;
        if (r1 < ((Segment) ZeusTransformUtils.preCheckCast(r6.get(r3), Segment.class, "com.obric.aiagent.plugin")).getStartOffset()) goto L7;
        r3 = r3 + 1;
    L7:
        r6.add(r3, r8);
        if (r9 == false) goto L13;
        r8.setIndex(r10);
        return;
    }

    private void fixSegmentsLocked(List<Segment> r19) {
        List<Segment> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        Segment r3 = (Segment) ZeusTransformUtils.preCheckCast(r1.get(0), Segment.class, "com.obric.aiagent.plugin");
        long r4 = this.downloadInfo.getStartOffset();
        if (r4 >= 0) goto L5;
        r4 = 0;
    L5:
        long r8 = r3.getStartOffset();
        String r12 = "fixSegmentsLocked";
        if (r8 <= r4) goto L11;
        Segment r10 = new Segment(r4, r8 - 1);
        if (Logger.debug() == false) goto L10;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "fixSegmentsLocked", "First = " + r3 + ", add new first = " + r10);
    L10:
        arrangeSegmentLocked(r1, r10, true);
    L11:
        Iterator<Segment> r5 = r1.iterator();
        if (r5.hasNext() == false) goto L25;
        Segment r6 = (Segment) ZeusTransformUtils.preCheckCast(r5.next(), Segment.class, "com.obric.aiagent.plugin");
    L15:
        if (r5.hasNext() == false) goto L25;
        Segment r7 = (Segment) ZeusTransformUtils.preCheckCast(r5.next(), Segment.class, "com.obric.aiagent.plugin");
        if (r6.getEndOffset() < (r7.getStartOffset() - 1)) goto L19;
        String r11 = r12;
    L24:
        r6 = r7;
        r12 = r11;
        goto L15
    L19:
        if (Logger.debug() == false) goto L21;
        r11 = r12;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), r11, "Segment = " + r6 + ", new end = " + (r7.getStartOffset() - 1));
    L22:
        r6.setEndOffset(r7.getStartOffset() - 1);
        goto L24
    L21:
        r11 = r12;
    L25:
        String r13 = r12;
        Segment r2 = (Segment) ZeusTransformUtils.preCheckCast(r1.get(r1.size() - 1), Segment.class, "com.obric.aiagent.plugin");
        long r9 = this.downloadInfo.getEndOffset();
        if (r9 > 0) goto L28;
    L31:
        long r14 = this.downloadInfo.getTotalBytes();
        if (r14 <= 0) goto L38;
        if (r2.getEndOffset() != (-1)) goto L36;
        return;
    L36:
        if (r2.getEndOffset() < (r14 - 1)) goto L38;
        return;
    L38:
        if (Logger.debug() == false) goto L40;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), r13, "Last segment = " + r2 + ", new end=-1");
    L40:
        r2.setEndOffset(-1);
        return;
    L28:
        if (r9 <= r4) goto L31;
        r2.setEndOffset(r9);
    }

    private void dispatchReadThreadOnce(UrlRecord r9) {
        SegmentReader r7 = new SegmentReader(this.downloadTask, this.downloadInfo, this, this.bufferQueue, r9, this.readers.size());
        this.readers.add(r7);
        r7.setFuture(DownloadComponentManager.getChunkDownloadThreadExecutorService().submit(r7));
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onReaderRun(SegmentReader r3) {
        if (this.debug == true) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "onReaderRun", "ThreadIndex = " + r3.threadIndex);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public Segment obtainSegment(SegmentReader r2, UrlRecord r3) {
        if (this.canceled == false) goto L5;
        return null;
    L5:
        if (this.paused == true) goto L23;
        monitor-enter(this);
        Segment r4 = obtainSegmentLocked(r2, r3);     // Catch: Throwable -> L17
        if (r4 == null) goto L15;
        r4.increaseCompetitor();     // Catch: Throwable -> L17
        if (r4.getCompetitor() <= 1) goto L15;
        Segment r5 = new Segment(r4);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return r5;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return r4;
    L17:
        th = move-exception;
        throw th;
    L23:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void unObtainSegment(SegmentReader r1, Segment r2) {
        monitor-enter(this);
        r2.decreaseCompetitor();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private Segment obtainSegmentLocked(SegmentReader r7, UrlRecord r8) {
    L3:
        if (this.toDispatchSegments.isEmpty() == true) goto L12;
        Segment r0 = (Segment) ZeusTransformUtils.preCheckCast(this.toDispatchSegments.poll(), Segment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L3;
        arrangeSegmentLocked(this.dispatchedSegments, r0, true);
        if (getRemainReadBytes(r0) > 0) goto L11;
        if (this.totalLength > 0) goto L3;
    L11:
        return r0;
    L12:
        clearCoveredSegmentLocked();
        Segment r9 = obtainChildSegmentFromMaxRemain(r7, r8);
        if (r9 != null) goto L15;
    L18:
        Segment r6 = obtainSegmentWhenNoNewSegment();
        if (r6 == null) goto L21;
        return r6;
    L21:
        return null;
    L15:
        if (getRemainReadBytes(r9) <= 0) goto L18;
        arrangeSegmentLocked(this.dispatchedSegments, r9, true);
        return r9;
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentConnected(SegmentReader r3, Segment r4, UrlRecord r5, HttpResponse r6) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.canceled == true) goto L19;
        if (this.paused == true) goto L19;
        checkSegmentHttpResponseLocked(r3, r4, r5, r6);     // Catch: Throwable -> L20
        r3.setFailed(false);     // Catch: Throwable -> L20
        if (this.totalLength > 0) goto L14;
        long r7 = this.downloadInfo.getTotalBytes();     // Catch: Throwable -> L20
        this.totalLength = r7;     // Catch: Throwable -> L20
        if (r7 > 0) goto L12;
        this.totalLength = r6.getTotalLength();     // Catch: Throwable -> L20
    L12:
        dispatchReadThread();     // Catch: Throwable -> L20
    L16:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L14:
        if (this.strategy.segmentOneByOne() == false) goto L16;
        dispatchReadThread();     // Catch: Throwable -> L20
    L19:
        throw new StreamClosedException("connected");     // Catch: Throwable -> L20
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void applySegment(SegmentReader r1, Segment r2) {
        monitor-enter(this);
        applySegmentLocked(r1, r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void unApplySegment(SegmentReader r6, Segment r7) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r7.owner == r6) goto L6;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "unApplySegment", "Segment: " + r7);     // Catch: Throwable -> L11
    L8:
        r7.setCurrentOffsetRead(r6.getCurSegmentReadOffset());     // Catch: Throwable -> L11
        r7.owner = null;     // Catch: Throwable -> L11
        r6.updateReadBytes();     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public IOutput createOutput(SegmentReader r3, Segment r4) {
        monitor-enter(this);
        SegmentOutput r5 = new SegmentOutput(this.downloadInfo, this.bufferQueue, r4);     // Catch: Throwable -> L6
        this.writer.assignOutput(r5);     // Catch: Throwable -> L6
        IOutput r6 = r5.getStub();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public boolean onSegmentRetry(SegmentReader r3, UrlRecord r4, Segment r5, BaseException r6, int r7, int r8) {
        int r9 = r6.getErrorCode();
        boolean r10 = false;
        if (r9 != 1083) goto L7;
        onError(r6);
        return false;
    L7:
        if (r9 != 1047) goto L9;
    L12:
        r10 = true;
    L14:
        if (DownloadHelper.isResponseCodeError(r6) == false) goto L16;
        r10 = true;
    L16:
        if (r10 == true) goto L18;
        if (r7 >= r8) goto L18;
    L19:
        return true;
    L18:
        trySwitchNextUrlForReader(r3);
        goto L19
    L9:
        if (r9 == 1074) goto L12;
        if (r9 != 1055) goto L14;
        goto L12
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentFailed(SegmentReader r5, UrlRecord r6, Segment r7, BaseException r8) {
        monitor-enter(this);
        Logger.taskError(TAG, this.downloadInfo.getId(), "onSegmentFailed", "Segment: " + r7 + " e:" + r8);     // Catch: Throwable -> L14
        r5.setFailed(true);     // Catch: Throwable -> L14
        if (r5.threadIndex != 0) goto L7;
        this.failedException = r8;     // Catch: Throwable -> L14
    L7:
        if (isAllReaderFailedLocked() == true) goto L9;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L9:
        if (this.failedException != null) goto L11;
        this.failedException = r8;     // Catch: Throwable -> L14
    L11:
        this.allReaderFailed = true;     // Catch: Throwable -> L14
        onError(this.failedException);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onReaderExit(SegmentReader r6) {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "onReaderExit", "ThreadIndex = " + r6.threadIndex);
    L5:
        monitor-enter(this);
        r6.setExited(true);     // Catch: Throwable -> L22
        this.readers.remove(r6);     // Catch: Throwable -> L22
        clearCoveredSegmentLocked();     // Catch: Throwable -> L22
        if (this.readers.isEmpty() == false) goto L11;
        onComplete();     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L11:
        if (isAllContentDownloaded() == false) goto L20;
        if (Logger.debug() == false) goto L15;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "onReaderExit", "allContentDownloaded");     // Catch: Throwable -> L22
    L15:
        Iterator<SegmentReader> r7 = this.readers.iterator();     // Catch: Throwable -> L22
    L17:
        if (r7.hasNext() == false) goto L19;
        ((SegmentReader) ZeusTransformUtils.preCheckCast(r7.next(), SegmentReader.class, "com.obric.aiagent.plugin")).close();     // Catch: Throwable -> L22
        goto L17
    L19:
        onComplete();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private void onError(BaseException r6) {
        Logger.taskError(TAG, this.downloadInfo.getId(), "onError", "Exception: " + r6);
        this.failedException = r6;
        this.bufferQueue.close();
        monitor-enter(this);
        Iterator<SegmentReader> r7 = this.readers.iterator();     // Catch: Throwable -> L10
    L6:
        if (r7.hasNext() == false) goto L8;
        ((SegmentReader) ZeusTransformUtils.preCheckCast(r7.next(), SegmentReader.class, "com.obric.aiagent.plugin")).close();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onComplete() {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "onComplete", "Run");
    L5:
        this.bufferQueue.close();
        Object r0 = this.firstConnectionLock;
        monitor-enter(r0);
        this.firstConnectionLock.notify();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean isAllReaderFailedLocked() {
        Iterator<SegmentReader> r3 = this.readers.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((SegmentReader) ZeusTransformUtils.preCheckCast(r3.next(), SegmentReader.class, "com.obric.aiagent.plugin")).isFailed() == true) goto L4;
        return false;
    L9:
        return true;
    }

    private boolean trySwitchNextUrlForReader(SegmentReader r2) {
        monitor-enter(this);
        UrlRecord r0 = findNextUrlLocked(r2);     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        boolean r3 = r2.switchUrlRecord(r0);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r3;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    private UrlRecord findNextUrlLocked(SegmentReader r7) {
        Iterator<UrlRecord> r0 = this.urlRecords.iterator();
        UrlRecord r2 = null;
    L4:
        if (r0.hasNext() == false) goto L14;
        UrlRecord r3 = (UrlRecord) ZeusTransformUtils.preCheckCast(r0.next(), UrlRecord.class, "com.obric.aiagent.plugin");
        if (r3 == r7.urlRecord) goto L4;
        if (r3.isCurrentFailed() == true) goto L4;
        if (r2 != null) goto L12;
        r2 = r3;
    L12:
        if (r3.getCurrentUsers() > 0) goto L4;
    L16:
        if (this.strategy.urlBalance() == false) goto L22;
        if (r3 == null) goto L20;
        return r3;
    L20:
        if (this.strategy.urlBalanceStrictly() == false) goto L22;
        return null;
    L22:
        return r2;
    L14:
        r3 = null;
        goto L16
    }

    private void checkSegmentHttpResponseLocked(SegmentReader r9, Segment r10, UrlRecord r11, HttpResponse r12) {
        SegmentReader r0 = r10.owner;
        if (r0 == null) goto L9;
        if (r0 == r9) goto L9;
        throw new SegmentApplyException(1, "segment already has an owner");
    L9:
        if (r9.getStartOffsetInConnection() != r10.getCurrentOffsetRead()) goto L66;
        if (r12.acceptPartial() == false) goto L13;
    L21:
        IDownloadRunnableCallback r13 = this.hostCallback;
        if (r13 == null) goto L25;
        r13.checkMaxBytes(r12.getTotalLength(), this.downloadInfo.getMaxBytes());
    L25:
        if (r11.isMainUrl == true) goto L27;
        validateHttpResponse(r12);
        if (this.firstBackupUrlHttpResponse != null) goto L78;
        this.firstBackupUrlHttpResponse = r12;
        if (this.downloadInfo.getTotalBytes() > 0) goto L56;
        long r14 = r12.getTotalLength();
        if (Logger.debug() == false) goto L55;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "checkSegmentHttpResponseLocked", "Len=" + r14 + ",url=" + r11.url);
    L55:
        this.downloadInfo.setTotalBytes(r14);
    L56:
        Object r15 = this.firstConnectionLock;
        monitor-enter(r15);
        this.firstConnectionLock.notify();     // Catch: Throwable -> L61
        monitor-exit(r15);     // Catch: Throwable -> L61
        return;
    L61:
        th = move-exception;
        throw th;
    L78:
        return;
    L27:
        if (this.mainUrlHttpResponse != null) goto L64;
        this.mainUrlHttpResponse = r12;
        Object r16 = this.firstConnectionLock;
        monitor-enter(r16);
        this.firstConnectionLock.notify();     // Catch: Throwable -> L45
        monitor-exit(r16);     // Catch: Throwable -> L45
        IDownloadRunnableCallback r17 = this.hostCallback;
        if (r17 == null) goto L35;
        r17.handleFirstConnection(r11.url, r12.connection, r10.getCurrentOffsetRead());
    L35:
        long r18 = r12.getTotalLength();
        if (r18 <= 0) goto L77;
        Iterator<Segment> r8 = this.dispatchedSegments.iterator();
    L39:
        if (r8.hasNext() == false) goto L80;
        Segment r19 = (Segment) ZeusTransformUtils.preCheckCast(r8.next(), Segment.class, "com.obric.aiagent.plugin");
        if (r19.getEndOffset() <= 0) goto L44;
        if (r19.getEndOffset() <= (r18 - 1)) goto L39;
    L44:
        r19.setEndOffset(r18 - 1);
        goto L39
    L80:
        return;
    L77:
        return;
    L45:
        th = move-exception;
        throw th;
    L64:
        return;
    L13:
        if (r10.getCurrentOffsetRead() > 0) goto L20;
        Logger.taskError(TAG, this.downloadInfo.getId(), "checkSegmentHttpResponseLocked", "Segment.getCurrentOffsetRead = " + r10.getCurrentOffsetRead());
        if (r12.isResponseDataFromBegin() == true) goto L21;
        throw new DownloadHttpException(1004, r12.responseCode, "2: response code error : " + r12.responseCode + " segment=" + r10);
    L20:
        throw new DownloadHttpException(1004, r12.responseCode, "1: response code error : " + r12.responseCode + " segment=" + r10);
    L66:
        throw new SegmentApplyException(5, "applySegment");
    }

    private void applySegmentLocked(SegmentReader r24, Segment r25) {
        if (Logger.debug() == false) goto L6;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "start " + r25);
    L6:
        if (r25.owner != r24) goto L12;
        if (Logger.debug() == false) goto L136;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "ApplySegment:" + r24 + " is already the owner of " + r25);
        return;
    L136:
        return;
    L12:
        if (r25.owner == null) goto L14;
        Logger.taskError(TAG, this.downloadInfo.getId(), "applySegmentLocked", "ApplySegment: " + r25 + " is already has an owner:" + r25.owner);
        throw new SegmentApplyException(1, "segment already has an owner");
    L14:
        if (r24.getStartOffsetInConnection() != r25.getCurrentOffsetRead()) goto L124;
        long r8 = r25.getStartOffset();
        int r3 = indexOfSegmentLocked(r8);
        if (r3 == (-1)) goto L121;
        Segment r11 = (Segment) ZeusTransformUtils.preCheckCast(this.dispatchedSegments.get(r3), Segment.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L121;
        if (r11 != r25) goto L22;
        long r21 = r8;
    L55:
        long r6 = r25.getDownloadBytes();
        int r9 = r3 - 1;
    L57:
        if (r9 < 0) goto L90;
        Segment r12 = (Segment) ZeusTransformUtils.preCheckCast(this.dispatchedSegments.get(r9), Segment.class, "com.obric.aiagent.plugin");
        long r14 = r12.getEndOffset();
        if (r14 <= 0) goto L63;
        if (r14 >= r21) goto L63;
    L79:
        r9 = r9 - 1;
    L63:
        if (r6 > 0) goto L70;
        if (r12.getCurrentOffsetRead() <= r21) goto L70;
        Logger.taskError(TAG, this.downloadInfo.getId(), "applySegmentLocked", "Prev's current has over this start, prev = " + r12 + ", segment = " + r25);
        this.dispatchedSegments.remove(r25);
        throw new SegmentApplyException(3, "prev overstep");
    L70:
        if (r12.owner != null) goto L80;
        r12.setEndOffset(r21 - 1);
        if (Logger.debug() == false) goto L75;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "Prev set end, prev = " + r12);
    L75:
        if (r12.getDownloadBytes() <= 0) goto L79;
        if (Logger.debug() == false) goto L90;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "Break");
        goto L90
    L80:
        long r7 = r21 - 1;
        if (r12.owner.adjustSegmentEndOffset(r7) == false) goto L86;
        r12.setEndOffset(r7);
        if (Logger.debug() == false) goto L90;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "adjustSegmentEndOffset succeed, prev = " + r12);
        goto L90
    L86:
        if (Logger.debug() == false) goto L89;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "adjustSegmentEndOffset filed, prev = " + r12);
    L89:
        throw new SegmentApplyException(4, "prev end adjust fail");
    L90:
        int r4 = r3 + 1;
        int r10 = this.dispatchedSegments.size();
    L91:
        if (r4 >= r10) goto L108;
        Segment r13 = (Segment) ZeusTransformUtils.preCheckCast(this.dispatchedSegments.get(r4), Segment.class, "com.obric.aiagent.plugin");
        if (r13.getDownloadBytes() > 0) goto L98;
        if (r13.owner != null) goto L98;
        r4 = r4 + 1;
    L98:
        long r15 = r25.getEndOffset();
        long r16 = r13.getStartOffset();
        if (r15 > 0) goto L101;
    L102:
        long r17 = r16 - 1;
        r25.setEndOffset(r17);
        if (Logger.debug() == false) goto L106;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "segment set end:" + r17 + ", later = " + r13);
    L106:
        if (Logger.debug() == false) goto L108;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "Break 2");
        goto L108
    L101:
        if (r15 < r16) goto L106;
    L108:
        long r18 = r25.getEndOffset();
        if (r18 > 0) goto L111;
    L117:
        r25.owner = r24;
        if (Logger.debug() == false) goto L137;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "ApplySegment: OK " + r25);
        return;
    L137:
        return;
    L111:
        if (r21 > r18) goto L116;
        if (r25.getCurrentOffsetRead() <= r18) goto L117;
    L116:
        throw new SegmentApplyException(6, "applySegment: " + r25);
    L22:
        if (r11.getStartOffset() != r25.getStartOffset()) goto L48;
        long r19 = getRemainReadBytes(r11);
        if (r19 <= 0) goto L48;
        SegmentReader r110 = r11.owner;
        if (r110 != null) goto L28;
        r21 = r8;
    L39:
        if (r110 == null) goto L45;
        if (Logger.debug() == false) goto L43;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "Has same segment,and owner too slow, segmentInList = " + r11);
    L43:
        r110.reconnect(true);
    L47:
        r25.setEndOffset(r11.getEndOffset());
        r25.setCompetitor(r11.getCompetitor());
        this.dispatchedSegments.set(r3, r25);
        boolean r111 = true;
    L50:
        if (r111 == true) goto L55;
        Logger.taskError(TAG, this.downloadInfo.getId(), "applySegmentLocked", "ApplySegment: " + r25 + " not exist! but has another same segment, segmentInList = " + r11);
        throw new SegmentApplyException(2, "segment not exist, but has another same segment");
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "Has same segment and no owner, segmentInList = " + r11);
        goto L47
    L28:
        if (r19 >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) goto L34;
        r21 = r8;
        if ((r24.readStartTime - r110.readStartTime) <= 1000) goto L36;
        if ((r11.getCurrentOffsetRead() - r25.getCurrentOffsetRead()) < (r19 / 2)) goto L39;
    L36:
        if (Logger.debug() == false) goto L49;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "applySegmentLocked", "Has same segment, but owner is normal, abort. segmentInList = " + r11);
    L49:
        r111 = false;
        goto L50
    L34:
        r21 = r8;
    L48:
        r21 = r8;
    L121:
        Logger.taskError(TAG, this.downloadInfo.getId(), "applySegmentLocked", "ApplySegment: " + r25 + " not exist! segmentIndex = " + r3);
        throw new SegmentApplyException(2, "segment not exist");
    L124:
        throw new SegmentApplyException(5, "applySegment");
    }

    private void validateHttpResponse(HttpResponse r12) {
        HttpResponse r0 = this.mainUrlHttpResponse;
        if (r0 != null) goto L7;
        r0 = this.firstBackupUrlHttpResponse;
        if (r0 != null) goto L7;
        return;
    L7:
        long r1 = r12.getTotalLength();
        long r3 = r0.getTotalLength();
        if (r1 == r3) goto L16;
        String r5 = "Total len not equals,len=" + r1 + ",sLen=" + r3 + ",code=" + r12.responseCode + ",sCode=" + r0.responseCode + ",range=" + r12.getContentRange() + ",sRange = " + r0.getContentRange() + ",url = " + r12.url + ",sUrl=" + r0.url;
        Logger.taskError(TAG, this.downloadInfo.getId(), "validateHttpResponse", r5);
        if (r1 <= 0) goto L16;
        if (r3 <= 0) goto L16;
        throw new BaseException(DownloadErrorCode.ERROR_BAD_URL, r5);
    L16:
        String r13 = r12.getEtag();
        String r2 = r0.getEtag();
        if (TextUtils.equals(r13, r2) == true) goto L27;
        String r4 = "Etag not equals with main url, etag = " + r13 + ", mainEtag = " + r2;
        Logger.taskError(TAG, this.downloadInfo.getId(), "validateHttpResponse", r4);
        if (TextUtils.isEmpty(r13) == false) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r2) == false) goto L23;
        return;
    L23:
        if (r13.equalsIgnoreCase(r2) == false) goto L26;
        return;
    L26:
        throw new BaseException(DownloadErrorCode.ERROR_BAD_URL, r4);
    }

    public void cancel() {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "cancel", "Run");
    L5:
        this.canceled = true;
        monitor-enter(this);
        Iterator<SegmentReader> r0 = this.readers.iterator();     // Catch: Throwable -> L14
    L9:
        if (r0.hasNext() == false) goto L11;
        ((SegmentReader) ZeusTransformUtils.preCheckCast(r0.next(), SegmentReader.class, "com.obric.aiagent.plugin")).close();     // Catch: Throwable -> L14
        goto L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L14
        this.writer.cancel();
        this.bufferQueue.close();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void pause() {
        if (Logger.debug() == false) goto L5;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "pause", "Run");
    L5:
        this.paused = true;
        monitor-enter(this);
        Iterator<SegmentReader> r0 = this.readers.iterator();     // Catch: Throwable -> L14
    L9:
        if (r0.hasNext() == false) goto L11;
        ((SegmentReader) ZeusTransformUtils.preCheckCast(r0.next(), SegmentReader.class, "com.obric.aiagent.plugin")).close();     // Catch: Throwable -> L14
        goto L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L14
        this.writer.pause();
        this.bufferQueue.close();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private int indexOfSegmentLocked(long r6) {
        int r0 = this.dispatchedSegments.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        Segment r2 = (Segment) ZeusTransformUtils.preCheckCast(this.dispatchedSegments.get(r1), Segment.class, "com.obric.aiagent.plugin");
        if (r2.getStartOffset() == r6) goto L6;
        if (r2.getStartOffset() > r6) goto L16;
        r1 = r1 + 1;
        goto L3
    L16:
        return -1;
    L6:
        return r1;
    L11:
        return -1;
    }

    private void clearCoveredSegmentLocked() {
        if (this.totalLength > 0) goto L5;
        return;
    L5:
        int r0 = this.dispatchedSegments.size();
        if (r0 > 1) goto L8;
        return;
    L8:
        ArrayList r4 = null;
        int r5 = 0;
        int r6 = 1;
    L10:
        if (r6 >= r0) goto L28;
        Segment r10 = (Segment) ZeusTransformUtils.preCheckCast(this.dispatchedSegments.get(r5), Segment.class, "com.obric.aiagent.plugin");
        Segment r9 = (Segment) ZeusTransformUtils.preCheckCast(this.dispatchedSegments.get(r6), Segment.class, "com.obric.aiagent.plugin");
        if (r10.getCurrentOffsetRead() <= r9.getStartOffset()) goto L25;
        if (r9.getDownloadBytes() > 0) goto L25;
        if (r9.owner != null) goto L25;
        if (r4 != null) goto L19;
        r4 = new ArrayList(1);
    L19:
        r4.add(r9);
        if (this.debug == false) goto L27;
        if (Logger.debug() == false) goto L27;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "clearCoveredSegmentLocked", "covered = " + r9 + ", prev = " + r10);
    L27:
        r6 = r6 + 1;
    L25:
        if (r9.getCurrentOffsetRead() <= r10.getCurrentOffsetRead()) goto L27;
        r5 = r5 + 1;
        goto L27
    L28:
        if (r4 == null) goto L43;
        Iterator r1 = r4.iterator();
    L31:
        if (r1.hasNext() == false) goto L56;
        Segment r2 = (Segment) ZeusTransformUtils.preCheckCast(r1.next(), Segment.class, "com.obric.aiagent.plugin");
        this.dispatchedSegments.remove(r2);
        Iterator<SegmentReader> r3 = this.readers.iterator();
    L34:
        if (r3.hasNext() == false) goto L31;
        SegmentReader r7 = (SegmentReader) ZeusTransformUtils.preCheckCast(r3.next(), SegmentReader.class, "com.obric.aiagent.plugin");
        if (r7.curSegment != r2) goto L34;
        if (this.debug == true) goto L40;
    L42:
        r7.reconnect(true);
        goto L34
    L40:
        if (Logger.debug() == false) goto L42;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "clearCoveredSegmentLocked", "reconnect, segment = " + r2 + ", threadIndex = " + r7.threadIndex);
        goto L42
    L56:
        return;
    }

    private boolean isAllContentDownloaded() {
        long r0 = this.totalLength;
        if (r0 > 0) goto L6;
        this.isAllContentDownloaded = false;
        return false;
    L6:
        monitor-enter(this);
        long r4 = SegmentUtils.getFirstOffset(this.dispatchedSegments);     // Catch: Throwable -> L18
        if (Logger.debug() == false) goto L11;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "isAllContentDownloaded", "FirstOffset: " + r4);     // Catch: Throwable -> L18
    L11:
        if (r4 < r0) goto L15;
        this.isAllContentDownloaded = true;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return true;
    L15:
        this.isAllContentDownloaded = false;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    private Segment obtainChildSegmentFromMaxRemain(SegmentReader r31, UrlRecord r32) {
        int r2 = this.dispatchedSegments.size();
        long r3 = -1;
        int r5 = -1;
        int r6 = 0;
    L3:
        if (r6 >= r2) goto L8;
        long r7 = getUnconfirmedRemainBytes(r6, r2);
        if (r7 <= r3) goto L7;
        r5 = r6;
        r3 = r7;
    L7:
        r6 = r6 + 1;
        goto L3
    L8:
        long r8 = this.strategy.getSegmentMinSize();
        long r9 = this.strategy.getSegmentMaxSize();
        if (r5 >= 0) goto L11;
        return null;
    L11:
        if (r3 <= r8) goto L88;
        Segment r4 = (Segment) ZeusTransformUtils.preCheckCast(this.dispatchedSegments.get(r5), Segment.class, "com.obric.aiagent.plugin");
        if (this.dispatchedSegments.size() >= this.readers.size()) goto L15;
        int r10 = 2;
    L17:
        if (r10 != 1) goto L58;
        SegmentReader r11 = r4.owner;
        if (r11 == null) goto L56;
        long r12 = System.currentTimeMillis();
        long r14 = r12 - 4000;
        long r25 = r11.getRecentDownloadSpeed(r14, r12);
        long r13 = r31.getRecentDownloadSpeed(r14, r12);
        if (r25 > 0) goto L23;
    L25:
        float r15 = -1.0f;
    L27:
        if (r15 != (-1.0f)) goto L33;
        long r16 = r11.getReadBytes();
        float r33 = r15;
        long r17 = r31.getReadBytes();
        if (r16 > 0) goto L31;
    L34:
        float r18 = r33;
    L36:
        if (r18 <= 0.0f) goto L56;
        float r19 = r18 * 0.9f;
        long r110 = (long) (r3 * r19);
        if (r110 >= r8) goto L41;
        r110 = r8;
    L41:
        if (r9 > 0) goto L43;
    L45:
        r9 = r110;
    L46:
        long r20 = r8 / 2;
        long r111 = r3 - r20;
        if (r9 <= r111) goto L50;
        r9 = r111;
    L52:
        Segment r21 = new Segment(r4.getCurrentOffsetRead() + (r3 - r9), r4.getEndOffset());
        if (Logger.debug() == false) goto L55;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "obtainChildSegmentFromMaxRemain", "parent = " + r4 + ", child = " + r21 + ", maxRemainBytes = " + r3 + ", childLength = " + r9 + ", ratio = " + r19 + ", threadIndex = " + r31.threadIndex);
    L55:
        return r21;
    L50:
        if (r9 >= r20) goto L52;
        r9 = r20;
        goto L52
    L43:
        if (r110 <= r9) goto L45;
    L31:
        if (r17 <= 0) goto L34;
        r18 = r17 / (r16 + r17);
        goto L36
    L33:
        r33 = r15;
        goto L34
    L23:
        if (r13 <= 0) goto L25;
        r15 = r13 / (r25 + r13);
    L56:
        String r22 = "obtainChildSegmentFromMaxRemain";
        String r23 = TAG;
    L79:
        Segment r1 = new Segment(r4.getCurrentOffsetRead() + (r3 / 2), r4.getEndOffset());
        if (Logger.debug() == false) goto L82;
        Logger.taskDebug(r23, this.downloadInfo.getId(), r22, "parent = " + r4 + ",child = " + r1);
    L82:
        return r1;
    L58:
        if (r10 != 2) goto L78;
        long r112 = this.totalLength - this.downloadInfo.getCurBytes();
        float r24 = getDownloadRatio(r31, r32);
        long r113 = (long) (r112 * r24);
        if (r113 >= r8) goto L63;
        r113 = r8;
    L63:
        if (r9 > 0) goto L65;
    L67:
        r9 = r113;
    L68:
        long r26 = r8 / 2;
        long r114 = r3 - r26;
        if (r9 <= r114) goto L72;
        r9 = r114;
    L74:
        Segment r27 = new Segment(r4.getCurrentOffsetRead() + (r3 - r9), r4.getEndOffset());
        if (Logger.debug() == false) goto L77;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "obtainChildSegmentFromMaxRemain", "parent = " + r4 + ", child = " + r27 + ", maxRemainBytes = " + r3 + ", childLength = " + r9 + ", ratio = " + r24 + ", threadIndex = " + r31.threadIndex);
    L77:
        return r27;
    L72:
        if (r9 >= r26) goto L74;
        r9 = r26;
        goto L74
    L65:
        if (r113 <= r9) goto L67;
    L78:
        r22 = "obtainChildSegmentFromMaxRemain";
        r23 = TAG;
        goto L79
    L15:
        r10 = this.strategy.getRatioSegmentStrategy();
        goto L17
    L88:
        return null;
    }

    private float getDownloadRatio(SegmentReader r6, UrlRecord r7) {
        long r0 = r6.getReadBytes();
        int r8 = this.readers.size();
        if (r8 > 1) goto L5;
        r8 = this.strategy.getThreadCount();
    L5:
        float r4 = 1.0f;
        if (r0 > 0) goto L19;
        float r5 = this.strategy.getMainRatio();
        if (r5 > 0.0f) goto L10;
    L11:
        r5 = 1.0f / r8;
    L13:
        if (r6.threadIndex != 0) goto L15;
        return r5;
    L15:
        if (r8 <= 1) goto L18;
        r4 = 1.0f - r5;
        r8 = r8 - 1;
    L18:
        return r4 / r8;
    L10:
        if (r5 < 1.0f) goto L13;
    L19:
        long r9 = getTotalReadBytes();
        if (r9 <= r0) goto L18;
        return r0 / r9;
    }

    private long getTotalReadBytes() {
        Iterator<SegmentReader> r5 = this.readers.iterator();
        long r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 + ((SegmentReader) ZeusTransformUtils.preCheckCast(r5.next(), SegmentReader.class, "com.obric.aiagent.plugin")).getReadBytes();
        goto L4
    L6:
        return r0;
    }

    private Segment obtainSegmentWhenNoNewSegment() {
        int r0 = 0;
    L3:
        Segment r1 = obtainLeastCompetitorSegment();
        if (r1 == null) goto L5;
        SegmentReader r13 = r1.owner;
        if (r13 == null) goto L8;
        if (r1.getCompetitor() >= 2) goto L11;
        long r7 = System.currentTimeMillis();
        markProgress(r7);
        if ((r7 - r13.readStartTime) > 2000) goto L15;
    L22:
        int r3 = r0 + 1;
        if (r0 > 2) goto L25;
        monitor-enter(this);     // Catch: InterruptedException -> L38
        wait(500);     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
        r0 = r3;
        goto L3
    L35:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L38
    L38:
        return null;
    L25:
        if (this.debug == true) goto L27;
    L29:
        return r1;
    L27:
        if (Logger.debug() == false) goto L29;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "obtainSegmentWhenNoNewSegment", "WaitCount > 2, return segment = " + r1);
        goto L29
    L15:
        if (isDownloadSpeedPoor(r13, r7 - 2000, r7, 500, 1.0d) == false) goto L22;
        if (this.debug == true) goto L19;
    L21:
        return r1;
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "obtainSegmentWhenNoNewSegment", "IsDownloadSpeedPoor segment = " + r1 + ", owner.threadIndex = " + r13.threadIndex);
        goto L21
    L11:
        return null;
    L8:
        return r1;
    L5:
        return null;
    }

    private Segment obtainLeastCompetitorSegment() {
        Iterator<Segment> r0 = this.dispatchedSegments.iterator();
        Segment r1 = null;
        int r2 = Integer.MAX_VALUE;
    L4:
        if (r0.hasNext() == false) goto L10;
        Segment r3 = (Segment) ZeusTransformUtils.preCheckCast(r0.next(), Segment.class, "com.obric.aiagent.plugin");
        if (getRemainReadBytes(r3) <= 0) goto L4;
        int r4 = r3.getCompetitor();
        if (r4 >= r2) goto L4;
        r1 = r3;
        r2 = r4;
        goto L4
    L10:
        return r1;
    }

    private long getUnconfirmedRemainBytes(int r6, int r7) {
        Segment r0 = (Segment) ZeusTransformUtils.preCheckCast(this.dispatchedSegments.get(r6), Segment.class, "com.obric.aiagent.plugin");
        long r3 = getRemainReadBytes(r0);
        int r8 = r6 + 1;
        if (r8 >= r7) goto L5;
        Segment r5 = (Segment) ZeusTransformUtils.preCheckCast(this.dispatchedSegments.get(r8), Segment.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 != null) goto L8;
        return r3;
    L8:
        long r9 = r5.getStartOffset() - r0.getCurrentOffsetRead();
        if (r3 != (-1)) goto L12;
        return r9;
    L12:
        return Math.min(r3, r9);
    L5:
        r5 = null;
        goto L6
    }

    private long getRemainReadBytes(Segment r7) {
        long r0 = r7.getRemainReadBytes();
        if (r0 != (-1)) goto L8;
        long r2 = this.totalLength;
        if (r2 > 0) goto L7;
        return r0;
    L7:
        return r2 - r7.getCurrentOffsetRead();
    L8:
        return r0;
    }

    private SegmentReader findEarliestConnectTimeoutReader(boolean r7, long r8, long r10) {
        Iterator<SegmentReader> r6 = this.readers.iterator();
        SegmentReader r0 = null;
    L4:
        if (r6.hasNext() == false) goto L20;
        SegmentReader r1 = (SegmentReader) ZeusTransformUtils.preCheckCast(r6.next(), SegmentReader.class, "com.obric.aiagent.plugin");
        if (r1.threadIndex != 0) goto L10;
        if (r7 == false) goto L4;
    L10:
        if (r1.connectStartTime <= 0) goto L4;
        if (r1.connectEndTime > 0) goto L4;
        if ((r8 - r1.connectStartTime) <= r10) goto L4;
        if (r0 == null) goto L16;
        if (r1.connectStartTime >= r0.connectStartTime) goto L4;
    L16:
        r0 = r1;
        goto L4
    L20:
        return r0;
    }

    private long scheduleWatchRead() {
        if (this.canceled == false) goto L5;
        return -1;
    L5:
        if (this.paused == true) goto L28;
        long r0 = System.currentTimeMillis();
        monitor-enter(this);
        markProgress(r0);     // Catch: Throwable -> L21
        long r2 = this.strategy.getReadTimeout();     // Catch: Throwable -> L21
        if (r2 <= 0) goto L19;
        long r6 = this.lastReconnectTime;     // Catch: Throwable -> L21
        if (r6 <= 0) goto L19;
        if ((r0 - r6) <= r2) goto L19;
        if (findPoorReadThreadAndReconnect(r0, r2) == false) goto L19;
        this.lastReconnectTime = r0;     // Catch: Throwable -> L21
        this.reconnectCount++;     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        return 2000;
    L21:
        th = move-exception;
        throw th;
    L28:
        return -1;
    }

    private void markProgress(long r4) {
        this.stenographer.markProgress(this.downloadInfo.getCurBytes(), r4);
        Iterator<SegmentReader> r3 = this.readers.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((SegmentReader) ZeusTransformUtils.preCheckCast(r3.next(), SegmentReader.class, "com.obric.aiagent.plugin")).markProgress(r4);
        goto L4
    }

    private boolean isDownloadSpeedPoor(SegmentReader r7, long r8, long r10, long r12, double r14) {
        if (r7.readStartTime <= 0) goto L17;
        long r0 = this.stenographer.getRecentDownloadSpeed(r8, r10);
        int r2 = this.readers.size();
        if (r2 <= 0) goto L7;
        long r3 = r0 / ((long) r2);
    L8:
        long r9 = r7.getRecentDownloadSpeed(r8, r10);
        if (r9 < r12) goto L13;
        if (r9 < (r3 * r14)) goto L13;
        return false;
    L13:
        if (Logger.debug() == false) goto L19;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "isDownloadSpeedPoor", "TotalSpeed = " + r0 + ", threadAvgSpeed = " + r3 + ", poorSpeed = " + r12 + ", speed = " + r9 + ",threadIndex = " + r7.threadIndex);
        return true;
    L19:
        return true;
    L7:
        r3 = r0;
        goto L8
    L17:
        return false;
    }

    private boolean findPoorReadThreadAndReconnect(long r11, long r13) {
        long r2 = r11 - r13;
        long r0 = this.stenographer.getRecentDownloadSpeed(r2, r11);
        int r4 = this.readers.size();
        if (r4 <= 0) goto L5;
        r0 = r0 / ((long) r4);
    L5:
        SegmentReader r1 = findPoorReadThread(r2, r11, (long) Math.max(10.0f, r0 * this.poorSpeedRatio), r4 / 2);
        if (r1 == null) goto L12;
        trySwitchNextUrlForReader(r1);
        if (Logger.debug() == false) goto L10;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "findPoorReadThreadAndReconnect", "HandlePoorReadThread: reconnect for poor speed, threadIndex = " + r1.threadIndex);
    L10:
        r1.reconnect();
        return true;
    L12:
        SegmentReader r12 = findEarliestConnectTimeoutReader(true, r11, r13);
        if (r12 == null) goto L19;
        trySwitchNextUrlForReader(r12);
        if (Logger.debug() == false) goto L17;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "findPoorReadThreadAndReconnect", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + r12.threadIndex);
    L17:
        r12.reconnect();
        return true;
    L19:
        return false;
    }

    private SegmentReader findPoorReadThread(long r20, long r22, long r24, int r26) {
        Iterator<SegmentReader> r3 = this.readers.iterator();
        long r5 = Long.MAX_VALUE;
        int r7 = 0;
        SegmentReader r8 = null;
    L4:
        if (r3.hasNext() == false) goto L24;
        SegmentReader r9 = (SegmentReader) ZeusTransformUtils.preCheckCast(r3.next(), SegmentReader.class, "com.obric.aiagent.plugin");
        if (r9.readStartTime <= 0) goto L4;
        r7 = r7 + 1;
        if (r9.readStartTime >= r20) goto L20;
        long r17 = r5;
        long r4 = r9.getRecentDownloadSpeed(r20, r22);
        if (this.debug == true) goto L12;
    L14:
        long r1 = 0;
    L16:
        if (r4 >= r1) goto L18;
    L21:
        r5 = r17;
        goto L4
    L18:
        if (r4 >= r17) goto L21;
        r5 = r4;
        r8 = r9;
        goto L4
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "findPoorReadThread", "Speed = " + r4 + ", threadIndex = " + r9.threadIndex);
        r1 = 0;
        goto L16
    L20:
        r17 = r5;
        goto L21
    L24:
        long r18 = r5;
        if (r8 != null) goto L27;
        return null;
    L27:
        if (r7 >= r26) goto L29;
        return null;
    L29:
        if (r18 < r24) goto L31;
        return null;
    L31:
        if (Logger.debug() == false) goto L33;
        Logger.taskDebug(TAG, this.downloadInfo.getId(), "findPoorReadThread", "MinSpeed = " + r18 + ", threadIndex = " + r8.threadIndex);
    L33:
        return r8;
    }
}

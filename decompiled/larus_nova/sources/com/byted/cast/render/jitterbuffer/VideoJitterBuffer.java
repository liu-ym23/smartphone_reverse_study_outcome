package com.byted.cast.render.jitterbuffer;

import com.byted.cast.common.CastMonitor;
import com.byted.cast.render.utils.Logger;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttm.player.C;
import java.util.concurrent.ConcurrentSkipListMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class VideoJitterBuffer {
    private static final int DEFAULT_JITTER_PREFETCH_TIME = 100;
    private static final long DOUBLE_VSYNC_PERIOD = 33333332;
    private static final boolean ENABLE_COUNT_RENDER_STATUS = true;
    private static final int MAX_JITTER_PREFETCH_TIME = 1000;
    private static final int MIN_JITTER_PREFETCH_TIME = 0;
    private static final String TAG = "VideoJitterBuffer";
    private AudioJitterBuffer audioJitterBuffer;
    private int delayFrame;
    private boolean isRenderClockRunning;
    private volatile boolean isRunning;
    private JitterBufferListener mCallback;
    private Runnable mDecodeTask;
    private Thread mDecodeThread;
    private long mFirstPacketArrivalTime;
    private long mFirstRenderPacketPts;
    private ConcurrentSkipListMap<Long, byte[]> mJitterBuffer;
    private JITTER_MODE mJitterMode;
    private int mJitterPrefetchTime;
    private JITTER_STATE mJitterState;
    private ConcurrentSkipListMap<Long, Long> mLatencyList;
    private volatile long mLatestDecodePacketPts;
    private volatile long mStartPlaybackSystemTime;
    private Object mSyncLock;
    private int normalFrame;
    private long periodCount;
    private long underRunCount;
    private boolean underRunStart;
    private long underRunStartTs;
    private int underRunTimes;

    public static final enum JITTER_MODE extends Enum<JITTER_MODE> {
        private static final /* synthetic */ JITTER_MODE[] $VALUES = null;
        public static final JITTER_MODE LOW_LATENCY_MODE = null;
        public static final JITTER_MODE QUALITY_DYNAMIC_MODE = null;
        public static final JITTER_MODE QUALITY_STATIC_MODE = null;

        static {
            JITTER_MODE r100 = new JITTER_MODE("LOW_LATENCY_MODE", 0);
            LOW_LATENCY_MODE = r100;
            JITTER_MODE r101 = new JITTER_MODE("QUALITY_DYNAMIC_MODE", 1);
            QUALITY_DYNAMIC_MODE = r101;
            JITTER_MODE r102 = new JITTER_MODE("QUALITY_STATIC_MODE", 2);
            QUALITY_STATIC_MODE = r102;
            $VALUES = new JITTER_MODE[]{r100, r101, r102};
        }

        public static JITTER_MODE[] values() {
            return (JITTER_MODE[]) $VALUES.clone();
        }

        public static JITTER_MODE valueOf(String r100) {
            return (JITTER_MODE) r27.a.a(JITTER_MODE.class, r100);
        }

        private JITTER_MODE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum JITTER_STATE extends Enum<JITTER_STATE> {
        private static final /* synthetic */ JITTER_STATE[] $VALUES = null;
        public static final JITTER_STATE PREFETCH = null;
        public static final JITTER_STATE PROCESS = null;

        static {
            JITTER_STATE r100 = new JITTER_STATE("PREFETCH", 0);
            PREFETCH = r100;
            JITTER_STATE r101 = new JITTER_STATE("PROCESS", 1);
            PROCESS = r101;
            $VALUES = new JITTER_STATE[]{r100, r101};
        }

        public static JITTER_STATE[] values() {
            return (JITTER_STATE[]) $VALUES.clone();
        }

        public static JITTER_STATE valueOf(String r100) {
            return (JITTER_STATE) r27.a.a(JITTER_STATE.class, r100);
        }

        private JITTER_STATE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ void a(VideoJitterBuffer r100) {
        r100.lambda$new$0();
    }

    private void doPrefetch() {
        Logger.i(TAG, "doPrefetch start...mJitterMode=" + this.mJitterMode.name());
        Object r100 = this.mSyncLock;
        monitor-enter(r100);
        this.mSyncLock.wait();     // Catch: Throwable -> L9 InterruptedException -> L11
        if (this.mJitterMode == JITTER_MODE.LOW_LATENCY_MODE) goto L7;
        Logger.i(TAG, "doPrefetch mJitterPrefetchTime=" + this.mJitterPrefetchTime);     // Catch: Throwable -> L9 InterruptedException -> L11
        Thread.sleep((long) this.mJitterPrefetchTime);     // Catch: Throwable -> L9 InterruptedException -> L11
    L7:
        Logger.i(TAG, "doPrefetch finished...");     // Catch: Throwable -> L9 InterruptedException -> L11
        this.mJitterState = JITTER_STATE.PROCESS;     // Catch: Throwable -> L9 InterruptedException -> L11
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void doProcess() {
        if (this.mJitterBuffer.isEmpty() == false) goto L16;
        Object r100 = this.mSyncLock;
        monitor-enter(r100);
        this.mSyncLock.wait();     // Catch: Throwable -> L8 InterruptedException -> L10
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    L16:
        this.mLatestDecodePacketPts = this.mJitterBuffer.firstKey().longValue();
        byte[] r101 = this.mJitterBuffer.pollFirstEntry().getValue();
        Logger.d(TAG, "Dequeue Packet Pts=" + this.mLatestDecodePacketPts + " queueSize=" + this.mJitterBuffer.size());
        this.mCallback.onAVSmoothOutput(r101, this.mLatestDecodePacketPts / 1000);
    }

    private void reset() {
        Logger.i(TAG, BasicTestActionHandler.TEST_ACTION_RESET);
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterPrefetchTime = 100;
        this.mCallback = null;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mJitterBuffer.clear();
        this.isRenderClockRunning = false;
        this.mStartPlaybackSystemTime = 0;
        this.mFirstRenderPacketPts = 0;
        this.mLatestDecodePacketPts = 0;
        this.mFirstPacketArrivalTime = 0;
        this.audioJitterBuffer = null;
        this.periodCount = 1;
        this.underRunStart = false;
        this.normalFrame = 0;
        this.delayFrame = 0;
        this.underRunTimes = 0;
        this.underRunCount = 0;
        this.mLatencyList.clear();
    }

    public void notifyAudioDelayChanged() {
        AudioJitterBuffer r100 = this.audioJitterBuffer;
        if (r100 == null) goto L7;
        long r101 = r100.getCurrentAudioDelayMs();
        if (r101 == Long.MAX_VALUE) goto L9;
        r101 = r101 * 1000000;
    L9:
        if (this.mStartPlaybackSystemTime != 0) goto L11;
    L13:
        Logger.i(TAG, "notifyAudioDelayChanged skip mStartPlaybackSystemTime=" + this.mStartPlaybackSystemTime + " audioDelay=" + r101);
        return;
    L11:
        if (r101 == Long.MAX_VALUE) goto L13;
        Logger.i(TAG, "notifyAudioDelayChanged before mStartPlaybackSystemTime=" + this.mStartPlaybackSystemTime + " audioDelay=" + (this.mStartPlaybackSystemTime - this.mFirstPacketArrivalTime));
        this.mStartPlaybackSystemTime = this.mFirstPacketArrivalTime + r101;
        Logger.i(TAG, "notifyAudioDelayChanged after mStartPlaybackSystemTime=" + this.mStartPlaybackSystemTime + " audioDelay=" + r101);
        return;
    L7:
        r101 = Long.MAX_VALUE;
        goto L9
    }

    public void start() {
        Logger.i(TAG, "start");
        this.isRunning = true;
        PthreadThreadV2 r100 = new PthreadThreadV2(this.mDecodeTask, "VideoDecodeThread");
        this.mDecodeThread = r100;
        ThreadMethodProxy.start(r100);
    }

    public void stop() {
        Logger.i(TAG, "stop");
        this.isRunning = false;
        Object r100 = this.mSyncLock;
        monitor-enter(r100);
        this.mSyncLock.notify();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        ThreadMethodProxy.join(this.mDecodeThread);     // Catch: Exception -> L8
    L10:
        reset();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    L12:
        th = move-exception;
        throw th;
    }

    public VideoJitterBuffer() {
        this.mSyncLock = new Object();
        this.mJitterBuffer = new ConcurrentSkipListMap();
        this.mLatencyList = new ConcurrentSkipListMap();
        this.mJitterPrefetchTime = 100;
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mCallback = null;
        this.mStartPlaybackSystemTime = 0;
        this.mFirstRenderPacketPts = 0;
        this.mLatestDecodePacketPts = 0;
        this.mFirstPacketArrivalTime = 0;
        this.isRunning = true;
        this.delayFrame = 0;
        this.normalFrame = 0;
        this.underRunStart = false;
        this.underRunTimes = 0;
        this.underRunCount = 0;
        this.underRunStartTs = 0;
        this.periodCount = 1;
        this.mDecodeTask = new b(this);
    }

    private /* synthetic */ void lambda$new$0() {
        ThreadMethodProxy.setPriority(ThreadMethodProxy.currentThread(), 10);
    L4:
        if (this.isRunning == false) goto L9;
        if (this.mJitterState == JITTER_STATE.PREFETCH) goto L7;
        doProcess();
        goto L4
    L7:
        doPrefetch();
        goto L4
    L9:
        Logger.i(TAG, "Decode Thread Exit");
    }

    private void countRenderStatus(long r110) {
        if (((this.periodCount * 60) * C.NANOS_PER_SECOND) <= (System.nanoTime() - this.mStartPlaybackSystemTime)) goto L15;
        if (r110 < 0) goto L10;
        this.normalFrame++;
        if (this.underRunStart == false) goto L9;
        this.underRunStart = false;
        this.underRunTimes++;
        this.underRunCount += System.currentTimeMillis() - this.underRunStartTs;
    L9:
        Logger.d(TAG, "countRenderStatus EARLY...delay=" + r110 + " underRunStart=" + this.underRunStart + " underRunTimes=" + this.underRunTimes + " underRunCount=" + this.underRunCount + " normalFrame=" + this.normalFrame);
        return;
    L10:
        this.delayFrame++;
        if (this.underRunStart == true) goto L13;
        this.underRunStart = true;
        this.underRunStartTs = System.currentTimeMillis();
    L13:
        Logger.d(TAG, "countRenderStatus DELAY...delay=" + r110 + " underRunStart=" + this.underRunStart + " underRunTimes=" + this.underRunTimes + " underRunCount=" + this.underRunCount + " delayFrame=" + this.delayFrame);
        return;
    L15:
        if (this.underRunStart == false) goto L17;
        this.underRunStart = false;
        this.underRunTimes++;
        this.underRunCount += System.currentTimeMillis() - this.underRunStartTs;
    L17:
        Logger.i(TAG, "countRenderStatus: underRunTimes=" + this.underRunTimes + " underRunCount=" + this.underRunCount + " delayFrame=" + this.delayFrame + " normalFrame=" + this.normalFrame + " curTime=" + System.currentTimeMillis());
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L20
        r111.put("underRunTimes", this.underRunTimes);     // Catch: Exception -> L20
        r111.put("underRunCount", this.underRunCount);     // Catch: Exception -> L20
        r111.put("delayFrame", this.delayFrame);     // Catch: Exception -> L20
        r111.put("normalFrame", this.normalFrame);     // Catch: Exception -> L20
        r111.put("periodCount", this.periodCount);     // Catch: Exception -> L20
        CastMonitor.getInstance().sendCustomEvent("ByteLink", "VideoPlayBackStatus", r111.toString());     // Catch: Exception -> L20
    L22:
        this.periodCount++;
        this.normalFrame = 0;
        this.delayFrame = 0;
        this.underRunTimes = 0;
        this.underRunCount = 0;
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public long doRender(long r110) {
        if (this.mFirstPacketArrivalTime != 0) goto L5;
    L18:
        Logger.i(TAG, "doRender mFirstPacketArrivalTime == 0 || decodedPts == 1");
        this.mStartPlaybackSystemTime = 0;
        this.mFirstRenderPacketPts = r110;
    L20:
        if (this.mJitterMode == JITTER_MODE.LOW_LATENCY_MODE) goto L34;
        long r100 = this.mStartPlaybackSystemTime + (r110 - this.mFirstRenderPacketPts);
        long r101 = r100 - System.nanoTime();
        if (r101 >= 0) goto L25;
        Logger.d(TAG, "Render Late Packet Pts=" + r110 + " renderTimestampNs=" + r100 + " delta=" + r101);
    L32:
        countRenderStatus(r101);
        return r100;
    L25:
        if (r101 <= 900000000) goto L31;
        long r102 = (r101 / 1000000) - 300;
        Logger.d(TAG, "Render Early Packet Pts=" + r110 + " renderTimestampNs=" + r100 + " delta=" + r101 + " sleep=" + r102);
        Thread.sleep(r102);     // Catch: InterruptedException -> L29
    L29:
        e = move-exception;
        Logger.e(TAG, e.toString());
        goto L32
    L31:
        Logger.d(TAG, "Render Normal Packet Pts=" + r110 + " renderTimestampNs=" + r100 + " delta=" + r101);
        goto L32
    L34:
        if (this.mLatencyList.containsKey(Long.valueOf(r110)) == false) goto L36;
        long r103 = System.currentTimeMillis() - this.mLatencyList.remove(Long.valueOf(r110)).longValue();
    L37:
        Logger.d(TAG, "Render Packet render=0 pts=" + r110 + " cost=" + r103 + " pending=" + this.mLatencyList.size());
        return 0;
    L36:
        this.mLatencyList.clear();
        r103 = 0;
        goto L37
    L5:
        if (r110 <= 5) goto L18;
        if (this.isRenderClockRunning == true) goto L20;
        this.isRenderClockRunning = true;
        AudioJitterBuffer r104 = this.audioJitterBuffer;
        if (r104 != null) goto L12;
        long r105 = 0;
    L14:
        if (r105 != Long.MAX_VALUE) goto L16;
        this.mStartPlaybackSystemTime = System.nanoTime() + DOUBLE_VSYNC_PERIOD;
    L17:
        this.mFirstRenderPacketPts = 100000000 + r110;
        Logger.i(TAG, "doRender audioDelay=" + r105 + " mFirstPacketArrivalTime=" + this.mFirstPacketArrivalTime + " mStartPlaybackSystemTime=" + this.mStartPlaybackSystemTime + " mFirstRenderPacketPts=" + this.mFirstRenderPacketPts);
        goto L20
    L16:
        this.mStartPlaybackSystemTime = this.mFirstPacketArrivalTime + (r105 * 1000000);
        goto L17
    L12:
        r105 = r104.getCurrentAudioDelayMs();
        goto L14
    }

    public void setAudioJitterBuffer(AudioJitterBuffer r100) {
        this.audioJitterBuffer = r100;
    }

    public VideoJitterBuffer setJitterCallback(JitterBufferListener r100) {
        Logger.i(TAG, "setJitterCallback");
        this.mCallback = r100;
        return this;
    }

    public VideoJitterBuffer setJitterDelay(int r100) {
        Logger.i(TAG, "setJitterDelay delay=" + r100);
        if (r100 >= 0) goto L5;
    L7:
        return this;
    L5:
        if (r100 > 1000) goto L7;
        this.mJitterPrefetchTime = r100;
        goto L7
    }

    public VideoJitterBuffer setJitterMode(JITTER_MODE r100) {
        Logger.i(TAG, "setJitterMode mode=" + r100.name());
        this.mJitterMode = r100;
        return this;
    }

    public void append(byte[] r100, long r101) {
        if (r101 != 0) goto L6;
        Logger.i(TAG, "append set codec info packet pts");
        r101 = this.mLatestDecodePacketPts + 1;
    L9:
        if (r101 > this.mLatestDecodePacketPts) goto L15;
        if (this.mJitterMode == JITTER_MODE.LOW_LATENCY_MODE) goto L15;
        Logger.i(TAG, "Drop packet pts=" + r101 + " queueSize=" + this.mJitterBuffer.size());
    L21:
        Thread.yield();
        return;
    L15:
        if (this.mJitterBuffer.containsKey(Long.valueOf(r101)) == false) goto L17;
        r101 = r101 + 1;
        goto L15
    L17:
        long r102 = System.currentTimeMillis();
        Logger.d(TAG, "Append Packet Pts=" + r101 + " queueSize=" + this.mJitterBuffer.size() + " now=" + r102);
        this.mJitterBuffer.put(Long.valueOf(r101), r100);
        this.mLatencyList.put(Long.valueOf(r101), Long.valueOf(r102));
        Object r103 = this.mSyncLock;
        monitor-enter(r103);
        this.mSyncLock.notify();     // Catch: Throwable -> L23
        monitor-exit(r103);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L6:
        if (this.mFirstPacketArrivalTime != 0) goto L9;
        this.mFirstPacketArrivalTime = System.nanoTime();
        Logger.i(TAG, "append mFirstPacketArrivalTime=" + this.mFirstPacketArrivalTime);
        goto L9
    }
}

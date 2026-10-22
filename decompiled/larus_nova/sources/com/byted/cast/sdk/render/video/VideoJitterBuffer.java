package com.byted.cast.sdk.render.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.byted.cast.sdk.render.audio.AudioJitterBuffer;
import com.relax.VSyncMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes43.dex */
public class VideoJitterBuffer {
    private static final int DEFAULT_JITTER_PREFETCH_TIME = 100;
    private static final long DOUBLE_VSYNC_PERIOD = 33333332;
    private static final boolean ENABLE_COUNT_RENDER_STATUS = false;
    private static final int MAX_JITTER_PREFETCH_TIME = 1000;
    private static final int MIN_JITTER_PREFETCH_TIME = 0;
    private static final String TAG = "VideoJitterBuffer";
    private static volatile VideoJitterBuffer mInstance;
    private int fastFrame;
    private long frameCount;
    private boolean isRenderClockRunning;
    private volatile boolean isRunning;
    private int lagFrame;
    private int lagFrameVsync;
    private int lostFrame;
    private MediaCodec.BufferInfo mBufferInfo;
    private VideoJitterBufferCallback mCallback;
    private Runnable mDecodeTask;
    private Thread mDecodeThread;
    private long mFirstPacketArrivalTime;
    private long mFirstRenderPacketPts;
    private ConcurrentSkipListMap<Long, byte[]> mJitterBuffer;
    private JITTER_MODE mJitterMode;
    private int mJitterPrefetchTime;
    private JITTER_STATE mJitterState;
    private volatile long mLatestDecodePacketPts;
    private MediaCodec mMediaCodec;
    private Runnable mRenderTask;
    private Thread mRenderThread;
    private volatile long mStartPlaybackSystemTime;
    private Object mSyncLock;
    private int normalFrame;
    private long preVsyncSeq;

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
        r100.lambda$new$1();
    }

    public static /* synthetic */ void b(VideoJitterBuffer r100) {
        r100.lambda$new$0();
    }

    public void start() {
        this.isRunning = true;
        PthreadThreadV2 r100 = new PthreadThreadV2(this.mDecodeTask, "VideoDecodeThread");
        this.mDecodeThread = r100;
        ThreadMethodProxy.start(r100);
        PthreadThreadV2 r101 = new PthreadThreadV2(this.mRenderTask, "VideoRenderThread");
        this.mRenderThread = r101;
        ThreadMethodProxy.start(r101);
    }

    public void stop() {
        this.isRunning = false;
        Object r100 = this.mSyncLock;
        monitor-enter(r100);
        this.mSyncLock.notify();     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        ThreadMethodProxy.join(this.mDecodeThread);     // Catch: InterruptedException -> L8
    L23:
        ThreadMethodProxy.join(this.mRenderThread);     // Catch: InterruptedException -> L12
    L14:
        reset();
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
    L16:
        th = move-exception;
        throw th;
    }

    private void doPrefetch() {
        this.mJitterMode.name();
        Object r100 = this.mSyncLock;
        monitor-enter(r100);
        this.mSyncLock.wait();     // Catch: Throwable -> L9 InterruptedException -> L11
        if (this.mJitterMode == JITTER_MODE.LOW_LATENCY_MODE) goto L7;
        Thread.sleep(this.mJitterPrefetchTime);     // Catch: Throwable -> L9 InterruptedException -> L11
    L7:
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
        if (this.mJitterBuffer.isEmpty() == false) goto L28;
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
    L28:
        int r101 = this.mMediaCodec.dequeueInputBuffer(-1);     // Catch: Exception -> L21
        if (r101 < 0) goto L27;
        this.mLatestDecodePacketPts = this.mJitterBuffer.firstKey().longValue();     // Catch: Exception -> L21
        byte[] r102 = this.mJitterBuffer.pollFirstEntry().getValue();     // Catch: Exception -> L21
        this.mMediaCodec.getInputBuffer(r101).put(r102);     // Catch: Exception -> L21
        this.mMediaCodec.queueInputBuffer(r101, 0, r102.length, this.mLatestDecodePacketPts, 0);     // Catch: Exception -> L21
    L27:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
    }

    private void doRender() {
        int r100 = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 1000000);     // Catch: Exception -> L35
        if (r100 < 0) goto L26;
        if (this.mFirstPacketArrivalTime != 0) goto L8;
        this.mStartPlaybackSystemTime = 0;     // Catch: Exception -> L35
        this.mFirstRenderPacketPts = this.mBufferInfo.presentationTimeUs;     // Catch: Exception -> L35
    L15:
        if (this.mJitterMode != JITTER_MODE.LOW_LATENCY_MODE) goto L17;
        this.mMediaCodec.releaseOutputBuffer(r100, true);     // Catch: Exception -> L35
        return;
    L17:
        long r101 = this.mStartPlaybackSystemTime + (this.mBufferInfo.presentationTimeUs - this.mFirstRenderPacketPts);     // Catch: Exception -> L35
        long r102 = r101 - System.nanoTime();     // Catch: Exception -> L35
        if (r102 >= 0) goto L21;
        long r103 = this.mBufferInfo.presentationTimeUs;     // Catch: Exception -> L35
    L24:
        this.mMediaCodec.releaseOutputBuffer(r100, r101);     // Catch: Exception -> L35
        return;
    L21:
        if (r102 <= 900000000) goto L23;
        long r104 = this.mBufferInfo.presentationTimeUs;     // Catch: Exception -> L35
        Thread.sleep((r102 / 1000000) - 300);     // Catch: Exception -> L35
        goto L24
    L23:
        long r105 = this.mBufferInfo.presentationTimeUs;     // Catch: Exception -> L35
        goto L24
    L8:
        if (this.isRenderClockRunning == true) goto L15;
        this.isRenderClockRunning = true;     // Catch: Exception -> L35
        long r106 = AudioJitterBuffer.getInstance().getCurrentAudioDelay();     // Catch: Exception -> L35
        if (r106 != Long.MAX_VALUE) goto L12;
        this.mStartPlaybackSystemTime = System.nanoTime() + DOUBLE_VSYNC_PERIOD;     // Catch: Exception -> L35
    L13:
        this.mFirstRenderPacketPts = this.mBufferInfo.presentationTimeUs;     // Catch: Exception -> L35
        goto L15
    L12:
        this.mStartPlaybackSystemTime = this.mFirstPacketArrivalTime + r106;     // Catch: Exception -> L35
        goto L13
    L26:
        if (r100 != (-1)) goto L29;
        return;
    L29:
        if (r100 != (-2)) goto L44;
        MediaFormat r107 = this.mMediaCodec.getOutputFormat();     // Catch: Exception -> L35
        int r108 = r107.getInteger("width");     // Catch: Exception -> L35
        int r109 = r107.getInteger("height");     // Catch: Exception -> L35
        VideoJitterBufferCallback r110 = this.mCallback;     // Catch: Exception -> L35
        if (r110 == null) goto L42;
        r110.onVideoSize(r108, r109);     // Catch: Exception -> L35
        return;
    L42:
        return;
    L44:
        return;
    L35:
        e = move-exception;
        e.printStackTrace();
    }

    public static VideoJitterBuffer getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(VideoJitterBuffer.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new VideoJitterBuffer();     // Catch: Throwable -> L11
    L9:
        monitor-exit(VideoJitterBuffer.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private void reset() {
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
        this.mMediaCodec = null;
        this.mBufferInfo = null;
    }

    public VideoJitterBuffer() {
        this.mSyncLock = new Object();
        this.mJitterBuffer = new ConcurrentSkipListMap();
        this.mJitterPrefetchTime = 100;
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mCallback = null;
        this.mStartPlaybackSystemTime = 0;
        this.mFirstRenderPacketPts = 0;
        this.mLatestDecodePacketPts = 0;
        this.mFirstPacketArrivalTime = 0;
        this.isRunning = true;
        this.mMediaCodec = null;
        this.mBufferInfo = null;
        this.preVsyncSeq = 0;
        this.frameCount = 0;
        this.lostFrame = 0;
        this.lagFrame = 0;
        this.lagFrameVsync = 0;
        this.fastFrame = 0;
        this.normalFrame = 0;
        this.mDecodeTask = new a(this);
        this.mRenderTask = new b(this);
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
    }

    private /* synthetic */ void lambda$new$1() {
        ThreadMethodProxy.setPriority(ThreadMethodProxy.currentThread(), 10);
    L4:
        if (this.isRunning == false) goto L6;
        doRender();
        goto L4
    }

    public void notifyAudioDelayChanged() {
        long r100 = AudioJitterBuffer.getInstance().getCurrentAudioDelay();
        if (this.mStartPlaybackSystemTime == 0) goto L8;
        if (r100 == Long.MAX_VALUE) goto L8;
        this.mStartPlaybackSystemTime = this.mFirstPacketArrivalTime + r100;
        return;
    }

    private void countRenderStatus(long r110) {
        long r100 = this.frameCount + 1;
        this.frameCount = r100;
        if (r100 > 1000) goto L6;
        return;
    L6:
        if (r100 <= 1000) goto L24;
        if (r100 >= 19001) goto L24;
        long r111 = r110 / VSyncMonitor.DEFAULT_FRAME_TIME_NS;
        if (this.preVsyncSeq != 0) goto L12;
        this.preVsyncSeq = r111 - 2;
    L12:
        long r101 = this.preVsyncSeq;
        if (r111 != r101) goto L16;
        this.lostFrame++;
    L22:
        this.preVsyncSeq = r111;
        return;
    L16:
        if ((r111 - r101) <= 2) goto L19;
        this.lagFrameVsync = (int) (((long) this.lagFrameVsync) + ((r111 - r101) - 2));
        this.lagFrame++;
        goto L22
    L19:
        if ((r111 - r101) != 1) goto L21;
        this.fastFrame++;
        goto L22
    L21:
        this.normalFrame++;
    }

    public VideoJitterBuffer setJitterCallback(VideoJitterBufferCallback r100) {
        this.mCallback = r100;
        return this;
    }

    public VideoJitterBuffer setJitterDelay(int r100) {
        if (r100 >= 0) goto L5;
    L7:
        return this;
    L5:
        if (r100 > 1000) goto L7;
        this.mJitterPrefetchTime = r100;
        goto L7
    }

    public VideoJitterBuffer setJitterMode(JITTER_MODE r100) {
        r100.name();
        this.mJitterMode = r100;
        return this;
    }

    public VideoJitterBuffer setMediaCodec(MediaCodec r100, MediaCodec.BufferInfo r101) {
        this.mMediaCodec = r100;
        this.mBufferInfo = r101;
        return this;
    }

    public void append(byte[] r100, long r101, boolean r102) {
        if (r102 == false) goto L7;
        r101 = this.mJitterBuffer.lastKey().longValue() + 1;
    L10:
        if (r101 > this.mLatestDecodePacketPts) goto L12;
    L21:
        this.mJitterBuffer.size();
    L22:
        Thread.yield();
        return;
    L12:
        if (this.mJitterBuffer.containsKey(Long.valueOf(r101)) == true) goto L21;
        this.mJitterBuffer.size();
        this.mJitterBuffer.put(Long.valueOf(r101), r100);
        Object r103 = this.mSyncLock;
        monitor-enter(r103);
        this.mSyncLock.notify();     // Catch: Throwable -> L18
        monitor-exit(r103);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L5:
        r101 = r101 - 2;
        goto L10
    L7:
        if (this.mFirstPacketArrivalTime != 0) goto L10;
        this.mFirstPacketArrivalTime = System.nanoTime();
        goto L10
    }
}

package com.byted.cast.sdk.render.audio;

import com.byted.cast.sdk.render.video.VideoJitterBuffer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttm.player.C;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes43.dex */
public class AudioJitterBuffer {
    private static final int COUNT_SIZE = 30000;
    private static final int DEFAULT_JITTER_PREFETCH_SIZE = 5;
    private static final boolean ENABLE_COUNT_RENDER_STATUS = false;
    private static final boolean ENABLE_UNDER_RUN_ECHO = false;
    private static final int MAX_JITTER_PREFETCH_SIZE = 100;
    private static final int MIN_JITTER_PREFETCH_SIZE = 1;
    private static final String TAG = "AudioJitterBuffer";
    private static volatile AudioJitterBuffer mInstance = null;
    private static final int mTolerance = 10;
    private volatile boolean isRunning;
    private int lateCount;
    private int lostCount;
    private AudioJitterBufferCallback mCallback;
    private int mChannelSize;
    private byte[] mEchoBuffer;
    private long mFirstDirtyPts;
    private long mFirstOutputPacketTime;
    private boolean mIsRtpTimeStamp;
    private ConcurrentSkipListMap<Long, byte[]> mJitterBuffer;
    private JITTER_MODE mJitterMode;
    private int mJitterPrefetchSize;
    private JITTER_STATE mJitterState;
    private volatile long mLatestOutputPacketPts;
    private volatile long mOriginalStartPlaybackSystemTime;
    private int mPacketDeltaPts;
    private int mPacketPlayTime;
    private Runnable mPlaybackTask;
    private Thread mPlaybackThread;
    private long mPreRtpTs;
    private long mPreSysTs;
    private long mSR_Counter;
    private long mSR_CurMinDelta;
    private long mSR_StartPts;
    private long mSR_StartSysTs;
    private int mSampleRate;
    private int mSampleSize;
    private Object mSyncLock;
    private volatile long mTunedStartPlaybackSystemTime;
    private int okCount;
    private long underRunCount;
    private long underRunStart;

    public static final enum COUNT_ELEMENT extends Enum<COUNT_ELEMENT> {
        private static final /* synthetic */ COUNT_ELEMENT[] $VALUES = null;
        public static final COUNT_ELEMENT PACKET_LATE = null;
        public static final COUNT_ELEMENT PACKET_LOST = null;
        public static final COUNT_ELEMENT PACKET_OK = null;
        public static final COUNT_ELEMENT UNDER_RUN = null;

        static {
            COUNT_ELEMENT r100 = new COUNT_ELEMENT("UNDER_RUN", 0);
            UNDER_RUN = r100;
            COUNT_ELEMENT r101 = new COUNT_ELEMENT("PACKET_LOST", 1);
            PACKET_LOST = r101;
            COUNT_ELEMENT r102 = new COUNT_ELEMENT("PACKET_LATE", 2);
            PACKET_LATE = r102;
            COUNT_ELEMENT r103 = new COUNT_ELEMENT("PACKET_OK", 3);
            PACKET_OK = r103;
            $VALUES = new COUNT_ELEMENT[]{r100, r101, r102, r103};
        }

        public static COUNT_ELEMENT[] values() {
            return (COUNT_ELEMENT[]) $VALUES.clone();
        }

        public static COUNT_ELEMENT valueOf(String r100) {
            return (COUNT_ELEMENT) r27.a.a(COUNT_ELEMENT.class, r100);
        }

        private COUNT_ELEMENT(String r100, int r101) {
            super(r100, r101);
        }
    }

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

    public static /* synthetic */ void a(AudioJitterBuffer r100) {
        r100.lambda$new$0();
    }

    public void start() {
        this.isRunning = true;
        PthreadThreadV2 r100 = new PthreadThreadV2(this.mPlaybackTask, "AudioPlaybackThread");
        this.mPlaybackThread = r100;
        ThreadMethodProxy.start(r100);
    }

    public void stop() {
        this.isRunning = false;
        Object r100 = this.mSyncLock;
        monitor-enter(r100);
        this.mSyncLock.notify();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        ThreadMethodProxy.join(this.mPlaybackThread);     // Catch: InterruptedException -> L8
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

    private void doPrefetch() {
        if (this.mJitterBuffer.size() > this.mJitterPrefetchSize) goto L19;
        Object r100 = this.mSyncLock;
        monitor-enter(r100);
        this.mSyncLock.wait();     // Catch: Throwable -> L8 InterruptedException -> L10
    L13:
        if (this.mJitterBuffer.size() != this.mJitterPrefetchSize) goto L15;
        this.mCallback.onAudioReadyToPlay();     // Catch: Throwable -> L8
    L15:
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L19:
        this.mJitterState = JITTER_STATE.PROCESS;
        this.mOriginalStartPlaybackSystemTime = System.currentTimeMillis();
        this.mTunedStartPlaybackSystemTime = this.mOriginalStartPlaybackSystemTime;
        long r101 = this.mJitterBuffer.firstKey().longValue();
        this.mFirstOutputPacketTime = r101;
        this.mLatestOutputPacketPts = r101;
        this.mJitterBuffer.size();
        VideoJitterBuffer.getInstance().notifyAudioDelayChanged();
        this.mCallback.onAudioSmoothOutput(this.mJitterBuffer.pollFirstEntry().getValue());
    }

    private void doProcess() {
        if (this.mJitterBuffer.isEmpty() == false) goto L17;
        underRunCheck();
        int r100 = this.mPacketPlayTime;
        Object r101 = this.mSyncLock;
        monitor-enter(r101);
        this.mSyncLock.wait(r100);     // Catch: Throwable -> L9 InterruptedException -> L11
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        return;
    L17:
        long r102 = this.mJitterBuffer.firstKey().longValue();
        long r103 = calculatePacketDelay(r102);
        if (r103 < 0) goto L39;
        long r104 = r102 - this.mLatestOutputPacketPts;
        int r105 = this.mPacketDeltaPts;
        if (r104 != r105) goto L23;
        this.mLatestOutputPacketPts = r102;
        this.mCallback.onAudioSmoothOutput(this.mJitterBuffer.pollFirstEntry().getValue());
        return;
    L23:
        if (r103 <= r105) goto L37;
        underRunCheck();
        int r106 = this.mPacketPlayTime;
        Object r107 = this.mSyncLock;
        monitor-enter(r107);
        this.mSyncLock.wait(r106);     // Catch: Throwable -> L29 InterruptedException -> L31
        monitor-exit(r107);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
        return;
    L37:
        this.mLatestOutputPacketPts = r102;
        this.mCallback.onAudioSmoothOutput(this.mJitterBuffer.pollFirstEntry().getValue());
        return;
    L39:
        if (r102 <= this.mLatestOutputPacketPts) goto L41;
        this.mLatestOutputPacketPts = r102;
    L41:
        this.mJitterBuffer.pollFirstEntry();
    }

    public static AudioJitterBuffer getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(AudioJitterBuffer.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new AudioJitterBuffer();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AudioJitterBuffer.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private void reset() {
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterPrefetchSize = 5;
        this.mCallback = null;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mJitterBuffer.clear();
        this.mOriginalStartPlaybackSystemTime = 0;
        this.mTunedStartPlaybackSystemTime = 0;
        this.mFirstOutputPacketTime = 0;
        this.mLatestOutputPacketPts = -1;
        this.mPacketPlayTime = 0;
        this.mPacketDeltaPts = 0;
        this.mSampleRate = 44100;
        this.mChannelSize = 0;
        this.mSampleSize = 0;
        this.mFirstDirtyPts = 0;
        this.mSR_StartPts = 0;
        this.mSR_StartSysTs = 0;
        this.mSR_CurMinDelta = Long.MAX_VALUE;
        this.mSR_Counter = 0;
        this.mIsRtpTimeStamp = false;
    }

    private long underRunCheck() {
        long r100 = calculatePacketDelay(this.mLatestOutputPacketPts) + ((long) this.mPacketDeltaPts);
        if (r100 >= 0) goto L11;
        this.mJitterMode.name();
        if (this.mJitterMode != JITTER_MODE.QUALITY_DYNAMIC_MODE) goto L11;
        int r101 = this.mJitterPrefetchSize;
        if ((((long) (this.mPacketDeltaPts * r101)) + r100) >= 0) goto L11;
        if (r101 >= 100) goto L11;
        this.mJitterPrefetchSize = r101 + 10;
        this.mOriginalStartPlaybackSystemTime += (long) (((this.mPacketDeltaPts * 10) * 1000) / this.mSampleRate);
        this.mTunedStartPlaybackSystemTime += (long) (((this.mPacketDeltaPts * 10) * 1000) / this.mSampleRate);
        this.mJitterMode.name();
        VideoJitterBuffer.getInstance().notifyAudioDelayChanged();
    L11:
        return r100;
    }

    public long getCurrentAudioDelay() {
        if (this.mOriginalStartPlaybackSystemTime != 0) goto L5;
        return Long.MAX_VALUE;
    L5:
        return (((((long) this.mJitterPrefetchSize) * ((long) this.mPacketDeltaPts)) * C.NANOS_PER_SECOND) / ((long) this.mSampleRate)) + ((this.mTunedStartPlaybackSystemTime - this.mOriginalStartPlaybackSystemTime) * 1000000);
    }

    public AudioJitterBuffer() {
        this.mSyncLock = new Object();
        this.mJitterBuffer = new ConcurrentSkipListMap();
        this.mJitterMode = JITTER_MODE.QUALITY_STATIC_MODE;
        this.mJitterState = JITTER_STATE.PREFETCH;
        this.mJitterPrefetchSize = 5;
        this.mCallback = null;
        this.mOriginalStartPlaybackSystemTime = 0;
        this.mTunedStartPlaybackSystemTime = 0;
        this.mFirstOutputPacketTime = 0;
        this.mLatestOutputPacketPts = -1;
        this.mPacketPlayTime = 0;
        this.mPacketDeltaPts = 0;
        this.mSampleRate = 44100;
        this.mChannelSize = 0;
        this.mSampleSize = 0;
        this.isRunning = true;
        this.mIsRtpTimeStamp = false;
        this.underRunStart = 0;
        this.underRunCount = 0;
        this.lateCount = 0;
        this.lostCount = 0;
        this.okCount = 0;
        this.mPlaybackTask = new a(this);
        this.mFirstDirtyPts = 0;
        this.mPreRtpTs = 0;
        this.mPreSysTs = 0;
        this.mSR_StartPts = 0;
        this.mSR_StartSysTs = 0;
        this.mSR_CurMinDelta = Long.MAX_VALUE;
        this.mSR_Counter = 0;
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

    private final long calculatePacketDelay(long r100) {
        return r100 - (this.mFirstOutputPacketTime + (((System.currentTimeMillis() - this.mTunedStartPlaybackSystemTime) * ((long) this.mSampleRate)) / 1000));
    }

    private void generateEchoBuffer(byte[] r100) {
        this.mEchoBuffer = r100;
    }

    public long convertToRtpTimestamp(long r110) {
        long r100 = this.mFirstDirtyPts;
        int r101 = this.mSampleRate;
        int r102 = this.mPacketDeltaPts;
        long r103 = ((((r110 - r100) * ((long) r101)) / 1000) / ((long) r102)) * ((long) r102);
        long r104 = (((((r110 - r100) + 10) * ((long) r101)) / 1000) / ((long) r102)) * ((long) r102);
        if (r103 > r104) goto L6;
        r103 = r104;
    L6:
        long r105 = this.mPreRtpTs;
        if (r103 != (((long) r102) + r105)) goto L9;
    L11:
        this.mPreRtpTs = r103;
        this.mPreSysTs = r110;
        return r103;
    L9:
        if ((r110 - this.mPreSysTs) >= ((this.mPacketPlayTime * 2) - 10)) goto L11;
        r103 = ((long) r102) + r105;
        goto L11
    }

    public AudioJitterBuffer setJitterCallback(AudioJitterBufferCallback r100) {
        this.mCallback = r100;
        return this;
    }

    public AudioJitterBuffer setJitterMode(JITTER_MODE r100) {
        r100.name();
        this.mJitterMode = r100;
        if (r100 != JITTER_MODE.LOW_LATENCY_MODE) goto L5;
        this.mJitterPrefetchSize = 1;
    L5:
        return this;
    }

    public AudioJitterBuffer setJitterPrefetchSize(int r100) {
        if (r100 >= 1) goto L5;
    L7:
        this.mJitterPrefetchSize = 5;
    L9:
        if (this.mJitterMode != JITTER_MODE.LOW_LATENCY_MODE) goto L11;
        this.mJitterPrefetchSize = 1;
    L11:
        return this;
    L5:
        if (r100 > 100) goto L7;
        this.mJitterPrefetchSize = r100;
        goto L9
    }

    public void set_audio_ntp_base(long r100) {
        long r101 = this.mSR_Counter + 1;
        this.mSR_Counter = r101;
        if ((r101 % 100) == 0) goto L5;
        return;
    L5:
        if (this.mSR_StartPts != 0) goto L7;
        this.mSR_StartPts = r100;
        this.mSR_StartSysTs = System.currentTimeMillis();
        return;
    L7:
        long r102 = System.currentTimeMillis() - this.mSR_StartSysTs;
        if (this.mIsRtpTimeStamp == false) goto L10;
        long r103 = ((r100 - this.mSR_StartPts) * 1000) / ((long) this.mSampleRate);
    L11:
        long r104 = r102 - r103;
        if (this.mSR_CurMinDelta <= r104) goto L15;
        this.mSR_CurMinDelta = r104;
    L15:
        if ((this.mSR_Counter % 10000) != 0) goto L20;
        this.mTunedStartPlaybackSystemTime = this.mOriginalStartPlaybackSystemTime + this.mSR_CurMinDelta;
        this.mSR_CurMinDelta = Long.MAX_VALUE;
        VideoJitterBuffer.getInstance().notifyAudioDelayChanged();
        return;
    L20:
        return;
    L10:
        r103 = r100 - this.mSR_StartPts;
        goto L11
    }

    private void countRenderStatus(COUNT_ELEMENT r110, long r111) {
        long r100 = this.mLatestOutputPacketPts;
        long r101 = this.mFirstOutputPacketTime;
        int r102 = this.mPacketDeltaPts;
        if (((r100 - r101) / ((long) r102)) < 30000) goto L5;
        long r112 = this.underRunStart;
        if (r112 == 0) goto L33;
        this.underRunCount += ((((long) (r102 * 30000)) + r101) - r112) - ((long) r102);
        this.underRunStart = 0;
    L33:
        return;
    L5:
        if (r110 != COUNT_ELEMENT.UNDER_RUN) goto L11;
        if (this.underRunStart != 0) goto L34;
        this.underRunStart = r111;
    L34:
        return;
    L11:
        if (r110 != COUNT_ELEMENT.PACKET_LOST) goto L17;
        this.lostCount = (int) (((long) this.lostCount) + (((r111 - this.mLatestOutputPacketPts) / ((long) this.mPacketDeltaPts)) - 1));
        this.okCount++;
        long r103 = r111 - this.mLatestOutputPacketPts;
        int r113 = this.mPacketDeltaPts;
        long r104 = r103 / ((long) r113);
        long r105 = this.underRunStart;
        if (r105 == 0) goto L15;
        this.underRunCount += (r111 - r105) - ((long) r113);
        this.underRunStart = 0;
        return;
    L15:
        this.underRunCount += (r111 - this.mLatestOutputPacketPts) - ((long) this.mPacketDeltaPts);
        return;
    L17:
        if (r110 != COUNT_ELEMENT.PACKET_OK) goto L22;
        this.okCount++;
        long r106 = this.underRunStart;
        if (r106 == 0) goto L37;
        this.underRunCount += (r111 - r106) - ((long) r102);
        this.underRunStart = 0;
        return;
    L37:
        return;
    L22:
        if (r110 != COUNT_ELEMENT.PACKET_LATE) goto L39;
        this.lateCount = (int) (((long) this.lateCount) + ((r111 - this.mLatestOutputPacketPts) / ((long) this.mPacketDeltaPts)));
        if ((calculatePacketDelay(this.mLatestOutputPacketPts) + ((long) this.mPacketDeltaPts)) >= 0) goto L40;
        if (this.underRunStart != 0) goto L40;
        this.underRunStart = this.mLatestOutputPacketPts;
    L40:
        return;
    }

    public void append(byte[] r100, long r101) {
        if (this.mPacketDeltaPts != 0) goto L9;
        int r102 = r100.length / (this.mChannelSize * this.mSampleSize);
        this.mPacketDeltaPts = r102;
        this.mPacketPlayTime = (r102 * 1000) / this.mSampleRate;
        this.mFirstDirtyPts = r101;
        VideoJitterBuffer.getInstance().notifyAudioDelayChanged();
        int r103 = this.mPacketDeltaPts;
        if ((r101 % ((long) r103)) != 0) goto L9;
        if (r101 >= (r103 * 5)) goto L9;
        this.mIsRtpTimeStamp = true;
    L9:
        set_audio_ntp_base(r101);
        if (this.mIsRtpTimeStamp == true) goto L14;
        r101 = convertToRtpTimestamp(r101);
    L14:
        if (r101 > this.mLatestOutputPacketPts) goto L16;
    L25:
        this.mJitterBuffer.size();
    L26:
        Thread.yield();
        return;
    L16:
        if (this.mJitterBuffer.containsKey(Long.valueOf(r101)) == true) goto L25;
        this.mJitterBuffer.size();
        int r104 = r100.length;
        this.mJitterBuffer.put(Long.valueOf(r101), r100);
        Object r105 = this.mSyncLock;
        monitor-enter(r105);
        this.mSyncLock.notify();     // Catch: Throwable -> L22
        monitor-exit(r105);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public AudioJitterBuffer setAudioFormat(int r100, int r101, int r102) {
        this.mSampleRate = r100;
        this.mChannelSize = r101;
        this.mSampleSize = r102;
        return this;
    }
}

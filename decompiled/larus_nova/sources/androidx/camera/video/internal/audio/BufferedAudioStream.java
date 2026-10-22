package androidx.camera.video.internal.audio;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class BufferedAudioStream implements AudioStream {
    private static final int DATA_WAITING_TIME_MILLIS = 1;
    private static final int DEFAULT_BUFFER_SIZE_IN_FRAME = 1024;
    private static final int DEFAULT_QUEUE_SIZE = 500;
    private static final String TAG = "BufferedAudioStream";
    private AudioData mAudioDataNotFullyRead;
    private final Queue<AudioData> mAudioDataQueue;
    private final AudioStream mAudioStream;
    private int mBufferSize;
    private final int mBytesPerFrame;
    private final AtomicBoolean mIsCollectingAudioData;
    private final AtomicBoolean mIsReleased;
    private final AtomicBoolean mIsStarted;
    private final Object mLock;
    private final Executor mProducerExecutor;
    private final int mQueueMaxSize;
    private final int mSampleRate;

    public static class AudioData {
        private final ByteBuffer mByteBuffer;
        private final int mBytesPerFrame;
        private final int mSampleRate;
        private long mTimestampNs;

        public int getRemainingBufferSizeInBytes() {
            return this.mByteBuffer.remaining();
        }

        public AudioStream.PacketInfo read(ByteBuffer r110) {
            long r100 = this.mTimestampNs;
            int r101 = this.mByteBuffer.position();
            int r102 = r110.position();
            if (this.mByteBuffer.remaining() <= r110.remaining()) goto L5;
            int r103 = r110.remaining();
            this.mTimestampNs += AudioUtils.frameCountToDurationNs(AudioUtils.sizeToFrameCount(r103, this.mBytesPerFrame), this.mSampleRate);
            ByteBuffer r104 = this.mByteBuffer.duplicate();
            r104.position(r101).limit(r101 + r103);
            r110.put(r104).limit(r102 + r103).position(r102);
        L6:
            this.mByteBuffer.position(r101 + r103);
            return AudioStream.PacketInfo.of(r103, r100);
        L5:
            r103 = this.mByteBuffer.remaining();
            r110.put(this.mByteBuffer).limit(r102 + r103).position(r102);
            goto L6
        }

        public AudioData(ByteBuffer r100, AudioStream.PacketInfo r101, int r102, int r103) {
            r100.rewind();
            int r104 = r100.limit() - r100.position();
            if (r104 != r101.getSizeInBytes()) goto L7;
            this.mBytesPerFrame = r102;
            this.mSampleRate = r103;
            this.mByteBuffer = r100;
            this.mTimestampNs = r101.getTimestampNs();
            return;
        L7:
            throw new IllegalStateException("Byte buffer size is not match with packet info: " + r104 + " != " + r101.getSizeInBytes());
        }
    }

    public static /* synthetic */ void a(BufferedAudioStream r100) {
        r100.lambda$start$0();
    }

    public static /* synthetic */ void b(BufferedAudioStream r100, int r101) {
        r100.lambda$updateCollectionBufferSizeAsync$4(r101);
    }

    public static /* synthetic */ void c(BufferedAudioStream r100, AudioStream.AudioStreamCallback r101, Executor r102) {
        r100.lambda$setCallback$3(r101, r102);
    }

    public static /* synthetic */ void d(BufferedAudioStream r100) {
        r100.lambda$stop$1();
    }

    public static /* synthetic */ void e(BufferedAudioStream r100) {
        r100.collectAudioData();
    }

    public static /* synthetic */ void f(BufferedAudioStream r100) {
        r100.lambda$release$2();
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    private void collectAudioData() {
        if (this.mIsCollectingAudioData.get() == true) goto L5;
        return;
    L5:
        ByteBuffer r100 = ByteBuffer.allocateDirect(this.mBufferSize);
        AudioData r101 = new AudioData(r100, this.mAudioStream.read(r100), this.mBytesPerFrame, this.mSampleRate);
        int r102 = this.mQueueMaxSize;
        Object r103 = this.mLock;
        monitor-enter(r103);
        this.mAudioDataQueue.offer(r101);     // Catch: Throwable -> L16
    L9:
        if (this.mAudioDataQueue.size() <= r102) goto L11;
        this.mAudioDataQueue.poll();     // Catch: Throwable -> L16
        Logger.w(TAG, "Drop audio data due to full of queue.");     // Catch: Throwable -> L16
        goto L9
    L11:
        monitor-exit(r103);     // Catch: Throwable -> L16
        if (this.mIsCollectingAudioData.get() == false) goto L22;
        this.mProducerExecutor.execute(new s(this));
        return;
    L22:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$release$2() {
        this.mIsCollectingAudioData.set(false);
        this.mAudioStream.release();
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mAudioDataNotFullyRead = null;     // Catch: Throwable -> L8
        this.mAudioDataQueue.clear();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$start$0() {
        this.mAudioStream.start();     // Catch: AudioStream.AudioStreamException -> L4
        startCollectingAudioData();     // Catch: AudioStream.AudioStreamException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private /* synthetic */ void lambda$stop$1() {
        this.mIsCollectingAudioData.set(false);
        this.mAudioStream.stop();
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mAudioDataNotFullyRead = null;     // Catch: Throwable -> L8
        this.mAudioDataQueue.clear();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void startCollectingAudioData() {
        if (this.mIsCollectingAudioData.getAndSet(true) == false) goto L5;
        return;
    L5:
        collectAudioData();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        if (this.mIsReleased.getAndSet(true) == false) goto L5;
        return;
    L5:
        this.mProducerExecutor.execute(new q(this));
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() throws AudioStream.AudioStreamException, IllegalStateException {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(true) == false) goto L5;
        return;
    L5:
        FutureTask r100 = new FutureTask(new r(this), null);
        this.mProducerExecutor.execute(r100);
        r100.get();     // Catch: ExecutionException -> L8 Throwable -> L10
        return;
    L10:
        e = move-exception;
        this.mIsStarted.set(false);
        throw new AudioStream.AudioStreamException(e);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() throws IllegalStateException {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(false) == true) goto L5;
        return;
    L5:
        this.mProducerExecutor.execute(new t(this));
    }

    private /* synthetic */ void lambda$updateCollectionBufferSizeAsync$4(int r100) {
        updateCollectionBufferSize(r100);
    }

    private void updateCollectionBufferSize(int r100) {
        int r101 = this.mBufferSize;
        if (r101 != r100) goto L5;
        return;
    L5:
        int r102 = this.mBytesPerFrame;
        this.mBufferSize = (r100 / r102) * r102;
        Logger.d(TAG, "Update buffer size from " + r101 + " to " + this.mBufferSize);
    }

    private void updateCollectionBufferSizeAsync(final int r100) {
        this.mProducerExecutor.execute(new p(this, r100));
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.PacketInfo read(ByteBuffer r100) {
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        updateCollectionBufferSizeAsync(r100.remaining());
        AudioStream.PacketInfo r101 = AudioStream.PacketInfo.of(0, 0);
    L3:
        Object r102 = this.mLock;
        monitor-enter(r102);
        AudioData r103 = this.mAudioDataNotFullyRead;     // Catch: Throwable -> L29
        this.mAudioDataNotFullyRead = null;     // Catch: Throwable -> L29
        if (r103 != null) goto L8;
        r103 = this.mAudioDataQueue.poll();     // Catch: Throwable -> L29
    L8:
        if (r103 == null) goto L12;
        r101 = r103.read(r100);     // Catch: Throwable -> L29
        if (r103.getRemainingBufferSizeInBytes() <= 0) goto L12;
        this.mAudioDataNotFullyRead = r103;     // Catch: Throwable -> L29
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L29
        if (r101.getSizeInBytes() <= 0) goto L16;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == false) goto L27;
        Thread.sleep(1);     // Catch: InterruptedException -> L25
    L25:
        e = move-exception;
        Logger.w(TAG, "Interruption while waiting for audio data", e);
    L28:
        return r101;
    L27:
        if (r104 == true) goto L3;
    L16:
        if (this.mIsStarted.get() == false) goto L20;
        if (this.mIsReleased.get() == true) goto L20;
        r104 = true;
    L29:
        th = move-exception;
        throw th;
    }

    public BufferedAudioStream(AudioStream r100, AudioSettings r101) {
        boolean r102 = false;
        this.mIsStarted = new AtomicBoolean(false);
        this.mIsReleased = new AtomicBoolean(false);
        this.mAudioDataQueue = new ConcurrentLinkedQueue();
        this.mProducerExecutor = CameraXExecutors.newSequentialExecutor(CameraXExecutors.audioExecutor());
        this.mLock = new Object();
        this.mAudioDataNotFullyRead = null;
        this.mIsCollectingAudioData = new AtomicBoolean(false);
        this.mAudioStream = r100;
        int r103 = r101.getBytesPerFrame();
        this.mBytesPerFrame = r103;
        int r104 = r101.getSampleRate();
        this.mSampleRate = r104;
        if (r103 <= 0) goto L5;
        boolean r105 = true;
    L6:
        Preconditions.checkArgument(r105, "mBytesPerFrame must be greater than 0.");
        if (r104 <= 0) goto L9;
        r102 = true;
    L9:
        Preconditions.checkArgument(r102, "mSampleRate must be greater than 0.");
        this.mQueueMaxSize = 500;
        this.mBufferSize = r103 * 1024;
        return;
    L5:
        r105 = false;
        goto L6
    }

    private /* synthetic */ void lambda$setCallback$3(AudioStream.AudioStreamCallback r100, Executor r101) {
        this.mAudioStream.setCallback(r100, r101);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void setCallback(final AudioStream.AudioStreamCallback r100, final Executor r101) {
        boolean r102 = true;
        Preconditions.checkState(!this.mIsStarted.get(), "AudioStream can not be started when setCallback.");
        checkNotReleasedOrThrow();
        if (r100 == null) goto L7;
        if (r101 != null) goto L7;
        r102 = false;
    L7:
        Preconditions.checkArgument(r102, "executor can't be null with non-null callback.");
        this.mProducerExecutor.execute(new o(this, r100, r101));
    }
}

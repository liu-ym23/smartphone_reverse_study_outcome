package androidx.camera.video.internal.audio;

import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class SilentAudioStream implements AudioStream {
    private static final String TAG = "SilentAudioStream";
    private AudioStream.AudioStreamCallback mAudioStreamCallback;
    private final int mBytesPerFrame;
    private Executor mCallbackExecutor;
    private long mCurrentReadTimeNs;
    private final AtomicBoolean mIsReleased;
    private final AtomicBoolean mIsStarted;
    private final int mSampleRate;
    private byte[] mZeroBytes;

    public static /* synthetic */ void a(AudioStream.AudioStreamCallback r100) {
        lambda$notifySilenced$0(r100);
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    private void notifySilenced() {
        final AudioStream.AudioStreamCallback r100 = this.mAudioStreamCallback;
        Executor r101 = this.mCallbackExecutor;
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r101.execute(new u(r100));
        return;
    L8:
        return;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        this.mIsReleased.getAndSet(true);
    }

    private static long currentSystemTimeNs() {
        return System.nanoTime();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(true) == false) goto L5;
        return;
    L5:
        this.mCurrentReadTimeNs = currentSystemTimeNs();
        notifySilenced();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        checkNotReleasedOrThrow();
        this.mIsStarted.set(false);
    }

    public SilentAudioStream(AudioSettings r100) {
        this.mIsStarted = new AtomicBoolean(false);
        this.mIsReleased = new AtomicBoolean(false);
        this.mBytesPerFrame = r100.getBytesPerFrame();
        this.mSampleRate = r100.getSampleRate();
    }

    private static void blockUntilSystemTimeReached(long r100) {
        long r101 = r100 - currentSystemTimeNs();
        if (r101 <= 0) goto L11;
        Thread.sleep(TimeUnit.NANOSECONDS.toMillis(r101));     // Catch: InterruptedException -> L6
        return;
    L6:
        e = move-exception;
        Logger.w(TAG, "Ignore interruption", e);
        return;
    }

    private static /* synthetic */ void lambda$notifySilenced$0(AudioStream.AudioStreamCallback r100) {
        r100.onSilenceStateChanged(true);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.PacketInfo read(ByteBuffer r100) {
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        long r101 = AudioUtils.sizeToFrameCount(r100.remaining(), this.mBytesPerFrame);
        int r102 = (int) AudioUtils.frameCountToSize(r101, this.mBytesPerFrame);
        if (r102 <= 0) goto L5;
        long r103 = this.mCurrentReadTimeNs + AudioUtils.frameCountToDurationNs(r101, this.mSampleRate);
        blockUntilSystemTimeReached(r103);
        writeSilenceToBuffer(r100, r102);
        AudioStream.PacketInfo r104 = AudioStream.PacketInfo.of(r102, this.mCurrentReadTimeNs);
        this.mCurrentReadTimeNs = r103;
        return r104;
    L5:
        return AudioStream.PacketInfo.of(0, this.mCurrentReadTimeNs);
    }

    private void writeSilenceToBuffer(ByteBuffer r100, int r101) {
        if (r101 > r100.remaining()) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkState(r102);
        byte[] r103 = this.mZeroBytes;
        if (r103 != null) goto L9;
    L10:
        this.mZeroBytes = new byte[r101];
    L11:
        int r104 = r100.position();
        r100.put(this.mZeroBytes, 0, r101).limit(r101 + r104).position(r104);
        return;
    L9:
        if (r103.length >= r101) goto L11;
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void setCallback(AudioStream.AudioStreamCallback r100, Executor r101) {
        boolean r102 = true;
        Preconditions.checkState(!this.mIsStarted.get(), "AudioStream can not be started when setCallback.");
        checkNotReleasedOrThrow();
        if (r100 == null) goto L7;
        if (r101 != null) goto L7;
        r102 = false;
    L7:
        Preconditions.checkArgument(r102, "executor can't be null with non-null callback.");
        this.mAudioStreamCallback = r100;
        this.mCallbackExecutor = r101;
    }
}

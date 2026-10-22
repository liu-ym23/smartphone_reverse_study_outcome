package androidx.camera.video.internal.audio;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.Api23Impl;
import androidx.camera.video.internal.compat.Api24Impl;
import androidx.camera.video.internal.compat.Api29Impl;
import androidx.camera.video.internal.compat.Api31Impl;
import androidx.camera.video.internal.compat.quirk.AudioTimestampFramePositionIncorrectQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class AudioStreamImpl implements AudioStream {
    private static final long DIFF_LIMIT_FROM_SYSTEM_TIME_NS = 0;
    private static final String TAG = "AudioStreamImpl";
    private AudioRecord mAudioRecord;
    private AudioManager.AudioRecordingCallback mAudioRecordingCallback;
    private AudioStream.AudioStreamCallback mAudioStreamCallback;
    private final int mBufferSize;
    private final int mBytesPerFrame;
    private Executor mCallbackExecutor;
    private final AtomicBoolean mIsReleased;
    private final AtomicBoolean mIsStarted;
    private final AtomicReference<Boolean> mNotifiedSilenceState;
    private final AudioSettings mSettings;
    private boolean mShouldFallbackToSystemTime;
    private long mTotalFramesRead;

    public class AudioRecordingApi29Callback extends AudioManager.AudioRecordingCallback {
        final /* synthetic */ AudioStreamImpl this$0;

        public AudioRecordingApi29Callback(AudioStreamImpl r100) {
            this.this$0 = r100;
        }

        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> r100) {
            Iterator<AudioRecordingConfiguration> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L12;
            AudioRecordingConfiguration r102 = r101.next();
            if (Api24Impl.getClientAudioSessionId(r102) != AudioStreamImpl.access$000(this.this$0).getAudioSessionId()) goto L4;
            boolean r103 = Api29Impl.isClientSilenced(r102);
            this.this$0.notifySilenced(r103);
            return;
        }
    }

    public static /* synthetic */ void a(AudioStream.AudioStreamCallback r100, boolean r101) {
        lambda$notifySilenced$0(r100, r101);
    }

    static {
        DIFF_LIMIT_FROM_SYSTEM_TIME_NS = TimeUnit.MILLISECONDS.toNanos(500);
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    private long generatePresentationTimeNs() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L12:
        long r100 = -1;
    L14:
        if (r100 == (-1)) goto L16;
        return r100;
    L16:
        return System.nanoTime();
    L5:
        if (this.mShouldFallbackToSystemTime == true) goto L12;
        AudioTimestamp r101 = new AudioTimestamp();
        if (Api24Impl.getTimestamp(this.mAudioRecord, r101, 0) != 0) goto L11;
        r100 = AudioUtils.computeInterpolatedTimeNs(this.mSettings.getSampleRate(), this.mTotalFramesRead, r101);
        if (Math.abs(r100 - System.nanoTime()) <= DIFF_LIMIT_FROM_SYSTEM_TIME_NS) goto L14;
        this.mShouldFallbackToSystemTime = true;
        goto L12
    L11:
        Logger.w(TAG, "Unable to get audio timestamp");
        goto L12
    }

    private static boolean hasAudioTimestampQuirk() {
        if (DeviceQuirks.get(AudioTimestampFramePositionIncorrectQuirk.class) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        if (this.mIsReleased.getAndSet(true) == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L10;
        AudioManager.AudioRecordingCallback r100 = this.mAudioRecordingCallback;
        if (r100 == null) goto L10;
        Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, r100);
    L10:
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_release(this.mAudioRecord);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() throws AudioStream.AudioStreamException {
        checkNotReleasedOrThrow();
        boolean r100 = true;
        if (this.mIsStarted.getAndSet(true) == false) goto L6;
        return;
    L6:
        if (hasAudioTimestampQuirk() == false) goto L8;
        checkAudioRecordInitialStateOrReleaseAndThrow(this.mAudioRecord);
    L8:
        INVOKEVIRTUAL_androidx_camera_video_internal_audio_AudioStreamImpl_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(this.mAudioRecord);
        boolean r101 = false;
        if (this.mAudioRecord.getRecordingState() != 3) goto L21;
        this.mTotalFramesRead = 0;
        this.mShouldFallbackToSystemTime = false;
        this.mNotifiedSilenceState.set(null);
        if (Build.VERSION.SDK_INT < 29) goto L19;
        AudioRecordingConfiguration r102 = Api29Impl.getActiveRecordingConfiguration(this.mAudioRecord);
        if (r102 != null) goto L15;
    L17:
        r100 = false;
    L18:
        r101 = r100;
        goto L19
    L15:
        if (Api29Impl.isClientSilenced(r102) == false) goto L17;
    L19:
        notifySilenced(r101);
        return;
    L21:
        this.mIsStarted.set(false);
        throw new AudioStream.AudioStreamException("Unable to start AudioRecord with state: " + this.mAudioRecord.getRecordingState());
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(false) == true) goto L5;
        return;
    L5:
        INVOKEVIRTUAL_androidx_camera_video_internal_audio_AudioStreamImpl_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(this.mAudioRecord);
        if (this.mAudioRecord.getRecordingState() == 1) goto L9;
        Logger.w(TAG, "Failed to stop AudioRecord with state: " + this.mAudioRecord.getRecordingState());
    L9:
        if (hasAudioTimestampQuirk() == false) goto L12;
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_release(this.mAudioRecord);
        this.mAudioRecord = createAudioRecord(this.mBufferSize, this.mSettings, null);
        return;
    }

    public static void INVOKEVIRTUAL_androidx_camera_video_internal_audio_AudioStreamImpl_com_obric_performance_power_monitor_audioin_AudioInLancet_startRecording(AudioRecord r100) {
        if (fna.g.d() == true) goto L6;
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_startRecording(r100);
        return;
    L6:
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_startRecording(r100);
        if ((r100 instanceof AudioRecord) == false) goto L10;
        hna.a.b(r100.hashCode());
        return;
    }

    public static void INVOKEVIRTUAL_androidx_camera_video_internal_audio_AudioStreamImpl_com_obric_performance_power_monitor_audioin_AudioInLancet_stop(AudioRecord r100) {
        if (fna.g.d() == true) goto L6;
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_stop(r100);
        return;
    L6:
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_stop(r100);
        if ((r100 instanceof AudioRecord) == false) goto L10;
        hna.a.c(r100.hashCode());
        return;
    }

    public static /* synthetic */ AudioRecord access$000(AudioStreamImpl r100) {
        return r100.mAudioRecord;
    }

    private static void androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_release(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100403, "android/media/AudioRecord", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, true);
    }

    private static void androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_startRecording(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100400, "android/media/AudioRecord", "startRecording", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, false);
        return;
    L6:
        r110.startRecording();
        r100.a(100400, "android/media/AudioRecord", "startRecording", r110, r101, null, r111, true);
    }

    private static void androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_stop(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100401, "android/media/AudioRecord", "stop", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, false);
        return;
    L6:
        r110.stop();
        r100.a(100401, "android/media/AudioRecord", "stop", r110, r101, null, r111, true);
    }

    private static void checkAudioRecordInitialStateOrReleaseAndThrow(AudioRecord r100) throws AudioStream.AudioStreamException {
        if (r100.getState() != 1) goto L5;
        return;
    L5:
        androidx_camera_video_internal_audio_AudioStreamImpl_android_media_AudioRecord_release(r100);
        throw new AudioStream.AudioStreamException("Unable to initialize AudioRecord");
    }

    public void notifySilenced(final boolean r100) {
        Executor r101 = this.mCallbackExecutor;
        final AudioStream.AudioStreamCallback r102 = this.mAudioStreamCallback;
        if (r101 == null) goto L9;
        if (r102 != null) goto L6;
        return;
    L6:
        if (Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(r100)), Boolean.valueOf(r100)) == true) goto L11;
        r101.execute(new n(r102, r100));
        return;
    L11:
        return;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.PacketInfo read(ByteBuffer r100) {
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        int r101 = this.mAudioRecord.read(r100, this.mBufferSize);
        if (r101 <= 0) goto L5;
        r100.limit(r101);
        long r102 = generatePresentationTimeNs();
        this.mTotalFramesRead += AudioUtils.sizeToFrameCount(r101, this.mBytesPerFrame);
    L7:
        return AudioStream.PacketInfo.of(r101, r102);
    L5:
        r102 = 0;
        goto L7
    }

    public AudioStreamImpl(AudioSettings r100, Context r101) throws IllegalArgumentException, AudioStream.AudioStreamException {
        boolean r102 = false;
        this.mIsReleased = new AtomicBoolean(false);
        this.mIsStarted = new AtomicBoolean(false);
        this.mNotifiedSilenceState = new AtomicReference(null);
        this.mShouldFallbackToSystemTime = false;
        if (isSettingsSupported(r100.getSampleRate(), r100.getChannelCount(), r100.getAudioFormat()) == false) goto L10;
        this.mSettings = r100;
        this.mBytesPerFrame = r100.getBytesPerFrame();
        int r103 = getMinBufferSize(r100.getSampleRate(), r100.getChannelCount(), r100.getAudioFormat());
        if (r103 <= 0) goto L7;
        r102 = true;
    L7:
        Preconditions.checkState(r102);
        int r104 = r103 * 2;
        this.mBufferSize = r104;
        AudioRecord r105 = createAudioRecord(r104, r100, r101);
        this.mAudioRecord = r105;
        checkAudioRecordInitialStateOrReleaseAndThrow(r105);
        return;
    L10:
        throw new UnsupportedOperationException(String.format("The combination of sample rate %d, channel count %d and audio format %d is not supported.", new Object[]{Integer.valueOf(r100.getSampleRate()), Integer.valueOf(r100.getChannelCount()), Integer.valueOf(r100.getAudioFormat())}));
    }

    private static /* synthetic */ void lambda$notifySilenced$0(AudioStream.AudioStreamCallback r100, boolean r101) {
        r100.onSilenceStateChanged(r101);
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
        if (Build.VERSION.SDK_INT < 29) goto L19;
        AudioManager.AudioRecordingCallback r103 = this.mAudioRecordingCallback;
        if (r103 == null) goto L12;
        Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, r103);
    L12:
        if (r100 != null) goto L15;
        return;
    L15:
        if (this.mAudioRecordingCallback != null) goto L17;
        this.mAudioRecordingCallback = new AudioRecordingApi29Callback(this);
    L17:
        Api29Impl.registerAudioRecordingCallback(this.mAudioRecord, r101, this.mAudioRecordingCallback);
        return;
    }

    private static AudioRecord createAudioRecord(int r100, AudioSettings r101, Context r102) {
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 23) goto L11;
        AudioFormat r104 = new AudioFormat.Builder().setSampleRate(r101.getSampleRate()).setChannelMask(AudioUtils.channelCountToChannelMask(r101.getChannelCount())).setEncoding(r101.getAudioFormat()).build();
        AudioRecord.Builder r105 = Api23Impl.createAudioRecordBuilder();
        if (r103 < 31) goto L8;
        if (r102 == null) goto L8;
        Api31Impl.setContext(r105, r102);
    L8:
        Api23Impl.setAudioSource(r105, r101.getAudioSource());
        Api23Impl.setAudioFormat(r105, r104);
        Api23Impl.setBufferSizeInBytes(r105, r100);
        return Api23Impl.build(r105);
    L11:
        return new AudioRecord(r101.getAudioSource(), r101.getSampleRate(), AudioUtils.channelCountToChannelConfig(r101.getChannelCount()), r101.getAudioFormat(), r100);
    }

    private static int getMinBufferSize(int r100, int r101, int r102) {
        return AudioRecord.getMinBufferSize(r100, AudioUtils.channelCountToChannelConfig(r101), r102);
    }

    public static boolean isSettingsSupported(int r100, int r101, int r102) {
        if (r100 <= 0) goto L10;
        if (r101 > 0) goto L7;
        return false;
    L7:
        if (getMinBufferSize(r100, r101, r102) <= 0) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }
}

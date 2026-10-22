package androidx.camera.video.internal.audio;

import android.content.Context;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.AudioStats;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.encoder.InputBuffer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class AudioSource {
    static final long DEFAULT_START_RETRY_INTERVAL_MS = 3000;
    private static final String TAG = "AudioSource";
    private FutureCallback<InputBuffer> mAcquireBufferCallback;
    long mAmplitudeTimestamp;
    double mAudioAmplitude;
    private final int mAudioFormat;
    public final int mAudioSource;
    AudioSourceCallback mAudioSourceCallback;
    final AudioStream mAudioStream;
    boolean mAudioStreamSilenced;
    BufferProvider<? extends InputBuffer> mBufferProvider;
    BufferProvider.State mBufferProviderState;
    Executor mCallbackExecutor;
    final Executor mExecutor;
    boolean mInSilentStartState;
    boolean mIsSendingAudio;
    private long mLatestFailedStartTimeNs;
    boolean mMuted;
    final AtomicReference<Boolean> mNotifiedSilenceState;
    final AtomicBoolean mNotifiedSuspendState;
    final SilentAudioStream mSilentAudioStream;
    private final long mStartRetryIntervalNs;
    InternalState mState;
    private Observable.Observer<BufferProvider.State> mStateObserver;
    private byte[] mZeroBytes;

    public interface AudioSourceCallback {

        /* JADX INFO: renamed from: androidx.camera.video.internal.audio.AudioSource$AudioSourceCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onSuspendStateChanged(AudioSourceCallback r100, boolean r101) {
            }
        }

        void onAmplitudeValue(double r100);

        void onError(Throwable r100);

        void onSilenceStateChanged(boolean r100);

        void onSuspendStateChanged(boolean r100);
    }

    public class AudioStreamCallback implements AudioStream.AudioStreamCallback {
        final /* synthetic */ AudioSource this$0;

        public AudioStreamCallback(AudioSource r100) {
            this.this$0 = r100;
        }

        @Override // androidx.camera.video.internal.audio.AudioStream.AudioStreamCallback
        public void onSilenceStateChanged(boolean r100) {
            AudioSource r101 = this.this$0;
            r101.mAudioStreamSilenced = r100;
            if (r101.mState != InternalState.STARTED) goto L6;
            r101.notifySilenced();
            return;
        }
    }

    public static final enum InternalState extends Enum<InternalState> {
        private static final /* synthetic */ InternalState[] $VALUES = null;
        public static final InternalState CONFIGURED = null;
        public static final InternalState RELEASED = null;
        public static final InternalState STARTED = null;

        private static /* synthetic */ InternalState[] $values() {
            return new InternalState[]{CONFIGURED, STARTED, RELEASED};
        }

        static {
            CONFIGURED = new InternalState("CONFIGURED", 0);
            STARTED = new InternalState("STARTED", 1);
            RELEASED = new InternalState("RELEASED", 2);
            $VALUES = $values();
        }

        public static InternalState[] values() {
            return (InternalState[]) $VALUES.clone();
        }

        public static InternalState valueOf(String r100) {
            return (InternalState) r27.a.a(InternalState.class, r100);
        }

        private InternalState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ void a(AudioSource r100, AudioSourceCallback r101) {
        r100.lambda$postMaxAmplitude$11(r101);
    }

    public static /* synthetic */ void b(AudioSource r100) {
        r100.lambda$stop$3();
    }

    public static /* synthetic */ Object c(AudioSource r100, CallbackToFutureAdapter.Completer r101) {
        return r100.lambda$release$5(r101);
    }

    public static /* synthetic */ void d(AudioSource r100, CallbackToFutureAdapter.Completer r101) {
        r100.lambda$release$4(r101);
    }

    public static /* synthetic */ void e(AudioSource r100, boolean r101) {
        r100.lambda$start$2(r101);
    }

    public static /* synthetic */ void f(AudioSourceCallback r100, boolean r101) {
        lambda$notifySuspended$10(r100, r101);
    }

    public static /* synthetic */ void g(AudioSourceCallback r100, boolean r101) {
        lambda$notifySilenced$9(r100, r101);
    }

    public static /* synthetic */ void h(AudioSource r100, BufferProvider r101) {
        r100.lambda$setBufferProvider$0(r101);
    }

    public static /* synthetic */ void i(AudioSource r100) {
        r100.lambda$start$1();
    }

    public static /* synthetic */ void j(AudioSource r100, Executor r101, AudioSourceCallback r102) {
        r100.lambda$setAudioSourceCallback$6(r101, r102);
    }

    public static /* synthetic */ void k(AudioSource r100, boolean r101) {
        r100.lambda$mute$7(r101);
    }

    public static /* synthetic */ void l(AudioSourceCallback r100, Throwable r101) {
        lambda$notifyError$8(r100, r101);
    }

    private /* synthetic */ void lambda$start$1() {
        start(this.mMuted);
    }

    private /* synthetic */ void lambda$stop$3() {
        int r100 = this.mState.ordinal();
        if (r100 != 1) goto L5;
        setState(InternalState.CONFIGURED);
        updateSendingAudio();
        return;
    L5:
        if (r100 != 2) goto L11;
        Logger.w(TAG, "AudioSource is released. Calling stop() is a no-op.");
        return;
    }

    private void startSendingAudio() {
        if (this.mIsSendingAudio == false) goto L12;
        return;
    L12:
        Logger.d(TAG, "startSendingAudio");     // Catch: AudioStream.AudioStreamException -> L8
        this.mAudioStream.start();     // Catch: AudioStream.AudioStreamException -> L8
        this.mInSilentStartState = false;     // Catch: AudioStream.AudioStreamException -> L8
    L10:
        this.mIsSendingAudio = true;
        sendNextAudio();
        return;
    L8:
        e = move-exception;
        Logger.w(TAG, "Failed to start AudioStream", e);
        this.mInSilentStartState = true;
        this.mSilentAudioStream.start();
        this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
        notifySilenced();
        goto L10
    }

    private void stopSendingAudio() {
        if (this.mIsSendingAudio == true) goto L5;
        return;
    L5:
        this.mIsSendingAudio = false;
        Logger.d(TAG, "stopSendingAudio");
        this.mAudioStream.stop();
    }

    public AudioStream getCurrentAudioStream() {
        if (this.mInSilentStartState == false) goto L6;
        return this.mSilentAudioStream;
    L6:
        return this.mAudioStream;
    }

    public boolean isStartRetryIntervalReached() {
        if (this.mLatestFailedStartTimeNs <= 0) goto L5;
        boolean r100 = true;
    L6:
        Preconditions.checkState(r100);
        if ((getCurrentSystemTimeNs() - this.mLatestFailedStartTimeNs) >= this.mStartRetryIntervalNs) goto L11;
        return false;
    L11:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public void notifySilenced() {
        Executor r100 = this.mCallbackExecutor;
        final AudioSourceCallback r101 = this.mAudioSourceCallback;
        if (r100 == null) goto L18;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.mMuted == false) goto L8;
    L13:
        final boolean r102 = true;
    L15:
        if (Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(r102)), Boolean.valueOf(r102)) == true) goto L20;
        r100.execute(new b(r101, r102));
        return;
    L20:
        return;
    L8:
        if (this.mInSilentStartState == true) goto L13;
        if (this.mAudioStreamSilenced == true) goto L13;
        r102 = false;
        goto L15
    }

    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.getFuture(new h(this));
    }

    public void retryStartAudioStream() {
        Preconditions.checkState(this.mInSilentStartState);
        this.mAudioStream.start();     // Catch: AudioStream.AudioStreamException -> L5
        Logger.d(TAG, "Retry start AudioStream succeed");     // Catch: AudioStream.AudioStreamException -> L5
        this.mSilentAudioStream.stop();     // Catch: AudioStream.AudioStreamException -> L5
        this.mInSilentStartState = false;     // Catch: AudioStream.AudioStreamException -> L5
        return;
    L5:
        e = move-exception;
        Logger.w(TAG, "Retry start AudioStream failed", e);
        this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
    }

    public void sendNextAudio() {
        BufferProvider<? extends InputBuffer> r100 = this.mBufferProvider;
        Objects.requireNonNull(r100);
        ListenableFuture<? extends InputBuffer> r101 = r100.acquireBuffer();
        FutureCallback<InputBuffer> r102 = this.mAcquireBufferCallback;
        Objects.requireNonNull(r102);
        Futures.addCallback(r101, r102, this.mExecutor);
    }

    public void start() {
        this.mExecutor.execute(new f(this));
    }

    public void stop() {
        this.mExecutor.execute(new k(this));
    }

    public void updateSendingAudio() {
        if (this.mState == InternalState.STARTED) goto L5;
        stopSendingAudio();
        return;
    L5:
        if (this.mBufferProviderState != BufferProvider.State.ACTIVE) goto L7;
        boolean r100 = true;
    L8:
        notifySuspended(!r100);
        if (r100 == false) goto L11;
        startSendingAudio();
        return;
    L11:
        stopSendingAudio();
        return;
    L7:
        r100 = false;
        goto L8
    }

    private static long getCurrentSystemTimeNs() {
        return System.nanoTime();
    }

    private static BufferProvider.State fetchBufferProviderState(BufferProvider<? extends InputBuffer> r100) {
        ListenableFuture<? extends InputBuffer> r101 = r100.fetchData();     // Catch: Throwable -> L8
        if (r101.isDone() == false) goto L11;
        return (BufferProvider.State) r101.get();
    L11:
        return null;
    L12:
        return null;
    }

    private /* synthetic */ void lambda$mute$7(boolean r100) {
        int r101 = this.mState.ordinal();
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L10;
        return;
    L10:
        throw new AssertionError("AudioSource is released");
    L12:
        if (this.mMuted != r100) goto L14;
        return;
    L14:
        this.mMuted = r100;
        if (this.mState != InternalState.STARTED) goto L18;
        notifySilenced();
        return;
    }

    private /* synthetic */ void lambda$postMaxAmplitude$11(AudioSourceCallback r100) {
        r100.onAmplitudeValue(this.mAudioAmplitude);
    }

    private /* synthetic */ void lambda$release$4(CallbackToFutureAdapter.Completer r100) {
        int r101 = this.mState.ordinal();     // Catch: Throwable -> L10
        if (r101 != 0) goto L5;
    L7:
        resetBufferProvider(null);     // Catch: Throwable -> L10
        this.mSilentAudioStream.release();     // Catch: Throwable -> L10
        this.mAudioStream.release();     // Catch: Throwable -> L10
        stopSendingAudio();     // Catch: Throwable -> L10
        setState(InternalState.RELEASED);     // Catch: Throwable -> L10
    L8:
        r100.set(null);     // Catch: Throwable -> L10
        return;
    L5:
        if (r101 == 1) goto L7;
    L10:
        th = move-exception;
        r100.setException(th);
    }

    private /* synthetic */ Object lambda$release$5(final CallbackToFutureAdapter.Completer r100) throws Exception {
        this.mExecutor.execute(new l(this, r100));
        return "AudioSource-release";
    }

    private /* synthetic */ void lambda$setBufferProvider$0(BufferProvider r100) {
        int r101 = this.mState.ordinal();
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L10;
        return;
    L10:
        throw new AssertionError("AudioSource is released");
    L12:
        if (this.mBufferProvider == r100) goto L15;
        resetBufferProvider(r100);
        return;
    }

    private /* synthetic */ void lambda$start$2(boolean r100) {
        int r101 = this.mState.ordinal();
        if (r101 != 0) goto L5;
        this.mNotifiedSilenceState.set(null);
        this.mNotifiedSuspendState.set(false);
        setState(InternalState.STARTED);
        mute(r100);
        updateSendingAudio();
        return;
    L5:
        if (r101 == 2) goto L8;
        return;
    L8:
        throw new AssertionError("AudioSource is released");
    }

    private void resetBufferProvider(final BufferProvider<? extends InputBuffer> r100) {
        BufferProvider<? extends InputBuffer> r101 = this.mBufferProvider;
        if (r101 == null) goto L5;
        Observable.Observer<BufferProvider.State> r102 = this.mStateObserver;
        Objects.requireNonNull(r102);
        r101.removeObserver(r102);
        this.mBufferProvider = null;
        this.mStateObserver = null;
        this.mAcquireBufferCallback = null;
        this.mBufferProviderState = BufferProvider.State.INACTIVE;
        updateSendingAudio();
    L5:
        if (r100 == null) goto L11;
        this.mBufferProvider = r100;
        this.mStateObserver = new AnonymousClass1(this, r100);
        this.mAcquireBufferCallback = new AnonymousClass2(this, r100);
        BufferProvider.State r103 = fetchBufferProviderState(r100);
        if (r103 == null) goto L9;
        this.mBufferProviderState = r103;
        updateSendingAudio();
    L9:
        this.mBufferProvider.addObserver(this.mExecutor, this.mStateObserver);
        return;
    }

    public void mute(final boolean r100) {
        this.mExecutor.execute(new c(this, r100));
    }

    public void notifyError(final Throwable r100) {
        Executor r101 = this.mCallbackExecutor;
        final AudioSourceCallback r102 = this.mAudioSourceCallback;
        if (r101 == null) goto L7;
        if (r102 == null) goto L8;
        r101.execute(new d(r102, r100));
        return;
    L8:
        return;
    }

    public void notifySuspended(final boolean r100) {
        Executor r101 = this.mCallbackExecutor;
        final AudioSourceCallback r102 = this.mAudioSourceCallback;
        if (r101 == null) goto L9;
        if (r102 != null) goto L6;
        return;
    L6:
        if (this.mNotifiedSuspendState.getAndSet(r100) == r100) goto L11;
        r101.execute(new g(r102, r100));
        return;
    L11:
        return;
    }

    public void postMaxAmplitude(ByteBuffer r100) {
        Executor r101 = this.mCallbackExecutor;
        final AudioSourceCallback r102 = this.mAudioSourceCallback;
        if (this.mAudioFormat != 2) goto L14;
        ShortBuffer r103 = r100.asShortBuffer();
        double r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        if (r103.hasRemaining() == false) goto L8;
        r104 = Math.max(r104, Math.abs(r103.get()));
        goto L6
    L8:
        this.mAudioAmplitude = r104 / 32767.0d;
        if (r101 == null) goto L15;
        if (r102 == null) goto L16;
        r101.execute(new m(this, r102));
        return;
    L16:
        return;
    L15:
        return;
    }

    public void setBufferProvider(final BufferProvider<? extends InputBuffer> r100) {
        this.mExecutor.execute(new a(this, r100));
    }

    public void setState(InternalState r100) {
        Logger.d(TAG, "Transitioning internal state: " + this.mState + " --> " + r100);
        this.mState = r100;
    }

    public void start(final boolean r100) {
        this.mExecutor.execute(new e(this, r100));
    }

    private static /* synthetic */ void lambda$notifyError$8(AudioSourceCallback r100, Throwable r101) {
        r100.onError(r101);
    }

    private static /* synthetic */ void lambda$notifySilenced$9(AudioSourceCallback r100, boolean r101) {
        r100.onSilenceStateChanged(r101);
    }

    private static /* synthetic */ void lambda$notifySuspended$10(AudioSourceCallback r100, boolean r101) {
        r100.onSuspendStateChanged(r101);
    }

    private /* synthetic */ void lambda$setAudioSourceCallback$6(Executor r100, AudioSourceCallback r101) {
        int r102 = this.mState.ordinal();
        if (r102 != 0) goto L5;
        this.mCallbackExecutor = r100;
        this.mAudioSourceCallback = r101;
        return;
    L5:
        if (r102 == 1) goto L10;
        if (r102 == 2) goto L10;
        return;
    L10:
        throw new AssertionError("The audio recording callback must be registered before the audio source is started.");
    }

    public void overrideBySilence(ByteBuffer r100, int r101) {
        byte[] r102 = this.mZeroBytes;
        if (r102 != null) goto L5;
    L6:
        this.mZeroBytes = new byte[r101];
    L7:
        int r103 = r100.position();
        r100.put(this.mZeroBytes, 0, r101);
        r100.limit(r100.position()).position(r103);
        return;
    L5:
        if (r102.length >= r101) goto L7;
        goto L6
    }

    public void setAudioSourceCallback(final Executor r100, final AudioSourceCallback r101) {
        this.mExecutor.execute(new j(this, r100, r101));
    }

    public AudioSource(AudioSettings r100, Executor r101, Context r110) throws AudioSourceAccessException {
        this(r100, r101, r110, new i(), 3000);
    }

    public static boolean isSettingsSupported(int r100, int r101, int r102) {
        return AudioStreamImpl.isSettingsSupported(r100, r101, r102);
    }

    public AudioSource(AudioSettings r100, Executor r101, Context r102, AudioStreamFactory r103, long r104) throws AudioSourceAccessException {
        this.mNotifiedSilenceState = new AtomicReference(null);
        this.mNotifiedSuspendState = new AtomicBoolean(false);
        this.mState = InternalState.CONFIGURED;
        this.mBufferProviderState = BufferProvider.State.INACTIVE;
        this.mAmplitudeTimestamp = 0;
        Executor r105 = CameraXExecutors.newSequentialExecutor(r101);
        this.mExecutor = r105;
        this.mStartRetryIntervalNs = TimeUnit.MILLISECONDS.toNanos(r104);
        BufferedAudioStream r106 = new BufferedAudioStream(r103.create(r100, r102), r100);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
        this.mAudioStream = r106;     // Catch: Throwable -> L6 IllegalArgumentException -> L8
        r106.setCallback(new AudioStreamCallback(this), r105);
        this.mSilentAudioStream = new SilentAudioStream(r100);
        this.mAudioFormat = r100.getAudioFormat();
        this.mAudioSource = r100.getAudioSource();
        return;
    L6:
        e = move-exception;
        throw new AudioSourceAccessException("Unable to create AudioStream", e);
    }
}

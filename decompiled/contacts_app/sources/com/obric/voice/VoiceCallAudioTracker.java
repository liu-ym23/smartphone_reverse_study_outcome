package com.obric.voice;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.GlobalProxyLancet;
import com.android.common.speech.LoggingEvents;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VoiceCallAudioTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0019J\b\u0010 \u001a\u00020\u0019H\u0002J\u0006\u0010!\u001a\u00020\u0019R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/voice/VoiceCallAudioTracker;", "", "()V", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "audioTrack", "Landroid/media/AudioTrack;", "bufferSize", "", "getBufferSize", "()I", "bufferSize$delegate", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "isFlush", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sampleRateInHz", "createAudioTrackAndPlay", LoggingEvents.EXTRA_FLUSH, "", "getDevice", "Landroid/media/AudioDeviceInfo;", "play", "data", "", "prepare", "releaseAudioTrack", "tearDown", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VoiceCallAudioTracker {
    public static final Companion Companion = null;
    public static final int DEFAULT_SAMPLE_RATE_IN_HZ = 24000;
    private static final int MSG_FLUSH = 4;
    private static final int MSG_PLAY = 1;
    private static final int MSG_PREPARE = 3;
    private static final int MSG_TEAR_DOWN = 2;
    private static final String TAG = "VoiceCallAudioTracker";
    private static final int TRACK_AUDIO_FORMAT = 2;
    private static final int TRACK_CHANNEL_CONFIG = 4;
    private static final int TRACK_DEVICE_TYPE = 2;
    private static final int TRACK_MODE = 1;
    private static final int TRACK_STREAM_TYPE = 3;
    private final Lazy audioManager$delegate;
    private AudioTrack audioTrack;
    private final Lazy bufferSize$delegate;
    private final Handler handler;
    private final HandlerThread handlerThread;
    private final AtomicBoolean isFlush;
    private int sampleRateInHz;

    /* JADX INFO: compiled from: VoiceCallAudioTracker.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/voice/VoiceCallAudioTracker$Companion;", "", "()V", "DEFAULT_SAMPLE_RATE_IN_HZ", "", "MSG_FLUSH", "MSG_PLAY", "MSG_PREPARE", "MSG_TEAR_DOWN", "TAG", "", "TRACK_AUDIO_FORMAT", "TRACK_CHANNEL_CONFIG", "TRACK_DEVICE_TYPE", "TRACK_MODE", "TRACK_STREAM_TYPE", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VoiceCallAudioTracker() {
        this.audioManager$delegate = LazyKt.lazy(VoiceCallAudioTracker$audioManager$2.INSTANCE);
        this.sampleRateInHz = DEFAULT_SAMPLE_RATE_IN_HZ;
        this.bufferSize$delegate = LazyKt.lazy(new VoiceCallAudioTracker$bufferSize$2(this));
        HandlerThread r0 = new HandlerThread(TAG);
        this.handlerThread = r0;
        this.isFlush = new AtomicBoolean(false);
        r0.start();
        final Looper r1 = r0.getLooper();
        this.handler = new AnonymousClass1(this, r1);
    }

    public static final /* synthetic */ AudioTrack access$createAudioTrackAndPlay(VoiceCallAudioTracker r0) {
        return r0.createAudioTrackAndPlay();
    }

    public static final /* synthetic */ AudioTrack access$getAudioTrack$p(VoiceCallAudioTracker r0) {
        return r0.audioTrack;
    }

    public static final /* synthetic */ int access$getBufferSize(VoiceCallAudioTracker r0) {
        return r0.getBufferSize();
    }

    public static final /* synthetic */ int access$getSampleRateInHz$p(VoiceCallAudioTracker r0) {
        return r0.sampleRateInHz;
    }

    public static final /* synthetic */ AtomicBoolean access$isFlush$p(VoiceCallAudioTracker r0) {
        return r0.isFlush;
    }

    public static final /* synthetic */ void access$releaseAudioTrack(VoiceCallAudioTracker r0) {
        r0.releaseAudioTrack();
    }

    public static final /* synthetic */ void access$setAudioTrack$p(VoiceCallAudioTracker r0, AudioTrack r1) {
        r0.audioTrack = r1;
    }

    private final AudioManager getAudioManager() {
        return (AudioManager) this.audioManager$delegate.getValue();
    }

    private final int getBufferSize() {
        return ((Number) this.bufferSize$delegate.getValue()).intValue();
    }

    public final void prepare() {
        this.handler.sendEmptyMessage(3);
    }

    public final void play(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        this.isFlush.set(false);
        Handler r2 = this.handler;
        r2.sendMessage(r2.obtainMessage(1, r3));
    }

    public final void flush() {
        this.isFlush.set(true);
        this.handler.sendEmptyMessage(4);
    }

    public final void tearDown() {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.sendEmptyMessage(2);
    }

    private final AudioTrack createAudioTrackAndPlay() {
        AudioTrack r7 = new AudioTrack(3, this.sampleRateInHz, 4, 2, getBufferSize(), 1);
        r7.play();
        return r7;
    }

    private final void releaseAudioTrack() {
        AudioTrack r0 = this.audioTrack;
        if (r0 == null) goto L15;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        VoiceCallAudioTracker r2 = this;     // Catch: Throwable -> L6
        r0.stop();     // Catch: Throwable -> L6
        r0.release();     // Catch: Throwable -> L6
        Object r3 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r4 = Result.m806exceptionOrNullimpl(r3);
        if (r4 == null) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "releaseAudioTrack error! " + ExceptionsKt.stackTraceToString(r4));
        return;
    L16:
        return;
    L6:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final AudioDeviceInfo getDevice() {
        AudioDeviceInfo[] r6 = getAudioManager().getDevices(2);
        Intrinsics.checkNotNullExpressionValue(r6, "devices");
        int r1 = r6.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L10;
        AudioDeviceInfo r4 = r6[r2];
        if (r4.getType() == 2) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getDevice success, device: " + r4);
        return r4;
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getDevice error! return null.");
        return null;
    }
}

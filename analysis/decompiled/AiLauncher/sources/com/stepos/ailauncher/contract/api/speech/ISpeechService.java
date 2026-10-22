package com.stepos.ailauncher.contract.api.speech;

import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.d;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\fJ3\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0013H\u0016¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010\u0004J#\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H&¢\u0006\u0004\b(\u0010)J\u001d\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0007H&¢\u0006\u0004\b-\u0010\fJ\u000f\u0010.\u001a\u00020\u0002H&¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0007H\u0016¢\u0006\u0004\b/\u0010\fJ\u000f\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b0\u0010\fJ\u0017\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0007H&¢\u0006\u0004\b5\u0010\f¨\u00066À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/speech/ISpeechService;", "", "", "isAsrAvailable", "()Z", "Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "callback", "LY8/t;", "startListening", "(Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;)V", "startManualRecording", "prewarmManualCapture", "()V", "cancelCapturePrewarm", "startSlaOnlyRecording", "startSlaOnlyListening", "stopAndFinalize", "cancelAsr", "armStartHapticPcmSkip", "", "silenceTimeoutMs", "listenTimeoutMs", "muteTimeoutMs", "setListeningConfig", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "timeoutMs", "setLongPressTimeoutMs", "(Ljava/lang/Long;)V", d.EXTRA_ENABLED, "setVadEnabled", "(Z)V", "getLongPressTimeoutMs", "()J", "getLongPressRemainingMs", "getRecordingRemainingMs", "isTtsAvailable", "", "text", "Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", "listener", "speak", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/speech/TtsListener;)V", "Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", "startStreamSpeak", "(Lcom/stepos/ailauncher/contract/api/speech/TtsListener;)Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", "stopSpeak", "isSpeaking", "pauseSpeak", "resumeSpeak", "", "gain", "setSpeakDuckGain", "(F)V", "destroy", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ISpeechService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void armStartHapticPcmSkip(ISpeechService iSpeechService) {
            ISpeechService.super.armStartHapticPcmSkip();
        }

        @Deprecated
        public static void cancelCapturePrewarm(ISpeechService iSpeechService) {
            ISpeechService.super.cancelCapturePrewarm();
        }

        @Deprecated
        public static long getLongPressRemainingMs(ISpeechService iSpeechService) {
            return ISpeechService.super.getLongPressRemainingMs();
        }

        @Deprecated
        public static long getLongPressTimeoutMs(ISpeechService iSpeechService) {
            return ISpeechService.super.getLongPressTimeoutMs();
        }

        @Deprecated
        public static long getRecordingRemainingMs(ISpeechService iSpeechService) {
            return ISpeechService.super.getRecordingRemainingMs();
        }

        @Deprecated
        public static void pauseSpeak(ISpeechService iSpeechService) {
            ISpeechService.super.pauseSpeak();
        }

        @Deprecated
        public static void prewarmManualCapture(ISpeechService iSpeechService) {
            ISpeechService.super.prewarmManualCapture();
        }

        @Deprecated
        public static void resumeSpeak(ISpeechService iSpeechService) {
            ISpeechService.super.resumeSpeak();
        }

        @Deprecated
        public static void setListeningConfig(ISpeechService iSpeechService, Long l10, Long l11, Long l12) {
            ISpeechService.super.setListeningConfig(l10, l11, l12);
        }

        @Deprecated
        public static void setLongPressTimeoutMs(ISpeechService iSpeechService, Long l10) {
            ISpeechService.super.setLongPressTimeoutMs(l10);
        }

        @Deprecated
        public static void setSpeakDuckGain(ISpeechService iSpeechService, float f10) {
            ISpeechService.super.setSpeakDuckGain(f10);
        }

        @Deprecated
        public static void setVadEnabled(ISpeechService iSpeechService, boolean z10) {
            ISpeechService.super.setVadEnabled(z10);
        }

        @Deprecated
        public static void startSlaOnlyListening(ISpeechService iSpeechService, AsrCallback callback) {
            p.i(callback, "callback");
            ISpeechService.super.startSlaOnlyListening(callback);
        }

        @Deprecated
        public static void startSlaOnlyRecording(ISpeechService iSpeechService, AsrCallback callback) {
            p.i(callback, "callback");
            ISpeechService.super.startSlaOnlyRecording(callback);
        }

        @Deprecated
        public static TtsStreamSession startStreamSpeak(ISpeechService iSpeechService, TtsListener ttsListener) {
            return ISpeechService.super.startStreamSpeak(ttsListener);
        }
    }

    static /* synthetic */ void setListeningConfig$default(ISpeechService iSpeechService, Long l10, Long l11, Long l12, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setListeningConfig");
        }
        if ((i10 & 1) != 0) {
            l10 = null;
        }
        if ((i10 & 2) != 0) {
            l11 = null;
        }
        if ((i10 & 4) != 0) {
            l12 = null;
        }
        iSpeechService.setListeningConfig(l10, l11, l12);
    }

    static /* synthetic */ void speak$default(ISpeechService iSpeechService, String str, TtsListener ttsListener, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: speak");
        }
        if ((i10 & 2) != 0) {
            ttsListener = null;
        }
        iSpeechService.speak(str, ttsListener);
    }

    static /* synthetic */ TtsStreamSession startStreamSpeak$default(ISpeechService iSpeechService, TtsListener ttsListener, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startStreamSpeak");
        }
        if ((i10 & 1) != 0) {
            ttsListener = null;
        }
        return iSpeechService.startStreamSpeak(ttsListener);
    }

    default void armStartHapticPcmSkip() {
    }

    void cancelAsr();

    default void cancelCapturePrewarm() {
    }

    void destroy();

    default long getLongPressRemainingMs() {
        return -1L;
    }

    default long getLongPressTimeoutMs() {
        return 0L;
    }

    default long getRecordingRemainingMs() {
        return -1L;
    }

    boolean isAsrAvailable();

    boolean isSpeaking();

    boolean isTtsAvailable();

    default void pauseSpeak() {
    }

    default void prewarmManualCapture() {
    }

    default void resumeSpeak() {
    }

    default void setListeningConfig(Long silenceTimeoutMs, Long listenTimeoutMs, Long muteTimeoutMs) {
    }

    default void setLongPressTimeoutMs(Long timeoutMs) {
    }

    default void setSpeakDuckGain(float gain) {
    }

    default void setVadEnabled(boolean enabled) {
    }

    void speak(String text, TtsListener listener);

    void startListening(AsrCallback callback);

    void startManualRecording(AsrCallback callback);

    default void startSlaOnlyListening(AsrCallback callback) {
        p.i(callback, "callback");
    }

    default void startSlaOnlyRecording(AsrCallback callback) {
        p.i(callback, "callback");
    }

    default TtsStreamSession startStreamSpeak(TtsListener listener) {
        return null;
    }

    void stopAndFinalize();

    void stopSpeak();
}

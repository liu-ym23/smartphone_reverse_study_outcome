package com.stepos.ailauncher.speech.asr;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.speech.AsrCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0010\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\tH&¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ3\u0010\u001a\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0016H\u0016¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\"\u0010 J\u0017\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010%¨\u0006&À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/speech/asr/c;", "", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Z", "Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "callback", "LY8/t;", "startListening", "(Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;)V", Const.INTENT_KEY_PKGNAME, "c", "()V", "cancelCapturePrewarm", Const.INTENT_KEY_UMID, "startSlaOnlyListening", "stopAndFinalize", "cancel", "destroy", "armStartHapticPcmSkip", "", "silenceTimeoutMs", "listenTimeoutMs", "muteTimeoutMs", "setListeningConfig", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "timeoutMs", "setLongPressTimeoutMs", "(Ljava/lang/Long;)V", "getLongPressTimeoutMs", "()J", "getLongPressRemainingMs", "getRecordingRemainingMs", x5.d.EXTRA_ENABLED, "setVadEnabled", "(Z)V", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface c {
    boolean a(Context context);

    default void armStartHapticPcmSkip() {
    }

    void b(AsrCallback callback);

    default void c() {
    }

    void cancel();

    default void cancelCapturePrewarm() {
    }

    default void d(AsrCallback callback) {
        p.i(callback, "callback");
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

    default void setListeningConfig(Long silenceTimeoutMs, Long listenTimeoutMs, Long muteTimeoutMs) {
    }

    default void setLongPressTimeoutMs(Long timeoutMs) {
    }

    default void setVadEnabled(boolean enabled) {
    }

    void startListening(AsrCallback callback);

    default void startSlaOnlyListening(AsrCallback callback) {
        p.i(callback, "callback");
    }

    void stopAndFinalize();
}

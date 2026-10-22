package com.stepos.ailauncher.contract.api.speech;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0017\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u000e¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/speech/AsrCallback;", "", "", "text", "LY8/t;", "onPartialResult", "(Ljava/lang/String;)V", "onFinalResult", "", "code", "message", "onError", "(ILjava/lang/String;)V", "onRecordingStarted", "()V", "onRecordingStopped", "", "data", "onAudioFrame", "([S)V", "onSpeechDetected", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AsrCallback {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onSpeechDetected(AsrCallback asrCallback) {
            AsrCallback.super.onSpeechDetected();
        }
    }

    void onAudioFrame(short[] data);

    void onError(int code, String message);

    void onFinalResult(String text);

    void onPartialResult(String text);

    void onRecordingStarted();

    void onRecordingStopped();

    default void onSpeechDetected() {
    }
}

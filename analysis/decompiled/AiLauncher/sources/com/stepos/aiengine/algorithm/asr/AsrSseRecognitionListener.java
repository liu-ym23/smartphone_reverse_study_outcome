package com.stepos.aiengine.algorithm.asr;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrSseRecognitionListener;", "", "", "source", "LY8/t;", "onRoutingDecision", "(Ljava/lang/String;)V", "delta", "onRecognizing", "Lcom/stepos/aiengine/algorithm/asr/AsrSseRecognitionResult;", "result", "onComplete", "(Lcom/stepos/aiengine/algorithm/asr/AsrSseRecognitionResult;)V", "", "errorCode", "message", "onError", "(ILjava/lang/String;)V", "onCancelled", "()V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AsrSseRecognitionListener {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCancelled(AsrSseRecognitionListener asrSseRecognitionListener) {
        }

        public static void onError(AsrSseRecognitionListener asrSseRecognitionListener, int i10, String message) {
            p.i(message, "message");
        }

        public static void onRecognizing(AsrSseRecognitionListener asrSseRecognitionListener, String delta) {
            p.i(delta, "delta");
        }

        public static void onRoutingDecision(AsrSseRecognitionListener asrSseRecognitionListener, String source) {
            p.i(source, "source");
        }
    }

    void onCancelled();

    void onComplete(AsrSseRecognitionResult result);

    void onError(int errorCode, String message);

    void onRecognizing(String delta);

    void onRoutingDecision(String source);
}

package com.stepos.aiengine.algorithm.asr;

import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrStreamRecognitionListener;", "", "", "index", "LC7/r;", "onSpeechStart", "(I)V", "", "delta", "", "startTime", "endTime", "onRecognizing", "(ILjava/lang/String;JJ)V", "Lcom/stepos/aiengine/algorithm/asr/AsrRecognitionResult;", "result", "onRecognized", "(Lcom/stepos/aiengine/algorithm/asr/AsrRecognitionResult;)V", "onComplete", "()V", "onCancelled", "errorCode", "message", "onError", "(ILjava/lang/String;)V", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AsrStreamRecognitionListener {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCancelled(AsrStreamRecognitionListener asrStreamRecognitionListener) {
        }

        public static void onRecognizing(AsrStreamRecognitionListener asrStreamRecognitionListener, int i, String delta, long j5, long j6) {
            k.f(delta, "delta");
        }

        public static void onRoutingDecision(AsrStreamRecognitionListener asrStreamRecognitionListener, String executionLocation, String reason) {
            k.f(executionLocation, "executionLocation");
            k.f(reason, "reason");
        }

        public static void onSpeechStart(AsrStreamRecognitionListener asrStreamRecognitionListener, int i) {
        }
    }

    void onCancelled();

    void onComplete();

    void onError(int errorCode, String message);

    void onRecognized(AsrRecognitionResult result);

    void onRecognizing(int index, String delta, long startTime, long endTime);

    void onRoutingDecision(String executionLocation, String reason);

    void onSpeechStart(int index);
}

package com.stepos.aiengine.algorithm.asr;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0007J\u000f\u0010\u0019\u001a\u00020\u0005H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamListener;", "", "", "executionLocation", "reason", "LY8/t;", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;)V", "", "index", "onSpeechStart", "(I)V", "delta", "", "startTime", "endTime", "onRecognizing", "(ILjava/lang/String;JJ)V", "Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamResult;", "result", "onRecognized", "(Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamResult;)V", "code", "message", "onWarning", "onComplete", "()V", "onCancelled", "errorCode", "onError", "(ILjava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AsrSseStreamListener {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCancelled(AsrSseStreamListener asrSseStreamListener) {
        }

        public static void onRecognizing(AsrSseStreamListener asrSseStreamListener, int i10, String delta, long j10, long j11) {
            p.i(delta, "delta");
        }

        public static void onRoutingDecision(AsrSseStreamListener asrSseStreamListener, String executionLocation, String reason) {
            p.i(executionLocation, "executionLocation");
            p.i(reason, "reason");
        }

        public static void onSpeechStart(AsrSseStreamListener asrSseStreamListener, int i10) {
        }

        public static void onWarning(AsrSseStreamListener asrSseStreamListener, String code, String message) {
            p.i(code, "code");
            p.i(message, "message");
        }
    }

    void onCancelled();

    void onComplete();

    void onError(int errorCode, String message);

    void onRecognized(AsrSseStreamResult result);

    void onRecognizing(int index, String delta, long startTime, long endTime);

    void onRoutingDecision(String executionLocation, String reason);

    void onSpeechStart(int index);

    void onWarning(String code, String message);
}

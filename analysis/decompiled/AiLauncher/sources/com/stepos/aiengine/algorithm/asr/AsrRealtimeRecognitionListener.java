package com.stepos.aiengine.algorithm.asr;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J7\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionListener;", "", "", "index", "LY8/t;", "onSpeechStart", "(I)V", "", "delta", "stash", "", "startTime", "endTime", "onRecognizing", "(ILjava/lang/String;Ljava/lang/String;JJ)V", "Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionResult;", "result", "onRecognized", "(Lcom/stepos/aiengine/algorithm/asr/AsrRealtimeRecognitionResult;)V", "errorCode", "message", "onSegmentBlocked", "(IILjava/lang/String;)V", "onComplete", "()V", "onCancelled", "onError", "(ILjava/lang/String;)V", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AsrRealtimeRecognitionListener {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCancelled(AsrRealtimeRecognitionListener asrRealtimeRecognitionListener) {
        }

        public static void onRecognizing(AsrRealtimeRecognitionListener asrRealtimeRecognitionListener, int i10, String delta, String stash, long j10, long j11) {
            p.i(delta, "delta");
            p.i(stash, "stash");
        }

        public static void onRoutingDecision(AsrRealtimeRecognitionListener asrRealtimeRecognitionListener, String executionLocation, String reason) {
            p.i(executionLocation, "executionLocation");
            p.i(reason, "reason");
        }

        public static void onSegmentBlocked(AsrRealtimeRecognitionListener asrRealtimeRecognitionListener, int i10, int i11, String message) {
            p.i(message, "message");
        }

        public static void onSpeechStart(AsrRealtimeRecognitionListener asrRealtimeRecognitionListener, int i10) {
        }
    }

    void onCancelled();

    void onComplete();

    void onError(int errorCode, String message);

    void onRecognized(AsrRealtimeRecognitionResult result);

    void onRecognizing(int index, String delta, String stash, long startTime, long endTime);

    void onRoutingDecision(String executionLocation, String reason);

    void onSegmentBlocked(int index, int errorCode, String message);

    void onSpeechStart(int index);
}

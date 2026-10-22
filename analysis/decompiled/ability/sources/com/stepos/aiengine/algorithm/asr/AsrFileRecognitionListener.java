package com.stepos.aiengine.algorithm.asr;

import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J'\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionListener;", "", "", SingleFileBundle.KEY_FILE_DESCRIPTOR, "", "index", "LC7/r;", "onSpeechStart", "(JI)V", "Lcom/stepos/aiengine/algorithm/asr/AsrUtterance;", "utterance", "onRecognizing", "(Lcom/stepos/aiengine/algorithm/asr/AsrUtterance;)V", "Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionResult;", "result", "onRecognized", "(Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionResult;)V", "onComplete", "()V", "onCancelled", "errorCode", "", "message", "onFileError", "(JILjava/lang/String;)V", "onError", "(ILjava/lang/String;)V", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AsrFileRecognitionListener {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCancelled(AsrFileRecognitionListener asrFileRecognitionListener) {
        }

        public static void onComplete(AsrFileRecognitionListener asrFileRecognitionListener) {
        }

        public static void onFileError(AsrFileRecognitionListener asrFileRecognitionListener, long j5, int i, String message) {
            k.f(message, "message");
        }

        public static void onRecognizing(AsrFileRecognitionListener asrFileRecognitionListener, AsrUtterance utterance) {
            k.f(utterance, "utterance");
        }

        public static void onRoutingDecision(AsrFileRecognitionListener asrFileRecognitionListener, String executionLocation, String reason) {
            k.f(executionLocation, "executionLocation");
            k.f(reason, "reason");
        }

        public static void onSpeechStart(AsrFileRecognitionListener asrFileRecognitionListener, long j5, int i) {
        }
    }

    void onCancelled();

    void onComplete();

    void onError(int errorCode, String message);

    void onFileError(long fd, int errorCode, String message);

    void onRecognized(AsrFileRecognitionResult result);

    void onRecognizing(AsrUtterance utterance);

    void onRoutingDecision(String executionLocation, String reason);

    void onSpeechStart(long fd, int index);
}

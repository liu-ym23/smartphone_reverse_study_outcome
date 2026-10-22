package com.stepos.aiengine.algorithm.voice;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJE\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/aiengine/algorithm/voice/SpeechRecognitionCallback;", "", AppAgent.CONSTRUCT, "()V", "", "text", "LC7/r;", "onPartialResult", "(Ljava/lang/String;)V", "language", "emotion", NotificationCompat.CATEGORY_EVENT, "", "withItn", "", "Lcom/stepos/aiengine/algorithm/voice/SpeechRecognitionSegment;", "segments", "onFinalResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "", "errorCode", "message", "onError", "(ILjava/lang/String;)V", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;)V", "index", "onFileResult", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "onFileError", "(IILjava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SpeechRecognitionCallback {
    public void onError(int errorCode, String message) {
        k.f(message, "message");
    }

    public void onFileError(int index, int errorCode, String message) {
        k.f(message, "message");
    }

    public void onFileResult(int index, String language, String emotion, String event, boolean withItn, List<SpeechRecognitionSegment> segments) {
        k.f(language, "language");
        k.f(emotion, "emotion");
        k.f(event, "event");
        k.f(segments, "segments");
    }

    public abstract void onFinalResult(String language, String emotion, String event, boolean withItn, List<SpeechRecognitionSegment> segments);

    public void onPartialResult(String text) {
        k.f(text, "text");
    }

    public void onRoutingDecision(String executionLocation, String reason) {
        k.f(executionLocation, "executionLocation");
        k.f(reason, "reason");
    }
}

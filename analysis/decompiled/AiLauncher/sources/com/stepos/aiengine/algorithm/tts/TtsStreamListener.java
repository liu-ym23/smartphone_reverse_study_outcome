package com.stepos.aiengine.algorithm.tts;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004J\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/aiengine/algorithm/tts/TtsStreamListener;", "", "LY8/t;", "onOpened", "()V", "", "pcm", "", "sampleRate", "channelCount", "encoding", "onAudioChunk", "([BIII)V", "onClosed", "onComplete", "errorCode", "", "message", "onError", "(ILjava/lang/String;)V", "code", "onCancelled", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TtsStreamListener {
    public static final int CANCEL_CODE_UNKNOWN = -1;
    public static final int CANCEL_CODE_USER = 0;
    public static final String CANCEL_MSG_UNKNOWN = "unknown";
    public static final String CANCEL_MSG_USER = "user requested";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f23686a;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/aiengine/algorithm/tts/TtsStreamListener$Companion;", "", "<init>", "()V", "CANCEL_CODE_USER", "", "CANCEL_MSG_USER", "", "CANCEL_CODE_UNKNOWN", "CANCEL_MSG_UNKNOWN", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public static final int CANCEL_CODE_UNKNOWN = -1;
        public static final int CANCEL_CODE_USER = 0;
        public static final String CANCEL_MSG_UNKNOWN = "unknown";
        public static final String CANCEL_MSG_USER = "user requested";

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f23686a = new Companion();
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCancelled(TtsStreamListener ttsStreamListener, int i10, String message) {
            p.i(message, "message");
        }

        public static void onRoutingDecision(TtsStreamListener ttsStreamListener, String executionLocation, String reason) {
            p.i(executionLocation, "executionLocation");
            p.i(reason, "reason");
        }
    }

    void onAudioChunk(byte[] pcm, int sampleRate, int channelCount, int encoding);

    void onCancelled(int code, String message);

    void onClosed();

    void onComplete();

    void onError(int errorCode, String message);

    void onOpened();

    void onRoutingDecision(String executionLocation, String reason);
}

package com.stepos.aiengine.adapter;

import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.algorithm.voice.ISpeechRecognition;
import com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor;
import com.stepos.aiengine.algorithm.voice.SpeechRecognitionCallback;
import com.stepos.aiengine.api.task.AlgorithmToken;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/adapter/ASRStubAdapter;", "Lcom/stepos/aiengine/algorithm/voice/ISpeechRecognition;", AppAgent.CONSTRUCT, "()V", "recognize", "", "token", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", BffConstant.Type.Audio, "Landroid/os/Bundle;", "callback", "Lcom/stepos/aiengine/algorithm/voice/SpeechRecognitionCallback;", "recognizeStreaming", "Lcom/stepos/aiengine/algorithm/voice/ISpeechStreamingRecognizor;", "cancel", "", "identity", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ASRStubAdapter implements ISpeechRecognition {

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"com/stepos/aiengine/adapter/ASRStubAdapter$recognizeStreaming$1", "Lcom/stepos/aiengine/algorithm/voice/ISpeechStreamingRecognizor;", "Lcom/stepos/aiengine/algorithm/voice/SpeechRecognitionCallback;", "callback", "", "openChannel", "(Lcom/stepos/aiengine/algorithm/voice/SpeechRecognitionCallback;)Z", "", "pcmData", "", "sampleRate", "channelCount", "writePcmData", "([BII)Z", "LC7/r;", "closeChannel", "()V", "isOpen", "()Z", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.aiengine.adapter.ASRStubAdapter$recognizeStreaming$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ISpeechStreamingRecognizor {
        @Override // com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor
        public void closeChannel() {
        }

        @Override // com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor
        public boolean isOpen() {
            return false;
        }

        @Override // com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor
        public boolean openChannel(SpeechRecognitionCallback callback) {
            k.f(callback, "callback");
            return false;
        }

        @Override // com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor
        public boolean writePcmData(byte[] pcmData, int sampleRate, int channelCount) {
            k.f(pcmData, "pcmData");
            return false;
        }
    }

    @Override // com.stepos.aiengine.algorithm.voice.ISpeechRecognition
    public boolean cancel(long identity) {
        return false;
    }

    @Override // com.stepos.aiengine.algorithm.voice.ISpeechRecognition
    public int recognize(AlgorithmToken token, Bundle audio, SpeechRecognitionCallback callback) {
        k.f(token, "token");
        k.f(audio, "audio");
        k.f(callback, "callback");
        callback.onError(-1, "SpeechRecognition: not implemented yet");
        return -1;
    }

    @Override // com.stepos.aiengine.algorithm.voice.ISpeechRecognition
    public ISpeechStreamingRecognizor recognizeStreaming(AlgorithmToken token) {
        k.f(token, "token");
        return new AnonymousClass1();
    }
}

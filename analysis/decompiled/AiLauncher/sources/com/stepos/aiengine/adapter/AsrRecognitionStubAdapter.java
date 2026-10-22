package com.stepos.aiengine.adapter;

import M5.b;
import android.os.Bundle;
import com.stepos.aiengine.algorithm.asr.AsrAudioFile;
import com.stepos.aiengine.algorithm.asr.AsrFileRecognitionListener;
import com.stepos.aiengine.algorithm.asr.AsrStreamRecognitionListener;
import com.stepos.aiengine.algorithm.asr.IAsrRecognition;
import com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrRecognitionStubAdapter;", "Lcom/stepos/aiengine/algorithm/asr/IAsrRecognition;", "<init>", "()V", "recognize", "", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "files", "", "Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "listener", "Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionListener;", "args", "Landroid/os/Bundle;", "recognizeStreaming", "Lcom/stepos/aiengine/algorithm/asr/IAsrStreamingRecognizer;", "params", "cancel", "", e.f30860s, "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrRecognitionStubAdapter implements IAsrRecognition {
    @Override // com.stepos.aiengine.algorithm.asr.IAsrRecognition
    public boolean cancel(long identity) {
        return false;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrRecognition
    public int recognize(AlgorithmToken token, List<AsrAudioFile> files, AsrFileRecognitionListener listener, Bundle args) {
        p.i(token, "token");
        p.i(files, "files");
        p.i(listener, "listener");
        listener.onError(-1, "ASR: not implemented yet");
        return -1;
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrRecognition
    public IAsrStreamingRecognizer recognizeStreaming(AlgorithmToken token, Bundle params) {
        p.i(token, "token");
        return new IAsrStreamingRecognizer() { // from class: com.stepos.aiengine.adapter.AsrRecognitionStubAdapter.recognizeStreaming.1
            @Override // com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer
            public void closeChannel() {
            }

            @Override // com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer
            public boolean isOpen() {
                return false;
            }

            @Override // com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer
            public boolean openChannel(AsrStreamRecognitionListener listener) {
                p.i(listener, "listener");
                return false;
            }

            @Override // com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer
            public boolean writePcmData(byte[] pcmData, int sampleRate, int channelCount) {
                p.i(pcmData, "pcmData");
                return false;
            }
        };
    }
}

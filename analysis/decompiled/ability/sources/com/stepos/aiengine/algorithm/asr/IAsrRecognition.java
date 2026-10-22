package com.stepos.aiengine.algorithm.asr;

import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/IAsrRecognition;", "", "recognize", "", "token", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "files", "", "Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "listener", "Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionListener;", "recognizeStreaming", "Lcom/stepos/aiengine/algorithm/asr/IAsrStreamingRecognizer;", "params", "Landroid/os/Bundle;", "cancel", "", "identity", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAsrRecognition {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ IAsrStreamingRecognizer recognizeStreaming$default(IAsrRecognition iAsrRecognition, AlgorithmToken algorithmToken, Bundle bundle, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recognizeStreaming");
            }
            if ((i & 2) != 0) {
                bundle = null;
            }
            return iAsrRecognition.recognizeStreaming(algorithmToken, bundle);
        }
    }

    boolean cancel(long identity);

    int recognize(AlgorithmToken token, List<AsrAudioFile> files, AsrFileRecognitionListener listener);

    IAsrStreamingRecognizer recognizeStreaming(AlgorithmToken token, Bundle params);
}

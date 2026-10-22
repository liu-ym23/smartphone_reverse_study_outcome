package com.stepos.aiengine.algorithm.asr;

import M5.b;
import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u0013"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/IAsrSseRecognition;", "", "recognize", "", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "audio", "Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "listener", "Lcom/stepos/aiengine/algorithm/asr/AsrSseRecognitionListener;", "args", "Landroid/os/Bundle;", "cancel", "", e.f30860s, "", "openChannel", "Lcom/stepos/aiengine/algorithm/asr/IAsrSseStreamRecognizer;", "params", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAsrSseRecognition {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ IAsrSseStreamRecognizer openChannel$default(IAsrSseRecognition iAsrSseRecognition, AlgorithmToken algorithmToken, Bundle bundle, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openChannel");
            }
            if ((i10 & 2) != 0) {
                bundle = null;
            }
            return iAsrSseRecognition.openChannel(algorithmToken, bundle);
        }

        public static /* synthetic */ int recognize$default(IAsrSseRecognition iAsrSseRecognition, AlgorithmToken algorithmToken, AsrAudioFile asrAudioFile, AsrSseRecognitionListener asrSseRecognitionListener, Bundle bundle, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recognize");
            }
            if ((i10 & 8) != 0) {
                bundle = null;
            }
            return iAsrSseRecognition.recognize(algorithmToken, asrAudioFile, asrSseRecognitionListener, bundle);
        }
    }

    boolean cancel(long identity);

    IAsrSseStreamRecognizer openChannel(AlgorithmToken token, Bundle params);

    int recognize(AlgorithmToken token, AsrAudioFile audio, AsrSseRecognitionListener listener, Bundle args);
}

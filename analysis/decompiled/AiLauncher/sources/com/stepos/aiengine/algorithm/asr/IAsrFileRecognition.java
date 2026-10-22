package com.stepos.aiengine.algorithm.asr;

import M5.b;
import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/IAsrFileRecognition;", "", "recognize", "", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "files", "", "Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "listener", "Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionListener;", "args", "Landroid/os/Bundle;", "cancel", "", e.f30860s, "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAsrFileRecognition {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ int recognize$default(IAsrFileRecognition iAsrFileRecognition, AlgorithmToken algorithmToken, List list, AsrFileRecognitionListener asrFileRecognitionListener, Bundle bundle, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recognize");
            }
            if ((i10 & 8) != 0) {
                bundle = null;
            }
            return iAsrFileRecognition.recognize(algorithmToken, list, asrFileRecognitionListener, bundle);
        }
    }

    boolean cancel(long identity);

    int recognize(AlgorithmToken token, List<AsrAudioFile> files, AsrFileRecognitionListener listener, Bundle args);
}

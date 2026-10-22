package Q4;

import com.stepos.aiengine.algorithm.asr.AsrFileRecognitionResult;
import com.stepos.aiengine.algorithm.asr.AsrUtterance;

/* loaded from: classes3.dex */
public interface b {
    void onError(int i, String str);

    void onRecognized(AsrFileRecognitionResult asrFileRecognitionResult);

    void onRecognizing(AsrUtterance asrUtterance);
}

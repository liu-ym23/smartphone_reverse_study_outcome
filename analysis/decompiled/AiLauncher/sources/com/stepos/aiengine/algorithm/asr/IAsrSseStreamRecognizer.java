package com.stepos.aiengine.algorithm.asr;

import android.os.Bundle;
import kotlin.Metadata;
import x5.d;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/aiengine/algorithm/asr/IAsrSseStreamRecognizer;", "", "Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamListener;", "listener", "", "openChannel", "(Lcom/stepos/aiengine/algorithm/asr/AsrSseStreamListener;)Z", "", "pcmData", "", "sampleRate", "channelCount", "writePcmData", "([BII)Z", "LY8/t;", "closeChannel", "()V", d.EXTRA_ENABLED, "Landroid/os/Bundle;", "params", "setVadEnabled", "(ZLandroid/os/Bundle;)V", "isOpen", "()Z", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAsrSseStreamRecognizer {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void setVadEnabled$default(IAsrSseStreamRecognizer iAsrSseStreamRecognizer, boolean z10, Bundle bundle, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setVadEnabled");
            }
            if ((i10 & 2) != 0) {
                bundle = null;
            }
            iAsrSseStreamRecognizer.setVadEnabled(z10, bundle);
        }
    }

    void closeChannel();

    boolean isOpen();

    boolean openChannel(AsrSseStreamListener listener);

    void setVadEnabled(boolean enabled, Bundle params);

    boolean writePcmData(byte[] pcmData, int sampleRate, int channelCount);
}

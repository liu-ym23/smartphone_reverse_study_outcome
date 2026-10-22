package com.stepos.aiengine.algorithm.sla;

import M5.b;
import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH&J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0017J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/ISla;", "", "recognize", "", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "input", "Lcom/stepos/aiengine/algorithm/sla/SlaInput;", "listener", "Lcom/stepos/aiengine/algorithm/sla/SlaListener;", "args", "Landroid/os/Bundle;", "audio", "Lcom/stepos/aiengine/algorithm/sla/SlaAudioInput;", "cancel", "", e.f30860s, "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISla {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int recognize(ISla iSla, AlgorithmToken token, SlaInput input, SlaListener listener) {
            p.i(token, "token");
            p.i(input, "input");
            p.i(listener, "listener");
            return iSla.recognize(token, input, null, listener);
        }

        public static int recognize(ISla iSla, AlgorithmToken token, SlaAudioInput audio, SlaListener listener) {
            p.i(token, "token");
            p.i(audio, "audio");
            p.i(listener, "listener");
            return iSla.recognize(token, audio.toSlaInput(), listener);
        }
    }

    boolean cancel(long identity);

    int recognize(AlgorithmToken token, SlaAudioInput audio, SlaListener listener);

    int recognize(AlgorithmToken token, SlaInput input, Bundle args, SlaListener listener);

    int recognize(AlgorithmToken token, SlaInput input, SlaListener listener);
}

package com.stepos.aiengine.adapter;

import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.tts.ITTS;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/stepos/aiengine/adapter/TTSStubAdapter;", "Lcom/stepos/aiengine/algorithm/tts/ITTS;", AppAgent.CONSTRUCT, "()V", "synthesize", "", "token", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "text", "", "args", "Landroid/os/Bundle;", "callback", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "cancel", "", "identity", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TTSStubAdapter implements ITTS {
    @Override // com.stepos.aiengine.algorithm.tts.ITTS
    public boolean cancel(long identity) {
        return false;
    }

    @Override // com.stepos.aiengine.algorithm.tts.ITTS
    public int synthesize(AlgorithmToken token, String text, Bundle args, IBundleCallback callback) {
        k.f(token, "token");
        k.f(text, "text");
        k.f(args, "args");
        k.f(callback, "callback");
        Bundle bundle = new Bundle();
        bundle.putString("exception", "TTS: not implemented yet");
        callback.onCall(bundle);
        return -1;
    }
}

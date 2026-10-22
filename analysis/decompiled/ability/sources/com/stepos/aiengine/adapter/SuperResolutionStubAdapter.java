package com.stepos.aiengine.adapter;

import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.superresolution.ISuperResolution;
import com.stepos.aiengine.api.task.AlgorithmToken;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/stepos/aiengine/adapter/SuperResolutionStubAdapter;", "Lcom/stepos/aiengine/algorithm/superresolution/ISuperResolution;", AppAgent.CONSTRUCT, "()V", "superResolve", "Landroid/os/Bundle;", "token", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "image", "scale", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SuperResolutionStubAdapter implements ISuperResolution {
    @Override // com.stepos.aiengine.algorithm.superresolution.ISuperResolution
    public Bundle superResolve(AlgorithmToken token, Bundle image, int scale) {
        k.f(token, "token");
        k.f(image, "image");
        Bundle bundle = new Bundle();
        bundle.putString("exception", "SuperResolution: not implemented yet");
        return bundle;
    }
}

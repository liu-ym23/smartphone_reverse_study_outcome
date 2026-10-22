package com.stepos.aiengine.adapter;

import M5.b;
import android.os.Bundle;
import com.stepos.aiengine.algorithm.superresolution.ISuperResolution;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/stepos/aiengine/adapter/SuperResolutionStubAdapter;", "Lcom/stepos/aiengine/algorithm/superresolution/ISuperResolution;", "<init>", "()V", "superResolve", "Landroid/os/Bundle;", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "image", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SuperResolutionStubAdapter implements ISuperResolution {
    @Override // com.stepos.aiengine.algorithm.superresolution.ISuperResolution
    public Bundle superResolve(AlgorithmToken token, Bundle image, int scale) {
        p.i(token, "token");
        p.i(image, "image");
        Bundle bundle = new Bundle();
        bundle.putString("exception", "SuperResolution: not implemented yet");
        return bundle;
    }
}

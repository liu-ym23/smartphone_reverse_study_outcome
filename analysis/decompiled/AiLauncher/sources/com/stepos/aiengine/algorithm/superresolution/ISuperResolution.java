package com.stepos.aiengine.algorithm.superresolution;

import M5.b;
import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/stepos/aiengine/algorithm/superresolution/ISuperResolution;", "", "superResolve", "Landroid/os/Bundle;", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "image", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISuperResolution {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Bundle superResolve$default(ISuperResolution iSuperResolution, AlgorithmToken algorithmToken, Bundle bundle, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: superResolve");
            }
            if ((i11 & 4) != 0) {
                i10 = 0;
            }
            return iSuperResolution.superResolve(algorithmToken, bundle, i10);
        }
    }

    Bundle superResolve(AlgorithmToken token, Bundle image, int scale);
}

package com.stepos.aiengine.algorithm.riskclassify;

import M5.b;
import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ1\u0010\f\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\f\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/aiengine/algorithm/riskclassify/IRiskClassify;", "", "", e.f30860s, "", "cancel", "(J)Z", "", "text", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/algorithm/riskclassify/RiskClassifyResult;", "classify", "(Ljava/lang/String;Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/riskclassify/RiskClassifyResult;", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "LY8/t;", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IRiskClassify {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ RiskClassifyResult classify$default(IRiskClassify iRiskClassify, String str, Bundle bundle, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: classify");
            }
            if ((i10 & 2) != 0) {
                bundle = null;
            }
            return iRiskClassify.classify(str, bundle);
        }
    }

    boolean cancel(long identity);

    RiskClassifyResult classify(String text, Bundle args);

    void classify(AlgorithmToken token, String text, Bundle args, IBundleCallback callback);
}

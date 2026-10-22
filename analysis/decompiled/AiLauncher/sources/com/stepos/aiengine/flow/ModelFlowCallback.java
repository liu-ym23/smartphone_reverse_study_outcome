package com.stepos.aiengine.flow;

import com.stepos.core.download.ModelFlowMeta;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/aiengine/flow/ModelFlowCallback;", "", "Lcom/stepos/aiengine/flow/ModelFlowStage;", "stage", "LY8/t;", "onStateChanged", "(Lcom/stepos/aiengine/flow/ModelFlowStage;)V", "", ModelFlowMeta.KEY_CAN_UPDATE, "onReady", "(Z)V", "", "code", "", "message", "onFailed", "(ILjava/lang/String;)V", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ModelFlowCallback {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onReady$default(ModelFlowCallback modelFlowCallback, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onReady");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            modelFlowCallback.onReady(z10);
        }
    }

    void onFailed(int code, String message);

    void onReady(boolean canUpdate);

    void onStateChanged(ModelFlowStage stage);
}

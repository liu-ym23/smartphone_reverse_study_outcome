package com.android.ttcjpaysdk.integrated.sign.counter.activity.scene.integratedsign;

import com.android.ttcjpaysdk.integrated.sign.counter.data.SignCreateResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/scene/integratedsign/IntegratedSignSceneState;", "", "()V", "signCreateResponse", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignCreateResponse;", "getSignCreateResponse", "()Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignCreateResponse;", "setSignCreateResponse", "(Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignCreateResponse;)V", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegratedSignSceneState {
    public static final IntegratedSignSceneState INSTANCE = null;
    private static SignCreateResponse signCreateResponse;

    static {
        INSTANCE = new IntegratedSignSceneState();
    }

    private IntegratedSignSceneState() {
    }

    public final SignCreateResponse getSignCreateResponse() {
        return signCreateResponse;
    }

    public final void setSignCreateResponse(SignCreateResponse r100) {
        signCreateResponse = r100;
    }
}

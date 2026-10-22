package com.stepos.core.deepbinder;

import com.stepos.core.data.base.Content;
import com.stepos.deepbinder.annotation.type.Callback;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Callback
/* loaded from: classes.dex */
public interface IInferenceStreamCallback {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static void onProgress(IInferenceStreamCallback iInferenceStreamCallback, String inferId, int i10, Content content) {
            g.f(inferId, "inferId");
        }

        public static void onRoutingDecision(IInferenceStreamCallback iInferenceStreamCallback, String inferId, String executionLocation, String reason) {
            g.f(inferId, "inferId");
            g.f(executionLocation, "executionLocation");
            g.f(reason, "reason");
        }
    }

    void onComplete(String str);

    void onError(String str, int i10, String str2);

    void onOutput(String str, Content content);

    void onProgress(String str, int i10, Content content);

    void onRecycle();

    void onRoutingDecision(String str, String str2, String str3);
}

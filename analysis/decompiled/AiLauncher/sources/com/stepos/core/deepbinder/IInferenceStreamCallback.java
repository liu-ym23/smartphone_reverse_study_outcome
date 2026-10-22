package com.stepos.core.deepbinder;

import com.stepos.core.data.base.Content;
import com.stepos.deepbinder.annotation.type.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Callback
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/core/deepbinder/IInferenceStreamCallback;", "", "", "inferId", "Lcom/stepos/core/data/base/Content;", "output", "LY8/t;", "onOutput", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)V", "onComplete", "(Ljava/lang/String;)V", "", "errorCode", "message", "onError", "(Ljava/lang/String;ILjava/lang/String;)V", "onRecycle", "()V", "percent", "extra", "onProgress", "(Ljava/lang/String;ILcom/stepos/core/data/base/Content;)V", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IInferenceStreamCallback {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onProgress(IInferenceStreamCallback iInferenceStreamCallback, String inferId, int i10, Content content) {
            p.i(inferId, "inferId");
        }

        public static void onRoutingDecision(IInferenceStreamCallback iInferenceStreamCallback, String inferId, String executionLocation, String reason) {
            p.i(inferId, "inferId");
            p.i(executionLocation, "executionLocation");
            p.i(reason, "reason");
        }
    }

    void onComplete(String inferId);

    void onError(String inferId, int errorCode, String message);

    void onOutput(String inferId, Content output);

    void onProgress(String inferId, int percent, Content extra);

    void onRecycle();

    void onRoutingDecision(String inferId, String executionLocation, String reason);
}

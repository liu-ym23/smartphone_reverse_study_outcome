package com.stepos.core;

import com.stepos.core.callback.InferResult;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/core/AbilityHandle$infer$executorCallback$1", "Lcom/stepos/core/InferenceCallback;", "", "inferId", "Lcom/stepos/core/callback/InferResult;", "result", "LY8/t;", "onNext", "(Ljava/lang/String;Lcom/stepos/core/callback/InferResult;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityHandle$infer$executorCallback$1<R> implements InferenceCallback<R> {
    final /* synthetic */ InferenceCallback<R> $callback;
    final /* synthetic */ Executor $executor;

    /* JADX WARN: Multi-variable type inference failed */
    public AbilityHandle$infer$executorCallback$1(Executor executor, InferenceCallback<? super R> inferenceCallback) {
        this.$executor = executor;
        this.$callback = inferenceCallback;
    }

    @Override // com.stepos.core.InferenceCallback
    public void onNext(final String inferId, final InferResult<? extends R> result) {
        kotlin.jvm.internal.p.i(inferId, "inferId");
        kotlin.jvm.internal.p.i(result, "result");
        Executor executor = this.$executor;
        final InferenceCallback<R> inferenceCallback = this.$callback;
        executor.execute(new Runnable() { // from class: com.stepos.core.p
            @Override // java.lang.Runnable
            public final void run() {
                inferenceCallback.onNext(inferId, result);
            }
        });
    }
}

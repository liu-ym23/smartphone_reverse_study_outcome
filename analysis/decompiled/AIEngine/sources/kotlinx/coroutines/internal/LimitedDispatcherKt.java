package kotlinx.coroutines.internal;

import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LimitedDispatcherKt {
    public static final void checkParallelism(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final CoroutineDispatcher namedOrThis(CoroutineDispatcher coroutineDispatcher, String str) {
        return str != null ? new NamedDispatcher(coroutineDispatcher, str) : coroutineDispatcher;
    }
}

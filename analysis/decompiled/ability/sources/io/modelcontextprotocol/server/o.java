package io.modelcontextprotocol.server;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.function.BiFunction;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import reactor.util.retry.RetryBackoffSpec;
import reactor.util.retry.RetrySpec;

/* loaded from: classes3.dex */
public final /* synthetic */ class o implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4714a;

    public /* synthetic */ o(int i) {
        this.f4714a = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f4714a) {
            case 0:
                return McpAsyncServer.lambda$prepareNotificationHandlers$3((McpAsyncServerExchange) obj, (List) obj2);
            case 1:
                return McpAsyncServerExchange.lambda$listRoots$1((McpSchema.ListRootsResult) obj, (McpSchema.ListRootsResult) obj2);
            case 2:
                return RetryBackoffSpec.lambda$static$0((RetryBackoffSpec) obj, (Retry.RetrySignal) obj2);
            case 3:
                return RetrySpec.lambda$static$1((Retry.RetrySignal) obj, (Mono) obj2);
            default:
                return RetrySpec.lambda$static$2((RetrySpec) obj, (Retry.RetrySignal) obj2);
        }
    }
}

package io.modelcontextprotocol.server;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.function.BiFunction;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import reactor.util.retry.RetryBackoffSpec;
import reactor.util.retry.RetrySpec;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6280c;

    public /* synthetic */ m(int i) {
        this.f6280c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f6280c) {
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

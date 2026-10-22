package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class y implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6336c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6337f;

    public /* synthetic */ y(int i) {
        this.f6336c = i;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.f6336c;
        Object obj3 = this.f6337f;
        switch (i) {
            case 0:
                return McpServerFeatures.AsyncToolSpecification.lambda$new$0((BiFunction) obj3, (McpAsyncServerExchange) obj, (McpSchema.CallToolRequest) obj2);
            case 1:
                return McpServerFeatures.SyncToolSpecification.lambda$new$0((BiFunction) obj3, (McpSyncServerExchange) obj, (McpSchema.CallToolRequest) obj2);
            default:
                return McpServerFeatures.Async.lambda$fromSync$5((BiConsumer) obj3, (McpAsyncServerExchange) obj, (List) obj2);
        }
    }
}

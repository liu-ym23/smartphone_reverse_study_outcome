package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* loaded from: classes3.dex */
public final /* synthetic */ class A implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4695a;
    public final /* synthetic */ Object b;

    public /* synthetic */ A(Object obj, int i) {
        this.f4695a = i;
        this.b = obj;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.f4695a;
        Object obj3 = this.b;
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

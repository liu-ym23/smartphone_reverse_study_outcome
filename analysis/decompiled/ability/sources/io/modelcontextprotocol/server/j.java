package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4710a;
    public final /* synthetic */ McpAsyncServerExchange b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ j(McpAsyncServer mcpAsyncServer, McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        this.f4710a = 0;
        this.c = mcpAsyncServer;
        this.d = obj;
        this.b = mcpAsyncServerExchange;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f4710a) {
            case 0:
                return ((McpAsyncServer) this.c).lambda$setLoggerRequestHandler$37(this.d, this.b);
            case 1:
                return McpAsyncServer.lambda$promptsGetRequestHandler$35((McpServerFeatures.AsyncPromptSpecification) this.c, this.b, (McpSchema.GetPromptRequest) this.d);
            case 2:
                return McpAsyncServer.lambda$asyncRootsListChangedNotificationHandler$6((BiFunction) this.c, this.b, (McpSchema.ListRootsResult) this.d);
            default:
                return McpAsyncServer.lambda$completionCompleteRequestHandler$40((McpServerFeatures.AsyncCompletionSpecification) this.c, this.b, (McpSchema.CompleteRequest) this.d);
        }
    }

    public /* synthetic */ j(Object obj, McpAsyncServerExchange mcpAsyncServerExchange, B7.a aVar, int i) {
        this.f4710a = i;
        this.c = obj;
        this.b = mcpAsyncServerExchange;
        this.d = aVar;
    }
}

package io.modelcontextprotocol.server;

import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements McpRequestHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6244a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpAsyncServer f6245b;

    public /* synthetic */ b(int i) {
        this.f6244a = i;
    }

    @Override // io.modelcontextprotocol.server.McpRequestHandler
    public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        int i = this.f6244a;
        McpAsyncServer mcpAsyncServer = this.f6245b;
        switch (i) {
            case 0:
                return mcpAsyncServer.lambda$resourceTemplateListRequestHandler$24(mcpAsyncServerExchange, obj);
            case 1:
                return mcpAsyncServer.lambda$toolsListRequestHandler$16(mcpAsyncServerExchange, obj);
            case 2:
                return mcpAsyncServer.lambda$resourcesReadRequestHandler$29(mcpAsyncServerExchange, obj);
            case 3:
                return mcpAsyncServer.lambda$resourcesListRequestHandler$23(mcpAsyncServerExchange, obj);
            case 4:
                return mcpAsyncServer.lambda$toolsCallRequestHandler$18(mcpAsyncServerExchange, obj);
            case 5:
                return mcpAsyncServer.lambda$setLoggerRequestHandler$38(mcpAsyncServerExchange, obj);
            case 6:
                return mcpAsyncServer.lambda$promptsListRequestHandler$34(mcpAsyncServerExchange, obj);
            case 7:
                return mcpAsyncServer.lambda$promptsGetRequestHandler$36(mcpAsyncServerExchange, obj);
            default:
                return mcpAsyncServer.lambda$completionCompleteRequestHandler$41(mcpAsyncServerExchange, obj);
        }
    }
}

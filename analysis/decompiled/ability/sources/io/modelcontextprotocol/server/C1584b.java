package io.modelcontextprotocol.server;

import reactor.core.publisher.Mono;

/* renamed from: io.modelcontextprotocol.server.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class C1584b implements McpRequestHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4702a;
    public final /* synthetic */ McpAsyncServer b;

    public /* synthetic */ C1584b(McpAsyncServer mcpAsyncServer, int i) {
        this.f4702a = i;
        this.b = mcpAsyncServer;
    }

    @Override // io.modelcontextprotocol.server.McpRequestHandler
    public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        int i = this.f4702a;
        McpAsyncServer mcpAsyncServer = this.b;
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

package io.modelcontextprotocol.server;

import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public final /* synthetic */ class r implements McpRequestHandler {
    @Override // io.modelcontextprotocol.server.McpRequestHandler
    public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return McpAsyncServer.lambda$prepareRequestHandlers$4(mcpAsyncServerExchange, obj);
    }
}

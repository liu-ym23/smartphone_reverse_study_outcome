package io.modelcontextprotocol.server;

import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public final /* synthetic */ class n implements McpNotificationHandler {
    @Override // io.modelcontextprotocol.server.McpNotificationHandler
    public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return McpAsyncServer.lambda$prepareNotificationHandlers$1(mcpAsyncServerExchange, obj);
    }
}

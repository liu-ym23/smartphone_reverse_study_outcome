package io.modelcontextprotocol.server;

import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements McpRequestHandler {
    @Override // io.modelcontextprotocol.server.McpRequestHandler
    public final Mono handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj) {
        return McpAsyncServer.lambda$prepareRequestHandlers$4(mcpAsyncServerExchange, obj);
    }
}

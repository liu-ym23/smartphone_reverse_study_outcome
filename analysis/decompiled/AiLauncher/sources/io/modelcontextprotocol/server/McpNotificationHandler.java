package io.modelcontextprotocol.server;

import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public interface McpNotificationHandler {
    Mono<Void> handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj);
}

package io.modelcontextprotocol.server;

import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public interface McpRequestHandler<T> {
    Mono<T> handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj);
}

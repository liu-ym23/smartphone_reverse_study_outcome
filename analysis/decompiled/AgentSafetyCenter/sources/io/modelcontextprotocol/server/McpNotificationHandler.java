package io.modelcontextprotocol.server;

import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpNotificationHandler {
    Mono<Void> handle(McpAsyncServerExchange mcpAsyncServerExchange, Object obj);
}

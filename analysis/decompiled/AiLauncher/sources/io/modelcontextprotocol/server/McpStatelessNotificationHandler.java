package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public interface McpStatelessNotificationHandler {
    Mono<Void> handle(McpTransportContext mcpTransportContext, Object obj);
}

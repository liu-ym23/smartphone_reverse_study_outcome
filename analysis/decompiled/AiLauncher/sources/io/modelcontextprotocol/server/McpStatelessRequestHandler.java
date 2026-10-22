package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public interface McpStatelessRequestHandler<R> {
    Mono<R> handle(McpTransportContext mcpTransportContext, Object obj);
}

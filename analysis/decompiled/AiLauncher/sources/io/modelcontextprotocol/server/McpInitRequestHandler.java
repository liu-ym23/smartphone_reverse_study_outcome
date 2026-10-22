package io.modelcontextprotocol.server;

import io.modelcontextprotocol.spec.McpSchema;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public interface McpInitRequestHandler {
    Mono<McpSchema.InitializeResult> handle(McpSchema.InitializeRequest initializeRequest);
}

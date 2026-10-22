package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.spec.McpSchema;
import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public interface McpStatelessServerHandler {
    Mono<Void> handleNotification(McpTransportContext mcpTransportContext, McpSchema.JSONRPCNotification jSONRPCNotification);

    Mono<McpSchema.JSONRPCResponse> handleRequest(McpTransportContext mcpTransportContext, McpSchema.JSONRPCRequest jSONRPCRequest);
}

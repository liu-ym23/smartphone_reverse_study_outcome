package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public interface McpStreamableServerTransport extends McpServerTransport {
    Mono<Void> sendMessage(McpSchema.JSONRPCMessage jSONRPCMessage, String str);
}

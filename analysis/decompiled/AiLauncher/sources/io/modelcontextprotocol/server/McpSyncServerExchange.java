package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.spec.McpSchema;

/* loaded from: classes4.dex */
public class McpSyncServerExchange {
    private final McpAsyncServerExchange exchange;

    public McpSyncServerExchange(McpAsyncServerExchange mcpAsyncServerExchange) {
        this.exchange = mcpAsyncServerExchange;
    }

    public McpSchema.ElicitResult createElicitation(McpSchema.ElicitRequest elicitRequest) {
        return this.exchange.createElicitation(elicitRequest).block();
    }

    public McpSchema.CreateMessageResult createMessage(McpSchema.CreateMessageRequest createMessageRequest) {
        return this.exchange.createMessage(createMessageRequest).block();
    }

    public McpSchema.ClientCapabilities getClientCapabilities() {
        return this.exchange.getClientCapabilities();
    }

    public McpSchema.Implementation getClientInfo() {
        return this.exchange.getClientInfo();
    }

    public McpSchema.ListRootsResult listRoots() {
        return this.exchange.listRoots().block();
    }

    public void loggingNotification(McpSchema.LoggingMessageNotification loggingMessageNotification) {
        this.exchange.loggingNotification(loggingMessageNotification).block();
    }

    public Object ping() {
        return this.exchange.ping().block();
    }

    public void progressNotification(McpSchema.ProgressNotification progressNotification) {
        this.exchange.progressNotification(progressNotification).block();
    }

    public String sessionId() {
        return this.exchange.sessionId();
    }

    public McpTransportContext transportContext() {
        return this.exchange.transportContext();
    }

    public McpSchema.ListRootsResult listRoots(String str) {
        return this.exchange.listRoots(str).block();
    }
}

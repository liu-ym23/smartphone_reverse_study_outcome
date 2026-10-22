package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.server.McpNotificationHandler;
import io.modelcontextprotocol.server.McpRequestHandler;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.time.Duration;
import java.util.Map;
import java.util.UUID;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DefaultMcpStreamableServerSessionFactory implements McpStreamableServerSession.Factory {
    McpStreamableServerSession.InitRequestHandler initRequestHandler;
    Map<String, McpNotificationHandler> notificationHandlers;
    Map<String, McpRequestHandler<?>> requestHandlers;
    Duration requestTimeout;

    public DefaultMcpStreamableServerSessionFactory(Duration duration, McpStreamableServerSession.InitRequestHandler initRequestHandler, Map<String, McpRequestHandler<?>> map, Map<String, McpNotificationHandler> map2) {
        this.requestTimeout = duration;
        this.initRequestHandler = initRequestHandler;
        this.requestHandlers = map;
        this.notificationHandlers = map2;
    }

    @Override // io.modelcontextprotocol.spec.McpStreamableServerSession.Factory
    public McpStreamableServerSession.McpStreamableServerSessionInit startSession(McpSchema.InitializeRequest initializeRequest) {
        return new McpStreamableServerSession.McpStreamableServerSessionInit(new McpStreamableServerSession(UUID.randomUUID().toString(), initializeRequest.capabilities(), initializeRequest.clientInfo(), this.requestTimeout, this.requestHandlers, this.notificationHandlers), this.initRequestHandler.handle(initializeRequest));
    }
}

package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpSchema;

/* loaded from: classes3.dex */
public interface McpLoggableSession extends McpSession {
    boolean isNotificationForLevelAllowed(McpSchema.LoggingLevel loggingLevel);

    void setMinLoggingLevel(McpSchema.LoggingLevel loggingLevel);
}

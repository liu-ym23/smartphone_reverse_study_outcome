package io.modelcontextprotocol.spec;

import io.modelcontextprotocol.spec.McpServerSession;

/* loaded from: classes4.dex */
public interface McpServerTransportProvider extends McpServerTransportProviderBase {
    void setSessionFactory(McpServerSession.Factory factory);
}

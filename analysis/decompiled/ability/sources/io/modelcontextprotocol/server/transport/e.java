package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpTransportContextExtractor;
import io.modelcontextprotocol.server.transport.HttpServletSseServerTransportProvider;
import jakarta.servlet.http.HttpServletRequest;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements McpTransportContextExtractor {
    @Override // io.modelcontextprotocol.server.McpTransportContextExtractor
    public final McpTransportContext extract(Object obj) {
        return HttpServletSseServerTransportProvider.Builder.lambda$new$0((HttpServletRequest) obj);
    }
}

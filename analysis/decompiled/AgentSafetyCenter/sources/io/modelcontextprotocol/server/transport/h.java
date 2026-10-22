package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpTransportContextExtractor;
import io.modelcontextprotocol.server.transport.HttpServletStatelessServerTransport;
import jakarta.servlet.http.HttpServletRequest;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements McpTransportContextExtractor {
    @Override // io.modelcontextprotocol.server.McpTransportContextExtractor
    public final McpTransportContext extract(Object obj) {
        return HttpServletStatelessServerTransport.Builder.lambda$new$0((HttpServletRequest) obj);
    }
}

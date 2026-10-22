package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public final /* synthetic */ class G implements McpStatelessRequestHandler {
    @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
    public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
        return McpStatelessAsyncServer.lambda$new$0(mcpTransportContext, obj);
    }
}

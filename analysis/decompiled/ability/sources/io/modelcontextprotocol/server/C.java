package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public final /* synthetic */ class C implements McpStatelessRequestHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4697a;
    public final /* synthetic */ McpStatelessAsyncServer b;

    public /* synthetic */ C(McpStatelessAsyncServer mcpStatelessAsyncServer, int i) {
        this.f4697a = i;
        this.b = mcpStatelessAsyncServer;
    }

    @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
    public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
        int i = this.f4697a;
        McpStatelessAsyncServer mcpStatelessAsyncServer = this.b;
        switch (i) {
            case 0:
                return mcpStatelessAsyncServer.lambda$completionCompleteRequestHandler$29(mcpTransportContext, obj);
            case 1:
                return mcpStatelessAsyncServer.lambda$promptsListRequestHandler$26(mcpTransportContext, obj);
            case 2:
                return mcpStatelessAsyncServer.lambda$resourceTemplateListRequestHandler$16(mcpTransportContext, obj);
            case 3:
                return mcpStatelessAsyncServer.lambda$resourcesReadRequestHandler$21(mcpTransportContext, obj);
            case 4:
                return mcpStatelessAsyncServer.lambda$toolsListRequestHandler$8(mcpTransportContext, obj);
            case 5:
                return mcpStatelessAsyncServer.lambda$promptsGetRequestHandler$27(mcpTransportContext, obj);
            case 6:
                return mcpStatelessAsyncServer.lambda$asyncInitializeRequestHandler$2(mcpTransportContext, obj);
            case 7:
                return mcpStatelessAsyncServer.lambda$toolsCallRequestHandler$10(mcpTransportContext, obj);
            default:
                return mcpStatelessAsyncServer.lambda$resourcesListRequestHandler$15(mcpTransportContext, obj);
        }
    }
}

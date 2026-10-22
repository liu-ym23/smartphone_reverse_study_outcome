package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements McpStatelessRequestHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6242a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpStatelessAsyncServer f6243b;

    public /* synthetic */ a0(int i) {
        this.f6242a = i;
    }

    @Override // io.modelcontextprotocol.server.McpStatelessRequestHandler
    public final Mono handle(McpTransportContext mcpTransportContext, Object obj) {
        int i = this.f6242a;
        McpStatelessAsyncServer mcpStatelessAsyncServer = this.f6243b;
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

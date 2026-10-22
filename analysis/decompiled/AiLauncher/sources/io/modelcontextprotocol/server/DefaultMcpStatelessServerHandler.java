package io.modelcontextprotocol.server;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Map;
import java.util.function.Function;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
class DefaultMcpStatelessServerHandler implements McpStatelessServerHandler {
    private static final vc.c logger = vc.e.l(DefaultMcpStatelessServerHandler.class);
    Map<String, McpStatelessNotificationHandler> notificationHandlers;
    Map<String, McpStatelessRequestHandler<?>> requestHandlers;

    public DefaultMcpStatelessServerHandler(Map<String, McpStatelessRequestHandler<?>> map, Map<String, McpStatelessNotificationHandler> map2) {
        this.requestHandlers = map;
        this.notificationHandlers = map2;
    }

    public static /* synthetic */ McpSchema.JSONRPCResponse a(McpSchema.JSONRPCRequest jSONRPCRequest, Object obj) {
        return new McpSchema.JSONRPCResponse("2.0", jSONRPCRequest.id(), obj, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ reactor.core.publisher.Mono b(io.modelcontextprotocol.spec.McpSchema.JSONRPCRequest r3, java.lang.Throwable r4) {
        /*
            boolean r0 = r4 instanceof io.modelcontextprotocol.spec.McpError
            r1 = 0
            if (r0 == 0) goto L13
            r0 = r4
            io.modelcontextprotocol.spec.McpError r0 = (io.modelcontextprotocol.spec.McpError) r0
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError r2 = r0.getJsonRpcError()
            if (r2 == 0) goto L13
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError r4 = r0.getJsonRpcError()
            goto L23
        L13:
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError r0 = new io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse$JSONRPCError
            r2 = -32603(0xffffffffffff80a5, float:NaN)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = r4.getMessage()
            r0.<init>(r2, r4, r1)
            r4 = r0
        L23:
            io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse r0 = new io.modelcontextprotocol.spec.McpSchema$JSONRPCResponse
            java.lang.String r2 = "2.0"
            java.lang.Object r3 = r3.id()
            r0.<init>(r2, r3, r1, r4)
            reactor.core.publisher.Mono r3 = reactor.core.publisher.Mono.just(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.server.DefaultMcpStatelessServerHandler.b(io.modelcontextprotocol.spec.McpSchema$JSONRPCRequest, java.lang.Throwable):reactor.core.publisher.Mono");
    }

    @Override // io.modelcontextprotocol.server.McpStatelessServerHandler
    public Mono<Void> handleNotification(McpTransportContext mcpTransportContext, McpSchema.JSONRPCNotification jSONRPCNotification) {
        McpStatelessNotificationHandler mcpStatelessNotificationHandler = this.notificationHandlers.get(jSONRPCNotification.method());
        if (mcpStatelessNotificationHandler != null) {
            return mcpStatelessNotificationHandler.handle(mcpTransportContext, jSONRPCNotification.params());
        }
        logger.j("Missing handler for notification type: {}", jSONRPCNotification.method());
        return Mono.empty();
    }

    @Override // io.modelcontextprotocol.server.McpStatelessServerHandler
    public Mono<McpSchema.JSONRPCResponse> handleRequest(McpTransportContext mcpTransportContext, final McpSchema.JSONRPCRequest jSONRPCRequest) {
        McpStatelessRequestHandler<?> mcpStatelessRequestHandler = this.requestHandlers.get(jSONRPCRequest.method());
        if (mcpStatelessRequestHandler != null) {
            return mcpStatelessRequestHandler.handle(mcpTransportContext, jSONRPCRequest.params()).map(new Function() { // from class: io.modelcontextprotocol.server.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return DefaultMcpStatelessServerHandler.a(jSONRPCRequest, obj);
                }
            }).onErrorResume(new Function() { // from class: io.modelcontextprotocol.server.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return DefaultMcpStatelessServerHandler.b(jSONRPCRequest, (Throwable) obj);
                }
            });
        }
        return Mono.error(new McpError("Missing handler for request type: " + jSONRPCRequest.method()));
    }
}

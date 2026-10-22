package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;
import reactor.util.context.Context;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4722a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d(Object obj, int i) {
        this.f4722a = i;
        this.b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4722a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return HttpServletSseServerTransportProvider.lambda$doPost$3((McpTransportContext) obj2, (Context) obj);
            case 1:
                return HttpServletStatelessServerTransport.lambda$doPost$1((McpTransportContext) obj2, (Context) obj);
            case 2:
                return HttpServletStatelessServerTransport.lambda$doPost$2((McpTransportContext) obj2, (Context) obj);
            case 3:
                return HttpServletStreamableServerTransportProvider.lambda$doDelete$12((McpTransportContext) obj2, (Context) obj);
            case 4:
                return HttpServletStreamableServerTransportProvider.lambda$doGet$6((McpTransportContext) obj2, (Context) obj);
            case 5:
                return HttpServletStreamableServerTransportProvider.lambda$doGet$7((McpTransportContext) obj2, (Context) obj);
            case 6:
                return HttpServletStreamableServerTransportProvider.lambda$doPost$9((McpTransportContext) obj2, (Context) obj);
            case 7:
                return HttpServletStreamableServerTransportProvider.lambda$doPost$10((McpTransportContext) obj2, (Context) obj);
            case 8:
                return HttpServletStreamableServerTransportProvider.lambda$doPost$11((McpTransportContext) obj2, (Context) obj);
            default:
                return ((StdioServerTransportProvider.StdioMcpSessionTransport) obj2).lambda$handleIncomingMessages$2((McpSchema.JSONRPCMessage) obj);
        }
    }
}

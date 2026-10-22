package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;
import reactor.core.publisher.Flux;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6314a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ StdioServerTransportProvider.StdioMcpSessionTransport f6315b;

    public /* synthetic */ n(int i) {
        this.f6314a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6314a;
        StdioServerTransportProvider.StdioMcpSessionTransport stdioMcpSessionTransport = this.f6315b;
        switch (i) {
            case 0:
                return stdioMcpSessionTransport.lambda$startOutboundProcessing$10((Flux) obj);
            default:
                return stdioMcpSessionTransport.lambda$handleIncomingMessages$2((McpSchema.JSONRPCMessage) obj);
        }
    }
}

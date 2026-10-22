package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class s implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return StdioServerTransportProvider.StdioMcpSessionTransport.lambda$startOutboundProcessing$9(obj);
    }
}

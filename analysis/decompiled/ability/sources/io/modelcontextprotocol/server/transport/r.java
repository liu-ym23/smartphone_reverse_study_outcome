package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class r implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return StdioServerTransportProvider.StdioMcpSessionTransport.lambda$startOutboundProcessing$9(obj);
    }
}

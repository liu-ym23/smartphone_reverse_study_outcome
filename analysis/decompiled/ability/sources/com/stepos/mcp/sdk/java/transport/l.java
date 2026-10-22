package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransport;
import java.util.function.Function;
import reactor.core.publisher.Flux;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3842a;
    public final /* synthetic */ McpTransport b;

    public /* synthetic */ l(McpTransport mcpTransport, int i) {
        this.f3842a = i;
        this.b = mcpTransport;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f3842a;
        McpTransport mcpTransport = this.b;
        switch (i) {
            case 0:
                return ((ServerTransportProvider.ServerSessionTransport) mcpTransport).lambda$handleIncomingMessages$2((McpSchema.JSONRPCMessage) obj);
            default:
                return ((AndroidClientTransport) mcpTransport).lambda$startOutboundProcessing$6((Flux) obj);
        }
    }
}

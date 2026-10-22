package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.IMCPBinderCallback;
import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransport;
import java.util.function.BiConsumer;
import reactor.core.publisher.SynchronousSink;

/* loaded from: classes3.dex */
public final /* synthetic */ class n implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3844a;
    public final /* synthetic */ McpTransport b;

    public /* synthetic */ n(McpTransport mcpTransport, int i) {
        this.f3844a = i;
        this.b = mcpTransport;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i = this.f3844a;
        McpTransport mcpTransport = this.b;
        switch (i) {
            case 0:
                ((ServerTransportProvider.ServerSessionTransport) mcpTransport).lambda$startOutboundProcessing$5((McpSchema.JSONRPCMessage) obj, (SynchronousSink) obj2);
                break;
            case 1:
                ((ServerTransportProvider.ServerSessionTransport) mcpTransport).unregisterDeathRecipient(obj, (IMCPBinderCallback) obj2);
                break;
            default:
                ((AndroidClientTransport) mcpTransport).lambda$startOutboundProcessing$5((McpSchema.JSONRPCMessage) obj, (SynchronousSink) obj2);
                break;
        }
    }
}

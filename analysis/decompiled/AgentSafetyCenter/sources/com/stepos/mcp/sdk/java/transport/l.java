package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.IMCPBinderCallback;
import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransport;
import java.util.function.BiConsumer;
import reactor.core.publisher.SynchronousSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2754c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpTransport f2755f;

    public /* synthetic */ l(int i) {
        this.f2754c = i;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i = this.f2754c;
        McpTransport mcpTransport = this.f2755f;
        switch (i) {
            case 0:
                ((ServerTransportProvider.ServerSessionTransport) mcpTransport).unregisterDeathRecipient(obj, (IMCPBinderCallback) obj2);
                break;
            case 1:
                ((ServerTransportProvider.ServerSessionTransport) mcpTransport).lambda$startOutboundProcessing$5((McpSchema.JSONRPCMessage) obj, (SynchronousSink) obj2);
                break;
            default:
                ((AndroidClientTransport) mcpTransport).lambda$startOutboundProcessing$5((McpSchema.JSONRPCMessage) obj, (SynchronousSink) obj2);
                break;
        }
    }
}

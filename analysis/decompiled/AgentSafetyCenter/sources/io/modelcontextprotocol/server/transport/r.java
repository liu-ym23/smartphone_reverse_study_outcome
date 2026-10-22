package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.BiConsumer;
import reactor.core.publisher.SynchronousSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ StdioServerTransportProvider.StdioMcpSessionTransport f6322c;

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        this.f6322c.lambda$startOutboundProcessing$6((McpSchema.JSONRPCMessage) obj, (SynchronousSink) obj2);
    }
}

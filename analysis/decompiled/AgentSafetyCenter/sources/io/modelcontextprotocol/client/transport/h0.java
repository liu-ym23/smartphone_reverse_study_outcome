package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.BiConsumer;
import reactor.core.publisher.SynchronousSink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h0 implements BiConsumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ StdioClientTransport f6180c;

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        this.f6180c.lambda$startOutboundProcessing$7((McpSchema.JSONRPCMessage) obj, (SynchronousSink) obj2);
    }
}

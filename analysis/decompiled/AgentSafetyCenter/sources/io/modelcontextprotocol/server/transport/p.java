package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ StdioServerTransportProvider.StdioMcpSessionTransport f6318c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpSchema.JSONRPCMessage f6319f;

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f6318c.lambda$sendMessage$0(this.f6319f);
    }
}

package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.transport.HttpServletStreamableServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import jakarta.servlet.AsyncContext;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpServletStreamableServerTransportProvider.HttpServletStreamableMcpSessionTransport f6304c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpTransportContext f6305f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ AsyncContext f6306g;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        HttpServletStreamableServerTransportProvider.lambda$doGet$8(this.f6304c, this.f6305f, this.f6306g, (McpSchema.JSONRPCMessage) obj);
    }
}

package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.HttpServletSseServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpServletSseServerTransportProvider.HttpServletMcpSessionTransport f6300c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpSchema.JSONRPCMessage f6301f;

    @Override // java.lang.Runnable
    public final void run() {
        this.f6300c.lambda$sendMessage$0(this.f6301f);
    }
}

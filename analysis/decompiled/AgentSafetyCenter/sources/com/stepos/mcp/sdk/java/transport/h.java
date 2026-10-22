package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.AIDLServerTransportProvider;
import io.modelcontextprotocol.spec.McpTransport;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2749c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpTransport f2750f;

    public /* synthetic */ h(int i) {
        this.f2749c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f2749c;
        McpTransport mcpTransport = this.f2750f;
        switch (i) {
            case 0:
                ((AndroidClientTransport) mcpTransport).lambda$handleOutbound$7();
                break;
            case 1:
                ((AndroidClientTransport) mcpTransport).lambda$closeGracefully$10();
                break;
            default:
                ((AIDLServerTransportProvider.Transport) mcpTransport).lambda$closeGracefully$1();
                break;
        }
    }
}

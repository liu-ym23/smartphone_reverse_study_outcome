package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.AIDLServerTransportProvider;
import io.modelcontextprotocol.spec.McpTransport;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3838a;
    public final /* synthetic */ McpTransport b;

    public /* synthetic */ g(McpTransport mcpTransport, int i) {
        this.f3838a = i;
        this.b = mcpTransport;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f3838a;
        McpTransport mcpTransport = this.b;
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

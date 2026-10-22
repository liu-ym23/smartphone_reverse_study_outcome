package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpClientTransport;

/* loaded from: classes2.dex */
public final /* synthetic */ class E implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4652a;
    public final /* synthetic */ McpClientTransport b;

    public /* synthetic */ E(McpClientTransport mcpClientTransport, int i) {
        this.f4652a = i;
        this.b = mcpClientTransport;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f4652a;
        McpClientTransport mcpClientTransport = this.b;
        switch (i) {
            case 0:
                ((StdioClientTransport) mcpClientTransport).lambda$handleOutbound$9();
                break;
            case 1:
                ((StdioClientTransport) mcpClientTransport).lambda$closeGracefully$15();
                break;
            case 2:
                ((StdioClientTransport) mcpClientTransport).lambda$startErrorProcessing$2();
                break;
            case 3:
                ((StdioClientTransport) mcpClientTransport).lambda$startInboundProcessing$6();
                break;
            case 4:
                ((StdioClientTransport) mcpClientTransport).lambda$closeGracefully$11();
                break;
            default:
                ((HttpClientSseClientTransport) mcpClientTransport).lambda$closeGracefully$18();
                break;
        }
    }
}

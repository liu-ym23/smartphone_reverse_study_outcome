package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpClientTransport;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6172c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ McpClientTransport f6173f;

    public /* synthetic */ e0(int i) {
        this.f6172c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f6172c;
        McpClientTransport mcpClientTransport = this.f6173f;
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

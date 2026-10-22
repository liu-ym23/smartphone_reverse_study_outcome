package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6316c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ StdioServerTransportProvider.StdioMcpSessionTransport f6317f;

    public /* synthetic */ o(int i) {
        this.f6316c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f6316c;
        StdioServerTransportProvider.StdioMcpSessionTransport stdioMcpSessionTransport = this.f6317f;
        switch (i) {
            case 0:
                stdioMcpSessionTransport.lambda$handleIncomingMessages$3();
                break;
            case 1:
                stdioMcpSessionTransport.lambda$closeGracefully$1();
                break;
            case 2:
                stdioMcpSessionTransport.lambda$startInboundProcessing$4();
                break;
            default:
                stdioMcpSessionTransport.lambda$startOutboundProcessing$7();
                break;
        }
    }
}

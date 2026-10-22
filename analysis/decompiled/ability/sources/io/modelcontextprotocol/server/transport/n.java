package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;

/* loaded from: classes3.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4729a;
    public final /* synthetic */ StdioServerTransportProvider.StdioMcpSessionTransport b;

    public /* synthetic */ n(StdioServerTransportProvider.StdioMcpSessionTransport stdioMcpSessionTransport, int i) {
        this.f4729a = i;
        this.b = stdioMcpSessionTransport;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f4729a;
        StdioServerTransportProvider.StdioMcpSessionTransport stdioMcpSessionTransport = this.b;
        switch (i) {
            case 0:
                stdioMcpSessionTransport.lambda$closeGracefully$1();
                break;
            case 1:
                stdioMcpSessionTransport.lambda$startInboundProcessing$4();
                break;
            case 2:
                stdioMcpSessionTransport.lambda$startOutboundProcessing$7();
                break;
            default:
                stdioMcpSessionTransport.lambda$handleIncomingMessages$3();
                break;
        }
    }
}

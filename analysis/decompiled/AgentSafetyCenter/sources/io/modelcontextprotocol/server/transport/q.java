package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6320c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ StdioServerTransportProvider.StdioMcpSessionTransport f6321f;

    public /* synthetic */ q(int i) {
        this.f6320c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f6320c;
        StdioServerTransportProvider.StdioMcpSessionTransport stdioMcpSessionTransport = this.f6321f;
        switch (i) {
            case 0:
                stdioMcpSessionTransport.lambda$startOutboundProcessing$5((qd.e) obj);
                break;
            default:
                stdioMcpSessionTransport.lambda$startOutboundProcessing$8((Throwable) obj);
                break;
        }
    }
}

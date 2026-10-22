package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.HttpServletSseServerTransportProvider;
import io.modelcontextprotocol.server.transport.HttpServletStreamableServerTransportProvider;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6302c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6303f;

    public /* synthetic */ g(int i) {
        this.f6302c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f6302c;
        Object obj = this.f6303f;
        switch (i) {
            case 0:
                ((HttpServletSseServerTransportProvider.HttpServletMcpSessionTransport) obj).lambda$closeGracefully$1();
                break;
            case 1:
                ((HttpServletStreamableServerTransportProvider.HttpServletStreamableMcpSessionTransport) obj).lambda$closeGracefully$1();
                break;
            case 2:
                ((HttpServletStatelessServerTransport) obj).lambda$closeGracefully$0();
                break;
            default:
                ((HttpServletStreamableServerTransportProvider) obj).lambda$closeGracefully$4();
                break;
        }
    }
}

package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.HttpServletSseServerTransportProvider;
import io.modelcontextprotocol.server.transport.HttpServletStreamableServerTransportProvider;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4724a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g(Object obj, int i) {
        this.f4724a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f4724a;
        Object obj = this.b;
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

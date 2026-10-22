package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.HttpServletStreamableServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6310c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f6311f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f6312g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f6313h;

    public /* synthetic */ m(int i) {
        this.f6310c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6310c) {
            case 0:
                ((HttpServletStreamableServerTransportProvider.HttpServletStreamableMcpSessionTransport) this.f6312g).lambda$sendMessage$0((McpSchema.JSONRPCMessage) this.f6313h, this.f6311f);
                break;
            default:
                ((HttpServletStreamableServerTransportProvider) this.f6312g).lambda$notifyClients$2(this.f6311f, this.f6313h);
                break;
        }
    }
}

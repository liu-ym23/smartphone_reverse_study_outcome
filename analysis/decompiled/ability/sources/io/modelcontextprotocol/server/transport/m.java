package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.server.transport.HttpServletStreamableServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4728a = 0;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ m(HttpServletStreamableServerTransportProvider.HttpServletStreamableMcpSessionTransport httpServletStreamableMcpSessionTransport, McpSchema.JSONRPCMessage jSONRPCMessage, String str) {
        this.c = httpServletStreamableMcpSessionTransport;
        this.d = jSONRPCMessage;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4728a) {
            case 0:
                ((HttpServletStreamableServerTransportProvider.HttpServletStreamableMcpSessionTransport) this.c).lambda$sendMessage$0((McpSchema.JSONRPCMessage) this.d, this.b);
                break;
            default:
                ((HttpServletStreamableServerTransportProvider) this.c).lambda$notifyClients$2(this.b, this.d);
                break;
        }
    }

    public /* synthetic */ m(HttpServletStreamableServerTransportProvider httpServletStreamableServerTransportProvider, String str, Object obj) {
        this.c = httpServletStreamableServerTransportProvider;
        this.b = str;
        this.d = obj;
    }
}

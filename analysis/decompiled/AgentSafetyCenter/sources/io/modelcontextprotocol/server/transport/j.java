package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6307c;

    public /* synthetic */ j(int i) {
        this.f6307c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f6307c) {
            case 0:
                HttpServletStreamableServerTransportProvider.lambda$closeGracefully$3((McpStreamableServerSession) obj);
                break;
            default:
                StdioServerTransportProvider.lambda$notifyClients$0((Throwable) obj);
                break;
        }
    }
}

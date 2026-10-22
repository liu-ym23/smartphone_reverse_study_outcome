package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.spec.McpServerSession;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6294c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6295f;

    public /* synthetic */ b(int i) {
        this.f6294c = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f6294c;
        Object obj2 = this.f6295f;
        switch (i) {
            case 0:
                ((HttpServletSseServerTransportProvider) obj2).lambda$closeGracefully$4((Void) obj);
                break;
            case 1:
                HttpServletSseServerTransportProvider.lambda$notifyClients$1((McpServerSession) obj2, (Throwable) obj);
                break;
            default:
                ((HttpServletStreamableServerTransportProvider) obj2).lambda$closeGracefully$5((Void) obj);
                break;
        }
    }
}

package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.spec.McpServerSession;
import java.util.function.Consumer;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4720a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f4720a = i;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f4720a;
        Object obj2 = this.b;
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

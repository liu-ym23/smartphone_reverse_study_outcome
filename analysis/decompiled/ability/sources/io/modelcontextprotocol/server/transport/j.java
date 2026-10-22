package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.spec.McpStreamableServerSession;
import java.util.function.Consumer;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4726a;

    public /* synthetic */ j(int i) {
        this.f4726a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4726a) {
            case 0:
                HttpServletStreamableServerTransportProvider.lambda$closeGracefully$3((McpStreamableServerSession) obj);
                break;
            default:
                StdioServerTransportProvider.lambda$notifyClients$0((Throwable) obj);
                break;
        }
    }
}

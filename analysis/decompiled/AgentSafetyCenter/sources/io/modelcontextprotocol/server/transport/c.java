package io.modelcontextprotocol.server.transport;

import io.modelcontextprotocol.spec.McpServerSession;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Function {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ String f6296a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6297b;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return HttpServletSseServerTransportProvider.lambda$notifyClients$2(this.f6296a, this.f6297b, (McpServerSession) obj);
    }
}

package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;
import io.modelcontextprotocol.spec.McpServerSession;
import java.util.function.Function;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2763a;

    public /* synthetic */ p(int i) {
        this.f2763a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f2763a) {
            case 0:
                return ServerTransportProvider.ServerSessionTransport.lambda$startOutboundProcessing$8(obj);
            case 1:
                return ((McpServerSession) obj).closeGracefully();
            default:
                return AndroidClientTransport.lambda$handleIncomingMessages$2((Context) obj);
        }
    }
}

package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;
import io.modelcontextprotocol.spec.McpServerSession;
import java.util.function.Function;
import reactor.util.context.Context;

/* loaded from: classes3.dex */
public final /* synthetic */ class o implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3845a;

    public /* synthetic */ o(int i) {
        this.f3845a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3845a) {
            case 0:
                return ServerTransportProvider.ServerSessionTransport.lambda$startOutboundProcessing$8(obj);
            case 1:
                return ((McpServerSession) obj).closeGracefully();
            default:
                return AndroidClientTransport.lambda$handleIncomingMessages$2((Context) obj);
        }
    }
}

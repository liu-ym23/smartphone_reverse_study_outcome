package com.stepos.mcp.sdk.java.transport;

import com.stepos.mcp.sdk.java.transport.ServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;
import reactor.core.publisher.Flux;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2759a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ ServerTransportProvider.ServerSessionTransport f2760b;

    public /* synthetic */ n(int i) {
        this.f2759a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f2759a;
        ServerTransportProvider.ServerSessionTransport serverSessionTransport = this.f2760b;
        switch (i) {
            case 0:
                return serverSessionTransport.lambda$handleIncomingMessages$2((McpSchema.JSONRPCMessage) obj);
            default:
                return serverSessionTransport.lambda$startOutboundProcessing$9((Flux) obj);
        }
    }
}

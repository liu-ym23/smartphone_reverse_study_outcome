package com.stepos.mcp.sdk.java.transport;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;
import reactor.core.publisher.Flux;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2747a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2748b;

    public /* synthetic */ g(int i) {
        this.f2747a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f2747a;
        Object obj2 = this.f2748b;
        switch (i) {
            case 0:
                return ((AndroidClientTransport) obj2).lambda$startOutboundProcessing$6((Flux) obj);
            default:
                return AndroidClientTransport.lambda$handleIncomingMessages$3((Function) obj2, (McpSchema.JSONRPCMessage) obj);
        }
    }
}

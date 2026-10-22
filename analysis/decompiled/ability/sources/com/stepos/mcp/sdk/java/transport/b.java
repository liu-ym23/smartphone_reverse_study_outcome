package com.stepos.mcp.sdk.java.transport;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpServerSession;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3833a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f3833a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f3833a) {
            case 0:
                return AIDLServerTransportProvider.lambda$notifyClients$1((String) this.b, this.c, (McpServerSession) obj);
            default:
                return ((AndroidClientTransport) this.b).lambda$handleIncomingMessages$3((Function) this.c, (McpSchema.JSONRPCMessage) obj);
        }
    }
}

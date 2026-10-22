package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* renamed from: io.modelcontextprotocol.client.transport.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1576d implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4661a;
    public final /* synthetic */ Function b;

    public /* synthetic */ C1576d(int i, Function function) {
        this.f4661a = i;
        this.b = function;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4661a;
        Function function = this.b;
        McpSchema.JSONRPCMessage jSONRPCMessage = (McpSchema.JSONRPCMessage) obj;
        switch (i) {
            case 0:
                return HttpClientSseClientTransport.lambda$connect$6(function, jSONRPCMessage);
            default:
                return StdioClientTransport.lambda$handleIncomingMessages$4(function, jSONRPCMessage);
        }
    }
}

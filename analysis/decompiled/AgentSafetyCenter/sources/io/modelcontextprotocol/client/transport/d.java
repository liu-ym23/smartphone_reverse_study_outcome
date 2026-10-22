package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6166a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Function f6167b;

    public /* synthetic */ d(int i) {
        this.f6166a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6166a;
        Function function = this.f6167b;
        McpSchema.JSONRPCMessage jSONRPCMessage = (McpSchema.JSONRPCMessage) obj;
        switch (i) {
            case 0:
                return HttpClientSseClientTransport.lambda$connect$6(function, jSONRPCMessage);
            default:
                return StdioClientTransport.lambda$handleIncomingMessages$4(function, jSONRPCMessage);
        }
    }
}

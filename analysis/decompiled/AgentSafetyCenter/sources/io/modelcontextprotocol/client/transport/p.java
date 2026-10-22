package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransportStream;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6200a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ HttpClientStreamableHttpTransport f6201b;

    public /* synthetic */ p(int i) {
        this.f6200a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f6200a;
        HttpClientStreamableHttpTransport httpClientStreamableHttpTransport = this.f6201b;
        switch (i) {
            case 0:
                return httpClientStreamableHttpTransport.lambda$createTransportSession$2((String) obj);
            case 1:
                return httpClientStreamableHttpTransport.lambda$reconnect$14((McpSchema.JSONRPCMessage) obj);
            case 2:
                return httpClientStreamableHttpTransport.reconnect((McpTransportStream) obj);
            default:
                return httpClientStreamableHttpTransport.lambda$sendMessage$29((McpSchema.JSONRPCMessage) obj);
        }
    }
}

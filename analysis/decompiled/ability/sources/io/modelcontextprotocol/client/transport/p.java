package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransportStream;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class p implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4672a;
    public final /* synthetic */ HttpClientStreamableHttpTransport b;

    public /* synthetic */ p(HttpClientStreamableHttpTransport httpClientStreamableHttpTransport, int i) {
        this.f4672a = i;
        this.b = httpClientStreamableHttpTransport;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f4672a;
        HttpClientStreamableHttpTransport httpClientStreamableHttpTransport = this.b;
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

package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransportStream;
import java.net.URI;
import java.util.function.Function;
import reactor.core.publisher.MonoSink;
import reactor.util.context.ContextView;

/* renamed from: io.modelcontextprotocol.client.transport.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1575c implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4660a;
    public final /* synthetic */ McpClientTransport b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C1575c(McpClientTransport mcpClientTransport, Object obj, int i) {
        this.f4660a = i;
        this.b = mcpClientTransport;
        this.c = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4660a) {
            case 0:
                return ((HttpClientSseClientTransport) this.b).lambda$connect$5((MonoSink) this.c, (ResponseSubscribers.SseResponseEvent) obj);
            case 1:
                return ((HttpClientSseClientTransport) this.b).lambda$sendMessage$14((McpSchema.JSONRPCMessage) this.c, (String) obj);
            case 2:
                return ((HttpClientSseClientTransport) this.b).lambda$sendMessage$12((String) this.c, (String) obj);
            case 3:
                return ((HttpClientSseClientTransport) this.b).lambda$connect$0((URI) this.c, (ContextView) obj);
            case 4:
                return ((HttpClientStreamableHttpTransport) this.b).lambda$connect$1((Function) this.c, (ContextView) obj);
            default:
                return ((HttpClientStreamableHttpTransport) this.b).lambda$reconnect$19((McpTransportStream) this.c, (ContextView) obj);
        }
    }
}

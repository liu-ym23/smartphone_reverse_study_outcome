package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpTransportSession;
import io.modelcontextprotocol.spec.McpTransportStream;
import java.net.URI;
import java.util.function.Function;
import reactor.core.publisher.MonoSink;
import reactor.util.context.ContextView;

/* loaded from: classes2.dex */
public final /* synthetic */ class r implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4673a;
    public final /* synthetic */ McpClientTransport b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ r(McpClientTransport mcpClientTransport, Object obj, Object obj2, int i) {
        this.f4673a = i;
        this.b = mcpClientTransport;
        this.c = obj;
        this.d = obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4673a) {
            case 0:
                return ((HttpClientStreamableHttpTransport) this.b).lambda$sendMessage$27((MonoSink) this.c, (ResponseSubscribers.ResponseEvent) this.d, (ResponseSubscribers.SseEvent) obj);
            case 1:
                return ((HttpClientStreamableHttpTransport) this.b).lambda$reconnect$13((McpTransportStream) this.c, (McpTransportSession) this.d, (ResponseSubscribers.SseResponseEvent) obj);
            case 2:
                return ((HttpClientSseClientTransport) this.b).lambda$sendHttpPost$16((URI) this.c, (String) this.d, (ContextView) obj);
            default:
                return ((HttpClientStreamableHttpTransport) this.b).lambda$createDelete$4((URI) this.c, (String) this.d, (ContextView) obj);
        }
    }
}

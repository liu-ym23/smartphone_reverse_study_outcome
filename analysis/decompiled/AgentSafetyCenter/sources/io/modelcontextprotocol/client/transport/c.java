package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransportStream;
import java.net.URI;
import java.util.function.Function;
import reactor.core.publisher.MonoSink;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6161a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpClientTransport f6162b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6163c;

    public /* synthetic */ c(int i) {
        this.f6161a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6161a) {
            case 0:
                return ((HttpClientSseClientTransport) this.f6162b).lambda$connect$5((MonoSink) this.f6163c, (ResponseSubscribers.SseResponseEvent) obj);
            case 1:
                return ((HttpClientSseClientTransport) this.f6162b).lambda$sendMessage$14((McpSchema.JSONRPCMessage) this.f6163c, (String) obj);
            case 2:
                return ((HttpClientSseClientTransport) this.f6162b).lambda$sendMessage$12((String) this.f6163c, (String) obj);
            case 3:
                return ((HttpClientSseClientTransport) this.f6162b).lambda$connect$0((URI) this.f6163c, (ContextView) obj);
            case 4:
                return ((HttpClientStreamableHttpTransport) this.f6162b).lambda$connect$1((Function) this.f6163c, (ContextView) obj);
            default:
                return ((HttpClientStreamableHttpTransport) this.f6162b).lambda$reconnect$19((McpTransportStream) this.f6163c, (ContextView) obj);
        }
    }
}

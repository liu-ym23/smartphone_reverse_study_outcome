package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransportSession;
import io.modelcontextprotocol.spec.McpTransportStream;
import java.net.URI;
import java.util.function.Function;
import reactor.core.publisher.MonoSink;
import reactor.util.context.ContextView;

/* loaded from: classes2.dex */
public final /* synthetic */ class A implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4648a;
    public final /* synthetic */ HttpClientStreamableHttpTransport b;
    public final /* synthetic */ McpTransportSession c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ A(HttpClientStreamableHttpTransport httpClientStreamableHttpTransport, McpTransportSession mcpTransportSession, Object obj, Object obj2, int i) {
        this.f4648a = i;
        this.b = httpClientStreamableHttpTransport;
        this.c = mcpTransportSession;
        this.d = obj;
        this.e = obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4648a) {
            case 0:
                return this.b.lambda$sendMessage$28(this.c, (MonoSink) this.d, (McpSchema.JSONRPCMessage) this.e, (ResponseSubscribers.ResponseEvent) obj);
            case 1:
                return this.b.lambda$reconnect$8(this.c, (McpTransportStream) this.d, (URI) this.e, (ContextView) obj);
            default:
                return this.b.lambda$sendMessage$21(this.c, (URI) this.d, (String) this.e, (ContextView) obj);
        }
    }
}

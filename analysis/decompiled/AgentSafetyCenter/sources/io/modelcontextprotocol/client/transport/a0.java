package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpTransportSession;
import io.modelcontextprotocol.spec.McpTransportStream;
import java.net.URI;
import java.util.function.Function;
import reactor.core.publisher.MonoSink;
import reactor.util.context.ContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a0 implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6152a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ HttpClientStreamableHttpTransport f6153b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ McpTransportSession f6154c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f6155d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f6156e;

    public /* synthetic */ a0(int i) {
        this.f6152a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6152a) {
            case 0:
                return this.f6153b.lambda$sendMessage$28(this.f6154c, (MonoSink) this.f6155d, (McpSchema.JSONRPCMessage) this.f6156e, (ResponseSubscribers.ResponseEvent) obj);
            case 1:
                return this.f6153b.lambda$reconnect$8(this.f6154c, (McpTransportStream) this.f6155d, (URI) this.f6156e, (ContextView) obj);
            default:
                return this.f6153b.lambda$sendMessage$21(this.f6154c, (URI) this.f6155d, (String) this.f6156e, (ContextView) obj);
        }
    }
}

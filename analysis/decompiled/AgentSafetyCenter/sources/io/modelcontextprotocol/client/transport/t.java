package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpTransportSession;
import io.modelcontextprotocol.spec.McpTransportStream;
import java.net.http.HttpRequest;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements Function {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ HttpClientStreamableHttpTransport f6207a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ McpTransportStream f6208b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ McpTransportSession f6209c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ AtomicReference f6210d;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f6207a.lambda$reconnect$18(this.f6208b, this.f6209c, this.f6210d, (HttpRequest.Builder) obj);
    }
}

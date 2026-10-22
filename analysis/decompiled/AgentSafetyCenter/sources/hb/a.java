package hb;

import io.modelcontextprotocol.client.transport.customizer.DelegatingMcpAsyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.common.McpTransportContext;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ McpAsyncHttpClientRequestCustomizer f5433a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ String f5434b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ URI f5435c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ String f5436d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ McpTransportContext f5437e;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return DelegatingMcpAsyncHttpClientRequestCustomizer.lambda$customize$0(this.f5433a, this.f5434b, this.f5435c, this.f5436d, this.f5437e, (HttpRequest.Builder) obj);
    }
}

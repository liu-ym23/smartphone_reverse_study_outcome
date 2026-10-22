package io.modelcontextprotocol.client.transport.customizer;

import hb.a;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.util.Assert;
import java.lang.invoke.VarHandle;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;
import qd.c;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DelegatingMcpAsyncHttpClientRequestCustomizer implements McpAsyncHttpClientRequestCustomizer {
    private final List<McpAsyncHttpClientRequestCustomizer> customizers;

    public DelegatingMcpAsyncHttpClientRequestCustomizer(List<McpAsyncHttpClientRequestCustomizer> list) {
        Assert.notNull(list, "Customizers must not be null");
        this.customizers = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mono lambda$customize$0(McpAsyncHttpClientRequestCustomizer mcpAsyncHttpClientRequestCustomizer, String str, URI uri, String str2, McpTransportContext mcpTransportContext, HttpRequest.Builder builder) {
        return Mono.from(mcpAsyncHttpClientRequestCustomizer.customize(builder, str, uri, str2, mcpTransportContext));
    }

    @Override // io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer
    public c customize(HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
        Mono monoJust = Mono.just(builder);
        for (McpAsyncHttpClientRequestCustomizer mcpAsyncHttpClientRequestCustomizer : this.customizers) {
            a aVar = new a();
            aVar.f5433a = mcpAsyncHttpClientRequestCustomizer;
            aVar.f5434b = str;
            aVar.f5435c = uri;
            aVar.f5436d = str2;
            aVar.f5437e = mcpTransportContext;
            VarHandle.storeStoreFence();
            monoJust = monoJust.flatMap(aVar);
        }
        return monoJust;
    }
}

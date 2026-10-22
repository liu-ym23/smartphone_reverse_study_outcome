package io.modelcontextprotocol.client.transport.customizer;

import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.util.Assert;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.function.Function;
import qc.b;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public class DelegatingMcpAsyncHttpClientRequestCustomizer implements McpAsyncHttpClientRequestCustomizer {
    private final List<McpAsyncHttpClientRequestCustomizer> customizers;

    public DelegatingMcpAsyncHttpClientRequestCustomizer(List<McpAsyncHttpClientRequestCustomizer> list) {
        Assert.notNull(list, "Customizers must not be null");
        this.customizers = list;
    }

    @Override // io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer
    public b<HttpRequest.Builder> customize(HttpRequest.Builder builder, final String str, final URI uri, final String str2, final McpTransportContext mcpTransportContext) {
        Mono monoJust = Mono.just(builder);
        for (final McpAsyncHttpClientRequestCustomizer mcpAsyncHttpClientRequestCustomizer : this.customizers) {
            monoJust = monoJust.flatMap(new Function() { // from class: t8.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Mono.from(mcpAsyncHttpClientRequestCustomizer.customize((HttpRequest.Builder) obj, str, uri, str2, mcpTransportContext));
                }
            });
        }
        return monoJust;
    }
}

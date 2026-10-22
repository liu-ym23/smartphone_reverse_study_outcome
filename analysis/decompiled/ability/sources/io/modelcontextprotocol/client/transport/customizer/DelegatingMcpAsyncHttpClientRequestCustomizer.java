package io.modelcontextprotocol.client.transport.customizer;

import Z9.c;
import io.modelcontextprotocol.client.transport.customizer.DelegatingMcpAsyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.util.Assert;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.function.Function;
import reactor.core.publisher.Mono;

/* loaded from: classes2.dex */
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
    public c customize(HttpRequest.Builder builder, final String str, final URI uri, final String str2, final McpTransportContext mcpTransportContext) {
        Mono monoJust = Mono.just(builder);
        for (final McpAsyncHttpClientRequestCustomizer mcpAsyncHttpClientRequestCustomizer : this.customizers) {
            monoJust = monoJust.flatMap(new Function() { // from class: A7.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return DelegatingMcpAsyncHttpClientRequestCustomizer.lambda$customize$0(mcpAsyncHttpClientRequestCustomizer, str, uri, str2, mcpTransportContext, (HttpRequest.Builder) obj);
                }
            });
        }
        return monoJust;
    }
}

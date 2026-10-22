package io.modelcontextprotocol.client.transport.customizer;

import io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.common.McpTransportContext;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.function.Supplier;
import qc.b;
import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
public interface McpAsyncHttpClientRequestCustomizer {
    public static final McpAsyncHttpClientRequestCustomizer NOOP = new Noop();

    public static class Noop implements McpAsyncHttpClientRequestCustomizer {
        @Override // io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer
        public b<HttpRequest.Builder> customize(HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
            return Mono.just(builder);
        }
    }

    static /* synthetic */ HttpRequest.Builder b(McpSyncHttpClientRequestCustomizer mcpSyncHttpClientRequestCustomizer, HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
        mcpSyncHttpClientRequestCustomizer.customize(builder, str, uri, str2, mcpTransportContext);
        return builder;
    }

    static McpAsyncHttpClientRequestCustomizer fromSync(final McpSyncHttpClientRequestCustomizer mcpSyncHttpClientRequestCustomizer) {
        return new McpAsyncHttpClientRequestCustomizer() { // from class: t8.c
            @Override // io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer
            public final qc.b customize(HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
                return Mono.fromSupplier(new Supplier() { // from class: t8.d
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return McpAsyncHttpClientRequestCustomizer.b(mcpSyncHttpClientRequestCustomizer, builder, str, uri, str2, mcpTransportContext);
                    }
                });
            }
        };
    }

    b<HttpRequest.Builder> customize(HttpRequest.Builder builder, String str, URI uri, @Nullable String str2, McpTransportContext mcpTransportContext);
}

package io.modelcontextprotocol.client.transport.customizer;

import Z9.c;
import io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.common.McpTransportContext;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;

/* loaded from: classes2.dex */
public interface McpAsyncHttpClientRequestCustomizer {
    public static final McpAsyncHttpClientRequestCustomizer NOOP = new Noop();

    public static class Noop implements McpAsyncHttpClientRequestCustomizer {
        @Override // io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer
        public c customize(HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
            return Mono.just(builder);
        }
    }

    static McpAsyncHttpClientRequestCustomizer fromSync(final McpSyncHttpClientRequestCustomizer mcpSyncHttpClientRequestCustomizer) {
        return new McpAsyncHttpClientRequestCustomizer() { // from class: A7.c
            @Override // io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer
            public final Z9.c customize(HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
                return McpAsyncHttpClientRequestCustomizer.lambda$fromSync$1(mcpSyncHttpClientRequestCustomizer, builder, str, uri, str2, mcpTransportContext);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ HttpRequest.Builder lambda$fromSync$0(McpSyncHttpClientRequestCustomizer mcpSyncHttpClientRequestCustomizer, HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
        mcpSyncHttpClientRequestCustomizer.customize(builder, str, uri, str2, mcpTransportContext);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ c lambda$fromSync$1(final McpSyncHttpClientRequestCustomizer mcpSyncHttpClientRequestCustomizer, final HttpRequest.Builder builder, final String str, final URI uri, final String str2, final McpTransportContext mcpTransportContext) {
        return Mono.fromSupplier(new Supplier() { // from class: A7.d
            @Override // java.util.function.Supplier
            public final Object get() {
                return McpAsyncHttpClientRequestCustomizer.lambda$fromSync$0(mcpSyncHttpClientRequestCustomizer, builder, str, uri, str2, mcpTransportContext);
            }
        });
    }

    c customize(HttpRequest.Builder builder, String str, URI uri, @Nullable String str2, McpTransportContext mcpTransportContext);
}

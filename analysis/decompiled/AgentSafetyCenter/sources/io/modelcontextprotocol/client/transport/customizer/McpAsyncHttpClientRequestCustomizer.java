package io.modelcontextprotocol.client.transport.customizer;

import hb.d;
import io.modelcontextprotocol.common.McpTransportContext;
import java.lang.invoke.VarHandle;
import java.net.URI;
import java.net.http.HttpRequest;
import qd.c;
import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpAsyncHttpClientRequestCustomizer {
    public static final McpAsyncHttpClientRequestCustomizer NOOP = new Noop();

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Noop implements McpAsyncHttpClientRequestCustomizer {
        @Override // io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer
        public c customize(HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
            return Mono.just(builder);
        }
    }

    static McpAsyncHttpClientRequestCustomizer fromSync(McpSyncHttpClientRequestCustomizer mcpSyncHttpClientRequestCustomizer) {
        hb.c cVar = new hb.c();
        cVar.f5442a = mcpSyncHttpClientRequestCustomizer;
        VarHandle.storeStoreFence();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ HttpRequest.Builder lambda$fromSync$0(McpSyncHttpClientRequestCustomizer mcpSyncHttpClientRequestCustomizer, HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
        mcpSyncHttpClientRequestCustomizer.customize(builder, str, uri, str2, mcpTransportContext);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ c lambda$fromSync$1(McpSyncHttpClientRequestCustomizer mcpSyncHttpClientRequestCustomizer, HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
        d dVar = new d();
        dVar.f5443c = mcpSyncHttpClientRequestCustomizer;
        dVar.f5444f = builder;
        dVar.f5445g = str;
        dVar.f5446h = uri;
        dVar.i = str2;
        dVar.f5447j = mcpTransportContext;
        VarHandle.storeStoreFence();
        return Mono.fromSupplier(dVar);
    }

    c customize(HttpRequest.Builder builder, String str, URI uri, @Nullable String str2, McpTransportContext mcpTransportContext);
}

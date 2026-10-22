package io.modelcontextprotocol.client.transport.customizer;

import io.modelcontextprotocol.common.McpTransportContext;
import java.net.URI;
import java.net.http.HttpRequest;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface McpSyncHttpClientRequestCustomizer {
    void customize(HttpRequest.Builder builder, String str, URI uri, @Nullable String str2, McpTransportContext mcpTransportContext);
}

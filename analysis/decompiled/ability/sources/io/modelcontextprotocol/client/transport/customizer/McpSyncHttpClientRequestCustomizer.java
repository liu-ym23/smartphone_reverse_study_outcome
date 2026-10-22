package io.modelcontextprotocol.client.transport.customizer;

import io.modelcontextprotocol.common.McpTransportContext;
import java.net.URI;
import java.net.http.HttpRequest;
import reactor.util.annotation.Nullable;

/* loaded from: classes2.dex */
public interface McpSyncHttpClientRequestCustomizer {
    void customize(HttpRequest.Builder builder, String str, URI uri, @Nullable String str2, McpTransportContext mcpTransportContext);
}

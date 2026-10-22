package io.modelcontextprotocol.client.transport.customizer;

import io.modelcontextprotocol.client.transport.customizer.McpSyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.util.Assert;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class DelegatingMcpSyncHttpClientRequestCustomizer implements McpSyncHttpClientRequestCustomizer {
    private final List<McpSyncHttpClientRequestCustomizer> delegates;

    public DelegatingMcpSyncHttpClientRequestCustomizer(List<McpSyncHttpClientRequestCustomizer> list) {
        Assert.notNull(list, "Customizers must not be null");
        this.delegates = list;
    }

    @Override // io.modelcontextprotocol.client.transport.customizer.McpSyncHttpClientRequestCustomizer
    public void customize(final HttpRequest.Builder builder, final String str, final URI uri, final String str2, final McpTransportContext mcpTransportContext) {
        this.delegates.forEach(new Consumer() { // from class: A7.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((McpSyncHttpClientRequestCustomizer) obj).customize(builder, str, uri, str2, mcpTransportContext);
            }
        });
    }
}

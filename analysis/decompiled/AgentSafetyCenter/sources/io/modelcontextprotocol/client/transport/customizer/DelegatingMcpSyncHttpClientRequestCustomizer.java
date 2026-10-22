package io.modelcontextprotocol.client.transport.customizer;

import hb.b;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.util.Assert;
import java.lang.invoke.VarHandle;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DelegatingMcpSyncHttpClientRequestCustomizer implements McpSyncHttpClientRequestCustomizer {
    private final List<McpSyncHttpClientRequestCustomizer> delegates;

    public DelegatingMcpSyncHttpClientRequestCustomizer(List<McpSyncHttpClientRequestCustomizer> list) {
        Assert.notNull(list, "Customizers must not be null");
        this.delegates = list;
    }

    @Override // io.modelcontextprotocol.client.transport.customizer.McpSyncHttpClientRequestCustomizer
    public void customize(HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
        List<McpSyncHttpClientRequestCustomizer> list = this.delegates;
        b bVar = new b();
        bVar.f5438c = builder;
        bVar.f5439f = str;
        bVar.f5440g = uri;
        bVar.f5441h = str2;
        bVar.i = mcpTransportContext;
        VarHandle.storeStoreFence();
        list.forEach(bVar);
    }
}

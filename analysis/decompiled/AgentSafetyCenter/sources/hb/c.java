package hb;

import io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.client.transport.customizer.McpSyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.common.McpTransportContext;
import java.net.URI;
import java.net.http.HttpRequest;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements McpAsyncHttpClientRequestCustomizer {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ McpSyncHttpClientRequestCustomizer f5442a;

    @Override // io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer
    public final qd.c customize(HttpRequest.Builder builder, String str, URI uri, String str2, McpTransportContext mcpTransportContext) {
        return McpAsyncHttpClientRequestCustomizer.lambda$fromSync$1(this.f5442a, builder, str, uri, str2, mcpTransportContext);
    }
}

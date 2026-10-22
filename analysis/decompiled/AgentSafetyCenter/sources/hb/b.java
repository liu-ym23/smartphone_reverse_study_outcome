package hb;

import io.modelcontextprotocol.client.transport.customizer.McpSyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.common.McpTransportContext;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Consumer {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ HttpRequest.Builder f5438c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f5439f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ URI f5440g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ String f5441h;
    public /* synthetic */ McpTransportContext i;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((McpSyncHttpClientRequestCustomizer) obj).customize(this.f5438c, this.f5439f, this.f5440g, this.f5441h, this.i);
    }
}

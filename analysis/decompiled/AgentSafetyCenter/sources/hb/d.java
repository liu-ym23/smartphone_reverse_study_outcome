package hb;

import io.modelcontextprotocol.client.transport.customizer.McpAsyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.client.transport.customizer.McpSyncHttpClientRequestCustomizer;
import io.modelcontextprotocol.common.McpTransportContext;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ McpSyncHttpClientRequestCustomizer f5443c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ HttpRequest.Builder f5444f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f5445g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ URI f5446h;
    public /* synthetic */ String i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ McpTransportContext f5447j;

    @Override // java.util.function.Supplier
    public final Object get() {
        return McpAsyncHttpClientRequestCustomizer.lambda$fromSync$0(this.f5443c, this.f5444f, this.f5445g, this.f5446h, this.i, this.f5447j);
    }
}

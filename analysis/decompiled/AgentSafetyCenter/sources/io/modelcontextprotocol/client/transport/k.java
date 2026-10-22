package io.modelcontextprotocol.client.transport;

import java.net.http.HttpRequest;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Function {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ HttpClientSseClientTransport f6190a;

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f6190a.lambda$sendHttpPost$17((HttpRequest.Builder) obj);
    }
}

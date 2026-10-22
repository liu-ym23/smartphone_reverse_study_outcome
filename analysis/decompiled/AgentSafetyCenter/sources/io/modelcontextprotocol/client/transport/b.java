package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import io.modelcontextprotocol.spec.McpTransportSession;
import java.util.Map;
import java.util.concurrent.CompletionException;
import java.util.function.Function;
import reactor.util.context.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6157a;

    public /* synthetic */ b(int i) {
        this.f6157a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6157a) {
            case 0:
                return HttpClientSseClientTransport.lambda$connect$4((ResponseSubscribers.ResponseEvent) obj);
            case 1:
                return HttpClientStreamableHttpTransport.lambda$reconnect$12((ResponseSubscribers.ResponseEvent) obj);
            case 2:
                return ((CompletionException) obj).getCause();
            case 3:
                return ((CompletionException) obj).getCause();
            case 4:
                return ((McpTransportSession) obj).sessionId();
            case 5:
                return ((CompletionException) obj).getCause();
            case 6:
                return (String) ((Map.Entry) obj).getKey();
            case 7:
                return (String) ((Map.Entry) obj).getValue();
            default:
                return StdioClientTransport.lambda$handleIncomingMessages$3((Context) obj);
        }
    }
}

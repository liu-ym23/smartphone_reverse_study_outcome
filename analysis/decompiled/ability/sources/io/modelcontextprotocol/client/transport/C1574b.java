package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import io.modelcontextprotocol.spec.McpTransportSession;
import java.util.Map;
import java.util.concurrent.CompletionException;
import java.util.function.Function;
import reactor.util.context.Context;

/* renamed from: io.modelcontextprotocol.client.transport.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1574b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4659a;

    public /* synthetic */ C1574b(int i) {
        this.f4659a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f4659a) {
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
                return (String) ((Map.Entry) obj).getValue();
            default:
                return StdioClientTransport.lambda$handleIncomingMessages$3((Context) obj);
        }
    }
}

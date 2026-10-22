package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpTransportSession;
import java.util.Map;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class y implements Predicate {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6217c;

    public /* synthetic */ y(int i) {
        this.f6217c = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f6217c) {
            case 0:
                return HttpClientStreamableHttpTransport.lambda$createClosedSession$3((McpTransportSession) obj);
            case 1:
                return HttpClientStreamableHttpTransport.lambda$connect$0((Throwable) obj);
            case 2:
                return ServerParameters.lambda$getDefaultEnvironment$0((Map.Entry) obj);
            case 3:
                return ServerParameters.lambda$getDefaultEnvironment$1((Map.Entry) obj);
            default:
                return ServerParameters.lambda$getDefaultEnvironment$2((Map.Entry) obj);
        }
    }
}
